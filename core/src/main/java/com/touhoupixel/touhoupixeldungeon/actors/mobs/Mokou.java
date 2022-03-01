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
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfDragonsBreath;
import com.touhoupixel.touhoupixeldungeon.sprites.MokouSprite;
import com.watabou.utils.Random;

public class Mokou extends Mob {

	{
		spriteClass = MokouSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 481;
		} else HP = HT = 71;

		if (Dungeon.depth > 50){
			defenseSkill = 75;
		} else defenseSkill = 25;

		if (Dungeon.depth > 50){
			EXP = 61;
		} else EXP = 11;

		if (Dungeon.depth > 50){
			maxLvl = 75;
		} else maxLvl = 25;

		loot = PotionOfDragonsBreath.class;
		lootChance = 0.1f;

		properties.add(Property.ELIXIR);
		properties.add(Property.FIRE);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(20+Statistics.ankhsUsed*12, 20+Statistics.ankhsUsed*24);
		} else return Random.NormalIntRange(15+Statistics.ankhsUsed*6, 18+Statistics.ankhsUsed*18);
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

}
