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

package com.touhoupixel.touhoupixeldungeon.items.potions;

import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiHeal;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bleeding;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Drowsy;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Healing;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.HighStress;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vertigo;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;

public class PotionOfHealing extends Potion {

	{
		icon = ItemSpriteSheet.Icons.POTION_HEALING;

		bones = true;
	}

	@Override
	public void apply(Hero hero) {
		identify();
		cure(hero);
		heal(hero);
		Talent.onHealingPotionUsed(hero);
	}

	public static void heal(Char ch) {
		if ( ch.buff(AntiHeal.class) != null ){
			ch.damage(ch.HT/2, ch);
		} else if (((Hero) ch).heroClass == HeroClass.KAGUYAPLAYER){
			Buff.prolong( ch, Silence.class, Silence.DURATION );
		} else if (ch == Dungeon.hero && Dungeon.isChallenged(Challenges.NO_HEALING) && !(Dungeon.hero.heroClass == HeroClass.MURASA)) {
				pharmacophobiaProc(Dungeon.hero);
			} else {
				//starts out healing 30 hp, equalizes with hero health total at level 11
				Buff.affect(ch, Healing.class).setHeal((int) (0.8f * ch.HT + 14), 0.25f, 0);
				if (ch == Dungeon.hero) {
					GLog.p(Messages.get(PotionOfHealing.class, "heal"));
				}
			}
		}

	public static void pharmacophobiaProc(Hero hero) {
		// harms the hero for ~40% of their max HP in poison
		hero.HP = Math.min(hero.HP + 30, hero.HT);
		hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);

	}

	public static void cure(Char ch) {
		Buff.detach(ch, Poison.class);
		Buff.detach(ch, Cripple.class);
		Buff.detach(ch, Weakness.class);
		Buff.detach(ch, Vulnerable.class);
		Buff.detach(ch, Bleeding.class);
		Buff.detach(ch, Blindness.class);
		Buff.detach(ch, Drowsy.class);
		Buff.detach(ch, Slow.class);
		Buff.detach(ch, Vertigo.class);
	}

	@Override
	public int value() {
		return isKnown() ? 30 * quantity : super.value();
	}
}