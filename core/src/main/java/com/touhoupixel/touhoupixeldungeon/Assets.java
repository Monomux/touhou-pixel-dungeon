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

public class Assets {

	public static class Effects {
		public static final String EFFECTS		= "effects/effects.png";
		public static final String FIREBALL		= "effects/fireball.png";
		public static final String SPECKS		= "effects/specks.png";
		public static final String SPELL_ICONS	= "effects/spell_icons.png";
	}

	public static class Environment {
		public static final String TERRAIN_FEATURES	= "environment/terrain_features.png";

		public static final String VISUAL_GRID	= "environment/visual_grid.png";
		public static final String WALL_BLOCKING= "environment/wall_blocking.png";

		public static final String TILES_SEWERS	= "environment/tiles_sewers.png";
		public static final String TILES_PRISON	= "environment/tiles_prison.png";
		public static final String TILES_CAVES	= "environment/tiles_caves.png";
		public static final String TILES_CITY	= "environment/tiles_city.png";
		public static final String TILES_FOREST	= "environment/tiles_forest.png";
		public static final String TILES_MORIYA	= "environment/tiles_moriya.png";
		public static final String TILES_SPIRIT	= "environment/tiles_spirit.png";
		public static final String TILES_LUNAR	= "environment/tiles_lunar.png";
		public static final String TILES_SKY	= "environment/tiles_sky.png";
		public static final String TILES_HALLS	= "environment/tiles_halls.png";

		public static final String WATER_SEWERS	= "environment/water0.png";
		public static final String WATER_PRISON	= "environment/water1.png";
		public static final String WATER_CAVES	= "environment/water2.png";
		public static final String WATER_CITY	= "environment/water3.png";
		public static final String WATER_FOREST	= "environment/water4.png";
		public static final String WATER_MORIYA	= "environment/water5.png";
		public static final String WATER_SPIRIT	= "environment/water6.png";
		public static final String WATER_LUNAR	= "environment/water7.png";
		public static final String WATER_SKY	= "environment/water8.png";
		public static final String WATER_HALLS	= "environment/water9.png";

		public static final String WEAK_FLOOR       = "environment/custom_tiles/weak_floor.png";
		public static final String SEWER_BOSS       = "environment/custom_tiles/sewer_boss.png";
		public static final String PRISON_QUEST     = "environment/custom_tiles/prison_quests.png";
		public static final String PRISON_EXIT      = "environment/custom_tiles/prison_exit.png";
		public static final String CAVES_BOSS       = "environment/custom_tiles/caves_boss.png";
		public static final String CITY_BOSS        = "environment/custom_tiles/city_boss.png";
		public static final String HALLS_SP         = "environment/custom_tiles/halls_special.png";
	}

	//TODO include other font assets here? Some are platform specific though...
	public static class Fonts {
		public static final String PIXELFONT= "fonts/pixel_font.png";
	}

	public static class Interfaces {
		public static final String ARCS_BG  = "interfaces/arcs1.png";
		public static final String ARCS_FG  = "interfaces/arcs2.png";

		public static final String BANNERS	= "interfaces/banners.png";
		public static final String BADGES	= "interfaces/badges.png";
		public static final String LOCKED	= "interfaces/locked_badge.png";

		public static final String CHROME	= "interfaces/chrome.png";
		public static final String ICONS	= "interfaces/icons.png";
		public static final String STATUS	= "interfaces/status_pane.png";
		public static final String DIFFI1	= "interfaces/difficulty1.png";
		public static final String DIFFI2	= "interfaces/difficulty2.png";
		public static final String DIFFI3	= "interfaces/difficulty3.png";
		public static final String DIFFI4	= "interfaces/difficulty4.png";
		public static final String DIFFI5	= "interfaces/difficulty5.png";
		public static final String MENU		= "interfaces/menu_button.png";
		public static final String HP_BAR	= "interfaces/hp_bar.png";
		public static final String SHLD_BAR = "interfaces/shield_bar.png";
		public static final String XP_BAR	= "interfaces/exp_bar.png";
		public static final String TOOLBAR	= "interfaces/toolbar.png";
		public static final String SHADOW   = "interfaces/shadow.png";
		public static final String BOSSHP   = "interfaces/boss_hp.png";

		public static final String SURFACE	= "interfaces/surface.png";

