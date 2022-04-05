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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Adrenaline;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AllyBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ChampionEnemy;
import com.touhoupixel.touhoupixeldungeon.effects.Beam;
import com.touhoupixel.touhoupixeldungeon.effects.Pushing;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.RemiliaSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.PatchouliSprite;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class Remilia extends Mob {
	
	{
		spriteClass = RemiliaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 394;
		} else HP = HT = 29;

		if (Dungeon.depth > 50){
			defenseSkill = 59;
		} else defenseSkill = 9;

		if (Dungeon.depth > 50){
			EXP = 55;
		} else EXP = 5;

		if (Dungeon.depth > 50){
			maxLvl = 63;
		} else maxLvl = 13;
		
		loot = new PotionOfHealing();
		lootChance = 0.2f;
		
		HUNTING = new Hunting();

		properties.add(Property.COOL);
	}
	
	public boolean summoning = false;
	public int summoningPos = -1;
	
	protected boolean firstSummon = true;
	
	private NecroPatchouli myPatchouli;
	private int storedpatchouliID = -1;

	@Override
	protected boolean act() {
		if (summoning && state != HUNTING){
			summoning = false;
			if (sprite instanceof RemiliaSprite) ((RemiliaSprite) sprite).cancelSummoning();
		}
		return super.act();
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}
	
	@Override
	public void rollToDropLoot() {
		lootChance *= ((6f - Dungeon.LimitedDrops.NECRO_HP.count) / 6f);
		super.rollToDropLoot();
	}
	
	@Override
	protected Item createLoot(){
		Dungeon.LimitedDrops.NECRO_HP.count++;
		return super.createLoot();
	}
	
	@Override
	public void die(Object cause) {
		if (storedpatchouliID != -1){
			Actor ch = Actor.findById(storedpatchouliID);
			storedpatchouliID = -1;
			if (ch instanceof NecroPatchouli){
				myPatchouli = (NecroPatchouli) ch;
			}
		}
		
		if (myPatchouli != null && myPatchouli.isAlive()){
			myPatchouli.die(null);
		}
		
		super.die(cause);
	}

	@Override
	protected boolean canAttack(Char enemy) {
		return false;
	}

	private static final String SUMMONING = "summoning";
	private static final String FIRST_SUMMON = "first_summon";
	private static final String SUMMONING_POS = "summoning_pos";
	private static final String MY_PATCHOULI = "my_patchouli";
	
	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put( SUMMONING, summoning );
		bundle.put( FIRST_SUMMON, firstSummon );
		if (summoning){
			bundle.put( SUMMONING_POS, summoningPos);
		}
		if (myPatchouli != null){
			bundle.put( MY_PATCHOULI, myPatchouli.id() );
		} else if (storedpatchouliID != -1){
			bundle.put( MY_PATCHOULI, storedpatchouliID );
		}
	}
	
	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		summoning = bundle.getBoolean( SUMMONING );
		if (bundle.contains(FIRST_SUMMON)) firstSummon = bundle.getBoolean(FIRST_SUMMON);
		if (summoning){
			summoningPos = bundle.getInt( SUMMONING_POS );
		}
		if (bundle.contains( MY_PATCHOULI )){
			storedpatchouliID = bundle.getInt( MY_PATCHOULI );
		}
	}
	
	public void onZapComplete(){
		if (myPatchouli == null || myPatchouli.sprite == null || !myPatchouli.isAlive()){
			return;
		}

		if (myPatchouli.HP < myPatchouli.HT){

			if (sprite.visible || myPatchouli.sprite.visible) {
				sprite.parent.add(new Beam.HealthRay(sprite.center(), myPatchouli.sprite.center()));
			}

			myPatchouli.HP = Math.min(myPatchouli.HP + 5, myPatchouli.HT);
			if (myPatchouli.sprite.visible) myPatchouli.sprite.emitter().burst( Speck.factory( Speck.HEALING ), 1 );
			
		//otherwise give it adrenaline
		} else if (myPatchouli.buff(Adrenaline.class) == null) {

			if (sprite.visible || myPatchouli.sprite.visible) {
				sprite.parent.add(new Beam.HealthRay(sprite.center(), myPatchouli.sprite.center()));
			}
			
			Buff.affect(myPatchouli, Adrenaline.class, 3f);
		}
		
		next();
	}

	public void summonMinion(){
		if (Actor.findChar(summoningPos) != null) {
			int pushPos = pos;
			for (int c : PathFinder.NEIGHBOURS8) {
				if (Actor.findChar(summoningPos + c) == null
						&& Dungeon.level.passable[summoningPos + c]
						&& (Dungeon.level.openSpace[summoningPos + c] || !hasProp(Actor.findChar(summoningPos), Property.LARGE))
						&& Dungeon.level.trueDistance(pos, summoningPos + c) > Dungeon.level.trueDistance(pos, pushPos)) {
					pushPos = summoningPos + c;
				}
			}

			//push enemy, or wait a turn if there is no valid pushing position
			if (pushPos != pos) {
				Char ch = Actor.findChar(summoningPos);
				Actor.addDelayed( new Pushing( ch, ch.pos, pushPos ), -1 );

				ch.pos = pushPos;
				Dungeon.level.occupyCell(ch );

			} else {

				Char blocker = Actor.findChar(summoningPos);
				if (blocker.alignment != alignment){
					blocker.damage( Random.NormalIntRange(2, 10), this );
				}

				spend(TICK);
				return;
			}
		}

		summoning = firstSummon = false;

		myPatchouli = new NecroPatchouli();
		myPatchouli.pos = summoningPos;
		GameScene.add( myPatchouli );
		Dungeon.level.occupyCell( myPatchouli );
		((RemiliaSprite)sprite).finishSummoning();

		for (Buff b : buffs(AllyBuff.class)){
			Buff.affect(myPatchouli, b.getClass());
		}
		for (Buff b : buffs(ChampionEnemy.class)){
			Buff.affect( myPatchouli, b.getClass());
		}
	}
	
	private class Hunting extends Mob.Hunting{
		
		@Override
		public boolean act(boolean enemyInFOV, boolean justAlerted) {
			enemySeen = enemyInFOV;
			
			if (storedpatchouliID != -1){
				Actor ch = Actor.findById(storedpatchouliID);
				storedpatchouliID = -1;
				if (ch instanceof NecroPatchouli){
					myPatchouli = (NecroPatchouli) ch;
				}
			}
			
			if (summoning){
				summonMinion();
				return true;
			}
			
			if (myPatchouli != null &&
					(!myPatchouli.isAlive()
					|| !Dungeon.level.mobs.contains(myPatchouli)
					|| myPatchouli.alignment != alignment)){
				myPatchouli = null;
			}

			if (enemySeen && Dungeon.level.distance(pos, enemy.pos) <= 4 && myPatchouli == null){
				
				summoningPos = -1;
				for (int c : PathFinder.NEIGHBOURS8){
					if (Actor.findChar(enemy.pos+c) == null
							&& Dungeon.level.passable[enemy.pos+c]
							&& fieldOfView[enemy.pos+c]
							&& Dungeon.level.trueDistance(pos, enemy.pos+c) < Dungeon.level.trueDistance(pos, summoningPos)){
						summoningPos = enemy.pos+c;
					}
				}
				
				if (summoningPos != -1){
					
					summoning = true;
					sprite.zap( summoningPos );
					
					spend( firstSummon ? TICK : 2*TICK );
				} else {
					//wait for a turn
					spend(TICK);
				}
				
				return true;
			} else if (enemySeen && myPatchouli != null){
				
				target = enemy.pos;
				spend(TICK);
				
				if (!fieldOfView[myPatchouli.pos]){

					if (!Dungeon.level.adjacent(myPatchouli.pos, enemy.pos)){
						int telePos = -1;
						for (int c : PathFinder.NEIGHBOURS8){
							if (Actor.findChar(enemy.pos+c) == null
									&& Dungeon.level.passable[enemy.pos+c]
									&& fieldOfView[enemy.pos+c]
									&& Dungeon.level.trueDistance(pos, enemy.pos+c) < Dungeon.level.trueDistance(pos, telePos)){
								telePos = enemy.pos+c;
							}
						}
						
						if (telePos != -1){
							
							ScrollOfTeleportation.appear(myPatchouli, telePos);
							myPatchouli.teleportSpend();
							
							if (sprite != null && sprite.visible){
								sprite.zap(telePos);
								return false;
							} else {
								onZapComplete();
							}
						}
					}
					
					return true;
					
				} else {

					if (myPatchouli.HP < myPatchouli.HT || myPatchouli.buff(Adrenaline.class) == null) {
						if (sprite != null && sprite.visible){
							sprite.zap(myPatchouli.pos);
							return false;
						} else {
							onZapComplete();
						}
					}
					
				}
				
				return true;
				
			//otherwise, default to regular hunting behaviour
			} else {
				return super.act(enemyInFOV, justAlerted);
			}
		}
	}
	
	public static class NecroPatchouli extends Patchouli {
		
		{
			state = WANDERING;
			
			spriteClass = NecroPatchouliSprite.class;
			
			//no loot or exp
			maxLvl = -5;
			
			//20/25 health to start
			HP = 20;
		}

		@Override
		public float spawningWeight() {
			return 0;
		}

		private void teleportSpend(){
			spend(TICK);
		}
		
		public static class NecroPatchouliSprite extends PatchouliSprite {
			
			public NecroPatchouliSprite(){
				super();
				brightness(0.75f);
			}
			
			@Override
			public void resetColor() {
				super.resetColor();
				brightness(0.75f);
			}
		}
		
	}
}
