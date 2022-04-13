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

package com.touhoupixel.touhoupixeldungeon.items;

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.items.armor.Armor;
import com.touhoupixel.touhoupixeldungeon.items.armor.ClothArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.GoldenDragonArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.HanasakigawaArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.HecatiaArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.LeatherArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.MailArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.MaxwellArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.PC98MarisaArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.PC98ReimuArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.PlateArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.PoppinPartyArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.RumiaArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.ScaleArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.ToyohimeArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.YorihimeArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.YuyukoArmor;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.AlchemistsToolkit;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.Artifact;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.CapeOfThorns;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.ChaliceOfBlood;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.CloakOfShadows;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.DriedRose;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.EtherealChains;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.HornOfPlenty;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.LloydsBeacon;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.MasterThievesArmband;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.SandalsOfNature;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.TalismanOfForesight;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.TimekeepersHourglass;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.UnstableSpellbook;
import com.touhoupixel.touhoupixeldungeon.items.food.Food;
import com.touhoupixel.touhoupixeldungeon.items.food.MiracleFruit;
import com.touhoupixel.touhoupixeldungeon.items.food.MysteryMeat;
import com.touhoupixel.touhoupixeldungeon.items.food.Pancake;
import com.touhoupixel.touhoupixeldungeon.items.food.Pasty;
import com.touhoupixel.touhoupixeldungeon.items.food.Waffle;
import com.touhoupixel.touhoupixeldungeon.items.potions.Potion;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfBerserk;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfDoublespeed;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfExperience;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfFrost;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHaste;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfInvisibility;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLevitation;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLightHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLiquidFlame;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfMight;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfMindVision;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfParalyticGas;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfPurity;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfStrength;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfToxicGas;
import com.touhoupixel.touhoupixeldungeon.items.rings.Ring;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfAccuracy;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfElements;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfEnergy;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfEvasion;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfForce;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfFuror;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfHaste;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfMight;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfSharpshooting;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfTenacity;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfWealth;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.Scroll;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfBurning;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfIdentify;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfLullaby;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfMirrorImage;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRage;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRecharging;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRetribution;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRouteChange;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfSilence;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfSlowness;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTerror;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTransmutation;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.touhoupixel.touhoupixeldungeon.items.stones.Runestone;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfFear;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfAggression;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfAugmentation;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfBlast;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfBlink;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfClairvoyance;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfDeepSleep;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfDisarming;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfEnchantment;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfFlock;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfIntuition;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfShock;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.BindTailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.BlowawayTailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.ChaosTailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.DecoyTailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.ExplosionTailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.FogpurgeTailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.ImpedeTailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.IncompetenceTailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.SwapTailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.Tailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.TormentTailsman;
import com.touhoupixel.touhoupixeldungeon.items.wands.Wand;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfAntiDoor;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfAntiEmber;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfBlastWave;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfCorrosion;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfCorruption;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfDeath;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfDestOrb;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfDisintegration;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfFireblast;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfFrost;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfHealWounds;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfLightning;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfLivingEarth;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfMagicMissile;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfPrismaticLight;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfPurityBeam;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfRegrowth;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfReverseGravity;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfSetsunatrip;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfStableness;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfTransfusion;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfWarding;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfWishing;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.AkyuuBrush;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.AlchemyHat;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.AlchemySword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.ArisaKeyboard;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.AssassinsBlade;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.AutumnKatana;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.BattleAxe;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.BlazingStar;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Crossbow;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Dagger;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.DeadBeacon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Dirk;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.DoremyDream;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.DoubleSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.EnmaShaku;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FireBrand;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Flail;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Flintlock;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FrostBrand;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FullmoonScythe;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Gauntlet;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Glaive;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Gloves;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Grayswandir;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Greataxe;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Greatshield;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Greatsword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HandAxe;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HecatiaStar;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HinaRibbon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HorouBook;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HoshigumaHorn;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.JeweledPagoda;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.KeineBook;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.KogasaRod;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.KoishiSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.KokoroFan;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.KomachiScythe;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.KyoukoBroom;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Levatein;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Log;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Longsword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.LunaClock;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Mace;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MagesStaff;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MintchocoSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MiracleRod;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MomoyoShovel;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MurasaDipper;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.NazrinRod;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.NitoriRod;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.PhoenixTail;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.PlayMat;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.PotofGreed;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Quarterstaff;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.RandomPhone;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.RingoDango;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.RoundShield;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.RunicBlade;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.SagumeWing;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Sai;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Scimitar;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.SevenStarSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Shortsword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.SilkyHair;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.SmallSeiranHammer;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Spear;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Sword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.SwordofHisou;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.TenkyuuCloak;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.ToramaruSpear;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.TurnaboutCloak;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WarHammer;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WatermelonSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Whip;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WindgodFan;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WoodenBat;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WornShortsword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YoumuSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YukinaMic;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YuukaUmbrella;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YuyukoFoldingFan;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.Bolas;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.FishingSpear;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.ForceCube;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.HeavyBoomerang;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.Javelin;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.Kunai;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.MissileWeapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.Shuriken;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.ThrowingClub;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.ThrowingHammer;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.ThrowingKnife;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.ThrowingSpear;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.ThrowingStone;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.Tomahawk;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.Trident;
import com.touhoupixel.touhoupixeldungeon.plants.Blindweed;
import com.touhoupixel.touhoupixeldungeon.plants.Dreamfoil;
import com.touhoupixel.touhoupixeldungeon.plants.Earthroot;
import com.touhoupixel.touhoupixeldungeon.plants.Fadeleaf;
import com.touhoupixel.touhoupixeldungeon.plants.Firebloom;
import com.touhoupixel.touhoupixeldungeon.plants.Icecap;
import com.touhoupixel.touhoupixeldungeon.plants.Plant;
import com.touhoupixel.touhoupixeldungeon.plants.Rotberry;
import com.touhoupixel.touhoupixeldungeon.plants.Sorrowmoss;
import com.touhoupixel.touhoupixeldungeon.plants.Starflower;
import com.touhoupixel.touhoupixeldungeon.plants.Stormvine;
import com.touhoupixel.touhoupixeldungeon.plants.Sungrass;
import com.touhoupixel.touhoupixeldungeon.plants.Swiftthistle;
import com.watabou.utils.Bundle;
import com.watabou.utils.GameMath;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Generator {

	public enum Category {
		WEAPON	( 4, 4, MeleeWeapon.class),
		WEP_T1	( 0, 0, MeleeWeapon.class),
		WEP_T2	( 0, 0, MeleeWeapon.class),
		WEP_T3	( 0, 0, MeleeWeapon.class),
		WEP_T4	( 0, 0, MeleeWeapon.class),
		WEP_T5	( 0, 0, MeleeWeapon.class),

		ARMOR	    ( 3, 2, Armor.class ),
		ARMOR_T1	( 0, 0, Armor.class ),
		ARMOR_T2	( 0, 0, Armor.class ),
		ARMOR_T3	( 0, 0, Armor.class ),
		ARMOR_T4	( 0, 0, Armor.class ),
		ARMOR_T5	( 0, 0, Armor.class ),
		
		MISSILE ( 2, 2, MissileWeapon.class ),
		MIS_T1  ( 0, 0, MissileWeapon.class ),
		MIS_T2  ( 0, 0, MissileWeapon.class ),
		MIS_T3  ( 0, 0, MissileWeapon.class ),
		MIS_T4  ( 0, 0, MissileWeapon.class ),
		MIS_T5  ( 0, 0, MissileWeapon.class ),
		
		WAND	( 1, 1, Wand.class ),
		RING	( 1, 0, Ring.class ),
		ARTIFACT( 0, 1, Artifact.class),
		
		FOOD	( 0, 0, Food.class ),
		
		POTION	( 7, 7, Potion.class ),
		SEED	( 1, 1, Plant.Seed.class ),
		
		SCROLL	( 7, 7, Scroll.class ),
		STONE   ( 1, 1, Runestone.class),
		TAILSMAN( 6, 6, Tailsman.class),
		
		GOLD	( 10, 10,   Gold.class );
		
		public Class<?>[] classes;

		//some item types use a deck-based system, where the probs decrement as items are picked
		// until they are all 0, and then they reset. Those generator classes should define
		// defaultProbs. If defaultProbs is null then a deck system isn't used.
		//Artifacts in particular don't reset, no duplicates!
		public float[] probs;
		public float[] defaultProbs = null;

		//game has two decks of 35 items for overall category probs
		//one deck has a ring and extra armor, the other has an artifact and extra thrown weapon
		public float firstProb;
		public float secondProb;
		public Class<? extends Item> superClass;
		
		private Category( float firstProb, float secondProb, Class<? extends Item> superClass ) {
			this.firstProb = firstProb;
			this.secondProb = secondProb;
			this.superClass = superClass;
		}
		
		public static int order( Item item ) {
			for (int i=0; i < values().length; i++) {
				if (values()[i].superClass.isInstance( item )) {
					return i;
				}
			}

			//items without a category-defined order are sorted based on the spritesheet
			return Short.MAX_VALUE+item.image();
		}

		static {
			GOLD.classes = new Class<?>[]{
					Gold.class };
			GOLD.probs = new float[]{ 1 };

			POTION.classes = new Class<?>[]{
					PotionOfStrength.class, //2 drop every chapter, see Dungeon.posNeeded()
					PotionOfHealing.class,
					PotionOfMindVision.class,
					PotionOfFrost.class,
					PotionOfLiquidFlame.class,
					PotionOfToxicGas.class,
					PotionOfHaste.class,
					PotionOfInvisibility.class,
					PotionOfLevitation.class,
					PotionOfParalyticGas.class,
					PotionOfPurity.class,
					PotionOfMight.class,
					PotionOfExperience.class,
					PotionOfDoublespeed.class,
					PotionOfBerserk.class,
					PotionOfLightHealing.class};
			POTION.defaultProbs = new float[]{ 0, 6, 2, 2, 1, 2, 2, 6, 6, 2, 2, 2, 2, 2, 2, 2 };
			POTION.probs = POTION.defaultProbs.clone();
			
			SEED.classes = new Class<?>[]{
					Rotberry.Seed.class, //quest item
					Sungrass.Seed.class,
					Fadeleaf.Seed.class,
					Icecap.Seed.class,
					Firebloom.Seed.class,
					Sorrowmoss.Seed.class,
					Swiftthistle.Seed.class,
					Blindweed.Seed.class,
					Stormvine.Seed.class,
					Earthroot.Seed.class,
					Dreamfoil.Seed.class,
					Starflower.Seed.class};
			SEED.defaultProbs = new float[]{ 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2 };
			SEED.probs = SEED.defaultProbs.clone();

			SCROLL.classes = new Class<?>[]{
					ScrollOfUpgrade.class, //3 drop every chapter, see Dungeon.souNeeded()
					ScrollOfIdentify.class,
					ScrollOfRemoveCurse.class,
					ScrollOfMirrorImage.class,
					ScrollOfRecharging.class,
					ScrollOfTeleportation.class,
					ScrollOfLullaby.class,
					ScrollOfMagicMapping.class,
					ScrollOfRage.class,
					ScrollOfRetribution.class,
					ScrollOfTerror.class,
					ScrollOfTransmutation.class,
					ScrollOfSlowness.class,
					ScrollOfBurning.class,
					ScrollOfSilence.class,
					ScrollOfRouteChange.class
			};
			SCROLL.defaultProbs = new float[]{ 0, 5, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1};
			SCROLL.probs = SCROLL.defaultProbs.clone();
			
			STONE.classes = new Class<?>[]{
					StoneOfEnchantment.class,
					StoneOfIntuition.class,     //1 additional stone is also dropped on floors 1-3
					StoneOfDisarming.class,
					StoneOfFlock.class,
					StoneOfShock.class,
					StoneOfBlink.class,
					StoneOfDeepSleep.class,
					StoneOfClairvoyance.class,
					StoneOfAggression.class,
					StoneOfBlast.class,
					StoneOfFear.class,
					StoneOfAugmentation.class  //1 is sold in each shop
			};
			STONE.defaultProbs = new float[]{ 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 };
			STONE.probs = STONE.defaultProbs.clone();

			TAILSMAN.classes = new Class<?>[]{
					BindTailsman.class,
					BlowawayTailsman.class,
					ChaosTailsman.class,
					DecoyTailsman.class,
					ExplosionTailsman.class,
					FogpurgeTailsman.class,
					ImpedeTailsman.class,
					IncompetenceTailsman.class,
					SwapTailsman.class,
					TormentTailsman.class
			};
			TAILSMAN.defaultProbs = new float[]{ 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 };
			TAILSMAN.probs = TAILSMAN.defaultProbs.clone();

			WAND.classes = new Class<?>[]{
					WandOfMagicMissile.class,
					WandOfLightning.class,
					WandOfDisintegration.class,
					WandOfFireblast.class,
					WandOfCorrosion.class,
					WandOfBlastWave.class,
					WandOfLivingEarth.class,
					WandOfFrost.class,
					WandOfPrismaticLight.class,
					WandOfWarding.class,
					WandOfCorruption.class,
					WandOfReverseGravity.class,
					WandOfAntiDoor.class,
					WandOfAntiEmber.class,
					WandOfWishing.class,
					WandOfHealWounds.class,
					WandOfPurityBeam.class,
					WandOfDestOrb.class,
					WandOfDeath.class,
					WandOfStableness.class,
					WandOfSetsunatrip.class,
					WandOfRegrowth.class };
			WAND.probs = new float[]{ 1, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 0, 6, 6, 6, 0, 0, 6, 1, 0, 4, 1 };

			//see generator.randomWeapon
			WEAPON.classes = new Class<?>[]{};
			WEAPON.probs = new float[]{};
			
			WEP_T1.classes = new Class<?>[]{
					WornShortsword.class,
					Gloves.class,
					Dagger.class,
					SmallSeiranHammer.class,
					HinaRibbon.class,
					MagesStaff.class
			};
			WEP_T1.probs = new float[]{ 1, 1, 1, 1, 1, 0 };

			WEP_T2.classes = new Class<?>[]{
					Shortsword.class,
					HandAxe.class,
					Spear.class,
					Quarterstaff.class,
					Dirk.class,
					RingoDango.class,
					SilkyHair.class,
					NazrinRod.class,
					MomoyoShovel.class,
					PotofGreed.class,
					KeineBook.class,
					MintchocoSword.class
			};
			WEP_T2.probs = new float[]{ 5, 5, 4, 4, 4, 5, 4, 5, 4, 5, 3, 5 };

			WEP_T3.classes = new Class<?>[]{
					Sword.class,
					Mace.class,
					Scimitar.class,
					RoundShield.class,
					Sai.class,
					Whip.class,
					AkyuuBrush.class,
					DoremyDream.class,
					KokoroFan.class,
					NitoriRod.class,
					HecatiaStar.class,
					WatermelonSword.class,
					BlazingStar.class,
					AlchemyHat.class,
					PlayMat.class,
					RandomPhone.class,
					TenkyuuCloak.class,
					AlchemySword.class,
					DeadBeacon.class
			};
			WEP_T3.probs = new float[]{ 5, 5, 5, 4, 4, 4, 5, 5, 4, 5, 4, 1, 4, 5, 5, 5, 5, 5, 5 };

			WEP_T4.classes = new Class<?>[]{
					Longsword.class,
					BattleAxe.class,
					Flail.class,
					RunicBlade.class,
					AssassinsBlade.class,
					Crossbow.class,
					YuyukoFoldingFan.class,
					MurasaDipper.class,
					KyoukoBroom.class,
					JeweledPagoda.class,
					Levatein.class,
					YuukaUmbrella.class,
					KogasaRod.class,
					WindgodFan.class,
					Flintlock.class,
					TurnaboutCloak.class,
					DoubleSword.class,
					FireBrand.class,
					FrostBrand.class
			};
			WEP_T4.probs = new float[]{ 5, 5, 5, 4, 4, 4, 5, 5, 5, 5, 5, 4, 4, 4, 4, 4, 4, 5, 5 };

			WEP_T5.classes = new Class<?>[]{
					Greatsword.class,
					WarHammer.class,
					Glaive.class,
					Greataxe.class,
					Greatshield.class,
					Gauntlet.class,
					SwordofHisou.class,
					MiracleRod.class,
					KomachiScythe.class,
					FullmoonScythe.class,
					Log.class,
					YoumuSword.class,
					PhoenixTail.class,
					EnmaShaku.class,
					SevenStarSword.class,
					SagumeWing.class,
					ToramaruSpear.class,
					KoishiSword.class,
					ArisaKeyboard.class,
					YukinaMic.class,
					WoodenBat.class,
					HoshigumaHorn.class,
					AutumnKatana.class,
					HorouBook.class,
					Grayswandir.class,
					LunaClock.class
			};
			WEP_T5.probs = new float[]{ 5, 5, 5, 4, 4, 4, 5, 5, 5, 5, 4, 5, 4, 5, 5, 5, 5, 4, 5, 5, 5, 4, 5, 5, 5, 5 };

			//see generator.randomWeapon
			ARMOR.classes = new Class<?>[]{};
			ARMOR.probs = new float[]{};

			//see Generator.randomArmor
			ARMOR_T1.classes = new Class<?>[]{
					ClothArmor.class};
			ARMOR_T1.probs = new float[]{ 5 };

			ARMOR_T2.classes = new Class<?>[]{
					LeatherArmor.class,
					PC98ReimuArmor.class,
					RumiaArmor.class};
			ARMOR_T2.probs = new float[]{ 5, 5, 5 };

			ARMOR_T3.classes = new Class<?>[]{
					MailArmor.class,
					PC98MarisaArmor.class,
					HanasakigawaArmor.class,
					PoppinPartyArmor.class};
			ARMOR_T3.probs = new float[]{ 5, 5, 5, 5 };

			ARMOR_T4.classes = new Class<?>[]{
					ScaleArmor.class,
					YorihimeArmor.class,
					YuyukoArmor.class,
					MaxwellArmor.class};
			ARMOR_T4.probs = new float[]{ 5, 5, 5, 5 };

			ARMOR_T5.classes = new Class<?>[]{
					PlateArmor.class,
					ToyohimeArmor.class,
					HecatiaArmor.class,
					GoldenDragonArmor.class};
			ARMOR_T5.probs = new float[]{ 5, 5, 5, 5 };
			
			//see Generator.randomMissile
			MISSILE.classes = new Class<?>[]{};
			MISSILE.probs = new float[]{};
			
			MIS_T1.classes = new Class<?>[]{
					ThrowingStone.class,
					ThrowingKnife.class
			};
			MIS_T1.probs = new float[]{ 6, 5 };
			
			MIS_T2.classes = new Class<?>[]{
					FishingSpear.class,
					ThrowingClub.class,
					Shuriken.class
			};
			MIS_T2.probs = new float[]{ 6, 5, 4 };
			
			MIS_T3.classes = new Class<?>[]{
					ThrowingSpear.class,
					Kunai.class,
					Bolas.class
			};
			MIS_T3.probs = new float[]{ 6, 5, 4 };
			
			MIS_T4.classes = new Class<?>[]{
					Javelin.class,
					Tomahawk.class,
					HeavyBoomerang.class
			};
			MIS_T4.probs = new float[]{ 6, 5, 4 };
			
			MIS_T5.classes = new Class<?>[]{
					Trident.class,
					ThrowingHammer.class,
					ForceCube.class
			};
			MIS_T5.probs = new float[]{ 6, 5, 4 };
			
			FOOD.classes = new Class<?>[]{
					Food.class,
					Pasty.class,
					Waffle.class,
					MiracleFruit.class,
					Pancake.class,
					MysteryMeat.class };
			FOOD.probs = new float[]{ 1, 1, 1, 1, 1, 0 };
			
			RING.classes = new Class<?>[]{
					RingOfAccuracy.class,
					RingOfEvasion.class,
					RingOfElements.class,
					RingOfForce.class,
					RingOfFuror.class,
					RingOfHaste.class,
					RingOfEnergy.class,
					RingOfMight.class,
					RingOfSharpshooting.class,
					RingOfTenacity.class,
					RingOfWealth.class};
			RING.probs = new float[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			
			ARTIFACT.classes = new Class<?>[]{
					CapeOfThorns.class,
					ChaliceOfBlood.class,
					CloakOfShadows.class,
					HornOfPlenty.class,
					MasterThievesArmband.class,
					SandalsOfNature.class,
					TalismanOfForesight.class,
					TimekeepersHourglass.class,
					UnstableSpellbook.class,
					AlchemistsToolkit.class,
					DriedRose.class,
					LloydsBeacon.class,
					EtherealChains.class
			};
			ARTIFACT.defaultProbs = new float[]{ 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1};
			ARTIFACT.probs = ARTIFACT.defaultProbs.clone();
		}
	}

	private static final float[][] floorSetTierProbs = new float[][] {
			{0, 75, 20,  4,  1},
			{0, 25, 50, 20,  5},
			{0,  0, 40, 50, 10},
			{0,  0, 20, 40, 40},
			{0,  0,  0, 20, 80}
	};

	private static boolean usingFirstDeck = false;
	private static HashMap<Category,Float> categoryProbs = new LinkedHashMap<>();

	public static void fullReset() {
		usingFirstDeck = Random.Int(2) == 0;
		generalReset();
		for (Category cat : Category.values()) {
			reset(cat);
		}
	}

	public static void generalReset(){
		for (Category cat : Category.values()) {
			categoryProbs.put( cat, usingFirstDeck ? cat.firstProb : cat.secondProb );
		}
	}

	public static void reset(Category cat){
		if (cat.defaultProbs != null) cat.probs = cat.defaultProbs.clone();
	}
	
	public static Item random() {
		Category cat = Random.chances( categoryProbs );
		if (cat == null){
			usingFirstDeck = !usingFirstDeck;
			generalReset();
			cat = Random.chances( categoryProbs );
		}
		categoryProbs.put( cat, categoryProbs.get( cat ) - 1);
		return random( cat );
	}
	
	public static Item random( Category cat ) {
		switch (cat) {
			case ARMOR:
				return randomArmor();
			case WEAPON:
				return randomWeapon();
			case MISSILE:
				return randomMissile();
			case ARTIFACT:
				Item item = randomArtifact();
				//if we're out of artifacts, return a ring instead.
				return item != null ? item : random(Category.RING);
			default:
				int i = Random.chances(cat.probs);
				if (i == -1) {
					reset(cat);
					i = Random.chances(cat.probs);
				}
				if (cat.defaultProbs != null) cat.probs[i]--;
				return ((Item) Reflection.newInstance(cat.classes[i])).random();
		}
	}

	//overrides any deck systems and always uses default probs
	public static Item randomUsingDefaults( Category cat ){
		if (cat.defaultProbs == null) {
			return random(cat); //currently covers weapons/armor/missiles
		} else {
			return ((Item) Reflection.newInstance(cat.classes[Random.chances(cat.defaultProbs)])).random();
		}
	}
	
	public static Item random( Class<? extends Item> cl ) {
		return Reflection.newInstance(cl).random();
	}

	public static final Category[] armorTiers = new Category[]{
			Category.ARMOR_T1,
			Category.ARMOR_T2,
			Category.ARMOR_T3,
			Category.ARMOR_T4,
			Category.ARMOR_T5
	};

	public static Armor randomArmor(){
		return randomArmor(Dungeon.depth / 5);
	}

	public static Armor randomArmor(int floorSet) {

		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);

		Category c2 = armorTiers[Random.chances(floorSetTierProbs[floorSet])];
		Armor w2 = (Armor)Reflection.newInstance(c2.classes[Random.chances(c2.probs)]);
		w2.random();
		return w2;
	}

	public static final Category[] wepTiers = new Category[]{
			Category.WEP_T1,
			Category.WEP_T2,
			Category.WEP_T3,
			Category.WEP_T4,
			Category.WEP_T5
	};

	public static MeleeWeapon randomWeapon(){
		return randomWeapon(Dungeon.depth / 5);
	}
	
	public static MeleeWeapon randomWeapon(int floorSet) {

		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);
		
		Category c = wepTiers[Random.chances(floorSetTierProbs[floorSet])];
		MeleeWeapon w = (MeleeWeapon)Reflection.newInstance(c.classes[Random.chances(c.probs)]);
		w.random();
		return w;
	}
	
	public static final Category[] misTiers = new Category[]{
			Category.MIS_T1,
			Category.MIS_T2,
			Category.MIS_T3,
			Category.MIS_T4,
			Category.MIS_T5
	};
	
	public static MissileWeapon randomMissile(){
		return randomMissile(Dungeon.depth / 5);
	}
	
	public static MissileWeapon randomMissile(int floorSet) {
		
		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);
		
		Category c = misTiers[Random.chances(floorSetTierProbs[floorSet])];
		MissileWeapon w = (MissileWeapon)Reflection.newInstance(c.classes[Random.chances(c.probs)]);
		w.random();
		return w;
	}

	//enforces uniqueness of artifacts throughout a run.
	public static Artifact randomArtifact() {

		Category cat = Category.ARTIFACT;
		int i = Random.chances( cat.probs );

		//if no artifacts are left, return null
		if (i == -1){
			return null;
		}

		cat.probs[i]--;
		return (Artifact) Reflection.newInstance((Class<? extends Artifact>) cat.classes[i]).random();

	}

	public static boolean removeArtifact(Class<?extends Artifact> artifact) {
		Category cat = Category.ARTIFACT;
		for (int i = 0; i < cat.classes.length; i++){
			if (cat.classes[i].equals(artifact) && cat.probs[i] > 0) {
				cat.probs[i] = 0;
				return true;
			}
		}
		return false;
	}

	private static final String FIRST_DECK = "first_deck";
	private static final String GENERAL_PROBS = "general_probs";
	private static final String CATEGORY_PROBS = "_probs";
	
	public static void storeInBundle(Bundle bundle) {
		bundle.put(FIRST_DECK, usingFirstDeck);

		Float[] genProbs = categoryProbs.values().toArray(new Float[0]);
		float[] storeProbs = new float[genProbs.length];
		for (int i = 0; i < storeProbs.length; i++){
			storeProbs[i] = genProbs[i];
		}
		bundle.put( GENERAL_PROBS, storeProbs);

		for (Category cat : Category.values()){
			if (cat.defaultProbs == null) continue;
			boolean needsStore = false;
			for (int i = 0; i < cat.probs.length; i++){
				if (cat.probs[i] != cat.defaultProbs[i]){
					needsStore = true;
					break;
				}
			}

			if (needsStore){
				bundle.put(cat.name().toLowerCase() + CATEGORY_PROBS, cat.probs);
			}
		}
	}

	public static void restoreFromBundle(Bundle bundle) {
		fullReset();

		usingFirstDeck = bundle.getBoolean(FIRST_DECK);

		if (bundle.contains(GENERAL_PROBS)){
			float[] probs = bundle.getFloatArray(GENERAL_PROBS);
			for (int i = 0; i < probs.length; i++){
				categoryProbs.put(Category.values()[i], probs[i]);
			}
		}

		for (Category cat : Category.values()){
			if (bundle.contains(cat.name().toLowerCase() + CATEGORY_PROBS)){
				float[] probs = bundle.getFloatArray(cat.name().toLowerCase() + CATEGORY_PROBS);
				if (cat.defaultProbs != null && probs.length == cat.defaultProbs.length){
					cat.probs = probs;
				}
			}
		}
		
	}
}
