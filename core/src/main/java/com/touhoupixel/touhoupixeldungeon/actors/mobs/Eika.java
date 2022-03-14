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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiSneakattack;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfShock;
import com.touhoupixel.touhoupixeldungeon.levels.traps.RockfallTrap;
import com.touhoupixel.touhoupixeldungeon.sprites.EikaSprite;
import com.watabou.utils.Random;

public class Eika extends Mob {
	
	{
		spriteClass = EikaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 431;
		} else HP = HT = 41;

		if (Dungeon.depth > 50){
			defenseSkill = 70;
		} else defenseSkill = 20;

		if (Dungeon.depth > 50){
			EXP = 58;
		} else EXP = 8;

		if (Dungeon.depth > 50){
			maxLvl = 70;
		} else maxLvl = 20;

		loot = new StoneOfShock();
		lootChance = 0.2f;

		properties.add(Property.COLD);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(33, 36);
		} else return Random.NormalIntRange(11, 16);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 72;
		} else return 22;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (this.buff(Incompetence.class) == null) {
			if (Dungeon.depth > 50) {
				Buff.prolong(enemy, Blindness.class, Blindness.DURATION);
			}
			if (Random.Int(2) == 0) {
				new RockfallTrap().set(target).activate();
			}
		}
		return damage;
	}
}
