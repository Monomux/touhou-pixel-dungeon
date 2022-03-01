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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.items.quest.Peach;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.TenshiSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Tenshi extends Mob {

	{
		spriteClass = TenshiSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 619;
		} else HP = HT = 145;

		if (Dungeon.depth > 50){
			defenseSkill = 95;
		} else defenseSkill = 45;

		if (Dungeon.depth > 50){
			EXP = 72;
		} else EXP = 22;

		if (Dungeon.depth > 50){
			maxLvl = 95;
		} else maxLvl = 45;

		loot = new Peach();
		lootChance = 0.04f;

		properties.add(Property.POWERFUL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(42, 48);
		} else return Random.NormalIntRange(21, 25);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 91;
		} else return 45;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	protected float focusCooldown = 1;

	@Override
	protected boolean act() {
		boolean result = super.act();
		Buff.prolong(this, Hisou.class, Hisou.DURATION * 1000f);
		if (state == HUNTING && focusCooldown <= 0 && !enemy.flying) {
			focusCooldown = 1;
			enemy.damage( Random.NormalIntRange(15, 20), this );
			Sample.INSTANCE.play(Assets.Sounds.BLAST);
			GLog.w(Messages.get(this, "earth"));
		}
		if (enemy == Dungeon.hero && !enemy.isAlive()) {
			Dungeon.fail( getClass() );
			GLog.n( Messages.get(this, "ondeath") );
		}
		return result;
	}

	@Override
	protected void spend(float time) {
		focusCooldown -= time;
		super.spend(time);
	}

	private static String FOCUS_COOLDOWN = "focus_cooldown";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(FOCUS_COOLDOWN, focusCooldown);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		focusCooldown = bundle.getInt(FOCUS_COOLDOWN);
	}
}