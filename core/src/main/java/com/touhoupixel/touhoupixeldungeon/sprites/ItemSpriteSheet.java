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

package com.touhoupixel.touhoupixeldungeon.sprites;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YukinaMic;
import com.watabou.noosa.TextureFilm;

public class ItemSpriteSheet {

	private static final int WIDTH = 16;
	public static final int SIZE = 16;

	public static TextureFilm film = new TextureFilm( Assets.Sprites.ITEMS, SIZE, SIZE );

	private static int xy(int x, int y){
		x -= 1; y -= 1;
		return x + WIDTH*y;
	}

	private static void assignItemRect( int item, int width, int height ){
		int x = (item % WIDTH) * SIZE;
		int y = (item / WIDTH) * SIZE;
		film.add( item, x, y, x+width, y+height);
	}

	private static final int PLACEHOLDERS   =                               xy(1, 1);   //16 slots
	//SOMETHING is the default item sprite at position 0. May show up ingame if there are bugs.
	public static final int SOMETHING       = PLACEHOLDERS+0;
	public static final int WEAPON_HOLDER   = PLACEHOLDERS+1;
	public static final int ARMOR_HOLDER    = PLACEHOLDERS+2;
	public static final int MISSILE_HOLDER  = PLACEHOLDERS+3;
	public static final int WAND_HOLDER     = PLACEHOLDERS+4;
	public static final int RING_HOLDER     = PLACEHOLDERS+5;
	public static final int ARTIFACT_HOLDER = PLACEHOLDERS+6;
	public static final int FOOD_HOLDER     = PLACEHOLDERS+7;
	public static final int BOMB_HOLDER     = PLACEHOLDERS+8;
	public static final int POTION_HOLDER   = PLACEHOLDERS+9;
	public static final int SCROLL_HOLDER   = PLACEHOLDERS+11;
	public static final int SEED_HOLDER     = PLACEHOLDERS+10;
	public static final int STONE_HOLDER    = PLACEHOLDERS+12;
	public static final int CATA_HOLDER     = PLACEHOLDERS+13;
	public static final int ELIXIR_HOLDER   = PLACEHOLDERS+14;
	public static final int SPELL_HOLDER    = PLACEHOLDERS+15;
	static{
		assignItemRect(SOMETHING,       8,  13);
		assignItemRect(WEAPON_HOLDER,   14, 14);
		assignItemRect(ARMOR_HOLDER,    14, 12);
		assignItemRect(MISSILE_HOLDER,  15, 15);
		assignItemRect(WAND_HOLDER,     14, 14);
		assignItemRect(RING_HOLDER,     8,  10);
		assignItemRect(ARTIFACT_HOLDER, 15, 15);
		assignItemRect(FOOD_HOLDER,     15, 11);
		assignItemRect(BOMB_HOLDER,     10, 13);
		assignItemRect(POTION_HOLDER,   12, 14);
		assignItemRect(SEED_HOLDER,     10, 10);
		assignItemRect(SCROLL_HOLDER,   15, 14);
		assignItemRect(STONE_HOLDER,    14, 12);
		assignItemRect(CATA_HOLDER,     6,  15);
		assignItemRect(ELIXIR_HOLDER,   12, 14);
		assignItemRect(SPELL_HOLDER,    8,  16);
	}

	private static final int UNCOLLECTIBLE  =                               xy(1, 2);   //16 slots
	public static final int GOLD            = UNCOLLECTIBLE+0;
	public static final int DEWDROP         = UNCOLLECTIBLE+1;
	public static final int PETAL           = UNCOLLECTIBLE+2;
	public static final int SANDBAG         = UNCOLLECTIBLE+3;
	public static final int SPIRIT_ARROW    = UNCOLLECTIBLE+4;
	public static final int ENERGY          = UNCOLLECTIBLE+5;

	public static final int GUIDE_PAGE      = UNCOLLECTIBLE+6;
	public static final int ALCH_PAGE       = UNCOLLECTIBLE+7;

	public static final int TENGU_BOMB      = UNCOLLECTIBLE+9;
	public static final int TENGU_SHOCKER   = UNCOLLECTIBLE+10;
	static{
		assignItemRect(GOLD,        12, 12);
		assignItemRect(DEWDROP,     10, 10);
		assignItemRect(PETAL,       8,  8);
		assignItemRect(SANDBAG,     16, 16);
		assignItemRect(SPIRIT_ARROW,16, 15);
		assignItemRect(ENERGY,      16, 16);

		assignItemRect(GUIDE_PAGE,  12, 12);
		assignItemRect(ALCH_PAGE,   12, 12);

		assignItemRect(TENGU_BOMB,      10, 10);
		assignItemRect(TENGU_SHOCKER,   10, 10);
	}

	private static final int CONTAINERS     =                               xy(1, 3);   //16 slots
	public static final int BONES           = CONTAINERS+0;
	public static final int REMAINS         = CONTAINERS+1;
	public static final int TOMB            = CONTAINERS+2;
	public static final int GRAVE           = CONTAINERS+3;
	public static final int CHEST           = CONTAINERS+4;
	public static final int LOCKED_CHEST    = CONTAINERS+5;
	public static final int CRYSTAL_CHEST   = CONTAINERS+6;
	public static final int EBONY_CHEST     = CONTAINERS+7;
	static{
		assignItemRect(BONES,           15, 14);
		assignItemRect(REMAINS,         15, 14);
		assignItemRect(TOMB,            15, 14);
		assignItemRect(GRAVE,           15, 14);
		assignItemRect(CHEST,           15, 14);
		assignItemRect(LOCKED_CHEST,    15, 14);
		assignItemRect(CRYSTAL_CHEST,   15, 14);
		assignItemRect(EBONY_CHEST,     15, 14);
	}

	private static final int MISC_CONSUMABLE =                              xy(1, 4);   //16 slots
	public static final int ANKH            = MISC_CONSUMABLE +0;
	public static final int STYLUS          = MISC_CONSUMABLE +1;
	public static final int SEAL            = MISC_CONSUMABLE +2;
	public static final int TORCH           = MISC_CONSUMABLE +3;
	public static final int BEACON          = MISC_CONSUMABLE +4;
	public static final int HONEYPOT        = MISC_CONSUMABLE +5;
	public static final int SHATTPOT        = MISC_CONSUMABLE +6;
	public static final int IRON_KEY        = MISC_CONSUMABLE +7;
	public static final int GOLDEN_KEY      = MISC_CONSUMABLE +8;
	public static final int CRYSTAL_KEY     = MISC_CONSUMABLE +9;
	public static final int SKELETON_KEY    = MISC_CONSUMABLE +10;
	public static final int MASK            = MISC_CONSUMABLE +11;
	public static final int CROWN           = MISC_CONSUMABLE +12;
	public static final int AMULET          = MISC_CONSUMABLE +13;
	public static final int MASTERY         = MISC_CONSUMABLE +14;
	public static final int KIT             = MISC_CONSUMABLE +15;
	static{
		assignItemRect(ANKH,            16, 15);
		assignItemRect(STYLUS,          10, 10);

		assignItemRect(SEAL,            9,  15);
		assignItemRect(TORCH,           12, 15);
		assignItemRect(BEACON,          16, 15);

		assignItemRect(HONEYPOT,        14, 12);
		assignItemRect(SHATTPOT,        14, 12);
		assignItemRect(IRON_KEY,        8,  14);
		assignItemRect(GOLDEN_KEY,      8,  14);
		assignItemRect(CRYSTAL_KEY,     8,  14);
		assignItemRect(SKELETON_KEY,    8,  14);
		assignItemRect(MASK,            11,  9);
		assignItemRect(CROWN,           13,  7);
		assignItemRect(AMULET,          12, 12);
		assignItemRect(MASTERY,         13, 16);
		assignItemRect(KIT,             16, 15);
	}