		public static final String LOADING_SEWERS	= "interfaces/loading_sewers.png";
		public static final String LOADING_PRISON	= "interfaces/loading_prison.png";
		public static final String LOADING_CAVES	= "interfaces/loading_caves.png";
		public static final String LOADING_CITY	    = "interfaces/loading_city.png";
		public static final String LOADING_FOREST	= "interfaces/loading_forest.png";
		public static final String LOADING_MORIYA	= "interfaces/loading_moriya.png";
		public static final String LOADING_SPIRIT	= "interfaces/loading_spirit.png";
		public static final String LOADING_LUNAR	= "interfaces/loading_lunar.png";
		public static final String LOADING_SKY   	= "interfaces/loading_sky.png";
		public static final String LOADING_HALLS	= "interfaces/loading_halls.png";

		public static final String BUFFS_SMALL	= "interfaces/buffs.png";
		public static final String BUFFS_LARGE	= "interfaces/large_buffs.png";

		public static final String TALENT_ICONS	 = "interfaces/talent_icons.png";
		public static final String TALENT_BUTTON = "interfaces/talent_button.png";

		public static final String HERO_ICONS	= "interfaces/hero_icons.png";
	}

	//these points to resource bundles, not raw asset files
	public static class Messages {
		public static final String ACTORS   = "messages/actors/actors";
		public static final String ITEMS    = "messages/items/items";
		public static final String JOURNAL  = "messages/journal/journal";
		public static final String LEVELS   = "messages/levels/levels";
		public static final String MISC     = "messages/misc/misc";
		public static final String PLANTS   = "messages/plants/plants";
		public static final String SCENES   = "messages/scenes/scenes";
		public static final String UI       = "messages/ui/ui";
		public static final String WINDOWS  = "messages/windows/windows";
	}

	public static class Music {
		public static final String THEME_1  	= "music/theme_1.ogg";
		public static final String THEME_2	    = "music/theme_2.ogg";
		public static final String SEWERS_1		= "music/sewers_1.ogg";
		public static final String PRISON_1		= "music/prison_1.ogg";
		public static final String CAVES_1		= "music/caves_1.ogg";
		public static final String CITY_1		= "music/city_1.ogg";
		public static final String FOREST_1		= "music/forest_1.ogg";
		public static final String MORIYA_1		= "music/moriya_1.ogg";
		public static final String SPIRIT_1		= "music/spirit_1.ogg";
		public static final String LUNAR_1		= "music/lunar_1.ogg";
		public static final String SKY_1		= "music/sky_1.ogg";
		public static final String HALLS_1		= "music/halls_1.ogg";
		public static final String DEKAISEWERS_1		= "music/dekaisewers_1.ogg";
		public static final String DEKAIPRISON_1		= "music/dekaiprison_1.ogg";
		public static final String DEKAICAVES_1		= "music/dekaicaves_1.ogg";
		public static final String DEKAICITY_1		= "music/dekaicity_1.ogg";
		public static final String DEKAIFOREST_1		= "music/dekaiforest_1.ogg";
		public static final String DEKAIMORIYA_1		= "music/dekaimoriya_1.ogg";
		public static final String DEKAISPIRIT_1		= "music/dekaispirit_1.ogg";
		public static final String DEKAILUNAR_1		= "music/dekailunar_1.ogg";
		public static final String DEKAISKY_1		= "music/dekaisky_1.ogg";
		public static final String DEKAIHALLS_1		= "music/dekaihalls_1.ogg";
	}

	public static class Sounds {
		public static final String CLICK	= "sounds/click.mp3";
		public static final String BADGE	= "sounds/badge.mp3";
		public static final String GOLD		= "sounds/gold.mp3";

		public static final String OPEN		= "sounds/door_open.mp3";
		public static final String UNLOCK	= "sounds/unlock.mp3";
		public static final String ITEM		= "sounds/item.mp3";
		public static final String DEWDROP	= "sounds/dewdrop.mp3";
		public static final String STEP		= "sounds/step.mp3";
		public static final String WATER	= "sounds/water.mp3";
		public static final String GRASS	= "sounds/grass.mp3";
		public static final String TRAMPLE	= "sounds/trample.mp3";
		public static final String STURDY	= "sounds/sturdy.mp3";

		public static final String HIT		        = "sounds/hit.mp3";
		public static final String MISS		        = "sounds/miss.mp3";
		public static final String HIT_SLASH        = "sounds/hit_slash.mp3";
		public static final String HIT_STAB         = "sounds/hit_stab.mp3";
		public static final String HIT_CRUSH        = "sounds/hit_crush.mp3";
		public static final String HIT_MAGIC        = "sounds/hit_magic.mp3";
		public static final String HIT_STRONG       = "sounds/hit_strong.mp3";
		public static final String HIT_PARRY        = "sounds/hit_parry.mp3";
		public static final String HIT_ARROW        = "sounds/hit_arrow.mp3";
		public static final String ATK_SPIRITBOW    = "sounds/atk_spiritbow.mp3";
		public static final String ATK_CROSSBOW     = "sounds/atk_crossbow.mp3";
		public static final String HEALTH_WARN      = "sounds/health_warn.mp3";
		public static final String HEALTH_CRITICAL  = "sounds/health_critical.mp3";

