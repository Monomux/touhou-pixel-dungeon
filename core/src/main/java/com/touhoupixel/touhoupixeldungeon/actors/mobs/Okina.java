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
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfMetamorphosis;
import com.touhoupixel.touhoupixeldungeon.levels.traps.DistortionTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.SummoningTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.WarpingTrap;
import com.touhoupixel.touhoupixeldungeon.sprites.MikoSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.OkinaSprite;
import com.watabou.utils.Random;

public class Okina extends Mob {
	
	{
		spriteClass = OkinaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 693;
		} else HP = HT = 131;

		if (Dungeon.depth > 50){
			defenseSkill = 90;
		} else defenseSkill = 40;

		if (Dungeon.depth > 50){
			EXP = 70;
		} else EXP = 20;

		if (Dungeon.depth > 50){
			maxLvl = 90;
		} else maxLvl = 40;

		loot = new ScrollOfMetamorphosis();
		lootChance = 0.1f;

		properties.add(Property.GOD);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(41, 46);
		} else return Random.NormalIntRange(20, 28);
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
	public int attackProc( Char enemy, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(3) == 0) {
				new DistortionTrap().set(target).activate();
			}
		}
		return damage;
	}
}