	private static final int BOMBS          =                               xy(1, 5);   //16 slots
	public static final int BOMB            = BOMBS+0;
	public static final int DBL_BOMB        = BOMBS+1;
	public static final int FIRE_BOMB       = BOMBS+2;
	public static final int FROST_BOMB      = BOMBS+3;
	public static final int REGROWTH_BOMB   = BOMBS+4;
	public static final int FLASHBANG       = BOMBS+5;
	public static final int SHOCK_BOMB      = BOMBS+6;
	public static final int HOLY_BOMB       = BOMBS+7;
	public static final int WOOLY_BOMB      = BOMBS+8;
	public static final int NOISEMAKER      = BOMBS+9;
	public static final int ARCANE_BOMB     = BOMBS+10;
	public static final int SHRAPNEL_BOMB   = BOMBS+11;
	public static final int POTION_CONFUSION   = BOMBS+12;
	public static final int SCROLL_CONFUSION   = BOMBS+13;

	static{
		assignItemRect(BOMB,            10, 13);
		assignItemRect(DBL_BOMB,        14, 13);
		assignItemRect(FIRE_BOMB,       13, 12);
		assignItemRect(FROST_BOMB,      13, 12);
		assignItemRect(REGROWTH_BOMB,   13, 12);
		assignItemRect(FLASHBANG,       13, 12);
		assignItemRect(SHOCK_BOMB,      10, 13);
		assignItemRect(HOLY_BOMB,       10, 13);
		assignItemRect(WOOLY_BOMB,      10, 13);
		assignItemRect(NOISEMAKER,      10, 13);
		assignItemRect(ARCANE_BOMB,     10, 13);
		assignItemRect(SHRAPNEL_BOMB,   10, 13);
		assignItemRect(POTION_CONFUSION,   10, 15);
		assignItemRect(SCROLL_CONFUSION,   11, 15);
	}

	private static final int TAILSMANS          =                               xy(1, 6);   //16 slots
	public static final int BIND            = TAILSMANS+0;
	public static final int BLOWAWAY        = TAILSMANS+1;
	public static final int CHAOS       = TAILSMANS+2;
	public static final int DECOY      = TAILSMANS+3;
	public static final int EXPLOSION   = TAILSMANS+4;
	public static final int FOGPURGE       = TAILSMANS+5;
	public static final int IMPEDE      = TAILSMANS+6;
	public static final int INCOMPETENCE       = TAILSMANS+7;
	public static final int SWAP      = TAILSMANS+8;
	public static final int TORMENT      = TAILSMANS+9;

	static{
		assignItemRect(BIND,            14, 16);
		assignItemRect(BLOWAWAY,        14, 16);
		assignItemRect(CHAOS,       14, 16);
		assignItemRect(DECOY,      14, 16);
		assignItemRect(EXPLOSION,   14, 16);
		assignItemRect(FOGPURGE,       14, 16);
		assignItemRect(IMPEDE,      14, 16);
		assignItemRect(INCOMPETENCE,       14, 16);
		assignItemRect(SWAP,      14, 16);
		assignItemRect(TORMENT,      14, 16);
	}


	//16 free slots

	private static final int WEP_TIER1      =                               xy(1, 7);   //8 slots
	public static final int WORN_SHORTSWORD = WEP_TIER1+0;
	public static final int KYOUKO_BROOM     = WEP_TIER1+1;
	public static final int GLOVES          = WEP_TIER1+2;
	public static final int YOUMU_SWORD      = WEP_TIER1+3;
	public static final int DAGGER          = WEP_TIER1+4;
	public static final int MAGES_STAFF     = WEP_TIER1+5;
	public static final int JEWELED_PAGODA   = WEP_TIER1+6;
	public static final int NITORI_ROD       = WEP_TIER1+7;
	static{
		assignItemRect(WORN_SHORTSWORD, 13, 13);
		assignItemRect(KYOUKO_BROOM,    13, 13);
		assignItemRect(GLOVES,          13, 13);
		assignItemRect(YOUMU_SWORD,     13, 13);
		assignItemRect(DAGGER,          13, 13);
		assignItemRect(MAGES_STAFF,     13, 13);
		assignItemRect(JEWELED_PAGODA,  11, 15);
		assignItemRect(NITORI_ROD,      13, 13);
	}

	private static final int WEP_TIER2      =                               xy(9, 7);   //8 slots
	public static final int SHORTSWORD      = WEP_TIER2+0;
	public static final int HAND_AXE        = WEP_TIER2+1;
	public static final int SPEAR           = WEP_TIER2+2;
	public static final int QUARTERSTAFF    = WEP_TIER2+3;
	public static final int DIRK            = WEP_TIER2+4;
	public static final int RINGODANGO      = WEP_TIER2+5;
	public static final int SILKYHAIR       = WEP_TIER2+6;
	public static final int NAZRINROD       = WEP_TIER2+7;
	static{
		assignItemRect(SHORTSWORD,      11, 13);
		assignItemRect(HAND_AXE,        7, 13);
		assignItemRect(SPEAR,           6, 9);
		assignItemRect(QUARTERSTAFF,    13, 13);
		assignItemRect(DIRK,            12, 13);
		assignItemRect(RINGODANGO,      13, 13);
		assignItemRect(SILKYHAIR,       13, 13);
		assignItemRect(NAZRINROD,       13, 13);
	}

	private static final int WEP_TIER3      =                               xy(1, 8);   //8 slots
	public static final int SWORD           = WEP_TIER3+0;
	public static final int MACE            = WEP_TIER3+1;
	public static final int SCIMITAR        = WEP_TIER3+2;
	public static final int ROUND_SHIELD    = WEP_TIER3+3;
	public static final int SAI             = WEP_TIER3+4;
	public static final int WHIP            = WEP_TIER3+5;
	public static final int AKYUUBRUSH      = WEP_TIER3+6;
	public static final int PURIFICATIONROD = WEP_TIER3+7;
	static{
		assignItemRect(SWORD,           9, 9);
		assignItemRect(MACE,            13, 13);
		assignItemRect(SCIMITAR,        13, 13);
		assignItemRect(ROUND_SHIELD,    14, 13);
		assignItemRect(SAI,             13, 13);
		assignItemRect(WHIP,            13, 13);
		assignItemRect(AKYUUBRUSH,      13, 13);
		assignItemRect(PURIFICATIONROD, 13, 13);
	}

	private static final int WEP_TIER4      =                               xy(9, 8);   //8 slots
	public static final int LONGSWORD     = WEP_TIER4+0;
	public static final int BATTLE_AXE      = WEP_TIER4+1;
	public static final int FLAIL           = WEP_TIER4+2;
	public static final int CROSSBOW       = WEP_TIER4+3;
	public static final int ASSASSINS_BLADE = WEP_TIER4+4;
	public static final int RUNIC_BLADE        = WEP_TIER4+5;
	public static final int YUYUKOFOLDINGFAN= WEP_TIER4+6;
	public static final int MURASADIPPER    = WEP_TIER4+7;
	static{
		assignItemRect(LONGSWORD,     12, 12);
		assignItemRect(BATTLE_AXE,      13, 13);
		assignItemRect(FLAIL,           13, 13);
		assignItemRect(CROSSBOW,       13, 13);
		assignItemRect(ASSASSINS_BLADE, 9, 9);
		assignItemRect(RUNIC_BLADE,        13, 13);
		assignItemRect(YUYUKOFOLDINGFAN,10, 10);
		assignItemRect(MURASADIPPER,    13, 13);
	}

