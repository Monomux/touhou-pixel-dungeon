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

package com.touhoupixel.touhoupixeldungeon.levels.traps;

import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Suika;

public class TenguDartTrap extends PoisonDartTrap {
	
	{
		canBeHidden = true;
		canBeSearched = false;
	}
	
	@Override
	protected int poisonAmount() {
		if (Dungeon.isChallenged(Challenges.CHAMPION_ENEMIES)){
			return 15; //50 damage total, equal to poison dart traps on floor 10
		} else {
			return 8; //17 damage total
		}
	}
	
	@Override
	protected boolean canTarget(Char ch) {
		return !(ch instanceof Suika);
	}
}
