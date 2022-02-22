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
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.sprites.ChenSprite;
import com.watabou.utils.Random;

public class Chen extends Mob {
	
	{
		spriteClass = ChenSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 705;
		} else HP = HT = 150;

		if (Dungeon.depth > 50){
			defenseSkill = 85;
		} else defenseSkill = 35;

		if (Dungeon.depth > 50){
			EXP = 64;
		} else EXP = 14;

		if (Dungeon.depth > 50){
			maxLvl = 80;
		} else maxLvl = 30;

		baseSpeed = 2f;

		loot = Generator.Category.SCROLL;
		lootChance = 0.05f;

		properties.add(Property.ANIMAL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(64, 68);
		} else return Random.NormalIntRange(35, 39);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 80;
		} else return 30;
	}

	@Override
	public float attackDelay() { return super.attackDelay()*0.5f; }
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}
}