	private static final int WEP_TIER5      =                               xy(1, 9);   //8 slots
	public static final int WAR_HAMMER      = WEP_TIER5+0;
	public static final int GREATSWORD      = WEP_TIER5+1;
	public static final int GLAIVE          = WEP_TIER5+2;
	public static final int GREATAXE        = WEP_TIER5+3;
	public static final int GREATSHIELD     = WEP_TIER5+4;
	public static final int GAUNTLETS       = WEP_TIER5+5;
	public static final int SWORDOFHISOU    = WEP_TIER5+6;
	public static final int MIRACLEROD      = WEP_TIER5+7;
	public static final int KOMACHISCYTHE   = WEP_TIER5+8;
	public static final int FULLMOONSCYTHE       = WEP_TIER5+9;
	public static final int JEWELEDBRANCH   = WEP_TIER5+10;
	public static final int DOREMY_DREAM    = WEP_TIER5+11;
	public static final int KOKOROFAN       = WEP_TIER5+12;
	public static final int LOG             = WEP_TIER5+13;
	public static final int TOYOHIME_FAN    = WEP_TIER5+14;
	public static final int YORIHIME_SWORD  = WEP_TIER5+15;
	public static final int MIRACLE_MALLET    = WEP_TIER5+64;
	public static final int KOGASA_ROD    = WEP_TIER5+65;
	public static final int TORAMARU_SPEAR    = WEP_TIER5+66;
	public static final int ENMA_SHAKU    = WEP_TIER5+67;
	public static final int SEVEN_STAR_SWORD    = WEP_TIER5+68;
	public static final int WATERMELON_SWORD    = WEP_TIER5+69;
	public static final int FLINTLOCK   = WEP_TIER5+70;
	public static final int MOMOYO_SHOVEL    = WEP_TIER5+71;
	public static final int WINDGOD_FAN    = WEP_TIER5+72;
	public static final int SAGUME_WING    = WEP_TIER5+73;
	public static final int HISOUTEN_MANKIND    = WEP_TIER5+74;
	public static final int KOISHI_SWORD    = WEP_TIER5+75;
	public static final int HECATIA_STAR    = WEP_TIER5+76;
	public static final int YUUKA_UMBRELLA  = WEP_TIER5+77;
	public static final int PHOENIX_TAIL    = WEP_TIER5+78;
	public static final int LEVATEIN        = WEP_TIER5+79;
	public static final int FIREBRAND        = WEP_TIER5+368;
	public static final int FROSTBRAND        = WEP_TIER5+369;
	public static final int BLAZING_STAR        = WEP_TIER5+370;
	public static final int WOODEN_BAT        = WEP_TIER5+371;
	public static final int HOSHIGUMA_HORN        = WEP_TIER5+372;
	public static final int ARISA_KEYBOARD        = WEP_TIER5+373;
	public static final int TURNABOUT_CLOAK        = WEP_TIER5+374;
	public static final int DOUBLE_SWORD        = WEP_TIER5+375;
	public static final int AUTUMN_KATANA        = WEP_TIER5+377;
	public static final int GRAYSWANDIR        = WEP_TIER5+378;
	public static final int YUKINA_MIC        = WEP_TIER5+381;
	public static final int PLAY_MAT        = WEP_TIER5+383;
	static{
		assignItemRect(WAR_HAMMER,   13, 13);
		assignItemRect(GREATSWORD,   12, 12);
		assignItemRect(GLAIVE,       8, 12);
		assignItemRect(GREATAXE,     12, 13);
		assignItemRect(GREATSHIELD,  13, 13);
		assignItemRect(GAUNTLETS,    13, 13);
		assignItemRect(SWORDOFHISOU, 13, 13);
		assignItemRect(MIRACLEROD,   13, 13);
		assignItemRect(KOMACHISCYTHE,16, 13);
		assignItemRect(FULLMOONSCYTHE,    16, 13);
		assignItemRect(JEWELEDBRANCH, 13, 13);
		assignItemRect(DOREMY_DREAM,  14, 13);
		assignItemRect(KOKOROFAN,     10, 10);
		assignItemRect(LOG,           13, 13);
		assignItemRect(TOYOHIME_FAN,  10, 10);
		assignItemRect(YORIHIME_SWORD,13, 13);
		assignItemRect(HECATIA_STAR,  14, 15);
		assignItemRect(YUUKA_UMBRELLA,14, 14);
		assignItemRect(PHOENIX_TAIL,  12, 13);
		assignItemRect(LEVATEIN,      13, 13);
		assignItemRect(MIRACLE_MALLET,      12, 13);
		assignItemRect(KOGASA_ROD,      13, 13);
		assignItemRect(TORAMARU_SPEAR,      13, 13);
		assignItemRect(ENMA_SHAKU,      13, 13);
		assignItemRect(SEVEN_STAR_SWORD,      13, 13);
		assignItemRect(WATERMELON_SWORD,      13, 13);
		assignItemRect(FLINTLOCK,      13, 13);
		assignItemRect(MOMOYO_SHOVEL,      13, 13);
		assignItemRect(WINDGOD_FAN,      13, 13);
		assignItemRect(SAGUME_WING,      13, 13);
		assignItemRect(HISOUTEN_MANKIND,      13, 13);
		assignItemRect(KOISHI_SWORD,      13, 13);
		assignItemRect(FIREBRAND,      13, 13);
		assignItemRect(FROSTBRAND,      13, 13);
		assignItemRect(BLAZING_STAR,      13, 13);
		assignItemRect(WOODEN_BAT,      13, 13);
		assignItemRect(HOSHIGUMA_HORN,      13, 13);
		assignItemRect(ARISA_KEYBOARD,      13, 13);
		assignItemRect(TURNABOUT_CLOAK,      14, 14);
		assignItemRect(DOUBLE_SWORD,      13, 13);
		assignItemRect(AUTUMN_KATANA,      13, 13);
		assignItemRect(GRAYSWANDIR,      13, 13);
		assignItemRect(YUKINA_MIC,      13, 13);
		assignItemRect(PLAY_MAT,      13, 13);
	}

	//8 free slots

	private static final int MISSILE_WEP    =                               xy(1, 10);  //16 slots. 3 per tier + boomerang
	public static final int SPIRIT_BOW      = MISSILE_WEP+0;

	public static final int DART            = MISSILE_WEP+1;
	public static final int THROWING_KNIFE  = MISSILE_WEP+2;
	public static final int THROWING_STONE  = MISSILE_WEP+3;

	public static final int FISHING_SPEAR   = MISSILE_WEP+4;
	public static final int SHURIKEN        = MISSILE_WEP+5;
	public static final int THROWING_CLUB   = MISSILE_WEP+6;

	public static final int THROWING_SPEAR  = MISSILE_WEP+7;
	public static final int BOLAS           = MISSILE_WEP+8;
	public static final int KUNAI           = MISSILE_WEP+9;

	public static final int JAVELIN         = MISSILE_WEP+10;
	public static final int TOMAHAWK        = MISSILE_WEP+11;
	public static final int BOOMERANG       = MISSILE_WEP+12;

	public static final int TRIDENT         = MISSILE_WEP+13;
	public static final int THROWING_HAMMER = MISSILE_WEP+14;
	public static final int FORCE_CUBE      = MISSILE_WEP+15;

	static{
		assignItemRect(SPIRIT_BOW,      16, 15);

		assignItemRect(DART,            15, 15);
		assignItemRect(THROWING_KNIFE,  13, 13);
		assignItemRect(THROWING_STONE,  14, 16);

		assignItemRect(FISHING_SPEAR,   8, 13);
		assignItemRect(SHURIKEN,        12, 15);
		assignItemRect(THROWING_CLUB,   16, 16);

		assignItemRect(THROWING_SPEAR,  8, 16);
		assignItemRect(BOLAS,           8, 16);
		assignItemRect(KUNAI,           8, 16);

		assignItemRect(JAVELIN,         16, 16);
		assignItemRect(TOMAHAWK,        15, 16);
		assignItemRect(BOOMERANG,       16, 16);

		assignItemRect(TRIDENT,         16, 15);
		assignItemRect(THROWING_HAMMER, 10, 13);
		assignItemRect(FORCE_CUBE,      13, 14);
	}

	public static final int TIPPED_DARTS    =                               xy(1, 11);  //16 slots
	public static final int ROT_DART        = TIPPED_DARTS+0;
	public static final int INCENDIARY_DART = TIPPED_DARTS+1;
	public static final int ADRENALINE_DART = TIPPED_DARTS+2;
	public static final int HEALING_DART    = TIPPED_DARTS+3;
	public static final int CHILLING_DART   = TIPPED_DARTS+4;
	public static final int SHOCKING_DART   = TIPPED_DARTS+5;
	public static final int POISON_DART     = TIPPED_DARTS+6;
	public static final int SLEEP_DART      = TIPPED_DARTS+7;
	public static final int PARALYTIC_DART  = TIPPED_DARTS+8;
	public static final int HOLY_DART       = TIPPED_DARTS+9;
	public static final int DISPLACING_DART = TIPPED_DARTS+10;
	public static final int BLINDING_DART   = TIPPED_DARTS+11;
	static {
		for (int i = TIPPED_DARTS; i < TIPPED_DARTS+16; i++)
			assignItemRect(i, 15, 15);
	}

