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
import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.HighStress;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfTorment;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.ClownpieceSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.SannyoSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Clownpiece extends Mob {

	{
		spriteClass = ClownpieceSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 394;
		} else HP = HT = 98;

		if (Dungeon.depth > 50){
			defenseSkill = 74;
		} else defenseSkill = 24;

		if (Dungeon.depth > 50){
			EXP = 72;
		} else EXP = 22;

		if (Dungeon.depth > 50){
			maxLvl = 95;
		} else maxLvl = 45;

		loot = new ScrollOfTorment();
		lootChance = 0.1f;

		properties.add(Property.YOKAI);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(20, 24);
		} else return Random.NormalIntRange(10, 12);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 74;
		} else return 35;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
		if (Random.Int(2) == 0) {
			Buff.prolong(enemy, HighStress.class, HighStress.DURATION);
			Sample.INSTANCE.play(Assets.Sounds.CURSED);
			CellEmitter.get(pos).burst(ShadowParticle.UP, 5);
		}
			return damage;
		}
		return damage;
	}
}
