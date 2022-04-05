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

package com.touhoupixel.touhoupixeldungeon.ui.changelist;

import com.touhoupixel.touhoupixeldungeon.items.Stylus;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Quarterstaff;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.ChangesScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSprite;
import com.touhoupixel.touhoupixeldungeon.ui.Icons;
import com.touhoupixel.touhoupixeldungeon.ui.Window;

import java.util.ArrayList;

public class v1_X_Changes {

	//just the one update this time
	public static void addAllChanges( ArrayList<ChangeInfo> changeInfos ){
		add_v1_5_1_Changes(changeInfos);
		add_v1_5_Changes(changeInfos);
	}

	public static void add_v1_5_1_Changes( ArrayList<ChangeInfo> changeInfos ){
		ChangeInfo changes = new ChangeInfo("v1.5.1", true, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton( Icons.get(Icons.CHANGES), "Minor Bug Fix",
				"_-_ Fixed an issue that some texts were korean.\n" +
						"_-_ Res. damage reduction were nerfed.\n" +
						"_-_ Devil mansion's library challenge reworked.\n" +
						"_-_ New hakkero, hakkero of setsuna trip.\n" +
						"_-_ On may, Tiles will reworked. so please wait!.\n" +
						"_-_ Many bugfixes.\n" +
						"_-_ Many other minor changes.\n" +
						"_-_ Bug report: Touhoupixeldungeon@gmail.com"));
	}

	public static void add_v1_5_Changes( ArrayList<ChangeInfo> changeInfos ){
		ChangeInfo changes = new ChangeInfo("v1.5", true, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton( Icons.get(Icons.CHANGES), "Massive Balance Fix",
				"_-_ Spellcards of upgrade now appear three for five floors each, from two.\n" +
						"_-_ Many weapons were nerfed for its damage modifiers.\n" +
						"_-_ Hana. uniform and maxwell's armor are nerfed, for removing its DR.\n" +
						"_-_ Partially SPD 1.2.0 contents were merged into TPD.\n" +
						"_-_ New challenge, afterglow.\n" +
						"_-_ New challenge, devil mansion's library. It replaces master spark challenge.\n" +
						"_-_ Nitori now triggers cursed hakkero effect when attacking with a chance. This can be prevented by using hakkero of stableness.\n" +
						"_-_ Tier 4 talents are completely removed from the game. For balancing.\n" +
						"_-_ Many bugfixes.\n" +
						"_-_ Many other minor changes.\n" +
						"_-_ Bug report: Touhoupixeldungeon@gmail.com"));
	}
}