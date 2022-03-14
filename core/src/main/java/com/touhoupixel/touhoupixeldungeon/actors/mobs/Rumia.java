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
import com.touhoupixel.touhoupixeldungeon.actors.blobs.Blob;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.SmokeScreen;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfShroudingFog;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.RumiaSprite;
import com.watabou.utils.Random;

public class Rumia extends Mob {
	
	{
		spriteClass = RumiaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 476;
		} else HP = HT = 28;

		if (Dungeon.depth > 50){
			defenseSkill = 59;
		} else defenseSkill = 9;

		if (Dungeon.depth > 50){
			EXP = 54;
		} else EXP = 4;

		if (Dungeon.depth > 50){
			maxLvl = 63;
		} else maxLvl = 13;

		loot = new PotionOfShroudingFog();
		lootChance = 0.15f;

		properties.add(Property.PURE);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(41, 48);
		} else return Random.NormalIntRange(2, 9);
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
		damage = super.attackProc( enemy, damage );
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(2) == 0) {
				Buff.prolong(hero, Blindness.class, Blindness.DURATION);
			}
		}

		return damage;
	}

	@Override
	public int defenseProc( Char enemy, int damage ) {
		if (this.buff(Incompetence.class) == null) {
			GameScene.add(Blob.seed(pos, 200, SmokeScreen.class));
		}
			return super.defenseProc(enemy, damage);
	}
}