		public static final String DESCEND	= "sounds/descend.mp3";
		public static final String EAT		= "sounds/eat.mp3";
		public static final String READ		= "sounds/read.mp3";
		public static final String LULLABY	= "sounds/lullaby.mp3";
		public static final String DRINK	= "sounds/drink.mp3";
		public static final String SHATTER	= "sounds/shatter.mp3";
		public static final String ZAP		= "sounds/zap.mp3";
		public static final String LIGHTNING= "sounds/lightning.mp3";
		public static final String LEVELUP	= "sounds/levelup.mp3";
		public static final String DEATH	= "sounds/death.mp3";
		public static final String CHALLENGE= "sounds/challenge.mp3";
		public static final String CURSED	= "sounds/cursed.mp3";
		public static final String TRAP		= "sounds/trap.mp3";
		public static final String EVOKE	= "sounds/evoke.mp3";
		public static final String TOMB		= "sounds/tomb.mp3";
		public static final String ALERT	= "sounds/alert.mp3";
		public static final String MELD		= "sounds/meld.mp3";
		public static final String BOSS		= "sounds/boss.mp3";
		public static final String BLAST	= "sounds/blast.mp3";
		public static final String PLANT	= "sounds/plant.mp3";
		public static final String RAY		= "sounds/ray.mp3";
		public static final String BEACON	= "sounds/beacon.mp3";
		public static final String TELEPORT	= "sounds/teleport.mp3";
		public static final String CHARMS	= "sounds/charms.mp3";
		public static final String MASTERY	= "sounds/mastery.mp3";
		public static final String PUFF		= "sounds/puff.mp3";
		public static final String ROCKS	= "sounds/rocks.mp3";
		public static final String BURNING	= "sounds/burning.mp3";
		public static final String FALLING	= "sounds/falling.mp3";
		public static final String GHOST	= "sounds/ghost.mp3";
		public static final String SECRET	= "sounds/secret.mp3";
		public static final String BONES	= "sounds/bones.mp3";
		public static final String BEE      = "sounds/bee.mp3";
		public static final String DEGRADE  = "sounds/degrade.mp3";
		public static final String MIMIC    = "sounds/mimic.mp3";
		public static final String DEBUFF   = "sounds/debuff.mp3";
		public static final String CHARGEUP = "sounds/chargeup.mp3";
		public static final String GAS      = "sounds/gas.mp3";
		public static final String CHAINS   = "sounds/chains.mp3";
		public static final String SCAN     = "sounds/scan.mp3";
		public static final String SHEEP    = "sounds/sheep.mp3";

		public static final String[] all = new String[]{
				CLICK, BADGE, GOLD,

				OPEN, UNLOCK, ITEM, DEWDROP, STEP, WATER, GRASS, TRAMPLE, STURDY,

				HIT, MISS, HIT_SLASH, HIT_STAB, HIT_CRUSH, HIT_MAGIC, HIT_STRONG, HIT_PARRY,
				HIT_ARROW, ATK_SPIRITBOW, ATK_CROSSBOW, HEALTH_WARN, HEALTH_CRITICAL,

				DESCEND, EAT, READ, LULLABY, DRINK, SHATTER, ZAP, LIGHTNING, LEVELUP, DEATH,
				CHALLENGE, CURSED, TRAP, EVOKE, TOMB, ALERT, MELD, BOSS, BLAST, PLANT, RAY, BEACON,
				TELEPORT, CHARMS, MASTERY, PUFF, ROCKS, BURNING, FALLING, GHOST, SECRET, BONES,
				BEE, DEGRADE, MIMIC, DEBUFF, CHARGEUP, GAS, CHAINS, SCAN, SHEEP
		};
	}

