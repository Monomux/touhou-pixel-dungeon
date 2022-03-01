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
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLiquidFlame;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.JoonSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Joon extends Mob {

	{
		spriteClass = JoonSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 481;
		} else HP = HT = 24;

		if (Dungeon.depth > 50){
			defenseSkill = 62;
		} else defenseSkill = 12;

		if (Dungeon.depth > 50){
			EXP = 55;
		} else EXP = 5;

		if (Dungeon.depth > 50){
			maxLvl = 60;
		} else maxLvl = 10;

		flying = true;

		loot = Gold.class;
		lootChance = 0.2f;

		properties.add(Property.FLOAT);
		properties.add(Property.GOD);
		properties.add(Property.PURE);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(37, 42);
		} else return Random.NormalIntRange(2, 8);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 60;
		} else return 10;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
		if (Random.Int( 3 ) == 0 && hero instanceof Hero) {
			if (Dungeon.gold > 501) {
				Dungeon.gold -= 500;
				PotionOfLiquidFlame Flame = new PotionOfLiquidFlame();
				Flame.quantity(1).collect();
				Sample.INSTANCE.play(Assets.Sounds.GOLD);
				CellEmitter.get(pos).burst(ShadowParticle.UP, 5);
				GLog.w(Messages.get(this, "wastemoney"));
			}
		}
			return damage;
		}
		return damage;
	}
}
