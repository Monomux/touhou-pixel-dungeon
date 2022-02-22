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

import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Burning;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.LockedFloor;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.DriedRose;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfExperience;
import com.touhoupixel.touhoupixeldungeon.items.quest.GooBlob;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.FlandreBossSprite;
import com.touhoupixel.touhoupixeldungeon.ui.BossHealthBar;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class FlandreBoss extends Mob {

	{
		spriteClass = FlandreBossSprite.class;

		HP = HT = Dungeon.isChallenged(Challenges.STRONGER_BOSSES) ? 2000 : 1600;
		defenseSkill = 35;

		EXP = 50;
		maxLvl = 1000;

		flying = true;

		loot = new PotionOfExperience();
		lootChance = 1f;

		properties.add(Property.BOSS);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(11, 14);
	}

	@Override
	public int attackSkill(Char target) {
		return 72;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (hero instanceof Hero) {
			if (hero.HT > 31 && hero.HP > 31) {
				Buff.affect( enemy, Burning.class ).reignite( enemy, 3f );
				hero.HT -= 30;
				hero.HP -= 30;
				if (this.HP < 500) {
					Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION);
				}
			}

			return damage;
		}
		return damage;
	}

	@Override
	public void damage(int dmg, Object src) {
		if (!BossHealthBar.isAssigned()) {
			BossHealthBar.assignBoss(this);
		}
		boolean bleeding = (HP * 2 <= HT);
		super.damage(dmg, src);
		if ((HP * 2 <= HT) && !bleeding) {
			BossHealthBar.bleed(true);
		}
		LockedFloor lock = Dungeon.hero.buff(LockedFloor.class);
		if (lock != null) lock.addTime(dmg * 2);
	}

	@Override
	public void die(Object cause) {

		super.die(cause);

		Dungeon.level.unseal();

		GameScene.bossSlain();

		//60% chance of 2 blobs, 30% chance of 3, 10% chance for 4. Average of 2.5
		int blobs = Random.chances(new float[]{0, 0, 0, 0, 1});
		for (int i = 0; i < blobs; i++) {
			int ofs;
			do {
				ofs = PathFinder.NEIGHBOURS8[Random.Int(8)];
			} while (!Dungeon.level.passable[pos + ofs]);
			Dungeon.level.drop(new GooBlob(), pos + ofs).sprite.drop(pos);
		}
	}

	@Override
	public void notice() {
		super.notice();
		if (!BossHealthBar.isAssigned()) {
			BossHealthBar.assignBoss(this);
			for (Char ch : Actor.chars()) {
				if (ch instanceof DriedRose.GhostHero) {
					((DriedRose.GhostHero) ch).sayBoss();
				}
			}
		}
	}
}