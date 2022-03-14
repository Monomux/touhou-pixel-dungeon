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

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiSneakattack;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.quest.Blood;
import com.touhoupixel.touhoupixeldungeon.sprites.AkyuuSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Akyuu extends Mob {

	{
		spriteClass = AkyuuSprite.class;

		if (Dungeon.depth > 50) {
			HP = HT = 1000;
		} else HP = HT = 200;

		if (Dungeon.depth > 50) {
			defenseSkill = 80;
		} else defenseSkill = 30;

		if (Dungeon.depth > 50) {
			EXP = 64;
		} else EXP = 14;

		if (Dungeon.depth > 50) {
			maxLvl = 80;
		} else maxLvl = 30;

		loot = new Blood();
		lootChance = 0.04f;

		properties.add(Property.POWERFUL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(62, 67);
		} else return Random.NormalIntRange(34, 39);
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
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			if (Dungeon.depth > 50) {
				Buff.prolong(enemy, AntiSneakattack.class, AntiSneakattack.DURATION);
			}
			if (Random.Int(0) == 0) {
				if (HP > 3) {
					HP = HP / 2;
					Sample.INSTANCE.play(Assets.Sounds.CURSED);
					CellEmitter.get(pos).burst(ShadowParticle.UP, 5);
				}
			}
			return damage;
		}
		return damage;
	}
}