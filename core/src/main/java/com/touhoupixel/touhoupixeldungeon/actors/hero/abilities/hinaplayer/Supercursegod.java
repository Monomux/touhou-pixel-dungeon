/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.touhoupixel.touhoupixeldungeon.actors.hero.abilities.hinaplayer;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Combo;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Invisibility;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Paralysis;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.actors.hero.abilities.ArmorAbility;
import com.touhoupixel.touhoupixeldungeon.effects.MagicMissile;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.armor.ClassArmor;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.mechanics.ConeAOE;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.ui.HeroIcon;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.Camera;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;
import com.watabou.utils.Random;

public class Supercursegod extends ArmorAbility {

	{
		baseChargeUse = 35f;
	}

	@Override
	public String targetingPrompt() {
		return Messages.get(this, "prompt");
	}

	@Override
	protected void activate(ClassArmor armor, Hero hero, Integer target) {
		if (target == null){
			return;
		}
		if (target == hero.pos){
			GLog.w(Messages.get(this, "self_target"));
			return;
		}
		hero.busy();

		armor.charge -= chargeUse(hero);
		Item.updateQuickslot();

		Ballistica aim = new Ballistica(hero.pos, target, Ballistica.WONT_STOP);

		int maxDist = 5 + hero.pointsInTalent(Talent.EXPANDING_WAVE);
		int dist = Math.min(aim.dist, maxDist);

		ConeAOE cone = new ConeAOE(aim,
				dist,
				60 + 15*hero.pointsInTalent(Talent.EXPANDING_WAVE),
				Ballistica.STOP_SOLID | Ballistica.STOP_TARGET);

		//cast to cells at the tip, rather than all cells, better performance.
		for (Ballistica ray : cone.outerRays){
			((MagicMissile)hero.sprite.parent.recycle( MagicMissile.class )).reset(
					MagicMissile.FORCE_CONE,
					hero.sprite,
					ray.path.get(ray.dist),
					null
			);
		}

		hero.sprite.zap(target);
		Sample.INSTANCE.play(Assets.Sounds.BLAST, 1f, 0.5f);
		Camera.main.shake(2, 0.5f);
		//final zap at 2/3 distance, for timing of the actual effect
		MagicMissile.boltFromChar(hero.sprite.parent,
				MagicMissile.FORCE_CONE,
				hero.sprite,
				cone.coreRay.path.get(dist * 2 / 3),
				new Callback() {
					@Override
					public void call() {

						for (int cell : cone.cells){

							Char ch = Actor.findChar(cell);
							if (ch != null && ch.alignment != hero.alignment){
								int scalingStr = hero.STR()-10;
								int damage = Random.NormalIntRange(5 + scalingStr, 10 + 2*scalingStr);
								damage = Math.round(damage * (1f + 0.2f*hero.pointsInTalent(Talent.SHOCK_FORCE)));
								damage -= ch.drRoll();

								if (hero.pointsInTalent(Talent.STRIKING_WAVE) == 4){
									Buff.affect(hero, Talent.StrikingWaveTracker.class, 0f);
								}

								if (Random.Int(10) < 3*hero.pointsInTalent(Talent.STRIKING_WAVE)){
									damage = hero.attackProc(ch, damage);
									ch.damage(damage, hero);
									if (hero.subClass == HeroSubClass.GLADIATOR){
										Buff.affect( hero, Combo.class ).hit( ch );
									}
								} else {
									ch.damage(damage, hero);
								}
								if (ch.isAlive()){
									if (Random.Int(4) < hero.pointsInTalent(Talent.SHOCK_FORCE)){
										Buff.affect(ch, Paralysis.class, 5f);
									} else {
										Buff.affect(ch, Cripple.class, 5f);
									}
								}

							}
						}

						Invisibility.dispel();
						hero.spendAndNext(Actor.TICK);

					}
				});
	}

	@Override
	public int icon() {
		return HeroIcon.SUPERCURSEGOD;
	}

	@Override
	public Talent[] talents() {
		return new Talent[]{Talent.CURSED_MIGHT, Talent.CURSED_SPEED, Talent.CURSED_EVASION, Talent.HEROIC_ENERGY};
	}
}
