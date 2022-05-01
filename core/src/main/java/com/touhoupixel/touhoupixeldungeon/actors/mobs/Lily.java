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
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiSneakattack;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doubleevasion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ExtremeConfusion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.food.Food;
import com.touhoupixel.touhoupixeldungeon.items.quest.Peach;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.Scroll;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfLullaby;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfChallenge;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfSirensSong;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.LilySprite;
import com.touhoupixel.touhoupixeldungeon.sprites.MinorikoSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Lily extends Mob {

	{
		spriteClass = LilySprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 514;
		} else HP = HT = 20;

		if (Dungeon.depth > 50){
			defenseSkill = 59;
		} else defenseSkill = 9;

		if (Dungeon.depth > 50){
			EXP = 55;
		} else EXP = 5;

		if (Dungeon.depth > 50){
			maxLvl = 63;
		} else maxLvl = 13;

		flying = true;

		loot = new ScrollOfSirensSong();
		lootChance = 0.15f;

		properties.add(Property.FLOAT);
		properties.add(Property.WARP);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(38, 43);
		} else return Random.NormalIntRange(3, 7);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 62;
		} else return 12;
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
				Buff.prolong(enemy, ExtremeConfusion.class, ExtremeConfusion.DURATION/2f);
			}
		}
		return damage;
	}
}