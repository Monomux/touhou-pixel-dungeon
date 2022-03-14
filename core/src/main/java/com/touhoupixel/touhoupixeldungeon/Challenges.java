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

import com.touhoupixel.touhoupixeldungeon.items.Dewdrop;
import com.touhoupixel.touhoupixeldungeon.items.Item;

public class Challenges {

	//Some of these internal IDs are outdated and don't represent what these challenges do
	public static final int CHAMPION_ENEMIES	= 1;
	public static final int STRONGER_BOSSES 	= 2;
	public static final int HECATIA_TIME 	    = 4;
	public static final int NO_FOOD				= 8;
	public static final int EIKI_JUDGEMENT		= 16;
	public static final int NO_HEALING			= 32;
	public static final int NO_HERBALISM		= 64;
	public static final int SWARM_INTELLIGENCE	= 128;
	public static final int DARKNESS			= 256;
	public static final int ROSELIA		        = 512;
	public static final int PACIFIST 	        = 1024;
	public static final int SPELLCARD_RULE 	    = 2048;
	public static final int DEKAI_ENEMIES 	    = 4096;
	public static final int ATHEISM 	        = 8192;
	public static final int BECOME_FUMO 	    = 16384;
	public static final int POPPIN_PARTY 	    = 32768;
	public static final int ENEMY_GRAZE 	    = 65536;
	public static final int MASTER_SPARK 	    = 131072;

	public static final int MAX_VALUE           = 262143;

	public static final String[] NAME_IDS = {
			"champion_enemies",
			"stronger_bosses",
			"hecatia_time",
			"no_food",
			"eiki_judgement",
			"no_healing",
			"no_herbalism",
			"swarm_intelligence",
			"darkness",
			"roselia",
			"pacifist",
			"spellcard_rule",
			"dekai_enemies",
			"atheism",
			"become_fumo",
			"poppin_party",
			"enemy_graze",
			"master_spark"
	};

	public static final int[] MASKS = {
			CHAMPION_ENEMIES, STRONGER_BOSSES, HECATIA_TIME, NO_FOOD, EIKI_JUDGEMENT, NO_HEALING, NO_HERBALISM, SWARM_INTELLIGENCE, DARKNESS, ROSELIA, PACIFIST, SPELLCARD_RULE, DEKAI_ENEMIES, ATHEISM, BECOME_FUMO, POPPIN_PARTY, ENEMY_GRAZE, MASTER_SPARK
	};

	public static int activeChallenges(){
		int chCount = 0;
		for (int ch : Challenges.MASKS){
			if ((Dungeon.challenges & ch) != 0) chCount++;
		}
		return chCount;
	}

	public static boolean isItemBlocked( Item item ){

		if (Dungeon.isChallenged(NO_HERBALISM) && item instanceof Dewdrop){
			return true;
		}

		return false;

	}

}