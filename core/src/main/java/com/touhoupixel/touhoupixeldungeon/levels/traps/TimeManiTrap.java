/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2019 Evan Debenham
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

package com.touhoupixel.touhoupixeldungeon.levels.traps;

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Belongings;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.LloydsBeacon;
import com.touhoupixel.touhoupixeldungeon.journal.Notes;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.InterlevelScene;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.Game;

public class TimeManiTrap extends Trap {

	{
		color = TEAL;
		shape = LARGE_DOT;
	}

	@Override
	public void activate() {
		Statistics.timeReset += 1;
		if (Statistics.timeReset > 10) {
			GLog.n( Messages.get(this, "timemanifailed") );
		}
		if (Statistics.timeReset < 11) {
			InterlevelScene.returnDepth = Dungeon.depth;
			Belongings belongings = Dungeon.hero.belongings;

			for (Notes.Record rec : Notes.getRecords()) {
				if (rec.depth() == Dungeon.depth) {
					Notes.remove(rec);
				}
			}

			for (Item i : belongings) {
				if (i instanceof LloydsBeacon && ((LloydsBeacon) i).returnDepth == Dungeon.depth)
					((LloydsBeacon) i).returnDepth = -1;
			}

			InterlevelScene.mode = InterlevelScene.Mode.RESET;
			Game.switchScene(InterlevelScene.class);
		}
	}
}