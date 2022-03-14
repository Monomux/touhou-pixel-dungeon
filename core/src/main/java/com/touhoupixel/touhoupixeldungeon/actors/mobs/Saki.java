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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Degrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeon.sprites.SakiSprite;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

public class Saki extends Mob {
	
	{
		spriteClass = SakiSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 60;
		} else HP = HT = 20;

		if (Dungeon.depth > 50){
			defenseSkill = 55;
		} else defenseSkill = 5;

		if (Dungeon.depth > 50){
			EXP = 53;
		} else EXP = 3;

		if (Dungeon.depth > 50){
			maxLvl = 60;
		} else maxLvl = 10;

		baseSpeed = 2f;

		properties.add(Property.POWERFUL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(31, 39);
		} else return Random.NormalIntRange(2, 4);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 57;
		} else return 7;
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(2) == 0) {
				Buff.prolong(this, Haste.class, Haste.DURATION);
			}
		}
		return damage;
	}

	@Override
	public void damage(int dmg, Object src) {
		if (dmg >= 5){
			//takes 5/6/7/8/9/10 dmg at 5/7/10/14/19/25 incoming dmg
			dmg = 4 + (int)(Math.sqrt(8*(dmg - 4) + 1) - 1)/2;
		}
		super.damage(dmg, src);
	}
}
