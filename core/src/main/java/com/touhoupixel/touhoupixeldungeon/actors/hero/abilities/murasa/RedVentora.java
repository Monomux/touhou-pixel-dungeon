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

package com.touhoupixel.touhoupixeldungeon.actors.hero.abilities.murasa;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Combo;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FlavourBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Invisibility;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.actors.hero.abilities.ArmorAbility;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.items.armor.ClassArmor;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.ui.BuffIndicator;
import com.touhoupixel.touhoupixeldungeon.ui.HeroIcon;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;

public class RedVentora extends ArmorAbility {

	{
		baseChargeUse = 50f;
	}

	@Override
	protected void activate(ClassArmor armor, Hero hero, Integer target) {

		Buff.prolong(hero, EndureTracker.class, 13f).setup(hero);

		Combo combo = hero.buff(Combo.class);
		if (combo != null){
			combo.addTime(3f);
		}
		hero.sprite.operate(hero.pos);

		armor.charge -= chargeUse(hero);
		armor.updateQuickslot();
		Invisibility.dispel();
		hero.spendAndNext(3f);
	}

	public static class EndureTracker extends FlavourBuff {

		public boolean enduring;

		public int damageBonus;
		public int maxDmgTaken;
		public int hitsLeft;

		@Override
		public int icon() {
			return enduring ? BuffIndicator.NONE : BuffIndicator.AMOK;
		}

		@Override
		public float iconFadePercent() {
			return Math.max(0, (10f - visualcooldown()) / 10f);
		}

		@Override
		public String toString() {
			return Messages.get(this, "name");
		}

		@Override
		public String desc() {
			return Messages.get(this, "desc", damageBonus, hitsLeft);
		}

		public void setup(Hero hero){
			enduring = true;
			maxDmgTaken = (int) (hero.HT * Math.pow(0.707f, hero.pointsInTalent(Talent.SHRUG_IT_OFF)));
			damageBonus = 0;
			hitsLeft = 0;
		}

		public int adjustDamageTaken(int damage){
			if (enduring) {
				damageBonus += damage/3;
				return damage/2;
			}
			return damage;
		}

		public int enforceDamagetakenLimit(int damage){
			if (damage >= maxDmgTaken) {
				damage = maxDmgTaken;
				maxDmgTaken = 0;
			} else {
				maxDmgTaken -= damage;
			}
			return damage;
		}

		public void endEnduring(){
			if (!enduring){
				return;
			}

			enduring = false;
			damageBonus *= 1f + 0.15f*Dungeon.hero.pointsInTalent(Talent.SUSTAINED_RETRIBUTION);

			int nearby = 0;
			for (Char ch : Actor.chars()){
				if (ch.alignment == Char.Alignment.ENEMY && Dungeon.level.distance(target.pos, ch.pos) <= 2){
					nearby ++;
				}
			}
			damageBonus *= 1f + (nearby*0.05f*Dungeon.hero.pointsInTalent(Talent.EVEN_THE_ODDS));

			hitsLeft = 1+Dungeon.hero.pointsInTalent(Talent.SUSTAINED_RETRIBUTION);
			damageBonus /= hitsLeft;

			if (damageBonus > 0) {
				target.sprite.centerEmitter().start( Speck.factory( Speck.SCREAM ), 0.3f, 3 );
				Sample.INSTANCE.play(Assets.Sounds.CHALLENGE);
			} else {
				detach();
			}
		}

		public int damageFactor(int damage){
			if (enduring){
				return damage;
			} else {
				int bonusDamage = damageBonus;
				hitsLeft--;

				if (hitsLeft <= 0){
					detach();
				}
				return damage + bonusDamage;
			}
		}

		public static String ENDURING       = "enduring";
		public static String DAMAGE_BONUS   = "damage_bonus";
		public static String MAX_DMG_TAKEN  = "max_dmg_taken";
		public static String HITS_LEFT      = "hits_left";

		@Override
		public void storeInBundle(Bundle bundle) {
			super.storeInBundle(bundle);
			bundle.put(ENDURING, enduring);
			bundle.put(DAMAGE_BONUS, damageBonus);
			bundle.put(MAX_DMG_TAKEN, maxDmgTaken);
			bundle.put(HITS_LEFT, hitsLeft);
		}

		@Override
		public void restoreFromBundle(Bundle bundle) {
			super.restoreFromBundle(bundle);
			enduring = bundle.getBoolean(ENDURING);
			damageBonus = bundle.getInt(DAMAGE_BONUS);
			maxDmgTaken = bundle.getInt(ENDURING);
			hitsLeft = bundle.getInt(HITS_LEFT);
		}
	};

	@Override
	public int icon() {
		return HeroIcon.REDVENTORA;
	}

	@Override
	public Talent[] talents() {
		return new Talent[]{Talent.LIFE_EXTEND, Talent.HUGE_GHOST_TENSITY, Talent.AQUA_INVISIBILITY, Talent.HEROIC_ENERGY};
	}
}
