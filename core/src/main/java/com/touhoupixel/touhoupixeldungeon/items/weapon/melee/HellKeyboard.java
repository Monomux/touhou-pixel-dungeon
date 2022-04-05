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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank1;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank2;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank3;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class HellKeyboard extends MeleeWeapon {

	{
		image = ItemSpriteSheet.HELLKEYBOARD;
		hitSound = Assets.Sounds.HIT;
		hitSoundPitch = 1f;

		tier = 6;
	}

	@Override
	public int max(int lvl) {
		return  12*(tier+1) +
				lvl*(tier);
	}

	@Override
	public int fireResistFactor( Char owner ) {
		return 3;
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.remove(AC_XYZ);
		return actions;
	}

	@Override
	public int damageRoll(Char owner) {
		if (owner instanceof Hero) {
			Hero hero = (Hero) owner;
			Char enemy = hero.enemy();
			if (Dungeon.hero.belongings.weapon() instanceof HellKeyboard && hero.buff(ArisastarRank1.class) == null && hero.buff(ArisastarRank2.class) == null && hero.buff(ArisastarRank3.class) == null && (Random.Int(2) == 0)) {
				Buff.prolong(owner, ArisastarRank1.class, ArisastarRank1.DURATION);
			} else if (Dungeon.hero.belongings.weapon() instanceof HellKeyboard && hero.buff(ArisastarRank1.class) != null && hero.buff(ArisastarRank2.class) == null && hero.buff(ArisastarRank3.class) == null && (Random.Int(2) == 0)) {
				Buff.detach(hero, ArisastarRank1.class);
				Buff.prolong(owner, ArisastarRank2.class, ArisastarRank2.DURATION);
			} else if (Dungeon.hero.belongings.weapon() instanceof HellKeyboard && hero.buff(ArisastarRank1.class) == null && hero.buff(ArisastarRank2.class) != null && hero.buff(ArisastarRank3.class) == null && (Random.Int(2) == 0)) {
				Buff.detach(hero, ArisastarRank2.class);
				Buff.prolong(owner, ArisastarRank3.class, ArisastarRank3.DURATION);
			} else if (Dungeon.hero.belongings.weapon() instanceof HellKeyboard && hero.buff(ArisastarRank3.class) != null && (Random.Int(2) == 0)) {
				Buff.prolong(owner, ArisastarRank3.class, ArisastarRank3.DURATION);
			}
		}
		return super.damageRoll(owner);
	}
}