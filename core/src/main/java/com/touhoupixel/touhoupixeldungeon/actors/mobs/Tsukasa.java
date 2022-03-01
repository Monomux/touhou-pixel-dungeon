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
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfYomi;
import com.touhoupixel.touhoupixeldungeon.levels.Terrain;
import com.touhoupixel.touhoupixeldungeon.sprites.TsukasaSprite;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class Tsukasa extends Mob {

	{
		spriteClass = TsukasaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 391;
		} else HP = HT = 32;

		if (Dungeon.depth > 50){
			defenseSkill = 65;
		} else defenseSkill = 15;

		if (Dungeon.depth > 50){
			EXP = 56;
		} else EXP = 6;

		if (Dungeon.depth > 50){
			maxLvl = 65;
		} else maxLvl = 15;

		loot = new PotionOfYomi();
		lootChance = 0.04f;

		properties.add(Property.ANIMAL);
		properties.add(Property.YOKAI);
		properties.add(Property.PURE);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(34, 38);
		} else return Random.NormalIntRange(13, 17);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 65;
		} else return 15;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public void damage(int dmg, Object src) {
		int waterCells = 0;
		for (int i : PathFinder.NEIGHBOURS9) {
			if (Dungeon.level.map[pos + i] == Terrain.DOOR
					|| Dungeon.level.map[pos + i] == Terrain.OPEN_DOOR
					|| Dungeon.level.map[pos + i] == Terrain.LOCKED_DOOR) {
				waterCells++;
			}
		}
		if (waterCells > 0) dmg = Math.round(dmg * (2 - waterCells)*0.25f);

		super.damage(dmg, src);
	}
}
