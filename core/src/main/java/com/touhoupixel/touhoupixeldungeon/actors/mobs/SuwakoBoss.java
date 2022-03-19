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

import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.items.quest.Ice;
import com.touhoupixel.touhoupixeldungeon.levels.Terrain;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.SuwakoSprite;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class SuwakoBoss extends Mob {

	{
		spriteClass = SuwakoSprite.class;

		HP = HT = Dungeon.isChallenged(Challenges.CHAMPION_ENEMIES) ? 180 : 120;

		defenseSkill = 15;

		EXP = 0;

		maxLvl = 99;

		properties.add(Property.BOSS);
		properties.add(Property.GOD);
		properties.add(Property.COLD);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(13, 16);
	}

	@Override
	public int attackSkill(Char target) {
		return 15;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );
		Statistics.ymbosskillcount += 1;

		if (Statistics.ymbosskillcount > 2){
			Dungeon.level.unseal();
			GameScene.bossSlain();
		}
	}

	@Override
	public void damage(int dmg, Object src) {
		int waterCells = 0;
		for (int i : PathFinder.NEIGHBOURS9) {
			if (Dungeon.level.map[pos + i] == Terrain.WATER) {
				waterCells++;
			}
		}
		if (waterCells > 0) dmg = Math.round(dmg * (6 - waterCells) / 6f);

		super.damage(dmg, src);
	}
}
