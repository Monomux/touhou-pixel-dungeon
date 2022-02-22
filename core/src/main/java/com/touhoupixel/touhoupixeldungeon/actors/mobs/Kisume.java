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
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLiquidFlame;
import com.touhoupixel.touhoupixeldungeon.sprites.KisumeSprite;
import com.watabou.utils.Random;

public class Kisume extends Mob {
	
	{
		spriteClass = KisumeSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 324;
		} else HP = HT = 10;

		if (Dungeon.depth > 50){
			defenseSkill = 57;
		} else defenseSkill = 7;

		if (Dungeon.depth > 50){
			EXP = 51;
		} else EXP = 1;

		if (Dungeon.depth > 50){
			maxLvl = 55;
		} else maxLvl = 5;
		
		loot = PotionOfLiquidFlame.class;
		lootChance = 0.13f;

		properties.add(Property.YOKAI);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(27, 34);
		} else return Random.NormalIntRange(1, 5);
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
