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
import com.touhoupixel.touhoupixeldungeon.items.quest.Peach;
import com.touhoupixel.touhoupixeldungeon.levels.Terrain;
import com.touhoupixel.touhoupixeldungeon.sprites.IkuSprite;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class Iku extends Mob {
	
	{
		spriteClass = IkuSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 823;
		} else HP = HT = 191;

		if (Dungeon.depth > 50){
			defenseSkill = 94;
		} else defenseSkill = 44;

		if (Dungeon.depth > 50){
			EXP = 72;
		} else EXP = 22;

		if (Dungeon.depth > 50){
			maxLvl = 95;
		} else maxLvl = 45;

		flying = true;

		loot = new Peach();
		lootChance = 0.04f;

		properties.add(Property.FLOAT);
		properties.add(Property.PURE);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(74, 81);
		} else return Random.NormalIntRange(41, 46);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 91;
		} else return 45;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public void damage(int dmg, Object src) {
		int waterCells = 0;
		for (int i : PathFinder.NEIGHBOURS9) {
			if (Dungeon.level.map[pos + i] == Terrain.CHASM) {
				waterCells++;
			}
		}
		if (waterCells > 0) dmg = Math.round(dmg * (6 - waterCells) / 6f);

		super.damage(dmg, src);
	}
}

