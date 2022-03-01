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

import com.touhoupixel.touhoupixeldungeon.items.KindOfWeapon;
import com.watabou.utils.Bundle;

public class Statistics {

	public static int goldCollected;
	public static int deepestFloor;
	public static int enemiesSlain;
	public static int foodEaten;
	public static int potionsCooked;
	public static int itemsCrafted;
	public static int piranhasKilled;
	public static int toyohimesKilled;
	public static int yorihimesKilled;
	public static int kisumesKilled;
	public static int shopkeepersKilled;
	public static int ankhsUsed;

	//used for hero unlock badges
	public static int upgradesUsed;
	public static int sneakAttacks;
	public static int thrownAssists;

	public static int limitBreak;

	public static int cardDraw;
	public static int cardDrawalt;

	public static int timeReset;

	public static int deepdwarfHTdown;

	public static int spawnersAlive;

	public static float duration;

	public static int fireres;
	public static int coldres;
	public static int warpres;
	public static int powerfulres;
	public static int coolres;
	public static int pureres;
	public static int happyres;

	public static boolean qualifiedForNoKilling = false;
	public static boolean completedWithNoKilling = false;

	public static boolean amuletObtained = false;

	public static boolean altRoute = false;

	public static void reset() {

		goldCollected	= 0;
		deepestFloor	= 0;
		enemiesSlain	= 0;
		foodEaten		= 0;
		potionsCooked	= 0;
		itemsCrafted    = 0;
		piranhasKilled	= 0;
		toyohimesKilled = 0;
		yorihimesKilled = 0;
		kisumesKilled   = 0;
		shopkeepersKilled = 0;
		ankhsUsed		= 0;

		upgradesUsed    = 0;
		sneakAttacks    = 0;
		thrownAssists   = 0;

		limitBreak   = 0;

		cardDraw   = 0;
		cardDrawalt   = 0;

		timeReset = 0;

		deepdwarfHTdown   = 0;

		spawnersAlive   = 0;

		duration	= 0;

		//resistances
		fireres = 0;
		coldres = 0;
		warpres = 0;
		powerfulres = 0;
		coolres = 0;
		pureres = 0;
		happyres = 0;

		qualifiedForNoKilling = false;

		amuletObtained = false;

		altRoute = false;

	}

	private static final String GOLD		= "score";
	private static final String DEEPEST		= "maxDepth";
	private static final String SLAIN		= "enemiesSlain";
	private static final String FOOD		= "foodEaten";
	private static final String ALCHEMY		= "potionsCooked";
	private static final String TOYOHIMES	= "toyohimeskilled";
	private static final String YORIHIMES	= "yorihimeskilled";
	private static final String KISUMES	    = "kisumeskilled";
	private static final String SHOPKEEPERS	= "shopkeeperskilled";
	private static final String PIRANHAS	= "priranhas";
	private static final String ANKHS		= "ankhsUsed";

	private static final String UPGRADES	= "upgradesUsed";
	private static final String SNEAKS		= "sneakAttacks";
	private static final String THROWN		= "thrownAssists";

	private static final String LIMITBREAK		= "limitBreak";

	private static final String CARDDRAW		= "cardDraw";
	private static final String CARDDRAWALT		= "cardDrawalt";

	private static final String TIMERESET		= "timeReset";

	private static final String DEEPDWARFHTDOWN		= "deepdwarfhtdown";

	private static final String SPAWNERS	= "spawnersAlive";

	private static final String DURATION	= "duration";

	private static final String FIRERES	= "fireres";
	private static final String COLDRES	= "coldres";
	private static final String WARPRES	= "warpres";
	private static final String POWERFULRES	= "powerfulres";
	private static final String COOLRES	= "coolres";
	private static final String PURERES	= "pureres";
	private static final String HAPPYRES	= "happyres";

	private static final String NO_KILLING_QUALIFIED	= "qualifiedForNoKilling";

	private static final String AMULET		= "amuletObtained";

	private static final String ALTROUTE		= "altroute";

