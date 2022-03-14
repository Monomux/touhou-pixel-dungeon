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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Charm;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Light;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.Scroll;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfIdentify;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfBlink;
import com.touhoupixel.touhoupixeldungeon.levels.traps.CursingTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.TimeManiTrap;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.sprites.SakuyaSprite;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.ArrayList;

public class Sakuya extends Mob {

	private int blinkCooldown = 0;
	
	{
		spriteClass = SakuyaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 542;
		} else HP = HT = 122;

		if (Dungeon.depth > 50){
			defenseSkill = 94;
		} else defenseSkill = 44;

		if (Dungeon.depth > 50){
			EXP = 71;
		} else EXP = 21;

		if (Dungeon.depth > 50){
			maxLvl = 95;
		} else maxLvl = 45;

		viewDistance = Light.DISTANCE;

		baseSpeed = 3f;

		loot = new StoneOfBlink();
		lootChance = 0.1f;

		properties.add(Property.WARP);
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (this.buff(Incompetence.class) == null) {
			if (Dungeon.depth > 50 && Random.Int(6) == 0) {
				new TimeManiTrap().set(target).activate();
			} else if (Random.Int(10) == 0) {
				new TimeManiTrap().set(target).activate();
			}
		}
		return damage;
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(47, 56);
		} else return Random.NormalIntRange(28, 34);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 91;
		} else return 45;
	}

	@Override
	public float attackDelay() { return super.attackDelay()*0.34f; }
	
	@Override
	protected boolean getCloser( int target ) {
		if (fieldOfView[target] && Dungeon.level.distance( pos, target ) > 2 && blinkCooldown <= 0) {
			
			blink( target );
			spend( -1 / speed() );
			return true;
			
		} else {

			blinkCooldown--;
			return super.getCloser( target );
			
		}
	}
	
	private void blink( int target ) {
		
		Ballistica route = new Ballistica( pos, target, Ballistica.PROJECTILE);
		int cell = route.collisionPos;

		//can't occupy the same cell as another char, so move back one.
		if (Actor.findChar( cell ) != null && cell != this.pos)
			cell = route.path.get(route.dist-1);

		if (Dungeon.level.avoid[ cell ] && (!properties().contains(Property.LARGE) || Dungeon.level.openSpace[cell])){
			ArrayList<Integer> candidates = new ArrayList<>();
			for (int n : PathFinder.NEIGHBOURS8) {
				cell = route.collisionPos + n;
				if (Dungeon.level.passable[cell]
						&& Actor.findChar( cell ) == null
						&& (!properties().contains(Property.LARGE) || Dungeon.level.openSpace[cell])) {
					candidates.add( cell );
				}
			}
			if (candidates.size() > 0)
				cell = Random.element(candidates);
			else {
				blinkCooldown = Random.IntRange(4, 6);
				return;
			}
		}
		
		ScrollOfTeleportation.appear( this, cell );

		blinkCooldown = Random.IntRange(4, 6);
	}
	
	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 10);
	}

	@Override
	protected Item createLoot() {
		Class<?extends Scroll> loot;
		do{
			loot = (Class<? extends Scroll>) Random.oneOf(Generator.Category.SCROLL.classes);
		} while (loot == ScrollOfIdentify.class || loot == ScrollOfUpgrade.class);

		return Reflection.newInstance(loot);
	}

	{
		immunities.add( Charm.class );
	}

	private static final String BLINK_CD = "blink_cd";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(BLINK_CD, blinkCooldown);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		blinkCooldown = bundle.getInt(BLINK_CD);
	}
}
