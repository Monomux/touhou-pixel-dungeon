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

import com.touhoupixel.touhoupixeldungeon.Badges;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.sprites.EnemyShopkeeperSprite;
import com.watabou.utils.Random;

public class EnemyShopkeeper extends Mob {

	{
		spriteClass = EnemyShopkeeperSprite.class;

		HP = HT = 999;
		defenseSkill = 0;

		EXP = 1;
		maxLvl = 99;

		flying = true;

		baseSpeed = 3f;

	}

	@Override
	public void die( Object cause ) {
		super.die( cause );

		Statistics.shopkeepersKilled++;
		Badges.validateShopkeepersKilled();
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange (90, 99);
	}

	@Override
	public float attackDelay() { return super.attackDelay()*0.34f; }

	@Override
	public int attackSkill(Char target) {
		return 99;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}
}