	public static void storeInBundle( Bundle bundle ) {
		bundle.put( GOLD,		goldCollected );
		bundle.put( DEEPEST,	deepestFloor );
		bundle.put( SLAIN,		enemiesSlain );
		bundle.put( FOOD,		foodEaten );
		bundle.put( ALCHEMY,    itemsCrafted );
		bundle.put( PIRANHAS,	piranhasKilled );
		bundle.put( TOYOHIMES,	toyohimesKilled );
		bundle.put( YORIHIMES,	yorihimesKilled );
		bundle.put( SHOPKEEPERS,shopkeepersKilled);
		bundle.put( KISUMES,	kisumesKilled );
		bundle.put( ANKHS,		ankhsUsed );

		bundle.put( UPGRADES,   upgradesUsed );
		bundle.put( SNEAKS,		sneakAttacks );
		bundle.put( THROWN,		thrownAssists );

		bundle.put( LIMITBREAK,		limitBreak );

		bundle.put( CARDDRAW,		cardDraw );
		bundle.put( CARDDRAWALT,		cardDrawalt );

		bundle.put( TIMERESET,		timeReset );

		bundle.put( DEEPDWARFHTDOWN,	deepdwarfHTdown );

		bundle.put( SPAWNERS,	spawnersAlive );

		bundle.put( ALTROUTE,	altRoute );

		bundle.put( DURATION,	duration );

		bundle.put( FIRERES,	fireres );
		bundle.put( COLDRES,	coldres );
		bundle.put( WARPRES,	warpres );
		bundle.put( POWERFULRES,	powerfulres );
		bundle.put( COOLRES,	coolres );
		bundle.put( PURERES,	pureres );
		bundle.put( HAPPYRES,	happyres );

		bundle.put(NO_KILLING_QUALIFIED, qualifiedForNoKilling);

		bundle.put( AMULET,		amuletObtained );
	}

	public static void restoreFromBundle( Bundle bundle ) {
		goldCollected	= bundle.getInt( GOLD );
		deepestFloor	= bundle.getInt( DEEPEST );
		enemiesSlain	= bundle.getInt( SLAIN );
		foodEaten		= bundle.getInt( FOOD );
		itemsCrafted    = bundle.getInt( ALCHEMY );
		toyohimesKilled	= bundle.getInt( TOYOHIMES );
		yorihimesKilled	= bundle.getInt( YORIHIMES );
		kisumesKilled	= bundle.getInt( KISUMES );
		shopkeepersKilled	= bundle.getInt( SHOPKEEPERS );
		piranhasKilled	= bundle.getInt( PIRANHAS );
		ankhsUsed		= bundle.getInt( ANKHS );

		upgradesUsed    = bundle.getInt( UPGRADES );
		sneakAttacks    = bundle.getInt( SNEAKS );
		thrownAssists   = bundle.getInt( THROWN );

		limitBreak   = bundle.getInt( LIMITBREAK );

		cardDraw   = bundle.getInt( CARDDRAW );
		cardDrawalt   = bundle.getInt( CARDDRAWALT );

		timeReset   = bundle.getInt( TIMERESET );

		deepdwarfHTdown   = bundle.getInt( DEEPDWARFHTDOWN );

		spawnersAlive   = bundle.getInt( SPAWNERS );

		duration		= bundle.getFloat( DURATION );

		fireres		= bundle.getInt( FIRERES );
		coldres		= bundle.getInt( COLDRES );
		warpres		= bundle.getInt( WARPRES );
		powerfulres		= bundle.getInt( POWERFULRES );
		coolres		= bundle.getInt( COOLRES );
		pureres		= bundle.getInt( PURERES );
		happyres		= bundle.getInt( HAPPYRES );

		qualifiedForNoKilling = bundle.getBoolean( NO_KILLING_QUALIFIED );

		amuletObtained	= bundle.getBoolean( AMULET );

		altRoute	= bundle.getBoolean( ALTROUTE );
	}

	public static void preview( GamesInProgress.Info info, Bundle bundle ){
		info.goldCollected  = bundle.getInt( GOLD );
		info.maxDepth       = bundle.getInt( DEEPEST );
	}

}