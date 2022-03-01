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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.items.quest.Blood;
import com.touhoupixel.touhoupixeldungeon.sprites.FlandreSprite;
import com.watabou.utils.Random;

public class Flandre extends Mob {

	{
		spriteClass = FlandreSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 631;
		} else HP = HT = 137;

		if (Dungeon.depth > 50){
			defenseSkill = 85;
		} else defenseSkill = 35;

		if (Dungeon.depth > 50){
			EXP = 67;
		} else EXP = 17;

		if (Dungeon.depth > 50){
			maxLvl = 85;
		} else maxLvl = 35;

		flying = true;

		loot = new Blood();
		lootChance = 0.04f;

		properties.add(Property.FLOAT);
		properties.add(Property.POWERFUL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(22, 27);
		} else return Random.NormalIntRange(16, 18);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 95;
		} else return 35;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			if (hero instanceof Hero) {
				if (hero.HT > 31 && hero.HP > 31) {
				hero.HT -= 30;
				hero.HP -= 30;
			}
		}

			return damage;
		}
		return damage;
	}
}
