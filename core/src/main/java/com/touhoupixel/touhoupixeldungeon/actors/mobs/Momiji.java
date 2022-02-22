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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ShieldBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Terror;
import com.touhoupixel.touhoupixeldungeon.items.Gold;
import com.touhoupixel.touhoupixeldungeon.levels.features.Chasm;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.MomijiSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.CharSprite;
import com.touhoupixel.touhoupixeldungeon.ui.BuffIndicator;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Momiji extends Mob {
	
	{
		spriteClass = MomijiSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 415;
		} else HP = HT = 32;

		if (Dungeon.depth > 50){
			defenseSkill = 65;
		} else defenseSkill = 15;

		if (Dungeon.depth > 50){
			EXP = 56;
		} else EXP = 6;

		if (Dungeon.depth > 50){
			maxLvl = 65;
		} else maxLvl = 15;
		
		loot = Gold.class;
		lootChance = 0.5f;

		properties.add(Property.ANIMAL);
	}
	
	protected boolean hasRaged = false;

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return buff(BruteRage.class) != null ?
					Random.NormalIntRange( 48, 70 ) :
					Random.NormalIntRange( 27, 33 );
		} else return buff(BruteRage.class) != null ?
				Random.NormalIntRange( 15, 38 ) :
				Random.NormalIntRange( 9, 15 );
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 65;
		} else return 15;
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 8);
	}

	@Override
	public void die(Object cause) {
		super.die(cause);

		if (cause == Chasm.class){
			hasRaged = true; //don't let enrage trigger for chasm deaths
		}
	}

	@Override
	public synchronized boolean isAlive() {
		if (super.isAlive()){
			return true;
		} else {
			if (!hasRaged){
				triggerEnrage();
			}
			return !buffs(BruteRage.class).isEmpty();
		}
	}
	
	protected void triggerEnrage(){
		Buff.affect(this, BruteRage.class).setShield(HT/2 + 4);
		if (Dungeon.level.heroFOV[pos]) {
			sprite.showStatus( CharSprite.NEGATIVE, Messages.get(this, "enraged") );
		}
		spend( TICK );
		hasRaged = true;
	}
	
	private static final String HAS_RAGED = "has_raged";
	
	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(HAS_RAGED, hasRaged);
	}
	
	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		hasRaged = bundle.getBoolean(HAS_RAGED);
	}
	
	public static class BruteRage extends ShieldBuff {
		
		{
			type = buffType.POSITIVE;
		}
		
		@Override
		public boolean act() {
			
			if (target.HP > 0){
				detach();
				return true;
			}
			
			absorbDamage( 4 );
			
			if (shielding() <= 0){
				target.die(null);
			}
			
			spend( TICK );
			
			return true;
		}
		
		@Override
		public int icon () {
			return BuffIndicator.FURY;
		}
		
		@Override
		public String toString () {
			return Messages.get(this, "name");
		}
		
		@Override
		public String desc () {
			return Messages.get(this, "desc", shielding());
		}

		{
			immunities.add(Terror.class);
		}
	}
}