	public static class Splashes {
		public static final String WARRIOR	= "splashes/warrior.jpg";
		public static final String MAGE		= "splashes/mage.jpg";
		public static final String ROGUE	= "splashes/rogue.jpg";
		public static final String HUNTRESS	= "splashes/huntress.jpg";
		public static final String REISENPLAYER	= "splashes/reisenplayer.jpg";
		public static final String NITORIPLAYER	= "splashes/nitoriplayer.jpg";
		public static final String YUYUKOPLAYER	= "splashes/yuyukoplayer.jpg";
		public static final String MURASAPLAYER	= "splashes/murasaplayer.jpg";
		public static final String HINAPLAYER     = "splashes/hinaplayer.jpg";
		public static final String KAGUYAPLAYER     = "splashes/kaguyaplayer.jpg";
		public static final String KOGASAPLAYER     = "splashes/kogasaplayer.jpg";
		public static final String YUKARIPLAYER     = "splashes/yukariplayer.jpg";
	}

	public static class Sprites {
		public static final String ITEMS	    = "sprites/items.png";
		public static final String ITEM_ICONS   = "sprites/item_icons.png";

		public static final String WARRIOR	= "sprites/warrior.png";
		public static final String MAGE		= "sprites/mage.png";
		public static final String ROGUE	= "sprites/rogue.png";
		public static final String HUNTRESS	= "sprites/huntress.png";
		public static final String REISENPLAYER	= "sprites/reisenplayer.png";
		public static final String NITORIPLAYER	= "sprites/nitoriplayer.png";
		public static final String YUYUKOPLAYER	= "sprites/yuyukoplayer.png";
		public static final String MURASAPLAYER	= "sprites/murasaplayer.png";
		public static final String HINAPLAYER = "sprites/hinaplayer.png";
		public static final String KAGUYAPLAYER = "sprites/kaguyaplayer.png";
		public static final String KOGASAPLAYER = "sprites/kogasaplayer.png";
		public static final String YUKARIPLAYER = "sprites/yukariplayer.png";
		public static final String AVATARS	= "sprites/avatars.png";
		public static final String PET		= "sprites/pet.png";
		public static final String AMULET	= "sprites/amulet.png";

