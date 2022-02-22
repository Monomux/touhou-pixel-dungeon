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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ChampionEnemy;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.quest.Peach;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfChallenge;
import com.touhoupixel.touhoupixeldungeon.sprites.HecatiaSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Hecatia extends Mob {

	{
		spriteClass = HecatiaSprite.class;

		HP = HT = Dungeon.depth*2;
		defenseSkill = Dungeon.depth;

		EXP = 1;
		maxLvl = 99;

		loot = new ScrollOfChallenge();
		lootChance = 0.01f;

		properties.add(Property.GOD);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(Dungeon.depth+4, Dungeon.depth+6);
	}

	@Override
	public int attackSkill(Char target) {
		return Dungeon.depth+5;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(3) == 0) {
				Sample.INSTANCE.play(Assets.Sounds.READ);
				CellEmitter.get(pos).burst(ShadowParticle.UP, 5);
				for (Mob mob : Dungeon.level.mobs.toArray(new Mob[0])) {
					mob.beckon(enemy.pos);
					Buff.prolong(mob, Doublespeed.class, Doublespeed.DURATION * 1000f);
					Buff.affect(mob, ChampionEnemy.HecatiaStatsUp.class);

				}
			}
		}
		return damage;
	}
}