	private static final int ARMOR          =                               xy(1, 12);  //16 slots
	public static final int ARMOR_CLOTH     = ARMOR+0;
	public static final int ARMOR_LEATHER   = ARMOR+1;
	public static final int ARMOR_MAIL      = ARMOR+2;
	public static final int ARMOR_SCALE     = ARMOR+3;
	public static final int ARMOR_PLATE     = ARMOR+4;
	public static final int ARMOR_PC98REIMU   = ARMOR+5;
	public static final int ARMOR_PC98MARISA      = ARMOR+6;
	public static final int ARMOR_YORIHIME    = ARMOR+7;
	public static final int ARMOR_TOYOHIME  = ARMOR+8;
	public static final int ARMOR_RUMIA    = ARMOR+9;
	public static final int ARMOR_HANASAKIGAWA    = ARMOR+10;
	public static final int ARMOR_YUYUKO    = ARMOR+11;
	public static final int ARMOR_HECATIA    = ARMOR+12;
	public static final int ARMOR_POPPINPARTY    = ARMOR+13;
	public static final int ARMOR_MAXWELL    = ARMOR+14;
	public static final int ARMOR_GOLDENDRAGON    = ARMOR+15;
	static{
		assignItemRect(ARMOR_CLOTH,     9, 13);
		assignItemRect(ARMOR_LEATHER,   9, 13);
		assignItemRect(ARMOR_MAIL,      9, 13);
		assignItemRect(ARMOR_SCALE,     9, 13);
		assignItemRect(ARMOR_PLATE,     9, 13);
		assignItemRect(ARMOR_PC98REIMU,   9, 13);
		assignItemRect(ARMOR_PC98MARISA,      9, 13);
		assignItemRect(ARMOR_YORIHIME,     9, 13);
		assignItemRect(ARMOR_TOYOHIME,  9, 13);
		assignItemRect(ARMOR_RUMIA,    9, 13);
		assignItemRect(ARMOR_HANASAKIGAWA,    9, 13);
		assignItemRect(ARMOR_YUYUKO,    9, 13);
		assignItemRect(ARMOR_HECATIA,    9, 13);
		assignItemRect(ARMOR_POPPINPARTY,    9, 13);
		assignItemRect(ARMOR_MAXWELL,    9, 13);
		assignItemRect(ARMOR_GOLDENDRAGON,    9, 13);
	}

	//16 free slots

	private static final int WANDS              =                           xy(1, 14);  //16 slots
	public static final int WAND_MAGIC_MISSILE  = WANDS+0;
	public static final int WAND_FIREBOLT       = WANDS+1;
	public static final int WAND_FROST          = WANDS+2;
	public static final int WAND_LIGHTNING      = WANDS+3;
	public static final int WAND_DISINTEGRATION = WANDS+4;
	public static final int WAND_PRISMATIC_LIGHT= WANDS+5;
	public static final int WAND_CORROSION      = WANDS+6;
	public static final int WAND_LIVING_EARTH   = WANDS+7;
	public static final int WAND_BLAST_WAVE     = WANDS+8;
	public static final int WAND_CORRUPTION     = WANDS+9;
	public static final int WAND_WARDING        = WANDS+10;
	public static final int WAND_REGROWTH       = WANDS+11;
	public static final int WAND_TRANSFUSION    = WANDS+12;
	public static final int WAND_REVERSEGRAVITY    = WANDS+13;
	public static final int WAND_ANTIDOOR    = WANDS+14;
	public static final int WAND_ANTIEMBER    = WANDS+15;
	public static final int WAND_WISHING    = WANDS+304;
	public static final int WAND_HEALWOUNDS    = WANDS+305;
	public static final int WAND_DESTORB    = WANDS+306;
	public static final int WAND_DEATH    = WANDS+307;
	static {
		for (int i = WANDS; i < WANDS+308; i++)
			assignItemRect(i, 14, 14);
	}

	private static final int RINGS          =                               xy(1, 15);  //16 slots
	public static final int RING_GARNET     = RINGS+0;
	public static final int RING_RUBY       = RINGS+1;
	public static final int RING_TOPAZ      = RINGS+2;
	public static final int RING_EMERALD    = RINGS+3;
	public static final int RING_ONYX       = RINGS+4;
	public static final int RING_OPAL       = RINGS+5;
	public static final int RING_TOURMALINE = RINGS+6;
	public static final int RING_SAPPHIRE   = RINGS+7;
	public static final int RING_AMETHYST   = RINGS+8;
	public static final int RING_QUARTZ     = RINGS+9;
	public static final int RING_AGATE      = RINGS+10;
	public static final int RING_DIAMOND    = RINGS+11;
	public static final int RING_RED    = RINGS+12;
	public static final int RING_YELLOW    = RINGS+13;
	public static final int RING_GREEN    = RINGS+14;
	public static final int RING_SKY    = RINGS+15;
	public static final int RING_BLACK    = RINGS+176;
	static {
		for (int i = RINGS; i < RINGS+177; i++)
			assignItemRect(i, 8, 10);
	}

	private static final int ARTIFACTS          =                            xy(1, 16);  //32 slots
	public static final int ARTIFACT_CLOAK      = ARTIFACTS+0;
	public static final int ARTIFACT_ARMBAND    = ARTIFACTS+1;
	public static final int ARTIFACT_CAPE       = ARTIFACTS+2;
	public static final int ARTIFACT_TALISMAN   = ARTIFACTS+3;
	public static final int ARTIFACT_HOURGLASS  = ARTIFACTS+4;
	public static final int ARTIFACT_TOOLKIT    = ARTIFACTS+5;
	public static final int ARTIFACT_SPELLBOOK  = ARTIFACTS+6;
	public static final int ARTIFACT_BEACON     = ARTIFACTS+7;
	public static final int ARTIFACT_CHAINS     = ARTIFACTS+8;
	public static final int ARTIFACT_HORN1      = ARTIFACTS+9;
	public static final int ARTIFACT_HORN2      = ARTIFACTS+10;
	public static final int ARTIFACT_HORN3      = ARTIFACTS+11;
	public static final int ARTIFACT_HORN4      = ARTIFACTS+12;
	public static final int ARTIFACT_CHALICE1   = ARTIFACTS+13;
	public static final int ARTIFACT_CHALICE2   = ARTIFACTS+14;
	public static final int ARTIFACT_CHALICE3   = ARTIFACTS+15;
	public static final int ARTIFACT_SANDALS    = ARTIFACTS+16;
	public static final int ARTIFACT_SHOES      = ARTIFACTS+17;
	public static final int ARTIFACT_BOOTS      = ARTIFACTS+18;
	public static final int ARTIFACT_GREAVES    = ARTIFACTS+19;
	public static final int ARTIFACT_ROSE1      = ARTIFACTS+20;
	public static final int ARTIFACT_ROSE2      = ARTIFACTS+21;
	public static final int ARTIFACT_ROSE3      = ARTIFACTS+22;
	static{
		assignItemRect(ARTIFACT_CLOAK,      9,  15);
		assignItemRect(ARTIFACT_ARMBAND,    16, 13);
		assignItemRect(ARTIFACT_CAPE,       16, 14);
		assignItemRect(ARTIFACT_TALISMAN,   15, 13);
		assignItemRect(ARTIFACT_HOURGLASS,  13, 16);
		assignItemRect(ARTIFACT_TOOLKIT,    15, 13);
		assignItemRect(ARTIFACT_SPELLBOOK,  13, 16);
		assignItemRect(ARTIFACT_BEACON,     16, 16);
		assignItemRect(ARTIFACT_CHAINS,     16, 16);
		assignItemRect(ARTIFACT_HORN1,      15, 15);
		assignItemRect(ARTIFACT_HORN2,      15, 15);
		assignItemRect(ARTIFACT_HORN3,      15, 15);
		assignItemRect(ARTIFACT_HORN4,      15, 15);
		assignItemRect(ARTIFACT_CHALICE1,   12, 15);
		assignItemRect(ARTIFACT_CHALICE2,   12, 15);
		assignItemRect(ARTIFACT_CHALICE3,   12, 15);
		assignItemRect(ARTIFACT_SANDALS,    16, 6 );
		assignItemRect(ARTIFACT_SHOES,      16, 6 );
		assignItemRect(ARTIFACT_BOOTS,      16, 9 );
		assignItemRect(ARTIFACT_GREAVES,    16, 14);
		assignItemRect(ARTIFACT_ROSE1,      14, 14);
		assignItemRect(ARTIFACT_ROSE2,      14, 14);
		assignItemRect(ARTIFACT_ROSE3,      14, 14);
	}

