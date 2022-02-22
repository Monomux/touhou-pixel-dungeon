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
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AllyBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Burning;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ChampionEnemy;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeon.effects.Pushing;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.AliceSprite;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class Alice extends Mob {

	{
		spriteClass = AliceSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 600;
		} else HP = HT = 80;

		if (Dungeon.depth > 50){
			defenseSkill = 75;
		} else defenseSkill = 25;

		if (Dungeon.depth > 50){
			EXP = 60;
		} else EXP = 10;

		if (Dungeon.depth > 50){
			maxLvl = 75;
		} else maxLvl = 25;
		
		flying = true;

		loot = new PotionOfHealing();
		lootChance = 0.1667f; //by default, see rollToDropLoot()

		properties.add(Property.FLOAT);
	}
	
	private static final float SPLIT_DELAY	= 1f;
	
	int generation = 0;
	
	private static final String GENERATION	= "generation";
	
	@Override
	public void storeInBundle( Bundle bundle ) {
		super.storeInBundle( bundle );
		bundle.put( GENERATION, generation );
	}
	
	@Override
	public void restoreFromBundle( Bundle bundle ) {
		super.restoreFromBundle( bundle );
		generation = bundle.getInt( GENERATION );
		if (generation > 0) EXP = 0;
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(42, 47);
		} else return Random.NormalIntRange(12, 21);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 75;
		} else return 25;
	}
	
	@Override
	public int defenseProc( Char enemy, int damage ) {
		if (this.buff(Incompetence.class) == null) {
			if (HP >= damage + 2) {
				ArrayList<Integer> candidates = new ArrayList<>();

				int[] neighbours = {pos + 1, pos - 1, pos + Dungeon.level.width(), pos - Dungeon.level.width()};
				for (int n : neighbours) {
					if (!Dungeon.level.solid[n] && Actor.findChar(n) == null
							&& (!properties().contains(Property.LARGE) || Dungeon.level.openSpace[n])) {
						candidates.add(n);
					}
				}

				if (candidates.size() > 0) {

					Alice clone = split();
					clone.HP = (HP - damage) / 2;
					clone.pos = Random.element(candidates);
					clone.state = clone.HUNTING;

					GameScene.add(clone, SPLIT_DELAY);
					Actor.addDelayed(new Pushing(clone, pos, clone.pos), -1);

					Dungeon.level.occupyCell(clone);

					HP -= clone.HP;
				}
			}
		}
		return super.defenseProc(enemy, damage);
	}
	
	private Alice split() {
		Alice clone = new Alice();
		clone.generation = generation + 1;
		clone.EXP = 0;
		if (buff( Burning.class ) != null) {
			Buff.affect( clone, Burning.class ).reignite( clone );
		}
		if (buff( Poison.class ) != null) {
			Buff.affect( clone, Poison.class ).set(2);
		}
		for (Buff b : buffs(AllyBuff.class)){
			Buff.affect( clone, b.getClass());
		}
		for (Buff b : buffs(ChampionEnemy.class)){
			Buff.affect( clone, b.getClass());
		}
		return clone;
	}
	
	@Override
	public void rollToDropLoot() {
		lootChance = 1f/(6 * (generation+1) );
		lootChance *= (5f - Dungeon.LimitedDrops.SWARM_HP.count) / 5f;
		super.rollToDropLoot();
	}
	
	@Override
	protected Item createLoot(){
		Dungeon.LimitedDrops.SWARM_HP.count++;
		return super.createLoot();
	}
}
