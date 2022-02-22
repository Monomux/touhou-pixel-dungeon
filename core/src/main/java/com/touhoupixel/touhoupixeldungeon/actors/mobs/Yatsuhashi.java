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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Degrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.items.quest.Peach;
import com.touhoupixel.touhoupixeldungeon.sprites.YatsuhashiSprite;
import com.watabou.utils.Random;

public class Yatsuhashi extends Mob {

	{
		spriteClass = YatsuhashiSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 895;
		} else HP = HT = 209;

		if (Dungeon.depth > 50){
			defenseSkill = 97;
		} else defenseSkill = 47;

		if (Dungeon.depth > 50){
			EXP = 74;
		} else EXP = 24;

		if (Dungeon.depth > 50){
			maxLvl = 99;
		} else maxLvl = 50;

		loot = new Peach();
		lootChance = 0.04f;

		properties.add(Property.YOKAI);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(67, 74);
		} else return Random.NormalIntRange(36, 41);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 99;
		} else return 50;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
		if (Random.Int(2) == 0) {
			if (Dungeon.hero.lvl > 50) {
				Buff.prolong(this, Might.class, Might.DURATION);
				Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION);
				Buff.prolong(enemy, Degrade.class, Degrade.DURATION);
				Buff.prolong(enemy, Silence.class, Silence.DURATION / 2f);
			}
		}
			return damage;
		}
		return damage;
	}
}
