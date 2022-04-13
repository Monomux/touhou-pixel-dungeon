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

package com.touhoupixel.touhoupixeldungeon.actors.mobs;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiHeal;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfTorment;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.SannyoSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Sannyo extends Mob {

	{
		spriteClass = SannyoSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 572;
		} else HP = HT = 118;

		if (Dungeon.depth > 50){
			defenseSkill = 88;
		} else defenseSkill = 38;

		if (Dungeon.depth > 50){
			EXP = 70;
		} else EXP = 20;

		if (Dungeon.depth > 50){
			maxLvl = 90;
		} else maxLvl = 40;

		loot = new ScrollOfTorment();
		lootChance = 0.1f;

		properties.add(Property.YOKAI);
		properties.add(Property.HAPPY);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(38, 43);
		} else return Random.NormalIntRange(21, 25);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 82;
		} else return 40;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(2) == 0) {
				if (Dungeon.isChallenged(Challenges.RINGING_BLOOM)) {
					damage = Math.max(damage, hero.HP / 4);
				} else {
					damage = Math.max(damage, hero.HP / 2);
				}
				Buff.prolong(enemy, AntiHeal.class, AntiHeal.DURATION);
				Sample.INSTANCE.play(Assets.Sounds.CURSED);
				CellEmitter.get(pos).burst(ShadowParticle.UP, 5);
				GLog.w(Messages.get(this, "mindcontrol"));

				return damage;
			}
		}
		return damage;
	}
}
