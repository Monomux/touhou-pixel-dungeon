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
import com.touhoupixel.touhoupixeldungeon.Badges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SuperDegrade;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfMight;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.CharSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.ToyohimeSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;
import com.watabou.utils.Random;

public class Toyohime extends Mob implements Callback {

	private static final float TIME_TO_ZAP = 1f;

	{
		spriteClass = ToyohimeSprite.class;

		if (Dungeon.depth > 50) {
			HP = HT = 1000;
		} else HP = HT = 300;

		if (Dungeon.depth > 50) {
			defenseSkill = 100;
		} else defenseSkill = 50;

		if (Dungeon.depth > 50) {
			EXP = 75;
		} else EXP = 25;

		if (Dungeon.depth > 50) {
			maxLvl = 99;
		} else maxLvl = 50;

		flying = true;

		loot = new PotionOfMight();
		lootChance = 0.2f;

		properties.add(Property.FLOAT);
		properties.add(Property.GOD);
		properties.add(Property.COLD);

		baseSpeed = 0.8f;
	}

	@Override
	public void die(Object cause) {
		super.die(cause);

		Statistics.toyohimesKilled++;
		Badges.validateToyohimesKilled();
		Badges.validateReisenUnlock();
		Badges.validateRenkoUnlock();
	}


	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(60, 76);
		} else return Random.NormalIntRange(30, 38);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 120;
		} else return 55;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 8);
	}

	@Override
	protected boolean canAttack(Char enemy) {
		return new Ballistica(pos, enemy.pos, Ballistica.MAGIC_BOLT).collisionPos == enemy.pos;
	}

	protected boolean doAttack(Char enemy) {

		if (Dungeon.level.adjacent(pos, enemy.pos)) {

			return super.doAttack(enemy);

		} else {

			if (sprite != null && (sprite.visible || enemy.sprite.visible)) {
				sprite.zap(enemy.pos);
				return false;
			} else {
				zap();
				return true;
			}
		}
	}

	//used so resistances can differentiate between melee and magical attacks
	public static class DarkBolt {
	}

	private void zap() {
		spend(TIME_TO_ZAP);

		if (hit(this, enemy, true)) {
			//TODO would be nice for this to work on ghost/statues too
			if (enemy == Dungeon.hero && Random.Int(0) == 0) {
				Buff.prolong(enemy, SuperDegrade.class, SuperDegrade.DURATION);
				Sample.INSTANCE.play(Assets.Sounds.DEBUFF);
			}

			int dmg = Random.NormalIntRange(16, 20);
			enemy.damage(dmg, new DarkBolt());

			if (enemy == Dungeon.hero && !enemy.isAlive()) {
				Dungeon.fail(getClass());
				GLog.n(Messages.get(this, "bolt_kill"));
			}
		} else {
			enemy.sprite.showStatus(CharSprite.NEUTRAL, enemy.defenseVerb());
		}
	}

	public void onZapComplete() {
		zap();
		next();
	}

	@Override
	public void call() {
		next();
	}

}