	private static final int OTHERS          =                            xy(1, 18);  //16 slots
	public static final int SCROLL_CATALYST = OTHERS+0;
	public static final int ARCANE_RESIN    = OTHERS+1;
	public static final int POTION_CATALYST = OTHERS+2;
	public static final int LIQUID_METAL    = OTHERS+3;
	static {
		for (int i = OTHERS; i < OTHERS + 16; i++)
			assignItemRect(i, 11, 15);
		assignItemRect(SCROLL_CATALYST, 12, 11);
		assignItemRect(ARCANE_RESIN, 12, 11);
		assignItemRect(POTION_CATALYST, 10, 15);
		assignItemRect(LIQUID_METAL, 16, 16);
	}


	private static final int SCROLLS        =                               xy(1, 19);  //16 slots
	public static final int SCROLL_KAUNAN   = SCROLLS+0;
	public static final int SCROLL_SOWILO   = SCROLLS+1;
	public static final int SCROLL_LAGUZ    = SCROLLS+2;
	public static final int SCROLL_YNGVI    = SCROLLS+3;
	public static final int SCROLL_GYFU     = SCROLLS+4;
	public static final int SCROLL_RAIDO    = SCROLLS+5;
	public static final int SCROLL_ISAZ     = SCROLLS+6;
	public static final int SCROLL_MANNAZ   = SCROLLS+7;
	public static final int SCROLL_NAUDIZ   = SCROLLS+8;
	public static final int SCROLL_BERKANAN = SCROLLS+9;
	public static final int SCROLL_ODAL     = SCROLLS+10;
	public static final int SCROLL_TIWAZ    = SCROLLS+11;
	public static final int SCROLL_GENSOKYO = SCROLLS+12;
	public static final int SCROLL_DANMAKU  = SCROLLS+13;
	public static final int SCROLL_ZUN      = SCROLLS+14;
	public static final int SCROLL_FUMO     = SCROLLS+15;
	static {
		for (int i = SCROLLS; i < SCROLLS+16; i++)
			assignItemRect(i, 11, 15);
	}

	private static final int EXOTIC_SCROLLS =                               xy(1, 20);  //16 slots
	public static final int EXOTIC_KAUNAN   = EXOTIC_SCROLLS+0;
	public static final int EXOTIC_SOWILO   = EXOTIC_SCROLLS+1;
	public static final int EXOTIC_LAGUZ    = EXOTIC_SCROLLS+2;
	public static final int EXOTIC_YNGVI    = EXOTIC_SCROLLS+3;
	public static final int EXOTIC_GYFU     = EXOTIC_SCROLLS+4;
	public static final int EXOTIC_RAIDO    = EXOTIC_SCROLLS+5;
	public static final int EXOTIC_ISAZ     = EXOTIC_SCROLLS+6;
	public static final int EXOTIC_MANNAZ   = EXOTIC_SCROLLS+7;
	public static final int EXOTIC_NAUDIZ   = EXOTIC_SCROLLS+8;
	public static final int EXOTIC_BERKANAN = EXOTIC_SCROLLS+9;
	public static final int EXOTIC_ODAL     = EXOTIC_SCROLLS+10;
	public static final int EXOTIC_TIWAZ    = EXOTIC_SCROLLS+11;
	public static final int EXOTIC_GENSOKYO = EXOTIC_SCROLLS+12;
	public static final int EXOTIC_DANMAKU  = EXOTIC_SCROLLS+13;
	public static final int EXOTIC_ZUN      = EXOTIC_SCROLLS+14;
	public static final int EXOTIC_FUMO     = EXOTIC_SCROLLS+15;
	static {
		for (int i = EXOTIC_SCROLLS; i < EXOTIC_SCROLLS+16; i++)
			assignItemRect(i, 11, 15);
	}

	private static final int STONES             =                           xy(1, 21);  //16 slots
	public static final int STONE_AGGRESSION    = STONES+0;
	public static final int STONE_AUGMENTATION  = STONES+1;
	public static final int STONE_FEAR          = STONES+2;
	public static final int STONE_BLAST         = STONES+3;
	public static final int STONE_BLINK         = STONES+4;
	public static final int STONE_CLAIRVOYANCE  = STONES+5;
	public static final int STONE_SLEEP         = STONES+6;
	public static final int STONE_DISARM        = STONES+7;
	public static final int STONE_ENCHANT       = STONES+8;
	public static final int STONE_FLOCK         = STONES+9;
	public static final int STONE_INTUITION     = STONES+10;
	public static final int STONE_SHOCK         = STONES+11;
	static {
		for (int i = STONES; i < STONES+16; i++)
			assignItemRect(i, 14, 12);
	}

	private static final int POTIONS        =                               xy(1, 22);  //17 slots
	public static final int POTION_CRIMSON  = POTIONS+0;
	public static final int POTION_AMBER    = POTIONS+1;
	public static final int POTION_GOLDEN   = POTIONS+2;
	public static final int POTION_JADE     = POTIONS+3;
	public static final int POTION_TURQUOISE= POTIONS+4;
	public static final int POTION_AZURE    = POTIONS+5;
	public static final int POTION_INDIGO   = POTIONS+6;
	public static final int POTION_MAGENTA  = POTIONS+7;
	public static final int POTION_BISTRE   = POTIONS+8;
	public static final int POTION_CHARCOAL = POTIONS+9;
	public static final int POTION_SILVER   = POTIONS+10;
	public static final int POTION_IVORY    = POTIONS+11;
	public static final int POTION_PINK     = POTIONS+12;
	public static final int POTION_YELLOW   = POTIONS+13;
	public static final int POTION_SPECTRAL = POTIONS+14;
	public static final int POTION_GREEN    = POTIONS+15;
	static {
		for (int i = POTIONS; i < POTIONS+16; i++)
			assignItemRect(i, 10, 15);
	}

	private static final int EXOTIC_POTIONS =                               xy(1, 23);  //17 slots
	public static final int EXOTIC_CRIMSON  = EXOTIC_POTIONS+0;
	public static final int EXOTIC_AMBER    = EXOTIC_POTIONS+1;
	public static final int EXOTIC_GOLDEN   = EXOTIC_POTIONS+2;
	public static final int EXOTIC_JADE     = EXOTIC_POTIONS+3;
	public static final int EXOTIC_TURQUOISE= EXOTIC_POTIONS+4;
	public static final int EXOTIC_AZURE    = EXOTIC_POTIONS+5;
	public static final int EXOTIC_INDIGO   = EXOTIC_POTIONS+6;
	public static final int EXOTIC_MAGENTA  = EXOTIC_POTIONS+7;
	public static final int EXOTIC_BISTRE   = EXOTIC_POTIONS+8;
	public static final int EXOTIC_CHARCOAL = EXOTIC_POTIONS+9;
	public static final int EXOTIC_SILVER   = EXOTIC_POTIONS+10;
	public static final int EXOTIC_IVORY    = EXOTIC_POTIONS+11;
	public static final int EXOTIC_PINK     = EXOTIC_POTIONS+12;
	public static final int EXOTIC_YELLOW   = EXOTIC_POTIONS+13;
	public static final int EXOTIC_SPECTRAL = EXOTIC_POTIONS+14;
	public static final int EXOTIC_GREEN    = EXOTIC_POTIONS+15;
	static {
		for (int i = EXOTIC_POTIONS; i < EXOTIC_POTIONS+16; i++)
			assignItemRect(i, 10, 15);
	}

