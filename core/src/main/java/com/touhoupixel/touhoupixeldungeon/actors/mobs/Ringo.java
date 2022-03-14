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
import com.touhoupixel.touhoupixeldungeon.items.food.MysteryMeat;
import com.touhoupixel.touhoupixeldungeon.sprites.RingoSprite;
import com.watabou.utils.Random;

public class Ringo extends Mob {

	{
		spriteClass = RingoSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 412;
		} else HP = HT = 15;

		if (Dungeon.depth > 50){
			defenseSkill = 55;
		} else defenseSkill = 5;

		if (Dungeon.depth > 50){
			EXP = 53;
		} else EXP = 3;

		if (Dungeon.depth > 50){
			maxLvl = 60;
		} else maxLvl = 10;

		baseSpeed = 1.5f;

		loot = new MysteryMeat();
		lootChance = 0.167f;

		properties.add(Property.WARP);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(36, 42);
		} else return Random.NormalIntRange(1, 6);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 57;
		} else return 7;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 4);
	}
}
