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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SuperOoze;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfCorrosiveGas;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.KeikiSprite;
import com.watabou.utils.Random;

public class KeikiBoss extends Mob {
	
	{
		spriteClass = KeikiSprite.class;

		HP = HT = Dungeon.isChallenged(Challenges.STRONGER_BOSSES) ? 180 : 120;

		defenseSkill = 25;

		EXP = 0;

		maxLvl = 99;

		loot = new PotionOfCorrosiveGas();
		lootChance = 0.1f;

		properties.add(Property.BOSS);
		properties.add(Property.GOD);
		properties.add(Property.POWERFUL);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(14, 18);
	}

	@Override
	public int attackSkill(Char target) {
		return 25;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );
		Statistics.forestbosskillcount += 1;

		if (Statistics.forestbosskillcount > 3){
			Dungeon.level.unseal();
			GameScene.bossSlain();
		}
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (this.buff(Incompetence.class) == null) {
			Buff.affect(enemy, SuperOoze.class).set(SuperOoze.DURATION);
		}
		return damage;
	}
}