		public static final String YORIHIME = "sprites/yorihime.png";
		public static final String TOYOHIME = "sprites/toyohime.png";
		public static final String ESHOPKEEPER = "sprites/eshopkeeper.png";
		public static final String BENBEN = "sprites/benben.png";
		public static final String YATSUHASHI = "sprites/yatsuhashi.png";
		public static final String YUUMA = "sprites/yuuma.png";
		public static final String KOSUZU = "sprites/kosuzu.png";
		public static final String JOON = "sprites/joon.png";
		public static final String SHION = "sprites/shion.png";
		public static final String PARSEE = "sprites/parsee.png";
		public static final String TSUKASA = "sprites/tsukasa.png";
		public static final String HECATIA = "sprites/hecatia.png";
		public static final String SUWAKO = "sprites/suwako.png";
		public static final String MISUMARU = "sprites/misumaru.png";
		public static final String MINORIKO = "sprites/minoriko.png";
		public static final String YACHIE = "sprites/yachie.png";
		public static final String TENKYUU = "sprites/tenkyuu.png";
		public static final String EIKA = "sprites/eika.png";
		public static final String MOKOU = "sprites/mokou.png";
		public static final String NAZRIN = "sprites/nazrin.png";
		public static final String RUMIA = "sprites/rumia.png";
		public static final String TAKANE = "sprites/takane.png";
		public static final String EIKI = "sprites/eiki.png";
		public static final String SEIJA = "sprites/seija.png";
		public static final String KOAKUMA = "sprites/koakuma.png";
		public static final String SUMIREKO = "sprites/sumireko.png";
		public static final String DOREMY 	= "sprites/doremy.png";
		public static final String YUUKA 	= "sprites/yuuka.png";
		public static final String KAGUYA 	= "sprites/kaguya.png";
		public static final String CHEN 	= "sprites/chen.png";
		public static final String SANNYO	= "sprites/sannyo.png";
		public static final String OKINA	= "sprites/okina.png";
		public static final String KEINE	= "sprites/keine.png";
		public static final String SHIZUHA	= "sprites/shizuha.png";
		public static final String SATORI	= "sprites/satori.png";
		public static final String KEIKI	= "sprites/keiki.png";
		public static final String KOMACHI	= "sprites/komachi.png";
		public static final String IKU	    = "sprites/iku.png";
		public static final String AYA		= "sprites/aya.png";
		public static final String SHINMYOMARU	= "sprites/shinmyomaru.png";
		public static final String KAGEROU	= "sprites/kagerou.png";
		public static final String YUKARI	= "sprites/yukari.png";
		public static final String UTSUHO	= "sprites/utsuho.png";
		public static final String MOMOYO	= "sprites/momoyo.png";
		public static final String HINA		= "sprites/hina.png";
		public static final String SAKUYA	= "sprites/sakuya.png";
		public static final String SHOU		= "sprites/shou.png";
		public static final String RAT		= "sprites/rat.png";
		public static final String BRUTE	= "sprites/brute.png";
		public static final String YAMAME	= "sprites/yamame.png";
		public static final String TENSHIBOSS	= "sprites/tenshiboss.png";
		public static final String WRAITH	= "sprites/wraith.png";
		public static final String UNDEAD	= "sprites/undead.png";
		public static final String KING		= "sprites/king.png";
		public static final String MURASA	= "sprites/murasa.png";
		public static final String JUNKO		= "sprites/junko.png";
		public static final String KISUME	= "sprites/kisume.png";
		public static final String MAI		= "sprites/mai.png";
		public static final String SATONO	= "sprites/satono.png";
		public static final String MEGUMU	= "sprites/megumu.png";
		public static final String CRAB		= "sprites/crab.png";
		public static final String CIRNO		= "sprites/cirno.png";
		public static final String ALICE	= "sprites/alice.png";
		public static final String PATCHOULI	= "sprites/patchouli.png";
		public static final String SHAMAN	= "sprites/shaman.png";
		public static final String THIEF	= "sprites/thief.png";
		public static final String SUIKA	= "sprites/suika.png";
		public static final String SHEEP	= "sprites/sheep.png";
		public static final String KEEPER	= "sprites/shopkeeper.png";
		public static final String BAT		= "sprites/bat.png";
		public static final String ELEMENTAL= "sprites/elemental.png";
		public static final String MONK		= "sprites/monk.png";
		public static final String RAN	= "sprites/ran.png";
		public static final String KASEN	= "sprites/kasen.png";
		public static final String STATUE	= "sprites/statue.png";
		public static final String REISEN	= "sprites/reisen.png";
		public static final String SAGUME	= "sprites/sagume.png";
		public static final String FISTS	= "sprites/yog_fists.png";
		public static final String GHOST	= "sprites/ghost.png";
		public static final String MAKER	= "sprites/wandmaker.png";
		public static final String TROLL	= "sprites/blacksmith.png";
		public static final String IMP		= "sprites/demon.png";
		public static final String RATKING	= "sprites/ratking.png";
		public static final String BEE      = "sprites/bee.png";
		public static final String MIMIC    = "sprites/mimic.png";
		public static final String ROT_LASH = "sprites/rot_lasher.png";
		public static final String ROT_HEART= "sprites/rot_heart.png";
		public static final String YUUGI    = "sprites/yuugi.png";
		public static final String WARDS    = "sprites/wards.png";
		public static final String GUARDIAN	= "sprites/guardian.png";
		public static final String SAKI	= "sprites/saki.png";
		public static final String SNAKE	= "sprites/snake.png";
		public static final String FLANDRE	= "sprites/flandre.png";
		public static final String GHOUL	= "sprites/ghoul.png";
		public static final String RIPPER	= "sprites/ripper.png";
		public static final String SPAWNER	= "sprites/spawner.png";
		public static final String TOJIKO	= "sprites/tojiko.png";
		public static final String PYLON	= "sprites/pylon.png";
		public static final String KANAKO	= "sprites/kanako.png";
		public static final String AKYUU	= "sprites/akyuu.png";
		public static final String KUTAKA	= "sprites/kutaka.png";
		public static final String KYOUKO	= "sprites/kyouko.png";
		public static final String KOGASA	= "sprites/kogasa.png";
		public static final String TENSHI	= "sprites/tenshi.png";
		public static final String CLOWNPIECE	= "sprites/clownpiece.png";
		public static final String EIRIN	= "sprites/eirin.png";
		public static final String SUNNY	= "sprites/sunny.png";
		public static final String LUNA	= "sprites/luna.png";
		public static final String STAR	= "sprites/star.png";
		public static final String KOISHI	= "sprites/koishi.png";
		public static final String KOKORO	= "sprites/kokoro.png";
		public static final String HIJIRI	= "sprites/hijiri.png";
		public static final String LILY	= "sprites/lily.png";
		public static final String MIYOI	= "sprites/miyoi.png";
		public static final String MIKE	= "sprites/mike.png";
		public static final String MIKO	= "sprites/miko.png";
		public static final String AUNN	= "sprites/aunn.png";
		public static final String NEMUNO	= "sprites/nemuno.png";
		public static final String DESTORB	= "sprites/destorb.png";
		public static final String LOTUS	= "sprites/lotus.png";
	}
}
