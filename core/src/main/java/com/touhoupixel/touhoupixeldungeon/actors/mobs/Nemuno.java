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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfChallenge;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfSirensSong;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfTorment;
import com.touhoupixel.touhoupixeldungeon.levels.Terrain;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.NemunoSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.SannyoSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class Nemuno extends Mob {

	{
		spriteClass = NemunoSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 464;
		} else HP = HT = 6;

		if (Dungeon.depth > 50){
			defenseSkill = 59;
		} else defenseSkill = 9;

		if (Dungeon.depth > 50){
			EXP = 55;
		} else EXP = 5;

		if (Dungeon.depth > 50){
			maxLvl = 63;
		} else maxLvl = 13;

		loot = new ScrollOfChallenge();
		lootChance = 0.1f;

		properties.add(Property.YOKAI);
		properties.add(Property.COOL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(35, 41);
		} else return Random.NormalIntRange(4, 6);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 59;
		} else return 9;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(10) == 0) {
				if (Dungeon.isChallenged(Challenges.BECOME_FUMO)) {
					damage = Math.max(damage, hero.HP / 4);
				} else {
					damage = Math.max(damage, hero.HP / 2);
				}
				Sample.INSTANCE.play(Assets.Sounds.CURSED);
				CellEmitter.get(pos).burst(ShadowParticle.UP, 5);
				GLog.w(Messages.get(this, "torment"));

				return damage;
			}
		}
		return damage;
	}

	@Override
	public void damage(int dmg, Object src) {
		int waterCells = 0;
		for (int i : PathFinder.NEIGHBOURS9) {
			if (Dungeon.level.map[pos + i] == Terrain.GRASS
					|| Dungeon.level.map[pos + i] == Terrain.FURROWED_GRASS
					|| Dungeon.level.map[pos + i] == Terrain.HIGH_GRASS) {
				waterCells++;
			}
		}
		if (waterCells > 0) dmg = Math.round(dmg * (6 - waterCells)*0.25f);

		super.damage(dmg, src);
	}
}
