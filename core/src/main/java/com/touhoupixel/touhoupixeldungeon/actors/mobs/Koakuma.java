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
import com.touhoupixel.touhoupixeldungeon.plants.Sungrass;
import com.touhoupixel.touhoupixeldungeon.sprites.KoakumaSprite;
import com.watabou.utils.Random;

public class Koakuma extends Mob {
	
	{
		spriteClass = KoakumaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 402;
		} else HP = HT = 24;

		if (Dungeon.depth > 50){
			defenseSkill = 58;
		} else defenseSkill = 8;

		if (Dungeon.depth > 50){
			EXP = 54;
		} else EXP = 4;

		if (Dungeon.depth > 50){
			maxLvl = 60;
		} else maxLvl = 10;

		loot = new Sungrass.Seed();
		lootChance = 0.02f;

		properties.add(Property.HAPPY);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(37, 41);
		} else return Random.NormalIntRange(3, 10);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 60;
		} else return 10;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}
}
