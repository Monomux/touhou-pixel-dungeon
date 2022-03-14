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
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.Gold;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.ShionSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Shion extends Mob {

	{
		spriteClass = ShionSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 451;
		} else HP = HT = 31;

		if (Dungeon.depth > 50){
			defenseSkill = 64;
		} else defenseSkill = 14;

		if (Dungeon.depth > 50){
			EXP = 57;
		} else EXP = 7;

		if (Dungeon.depth > 50){
			maxLvl = 66;
		} else maxLvl = 16;

		flying = true;

		loot = Gold.class;
		lootChance = 0.18f;

		properties.add(Property.FLOAT);
		properties.add(Property.GOD);
		properties.add(Property.PURE);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(32, 36);
		} else return Random.NormalIntRange(7, 12);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 65;
		} else return 15;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(3) == 0 && hero instanceof Hero) {
				if (Dungeon.gold > 401) {
					Dungeon.gold -= 400;
					Sample.INSTANCE.play(Assets.Sounds.CURSED);
					CellEmitter.get(pos).burst(ShadowParticle.UP, 5);
					GLog.w(Messages.get(this, "losemoney"));
				}

				return damage;
			}
		}
		return damage;
	}
}
