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
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.Blob;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.ToxicGas;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.KanakoSprite;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class KanakoBoss extends Mob {

	{
		spriteClass = KanakoSprite.class;

		HP = HT = Dungeon.isChallenged(Challenges.STRONGER_BOSSES) ? 180 : 120;

		defenseSkill = 15;

		EXP = 0;

		maxLvl = 99;

		properties.add(Property.BOSS);
		properties.add(Property.GOD);
		properties.add(Property.POWERFUL);

		HUNTING = new Hunting();
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(18, 22);
	}

	@Override
	public int attackSkill(Char target) {
		return 15;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 8);
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );
		Statistics.ymbosskillcount += 1;

		if (Statistics.ymbosskillcount > 2){
			Dungeon.level.unseal();
			GameScene.bossSlain();
		}
	}

	private int ventCooldown = 0;

	private static final String VENT_COOLDOWN = "vent_cooldown";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(VENT_COOLDOWN, ventCooldown);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		ventCooldown = bundle.getInt( VENT_COOLDOWN );
	}

	@Override
	protected boolean act() {
		ventCooldown--;
		return super.act();
	}

	public void onZapComplete(){
		zap();
		next();
	}

	private void zap( ){
		spend( TICK );
		ventCooldown = 30;

		Ballistica trajectory = new Ballistica(pos, enemy.pos, Ballistica.STOP_TARGET);

		for (int i : trajectory.subPath(0, trajectory.dist)){
			GameScene.add(Blob.seed(i, 20, ToxicGas.class));
		}
		GameScene.add(Blob.seed(trajectory.collisionPos, 100, ToxicGas.class));

	}

	private class Hunting extends Mob.Hunting{

		@Override
		public boolean act(boolean enemyInFOV, boolean justAlerted) {
			if (!enemyInFOV || canAttack(enemy)) {
				return super.act(enemyInFOV, justAlerted);
			} else {
				enemySeen = true;
				target = enemy.pos;

				int oldPos = pos;

				if (ventCooldown <= 0 && distance(enemy) >= 1 && Random.Int(100/distance(enemy)) == 0){
					if (sprite != null && (sprite.visible || enemy.sprite.visible)) {
						sprite.zap( enemy.pos );
						return false;
					} else {
						zap();
						return true;
					}

				} else if (getCloser( target )) {
					spend( 1 / speed() );
					return moveSprite( oldPos,  pos );

				} else if (ventCooldown <= 0) {
					if (sprite != null && (sprite.visible || enemy.sprite.visible)) {
						sprite.zap( enemy.pos );
						return false;
					} else {
						zap();
						return true;
					}

				} else {
					spend( TICK );
					return true;
				}

			}
		}
	}

}
