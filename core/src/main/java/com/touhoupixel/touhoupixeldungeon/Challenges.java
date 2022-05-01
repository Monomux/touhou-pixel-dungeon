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

package com.touhoupixel.touhoupixeldungeon;

import com.touhoupixel.touhoupixeldungeon.items.Item;

public class Challenges {

	//Some of these internal IDs are outdated and don't represent what these challenges do
	public static final int CHAMPION_ENEMIES	     = 1;
	public static final int REISEN_GAZE 	         = 2;
	public static final int AFTERGLOW                = 4;
	public static final int PASTEL_PALETTES		     = 8;
	public static final int ROSELIA		             = 16;
	public static final int HECATIA_TIME 	         = 32;
	public static final int KEINE_TIME			     = 64;
	public static final int EIKI_JUDGEMENT		     = 128;
	public static final int CURSED_HOURAI_ELIXIR	 = 256;
	public static final int TENSHI_EARTHQUAKE        = 512;
	public static final int YUUMA_POWER_DRAIN 		 = 1024;
	public static final int CHERRY_BLOSSOM_BLOOM     = 2048;
	public static final int DEKAI_ENEMIES 	         = 4096;
	public static final int ATHEISM 	             = 8192;
	public static final int RINGING_BLOOM            = 16384;
	public static final int MORFONICA 	             = 32768;
	public static final int REBIRTH_DAY 	         = 65536;
	public static final int NITORI_CURSED_KEY        = 131072;
	public static final int KAGUYA_ITEM_DISPEL       = 262144;
	public static final int PUPPET_DANCE_PERFORMANCE = 524288;

	public static final int MAX_VALUE                = 1048575;

	public static final String[] NAME_IDS = {
			"champion_enemies",
			"reisen_gaze",
			"afterglow",
			"pastel_palettes",
			"roselia",
			"hecatia_time",
			"keine_time",
			"eiki_judgement",
			"cursed_hourai_elixir",
			"tenshi_earthquake",
			"yuuma_power_drain",
			"cherry_blossom_bloom",
			"dekai_enemies",
			"atheism",
			"become_fumo",
			"morfonica",
			"rebirth_day",
			"nitori_cursed_key",
			"kaguya_item_dispel",
			"puppet_dance_performance"
	};

	public static final int[] MASKS = {
			CHAMPION_ENEMIES, REISEN_GAZE, AFTERGLOW, PASTEL_PALETTES, ROSELIA, HECATIA_TIME, KEINE_TIME, EIKI_JUDGEMENT, CURSED_HOURAI_ELIXIR, TENSHI_EARTHQUAKE, YUUMA_POWER_DRAIN, CHERRY_BLOSSOM_BLOOM, DEKAI_ENEMIES, ATHEISM, RINGING_BLOOM, MORFONICA, REBIRTH_DAY, NITORI_CURSED_KEY, KAGUYA_ITEM_DISPEL, PUPPET_DANCE_PERFORMANCE
	};

	public static int activeChallenges(){
		int chCount = 0;
		for (int ch : Challenges.MASKS){
			if ((Dungeon.challenges & ch) != 0) chCount++;
		}
		return chCount;
	}

	public static boolean isItemBlocked( Item item ){
		return false;

	}

}