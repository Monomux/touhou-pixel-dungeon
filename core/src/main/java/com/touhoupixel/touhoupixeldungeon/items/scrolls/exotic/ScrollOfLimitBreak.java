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

package com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Mob;
import com.touhoupixel.touhoupixeldungeon.effects.Flare;
import com.touhoupixel.touhoupixeldungeon.items.Amulet;
import com.touhoupixel.touhoupixeldungeon.items.food.SmallRation;
import com.touhoupixel.touhoupixeldungeon.levels.traps.DistortionTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.SummoningTrap;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;

public class ScrollOfLimitBreak extends ExoticScroll {

	{
		icon = ItemSpriteSheet.Icons.SCROLL_LIMITBREAK;
	}

	@Override
	public void doRead() {

		new Flare( 5, 32 ).color( 0xFFFFFF, true ).show( curUser.sprite, 2f );

		GameScene.flash(0x80FFFFFF);

		//scales from 0x to 1x power, maxing at ~10% HP

		Sample.INSTANCE.play(Assets.Sounds.READ);

		SmallRation Smallfood = new SmallRation();

		Statistics.limitBreak += 5;

		Smallfood.collect();

		identify();

		GLog.i( Messages.get(this, "limitbreak") );

		readAnimation();

	}

}
