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
		add_v1_5_6_Changes(changeInfos);
		add_v1_5_5_Changes(changeInfos);
		add_v1_5_4_Changes(changeInfos);
		add_v1_5_3_Changes(changeInfos);
		add_v1_5_2_Changes(changeInfos);
		add_v1_5_1_Changes(changeInfos);
		add_v1_5_Changes(changeInfos);
	}

	public static void add_v1_5_6_Changes( ArrayList<ChangeInfo> changeInfos ){
		ChangeInfo changes = new ChangeInfo("v1.5.6", true, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton( Icons.get(Icons.CHANGES), "Challenges rework part V",
				"_-_ Too many changes. Too many, so there is no space to write...\n" +
						"_-_ Bug report: Touhoupixeldungeon@gmail.com"));
	}

	public static void add_v1_5_5_Changes( ArrayList<ChangeInfo> changeInfos ){
		ChangeInfo changes = new ChangeInfo("v1.5.5", true, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton( Icons.get(Icons.CHANGES), "Challenges rework part IV",
				"_-_ Added new challenge, tengu's toy camera which replaces mystia's stress song.\n" +
						"_-_ Afterglow challenge reworked. now grants double rainbow instead of triplespeed.\n" +
						"_-_ Roselia challenge reworked. Now death messages are gathered in order, each messages are lasted for 25 turns, gain message resistance buff when gathered a message, preventing unlucky players.\n" +
						"_-_ Yuuma's power drain challenge nerfed. Now triggers at 10th item instead of 5th item.\n" +
						"_-_ Hello, hellpy world! challenge nerfed. now hecatia also doesn't spawn on floor 1~10f.\n" +
						"_-_ Wizard of gensokyo challenge nerfed. now abilities are triggered with random.\n" +
						"_-_ Dried rose now always appear on floor 6 shop.\n" +
						"_-_ Bug report: Touhoupixeldungeon@gmail.com"));
	}

	public static void add_v1_5_4_Changes( ArrayList<ChangeInfo> changeInfos ){
		ChangeInfo changes = new ChangeInfo("v1.5.4", true, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton( Icons.get(Icons.CHANGES), "Major bug fixes&Challenges rework part III",
				"_-_ Fixed an issue when sakuya warpes time while you dropped inventory via unblessed life, then you lose loventory forever.\n" +
						"_-_ Fixed a softlock for yuyuko boss when re:birth day challenge is activated.\n" +
						"_-_ Rebirth now doesn't work for the fallen enemy.\n" +
						"_-_ Spellcard rule challenge is now merged with cursed hourai elixir challenge.\n" +
						"_-_ Added new challenge, yuuma's power drain which replaces pacifist.\n" +
						"_-_ Added new challenge, cherry blossom bloom which replaces spellcard rule.\n" +
						"_-_ Added new challenge, wizard of gensokyo.\n" +
						"_-_ Junko's talents were added. (Other two are still WIP)\n" +
						"_-_ I'm very disappointed of become fumo dev's abnormal behaviors. You are ruining touhou fumos.\n" +
						"_-_ Many other minor changes.\n" +
						"_-_ Bug report: Touhoupixeldungeon@gmail.com"));
	}

	public static void add_v1_5_3_Changes( ArrayList<ChangeInfo> changeInfos ){
		ChangeInfo changes = new ChangeInfo("v1.5.3", true, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton( Icons.get(Icons.CHANGES), "Challenges rework part II",
				"_-_ Afterglow challenge nerfed. Now grants triplespeed for 2 turns, from 10 turns. and only for 4 directions.\n" +
						"_-_ Pacifist challenge nerfed. Now starts with hakkero of corrosion.\n" +
						"_-_ Puppet dance performance challenge nerfed. Now don't summon enemies when enemy attacks.\n" +
						"_-_ Dekafumo challenge renamed. Now it's genso wanderer.\n" +
						"_-_ Become fumo challenge name renamed. Now it's ringing bloom.\n" +
						"_-_ (Talents WIP) Two new character renko and seija is added.\n" +
						"_-_ Hakkero of reverse gravity is now seija's special item and no longer random drops.\n" +
						"_-_ Fixed an issue that rod of repentance is not increasing its ATK.\n" +
						"_-_ I'm very disappointed of become fumo dev's abnormal behaviors. You are ruining touhou fumos.\n" +
						"_-_ Many other minor changes.\n" +
						"_-_ Bug report: Touhoupixeldungeon@gmail.com"));
	}

	public static void add_v1_5_2_Changes( ArrayList<ChangeInfo> changeInfos ){
		ChangeInfo changes = new ChangeInfo("v1.5.2", true, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton( Icons.get(Icons.CHANGES), "Challenges rework",
				"_-_ Added new challenge, re:birth day which replaces double rainbow challenge.\n" +
						"_-_ Added new challenge, puppet dance performance which replaces devil mansion's library.\n" +
						"_-_ Pastel palettes challenge nerfed. Now deals 1.25x damage when a condition met.\n" +
						"_-_ Roselia challenge nerfed. Now works with 1/2 chance.\n" +
						"_-_ Hakkero of transfusion is completely removed from the game, since it is meaningless.\n" +
						"_-_ Many other minor changes.\n" +
						"_-_ Bug report: Touhoupixeldungeon@gmail.com"));
	}

	public static void add_v1_5_1_Changes( ArrayList<ChangeInfo> changeInfos ){
		ChangeInfo changes = new ChangeInfo("v1.5.1", true, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton( Icons.get(Icons.CHANGES), "Minor bugfix",
				"_-_ Fixed an issue that some texts were korean.\n" +
						"_-_ Res. damage reduction were nerfed.\n" +
						"_-_ Devil mansion's library challenge reworked.\n" +
						"_-_ New hakkero, hakkero of setsuna trip.\n" +
						"_-_ On may, Tiles will reworked. so please wait!\n" +
						"_-_ Many bugfixes.\n" +
						"_-_ Many other minor changes.\n" +
						"_-_ Bug report: Touhoupixeldungeon@gmail.com"));
	}

	public static void add_v1_5_Changes( ArrayList<ChangeInfo> changeInfos ){
		ChangeInfo changes = new ChangeInfo("v1.5", true, "");
		changes.hardlight(Window.TITLE_COLOR);
		changeInfos.add(changes);

		changes.addButton( new ChangeButton( Icons.get(Icons.CHANGES), "Massive balance fix",
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