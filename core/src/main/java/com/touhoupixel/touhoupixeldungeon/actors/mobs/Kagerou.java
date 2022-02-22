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
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRage;
import com.touhoupixel.touhoupixeldungeon.levels.traps.AlarmTrap;
import com.touhoupixel.touhoupixeldungeon.sprites.KagerouSprite;
import com.watabou.utils.Random;

public class Kagerou extends Mob {
	
	{
		spriteClass = KagerouSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 517;
		} else HP = HT = 78;

		if (Dungeon.depth > 50){
			defenseSkill = 75;
		} else defenseSkill = 25;

		if (Dungeon.depth > 50){
			EXP = 60;
		} else EXP = 10;

		if (Dungeon.depth > 50){
			maxLvl = 75;
		} else maxLvl = 25;

		loot = new ScrollOfRage();
		lootChance = 0.05f;

		properties.add(Property.ANIMAL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(45, 50);
		} else return Random.NormalIntRange(15, 19);
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

	@Override
	public int attackProc( Char enemy, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(2) == 0) {
				new AlarmTrap().set(target).activate();
			}
		}
		return damage;
	}
}