	private static final int SEEDS              =                           xy(1, 24);  //17 slots
	public static final int SEED_ROTBERRY       = SEEDS+0;
	public static final int SEED_FIREBLOOM      = SEEDS+1;
	public static final int SEED_SWIFTTHISTLE   = SEEDS+2;
	public static final int SEED_SUNGRASS       = SEEDS+3;
	public static final int SEED_ICECAP         = SEEDS+4;
	public static final int SEED_STORMVINE      = SEEDS+5;
	public static final int SEED_SORROWMOSS     = SEEDS+6;
	public static final int SEED_DREAMFOIL      = SEEDS+7;
	public static final int SEED_EARTHROOT      = SEEDS+8;
	public static final int SEED_STARFLOWER     = SEEDS+9;
	public static final int SEED_FADELEAF       = SEEDS+10;
	public static final int SEED_BLINDWEED      = SEEDS+11;
	public static final int SEED_MIGHTSEED      = SEEDS+12;
	static{
		for (int i = SEEDS; i < SEEDS+16; i++)
			assignItemRect(i, 10, 10);
	}

	private static final int BREWS          =                               xy(1, 25);  //8 slots
	public static final int BREW_INFERNAL   = BREWS+0;
	public static final int BREW_BLIZZARD   = BREWS+1;
	public static final int BREW_SHOCKING   = BREWS+2;
	public static final int BREW_CAUSTIC    = BREWS+3;

	private static final int ELIXIRS        =                               xy(9, 25);  //8 slots
	public static final int ELIXIR_HONEY    = ELIXIRS+0;
	public static final int ELIXIR_AQUA     = ELIXIRS+1;
	public static final int ELIXIR_MIGHT    = ELIXIRS+2;
	public static final int ELIXIR_DRAGON   = ELIXIRS+3;
	public static final int ELIXIR_TOXIC    = ELIXIRS+4;
	public static final int ELIXIR_ICY      = ELIXIRS+5;
	public static final int ELIXIR_ARCANE   = ELIXIRS+6;
	static{
		for (int i = BREWS; i < BREWS+16; i++)
			assignItemRect(i, 12, 14);
	}

	//16 free slots

	private static final int SPELLS         =                               xy(1, 27);  //16 slots
	public static final int MAGIC_PORTER    = SPELLS+0;
	public static final int PHASE_SHIFT     = SPELLS+1;
	public static final int TELE_GRAB       = SPELLS+2;
	public static final int WILD_ENERGY     = SPELLS+3;
	public static final int RETURN_BEACON   = SPELLS+4;
	public static final int SUMMON_ELE      = SPELLS+5;
	public static final int KOGASA_HAMMER   = SPELLS+6;
	public static final int AQUA_BLAST      = SPELLS+7;
	public static final int FEATHER_FALL    = SPELLS+8;
	public static final int RECLAIM_TRAP    = SPELLS+9;

	public static final int CURSE_INFUSE    = SPELLS+11;
	public static final int MAGIC_INFUSE    = SPELLS+12;
	public static final int ALCHEMIZE       = SPELLS+13;
	public static final int RECYCLE         = SPELLS+14;
	static{
		assignItemRect(MAGIC_PORTER,    12, 11);
		assignItemRect(PHASE_SHIFT,     12, 11);
		assignItemRect(TELE_GRAB,       12, 11);
		assignItemRect(WILD_ENERGY,     8, 16);
		assignItemRect(RETURN_BEACON,   8, 16);
		assignItemRect(SUMMON_ELE,      8, 16);
		assignItemRect(KOGASA_HAMMER,   16, 16);
		assignItemRect(AQUA_BLAST,      11, 11);
		assignItemRect(FEATHER_FALL,    11, 11);
		assignItemRect(RECLAIM_TRAP,    11, 11);

		assignItemRect(CURSE_INFUSE,    10, 15);
		assignItemRect(MAGIC_INFUSE,    10, 15);
		assignItemRect(ALCHEMIZE,       10, 15);
		assignItemRect(RECYCLE,         10, 15);
	}

	private static final int FOOD       =                                   xy(1, 28);  //16 slots
	public static final int MEAT        = FOOD+0;
	public static final int STEAK       = FOOD+1;
	public static final int STEWED      = FOOD+2;
	public static final int OVERPRICED  = FOOD+3;
	public static final int CARPACCIO   = FOOD+4;
	public static final int RATION      = FOOD+5;
	public static final int PASTY       = FOOD+6;
	public static final int PUMPKIN_PIE = FOOD+7;
	public static final int CANDY_CANE  = FOOD+8;
	public static final int MEAT_PIE    = FOOD+9;
	public static final int BLANDFRUIT  = FOOD+10;
	public static final int BLAND_CHUNKS= FOOD+11;
	public static final int BERRY =       FOOD+12;
	public static final int WAFFLE =       FOOD+13;
	public static final int MIRACLE_FRUIT =       FOOD+14;
	public static final int PANCAKE =       FOOD+15;
	static{
		assignItemRect(MEAT,        15, 11);
		assignItemRect(STEAK,       15, 11);
		assignItemRect(STEWED,      15, 11);
		assignItemRect(OVERPRICED,  14, 11);
		assignItemRect(CARPACCIO,   15, 11);
		assignItemRect(RATION,      16, 12);
		assignItemRect(PASTY,       16, 11);
		assignItemRect(PUMPKIN_PIE, 16, 11);
		assignItemRect(CANDY_CANE,  16, 11);
		assignItemRect(MEAT_PIE,    16, 12);
		assignItemRect(BLANDFRUIT,  9,  12);
		assignItemRect(BLAND_CHUNKS,14, 6);
		assignItemRect(BERRY,       9,  11);
		assignItemRect(WAFFLE,    16, 12);
		assignItemRect(MIRACLE_FRUIT,    16, 12);
		assignItemRect(PANCAKE,    16, 12);
	}

	private static final int QUEST  =                                       xy(1, 29);  //32 slots
	public static final int SKULL   = QUEST+0;
	public static final int DUST    = QUEST+1;
	public static final int CANDLE  = QUEST+2;
	public static final int EMBER   = QUEST+3;
	public static final int PICKAXE = QUEST+4;
	public static final int ORE     = QUEST+5;
	public static final int TOKEN   = QUEST+6;
	public static final int BLOB    = QUEST+7;
	public static final int SHARD   = QUEST+8;
	public static final int PEACH   = QUEST+9;
	public static final int BLOOD   = QUEST+10;
	public static final int ICE   = QUEST+11;
	public static final int HALF   = QUEST+12;
	public static final int BLOODWAFFLE   = QUEST+13;
	public static final int WATERMELON   = QUEST+14;
	public static final int HALFCAKE   = QUEST+15;
	public static final int PEACHWAFFLE   = QUEST+16;
	public static final int PEACHFRUIT   = QUEST+17;
	public static final int BLOODCAKE   = QUEST+18;
	public static final int ICEAPPLE   = QUEST+19;
	public static final int HALFAPPLE   = QUEST+20;
	public static final int KNIFEWAFFLE   = QUEST+21;
	public static final int TENSHIPEACH   = QUEST+22;
	public static final int CUCUMBER   = QUEST+23;
	public static final int TWOSOYSAUCE   = QUEST+24;
	static{
		assignItemRect(SKULL,   16, 11);
		assignItemRect(DUST,    12, 11);
		assignItemRect(CANDLE,  12, 12);
		assignItemRect(EMBER,   12, 11);
		assignItemRect(PICKAXE, 14, 14);
		assignItemRect(ORE,     15, 15);
		assignItemRect(TOKEN,   12, 12);
		assignItemRect(BLOB,    10,  9);
		assignItemRect(SHARD,    8, 10);
		assignItemRect(PEACH,    11, 7);
		assignItemRect(BLOOD,    10, 13);
		assignItemRect(ICE,    12, 11);
		assignItemRect(HALF,    9, 11);
		assignItemRect(BLOODWAFFLE,    16, 12);
		assignItemRect(WATERMELON,    16, 12);
		assignItemRect(HALFCAKE,    16, 12);
		assignItemRect(PEACHWAFFLE,    16, 12);
		assignItemRect(PEACHFRUIT,    16, 12);
		assignItemRect(BLOODCAKE,    16, 12);
		assignItemRect(ICEAPPLE,    9, 11);
		assignItemRect(HALFAPPLE,    9, 11);
		assignItemRect(KNIFEWAFFLE,    16, 12);
		assignItemRect(TENSHIPEACH,    11, 12);
		assignItemRect(CUCUMBER,    8, 13);
		assignItemRect(TWOSOYSAUCE,    16, 12);
	}

