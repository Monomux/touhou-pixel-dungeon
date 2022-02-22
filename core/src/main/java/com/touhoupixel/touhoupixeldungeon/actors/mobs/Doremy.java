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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfFlock;
import com.touhoupixel.touhoupixeldungeon.levels.traps.FlockTrap;
import com.touhoupixel.touhoupixeldungeon.sprites.DoremySprite;
import com.watabou.utils.Random;

public class Doremy extends Mob {

	{
		spriteClass = DoremySprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 712;
		} else HP = HT = 154;

		if (Dungeon.depth > 50){
			defenseSkill = 88;
		} else defenseSkill = 38;

		if (Dungeon.depth > 50){
			EXP = 69;
		} else EXP = 19;

		if (Dungeon.depth > 50){
			maxLvl = 90;
		} else maxLvl = 40;

		loot = new StoneOfFlock();
		lootChance = 0.2f;

		properties.add(Property.ANIMAL);
		properties.add(Property.YOKAI);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(58, 64);
		} else return Random.NormalIntRange(34, 41);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 82;
		} else return 40;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(2) == 0) {
				new FlockTrap().set(target).activate();
			}
		}
		return damage;
	}
}
