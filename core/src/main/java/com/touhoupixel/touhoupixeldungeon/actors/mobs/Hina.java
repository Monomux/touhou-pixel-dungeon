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
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.touhoupixel.touhoupixeldungeon.levels.traps.CursingTrap;
import com.touhoupixel.touhoupixeldungeon.sprites.HinaSprite;
import com.watabou.utils.Random;

public class Hina extends Mob {
	
	{
		spriteClass = HinaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 891;
		} else HP = HT = 89;

		if (Dungeon.depth > 50){
			defenseSkill = 78;
		} else defenseSkill = 28;

		if (Dungeon.depth > 50){
			EXP = 64;
		} else EXP = 14;

		if (Dungeon.depth > 50){
			maxLvl = 80;
		} else maxLvl = 30;

		flying = true;

		loot = new ScrollOfRemoveCurse();
		lootChance = 0.1f;

		properties.add(Property.FLOAT);
		properties.add(Property.GOD);
		properties.add(Property.PURE);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(41, 47);
		} else return Random.NormalIntRange(24, 27);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 80;
		} else return 30;
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
				new CursingTrap().set(target).activate();
			}
		}
		return damage;
	}
}
