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

package com.touhoupixel.touhoupixeldungeon.journal;

import com.touhoupixel.touhoupixeldungeon.Badges;
import com.touhoupixel.touhoupixeldungeon.items.Item;
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
import com.touhoupixel.touhoupixeldungeon.items.artifacts.ChaliceOfBlood;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.CloakOfShadows;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.DriedRose;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.EtherealChains;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.HornOfPlenty;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.MasterThievesArmband;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.SandalsOfNature;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.TalismanOfForesight;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.TimekeepersHourglass;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.UnstableSpellbook;
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
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FireBrand2;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Flail;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Flintlock;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FrostBrand;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FrostBrand2;
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
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HellKeyboard;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HellMic;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HinaRibbon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HisoutenMankind;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HorouBook;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HoshigumaHorn;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.JeweledBranch;
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
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MintchocoSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MiracleMallet;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MiracleRod;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MomoyoShovel;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MurasaDipper;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.NazrinRod;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.NitoriRod;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.PhoenixTail;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.PlayMat;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.PotofGreed;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Psalms;
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
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.ToyohimeFan;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.TurnaboutCloak;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.TurnaboutSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WarHammer;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WatermelonSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Whip;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WindgodFan;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WoodenBat;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WornShortsword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YorihimeSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YoumuSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YukinaMic;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YuukaUmbrella;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YuyukoFoldingFan;
import com.watabou.utils.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public enum Catalog {

	WEAPONS,
	ARMOR,
	WANDS,
	RINGS,
	ARTIFACTS,
	POTIONS,
	SCROLLS;

	private LinkedHashMap<Class<? extends Item>, Boolean> seen = new LinkedHashMap<>();

	public Collection<Class<? extends Item>> items(){
		return seen.keySet();
	}

	public boolean allSeen(){
		for (Class<?extends Item> item : items()){
			if (!seen.get(item)){
				return false;
			}
		}
		return true;
	}

	static {
		WEAPONS.seen.put( JeweledBranch.class,              true);
		WEAPONS.seen.put( MiracleMallet.class,              true);
		WEAPONS.seen.put( ToyohimeFan.class,                true);
		WEAPONS.seen.put( YorihimeSword.class,              true);
		WEAPONS.seen.put( HisoutenMankind.class,            true);
		WEAPONS.seen.put( Psalms.class,                     true);
		WEAPONS.seen.put( WornShortsword.class,             true);
		WEAPONS.seen.put( MagesStaff.class,                 true);
		WEAPONS.seen.put( Dagger.class,                     true);
		WEAPONS.seen.put( Gloves.class,                     true);
		WEAPONS.seen.put( SmallSeiranHammer.class,          true);
		WEAPONS.seen.put( HinaRibbon.class,                 true);
		WEAPONS.seen.put( Shortsword.class,                 true);
		WEAPONS.seen.put( HandAxe.class,                    true);
		WEAPONS.seen.put( Spear.class,                      true);
		WEAPONS.seen.put( Quarterstaff.class,               true);
		WEAPONS.seen.put( Dirk.class,                       true);
		WEAPONS.seen.put( RingoDango.class,                 true);
		WEAPONS.seen.put( SilkyHair.class,                  true);
		WEAPONS.seen.put( NazrinRod.class,                  true);
		WEAPONS.seen.put( MomoyoShovel.class,               true);
		WEAPONS.seen.put( PotofGreed.class,                 true);
		WEAPONS.seen.put( KeineBook.class,                  true);
		WEAPONS.seen.put( MintchocoSword.class,             true);
		WEAPONS.seen.put( Sword.class,                      true);
		WEAPONS.seen.put( Mace.class,                       true);
		WEAPONS.seen.put( Scimitar.class,                   true);
		WEAPONS.seen.put( RoundShield.class,                true);
		WEAPONS.seen.put( Sai.class,                        true);
		WEAPONS.seen.put( Whip.class,                       true);
		WEAPONS.seen.put( AkyuuBrush.class,                 true);
		WEAPONS.seen.put( DoremyDream.class,                true);
		WEAPONS.seen.put( HecatiaStar.class,                true);
		WEAPONS.seen.put( KokoroFan.class,                  true);
		WEAPONS.seen.put( NitoriRod.class,                  true);
		WEAPONS.seen.put( BlazingStar.class,                true);
		WEAPONS.seen.put( WatermelonSword.class,            true);
		WEAPONS.seen.put( AlchemyHat.class,                 true);
		WEAPONS.seen.put( PlayMat.class,                    true);
		WEAPONS.seen.put( RandomPhone.class,                true);
		WEAPONS.seen.put( TenkyuuCloak.class,               true);
		WEAPONS.seen.put( AlchemySword.class,               true);
		WEAPONS.seen.put( DeadBeacon.class,                 true);
		WEAPONS.seen.put( Longsword.class,                  true);
		WEAPONS.seen.put( BattleAxe.class,                  true);
		WEAPONS.seen.put( Flail.class,                      true);
		WEAPONS.seen.put( RunicBlade.class,                 true);
		WEAPONS.seen.put( AssassinsBlade.class,             true);
		WEAPONS.seen.put( Crossbow.class,                   true);
		WEAPONS.seen.put( YuyukoFoldingFan.class,           true);
		WEAPONS.seen.put( WindgodFan.class,                 true);
		WEAPONS.seen.put( MurasaDipper.class,               true);
		WEAPONS.seen.put( KogasaRod.class,                  true);
		WEAPONS.seen.put( JeweledPagoda.class,              true);
		WEAPONS.seen.put( YuukaUmbrella.class,              true);
		WEAPONS.seen.put( Levatein.class,                   true);
		WEAPONS.seen.put( KyoukoBroom.class,                true);
		WEAPONS.seen.put( Flintlock.class,                  true);
		WEAPONS.seen.put( TurnaboutCloak.class,             true);
		WEAPONS.seen.put( DoubleSword.class,                true);
		WEAPONS.seen.put( FireBrand.class,                  true);
		WEAPONS.seen.put( FrostBrand.class,                 true);
		WEAPONS.seen.put( Greatsword.class,                 true);
		WEAPONS.seen.put( WarHammer.class,                  true);
		WEAPONS.seen.put( Glaive.class,                     true);
		WEAPONS.seen.put( Greataxe.class,                   true);
		WEAPONS.seen.put( Greatshield.class,                true);
		WEAPONS.seen.put( Gauntlet.class,                   true);
		WEAPONS.seen.put( SwordofHisou.class,               true);
		WEAPONS.seen.put( MiracleRod.class,                 true);
		WEAPONS.seen.put( KomachiScythe.class,              true);
		WEAPONS.seen.put( FullmoonScythe.class,             true);
		WEAPONS.seen.put( Log.class,                        true);
		WEAPONS.seen.put( YoumuSword.class,                 true);
		WEAPONS.seen.put( PhoenixTail.class,                true);
		WEAPONS.seen.put( AutumnKatana.class,               true);
		WEAPONS.seen.put( EnmaShaku.class,                  true);
		WEAPONS.seen.put( SevenStarSword.class,             true);
		WEAPONS.seen.put( SagumeWing.class,                 true);
		WEAPONS.seen.put( ToramaruSpear.class,              true);
		WEAPONS.seen.put( KoishiSword.class,                true);
		WEAPONS.seen.put( WoodenBat.class,                  true);
		WEAPONS.seen.put( HoshigumaHorn.class,              true);
		WEAPONS.seen.put( ArisaKeyboard.class,              true);
		WEAPONS.seen.put( YukinaMic.class,                  true);
		WEAPONS.seen.put( HorouBook.class,                  true);
		WEAPONS.seen.put( Grayswandir.class,                true);
		WEAPONS.seen.put( LunaClock.class,                  true);
		WEAPONS.seen.put( FireBrand2.class,                 true);
		WEAPONS.seen.put( FrostBrand2.class,                true);
		WEAPONS.seen.put( TurnaboutSword.class,             true);
		WEAPONS.seen.put( HellKeyboard.class,               true);
		WEAPONS.seen.put( HellMic.class,                    true);

		ARMOR.seen.put( ClothArmor.class,                   true);
		ARMOR.seen.put( LeatherArmor.class,                 true);
		ARMOR.seen.put( MailArmor.class,                    true);
		ARMOR.seen.put( ScaleArmor.class,                   true);
		ARMOR.seen.put( PlateArmor.class,                   true);
		ARMOR.seen.put( PC98ReimuArmor.class,               true);
		ARMOR.seen.put( PC98MarisaArmor.class,              true);
		ARMOR.seen.put( YorihimeArmor.class,                true);
		ARMOR.seen.put( ToyohimeArmor.class,                true);
		ARMOR.seen.put( RumiaArmor.class,                   true);
		ARMOR.seen.put( HanasakigawaArmor.class,            true);
		ARMOR.seen.put( YuyukoArmor.class,                  true);
		ARMOR.seen.put( HecatiaArmor.class,                 true);
		ARMOR.seen.put( PoppinPartyArmor.class,             true);
		ARMOR.seen.put( MaxwellArmor.class,                 true);
		ARMOR.seen.put( GoldenDragonArmor.class,            true);

		WANDS.seen.put( WandOfMagicMissile.class,           true);
		WANDS.seen.put( WandOfLightning.class,              true);
		WANDS.seen.put( WandOfDisintegration.class,         true);
		WANDS.seen.put( WandOfFireblast.class,              true);
		WANDS.seen.put( WandOfCorrosion.class,              true);
		WANDS.seen.put( WandOfBlastWave.class,              true);
		WANDS.seen.put( WandOfLivingEarth.class,            true);
		WANDS.seen.put( WandOfFrost.class,                  true);
		WANDS.seen.put( WandOfPrismaticLight.class,         true);
		WANDS.seen.put( WandOfWarding.class,                true);
		WANDS.seen.put( WandOfTransfusion.class,            true);
		WANDS.seen.put( WandOfCorruption.class,             true);
		WANDS.seen.put( WandOfRegrowth.class,               true);
		WANDS.seen.put( WandOfReverseGravity.class,         true);
		WANDS.seen.put( WandOfAntiDoor.class,               true);
		WANDS.seen.put( WandOfAntiEmber.class,              true);
		WANDS.seen.put( WandOfWishing.class,                true);
		WANDS.seen.put( WandOfHealWounds.class,             true);
		WANDS.seen.put( WandOfDestOrb.class,                true);
		WANDS.seen.put( WandOfDeath.class,                  true);
		WANDS.seen.put( WandOfPurityBeam.class,             true);
		WANDS.seen.put( WandOfStableness.class,             true);
		WANDS.seen.put( WandOfSetsunatrip.class,            true);

		RINGS.seen.put( RingOfAccuracy.class,               true);
		RINGS.seen.put( RingOfEnergy.class,                 true);
		RINGS.seen.put( RingOfElements.class,               true);
		RINGS.seen.put( RingOfEvasion.class,                true);
		RINGS.seen.put( RingOfForce.class,                  true);
		RINGS.seen.put( RingOfFuror.class,                  true);
		RINGS.seen.put( RingOfHaste.class,                  true);
		RINGS.seen.put( RingOfMight.class,                  true);
		RINGS.seen.put( RingOfSharpshooting.class,          true);
		RINGS.seen.put( RingOfTenacity.class,               true);
		RINGS.seen.put( RingOfWealth.class,                 true);

		ARTIFACTS.seen.put( AlchemistsToolkit.class,        true);
		//ARTIFACTS.seen.put( CapeOfThorns.class,             false);
		ARTIFACTS.seen.put( ChaliceOfBlood.class,           true);
		ARTIFACTS.seen.put( CloakOfShadows.class,           true);
		ARTIFACTS.seen.put( DriedRose.class,                true);
		ARTIFACTS.seen.put( EtherealChains.class,           true);
		ARTIFACTS.seen.put( HornOfPlenty.class,             true);
		//ARTIFACTS.seen.put( LloydsBeacon.class,             false);
		ARTIFACTS.seen.put( MasterThievesArmband.class,     true);
		ARTIFACTS.seen.put( SandalsOfNature.class,          true);
		ARTIFACTS.seen.put( TalismanOfForesight.class,      true);
		ARTIFACTS.seen.put( TimekeepersHourglass.class,     true);
		ARTIFACTS.seen.put( UnstableSpellbook.class,        true);

		POTIONS.seen.put( PotionOfHealing.class,            true);
		POTIONS.seen.put( PotionOfStrength.class,           true);
		POTIONS.seen.put( PotionOfLiquidFlame.class,        true);
		POTIONS.seen.put( PotionOfFrost.class,              true);
		POTIONS.seen.put( PotionOfToxicGas.class,           true);
		POTIONS.seen.put( PotionOfParalyticGas.class,       true);
		POTIONS.seen.put( PotionOfPurity.class,             true);
		POTIONS.seen.put( PotionOfLevitation.class,         true);
		POTIONS.seen.put( PotionOfMindVision.class,         true);
		POTIONS.seen.put( PotionOfInvisibility.class,       true);
		POTIONS.seen.put( PotionOfExperience.class,         true);
		POTIONS.seen.put( PotionOfHaste.class,              true);
		POTIONS.seen.put( PotionOfMight.class,              true);
		POTIONS.seen.put( PotionOfDoublespeed.class,        true);
		POTIONS.seen.put( PotionOfBerserk.class,            true);
		POTIONS.seen.put( PotionOfLightHealing.class,       true);

		SCROLLS.seen.put( ScrollOfIdentify.class,           true);
		SCROLLS.seen.put( ScrollOfUpgrade.class,            true);
		SCROLLS.seen.put( ScrollOfRemoveCurse.class,        true);
		SCROLLS.seen.put( ScrollOfMagicMapping.class,       true);
		SCROLLS.seen.put( ScrollOfTeleportation.class,      true);
		SCROLLS.seen.put( ScrollOfRecharging.class,         true);
		SCROLLS.seen.put( ScrollOfMirrorImage.class,        true);
		SCROLLS.seen.put( ScrollOfTerror.class,             true);
		SCROLLS.seen.put( ScrollOfLullaby.class,            true);
		SCROLLS.seen.put( ScrollOfRage.class,               true);
		SCROLLS.seen.put( ScrollOfRetribution.class,        true);
		SCROLLS.seen.put( ScrollOfTransmutation.class,      true);
		SCROLLS.seen.put( ScrollOfSlowness.class,           true);
		SCROLLS.seen.put( ScrollOfBurning.class,            true);
		SCROLLS.seen.put( ScrollOfSilence.class,            true);
		SCROLLS.seen.put( ScrollOfRouteChange.class,        true);
	}

	public static LinkedHashMap<Catalog, Badges.Badge> catalogBadges = new LinkedHashMap<>();
	static {
		catalogBadges.put(WEAPONS, Badges.Badge.ALL_WEAPONS_IDENTIFIED);
		catalogBadges.put(ARMOR, Badges.Badge.ALL_ARMOR_IDENTIFIED);
		catalogBadges.put(WANDS, Badges.Badge.ALL_WANDS_IDENTIFIED);
		catalogBadges.put(RINGS, Badges.Badge.ALL_RINGS_IDENTIFIED);
		catalogBadges.put(ARTIFACTS, Badges.Badge.ALL_ARTIFACTS_IDENTIFIED);
		catalogBadges.put(POTIONS, Badges.Badge.ALL_POTIONS_IDENTIFIED);
		catalogBadges.put(SCROLLS, Badges.Badge.ALL_SCROLLS_IDENTIFIED);
	}

	public static boolean isSeen(Class<? extends Item> itemClass){
		for (Catalog cat : values()) {
			if (cat.seen.containsKey(itemClass)) {
				return cat.seen.get(itemClass);
			}
		}
		return false;
	}

	public static void setSeen(Class<? extends Item> itemClass){
		for (Catalog cat : values()) {
			if (cat.seen.containsKey(itemClass) && !cat.seen.get(itemClass)) {
				cat.seen.put(itemClass, true);
				Journal.saveNeeded = true;
			}
		}
		Badges.validateItemsIdentified();
	}

	private static final String CATALOG_ITEMS = "catalog_items";

	public static void store( Bundle bundle ){

		Badges.loadGlobal();

		ArrayList<Class> seen = new ArrayList<>();

		//if we have identified all items of a set, we use the badge to keep track instead.
		if (!Badges.isUnlocked(Badges.Badge.ALL_ITEMS_IDENTIFIED)) {
			for (Catalog cat : values()) {
				if (!Badges.isUnlocked(catalogBadges.get(cat))) {
					for (Class<? extends Item> item : cat.items()) {
						if (cat.seen.get(item)) seen.add(item);
					}
				}
			}
		}

		bundle.put( CATALOG_ITEMS, seen.toArray(new Class[0]) );

	}

	public static void restore( Bundle bundle ){

		Badges.loadGlobal();

		//logic for if we have all badges
		if (Badges.isUnlocked(Badges.Badge.ALL_ITEMS_IDENTIFIED)){
			for ( Catalog cat : values()){
				for (Class<? extends Item> item : cat.items()){
					cat.seen.put(item, true);
				}
			}
			return;
		}

		//catalog-specific badge logic
		for (Catalog cat : values()){
			if (Badges.isUnlocked(catalogBadges.get(cat))){
				for (Class<? extends Item> item : cat.items()){
					cat.seen.put(item, true);
				}
			}
		}

		//general save/load
		//includes "catalogs" for pre-0.8.2 saves
		if (bundle.contains("catalogs") || bundle.contains(CATALOG_ITEMS)) {
			List<Class> seenClasses = new ArrayList<>();
			if (bundle.contains(CATALOG_ITEMS)) {
				seenClasses = Arrays.asList(bundle.getClassArray(CATALOG_ITEMS));
			}
			List<String> seenItems = new ArrayList<>();
			if (bundle.contains("catalogs")) {
				Journal.saveNeeded = true; //we want to overwrite with the newer storage format
				seenItems = Arrays.asList(bundle.getStringArray("catalogs"));
			}

			for (Catalog cat : values()) {
				for (Class<? extends Item> item : cat.items()) {
					if (seenClasses.contains(item) || seenItems.contains(item.getSimpleName())) {
						cat.seen.put(item, true);
					}
				}
			}
		}
	}

}
