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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.quest.Blood;
import com.touhoupixel.touhoupixeldungeon.sprites.YuumaSprite;
import com.watabou.utils.Random;

public class Yuuma extends Mob {

	{
		spriteClass = YuumaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 814;
		} else HP = HT = 221;

		if (Dungeon.depth > 50){
			defenseSkill = 97;
		} else defenseSkill = 47;

		if (Dungeon.depth > 50){
			EXP = 73;
		} else EXP = 23;

		if (Dungeon.depth > 50){
			maxLvl = 99;
		} else maxLvl = 50;

		loot = new Blood();
		lootChance = 0.04f;

		properties.add(Property.YOKAI);
		properties.add(Property.WARP);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(59, 64);
		} else return Random.NormalIntRange(30, 38);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 99;
		} else return 50;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 4);
	}

	@Override
	public int attackProc(Char enemy, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			int reg = Math.min(damage - 4, HT - HP);
			//int reg = Math.min( damage - 4, HT - HP );

			if (reg > 0) {
				HP += reg;
				damage = Math.max(damage, damage);
				Buff.prolong(this, Bless.class, Bless.DURATION);
				Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION);
				sprite.emitter().burst(Speck.factory(Speck.UP), 2);
			}
		}
			return damage;
	}

	@Override
	public void rollToDropLoot() {
		lootChance *= ((7f - Dungeon.LimitedDrops.BAT_HP.count) / 7f);
		super.rollToDropLoot();
	}

	@Override
	protected Item createLoot(){
		Dungeon.LimitedDrops.BAT_HP.count++;
		return super.createLoot();
	}

}
