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

package com.touhoupixel.touhoupixeldungeon.items.weapon.melee;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Levitation;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Paralysis;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vertigo;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfDoublespeed;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;

import java.util.ArrayList;

public class WindgodFan extends MeleeWeapon {

	{
		image = ItemSpriteSheet.WINDGOD_FAN;
		hitSound = Assets.Sounds.HIT;
		hitSoundPitch = 1f;

		tier = 4;
	}

	@Override
	public int max(int lvl) {
		return  3*(tier+1) +    //20 base, down from 25
				lvl*(tier);     //+4 per level, down from +5
	}

	@Override
	public int coldResistFactor( Char owner ) {
		return 0;
	}

	@Override
	public ArrayList<String> actions(Hero hero ) {
		ArrayList<String> actions = super.actions( hero );
		actions.remove(AC_XYZ);
		return actions;
	}

	@Override
	public int damageRoll(Char owner) {
		if (owner instanceof Hero) {
			Hero hero = (Hero) owner;
			Char enemy = hero.enemy();
			if (Dungeon.hero.belongings.weapon() instanceof WindgodFan) {
				Buff.prolong(hero, Levitation.class, Levitation.DURATION);
				Buff.prolong(hero, Doublespeed.class, Doublespeed.DURATION);
			}
			if (Dungeon.hero.heroClass == HeroClass.KOGASAPLAYER && Dungeon.hero.belongings.weapon() instanceof WindgodFan){
				GLog.w( Messages.get(PotionOfDoublespeed.class, "wrath") );
				Buff.prolong( owner, Paralysis.class, Paralysis.DURATION);
				Buff.prolong( owner, Slow.class, Slow.DURATION*10f);
				Buff.prolong( owner, Silence.class, Silence.DURATION*2f);
			}
		}
		return super.damageRoll(owner);
	}
}