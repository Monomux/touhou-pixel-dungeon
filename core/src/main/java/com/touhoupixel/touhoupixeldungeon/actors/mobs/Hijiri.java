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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doubleevasion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfDivineInspiration;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfSlowness;
import com.touhoupixel.touhoupixeldungeon.sprites.HijiriSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.KutakaSprite;
import com.watabou.utils.Random;

public class Hijiri extends Mob {
	
	{
		spriteClass = HijiriSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 831;
		} else HP = HT = 170;

		if (Dungeon.depth > 50){
			defenseSkill = 94;
		} else defenseSkill = 44;

		if (Dungeon.depth > 50){
			EXP = 72;
		} else EXP = 22;

		if (Dungeon.depth > 50){
			maxLvl = 95;
		} else maxLvl = 45;

		loot = new PotionOfDivineInspiration();
		lootChance = 0.02f;

		properties.add(Property.POWERFUL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(56, 60);
		} else return Random.NormalIntRange(21, 28);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 97;
		} else return 35;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(3) == 0) {
				Buff.prolong(this, Doubleevasion.class, Doubleevasion.DURATION);
				Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION);
				Buff.prolong(this, Hisou.class, Hisou.DURATION);
				Buff.prolong(enemy, AntiSneakattack.class, AntiSneakattack.DURATION);
			}
		}
		return damage;
	}
}
