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

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Degrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfWeakness;
import com.touhoupixel.touhoupixeldungeon.sprites.KaguyaSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.KanakoSprite;
import com.watabou.utils.Random;

public class Kanako extends Mob {

	{
		spriteClass = KanakoSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 478;
		} else HP = HT = 67;

		if (Dungeon.depth > 50){
			defenseSkill = 75;
		} else defenseSkill = 25;

		if (Dungeon.depth > 50){
			EXP = 61;
		} else EXP = 11;

		if (Dungeon.depth > 50){
			maxLvl = 75;
		} else maxLvl = 25;

		loot = new ScrollOfWeakness();
		lootChance = 0.05f;

		properties.add(Property.GOD);
		properties.add(Property.POWERFUL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(47, 50);
		} else return Random.NormalIntRange(12, 17);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 75;
		} else return 25;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(5) == 0) {
				Buff.prolong(enemy, Degrade.class, Degrade.DURATION);
			}
		}
		return damage;
	}
}