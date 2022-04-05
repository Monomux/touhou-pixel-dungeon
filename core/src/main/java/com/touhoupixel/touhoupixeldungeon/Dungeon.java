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

import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Amok;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Awareness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Light;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MindVision;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.RevealedArea;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Mob;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.npcs.Blacksmith;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.npcs.Ghost;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.npcs.Imp;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.npcs.Wandmaker;
import com.touhoupixel.touhoupixeldungeon.items.Ankh;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.Heap;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.TalismanOfForesight;
import com.touhoupixel.touhoupixeldungeon.items.potions.Potion;
import com.touhoupixel.touhoupixeldungeon.items.rings.Ring;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.Scroll;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfRegrowth;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfWarding;
import com.touhoupixel.touhoupixeldungeon.journal.Notes;
import com.touhoupixel.touhoupixeldungeon.levels.CavesBossLevel;
import com.touhoupixel.touhoupixeldungeon.levels.CavesLevel;
import com.touhoupixel.touhoupixeldungeon.levels.CityBossLevel;
import com.touhoupixel.touhoupixeldungeon.levels.CityLevel;
import com.touhoupixel.touhoupixeldungeon.levels.DekaiCavesLevel;
import com.touhoupixel.touhoupixeldungeon.levels.DekaiCityLevel;
import com.touhoupixel.touhoupixeldungeon.levels.DekaiForestLevel;
import com.touhoupixel.touhoupixeldungeon.levels.DekaiHallsLevel;
import com.touhoupixel.touhoupixeldungeon.levels.DekaiLunarLevel;
import com.touhoupixel.touhoupixeldungeon.levels.DekaiMoriyaLevel;
import com.touhoupixel.touhoupixeldungeon.levels.DekaiPrisonLevel;
import com.touhoupixel.touhoupixeldungeon.levels.DekaiSewerLevel;
import com.touhoupixel.touhoupixeldungeon.levels.DekaiSkyLevel;
import com.touhoupixel.touhoupixeldungeon.levels.DekaiSpiritLevel;
import com.touhoupixel.touhoupixeldungeon.levels.FlandreBossLevel;
import com.touhoupixel.touhoupixeldungeon.levels.ForestBossLevel;
import com.touhoupixel.touhoupixeldungeon.levels.ForestLevel;
import com.touhoupixel.touhoupixeldungeon.levels.HallsBossLevel;
import com.touhoupixel.touhoupixeldungeon.levels.HallsLevel;
import com.touhoupixel.touhoupixeldungeon.levels.KisumeBossLevel;
import com.touhoupixel.touhoupixeldungeon.levels.LakeBossLevel;
import com.touhoupixel.touhoupixeldungeon.levels.LastLevel;
import com.touhoupixel.touhoupixeldungeon.levels.Level;
import com.touhoupixel.touhoupixeldungeon.levels.LunarLevel;
import com.touhoupixel.touhoupixeldungeon.levels.MansionBossLevel;
import com.touhoupixel.touhoupixeldungeon.levels.MoriyaLevel;
import com.touhoupixel.touhoupixeldungeon.levels.PrisonBossLevel;
import com.touhoupixel.touhoupixeldungeon.levels.PrisonLevel;
import com.touhoupixel.touhoupixeldungeon.levels.SewerLevel;
import com.touhoupixel.touhoupixeldungeon.levels.SkyLevel;
import com.touhoupixel.touhoupixeldungeon.levels.SpiritLevel;
import com.touhoupixel.touhoupixeldungeon.levels.YokaiBossLevel;
import com.touhoupixel.touhoupixeldungeon.levels.rooms.secret.SecretRoom;
import com.touhoupixel.touhoupixeldungeon.levels.rooms.special.SpecialRoom;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.ui.QuickSlotButton;
import com.touhoupixel.touhoupixeldungeon.utils.BArray;
import com.touhoupixel.touhoupixeldungeon.utils.DungeonSeed;
import com.watabou.noosa.Game;
import com.watabou.utils.Bundlable;
import com.watabou.utils.Bundle;
import com.watabou.utils.FileUtils;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;
import com.watabou.utils.SparseArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Dungeon {

	//enum of items which have limited spawns, records how many have spawned
	//could all be their own separate numbers, but this allows iterating, much nicer for bundling/initializing.
	public static enum LimitedDrops {
		//limited world drops
		STRENGTH_POTIONS,
		UPGRADE_SCROLLS,
		ROUTECHANGE_SCROLLS,
		ARCANE_STYLI,
		LIQUID_METAL,
		STONE_OF_ENCHANTMENT,

		//Health potion sources
		//enemies
		SWARM_HP,
		NECRO_HP,
		BAT_HP,
		WARLOCK_HP,
		TOYOHIME_HP,
		//Demon spawners are already limited in their spawnrate, no need to limit their health drops
		//alchemy
		COOKING_HP,
		BLANDFRUIT_SEED,

		//Other limited enemy drops
		SLIME_WEP,
		SKELE_WEP,
		THEIF_MISC,
		GUARD_ARM,
		SHAMAN_WAND,
		DM200_EQUIP,
		GOLEM_EQUIP,
		KOMACHI_EQUIP,

		//containers
		VELVET_POUCH,
		SCROLL_HOLDER,
		FOOD_HOLDER,
		ARCANE_HOLDER,
		POTION_BANDOLIER,
		MAGICAL_HOLSTER,
		TAILSMAN_HOLDER;

		public int count = 0;

		//for items which can only be dropped once, should directly access count otherwise.
		public boolean dropped(){
			return count != 0;
		}
		public void drop(){
			count = 1;
		}

		public static void reset(){
			for (LimitedDrops lim : values()){
				lim.count = 0;
			}
		}

		public static void store( Bundle bundle ){
			for (LimitedDrops lim : values()){
				bundle.put(lim.name(), lim.count);
			}
		}

		public static void restore( Bundle bundle ){
			for (LimitedDrops lim : values()){
				if (bundle.contains(lim.name())){
					lim.count = bundle.getInt(lim.name());
				} else {
					lim.count = 0;
				}

			}
		}

	}

	public static int challenges;
	public static int mobsToChampion;

	public static Hero hero;
	public static Level level;

	public static QuickSlot quickslot = new QuickSlot();

	public static int depth;

	public static int gold;
	public static int energy;

	public static HashSet<Integer> chapters;

	public static SparseArray<ArrayList<Item>> droppedItems;
	public static SparseArray<ArrayList<Item>> portedItems;

	public static int version;

	public static long seed;

	public static void init() {

		version = Game.versionCode;
		challenges = TPDSettings.challenges();
		mobsToChampion = -1;

		seed = DungeonSeed.randomSeed();

		Actor.clear();
		Actor.resetNextID();

		Random.pushGenerator( seed );

		Scroll.initLabels();
		Potion.initColors();
		Ring.initGems();

		SpecialRoom.initForRun();
		SecretRoom.initForRun();

		Random.resetGenerators();

		com.touhoupixel.touhoupixeldungeon.Statistics.reset();
		Notes.reset();

		quickslot.reset();
		QuickSlotButton.reset();

		depth = 0;
		gold = 0;
		energy = 0;

		droppedItems = new SparseArray<>();
		portedItems = new SparseArray<>();

		LimitedDrops.reset();

		chapters = new HashSet<>();

		Ghost.Quest.reset();
		Wandmaker.Quest.reset();
		Blacksmith.Quest.reset();
		Imp.Quest.reset();

		Generator.fullReset();
		hero = new Hero();
		hero.live();

		Badges.reset();

		GamesInProgress.selectedClass.initHero( hero );
	}

	public static boolean isChallenged( int mask ) {
		return (challenges & mask) != 0;
	}

	public static Level newLevel() {

		Dungeon.level = null;
		Actor.clear();

		depth++;
		if (depth > com.touhoupixel.touhoupixeldungeon.Statistics.deepestFloor) {
			com.touhoupixel.touhoupixeldungeon.Statistics.deepestFloor = depth;

			if (com.touhoupixel.touhoupixeldungeon.Statistics.qualifiedForNoKilling) {
				com.touhoupixel.touhoupixeldungeon.Statistics.completedWithNoKilling = true;
			} else {
				com.touhoupixel.touhoupixeldungeon.Statistics.completedWithNoKilling = false;
			}
		}

		Level level;
		switch (depth) {
			case 1:
			case 2:
			case 3:
			case 4:
				level = new SewerLevel();
				break;
			case 5:
				level = new LakeBossLevel();
				break;
			case 6:
			case 7:
			case 8:
			case 9:
				level = new PrisonLevel();
				break;
			case 10:
				level = new MansionBossLevel();
				break;
			case 11:
			case 12:
			case 13:
			case 14:
				level = new CavesLevel();
				break;
			case 15:
				level = new YokaiBossLevel();
				break;
			case 16:
			case 17:
			case 18:
			case 19:
				level = new CityLevel();
				break;
			case 20:
				level = new PrisonBossLevel();
				break;
			case 21:
			case 22:
			case 23:
			case 24:
				level = new ForestLevel();
				break;
			case 25:
				level = new ForestBossLevel();
				break;
			case 26:
			case 27:
			case 28:
			case 29:
				level = new MoriyaLevel();
				break;
			case 30:
				level = new CavesBossLevel();
				break;
			case 31:
			case 32:
			case 33:
			case 34:
				level = new SpiritLevel();
				break;
			case 35:
				level = new KisumeBossLevel();
				break;
			case 36:
			case 37:
			case 38:
			case 39:
				level = new LunarLevel();
				break;
			case 40:
				level = new CityBossLevel();
				break;
			case 41:
			case 42:
			case 43:
			case 44:
				level = new SkyLevel();
				break;
			case 45:
				level = new FlandreBossLevel();
				break;
			case 46:
			case 47:
			case 48:
			case 49:
				level = new HallsLevel();
				break;
			case 50:
				level = new HallsBossLevel();
				break;
			case 51:
				if (!Dungeon.isChallenged(com.touhoupixel.touhoupixeldungeon.Challenges.DEKAI_ENEMIES)) {
					level = new LastLevel();
					break;
				} else {
					level = new DekaiSewerLevel();
					break;
				}
			case 52:
			case 53:
			case 54:
			case 55:
				level = new DekaiSewerLevel();
				break;
			case 56:
			case 57:
			case 58:
			case 59:
			case 60:
				level = new DekaiPrisonLevel();
				break;
			case 61:
			case 62:
			case 63:
			case 64:
			case 65:
				level = new DekaiCavesLevel();
				break;
			case 66:
			case 67:
			case 68:
			case 69:
			case 70:
				level = new DekaiCityLevel();
				break;
			case 71:
			case 72:
			case 73:
			case 74:
			case 75:
				level = new DekaiForestLevel();
				break;
			case 76:
			case 77:
			case 78:
			case 79:
			case 80:
				level = new DekaiMoriyaLevel();
				break;
			case 81:
			case 82:
			case 83:
			case 84:
			case 85:
				level = new DekaiSpiritLevel();
				break;
			case 86:
			case 87:
			case 88:
			case 89:
			case 90:
				level = new DekaiLunarLevel();
				break;
			case 91:
			case 92:
			case 93:
			case 94:
			case 95:
				level = new DekaiSkyLevel();
				break;
			case 96:
			case 97:
			case 98:
				level = new DekaiHallsLevel();
				break;
			default:
				level = new LastLevel();
				com.touhoupixel.touhoupixeldungeon.Statistics.deepestFloor--;
		}

		level.create();

		com.touhoupixel.touhoupixeldungeon.Statistics.qualifiedForNoKilling = !bossLevel();

		return level;
	}

	public static void resetLevel() {

		Actor.clear();

		level.reset();
		switchLevel( level, level.entrance );
	}

	public static long seedCurDepth(){
		return seedForDepth(depth);
	}

	public static long seedForDepth(int depth){
		Random.pushGenerator( seed );

		for (int i = 0; i < depth; i ++) {
			Random.Long(); //we don't care about these values, just need to go through them
		}
		long result = Random.Long();

		Random.popGenerator();
		return result;
	}

	public static boolean shopOnLevel() {
		return depth == 6 || depth == 11 || depth == 16 || depth == 21 || depth == 31 || depth == 61 || depth == 81;
	}

	public static boolean bossLevel() {
		return bossLevel( depth );
	}

	public static boolean bossLevel( int depth ) {
		return depth == 5 || depth == 10 || depth == 15 || depth == 20 || depth == 25 || depth == 30 || depth == 35 || depth == 40 || depth == 45 || depth == 50; //|| depth == 60 || depth == 65 || depth == 70 || depth == 75 || depth == 80 || depth == 85 || depth == 90 || depth == 94 || depth == 98;
	}

	public static void switchLevel( final Level level, int pos ) {

		if (pos == -2){
			pos = level.exit;
		} else if (pos < 0 || pos >= level.length() || (!level.passable[pos] && !level.avoid[pos])){
			pos = level.entrance;
		}

		PathFinder.setMapSize(level.width(), level.height());

		Dungeon.level = level;
		Mob.restoreAllies( level, pos );
		Actor.init();

		level.addRespawner();

		hero.pos = pos;

		for(Mob m : level.mobs){
			if (m.pos == hero.pos){
				//displace mob
				for(int i : PathFinder.NEIGHBOURS8){
					if (Actor.findChar(m.pos+i) == null && level.passable[m.pos + i]){
						m.pos += i;
						break;
					}
				}
			}
		}

		Light light = hero.buff( Light.class );
		hero.viewDistance = light == null ? level.viewDistance : Math.max( Light.DISTANCE, level.viewDistance );

		hero.curAction = hero.lastAction = null;

		observe();
		try {
			saveAll();
		} catch (IOException e) {
			TouhouPixelDungeon.reportException(e);
			/*This only catches IO errors. Yes, this means things can go wrong, and they can go wrong catastrophically.
			But when they do the user will get a nice 'report this issue' dialogue, and I can fix the bug.*/
		}
	}

	public static void dropToChasm( Item item ) {
		int depth = Dungeon.depth + 1;
		ArrayList<Item> dropped = Dungeon.droppedItems.get( depth );
		if (dropped == null) {
			Dungeon.droppedItems.put( depth, dropped = new ArrayList<>() );
		}
		dropped.add( item );
	}

	public static boolean posNeeded() {
		//2 POS each floor set
		int posLeftThisSet = 2 - (LimitedDrops.STRENGTH_POTIONS.count - (depth / 5) * 2);
		if (posLeftThisSet <= 0) return false;

		int floorThisSet = (depth % 5);

		//pos drops every two floors, (numbers 1-2, and 3-4) with a 50% chance for the earlier one each time.
		int targetPOSLeft = 2 - floorThisSet/2;
		if (floorThisSet % 2 == 1 && Random.Int(2) == 0) targetPOSLeft --;

		if (targetPOSLeft < posLeftThisSet) return true;
		else return false;

	}

	public static boolean souNeeded() {
		int souLeftThisSet;
		//3 SOU each floor set, 1.5 (rounded) on forbidden runes challenge
			souLeftThisSet = 3 - (LimitedDrops.UPGRADE_SCROLLS.count - (depth / 5) * 3);
		if (souLeftThisSet <= 0) return false;

		int floorThisSet = (depth % 5);
		//chance is floors left / scrolls left
		return Random.Int(5 - floorThisSet) < souLeftThisSet;
	}

	public static boolean asNeeded() {
		//1 AS each floor set
		int asLeftThisSet = 1 - (LimitedDrops.ARCANE_STYLI.count - (depth / 5));
		if (asLeftThisSet <= 0) return false;

		int floorThisSet = (depth % 5);
		//chance is floors left / scrolls left
		return Random.Int(5 - floorThisSet) < asLeftThisSet;
	}

	public static boolean soeNeeded() {
		//1 AS each floor set
		int asLeftThisSet = 1 - (LimitedDrops.STONE_OF_ENCHANTMENT.count - (depth / 5));
		if (asLeftThisSet <= 0) return false;

		int floorThisSet = (depth % 5);
		//chance is floors left / scrolls left
		return Random.Int(5 - floorThisSet) < asLeftThisSet;
	}

	public static boolean sorcNeeded() {
		//1 AS each floor set
		int asLeftThisSet = 1 - (LimitedDrops.ROUTECHANGE_SCROLLS.count - (depth / 5));
		if (asLeftThisSet <= 0) return false;

		int floorThisSet = (depth % 5);
		//chance is floors left / scrolls left
		return Random.Int(5 - floorThisSet) < asLeftThisSet;
	}

	private static final String VERSION		= "version";
	private static final String SEED		= "seed";
	private static final String CHALLENGES	= "challenges";
	private static final String MOBS_TO_CHAMPION	= "mobs_to_champion";
	private static final String HERO		= "hero";
	private static final String GOLD		= "gold";
	private static final String ENERGY		= "energy";
	private static final String DEPTH		= "depth";
	private static final String DROPPED     = "dropped%d";
	private static final String PORTED      = "ported%d";
	private static final String LEVEL		= "level";
	private static final String LIMDROPS    = "limited_drops";
	private static final String CHAPTERS	= "chapters";
	private static final String QUESTS		= "quests";
	private static final String BADGES		= "badges";

	public static void saveGame( int save ) {
		try {
			Bundle bundle = new Bundle();

			version = Game.versionCode;
			bundle.put( VERSION, version );
			bundle.put( SEED, seed );
			bundle.put( CHALLENGES, challenges );
			bundle.put( MOBS_TO_CHAMPION, mobsToChampion );
			bundle.put( HERO, hero );

			bundle.put( GOLD, gold );
			bundle.put( ENERGY, energy );

			bundle.put( DEPTH, depth );

			for (int d : droppedItems.keyArray()) {
				bundle.put(Messages.format(DROPPED, d), droppedItems.get(d));
			}

			for (int p : portedItems.keyArray()){
				bundle.put(Messages.format(PORTED, p), portedItems.get(p));
			}

			quickslot.storePlaceholders( bundle );

			Bundle limDrops = new Bundle();
			LimitedDrops.store( limDrops );
			bundle.put ( LIMDROPS, limDrops );

			int count = 0;
			int ids[] = new int[chapters.size()];
			for (Integer id : chapters) {
				ids[count++] = id;
			}
			bundle.put( CHAPTERS, ids );

			Bundle quests = new Bundle();
			Ghost		.Quest.storeInBundle( quests );
			Wandmaker	.Quest.storeInBundle( quests );
			Blacksmith	.Quest.storeInBundle( quests );
			Imp			.Quest.storeInBundle( quests );
			bundle.put( QUESTS, quests );

			SpecialRoom.storeRoomsInBundle( bundle );
			SecretRoom.storeRoomsInBundle( bundle );

			com.touhoupixel.touhoupixeldungeon.Statistics.storeInBundle( bundle );
			Notes.storeInBundle( bundle );
			Generator.storeInBundle( bundle );

			Scroll.save( bundle );
			Potion.save( bundle );
			Ring.save( bundle );

			Actor.storeNextID( bundle );

			Bundle badges = new Bundle();
			Badges.saveLocal( badges );
			bundle.put( BADGES, badges );

			FileUtils.bundleToFile( GamesInProgress.gameFile(save), bundle);

		} catch (IOException e) {
			GamesInProgress.setUnknown( save );
			TouhouPixelDungeon.reportException(e);
		}
	}

	public static void saveLevel( int save ) throws IOException {
		Bundle bundle = new Bundle();
		bundle.put( LEVEL, level );

		FileUtils.bundleToFile(GamesInProgress.depthFile( save, depth), bundle);
	}

	public static void saveAll() throws IOException {
		if (hero != null && hero.isAlive()) {

			Actor.fixTime();
			saveGame( GamesInProgress.curSlot );
			saveLevel( GamesInProgress.curSlot );

			GamesInProgress.set( GamesInProgress.curSlot, depth, challenges, hero );

		}
	}

	public static void loadGame( int save ) throws IOException {
		loadGame( save, true );
	}

	public static void loadGame( int save, boolean fullLoad ) throws IOException {

		Bundle bundle = FileUtils.bundleFromFile( GamesInProgress.gameFile( save ) );

		version = bundle.getInt( VERSION );

		seed = bundle.contains( SEED ) ? bundle.getLong( SEED ) : DungeonSeed.randomSeed();

		Actor.restoreNextID( bundle );

		quickslot.reset();
		QuickSlotButton.reset();

		Dungeon.challenges = bundle.getInt( CHALLENGES );
		Dungeon.mobsToChampion = bundle.getInt( MOBS_TO_CHAMPION );

		Dungeon.level = null;
		Dungeon.depth = -1;

		Scroll.restore( bundle );
		Potion.restore( bundle );
		Ring.restore( bundle );

		quickslot.restorePlaceholders( bundle );

		if (fullLoad) {

			LimitedDrops.restore( bundle.getBundle(LIMDROPS) );

			chapters = new HashSet<>();
			int ids[] = bundle.getIntArray( CHAPTERS );
			if (ids != null) {
				for (int id : ids) {
					chapters.add( id );
				}
			}

			Bundle quests = bundle.getBundle( QUESTS );
			if (!quests.isNull()) {
				Ghost.Quest.restoreFromBundle( quests );
				Wandmaker.Quest.restoreFromBundle( quests );
				Blacksmith.Quest.restoreFromBundle( quests );
				Imp.Quest.restoreFromBundle( quests );
			} else {
				Ghost.Quest.reset();
				Wandmaker.Quest.reset();
				Blacksmith.Quest.reset();
				Imp.Quest.reset();
			}

			SpecialRoom.restoreRoomsFromBundle(bundle);
			SecretRoom.restoreRoomsFromBundle(bundle);
		}

		Bundle badges = bundle.getBundle(BADGES);
		if (!badges.isNull()) {
			Badges.loadLocal( badges );
		} else {
			Badges.reset();
		}

		Notes.restoreFromBundle( bundle );

		hero = null;
		hero = (Hero)bundle.get( HERO );

		gold = bundle.getInt( GOLD );
		energy = bundle.getInt( ENERGY );

		depth = bundle.getInt( DEPTH );

		com.touhoupixel.touhoupixeldungeon.Statistics.restoreFromBundle( bundle );
		Generator.restoreFromBundle( bundle );

		droppedItems = new SparseArray<>();
		portedItems = new SparseArray<>();
		for (int i=1; i <= 26; i++) {

			//dropped items
			ArrayList<Item> items = new ArrayList<>();
			if (bundle.contains(Messages.format( DROPPED, i )))
				for (Bundlable b : bundle.getCollection( Messages.format( DROPPED, i ) ) ) {
					items.add( (Item)b );
				}
			if (!items.isEmpty()) {
				droppedItems.put( i, items );
			}

			//ported items
			items = new ArrayList<>();
			if (bundle.contains(Messages.format( PORTED, i )))
				for (Bundlable b : bundle.getCollection( Messages.format( PORTED, i ) ) ) {
					items.add( (Item)b );
				}
			if (!items.isEmpty()) {
				portedItems.put( i, items );
			}
		}
	}

	public static Level loadLevel( int save ) throws IOException {

		Dungeon.level = null;
		Actor.clear();

		Bundle bundle = FileUtils.bundleFromFile( GamesInProgress.depthFile( save, depth)) ;

		Level level = (Level)bundle.get( LEVEL );

		if (level == null){
			throw new IOException();
		} else {
			return level;
		}
	}

	public static void deleteGame( int save, boolean deleteLevels ) {

		FileUtils.deleteFile(GamesInProgress.gameFile(save));

		if (deleteLevels) {
			FileUtils.deleteDir(GamesInProgress.gameFolder(save));
		}

		GamesInProgress.delete( save );
	}

	public static void preview( GamesInProgress.Info info, Bundle bundle ) {
		info.depth = bundle.getInt( DEPTH );
		info.version = bundle.getInt( VERSION );
		info.challenges = bundle.getInt( CHALLENGES );
		Hero.preview( info, bundle.getBundle( HERO ) );
		com.touhoupixel.touhoupixeldungeon.Statistics.preview( info, bundle );
	}

	public static void fail( Class cause ) {
		if (hero.belongings.getItem( Ankh.class ) == null) {
			Rankings.INSTANCE.submit( false, cause );
		}
	}

	public static void win( Class cause ) {

		hero.belongings.identify();

		Rankings.INSTANCE.submit( true, cause );
	}

	//default to recomputing based on max hero vision, in case vision just shrank/grew
	public static void observe(){
		int dist = 8;
		dist *= 1f + 0.25f*Dungeon.hero.pointsInTalent(Talent.FARSIGHT);
		observe( dist+1 );
	}

	public static void observe( int dist ) {

		if (level == null) {
			return;
		}

		level.updateFieldOfView(hero, level.heroFOV);

		int x = hero.pos % level.width();
		int y = hero.pos / level.width();

		//left, right, top, bottom
		int l = Math.max( 0, x - dist );
		int r = Math.min( x + dist, level.width() - 1 );
		int t = Math.max( 0, y - dist );
		int b = Math.min( y + dist, level.height() - 1 );

		int width = r - l + 1;
		int height = b - t + 1;

		int pos = l + t * level.width();

		for (int i = t; i <= b; i++) {
			BArray.or( level.visited, level.heroFOV, pos, width, level.visited );
			pos+=level.width();
		}

		GameScene.updateFog(l, t, width, height);

		if (hero.buff(MindVision.class) != null){
			for (Mob m : level.mobs.toArray(new Mob[0])){
				BArray.or( level.visited, level.heroFOV, m.pos - 1 - level.width(), 3, level.visited );
				BArray.or( level.visited, level.heroFOV, m.pos, 3, level.visited );
				BArray.or( level.visited, level.heroFOV, m.pos - 1 + level.width(), 3, level.visited );
				//updates adjacent cells too
				GameScene.updateFog(m.pos, 2);
			}
		}

		if (hero.buff(Awareness.class) != null){
			for (Heap h : level.heaps.valueList()){
				BArray.or( level.visited, level.heroFOV, h.pos - 1 - level.width(), 3, level.visited );
				BArray.or( level.visited, level.heroFOV, h.pos - 1, 3, level.visited );
				BArray.or( level.visited, level.heroFOV, h.pos - 1 + level.width(), 3, level.visited );
				GameScene.updateFog(h.pos, 2);
			}
		}

		for (TalismanOfForesight.CharAwareness c : hero.buffs(TalismanOfForesight.CharAwareness.class)){
			Char ch = (Char) Actor.findById(c.charID);
			if (ch == null) continue;
			BArray.or( level.visited, level.heroFOV, ch.pos - 1 - level.width(), 3, level.visited );
			BArray.or( level.visited, level.heroFOV, ch.pos - 1, 3, level.visited );
			BArray.or( level.visited, level.heroFOV, ch.pos - 1 + level.width(), 3, level.visited );
			GameScene.updateFog(ch.pos, 2);
		}

		for (TalismanOfForesight.HeapAwareness h : hero.buffs(TalismanOfForesight.HeapAwareness.class)){
			if (Dungeon.depth != h.depth) continue;
			BArray.or( level.visited, level.heroFOV, h.pos - 1 - level.width(), 3, level.visited );
			BArray.or( level.visited, level.heroFOV, h.pos - 1, 3, level.visited );
			BArray.or( level.visited, level.heroFOV, h.pos - 1 + level.width(), 3, level.visited );
			GameScene.updateFog(h.pos, 2);
		}

		for (RevealedArea a : hero.buffs(RevealedArea.class)){
			if (Dungeon.depth != a.depth) continue;
			BArray.or( level.visited, level.heroFOV, a.pos - 1 - level.width(), 3, level.visited );
			BArray.or( level.visited, level.heroFOV, a.pos - 1, 3, level.visited );
			BArray.or( level.visited, level.heroFOV, a.pos - 1 + level.width(), 3, level.visited );
			GameScene.updateFog(a.pos, 2);
		}

		for (Char ch : Actor.chars()){
			if (ch instanceof WandOfWarding.Ward
					|| ch instanceof WandOfRegrowth.Lotus){
				x = ch.pos % level.width();
				y = ch.pos / level.width();

				//left, right, top, bottom
				dist = ch.viewDistance+1;
				l = Math.max( 0, x - dist );
				r = Math.min( x + dist, level.width() - 1 );
				t = Math.max( 0, y - dist );
				b = Math.min( y + dist, level.height() - 1 );

				width = r - l + 1;
				height = b - t + 1;

				pos = l + t * level.width();

				for (int i = t; i <= b; i++) {
					BArray.or( level.visited, level.heroFOV, pos, width, level.visited );
					pos+=level.width();
				}
				GameScene.updateFog(ch.pos, dist);
			}
		}


		GameScene.afterObserve();
	}

	//we store this to avoid having to re-allocate the array with each pathfind
	private static boolean[] passable;

	private static void setupPassable(){
		if (passable == null || passable.length != Dungeon.level.length())
			passable = new boolean[Dungeon.level.length()];
		else
			BArray.setFalse(passable);
	}

	public static PathFinder.Path findPath(Char ch, int to, boolean[] pass, boolean[] vis, boolean chars) {

		setupPassable();
		if (ch.flying || ch.buff( Amok.class ) != null) {
			BArray.or( pass, Dungeon.level.avoid, passable );
		} else {
			System.arraycopy( pass, 0, passable, 0, Dungeon.level.length() );
		}

		if (chars && Char.hasProp(ch, Char.Property.LARGE)){
			BArray.and( passable, Dungeon.level.openSpace, passable );
		}

		if (chars) {
			for (Char c : Actor.chars()) {
				if (vis[c.pos]) {
					passable[c.pos] = false;
				}
			}
		}

		return PathFinder.find( ch.pos, to, passable );

	}

	public static int findStep(Char ch, int to, boolean[] pass, boolean[] visible, boolean chars ) {

		if (Dungeon.level.adjacent( ch.pos, to )) {
			return Actor.findChar( to ) == null && (pass[to] || Dungeon.level.avoid[to]) ? to : -1;
		}

		setupPassable();
		if (ch.flying || ch.buff( Amok.class ) != null) {
			BArray.or( pass, Dungeon.level.avoid, passable );
		} else {
			System.arraycopy( pass, 0, passable, 0, Dungeon.level.length() );
		}

		if (Char.hasProp(ch, Char.Property.LARGE)){
			BArray.and( passable, Dungeon.level.openSpace, passable );
		}

		if (chars){
			for (Char c : Actor.chars()) {
				if (visible[c.pos]) {
					passable[c.pos] = false;
				}
			}
		}

		return PathFinder.getStep( ch.pos, to, passable );

	}

	public static int flee( Char ch, int from, boolean[] pass, boolean[] visible, boolean chars ) {

		setupPassable();
		if (ch.flying) {
			BArray.or( pass, Dungeon.level.avoid, passable );
		} else {
			System.arraycopy( pass, 0, passable, 0, Dungeon.level.length() );
		}

		if (Char.hasProp(ch, Char.Property.LARGE)){
			BArray.and( passable, Dungeon.level.openSpace, passable );
		}

		passable[ch.pos] = true;

		//only consider chars impassable if our retreat path runs into them
		int step = PathFinder.getStepBack( ch.pos, from, passable );
		while (step != -1 && Actor.findChar(step) != null){
			passable[step] = false;
			step = PathFinder.getStepBack( ch.pos, from, passable );
		}
		return step;

	}

}