	private static final int BAGS       =                                   xy(1, 31);  //16 slots
	public static final int WATERSKIN   = BAGS+0;
	public static final int BACKPACK    = BAGS+1;
	public static final int POUCH       = BAGS+2;
	public static final int HOLDER      = BAGS+3;
	public static final int BANDOLIER   = BAGS+4;
	public static final int HOLSTER     = BAGS+5;
	public static final int VIAL        = BAGS+6;
	public static final int PRAYER       = BAGS+7;
	public static final int FOODHOLD       = BAGS+8;
	public static final int ARTIHOLD       = BAGS+9;
	public static final int TAILSMANHOLD       = BAGS+10;
	static{
		assignItemRect(WATERSKIN,   16, 14);
		assignItemRect(BACKPACK,    16, 16);
		assignItemRect(POUCH,       14, 15);
		assignItemRect(HOLDER,      16, 16);
		assignItemRect(BANDOLIER,   15, 16);
		assignItemRect(HOLSTER,     15, 16);
		assignItemRect(VIAL,        12, 12);
		assignItemRect(PRAYER,       13, 13);
		assignItemRect(FOODHOLD,       14, 15);
		assignItemRect(ARTIHOLD,       14, 15);
		assignItemRect(TAILSMANHOLD,       14, 15);
	}

	private static final int XYZ_WEAPON   =                               xy(1, 34);   //8 slots
	public static final int FIREBRAND2    = XYZ_WEAPON+0;
	public static final int FROSTBRAND2   = XYZ_WEAPON+1;
	public static final int TURNABOUTSWORD   = XYZ_WEAPON+2;
	public static final int EXHELLSCYTHE   = XYZ_WEAPON+3;
	public static final int HELLKEYBOARD   = XYZ_WEAPON+4;
	public static final int HELLMIC   = XYZ_WEAPON+5;
	static{
		assignItemRect(FIREBRAND2, 13, 13);
		assignItemRect(FROSTBRAND2,    13, 13);
		assignItemRect(TURNABOUTSWORD,    13, 13);
		assignItemRect(EXHELLSCYTHE,    16, 13);
		assignItemRect(HELLKEYBOARD,    13, 13);
		assignItemRect(HELLMIC,    13, 13);
	}

	private static final int WEP_TIER5_PART2   =                               xy(1, 35);   //8 slots
	public static final int RANDOMPHONE    = WEP_TIER5_PART2+0;
	public static final int TENKYUUCLOAK   = WEP_TIER5_PART2+1;
	public static final int MINTCHOCOSWORD   = WEP_TIER5_PART2+2;
	public static final int HOROU_BOOK        = WEP_TIER5_PART2+3;
	public static final int KEINE_BOOK        = WEP_TIER5_PART2+4;
	public static final int PSALMS        = WEP_TIER5_PART2+5;
	public static final int ALCHEMY_SWORD        = WEP_TIER5_PART2+6;
	public static final int POT_OF_GREED        = WEP_TIER5_PART2+7;
	public static final int ALCHEMY_HAT        = WEP_TIER5_PART2+8;
	public static final int BLACK_FAN        = WEP_TIER5_PART2+9;
	public static final int SMALL_SEIRAN_HAMMER    = WEP_TIER5_PART2+10;
	public static final int HINA_RIBBON        = WEP_TIER5_PART2+11;
	static{
		assignItemRect(RANDOMPHONE, 8, 12);
		assignItemRect(TENKYUUCLOAK,    16, 14);
		assignItemRect(MINTCHOCOSWORD,    13, 13);
		assignItemRect(HOROU_BOOK,      13, 16);
		assignItemRect(KEINE_BOOK,      13, 16);
		assignItemRect(PSALMS,      13, 16);
		assignItemRect(ALCHEMY_SWORD,      13, 13);
		assignItemRect(POT_OF_GREED,      12, 12);
		assignItemRect(ALCHEMY_HAT,      11, 10);
		assignItemRect(BLACK_FAN,      10, 10);
		assignItemRect(SMALL_SEIRAN_HAMMER,      10, 10);
		assignItemRect(HINA_RIBBON,      13, 6);
	}

	//for smaller 8x8 icons that often accompany an item sprite
	public static class Icons {

		private static final int WIDTH = 16;
		public static final int SIZE = 8;

		public static TextureFilm film = new TextureFilm( Assets.Sprites.ITEM_ICONS, SIZE, SIZE );

		private static int xy(int x, int y){
			x -= 1; y -= 1;
			return x + WIDTH*y;
		}

		private static void assignIconRect( int item, int width, int height ){
			int x = (item % WIDTH) * SIZE;
			int y = (item / WIDTH) * SIZE;
			film.add( item, x, y, x+width, y+height);
		}

		private static final int RINGS          =                            xy(1, 1);  //16 slots
		public static final int RING_ACCURACY   = RINGS+0;
		public static final int RING_ELEMENTS   = RINGS+1;
		public static final int RING_ENERGY     = RINGS+2;
		public static final int RING_EVASION    = RINGS+3;
		public static final int RING_FORCE      = RINGS+4;
		public static final int RING_FUROR      = RINGS+5;
		public static final int RING_HASTE      = RINGS+6;
		public static final int RING_MIGHT      = RINGS+7;
		public static final int RING_SHARPSHOOT = RINGS+8;
		public static final int RING_TENACITY   = RINGS+9;
		public static final int RING_WEALTH     = RINGS+10;
		public static final int RING_YOKAISLAYER     = RINGS+11;
		public static final int RING_FLOATSLAYER     = RINGS+12;
		public static final int RING_ANIMALSLAYER     = RINGS+13;
		public static final int RING_GODSLAYER     = RINGS+14;
		public static final int RING_PRESERVE     = RINGS+15;
		static {
			assignIconRect( RING_ACCURACY,      7, 7 );
			assignIconRect( RING_ELEMENTS,      7, 7 );
			assignIconRect( RING_ENERGY,        7, 5 );
			assignIconRect( RING_EVASION,       7, 7 );
			assignIconRect( RING_FORCE,         5, 6 );
			assignIconRect( RING_FUROR,         7, 6 );
			assignIconRect( RING_HASTE,         6, 6 );
			assignIconRect( RING_MIGHT,         7, 7 );
			assignIconRect( RING_SHARPSHOOT,    7, 7 );
			assignIconRect( RING_TENACITY,      6, 6 );
			assignIconRect( RING_WEALTH,        7, 6 );
			assignIconRect( RING_YOKAISLAYER,    7, 7 );
			assignIconRect( RING_FLOATSLAYER,    7, 7 );
			assignIconRect( RING_ANIMALSLAYER,    7, 7 );
			assignIconRect( RING_GODSLAYER,    7, 7 );
			assignIconRect( RING_PRESERVE,    7, 7 );
		}

		//16 free slots

		private static final int SCROLLS        =                            xy(1, 3);  //16 slots
		public static final int SCROLL_UPGRADE  = SCROLLS+0;
		public static final int SCROLL_IDENTIFY = SCROLLS+1;
		public static final int SCROLL_REMCURSE = SCROLLS+2;
		public static final int SCROLL_MIRRORIMG= SCROLLS+3;
		public static final int SCROLL_RECHARGE = SCROLLS+4;
		public static final int SCROLL_TELEPORT = SCROLLS+5;
		public static final int SCROLL_LULLABY  = SCROLLS+6;
		public static final int SCROLL_MAGICMAP = SCROLLS+7;
		public static final int SCROLL_RAGE     = SCROLLS+8;
		public static final int SCROLL_RETRIB   = SCROLLS+9;
		public static final int SCROLL_TERROR   = SCROLLS+10;
		public static final int SCROLL_TRANSMUTE= SCROLLS+11;
		public static final int SCROLL_SLOWNESS = SCROLLS+12;
		public static final int SCROLL_BURNING  = SCROLLS+13;
		public static final int SCROLL_SILENCE  = SCROLLS+14;
		public static final int SCROLL_ROUTECHANGE  = SCROLLS+15;
		static {
			assignIconRect( SCROLL_UPGRADE,     7, 7 );
			assignIconRect( SCROLL_IDENTIFY,    4, 7 );
			assignIconRect( SCROLL_REMCURSE,    7, 7 );
			assignIconRect( SCROLL_MIRRORIMG,   7, 5 );
			assignIconRect( SCROLL_RECHARGE,    7, 5 );
			assignIconRect( SCROLL_TELEPORT,    7, 7 );
			assignIconRect( SCROLL_LULLABY,     7, 6 );
			assignIconRect( SCROLL_MAGICMAP,    7, 7 );
			assignIconRect( SCROLL_RAGE,        6, 6 );
			assignIconRect( SCROLL_RETRIB,      5, 6 );
			assignIconRect( SCROLL_TERROR,      5, 7 );
			assignIconRect( SCROLL_TRANSMUTE,   7, 7 );
			assignIconRect( SCROLL_SLOWNESS,    7, 7 );
			assignIconRect( SCROLL_BURNING,     5, 7 );
			assignIconRect( SCROLL_SILENCE,     7, 7 );
			assignIconRect( SCROLL_ROUTECHANGE, 7, 7 );
		}

