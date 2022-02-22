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

package com.touhoupixel.touhoupixeldungeon.actors.hero;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Badges;
import com.touhoupixel.touhoupixeldungeon.Bones;
import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.GamesInProgress;
import com.touhoupixel.touhoupixeldungeon.TouhouPixelDungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.CorrosiveGas;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.Fire;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.ParalyticGas;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.ToxicGas;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AdrenalineSurge;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Amok;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AnkhInvulnerability;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiHeal;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiSneakattack;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank1;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank2;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank3;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Awareness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Barkskin;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Berserk;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bleeding;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Burning;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Charm;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Chill;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Combo;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Corrosion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Degrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doubleevasion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Drowsy;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FireBrandBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FireImbue;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Foresight;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Frost;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FrostBrandBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FrostImbue;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.HatResistance;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.HighStress;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.HoldFast;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hunger;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Invisibility;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Light;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.LostInventory;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MindVision;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Momentum;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MoveDetect;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.OneDamage;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.OneDefDamage;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Ooze;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Paralysis;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.PotionPreserve;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Regeneration;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.RingoSurge;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Roots;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SnipersMark;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Stamina;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SuperDegrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SuperOoze;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.UnderwaterCurse;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vertigo;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.YuukaRage;
import com.touhoupixel.touhoupixeldungeon.actors.hero.abilities.ArmorAbility;
import com.touhoupixel.touhoupixeldungeon.actors.hero.abilities.huntress.NaturesPower;
import com.touhoupixel.touhoupixeldungeon.actors.hero.abilities.warrior.Endure;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.*;
import com.touhoupixel.touhoupixeldungeon.effects.CheckedCell;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.effects.SpellSprite;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.Amulet;
import com.touhoupixel.touhoupixeldungeon.items.Ankh;
import com.touhoupixel.touhoupixeldungeon.items.Dewdrop;
import com.touhoupixel.touhoupixeldungeon.items.EquipableItem;
import com.touhoupixel.touhoupixeldungeon.items.Heap;
import com.touhoupixel.touhoupixeldungeon.items.Heap.Type;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.KindOfWeapon;
import com.touhoupixel.touhoupixeldungeon.items.armor.ClassArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.glyphs.AntiMagic;
import com.touhoupixel.touhoupixeldungeon.items.armor.glyphs.Brimstone;
import com.touhoupixel.touhoupixeldungeon.items.armor.glyphs.Viscosity;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.AlchemistsToolkit;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.CapeOfThorns;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.CloakOfShadows;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.DriedRose;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.EtherealChains;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.HornOfPlenty;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.TalismanOfForesight;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.TimekeepersHourglass;
import com.touhoupixel.touhoupixeldungeon.items.bags.MagicalHolster;
import com.touhoupixel.touhoupixeldungeon.items.journal.Guidebook;
import com.touhoupixel.touhoupixeldungeon.items.keys.CrystalKey;
import com.touhoupixel.touhoupixeldungeon.items.keys.GoldenKey;
import com.touhoupixel.touhoupixeldungeon.items.keys.IronKey;
import com.touhoupixel.touhoupixeldungeon.items.keys.Key;
import com.touhoupixel.touhoupixeldungeon.items.keys.SkeletonKey;
import com.touhoupixel.touhoupixeldungeon.items.potions.Potion;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfExperience;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfMight;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfDivineInspiration;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfAccuracy;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfEvasion;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfForce;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfFuror;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfHaste;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfMight;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfTenacity;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.Scroll;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.touhoupixel.touhoupixeldungeon.items.wands.Wand;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfBlastWave;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfLivingEarth;
import com.touhoupixel.touhoupixeldungeon.items.weapon.SpiritBow;
import com.touhoupixel.touhoupixeldungeon.items.weapon.Weapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.AlchemyHat;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.BlazingStar;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.DoubleSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FireBrand;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FireBrand2;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Flail;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Flintlock;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FrostBrand;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FrostBrand2;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FullmoonScythe;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Grayswandir;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.KoishiSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Log;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MagesStaff;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MomoyoShovel;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.PlayMat;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.RunicBlade;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.TurnaboutCloak;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WatermelonSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YukinaMic;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.MissileWeapon;
import com.touhoupixel.touhoupixeldungeon.journal.Document;
import com.touhoupixel.touhoupixeldungeon.journal.Notes;
import com.touhoupixel.touhoupixeldungeon.levels.Level;
import com.touhoupixel.touhoupixeldungeon.levels.Terrain;
import com.touhoupixel.touhoupixeldungeon.levels.features.Chasm;
import com.touhoupixel.touhoupixeldungeon.levels.traps.Trap;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.mechanics.ShadowCaster;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.plants.Earthroot;
import com.touhoupixel.touhoupixeldungeon.plants.Swiftthistle;
import com.touhoupixel.touhoupixeldungeon.scenes.AlchemyScene;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.scenes.InterlevelScene;
import com.touhoupixel.touhoupixeldungeon.scenes.SurfaceScene;
import com.touhoupixel.touhoupixeldungeon.sprites.CharSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.HeroSprite;
import com.touhoupixel.touhoupixeldungeon.ui.AttackIndicator;
import com.touhoupixel.touhoupixeldungeon.ui.BuffIndicator;
import com.touhoupixel.touhoupixeldungeon.ui.QuickSlotButton;
import com.touhoupixel.touhoupixeldungeon.ui.StatusPane;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.touhoupixel.touhoupixeldungeon.windows.WndHero;
import com.touhoupixel.touhoupixeldungeon.windows.WndMessage;
import com.touhoupixel.touhoupixeldungeon.windows.WndResurrect;
import com.touhoupixel.touhoupixeldungeon.windows.WndTradeItem;
import com.watabou.noosa.Camera;
import com.watabou.noosa.Game;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Callback;
import com.watabou.utils.GameMath;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class  Hero extends Char {

	{
		actPriority = HERO_PRIO;

		alignment = Alignment.ALLY;
	}

	public static final int MAX_LEVEL = 99;

	public static final int STARTING_STR = 10;

	private static final float TIME_TO_REST		    = 1f;
	private static final float TIME_TO_SEARCH	    = 2f;
	private static final float HUNGER_FOR_SEARCH	= 6f;

	public com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass heroClass = com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.ROGUE;
	public com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass subClass = com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass.NONE;
	public ArmorAbility armorAbility = null;
	public ArrayList<LinkedHashMap<com.touhoupixel.touhoupixeldungeon.actors.hero.Talent, Integer>> talents = new ArrayList<>();
	public LinkedHashMap<Talent, Talent> metamorphedTalents = new LinkedHashMap<>();

	private int attackSkill = 10;
	private int defenseSkill = 5;

	public boolean ready = false;
	private boolean damageInterrupt = true;
	public HeroAction curAction = null;
	public HeroAction lastAction = null;

	private Char enemy;

	public boolean resting = false;

	public Belongings belongings;

	public int STR;

	public float awareness;

	public int lvl = 1;
	public int exp = 0;

	public int HTBoost = 0;

	private ArrayList<Mob> visibleEnemies;

	//This list is maintained so that some logic checks can be skipped
	// for enemies we know we aren't seeing normally, resultign in better performance
	public ArrayList<Mob> mindVisionEnemies = new ArrayList<>();

	public Hero() {
		super();

		HP = HT = 30;
		STR = STARTING_STR;

		belongings = new Belongings( this );

		visibleEnemies = new ArrayList<>();

		if (Dungeon.isChallenged(Challenges.MASTER_SPARK)){
			STR += 10;
		}
	}

	public void updateHT( boolean boostHP ){
		int curHT = HT;

		if (Dungeon.isChallenged(Challenges.MASTER_SPARK)) {
			HT = 30 + 3 * (lvl - 1) + HTBoost + 30*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GHOST_TENSITY) + 40*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.MORE_GHOST_TENSITY) + 50*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.HUGE_GHOST_TENSITY) + Statistics.deepdwarfHTdown + (Statistics.upgradesUsed*2)*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.UPGRADE_MAXHT_UP) + 15*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.MAXHT_UP);
		} else
			HT = 30 + 5 * (lvl - 1) + HTBoost + 30*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GHOST_TENSITY) + 40*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.MORE_GHOST_TENSITY) + 50*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.HUGE_GHOST_TENSITY) + Statistics.deepdwarfHTdown + (Statistics.upgradesUsed*2)*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.UPGRADE_MAXHT_UP) + 15*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.MAXHT_UP);
		float multiplier = RingOfMight.HTMultiplier(this);
		HT = Math.round(multiplier * HT);

		if (buff(ElixirOfMight.HTBoost.class) != null){
			HT += buff(ElixirOfMight.HTBoost.class).boost();
		}

		if (boostHP){
			HP += Math.max(HT - curHT, 0);
		}
		HP = Math.min(HP, HT);
	}

	public int STR() {
		int strBonus = 0;

		strBonus += RingOfMight.strengthBonus( this );

		AdrenalineSurge buff = buff(AdrenalineSurge.class);
		if (buff != null){
			strBonus += buff.boost();
		}

		RingoSurge buff2 = buff(RingoSurge.class);
		if (buff2 != null){
			strBonus += buff2.boost();
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.STRONGMAN)){
			strBonus += (int)Math.floor(STR * (0.03f + 0.05f*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.STRONGMAN)));
		}

		return STR + strBonus;
	}

	private static final String CLASS       = "class";
	private static final String SUBCLASS    = "subClass";
	private static final String ABILITY     = "armorAbility";

	private static final String ATTACK		= "attackSkill";
	private static final String DEFENSE		= "defenseSkill";
	private static final String STRENGTH	= "STR";
	private static final String LEVEL		= "lvl";
	private static final String EXPERIENCE	= "exp";
	private static final String HTBOOST     = "htboost";

	@Override
	public void storeInBundle( Bundle bundle ) {

		super.storeInBundle( bundle );

		bundle.put( CLASS, heroClass );
		bundle.put( SUBCLASS, subClass );
		bundle.put( ABILITY, armorAbility );
		com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.storeTalentsInBundle( bundle, this );

		bundle.put( ATTACK, attackSkill );
		bundle.put( DEFENSE, defenseSkill );

		bundle.put( STRENGTH, STR );

		bundle.put( LEVEL, lvl );
		bundle.put( EXPERIENCE, exp );

		bundle.put( HTBOOST, HTBoost );

		belongings.storeInBundle( bundle );
	}

	@Override
	public void restoreFromBundle( Bundle bundle ) {

		lvl = bundle.getInt( LEVEL );
		exp = bundle.getInt( EXPERIENCE );

		HTBoost = bundle.getInt(HTBOOST);

		super.restoreFromBundle( bundle );

		heroClass = bundle.getEnum( CLASS, com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.class );
		subClass = bundle.getEnum( SUBCLASS, com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass.class );
		armorAbility = (ArmorAbility)bundle.get( ABILITY );
		com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.restoreTalentsFromBundle( bundle, this );

		attackSkill = bundle.getInt( ATTACK );
		defenseSkill = bundle.getInt( DEFENSE );

		STR = bundle.getInt( STRENGTH );

		belongings.restoreFromBundle( bundle );
	}

	public static void preview( GamesInProgress.Info info, Bundle bundle ) {
		info.level = bundle.getInt( LEVEL );
		info.str = bundle.getInt( STRENGTH );
		info.exp = bundle.getInt( EXPERIENCE );
		info.hp = bundle.getInt( Char.TAG_HP );
		info.ht = bundle.getInt( Char.TAG_HT );
		info.shld = bundle.getInt( Char.TAG_SHLD );
		info.heroClass = bundle.getEnum( CLASS, com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.class );
		info.subClass = bundle.getEnum( SUBCLASS, com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass.class );
		Belongings.preview( info, bundle );
	}

	public boolean hasTalent( com.touhoupixel.touhoupixeldungeon.actors.hero.Talent talent ){
		return pointsInTalent(talent) > 0;
	}

	public int pointsInTalent( com.touhoupixel.touhoupixeldungeon.actors.hero.Talent talent ){
		for (LinkedHashMap<com.touhoupixel.touhoupixeldungeon.actors.hero.Talent, Integer> tier : talents){
			for (com.touhoupixel.touhoupixeldungeon.actors.hero.Talent f : tier.keySet()){
				if (f == talent) return tier.get(f);
			}
		}
		return 0;
	}

	public void upgradeTalent( com.touhoupixel.touhoupixeldungeon.actors.hero.Talent talent ){
		for (LinkedHashMap<com.touhoupixel.touhoupixeldungeon.actors.hero.Talent, Integer> tier : talents){
			for (com.touhoupixel.touhoupixeldungeon.actors.hero.Talent f : tier.keySet()){
				if (f == talent) tier.put(talent, tier.get(talent)+1);
			}
		}
		com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.onTalentUpgraded(this, talent);
	}

	public int talentPointsSpent(int tier){
		int total = 0;
		for (int i : talents.get(tier-1).values()){
			total += i;
		}
		return total;
	}

	public int talentPointsAvailable(int tier){
		if (lvl < com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.tierLevelThresholds[tier]
				|| (tier == 3 && subClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass.NONE)
				|| (tier == 4 && armorAbility == null)){
			return 0;
		} else if (lvl >= com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.tierLevelThresholds[tier+1]){
			return com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.tierLevelThresholds[tier+1] - com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.tierLevelThresholds[tier] - talentPointsSpent(tier);
		} else {
			return 1 + lvl - com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.tierLevelThresholds[tier] - talentPointsSpent(tier);
		}
	}

	public int bonusTalentPoints(int tier){
		if (lvl < (Talent.tierLevelThresholds[tier]-1)
				|| (tier == 3 && subClass == HeroSubClass.NONE)
				|| (tier == 4 && armorAbility == null)) {
			return 0;
		} else if (buff(PotionOfDivineInspiration.DivineInspirationTracker.class) != null
				&& buff(PotionOfDivineInspiration.DivineInspirationTracker.class).isBoosted(tier)) {
			return 2;
		} else {
			return 0;
		}
	}

	public String className() {
		return subClass == null || subClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass.NONE ? heroClass.title() : subClass.title();
	}

	@Override
	public String name(){
		return className();
	}

	@Override
	public void hitSound(float pitch) {
		if ( belongings.weapon() != null ){
			belongings.weapon().hitSound(pitch);
		} else if (RingOfForce.getBuffedBonus(this, RingOfForce.Force.class) > 0) {
			//pitch deepens by 2.5% (additive) per point of strength, down to 75%
			super.hitSound( pitch * GameMath.gate( 0.75f, 1.25f - 0.025f*STR(), 1f) );
		} else {
			super.hitSound(pitch * 1.1f);
		}
	}

	@Override
	public boolean blockSound(float pitch) {
		if ( belongings.weapon() != null && belongings.weapon().defenseFactor(this) >= 4 ){
			Sample.INSTANCE.play( Assets.Sounds.HIT_PARRY, 1, pitch);
			return true;
		}
		return super.blockSound(pitch);
	}

	public void live() {
		for (Buff b : buffs()){
			if (!b.revivePersists) b.detach();
		}
		Buff.affect( this, Regeneration.class );
		Buff.affect( this, Hunger.class );
	}

	public int tier() {
		if (belongings.armor() instanceof ClassArmor){
			return 6;
		} else if (belongings.armor() != null){
			return belongings.armor().tier;
		} else {
			return 0;
		}
	}

	public boolean shoot( Char enemy, MissileWeapon wep ) {

		this.enemy = enemy;

		//temporarily set the hero's weapon to the missile weapon being used
		//TODO improve this!
		belongings.thrownWeapon = wep;
		boolean hit = attack( enemy );
		Invisibility.dispel();
		belongings.thrownWeapon = null;

		if (hit && subClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass.GLADIATOR){
			Buff.affect( this, Combo.class ).hit( enemy );
		}

		return hit;
	}

	@Override
	public int attackSkill( Char target ) {
		KindOfWeapon wep = belongings.weapon();

		float accuracy = 1;
		accuracy *= RingOfAccuracy.accuracyMultiplier( this );

		if (heroClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.MURASA && Dungeon.level.water[pos]) {
			accuracy *= 1.5f;
		}

		if (Dungeon.isChallenged(Challenges.MASTER_SPARK)){
			accuracy *= 0.8f;
		}

		if (buff(ArisastarRank1.class) != null){
			accuracy *= 1.5f;
		}
		if (buff(ArisastarRank2.class) != null){
			accuracy *= 2f;
		}
		if (buff(ArisastarRank3.class) != null){
			accuracy *= 3f;
		}

		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_ACC) == 1){
			accuracy *= 2f;
		}
		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_ACC) == 2){
			accuracy *= 2.5f;
		}
		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_ACC) == 3){
			accuracy *= 3f;
		}

		if (Dungeon.hero.HP < Dungeon.depth && Dungeon.hero.belongings.weapon() instanceof DoubleSword){
			accuracy *= 2f;
		}

		if (Dungeon.hero.belongings.weapon() instanceof Flintlock){
			if (this.HP == 1 || this.HP == 4 || this.HP == 9 || this.HP == 16 || this.HP == 25 || this.HP == 36 || this.HP == 49 || this.HP == 64 || this.HP == 81 || this.HP == 100 || this.HP == 121 || this.HP == 144 || this.HP == 169 || this.HP == 196 || this.HP == 225 || this.HP == 256 || this.HP == 289 || this.HP == 324 || this.HP == 361 || this.HP == 400 || this.HP == 441 || this.HP == 484 || this.HP == 529 || this.HP == 576 || this.HP == 625 || this.HP == 676 || this.HP == 729 || this.HP == 784 || this.HP == 841 || this.HP == 900 || this.HP == 961 || this.HP == 1024){
				accuracy *= 3f;
			}
		}

		if (Dungeon.hero.belongings.weapon() instanceof BlazingStar){
			if (this.HP == 1 || this.HP == 2 || this.HP == 3 || this.HP == 5 || this.HP == 8 || this.HP == 13 || this.HP == 21 || this.HP == 34 || this.HP == 55 || this.HP == 89 || this.HP == 144 || this.HP == 233 || this.HP == 377 || this.HP == 610 || this.HP == 987){
				accuracy *= 4f;
			}
		}

		if (this.pointsInTalent(Talent.CURSED_ACC) == 1) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					accuracy *= 2.5f;
				}
			}
		}
		if (this.pointsInTalent(Talent.CURSED_ACC) == 2) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					accuracy *= 2.75f;
				}
			}
		}
		if (this.pointsInTalent(Talent.CURSED_ACC) == 3) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					accuracy *= 3f;
				}
			}
		}

		if (wep instanceof MissileWeapon){
			if (Dungeon.level.adjacent( pos, target.pos )) {
				accuracy *= (0.5f + 0.2f*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.POINT_BLANK));
			} else {
				accuracy *= 1.5f;
			}
		}
		if (Dungeon.hero.belongings.weapon() instanceof MissileWeapon) {
			accuracy *= (1f + 0.2f*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.EIENTEI_LUCK)+ 0.3f*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.EIENTEI_ENHANCED_LUCK));
		}

		if (wep != null) {
			return (int)(attackSkill * accuracy * wep.accuracyFactor( this ));
		} else {
			return (int)(attackSkill * accuracy);
		}
	}

	@Override
	public int defenseSkill( Char enemy ) {

		if (buff(Combo.ParryTracker.class) != null){
			if (canAttack(enemy)){
				Buff.affect(this, Combo.RiposteTracker.class).enemy = enemy;
			}
			return INFINITE_EVASION;
		}

		float evasion = defenseSkill;

		evasion *= RingOfEvasion.evasionMultiplier( this );

		if (buff(Doubleevasion.class) != null){
			evasion *= 2;
		}

		if (buff(ArisastarRank1.class) != null){
			evasion *= 1.5;
		}
		if (buff(ArisastarRank2.class) != null){
			evasion *= 2;
		}
		if (buff(ArisastarRank3.class) != null){
			evasion *= 3;
		}

		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_EVASION) == 1){
			evasion *= 1.15;
		}
		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_EVASION) == 2){
			evasion *= 1.3;
		}
		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_EVASION) == 3){
			evasion *= 1.5;
		}

		if (paralysed > 0) {
			evasion /= 2;
		}

		if (buff(FireBrandBuff.class) != null){
			evasion *= 0.95;
		}

		if (buff(FrostBrandBuff.class) != null){
			evasion *= 0.95;
		}

		if (belongings.armor() != null) {
			evasion = belongings.armor().evasionFactor(this, evasion);
		}

		return Math.round(evasion);
	}

	@Override
	public String defenseVerb() {
		Combo.ParryTracker parry = buff(Combo.ParryTracker.class);
		if (parry == null){
			return super.defenseVerb();
		} else {
			parry.parried = true;
			if (buff(Combo.class).getComboCount() < 9 || pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.ENHANCED_COMBO) < 2){
				parry.detach();
			}
			return Messages.get(Meiling.class, "parried");
		}
	}

	@Override
	public int drRoll() {
		int dr = 0;

		if (belongings.armor() != null) {
			int armDr = Random.NormalIntRange( belongings.armor().DRMin(), belongings.armor().DRMax());
			if (STR() < belongings.armor().STRReq()){
				armDr -= 2*(belongings.armor().STRReq() - STR());
			}
			if (armDr > 0) dr += armDr;
		}
		if (belongings.weapon() != null)  {
			int wepDr = Random.NormalIntRange( 0 , belongings.weapon().defenseFactor( this ) );
			if (STR() < ((Weapon)belongings.weapon()).STRReq()){
				wepDr -= 2*(((Weapon)belongings.weapon()).STRReq() - STR());
			}
			if (wepDr > 0) dr += wepDr;
		}

		if (buff(HoldFast.class) != null){
			dr += Random.NormalIntRange(0, 2*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.HOLD_FAST));
		}

		return dr;
	}

	@Override
	public int damageRoll() {
		KindOfWeapon wep = belongings.weapon();
		int dmg;

		if (wep != null) {
			dmg = wep.damageRoll( this );
			if (!(wep instanceof MissileWeapon)) dmg += RingOfForce.armedDamageBonus(this);
		} else {
			dmg = RingOfForce.damageRoll(this);
		}
		if (dmg < 0) dmg = 0;

		return dmg;
	}

	@Override
	public float speed() {

		float speed = super.speed();

		if (heroClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.MURASA && Dungeon.level.water[pos]) {
			speed *= 3f;
		}

		speed *= RingOfHaste.speedMultiplier(this);

		if (belongings.armor() != null) {
			speed = belongings.armor().speedFactor(this, speed);
		}

		Momentum momentum = buff(Momentum.class);
		if (momentum != null){
			((HeroSprite)sprite).sprint( momentum.freerunning() ? 1.5f : 1f );
			speed *= momentum.speedMultiplier();
		} else {
			((HeroSprite)sprite).sprint( 1f );
		}

		if (buff(ArisastarRank1.class) != null){
			speed *= 1.5f;
		}
		if (buff(ArisastarRank2.class) != null){
			speed *= 2f;
		}
		if (buff(ArisastarRank3.class) != null){
			speed *= 3f;
		}

		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_SPEED) == 1){
			speed *= 3f;
		}
		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_SPEED) == 2){
			speed *= 4f;
		}
		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_SPEED) == 3){
			speed *= 5f;
		}

		NaturesPower.naturesPowerTracker natStrength = buff(NaturesPower.naturesPowerTracker.class);
		if (natStrength != null){
			speed *= (2f + 0.25f*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GROWING_POWER));
		}

		return speed;

	}

	public boolean canSurpriseAttack(){
		if (belongings.weapon() == null || !(belongings.weapon() instanceof Weapon))    return true;
		if (STR() < ((Weapon)belongings.weapon()).STRReq())                             return false;
		if (Dungeon.isChallenged(Challenges.MASTER_SPARK))                              return false;
		if (this.hasTalent(Talent.CURSED_SNEAKATTACK))                                  return false;
		if (buff(AntiSneakattack.class) != null)                                        return false;
		if (belongings.weapon() instanceof Flail || belongings.weapon() instanceof Log) return false;

		return true;
	}

	public boolean canAttack(Char enemy){
		if (enemy == null || pos == enemy.pos || !Actor.chars().contains(enemy)) {
			return false;
		}

		//can always attack adjacent enemies
		if (Dungeon.level.adjacent(pos, enemy.pos)) {
			return true;
		}

		KindOfWeapon wep = Dungeon.hero.belongings.weapon();

		if (wep != null){
			return wep.canReach(this, enemy.pos);
		} else {
			return false;
		}
	}

	public float attackDelay() {
		if (buff(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.LethalMomentumTracker.class) != null){
			buff(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.LethalMomentumTracker.class).detach();
			return 0;
		}

		if (belongings.weapon() != null) {

			return belongings.weapon().delayFactor( this );

		} else {
			//Normally putting furor speed on unarmed attacks would be unnecessary
			//But there's going to be that one guy who gets a furor+force ring combo
			//This is for that one guy, you shall get your fists of fury!
			return 1f/RingOfFuror.attackSpeedMultiplier(this);
		}
	}

	@Override
	public void spend( float time ) {
		justMoved = false;
		TimekeepersHourglass.timeFreeze freeze = buff(TimekeepersHourglass.timeFreeze.class);
		if (freeze != null) {
			freeze.processTime(time);
			return;
		}

		Swiftthistle.TimeBubble bubble = buff(Swiftthistle.TimeBubble.class);
		if (bubble != null){
			bubble.processTime(time);
			return;
		}

		super.spend(time);
	}

	public void spendAndNext( float time ) {
		busy();
		spend( time );
		next();
	}

	@Override
	public boolean act() {

		//calls to dungeon.observe will also update hero's local FOV.
		fieldOfView = Dungeon.level.heroFOV;

		if (buff(Endure.EndureTracker.class) != null){
			buff(Endure.EndureTracker.class).endEnduring();
		}

		if (!ready) {
			//do a full observe (including fog update) if not resting.
			if (!resting || buff(MindVision.class) != null || buff(Awareness.class) != null) {
				Dungeon.observe();
			} else {
				//otherwise just directly re-calculate FOV
				Dungeon.level.updateFieldOfView(this, fieldOfView);
			}
		}

		checkVisibleMobs();
		BuffIndicator.refreshHero();

		if (paralysed > 0) {

			curAction = null;

			spendAndNext( TICK );
			return false;
		}

		boolean actResult;
		if (curAction == null) {

			if (resting) {
				spend( TIME_TO_REST );
				next();
			} else {
				ready();
			}

			actResult = false;

		} else {

			resting = false;

			ready = false;

			if (curAction instanceof HeroAction.Move) {
				actResult = actMove( (HeroAction.Move)curAction );

			} else if (curAction instanceof HeroAction.Interact) {
				actResult = actInteract( (HeroAction.Interact)curAction );

			} else if (curAction instanceof HeroAction.Buy) {
				actResult = actBuy( (HeroAction.Buy)curAction );

			}else if (curAction instanceof HeroAction.PickUp) {
				actResult = actPickUp( (HeroAction.PickUp)curAction );

			} else if (curAction instanceof HeroAction.OpenChest) {
				actResult = actOpenChest( (HeroAction.OpenChest)curAction );

			} else if (curAction instanceof HeroAction.Unlock) {
				actResult = actUnlock((HeroAction.Unlock) curAction);

			} else if (curAction instanceof HeroAction.Descend) {
				actResult = actDescend( (HeroAction.Descend)curAction );

			} else if (curAction instanceof HeroAction.Ascend) {
				actResult = actAscend( (HeroAction.Ascend)curAction );

			} else if (curAction instanceof HeroAction.Attack) {
				actResult = actAttack( (HeroAction.Attack)curAction );

			} else if (curAction instanceof HeroAction.Alchemy) {
				actResult = actAlchemy( (HeroAction.Alchemy)curAction );

			} else {
				actResult = false;
			}
		}

		if(hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.BARKSKIN) && Dungeon.level.map[pos] == Terrain.FURROWED_GRASS){
			Buff.affect(this, Barkskin.class).set( (lvl*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.BARKSKIN))/2, 1 );
		}

		return actResult;
	}

	public void busy() {
		ready = false;
	}

	private void ready() {
		if (sprite.looping()) sprite.idle();
		curAction = null;
		damageInterrupt = true;
		ready = true;

		AttackIndicator.updateState();

		GameScene.ready();
	}

	public void interrupt() {
		if (isAlive() && curAction != null &&
				((curAction instanceof HeroAction.Move && curAction.dst != pos) ||
						(curAction instanceof HeroAction.Ascend || curAction instanceof HeroAction.Descend))) {
			lastAction = curAction;
		}
		curAction = null;
		GameScene.resetKeyHold();
	}

	public void resume() {
		curAction = lastAction;
		lastAction = null;
		damageInterrupt = false;
		next();
	}

	private boolean actMove( HeroAction.Move action ) {

		if (getCloser( action.dst )) {
			return true;

		} else {
			ready();
			return false;
		}
	}

	private boolean actInteract( HeroAction.Interact action ) {

		Char ch = action.ch;

		if (ch.canInteract(this)) {

			ready();
			sprite.turnTo( pos, ch.pos );
			return ch.interact(this);

		} else {

			if (fieldOfView[ch.pos] && getCloser( ch.pos )) {

				return true;

			} else {
				ready();
				return false;
			}

		}
	}

	private boolean actBuy( HeroAction.Buy action ) {
		int dst = action.dst;
		if (pos == dst) {

			ready();

			Heap heap = Dungeon.level.heaps.get( dst );
			if (heap != null && heap.type == Type.FOR_SALE && heap.size() == 1) {
				Game.runOnRenderThread(new Callback() {
					@Override
					public void call() {
						GameScene.show( new WndTradeItem( heap ) );
					}
				});
			}

			return false;

		} else if (getCloser( dst )) {

			return true;

		} else {
			ready();
			return false;
		}
	}

	private boolean actAlchemy( HeroAction.Alchemy action ) {
		int dst = action.dst;
		if (Dungeon.level.distance(dst, pos) <= 1) {

			ready();

			AlchemistsToolkit.kitEnergy kit = buff(AlchemistsToolkit.kitEnergy.class);
			if (kit != null && kit.isCursed()){
				GLog.w( Messages.get(AlchemistsToolkit.class, "cursed"));
				return false;
			}

			AlchemyScene.clearToolkit();
			TouhouPixelDungeon.switchScene(AlchemyScene.class);
			return false;

		} else if (getCloser( dst )) {

			return true;

		} else {
			ready();
			return false;
		}
	}

	private boolean actPickUp( HeroAction.PickUp action ) {
		int dst = action.dst;
		if (pos == dst) {

			Heap heap = Dungeon.level.heaps.get( pos );
			if (heap != null) {
				Item item = heap.peek();
				if (item.doPickUp( this )) {
					heap.pickUp();

					if (item instanceof Dewdrop
							|| item instanceof TimekeepersHourglass.sandBag
							|| item instanceof DriedRose.Petal
							|| item instanceof Key) {
						//Do Nothing
					} else {

						//TODO make all unique items important? or just POS / SOU?
						boolean important = item.unique && item.isIdentified() &&
								(item instanceof Scroll || item instanceof Potion);
						if (important) {
							GLog.p( Messages.get(this, "you_now_have", item.name()) );
						} else {
							GLog.i( Messages.get(this, "you_now_have", item.name()) );
						}
					}

					curAction = null;
				} else {

					if (item instanceof Dewdrop
							|| item instanceof TimekeepersHourglass.sandBag
							|| item instanceof DriedRose.Petal
							|| item instanceof Key) {
						//Do Nothing
					} else {
						GLog.newLine();
						GLog.n(Messages.get(this, "you_cant_have", item.name()));
					}

					heap.sprite.drop();
					ready();
				}
			} else {
				ready();
			}

			return false;

		} else if (getCloser( dst )) {

			return true;

		} else {
			ready();
			return false;
		}
	}

	private boolean actOpenChest( HeroAction.OpenChest action ) {
		int dst = action.dst;
		if (Dungeon.level.adjacent( pos, dst ) || pos == dst) {

			Heap heap = Dungeon.level.heaps.get( dst );
			if (heap != null && (heap.type != Type.HEAP && heap.type != Type.FOR_SALE)) {

				if ((heap.type == Type.LOCKED_CHEST && Notes.keyCount(new GoldenKey(Dungeon.depth)) < 1)
						|| (heap.type == Type.CRYSTAL_CHEST && Notes.keyCount(new CrystalKey(Dungeon.depth)) < 1)){

					GLog.w( Messages.get(this, "locked_chest") );
					ready();
					return false;

				}

				switch (heap.type) {
					case TOMB:
						Sample.INSTANCE.play( Assets.Sounds.TOMB );
						Camera.main.shake( 1, 0.5f );
						break;
					case SKELETON:
					case REMAINS:
						break;
					default:
						Sample.INSTANCE.play( Assets.Sounds.UNLOCK );
				}

				sprite.operate( dst );

			} else {
				ready();
			}

			return false;

		} else if (getCloser( dst )) {

			return true;

		} else {
			ready();
			return false;
		}
	}

	private boolean actUnlock( HeroAction.Unlock action ) {
		int doorCell = action.dst;
		if (Dungeon.level.adjacent( pos, doorCell )) {

			boolean hasKey = false;
			int door = Dungeon.level.map[doorCell];

			if (door == Terrain.LOCKED_DOOR
					&& Notes.keyCount(new IronKey(Dungeon.depth)) > 0) {

				hasKey = true;

			} else if (door == Terrain.LOCKED_EXIT
					&& Notes.keyCount(new SkeletonKey(Dungeon.depth)) > 0) {

				hasKey = true;

			}

			if (hasKey) {

				sprite.operate( doorCell );

				Sample.INSTANCE.play( Assets.Sounds.UNLOCK );

			} else {
				GLog.w( Messages.get(this, "locked_door") );
				ready();
			}

			return false;

		} else if (getCloser( doorCell )) {

			return true;

		} else {
			ready();
			return false;
		}
	}

	private boolean actDescend( HeroAction.Descend action ) {
		int stairs = action.dst;

		if (rooted) {
			Camera.main.shake(1, 1f);
			ready();
			return false;
			//there can be multiple exit tiles, so descend on any of them
			//TODO this is slightly brittle, it assumes there are no disjointed sets of exit tiles
		} else if ((Dungeon.level.map[pos] == Terrain.EXIT || Dungeon.level.map[pos] == Terrain.UNLOCKED_EXIT)) {

			curAction = null;

			TimekeepersHourglass.timeFreeze timeFreeze = buff(TimekeepersHourglass.timeFreeze.class);
			if (timeFreeze != null) timeFreeze.disarmPressedTraps();
			Swiftthistle.TimeBubble timeBubble = buff(Swiftthistle.TimeBubble.class);
			if (timeBubble != null) timeBubble.disarmPressedTraps();

			InterlevelScene.mode = InterlevelScene.Mode.DESCEND;
			Game.switchScene( InterlevelScene.class );

			return false;

		} else if (getCloser( stairs )) {

			return true;

		} else {
			ready();
			return false;
		}
	}

	private boolean actAscend( HeroAction.Ascend action ) {
		int stairs = action.dst;

		if (rooted){
			Camera.main.shake( 1, 1f );
			ready();
			return false;
			//there can be multiple entrance tiles, so descend on any of them
			//TODO this is slightly brittle, it assumes there are no disjointed sets of entrance tiles
		} else if (Dungeon.level.map[pos] == Terrain.ENTRANCE) {

			if (Dungeon.depth == 1) {

				if (belongings.getItem( Amulet.class ) == null) {
					Game.runOnRenderThread(new Callback() {
						@Override
						public void call() {
							GameScene.show( new WndMessage( Messages.get(Hero.this, "leave") ) );
						}
					});
					ready();
				} else {
					Badges.silentValidateHappyEnd();
					Dungeon.win( Amulet.class );
					Dungeon.deleteGame( GamesInProgress.curSlot, true );
					Game.switchScene( SurfaceScene.class );
				}

			} else {

				curAction = null;

				TimekeepersHourglass.timeFreeze timeFreeze = buff(TimekeepersHourglass.timeFreeze.class);
				if (timeFreeze != null) timeFreeze.disarmPressedTraps();
				Swiftthistle.TimeBubble timeBubble = buff(Swiftthistle.TimeBubble.class);
				if (timeBubble != null) timeBubble.disarmPressedTraps();

				InterlevelScene.mode = InterlevelScene.Mode.ASCEND;
				Game.switchScene( InterlevelScene.class );
			}

			return false;

		} else if (getCloser( stairs )) {

			return true;

		} else {
			ready();
			return false;
		}
	}

	private boolean actAttack( HeroAction.Attack action ) {

		enemy = action.target;

		if (enemy.isAlive() && canAttack( enemy ) && !isCharmedBy( enemy )) {

			sprite.attack( enemy.pos );

			return false;

		} else {

			if (fieldOfView[enemy.pos] && getCloser( enemy.pos )) {

				return true;

			} else {
				ready();
				return false;
			}

		}
	}

	public Char enemy(){
		return enemy;
	}

	public void rest( boolean fullRest ) {
		spendAndNext( TIME_TO_REST );
		if (!fullRest) {
			if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.HOLD_FAST)){
				Buff.affect(this, HoldFast.class);
			}
			if (sprite != null) {
				sprite.showStatus(CharSprite.DEFAULT, Messages.get(this, "wait"));
			}
		}
		resting = fullRest;
	}

	@Override
	public int attackProc( final Char enemy, int damage ) {
		damage = super.attackProc(enemy, damage);

		if (heroClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.MURASA && (Random.Int(5) == 0)) {
			Dungeon.level.setCellToWater(false, enemy.pos);
		}

		if (buff(FireBrandBuff.class) != null){
			Buff.affect(this, FireImbue.class).set(FireImbue.DURATION);
			damage *= 2.5f;
		}

		if (buff(FrostBrandBuff.class) != null){
			Buff.affect(this, FrostImbue.class, FrostImbue.DURATION);
			damage *= 2.5f;
		}

		if (Dungeon.hero.belongings.weapon() instanceof FireBrand2 && enemy.properties().contains(Char.Property.ANIMAL)){
			damage *= 2f;
		}

		if (Dungeon.hero.belongings.weapon() instanceof FrostBrand2 && enemy.properties().contains(Char.Property.YOKAI)){
			damage *= 2f;
		}

		if (Dungeon.hero.belongings.weapon() instanceof FireBrand2 && enemy.buff(Burning.class) != null){
			damage *= 10f;
		}

		if (Dungeon.hero.belongings.weapon() instanceof FrostBrand2 && enemy.buff(Chill.class) != null){
			damage *= 10f;
		}

		if (Dungeon.hero.belongings.weapon() instanceof Grayswandir){
			if (Dungeon.depth == 46 || Dungeon.depth == 47 || Dungeon.depth == 48 || Dungeon.depth == 49 || Dungeon.depth == 50 || Dungeon.depth == 96 || Dungeon.depth == 97 || Dungeon.depth == 98 || Dungeon.depth == 99 || Dungeon.depth == 100){
				damage *= 2.5f;
			}
		}

		if (Dungeon.hero.belongings.weapon() instanceof PlayMat && buff(Weakness.class) != null && enemy.buff(Weakness.class) != null){
			damage *= 1f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof PlayMat && buff(Weakness.class) != null && enemy.buff(Vulnerable.class) != null){
			damage *= 1.5f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof PlayMat && buff(Weakness.class) != null && enemy.buff(Hex.class) != null){
			damage *= 0.75f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof PlayMat && buff(Vulnerable.class) != null && enemy.buff(Weakness.class) != null){
			damage *= 0.75f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof PlayMat && buff(Vulnerable.class) != null && enemy.buff(Vulnerable.class) != null){
			damage *= 1f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof PlayMat && buff(Vulnerable.class) != null && enemy.buff(Hex.class) != null){
			damage *= 1.5f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof PlayMat && buff(Hex.class) != null && enemy.buff(Weakness.class) != null){
			damage *= 1.5f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof PlayMat && buff(Hex.class) != null && enemy.buff(Vulnerable.class) != null){
			damage *= 0.75f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof PlayMat && buff(Hex.class) != null && enemy.buff(Hex.class) != null){
			damage *= 1f;
		}

		if (Dungeon.hero.belongings.weapon() instanceof MomoyoShovel){
			if (this.HP == 2 || this.HP == 3 || this.HP == 5 || this.HP == 7 || this.HP == 11 || this.HP == 13 || this.HP == 17 || this.HP == 19 || this.HP == 23 || this.HP == 29 || this.HP == 31 || this.HP == 37 || this.HP == 41 || this.HP == 43 || this.HP == 47 || this.HP == 53 || this.HP == 59 || this.HP == 61 || this.HP == 67 || this.HP == 71 || this.HP == 73 || this.HP == 79 || this.HP == 83 || this.HP == 89 || this.HP == 97 || this.HP == 101 || this.HP == 103 || this.HP == 107 || this.HP == 109 || this.HP == 113 || this.HP == 127 || this.HP == 131 || this.HP == 137 || this.HP == 139 || this.HP == 149 || this.HP == 151 || this.HP == 157 || this.HP == 163 || this.HP == 167 || this.HP == 173 || this.HP == 179 || this.HP == 181 || this.HP == 191 || this.HP == 193 || this.HP == 197 || this.HP == 199 || this.HP == 211 || this.HP == 223 || this.HP == 227 || this.HP == 229 || this.HP == 233 || this.HP == 239 || this.HP == 241 || this.HP == 251 || this.HP == 257 || this.HP == 263 || this.HP == 269 || this.HP == 271 || this.HP == 277 || this.HP == 281 || this.HP == 283 || this.HP == 293){
				damage *= 3f;
			}
		}

		if (Dungeon.hero.belongings.weapon() instanceof WatermelonSword){
			if (this.HP == 9 || this.HP == 19 || this.HP == 29 || this.HP == 39 || this.HP == 49 || this.HP == 59 || this.HP == 69 || this.HP == 79 || this.HP == 89 || this.HP == 90 || this.HP == 91 || this.HP == 92 || this.HP == 93 || this.HP == 94 || this.HP == 95 || this.HP == 96 || this.HP == 97 || this.HP == 98 || this.HP == 109 || this.HP == 119 || this.HP == 129 || this.HP == 139 || this.HP == 149 || this.HP == 159 || this.HP == 169 || this.HP == 179 || this.HP == 189 || this.HP == 190 || this.HP == 191 || this.HP == 192 || this.HP == 193 || this.HP == 194 || this.HP == 195 || this.HP == 196 || this.HP == 197 || this.HP == 198 || this.HP == 209 || this.HP == 219 || this.HP == 229 || this.HP == 239 || this.HP == 249 || this.HP == 259 || this.HP == 269 || this.HP == 279 || this.HP == 289 || this.HP == 290 || this.HP == 291 || this.HP == 292 || this.HP == 293 || this.HP == 294 || this.HP == 295 || this.HP == 296 || this.HP == 297 || this.HP == 298){
				damage *= 3f;
			}
		}

		if (Dungeon.hero.belongings.weapon() instanceof WatermelonSword){
			if (this.HP == 99 || this.HP == 199 || this.HP == 299){
				damage *= 9f;
			}
		}

		if (Dungeon.hero.belongings.weapon() instanceof YukinaMic && enemy.properties().contains(Char.Property.ANIMAL)) {
			damage *= 0.05f;
		}

		if (Dungeon.hero.belongings.weapon() instanceof YukinaMic && !enemy.properties().contains(Char.Property.ANIMAL)) {
			damage *= 2f;
		}

		if (Dungeon.hero.belongings.weapon() instanceof BlazingStar){
			if (this.HP == 1 || this.HP == 2 || this.HP == 3 || this.HP == 5 || this.HP == 8 || this.HP == 13 || this.HP == 16 || this.HP == 21 || this.HP == 34 || this.HP == 55 || this.HP == 81 || this.HP == 89 || this.HP == 144 || this.HP == 233 || this.HP == 256 || this.HP == 377 || this.HP == 610 || this.HP == 625 || this.HP == 987){
				damage *= 4f;
			}
		}

		if (Dungeon.hero.belongings.weapon() instanceof WatermelonSword && enemy.properties().contains(Char.Property.BOSS)){
				damage *= 0.5f;
		}

		if (Dungeon.hero.belongings.weapon() instanceof Flintlock){
			if (this.HP == 1 || this.HP == 4 || this.HP == 9 || this.HP == 16 || this.HP == 25 || this.HP == 36 || this.HP == 49 || this.HP == 64 || this.HP == 81 || this.HP == 100 || this.HP == 121 || this.HP == 144 || this.HP == 169 || this.HP == 196 || this.HP == 225 || this.HP == 256 || this.HP == 289 || this.HP == 324 || this.HP == 361 || this.HP == 400 || this.HP == 441 || this.HP == 484 || this.HP == 529 || this.HP == 576 || this.HP == 625 || this.HP == 676 || this.HP == 729 || this.HP == 784 || this.HP == 841 || this.HP == 900 || this.HP == 961 || this.HP == 1024){
				damage *= 5f;
			}
		}

		if (Dungeon.hero.belongings.weapon() instanceof FullmoonScythe){
			if (this.lvl == 1 || this.lvl == 3 || this.lvl == 5 || this.lvl == 7 || this.lvl == 9 || this.lvl == 11 || this.lvl == 13 || this.lvl == 15 || this.lvl == 17 || this.lvl == 19 || this.lvl == 21 || this.lvl == 23 || this.lvl == 25 || this.lvl == 27 || this.lvl == 29 || this.lvl == 31 || this.lvl == 33 || this.lvl == 35 || this.lvl == 37 || this.lvl == 39 || this.lvl == 41 || this.lvl == 43 || this.lvl == 45 || this.lvl == 47 || this.lvl == 49 || this.lvl == 51 || this.lvl == 53 || this.lvl == 55 || this.lvl == 57 || this.lvl == 59 || this.lvl == 61 || this.lvl == 63 || this.lvl == 65 || this.lvl == 67 || this.lvl == 69 || this.lvl == 71 || this.lvl == 73 || this.lvl == 75 || this.lvl == 77 || this.lvl == 79 || this.lvl == 81 || this.lvl == 83 || this.lvl == 85 || this.lvl == 87 || this.lvl == 89 || this.lvl == 91 || this.lvl == 93 || this.lvl == 95 || this.lvl == 97 || this.lvl == 99){
			damage *= 1.5f;
				Buff.affect(enemy, Bleeding.class).set(12);
			}
		}

		if (Dungeon.hero.belongings.weapon() instanceof RunicBlade && Statistics.amuletObtained){
			damage *= 2f;
		}

		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_DAMAGE) == 1){
			damage *= 1.25f;
		}
		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_DAMAGE) == 2){
			damage *= 1.5f;
		}
		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_DAMAGE) == 3){
			damage *= 1.75f;
		}
		if (Dungeon.hero.HP == Dungeon.hero.HT && Dungeon.hero.pointsInTalent(Talent.MAXHP_DAMAGE) == 4){
			damage *= 2f;
		}

		if (Dungeon.hero.HP < enemy.HP && Dungeon.hero.belongings.weapon() instanceof TurnaboutCloak){
			damage *= 2f;
		}

		if (Dungeon.hero.HP < Dungeon.depth && Dungeon.hero.belongings.weapon() instanceof DoubleSword){
			damage *= 3f;
		}

		if (buff(ArisastarRank1.class) != null){
			damage *= 1.5f;
		}
		if (buff(ArisastarRank2.class) != null){
			damage *= 2f;
		}
		if (buff(ArisastarRank3.class) != null){
			damage *= 3f;
		}

		if (heroClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.REISEN && Dungeon.hero.belongings.weapon() instanceof MissileWeapon) {
			damage *= 1.5f;
		}

		if (enemy instanceof Yuuka && Dungeon.hero.belongings.weapon() instanceof MissileWeapon) {
			damage *= 0f;
		}

		if (this.pointsInTalent(Talent.CURSED_SNEAKATTACK) == 1) {
			damage *= 1.6f;
		}
		if (this.pointsInTalent(Talent.CURSED_SNEAKATTACK) == 2) {
			damage *= 1.7f;
		}
		if (this.pointsInTalent(Talent.CURSED_SNEAKATTACK) == 3) {
			damage *= 1.8f;
		}

		if (heroClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.MURASA && Dungeon.level.water[pos]) {
			damage *= 1.8f;
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MINDVISION) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MINDVISION) == 1) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, MindVision.class, MindVision.DURATION / 20f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MINDVISION) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MINDVISION) == 2) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, MindVision.class, MindVision.DURATION);
				}
			}
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_HASTE) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_HASTE) == 1) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					if ((Random.Int(5) == 0)) {
						Buff.prolong(this, Haste.class, Haste.DURATION / 2f);
					}
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_HASTE) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_HASTE) == 2) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					if ((Random.Int(5) == 0)) {
						Buff.prolong(this, Haste.class, Haste.DURATION);
					}
				}
			}
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_INVU) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_INVU) == 1) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					if ((Random.Int(8) == 0)) {
						Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION / 2f);
					}
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_INVU) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_INVU) == 2) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					if ((Random.Int(8) == 0)) {
						Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION);
					}
				}
			}
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MIGHT) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MIGHT) == 1) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Might.class, Might.DURATION / 4f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MIGHT) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MIGHT) == 2) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Might.class, Might.DURATION / 2f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MIGHT) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MIGHT) == 3) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Might.class, Might.DURATION / 2f);
					Buff.prolong(this, Bless.class, Bless.DURATION);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MIGHT) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_MIGHT) == 4) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Might.class, Might.DURATION);
					Buff.prolong(this, Bless.class, Bless.DURATION);
				}
			}
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_SPEED) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_SPEED)==1) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Doublespeed.class, Doublespeed.DURATION / 4f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_SPEED) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_SPEED)==2) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Doublespeed.class, Doublespeed.DURATION / 2f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_SPEED) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_SPEED)==3) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION / 2f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_SPEED) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_SPEED)==4) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION);
				}
			}
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_EVASION) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_EVASION)==1) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Doubleevasion.class, Doubleevasion.DURATION / 4f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_EVASION) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_EVASION)==2) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Doubleevasion.class, Doubleevasion.DURATION / 2f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_EVASION) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_EVASION)==3) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Doubleevasion.class, Doubleevasion.DURATION / 2f);
					Buff.prolong(this, Light.class, Light.DURATION / 10f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_EVASION) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_EVASION)==4) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Doubleevasion.class, Doubleevasion.DURATION);
					Buff.prolong(this, Light.class, Light.DURATION / 10f);
				}
			}
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.INVU_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.INVU_ATTACK)==1 && (Random.Int(12) == 0)){
			Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION / 3f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.INVU_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.INVU_ATTACK)==2 && (Random.Int(10) == 0)){
			Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION / 3f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.INVU_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.INVU_ATTACK)==3 && (Random.Int(8) == 0)){
			Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION / 3f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.INVU_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.INVU_ATTACK)==4 && (Random.Int(6) == 0)){
			Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION / 3f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.TRIPLESPEED_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.TRIPLESPEED_ATTACK)==1 && (Random.Int(12) == 0)){
			Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION / 5f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.TRIPLESPEED_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.TRIPLESPEED_ATTACK)==2 && (Random.Int(10) == 0)){
			Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION / 5f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.TRIPLESPEED_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.TRIPLESPEED_ATTACK)==3 && (Random.Int(8) == 0)){
			Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION / 5f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.TRIPLESPEED_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.TRIPLESPEED_ATTACK)==4 && (Random.Int(6) == 0)){
			Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION / 5f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.POTION_PRESERVE_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.POTION_PRESERVE_ATTACK)==1 && (Random.Int(12) == 0)){
			Buff.prolong(this, PotionPreserve.class, PotionPreserve.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.POTION_PRESERVE_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.POTION_PRESERVE_ATTACK)==2 && (Random.Int(10) == 0)){
			Buff.prolong(this, PotionPreserve.class, PotionPreserve.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.POTION_PRESERVE_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.POTION_PRESERVE_ATTACK)==3 && (Random.Int(8) == 0)){
			Buff.prolong(this, PotionPreserve.class, PotionPreserve.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.POTION_PRESERVE_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.POTION_PRESERVE_ATTACK)==4 && (Random.Int(6) == 0)){
			Buff.prolong(this, PotionPreserve.class, PotionPreserve.DURATION);
		}

		if (heroClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.YUYUKO && (Random.Int(12-pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.COMING_DEATH)-pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.COMING_MORE_DEATH)) == 0) && !enemy.properties().contains(Char.Property.BOSS)){
			enemy.damage(enemy.HP, this);
			enemy.sprite.emitter().burst(ShadowParticle.UP, 5);
		}

		if (heroClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.MURASA && (Random.Int(10-pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INSTAKILL)-pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MORE_INSTAKILL)) == 0) && Dungeon.level.water[enemy.pos] && !enemy.properties().contains(Char.Property.BOSS)){
			enemy.damage(enemy.HP, this);
			enemy.sprite.emitter().burst(ShadowParticle.UP, 5);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.ANIMAL_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.ANIMAL_MEAL)==1 && enemy.properties().contains(Property.ANIMAL)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(10);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.ANIMAL_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.ANIMAL_MEAL)==2 && enemy.properties().contains(Property.ANIMAL)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(15);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.ANIMAL_ENHANCED_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.ANIMAL_ENHANCED_MEAL)==1 && enemy.properties().contains(Property.ANIMAL)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(30);
			this.HP = Math.min(this.HP + 2, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.ANIMAL_ENHANCED_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.ANIMAL_ENHANCED_MEAL)==2 && enemy.properties().contains(Property.ANIMAL)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 3, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MIGHT) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MIGHT)==1 && (Random.Int(7) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Might.class, Might.DURATION/5f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MIGHT) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MIGHT)==2 && (Random.Int(7) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Might.class, Might.DURATION/4f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MIGHT) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MIGHT)==3 && (Random.Int(7) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Might.class, Might.DURATION/2f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MIGHT) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MIGHT)==4 && (Random.Int(7) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Might.class, Might.DURATION);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_TRIPLESPEED) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_TRIPLESPEED)==1 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION/10f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_TRIPLESPEED) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_TRIPLESPEED)==2 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION/5f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_TRIPLESPEED) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_TRIPLESPEED)==3 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION/2f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_TRIPLESPEED) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_TRIPLESPEED)==4 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVU) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVU)==1 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION/6f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVU) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVU)==2 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION/3f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVU) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVU)==3 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION/2f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVU) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVU)==4 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION);
		}



		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.YOKAI_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.YOKAI_MEAL)==1 && enemy.properties().contains(Property.YOKAI)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 10, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.YOKAI_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.YOKAI_MEAL)==2 && enemy.properties().contains(Property.YOKAI)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 14, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.YOKAI_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.YOKAI_MEAL)==3 && enemy.properties().contains(Property.YOKAI)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 18, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.YOKAI_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.YOKAI_MEAL)==4 && enemy.properties().contains(Property.YOKAI)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 22, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.FLOAT_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.FLOAT_MEAL)==1 && enemy.properties().contains(Property.FLOAT)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 10, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.FLOAT_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.FLOAT_MEAL)==2 && enemy.properties().contains(Property.FLOAT)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 14, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.FLOAT_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.FLOAT_MEAL)==3 && enemy.properties().contains(Property.FLOAT)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 18, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.FLOAT_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.FLOAT_MEAL)==4 && enemy.properties().contains(Property.FLOAT)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 22, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GOD_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GOD_MEAL)==1 && enemy.properties().contains(Property.GOD)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 10, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GOD_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GOD_MEAL)==2 && enemy.properties().contains(Property.GOD)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 14, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GOD_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GOD_MEAL)==3 && enemy.properties().contains(Property.GOD)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 18, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GOD_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.GOD_MEAL)==4 && enemy.properties().contains(Property.GOD)){
			Hunger hunger = Buff.affect(this, Hunger.class);
			hunger.affectHunger(40);
			this.HP = Math.min(this.HP + 22, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.DOOM_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.DOOM_ATTACK)==1){
			if ((Random.Int(10) == 0))
				Buff.affect(enemy, com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom.class);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.DOOM_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.DOOM_ATTACK)==2){
			if ((Random.Int(8) == 0))
				Buff.affect(enemy, com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom.class);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.DOOM_ATTACK) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.DOOM_ATTACK)==3){
			if ((Random.Int(6) == 0))
				Buff.affect(enemy, com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom.class);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.EVERYONE_IS_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.EVERYONE_IS_MEAL)==1){
			this.HP = Math.min(this.HP + 4, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.EVERYONE_IS_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.EVERYONE_IS_MEAL)==2){
			this.HP = Math.min(this.HP + 5, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.EVERYONE_IS_MEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.EVERYONE_IS_MEAL)==3){
			this.HP = Math.min(this.HP + 6, this.HT);
			this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_STAMINA) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_STAMINA)==1 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Stamina.class, Stamina.DURATION / 10f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_STAMINA) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_STAMINA)==2 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Stamina.class, Stamina.DURATION / 4f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_STAMINA) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_STAMINA)==3 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Stamina.class, Stamina.DURATION / 2f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_HASTE) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_HASTE)==1 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Haste.class, Haste.DURATION / 5f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_HASTE) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_HASTE)==2 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Haste.class, Haste.DURATION / 4f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_HASTE) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_HASTE)==3 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Haste.class, Haste.DURATION / 2f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MINDVISION) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MINDVISION)==1 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, MindVision.class, MindVision.DURATION / 5f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MINDVISION) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MINDVISION)==2 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, MindVision.class, MindVision.DURATION / 4f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MINDVISION) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_MINDVISION)==3 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, MindVision.class, MindVision.DURATION / 2f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_PARALYSIS) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_PARALYSIS)==1 && (Random.Int(8) == 0) && Dungeon.level.water[enemy.pos]){
			Buff.prolong(enemy, Paralysis.class, Paralysis.DURATION / 2f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_PARALYSIS) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_PARALYSIS)==2 && (Random.Int(7) == 0) && Dungeon.level.water[enemy.pos]){
			Buff.prolong(enemy, Paralysis.class, Paralysis.DURATION / 2f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_PARALYSIS) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_PARALYSIS)==3 && (Random.Int(6) == 0) && Dungeon.level.water[enemy.pos]){
			Buff.prolong(enemy, Paralysis.class, Paralysis.DURATION / 2f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_SLOW) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_SLOW)==1 && (Random.Int(8) == 0) && Dungeon.level.water[enemy.pos]){
			Buff.prolong(enemy, Slow.class, Slow.DURATION / 2f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_SLOW) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_SLOW)==2 && (Random.Int(7) == 0) && Dungeon.level.water[enemy.pos]){
			Buff.prolong(enemy, Slow.class, Slow.DURATION / 2f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_SLOW) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_SLOW)==3 && (Random.Int(6) == 0) && Dungeon.level.water[enemy.pos]){
			Buff.prolong(enemy, Slow.class, Slow.DURATION / 2f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_LIGHT) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_LIGHT)==1 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Light.class, Light.DURATION / 5f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_LIGHT) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_LIGHT)==2 && (Random.Int(5) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Light.class, Light.DURATION / 2f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_BLESS) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_BLESS)==1 && (Random.Int(3) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Bless.class, Bless.DURATION / 2f);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_BLESS) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_BLESS)==2 && (Random.Int(3) == 0) && Dungeon.level.water[pos]){
			Buff.prolong(this, Bless.class, Bless.DURATION);
		}

		KindOfWeapon wep = belongings.weapon();

		if (wep != null) damage = wep.proc( this, enemy, damage );

		if (buff(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SpiritBladesTracker.class) != null
				&& Random.Int(10) < 3*pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIRIT_BLADES)){
			SpiritBow bow = belongings.getItem(SpiritBow.class);
			if (bow != null) damage = bow.proc( this, enemy, damage );
			buff(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SpiritBladesTracker.class).detach();
		}

		damage = com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.onAttackProc( this, enemy, damage );

		switch (subClass) {
			case SNIPER:
				if (wep instanceof MissileWeapon && !(wep instanceof SpiritBow.SpiritArrow) && enemy != this) {
					Actor.add(new Actor() {

						{
							actPriority = VFX_PRIO;
						}

						@Override
						protected boolean act() {
							if (enemy.isAlive()) {
								int bonusTurns = hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SHARED_UPGRADES) ? wep.buffedLvl() : 0;
								Buff.prolong(Hero.this, SnipersMark.class, SnipersMark.DURATION + bonusTurns).set(enemy.id(), bonusTurns);
							}
							Actor.remove(this);
							return true;
						}
					});
				}
				break;
			default:
		}

		return damage;
	}

	@Override
	public int defenseProc( Char enemy, int damage ) {

		if (heroClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.MURASA && (Random.Int(5) == 0)){
			Dungeon.level.setCellToWater(false, pos);
		}

		if (Dungeon.hero.belongings.weapon() instanceof KoishiSword && (Random.Int(4) == 0)){
			Buff.prolong(this, Invisibility.class, Invisibility.DURATION / 4f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_INVISIBILITY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_INVISIBILITY)==1) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Invisibility.class, Invisibility.DURATION / 4f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_INVISIBILITY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_INVISIBILITY)==2) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Invisibility.class, Invisibility.DURATION / 2f);
				}
			}
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_INVISIBILITY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.CURSED_INVISIBILITY)==3){
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					Buff.prolong(this, Invisibility.class, Invisibility.DURATION);
				}
			}
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_BLIND) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_BLIND)==1){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 2);
			Buff.prolong(enemy, Blindness.class, Blindness.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_BLIND) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_BLIND)==2){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 4);
			Buff.prolong(enemy, Blindness.class, Blindness.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_BLIND) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_BLIND)==3){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 6);
			Buff.prolong(enemy, Blindness.class, Blindness.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEX) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEX)==1){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 2);
			Buff.prolong(enemy, Hex.class, Hex.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEX) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEX)==2){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 4);
			Buff.prolong(enemy, Hex.class, Hex.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEX) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEX)==3){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 6);
			Buff.prolong(enemy, Hex.class, Hex.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEAL)==1){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 2);
			this.HP = Math.min(this.HP + 3, this.HT);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEAL)==2){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 4);
			this.HP = Math.min(this.HP + 6, this.HT);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEAL) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_HEAL)==3){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 6);
			this.HP = Math.min(this.HP + 9, this.HT);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_CHARM) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_CHARM)==1){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 2);
			Buff.prolong(enemy, Charm.class, Charm.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_CHARM) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_CHARM)==2){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 4);
			Buff.prolong(enemy, Charm.class, Charm.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_CHARM) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_CHARM)==3){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 6);
			Buff.prolong(enemy, Charm.class, Charm.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_CHARM) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_CHARM)==4){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 8);
			Buff.prolong(enemy, Charm.class, Charm.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_DOOM) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_DOOM)==1){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 2);
			Buff.affect(enemy, com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom.class);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_DOOM) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_DOOM)==2){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 4);
			Buff.affect(enemy, com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom.class);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_DOOM) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_DOOM)==3){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 6);
			Buff.affect(enemy, com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom.class);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_DOOM) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_DOOM)==4){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 8);
			Buff.affect(enemy, com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom.class);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_PARALYSIS) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_PARALYSIS)==1){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 2);
			Buff.prolong(enemy, Paralysis.class, Paralysis.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_PARALYSIS) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_PARALYSIS)==2){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 4);
			Buff.prolong(enemy, Paralysis.class, Paralysis.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_PARALYSIS) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_PARALYSIS)==3){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 6);
			Buff.prolong(enemy, Paralysis.class, Paralysis.DURATION);
		}
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_PARALYSIS) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SPIN_PARALYSIS)==4){
			Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
			//trim it to just be the part that goes past them
			trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
			//knock them back along that ballistica
			WandOfBlastWave.throwChar(enemy, trajectory, 8);
			Buff.prolong(enemy, Paralysis.class, Paralysis.DURATION);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY)==1){
			Buff.affect( enemy, Bleeding.class ).set( 14 );
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY)==1){
			Buff.affect( enemy, Bleeding.class ).set( 14 );
		}

		if ( buff(HighStress.class) != null ){
			HP = 1;
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY)==1){
			Buff.affect( enemy, Bleeding.class ).set( 14 );
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY)==2){
			Buff.affect( enemy, Bleeding.class ).set( 17 );
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY)==3){
			Buff.affect( enemy, Bleeding.class ).set( 20 );
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.SUICIDE_BUTTERFLY)==4){
			Buff.affect( enemy, Bleeding.class ).set( 23 );
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.REFLOWERING) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.REFLOWERING)==1){
			Buff.prolong(this, Invisibility.class, Invisibility.DURATION/15f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.REFLOWERING) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.REFLOWERING)==2){
			Buff.prolong(this, Invisibility.class, Invisibility.DURATION/10f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.REFLOWERING) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.REFLOWERING)==3){
			Buff.prolong(this, Invisibility.class, Invisibility.DURATION/6f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.REFLOWERING) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.REFLOWERING)==4){
			Buff.prolong(this, Invisibility.class, Invisibility.DURATION/3f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVISIBILITY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVISIBILITY)==1 && Dungeon.level.water[pos]){
			Buff.prolong(this, Invisibility.class, Invisibility.DURATION/5f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVISIBILITY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVISIBILITY)==2 && Dungeon.level.water[pos]){
			Buff.prolong(this, Invisibility.class, Invisibility.DURATION/3f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVISIBILITY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVISIBILITY)==3 && Dungeon.level.water[pos]){
			Buff.prolong(this, Invisibility.class, Invisibility.DURATION/2f);
		}

		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVISIBILITY) && pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.AQUA_INVISIBILITY)==4 && Dungeon.level.water[pos]){
			Buff.prolong(this, Invisibility.class, Invisibility.DURATION);
		}

		if (belongings.armor() != null) {
			damage = belongings.armor().proc( enemy, this, damage );
		}

		Earthroot.Armor armor = buff( Earthroot.Armor.class );
		if (armor != null) {
			damage = armor.absorb( damage );
		}

		WandOfLivingEarth.RockArmor rockArmor = buff(WandOfLivingEarth.RockArmor.class);
		if (rockArmor != null) {
			damage = rockArmor.absorb(damage);
		}

		return damage;
	}

	@Override
	public void damage( int dmg, Object src ) {
		if (buff(TimekeepersHourglass.timeStasis.class) != null)
			return;

		if (!(src instanceof Hunger || src instanceof Viscosity.DeferedDamage) && damageInterrupt) {
			interrupt();
			resting = false;
		}

		if (this.buff(Drowsy.class) != null){
			Buff.detach(this, Drowsy.class);
			GLog.w( Messages.get(this, "pain_resist") );
		}

		CapeOfThorns.Thorns thorns = buff( CapeOfThorns.Thorns.class );
		if (thorns != null) {
			dmg = thorns.proc(dmg, (src instanceof Char ? (Char)src : null),  this);
		}

		dmg = (int)Math.ceil(dmg * RingOfTenacity.damageMultiplier( this ));

		//TODO improve this when I have proper damage source logic
		if (belongings.armor() != null && belongings.armor().hasGlyph(AntiMagic.class, this)
				&& AntiMagic.RESISTS.contains(src.getClass())){
			dmg -= AntiMagic.drRoll(belongings.armor().buffedLvl());
		}

		if (buff(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.WarriorFoodImmunity.class) != null){
			if (pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.IRON_STOMACH) == 1)       dmg = Math.round(dmg*0.25f);
			else if (pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.IRON_STOMACH) == 2)  dmg = Math.round(dmg*0.00f);
		}

		if (heroClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.KAGUYAPLAYER){
			dmg = Math.round(dmg*0.75f);
		}

		if (Dungeon.hero.belongings.weapon() instanceof AlchemyHat){
			dmg += 2;
		}

		if (buff(FireBrandBuff.class) != null){
			dmg += 1;
		}

		if (buff(FrostBrandBuff.class) != null){
			dmg += 1;
		}

		int preHP = HP + shielding();
		super.damage( dmg, src );
		int postHP = HP + shielding();
		int effectiveDamage = preHP - postHP;

		if (effectiveDamage <= 0) return;

		//flash red when hit for serious damage.
		float percentDMG = effectiveDamage / (float)preHP; //percent of current HP that was taken
		float percentHP = 1 - ((HT - postHP) / (float)HT); //percent health after damage was taken
		// The flash intensity increases primarily based on damage taken and secondarily on missing HP.
		float flashIntensity = 0.25f * (percentDMG * percentDMG) / percentHP;
		//if the intensity is very low don't flash at all
		if (flashIntensity >= 0.05f){
			flashIntensity = Math.min(1/3f, flashIntensity); //cap intensity at 1/3
			GameScene.flash( (int)(0xFF*flashIntensity) << 16 );
			if (isAlive()) {
				if (flashIntensity >= 1/6f) {
					Sample.INSTANCE.play(Assets.Sounds.HEALTH_CRITICAL, 1/3f + flashIntensity * 2f);
				} else {
					Sample.INSTANCE.play(Assets.Sounds.HEALTH_WARN, 1/3f + flashIntensity * 4f);
				}
			}
		}
	}

	public void checkVisibleMobs() {
		ArrayList<Mob> visible = new ArrayList<>();

		boolean newMob = false;

		Mob target = null;
		for (Mob m : Dungeon.level.mobs.toArray(new Mob[0])) {
			if (fieldOfView[ m.pos ] && m.alignment == Alignment.ENEMY) {
				visible.add(m);
				if (!visibleEnemies.contains( m )) {
					newMob = true;
				}

				if (!mindVisionEnemies.contains(m) && QuickSlotButton.autoAim(m) != -1){
					if (target == null){
						target = m;
					} else if (distance(target) > distance(m)) {
						target = m;
					}
					if (m instanceof Mystia && Dungeon.level.distance(m.pos, pos) <= 4
							&& !Document.ADVENTURERS_GUIDE.isPageRead(Document.GUIDE_EXAMINING)){
						GLog.p(Messages.get(Guidebook.class, "hint"));
						GameScene.flashForDocument(Document.GUIDE_EXAMINING);
						//we set to read here to prevent this message popping up a bunch
						Document.ADVENTURERS_GUIDE.readPage(Document.GUIDE_EXAMINING);
					}
				}
			}
		}

		Char lastTarget = QuickSlotButton.lastTarget;
		if (target != null && (lastTarget == null ||
				!lastTarget.isAlive() ||
				lastTarget.alignment == Alignment.ALLY ||
				!fieldOfView[lastTarget.pos])){
			QuickSlotButton.target(target);
		}

		if (newMob) {
			interrupt();
			if (resting){
				Dungeon.observe();
				resting = false;
			}
		}

		visibleEnemies = visible;
	}

	public int visibleEnemies() {
		return visibleEnemies.size();
	}

	public Mob visibleEnemy( int index ) {
		return visibleEnemies.get(index % visibleEnemies.size());
	}

	private boolean walkingToVisibleTrapInFog = false;

	//FIXME this is a fairly crude way to track this, really it would be nice to have a short
	//history of hero actions
	public boolean justMoved = false;

	private boolean getCloser( final int target ) {

		if (target == pos)
			return false;

		if (rooted) {
			Camera.main.shake( 1, 1f );
			return false;
		}

		int step = -1;

		if (Dungeon.level.adjacent( pos, target )) {

			path = null;

			if (Actor.findChar( target ) == null) {
				if (Dungeon.level.pit[target] && !flying && !Dungeon.level.solid[target]) {
					if (!Chasm.jumpConfirmed){
						Chasm.heroJump(this);
						interrupt();
					} else {
						Chasm.heroFall(target);
					}
					return false;
				}
				if (Dungeon.level.passable[target] || Dungeon.level.avoid[target]) {
					step = target;
				}
				if (walkingToVisibleTrapInFog
						&& Dungeon.level.traps.get(target) != null
						&& Dungeon.level.traps.get(target).visible){
					return false;
				}
			}

		} else {

			boolean newPath = false;
			if (path == null || path.isEmpty() || !Dungeon.level.adjacent(pos, path.getFirst()))
				newPath = true;
			else if (path.getLast() != target)
				newPath = true;
			else {
				if (!Dungeon.level.passable[path.get(0)] || Actor.findChar(path.get(0)) != null) {
					newPath = true;
				}
			}

			if (newPath) {

				int len = Dungeon.level.length();
				boolean[] p = Dungeon.level.passable;
				boolean[] v = Dungeon.level.visited;
				boolean[] m = Dungeon.level.mapped;
				boolean[] passable = new boolean[len];
				for (int i = 0; i < len; i++) {
					passable[i] = p[i] && (v[i] || m[i]);
				}

				PathFinder.Path newpath = Dungeon.findPath(this, target, passable, fieldOfView, true);
				if (newpath != null && path != null && newpath.size() > 2*path.size()){
					path = null;
				} else {
					path = newpath;
				}
			}

			if (path == null) return false;
			step = path.removeFirst();

		}

		if (step != -1) {

			if (subClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass.FREERUNNER){
				Buff.affect(this, Momentum.class).gainStack();
			}

			float speed = speed();

			sprite.move(pos, step);
			move(step);

			spend( 1 / speed );
			justMoved = true;

			search(false);

			return true;

		} else {

			return false;

		}

	}

	public boolean handle( int cell ) {

		if (cell == -1) {
			return false;
		}

		if (fieldOfView == null || fieldOfView.length != Dungeon.level.length()){
			fieldOfView = new boolean[Dungeon.level.length()];
			Dungeon.level.updateFieldOfView( this, fieldOfView );
		}

		Char ch = Actor.findChar( cell );
		Heap heap = Dungeon.level.heaps.get( cell );

		if (Dungeon.level.map[cell] == Terrain.ALCHEMY && cell != pos) {

			curAction = new HeroAction.Alchemy( cell );

		} else if (fieldOfView[cell] && ch instanceof Mob) {

			if (ch.alignment != Alignment.ENEMY && ch.buff(Amok.class) == null) {
				curAction = new HeroAction.Interact( ch );
			} else {
				curAction = new HeroAction.Attack( ch );
			}

		} else if (heap != null
				//moving to an item doesn't auto-pickup when enemies are near...
				&& (visibleEnemies.size() == 0 || cell == pos ||
				//...but only for standard heaps, chests and similar open as normal.
				(heap.type != Type.HEAP && heap.type != Type.FOR_SALE))) {

			switch (heap.type) {
				case HEAP:
					curAction = new HeroAction.PickUp( cell );
					break;
				case FOR_SALE:
					curAction = heap.size() == 1 && heap.peek().value() > 0 ?
							new HeroAction.Buy( cell ) :
							new HeroAction.PickUp( cell );
					break;
				default:
					curAction = new HeroAction.OpenChest( cell );
			}

		} else if (Dungeon.level.map[cell] == Terrain.LOCKED_DOOR || Dungeon.level.map[cell] == Terrain.LOCKED_EXIT) {

			curAction = new HeroAction.Unlock( cell );

		} else if ((cell == Dungeon.level.exit || Dungeon.level.map[cell] == Terrain.EXIT || Dungeon.level.map[cell] == Terrain.UNLOCKED_EXIT)
				&& Dungeon.depth < 105) {

			curAction = new HeroAction.Descend( cell );

		} else if (cell == Dungeon.level.entrance || Dungeon.level.map[cell] == Terrain.ENTRANCE) {

			curAction = new HeroAction.Ascend( cell );

		} else  {

			if (!Dungeon.level.visited[cell] && !Dungeon.level.mapped[cell]
					&& Dungeon.level.traps.get(cell) != null && Dungeon.level.traps.get(cell).visible) {
				walkingToVisibleTrapInFog = true;
			} else {
				walkingToVisibleTrapInFog = false;
			}

			curAction = new HeroAction.Move( cell );
			lastAction = null;

		}

		return true;
	}

	public void earnExp( int exp, Class source ) {

		this.exp += exp;
		float percent = exp/(float)maxExp();

		EtherealChains.chainsRecharge chains = buff(EtherealChains.chainsRecharge.class);
		if (chains != null) chains.gainExp(percent);

		HornOfPlenty.hornRecharge horn = buff(HornOfPlenty.hornRecharge.class);
		if (horn != null) horn.gainCharge(percent);

		AlchemistsToolkit.kitEnergy kit = buff(AlchemistsToolkit.kitEnergy.class);
		if (kit != null) kit.gainCharge(percent);

		Berserk berserk = buff(Berserk.class);
		if (berserk != null) berserk.recover(percent);

		if (source != PotionOfExperience.class) {
			for (Item i : belongings) {
				i.onHeroGainExp(percent, this);
			}
			if (buff(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.RejuvenatingStepsFurrow.class) != null){
				buff(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.RejuvenatingStepsFurrow.class).countDown(percent*200f);
				if (buff(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.RejuvenatingStepsFurrow.class).count() <= 0){
					buff(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.RejuvenatingStepsFurrow.class).detach();
				}
			}
		}

		boolean levelUp = false;
		while (this.exp >= maxExp()) {
			this.exp -= maxExp();
			if (lvl < MAX_LEVEL) {
				lvl++;
				levelUp = true;

				if (buff(ElixirOfMight.HTBoost.class) != null){
					buff(ElixirOfMight.HTBoost.class).onLevelUp();
				}

				updateHT( true );
				attackSkill++;
				defenseSkill++;

			} else {
				Buff.prolong(this, Bless.class, Bless.DURATION);
				this.exp = 0;

				GLog.newLine();
				GLog.p( Messages.get(this, "level_cap"));
				Sample.INSTANCE.play( Assets.Sounds.LEVELUP );
			}

		}

		if (levelUp) {

			if (sprite != null) {
				GLog.newLine();
				GLog.p( Messages.get(this, "new_level") );
				sprite.showStatus( CharSprite.POSITIVE, Messages.get(Hero.class, "level_up") );
				Sample.INSTANCE.play( Assets.Sounds.LEVELUP );
				if (lvl < com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.tierLevelThresholds[com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.MAX_TALENT_TIERS+1]){
					GLog.newLine();
					GLog.p( Messages.get(this, "new_talent") );
					StatusPane.talentBlink = 10f;
					WndHero.lastIdx = 1;
				}
			}

			Item.updateQuickslot();

			Badges.validateLevelReached();
		}
	}

	public int maxExp() {
		return maxExp( lvl );
	}

	public static int maxExp( int lvl ){
		return 5 + lvl * 5;
	}

	public boolean isStarving() {
		return Buff.affect(this, Hunger.class).isStarving();
	}

	@Override
	public void add( Buff buff ) {

		if (buff(TimekeepersHourglass.timeStasis.class) != null)
			return;

		super.add( buff );

		if (sprite != null) {
			String msg = buff.heroMessage();
			if (msg != null){
				GLog.w(msg);
			}

			if (buff instanceof Paralysis || buff instanceof Vertigo) {
				interrupt();
			}

		}

		BuffIndicator.refreshHero();
	}

	@Override
	public void remove( Buff buff ) {
		super.remove( buff );

		BuffIndicator.refreshHero();
	}

	@Override
	public float stealth() {
		float stealth = super.stealth();

		if (belongings.armor() != null){
			stealth = belongings.armor().stealthFactor(this, stealth);
		}

		return stealth;
	}

	@Override
	public void die( Object cause ) {

		curAction = null;

		Ankh ankh = null;

		//look for ankhs in player inventory, prioritize ones which are blessed.
		for (Ankh i : belongings.getAllItems(Ankh.class)){
			if (ankh == null || i.isBlessed()) {
				ankh = i;
			}
		}

		if (ankh != null) {
			interrupt();
			resting = false;

			if (ankh.isBlessed()) {
				this.HP = HT / 4;

				PotionOfHealing.cure(this);
				Buff.prolong(this, AnkhInvulnerability.class, AnkhInvulnerability.DURATION);

				SpellSprite.show(this, SpellSprite.ANKH);
				GameScene.flash(0x80FFFF40);
				Sample.INSTANCE.play(Assets.Sounds.TELEPORT);
				GLog.w(Messages.get(this, "revive"));
				Statistics.ankhsUsed++;

				ankh.detach(belongings.backpack);

				for (Char ch : Actor.chars()) {
					if (ch instanceof DriedRose.GhostHero) {
						((DriedRose.GhostHero) ch).sayAnhk();
						return;
					}
				}
			} else {

				//this is hacky, basically we want to declare that a wndResurrect exists before
				//it actually gets created. This is important so that the game knows to not
				//delete the run or submit it to rankings, because a WndResurrect is about to exist
				//this is needed because the actual creation of the window is delayed here
				WndResurrect.instance = new Object();
				Ankh finalAnkh = ankh;
				Game.runOnRenderThread(new Callback() {
					@Override
					public void call() {
						GameScene.show( new WndResurrect(finalAnkh) );
					}
				});

			}
			return;
		}

		Actor.fixTime();
		super.die( cause );
		reallyDie( cause );
	}

	public static void reallyDie( Object cause ) {

		int length = Dungeon.level.length();
		int[] map = Dungeon.level.map;
		boolean[] visited = Dungeon.level.visited;
		boolean[] discoverable = Dungeon.level.discoverable;

		for (int i=0; i < length; i++) {

			int terr = map[i];

			if (discoverable[i]) {

				visited[i] = true;
				if ((Terrain.flags[terr] & Terrain.SECRET) != 0) {
					Dungeon.level.discover( i );
				}
			}
		}

		Bones.leave();

		Dungeon.observe();
		GameScene.updateFog();

		Dungeon.hero.belongings.identify();

		int pos = Dungeon.hero.pos;

		ArrayList<Integer> passable = new ArrayList<>();
		for (Integer ofs : PathFinder.NEIGHBOURS8) {
			int cell = pos + ofs;
			if ((Dungeon.level.passable[cell] || Dungeon.level.avoid[cell]) && Dungeon.level.heaps.get( cell ) == null) {
				passable.add( cell );
			}
		}
		Collections.shuffle( passable );

		ArrayList<Item> items = new ArrayList<>(Dungeon.hero.belongings.backpack.items);
		for (Integer cell : passable) {
			if (items.isEmpty()) {
				break;
			}

			Item item = Random.element( items );
			Dungeon.level.drop( item, cell ).sprite.drop( pos );
			items.remove( item );
		}

		for (Char c : Actor.chars()){
			if (c instanceof DriedRose.GhostHero){
				((DriedRose.GhostHero) c).sayHeroKilled();
			}
		}

		GameScene.gameOver();

		if (cause instanceof Hero.Doom) {
			((Hero.Doom)cause).onDeath();
		}

		Dungeon.deleteGame( GamesInProgress.curSlot, true );
	}

	//effectively cache this buff to prevent having to call buff(...) a bunch.
	//This is relevant because we call isAlive during drawing, which has both performance
	//and thread coordination implications if that method calls buff(...) frequently
	private Berserk berserk;

	@Override
	public boolean isAlive() {

		if (HP <= 0){
			if (berserk == null) berserk = buff(Berserk.class);
			return berserk != null && berserk.berserking();
		} else {
			berserk = null;
			return super.isAlive();
		}
	}

	@Override
	public void move(int step, boolean travelling) {
		boolean wasHighGrass = Dungeon.level.map[step] == Terrain.HIGH_GRASS;

		super.move( step, travelling);

		if (heroClass == HeroClass.MURASA){
			Buff.affect(this, UnderwaterCurse.class);
		}

		if (Dungeon.hero.belongings.weapon instanceof AlchemyHat){
			Buff.prolong(this, HatResistance.class, HatResistance.DURATION);
		}

		if (buff(MoveDetect.class) != null){
			damage(10, this);
		}

		if (Dungeon.isChallenged(Challenges.BECOME_FUMO) && !(heroClass == HeroClass.MURASA)) {
			Buff.affect(this, com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom.class);
			this.sprite.add( CharSprite.State.DARKENED );
		}

		if (!flying && travelling) {
			if (Dungeon.level.water[pos]) {
				Sample.INSTANCE.play( Assets.Sounds.WATER, 1, Random.Float( 0.8f, 1.25f ) );
			} else if (Dungeon.level.map[pos] == Terrain.EMPTY_SP) {
				Sample.INSTANCE.play( Assets.Sounds.STURDY, 1, Random.Float( 0.96f, 1.05f ) );
			} else if (Dungeon.level.map[pos] == Terrain.GRASS
					|| Dungeon.level.map[pos] == Terrain.EMBERS
					|| Dungeon.level.map[pos] == Terrain.FURROWED_GRASS){
				if (step == pos && wasHighGrass) {
					Sample.INSTANCE.play(Assets.Sounds.TRAMPLE, 1, Random.Float( 0.96f, 1.05f ) );
				} else {
					Sample.INSTANCE.play( Assets.Sounds.GRASS, 1, Random.Float( 0.96f, 1.05f ) );
				}
			} else {
				Sample.INSTANCE.play( Assets.Sounds.STEP, 1, Random.Float( 0.96f, 1.05f ) );
			}
		}
	}
	@Override
	public void onAttackComplete() {

		AttackIndicator.target(enemy);

		boolean hit = attack( enemy );

		Invisibility.dispel();
		spend( attackDelay() );

		if (hit && subClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass.GLADIATOR){
			Buff.affect( this, Combo.class ).hit( enemy );
		}

		curAction = null;

		super.onAttackComplete();
	}

	@Override
	public void onMotionComplete() {
		GameScene.checkKeyHold();
	}

	@Override
	public void onOperateComplete() {

		if (curAction instanceof HeroAction.Unlock) {

			int doorCell = ((HeroAction.Unlock)curAction).dst;
			int door = Dungeon.level.map[doorCell];

			if (Dungeon.level.distance(pos, doorCell) <= 1) {
				boolean hasKey = true;
				if (door == Terrain.LOCKED_DOOR) {
					hasKey = Notes.remove(new IronKey(Dungeon.depth));
					if (hasKey) Level.set(doorCell, Terrain.DOOR);
				} else {
					hasKey = Notes.remove(new SkeletonKey(Dungeon.depth));
					if (hasKey) Level.set(doorCell, Terrain.UNLOCKED_EXIT);
				}

				if (hasKey) {
					GameScene.updateKeyDisplay();
					Level.set(doorCell, door == Terrain.LOCKED_DOOR ? Terrain.DOOR : Terrain.UNLOCKED_EXIT);
					GameScene.updateMap(doorCell);
					spend(Key.TIME_TO_UNLOCK);
				}
			}

		} else if (curAction instanceof HeroAction.OpenChest) {

			Heap heap = Dungeon.level.heaps.get( ((HeroAction.OpenChest)curAction).dst );

			if (Dungeon.level.distance(pos, heap.pos) <= 1){
				boolean hasKey = true;
				if (heap.type == Type.SKELETON || heap.type == Type.REMAINS) {
					Sample.INSTANCE.play( Assets.Sounds.BONES );
				} else if (heap.type == Type.LOCKED_CHEST){
					hasKey = Notes.remove(new GoldenKey(Dungeon.depth));
				} else if (heap.type == Type.CRYSTAL_CHEST){
					hasKey = Notes.remove(new CrystalKey(Dungeon.depth));
				}

				if (hasKey) {
					GameScene.updateKeyDisplay();
					heap.open(this);
					spend(Key.TIME_TO_UNLOCK);
				}
			}

		}
		curAction = null;

		super.onOperateComplete();
	}

	@Override
	public boolean isImmune(Class effect) {
		if (effect == Burning.class
				&& belongings.armor() != null
				&& belongings.armor().hasGlyph(Brimstone.class, this)){
			return true;
		}
		return super.isImmune(effect);
	}

	@Override
	public boolean isInvulnerable(Class effect) {
		return buff(AnkhInvulnerability.class) != null;
	}

	public boolean search( boolean intentional ) {

		if (!isAlive()) return false;

		boolean smthFound = false;

		boolean circular = pointsInTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.WIDE_SEARCH) == 1;
		int distance = heroClass == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass.ROGUE ? 2 : 1;
		if (hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.WIDE_SEARCH)) distance++;

		boolean foresight = buff(Foresight.class) != null;

		if (foresight) distance++;

		int cx = pos % Dungeon.level.width();
		int cy = pos / Dungeon.level.width();
		int ax = cx - distance;
		if (ax < 0) {
			ax = 0;
		}
		int bx = cx + distance;
		if (bx >= Dungeon.level.width()) {
			bx = Dungeon.level.width() - 1;
		}
		int ay = cy - distance;
		if (ay < 0) {
			ay = 0;
		}
		int by = cy + distance;
		if (by >= Dungeon.level.height()) {
			by = Dungeon.level.height() - 1;
		}

		TalismanOfForesight.Foresight talisman = buff( TalismanOfForesight.Foresight.class );
		boolean cursed = talisman != null && talisman.isCursed();

		for (int y = ay; y <= by; y++) {
			for (int x = ax, p = ax + y * Dungeon.level.width(); x <= bx; x++, p++) {

				if (circular && Math.abs(x - cx)-1 > ShadowCaster.rounding[distance][distance - Math.abs(y - cy)]){
					continue;
				}

				if (fieldOfView[p] && p != pos) {

					if (intentional) {
						GameScene.effectOverFog(new CheckedCell(p, pos));
					}

					if (Dungeon.level.secret[p]){

						Trap trap = Dungeon.level.traps.get( p );
						float chance;

						//searches aided by foresight always succeed, even if trap isn't searchable
						if (foresight){
							chance = 1f;

							//otherwise if the trap isn't searchable, searching always fails
						} else if (trap != null && !trap.canBeSearched){
							chance = 0f;

							//intentional searches always succeed against regular traps and doors
						} else if (intentional){
							chance = 1f;

							//unintentional searches always fail with a cursed talisman
						} else if (cursed) {
							chance = 0f;

							//unintentional trap detection scales from 40% at floor 0 to 30% at floor 25
						} else if (Dungeon.level.map[p] == Terrain.SECRET_TRAP) {
							chance = 0.4f - (Dungeon.depth / 250f);

							//unintentional door detection scales from 20% at floor 0 to 0% at floor 20
						} else {
							chance = 0.2f - (Dungeon.depth / 100f);
						}

						if (Random.Float() < chance) {

							int oldValue = Dungeon.level.map[p];

							GameScene.discoverTile( p, oldValue );

							Dungeon.level.discover( p );

							ScrollOfMagicMapping.discover( p );

							smthFound = true;

							if (talisman != null){
								if (oldValue == Terrain.SECRET_TRAP){
									talisman.charge(2);
								} else if (oldValue == Terrain.SECRET_DOOR){
									talisman.charge(10);
								}
							}
						}
					}
				}
			}
		}


		if (intentional) {
			sprite.showStatus( CharSprite.DEFAULT, Messages.get(this, "search") );
			sprite.operate( pos );
			if (!Dungeon.level.locked) {
				if (cursed) {
					GLog.n(Messages.get(this, "search_distracted"));
					Buff.affect(this, Hunger.class).affectHunger(TIME_TO_SEARCH - (2 * HUNGER_FOR_SEARCH));
				} else {
					Buff.affect(this, Hunger.class).affectHunger(TIME_TO_SEARCH - HUNGER_FOR_SEARCH);
				}
			}
			spendAndNext(TIME_TO_SEARCH);

		}

		if (smthFound) {
			GLog.w( Messages.get(this, "noticed_smth") );
			Sample.INSTANCE.play( Assets.Sounds.SECRET );
			interrupt();
		}

		return smthFound;
	}

	public void resurrect() {
		HP = HT;
		live();

		MagicalHolster holster = belongings.getItem(MagicalHolster.class);

		Buff.affect(this, LostInventory.class);
		Buff.affect(this, Invisibility.class, 3f);
		//lost inventory is dropped in interlevelscene

		//activate items that persist after lost inventory
		//FIXME this is very messy, maybe it would be better to just have one buff that
		// handled all items that recharge over time?
		for (Item i : belongings){
			if (i instanceof EquipableItem && i.isEquipped(this)){
				((EquipableItem) i).activate(this);
			} else if (i instanceof CloakOfShadows && i.keptThoughLostInvent && hasTalent(com.touhoupixel.touhoupixeldungeon.actors.hero.Talent.LIGHT_CLOAK)){
				((CloakOfShadows) i).activate(this);
			} else if (i instanceof Wand && i.keptThoughLostInvent){
				if (holster != null && holster.contains(i)){
					((Wand) i).charge(this, MagicalHolster.HOLSTER_SCALE_FACTOR);
				} else {
					((Wand) i).charge(this);
				}
			} else if (i instanceof MagesStaff && i.keptThoughLostInvent){
				((MagesStaff) i).applyWandChargeBuff(this);
			}
		}
	}

	@Override
	public void next() {
		if (isAlive())
			super.next();
	}

	public static interface Doom {
		public void onDeath();
	}
}