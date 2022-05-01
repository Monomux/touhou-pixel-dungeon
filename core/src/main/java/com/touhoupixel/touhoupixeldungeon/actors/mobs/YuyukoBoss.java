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
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiHeal;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank1;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublerainbow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hunger;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.LockedFloor;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MessageA;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MessageD;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MessageE;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MessageH;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MessageResistance;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MessageT;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.items.Gold;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.DriedRose;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.LloydsBeacon;
import com.touhoupixel.touhoupixeldungeon.levels.traps.DistortionTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.SummoningTrap;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.LunaSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.YuyukoBossSprite;
import com.touhoupixel.touhoupixeldungeon.ui.BossHealthBar;
import com.watabou.utils.Random;

public class YuyukoBoss extends Mob {

	{
		spriteClass = YuyukoBossSprite.class;

		HP = HT = Dungeon.isChallenged(Challenges.CHAMPION_ENEMIES) ? 2000 : 1600;
		EXP = 35;
		defenseSkill = 45;

		maxLvl = 99;

		baseSpeed = 2f;

		properties.add(Property.BOSS);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(26, 36);
	}

	@Override
	public int attackSkill(Char target) {
		return 45;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public void die( Object cause ) {

		super.die(cause);

		GameScene.bossSlain();
		Dungeon.level.unseal();

		LloydsBeacon beacon = Dungeon.hero.belongings.getItem(LloydsBeacon.class);
		if (beacon != null) {
			beacon.upgrade();
		}
	}

	@Override
	public void damage(int dmg, Object src) {
		if (!BossHealthBar.isAssigned()) {
			BossHealthBar.assignBoss(this);
		}
		boolean bleeding = (HP * 2 <= HT);
		super.damage(dmg, src);
		if ((HP * 2 <= HT) && !bleeding) {
			BossHealthBar.bleed(true);
		}
		LockedFloor lock = Dungeon.hero.buff(LockedFloor.class);
		if (lock != null) lock.addTime(dmg * 2);
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc( enemy, damage );
		Hunger hunger = Buff.affect(enemy, Hunger.class);
		if (!Dungeon.isChallenged(Challenges.CHAMPION_ENEMIES)) {
			hunger.affectHunger(-50);
		} else hunger.affectHunger(-40);
		if (enemy.buff(Hunger.class) != null && hunger.isStarving()){
			if (enemy.buff(MessageD.class) == null && enemy.buff(MessageE.class) == null) {
				Buff.affect(enemy, MessageD.class).reignite(enemy, 50f);
			} else if (enemy.buff(MessageD.class) != null && enemy.buff(MessageE.class) == null) {
				Buff.affect(enemy, MessageE.class).reignite(enemy, 50f);
			} else if (enemy.buff(MessageE.class) != null && enemy.buff(MessageA.class) == null) {
				Buff.affect(enemy, MessageA.class).reignite(enemy, 50f);
			} else if (enemy.buff(MessageA.class) != null && enemy.buff(MessageT.class) == null) {
				Buff.affect(enemy, MessageT.class).reignite(enemy, 50f);
			} else if (enemy.buff(MessageT.class) != null && enemy.buff(MessageH.class) == null) {
				Buff.affect(enemy, MessageH.class).reignite(enemy, 50f);
			}
		}
		if (enemy.buff(Might.class) != null || enemy.buff(Hisou.class) != null){
			Buff.prolong(this, Might.class, Might.DURATION);
		}
		if (this.HP < 1000){
			Buff.prolong( this, Bless.class, Bless.DURATION );
		}
		if (this.HP < 500 && Random.Int(3) == 0){
			new DistortionTrap().set(target).activate();
		}
		return damage;
	}

	@Override
	public void notice() {
		super.notice();
		if (!BossHealthBar.isAssigned()) {
			BossHealthBar.assignBoss(this);
		}
	}
}