		private static final int EXOTIC_SCROLLS =                            xy(1, 4);  //16 slots
		public static final int SCROLL_ENCHANT  = EXOTIC_SCROLLS+0;
		public static final int SCROLL_DIVINATE = EXOTIC_SCROLLS+1;
		public static final int SCROLL_ANTIMAGIC= EXOTIC_SCROLLS+2;
		public static final int SCROLL_PRISIMG  = EXOTIC_SCROLLS+3;
		public static final int SCROLL_MYSTENRG = EXOTIC_SCROLLS+4;
		public static final int SCROLL_PASSAGE  = EXOTIC_SCROLLS+5;
		public static final int SCROLL_SIREN    = EXOTIC_SCROLLS+6;
		public static final int SCROLL_FORESIGHT= EXOTIC_SCROLLS+7;
		public static final int SCROLL_CHALLENGE= EXOTIC_SCROLLS+8;
		public static final int SCROLL_PSIBLAST = EXOTIC_SCROLLS+9;
		public static final int SCROLL_DREAD    = EXOTIC_SCROLLS+10;
		public static final int SCROLL_METAMORPH= EXOTIC_SCROLLS+11;
		public static final int SCROLL_TORMENT  = EXOTIC_SCROLLS+12;
		public static final int SCROLL_WEAKNESS = EXOTIC_SCROLLS+13;
		public static final int SCROLL_PRISMRIVER = EXOTIC_SCROLLS+14;
		public static final int SCROLL_LIMITBREAK = EXOTIC_SCROLLS+15;
		static {
			assignIconRect( SCROLL_ENCHANT,     7, 7 );
			assignIconRect( SCROLL_DIVINATE,    7, 6 );
			assignIconRect( SCROLL_ANTIMAGIC,   7, 7 );
			assignIconRect( SCROLL_PRISIMG,     5, 7 );
			assignIconRect( SCROLL_MYSTENRG,    7, 5 );
			assignIconRect( SCROLL_PASSAGE,     5, 7 );
			assignIconRect( SCROLL_SIREN,       7, 6 );
			assignIconRect( SCROLL_FORESIGHT,   7, 5 );
			assignIconRect( SCROLL_CHALLENGE,   7, 7 );
			assignIconRect( SCROLL_PSIBLAST,    5, 6 );
			assignIconRect( SCROLL_DREAD,       5, 7 );
			assignIconRect( SCROLL_METAMORPH,   7, 7 );
			assignIconRect( SCROLL_TORMENT,     7, 5 );
			assignIconRect( SCROLL_WEAKNESS,    7, 7 );
			assignIconRect( SCROLL_PRISMRIVER,  7, 6 );
			assignIconRect( SCROLL_LIMITBREAK,  7, 7 );
		}

		//16 free slots

		private static final int POTIONS        =                            xy(1, 6);  //16 slots
		public static final int POTION_STRENGTH = POTIONS+0;
		public static final int POTION_HEALING  = POTIONS+1;
		public static final int POTION_MINDVIS  = POTIONS+2;
		public static final int POTION_FROST    = POTIONS+3;
		public static final int POTION_LIQFLAME = POTIONS+4;
		public static final int POTION_TOXICGAS = POTIONS+5;
		public static final int POTION_HASTE    = POTIONS+6;
		public static final int POTION_INVIS    = POTIONS+7;
		public static final int POTION_LEVITATE = POTIONS+8;
		public static final int POTION_PARAGAS  = POTIONS+9;
		public static final int POTION_PURITY   = POTIONS+10;
		public static final int POTION_EXP      = POTIONS+11;
		public static final int POTION_MIGHT    = POTIONS+12;
		public static final int POTION_DOUBLESPEED = POTIONS+13;
		public static final int POTION_BERSERK = POTIONS+14;
		public static final int POTION_LIGHTHEALING = POTIONS+15;
		static {
			assignIconRect( POTION_STRENGTH,    7, 7 );
			assignIconRect( POTION_HEALING,     6, 7 );
			assignIconRect( POTION_MINDVIS,     7, 5 );
			assignIconRect( POTION_FROST,       7, 7 );
			assignIconRect( POTION_LIQFLAME,    5, 7 );
			assignIconRect( POTION_TOXICGAS,    7, 7 );
			assignIconRect( POTION_HASTE,       6, 6 );
			assignIconRect( POTION_INVIS,       5, 7 );
			assignIconRect( POTION_LEVITATE,    6, 7 );
			assignIconRect( POTION_PARAGAS,     7, 7 );
			assignIconRect( POTION_PURITY,      5, 7 );
			assignIconRect( POTION_EXP,         7, 7 );
			assignIconRect( POTION_MIGHT,       7, 7 );
			assignIconRect( POTION_DOUBLESPEED,       7, 7 );
			assignIconRect( POTION_BERSERK,       7, 7 );
			assignIconRect( POTION_LIGHTHEALING,       6, 7 );
		}

		private static final int EXOTIC_POTIONS =                            xy(1, 7);  //16 slots
		public static final int POTION_MASTERY  = EXOTIC_POTIONS+0;
		public static final int POTION_SHIELDING= EXOTIC_POTIONS+1;
		public static final int POTION_MAGISIGHT= EXOTIC_POTIONS+2;
		public static final int POTION_SNAPFREEZ= EXOTIC_POTIONS+3;
		public static final int POTION_DRGBREATH= EXOTIC_POTIONS+4;
		public static final int POTION_CORROGAS = EXOTIC_POTIONS+5;
		public static final int POTION_STAMINA  = EXOTIC_POTIONS+6;
		public static final int POTION_SHROUDFOG= EXOTIC_POTIONS+7;
		public static final int POTION_STRMCLOUD= EXOTIC_POTIONS+8;
		public static final int POTION_EARTHARMR= EXOTIC_POTIONS+9;
		public static final int POTION_CLEANSE  = EXOTIC_POTIONS+10;
		public static final int POTION_DIVINE   = EXOTIC_POTIONS+11;
		public static final int POTION_INVULNERABILITY= EXOTIC_POTIONS+12;
		public static final int POTION_TRIPLESPEED= EXOTIC_POTIONS+13;
		public static final int POTION_PHILOSOPHER= EXOTIC_POTIONS+14;
		public static final int POTION_YOMI= EXOTIC_POTIONS+15;
		static {
			assignIconRect( POTION_MASTERY,     7, 7 );
			assignIconRect( POTION_SHIELDING,   6, 6 );
			assignIconRect( POTION_MAGISIGHT,   7, 5 );
			assignIconRect( POTION_SNAPFREEZ,   7, 7 );
			assignIconRect( POTION_DRGBREATH,   7, 7 );
			assignIconRect( POTION_CORROGAS,    7, 7 );
			assignIconRect( POTION_STAMINA,     6, 6 );
			assignIconRect( POTION_SHROUDFOG,   7, 7 );
			assignIconRect( POTION_STRMCLOUD,   7, 7 );
			assignIconRect( POTION_EARTHARMR,   6, 6 );
			assignIconRect( POTION_CLEANSE,     7, 7 );
			assignIconRect( POTION_DIVINE,      7, 7 );
			assignIconRect( POTION_INVULNERABILITY,   7, 7 );
			assignIconRect( POTION_TRIPLESPEED,   7, 7 );
			assignIconRect( POTION_PHILOSOPHER,   7, 7 );
			assignIconRect( POTION_YOMI,   7, 7 );
		}

		//16 free slots

	}

}
