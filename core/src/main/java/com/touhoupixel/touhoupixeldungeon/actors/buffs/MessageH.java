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

package com.touhoupixel.touhoupixeldungeon.actors.buffs;

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.ui.BuffIndicator;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.utils.Bundle;

public class MessageH extends Buff implements Hero.Doom {
	
	private static final float DURATION = 25f;
	
	private float left;
	
	private static final String LEFT	= "left";

	{
		type = buffType.NEGATIVE;
		announced = true;
	}
	
	@Override
	public void storeInBundle( Bundle bundle ) {
		super.storeInBundle( bundle );
		bundle.put( LEFT, left );
	}
	
	@Override
	public void restoreFromBundle( Bundle bundle ) {
		super.restoreFromBundle(bundle);
		left = bundle.getFloat( LEFT );
	}

	@Override
	public boolean attachTo(Char target) {
		Buff.detach( target, Chill.class);

		return super.attachTo(target);
	}
	
	public void reignite( Char ch ) {
		reignite( ch, DURATION );
	}
	
	public void reignite( Char ch, float duration ) {
		left = duration;
	}
	
	@Override
	public int icon() {
		return BuffIndicator.MESSAGE_H;
	}

	@Override
	public boolean act() {
		spend( TICK );
		left -= TICK;

		if (left <= 0){
			detach();
		}

		return true;
	}

	@Override
	public float iconFadePercent() {
		return Math.max(0, (DURATION - left) / DURATION);
	}

	@Override
	public String toString() {
		return Messages.get(this, "name");
	}

	@Override
	public String desc() {
		return Messages.get(this, "desc", dispTurns(left));
	}

	@Override
	public void onDeath() {
	}
}
