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
import com.touhoupixel.touhoupixeldungeon.items.Gold;
import com.touhoupixel.touhoupixeldungeon.sprites.NazrinSprite;
import com.watabou.utils.Random;

public class Nazrin extends Mob {
	
	{
		spriteClass = NazrinSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 382;
		} else HP = HT = 9;

		if (Dungeon.depth > 50){
			defenseSkill = 51;
		} else defenseSkill = 1;

		if (Dungeon.depth > 50){
			EXP = 52;
		} else EXP = 2;

		if (Dungeon.depth > 50){
			maxLvl = 55;
		} else maxLvl = 5;
		
		loot = Gold.class;
		lootChance = 0.5f;

		properties.add(Property.ANIMAL);
		properties.add(Property.HAPPY);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(32, 36);
		} else return Random.NormalIntRange(2, 3);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 55;
		} else return 5;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}
}
