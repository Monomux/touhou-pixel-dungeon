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
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.ui.BuffIndicator;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;

public class UnderwaterCurse extends Buff implements Hero.Doom {

	{
		type = buffType.NEGATIVE;
		announced = true;
	}

	//@Override
	//public void fx(boolean on) {
	//if (on) target.sprite.add( CharSprite.State.DARKENED );
	//else if (target.invisible == 0) target.sprite.remove( CharSprite.State.DARKENED );
	//}

	@Override
	public boolean act() {
		if (target.isAlive() && !Dungeon.level.water[target.pos]) {

			target.damage(1, this);
			spend(TICK);

		} else if (target.isAlive() && Dungeon.level.water[target.pos]) {

			spend(TICK);
		} else {

			detach();

		}

		return true;
	}

	@Override
	public int icon() {
		return BuffIndicator.UNDERWATERCURSE;
	}

	@Override
	public String toString() {
		return Messages.get(this, "name");
	}

	@Override
	public String desc() {
		return Messages.get(this, "desc");
	}

	@Override
	public void onDeath() {

		Dungeon.fail( getClass() );
		GLog.n( Messages.get(this, "ondeath") );
	}
}