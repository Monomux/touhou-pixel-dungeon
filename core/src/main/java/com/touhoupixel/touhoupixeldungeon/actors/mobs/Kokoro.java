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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doubleevasion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MagicImmune;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MoveDetect;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.items.Gold;
import com.touhoupixel.touhoupixeldungeon.sprites.KokoroSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.MomoyoSprite;
import com.watabou.utils.Random;

public class Kokoro extends Mob {

	{
		spriteClass = KokoroSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 693;
		} else HP = HT = 141;

		if (Dungeon.depth > 50){
			defenseSkill = 90;
		} else defenseSkill = 40;

		if (Dungeon.depth > 50){
			EXP = 69;
		} else EXP = 19;

		if (Dungeon.depth > 50){
			maxLvl = 90;
		} else maxLvl = 40;

		loot = Gold.class;
		lootChance = 0.4f;

		properties.add(Property.YOKAI);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(56, 59);
		} else return Random.NormalIntRange(38, 41);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 92;
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
			if (hero.buff(Doublespeed.class) != null) {
				Buff.prolong(this, Doublespeed.class, Doublespeed.DURATION);
			}
			if (hero.buff(Triplespeed.class) != null) {
				Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION);
			}
			if (hero.buff(Might.class) != null) {
				Buff.prolong(this, Might.class, Might.DURATION);
			}
			if (hero.buff(Hisou.class) != null) {
				Buff.prolong(this, Hisou.class, Hisou.DURATION);
			}
			if (hero.buff(Haste.class) != null) {
				Buff.prolong(this, Haste.class, Haste.DURATION);
			}
			if (hero.buff(Bless.class) != null) {
				Buff.prolong(this, Bless.class, Bless.DURATION);
			}
			if (hero.buff(Doubleevasion.class) != null) {
				Buff.prolong(this, Doubleevasion.class, Doubleevasion.DURATION);
			}
			if (hero.buff(MagicImmune.class) != null) {
				Buff.prolong(this, MagicImmune.class, MagicImmune.DURATION);
			}
		}
		return damage;
	}
}
