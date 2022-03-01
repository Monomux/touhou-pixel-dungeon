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
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfMight;
import com.touhoupixel.touhoupixeldungeon.sprites.EikiSprite;
import com.watabou.utils.Random;

public class Eiki extends Mob {

	{
		spriteClass = EikiSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 950;
		} else HP = HT = 250;

		if (Dungeon.depth > 50){
			defenseSkill = 97;
		} else defenseSkill = 47;

		if (Dungeon.depth > 50){
			EXP = 74;
		} else EXP = 24;

		if (Dungeon.depth > 50){
			maxLvl = 99;
		} else maxLvl = 50;

		loot = PotionOfMight.class;
		lootChance = 0.04f;

		properties.add(Property.GOD);
		properties.add(Property.POWERFUL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(Statistics.enemiesSlain/15, Statistics.enemiesSlain/14);
		} else return Random.NormalIntRange(Statistics.enemiesSlain/17, Statistics.enemiesSlain/16);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 99;
		} else return 50;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}
}
