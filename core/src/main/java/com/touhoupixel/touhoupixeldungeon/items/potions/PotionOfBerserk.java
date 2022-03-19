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

package com.touhoupixel.touhoupixeldungeon.items.potions;

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Paralysis;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;

public class PotionOfBerserk extends Potion {

	{
		icon = ItemSpriteSheet.Icons.POTION_BERSERK;
	}

	@Override
	public void apply( Hero hero ) {
		identify();
		GLog.i( Messages.get(this, "msg1") );
		Buff.affect(hero, Might.class, Might.DURATION*5f);
		Buff.affect(hero, Silence.class, Silence.DURATION*3f);

		if (Dungeon.hero.heroClass == HeroClass.KOGASAPLAYER){
			GLog.w( Messages.get(PotionOfDoublespeed.class, "wrath") );
			Buff.prolong( hero, Paralysis.class, Paralysis.DURATION);
			Buff.prolong( hero, Slow.class, Slow.DURATION*10f);
			Buff.prolong( hero, Silence.class, Silence.DURATION*2f);
		} else Buff.prolong( hero, Haste.class, Haste.DURATION*5f);
	}
	
	@Override
	public int value() {
		return isKnown() ? 30 * quantity : super.value();
	}
}
