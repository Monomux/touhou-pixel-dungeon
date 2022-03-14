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
import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.QuickSlot;
import com.touhoupixel.touhoupixeldungeon.items.BrokenSeal;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.Prayer;
import com.touhoupixel.touhoupixeldungeon.items.MokouRibbon;
import com.touhoupixel.touhoupixeldungeon.items.Waterskin;
import com.touhoupixel.touhoupixeldungeon.items.armor.ClothArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.GoldenDragonArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.HanasakigawaArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.HecatiaArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.MaxwellArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.PC98MarisaArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.PC98ReimuArmor;
import com.touhoupixel.touhoupixeldungeon.items.armor.YuyukoArmor;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.CloakOfShadows;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.DriedRose;
import com.touhoupixel.touhoupixeldungeon.items.bags.FoodHolder;
import com.touhoupixel.touhoupixeldungeon.items.bags.MagicalHolster;
import com.touhoupixel.touhoupixeldungeon.items.bags.TailsmanHolder;
import com.touhoupixel.touhoupixeldungeon.items.bags.VelvetPouch;
import com.touhoupixel.touhoupixeldungeon.items.bombs.RegrowthBomb;
import com.touhoupixel.touhoupixeldungeon.items.food.Cucumber;
import com.touhoupixel.touhoupixeldungeon.items.food.Food;
import com.touhoupixel.touhoupixeldungeon.items.food.TwoSoySauce;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfBerserk;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfExperience;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHaste;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfInvisibility;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLightHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLiquidFlame;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfMight;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfMindVision;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfPurity;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.Elixir;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfAquaticRejuvenation;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfHoneyedHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfCleansing;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfDivineInspiration;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfMastery;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfYomi;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfIdentify;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfLullaby;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRage;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRouteChange;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfSilence;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfSlowness;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTransmutation;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfSirensSong;
import com.touhoupixel.touhoupixeldungeon.items.spells.PhaseShift;
import com.touhoupixel.touhoupixeldungeon.items.spells.Recycle;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfBlink;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.SwapTailsman;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfHealWounds;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfMagicMissile;
import com.touhoupixel.touhoupixeldungeon.items.weapon.SpiritBow;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.AlchemySword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Dagger;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Gloves;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Log;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MagesStaff;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MurasaDipper;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Psalms;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WornShortsword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YuyukoFoldingFan;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.FishingSpear;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.Shuriken;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.ThrowingKnife;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.ThrowingStone;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.watabou.utils.DeviceCompat;

public enum HeroClass {

	WARRIOR( HeroSubClass.BERSERKER, HeroSubClass.GLADIATOR ),
	MAGE( HeroSubClass.BATTLEMAGE, HeroSubClass.WARLOCK ),
	ROGUE( HeroSubClass.ASSASSIN, HeroSubClass.FREERUNNER ),
	HUNTRESS( HeroSubClass.SNIPER, HeroSubClass.WARDEN ),
	REISEN( HeroSubClass.MOONRABBIT, HeroSubClass.DESERTER ),
	NITORI( HeroSubClass.KAPPA, HeroSubClass.ENGINEER ),
	YUYUKO( HeroSubClass.GOURMET, HeroSubClass.DEATHGHOST ),
	MURASA( HeroSubClass.CAPTAIN, HeroSubClass.SHIPGHOST ),
	HINAPLAYER( HeroSubClass.SPINGOD, HeroSubClass.CURSEGOD ),
	KAGUYAPLAYER( HeroSubClass.TIMESTOP, HeroSubClass.TIMEMOVE );

	private HeroSubClass[] subClasses;

	HeroClass( HeroSubClass...subClasses ) {
		this.subClasses = subClasses;
	}

	public void initHero( Hero hero ) {

		hero.heroClass = this;
		Talent.initClassTalents(hero);

		Item i = new ClothArmor().identify();
		if (!Challenges.isItemBlocked(i)) hero.belongings.armor = (ClothArmor)i;

		i = new Food();
		if (!Challenges.isItemBlocked(i)) i.collect();

		new VelvetPouch().collect();
		Dungeon.LimitedDrops.VELVET_POUCH.drop();

		new MagicalHolster().collect();
		Dungeon.LimitedDrops.MAGICAL_HOLSTER.drop();

		new FoodHolder().collect();
		Dungeon.LimitedDrops.FOOD_HOLDER.drop();

		new TailsmanHolder().collect();
		Dungeon.LimitedDrops.TAILSMAN_HOLDER.drop();

		Waterskin waterskin = new Waterskin();
		waterskin.collect();

		if (Dungeon.isChallenged(Challenges.PACIFIST)) {
			DriedRose rose = new DriedRose();
			rose.identify().collect();
			WornShortsword wss = new WornShortsword();
			wss.identify().collect();
			ClothArmor ca = new ClothArmor();
			ca.identify().collect();
			ScrollOfIdentify soi = new ScrollOfIdentify();
			soi.quantity(5).identify().collect();
			ScrollOfSirensSong soss = new ScrollOfSirensSong();
			soss.quantity(5).identify().collect();
			ElixirOfHoneyedHealing eohh = new ElixirOfHoneyedHealing();
			eohh.quantity(5).identify().collect();
			PotionOfInvisibility Poi = new PotionOfInvisibility();
			Poi.quantity(5).identify().collect();
		}

		if (!Dungeon.isChallenged(Challenges.ATHEISM)) {
			Prayer pray = new Prayer();
			pray.collect();
			pray.identify();
			Dungeon.quickslot.setSlot(3, pray);
		}

		PotionOfHealing Poh = new PotionOfHealing();
		Poh.quantity(3).collect();

		ScrollOfUpgrade Upgrade = new ScrollOfUpgrade();
		if (!Dungeon.isChallenged(Challenges.MASTER_SPARK)) {
			Upgrade.quantity(3).collect();
		} else {
			Upgrade.quantity(6).collect();
		}

		new PotionOfHealing().identify();
		new ScrollOfRouteChange().identify();
		new ScrollOfUpgrade().identify();

		switch (this) {
			case WARRIOR:
				initWarrior( hero );
				break;

			case MAGE:
				initMage( hero );
				break;

			case ROGUE:
				initRogue( hero );
				break;

			case HUNTRESS:
				initHuntress( hero );
				break;

			case REISEN:
				initReisen( hero );
				break;

			case NITORI:
				initNitori( hero );
				break;

			case YUYUKO:
				initYuyuko( hero );
				break;

			case MURASA:
				initMurasa( hero );
				break;

			case HINAPLAYER:
				initHinaplayer( hero );
				break;

			case KAGUYAPLAYER:
				initKaguyaplayer( hero );
				break;
		}

		for (int s = 0; s < QuickSlot.SIZE; s++){
			if (Dungeon.quickslot.getItem(s) == null){
				Dungeon.quickslot.setSlot(s, waterskin);
				break;
			}
		}

	}

	private static void initWarrior( Hero hero ) {
		(hero.belongings.weapon = new WornShortsword()).identify();
		ThrowingStone stones = new ThrowingStone();
		stones.quantity(5).collect();

		PotionOfLightHealing LightHealing = new PotionOfLightHealing();
		LightHealing.quantity(3).collect();

		Dungeon.quickslot.setSlot(0, stones);

		if (hero.belongings.armor != null){
			hero.belongings.armor.affixSeal(new BrokenSeal());
		}

		new PotionOfLightHealing().identify();
		new PotionOfHealing().identify();
		new ScrollOfRage().identify();
	}

	private static void initMage( Hero hero ) {
		MagesStaff staff;

		staff = new MagesStaff(new WandOfMagicMissile());

		(hero.belongings.weapon = staff).identify();
		hero.belongings.weapon.activate(hero);

		Dungeon.quickslot.setSlot(0, staff);

		new ScrollOfTransmutation().identify();
		new PotionOfLiquidFlame().identify();
	}

	private static void initRogue( Hero hero ) {
		(hero.belongings.weapon = new Dagger()).identify();

		CloakOfShadows cloak = new CloakOfShadows();
		(hero.belongings.artifact = cloak).identify();
		hero.belongings.artifact.activate( hero );

		ThrowingKnife knives = new ThrowingKnife();
		knives.quantity(5).collect();

		Dungeon.quickslot.setSlot(0, cloak);
		Dungeon.quickslot.setSlot(1, knives);

		new ScrollOfMagicMapping().identify();
		new PotionOfInvisibility().identify();
	}

	private static void initHuntress( Hero hero ) {

		(hero.belongings.weapon = new Gloves()).identify();
		SpiritBow bow = new SpiritBow();
		bow.identify().collect();

		Dungeon.quickslot.setSlot(0, bow);

		new PotionOfMindVision().identify();
		new ScrollOfLullaby().identify();
	}

	private static void initReisen( Hero hero ) {
		(hero.belongings.weapon = new WornShortsword()).identify();

		FishingSpear knives2 = new FishingSpear();
		knives2.quantity(5).collect();

		Shuriken knives3 = new Shuriken();
		knives3.quantity(5).collect();

		Dungeon.quickslot.setSlot(0, knives2);
		Dungeon.quickslot.setSlot(1, knives3);

		new ScrollOfSilence().identify();
		new PotionOfMight().identify();
	}

	private static void initNitori( Hero hero ) {
		(hero.belongings.weapon = new WornShortsword()).identify();

		Cucumber LightHealing2 = new Cucumber();
		LightHealing2.quantity(5).collect();

		Recycle LightHealing3 = new Recycle();
		LightHealing3.quantity(3).collect();

		Dungeon.quickslot.setSlot(0, LightHealing2);
		Dungeon.quickslot.setSlot(1, LightHealing3);

		new ScrollOfTeleportation().identify();
		new PotionOfBerserk().identify();
	}

	private static void initYuyuko( Hero hero ) {
		(hero.belongings.weapon = new WornShortsword()).identify();

		YuyukoFoldingFan yffan = new YuyukoFoldingFan();
		yffan.collect();
		yffan.identify();

		TwoSoySauce soy = new TwoSoySauce();
		soy.quantity(3).collect();

		PotionOfYomi yomi = new PotionOfYomi();
		yomi.quantity(3).collect();

		Dungeon.quickslot.setSlot(0, soy);
		Dungeon.quickslot.setSlot(1, yomi);

		new ScrollOfSlowness().identify();
		new PotionOfLightHealing().identify();
	}

	private static void initMurasa( Hero hero ) {
		(hero.belongings.weapon = new WornShortsword()).identify();

		MurasaDipper md = new MurasaDipper();
		md.collect();
		md.identify();

		PotionOfHealing Healing = new PotionOfHealing();
		Healing.quantity(17).collect();

		PotionOfHaste haste = new PotionOfHaste();
		haste.quantity(20).collect();

		TwoSoySauce soy = new TwoSoySauce();
		soy.quantity(5).collect();

		ElixirOfAquaticRejuvenation eoar = new ElixirOfAquaticRejuvenation();
		eoar.quantity(5).collect();

		Dungeon.quickslot.setSlot(0, soy);
		Dungeon.quickslot.setSlot(1, eoar);

		new ScrollOfMagicMapping().identify();
		new PotionOfHaste().identify();
	}

	private static void initHinaplayer( Hero hero ) {
		(hero.belongings.weapon = new WornShortsword()).identify();

		PotionOfCleansing soy2 = new PotionOfCleansing();
		soy2.quantity(3).collect();

		ScrollOfRemoveCurse yomi2 = new ScrollOfRemoveCurse();
		yomi2.quantity(3).collect();

		Dungeon.quickslot.setSlot(0, soy2);
		Dungeon.quickslot.setSlot(1, yomi2);

		new ScrollOfRemoveCurse().identify();
		new PotionOfPurity().identify();
	}

	private static void initKaguyaplayer( Hero hero ) {
		(hero.belongings.weapon = new WornShortsword()).identify();

		ScrollOfSirensSong soss = new ScrollOfSirensSong();
		soss.quantity(3).collect();

		WandOfHealWounds wohw = new WandOfHealWounds();
		wohw.identify().collect();

		Dungeon.quickslot.setSlot(0, wohw);

		new ScrollOfLullaby().identify();
		new PotionOfLightHealing().identify();
	}

	public String title() {
		return Messages.get(HeroClass.class, name());
	}

	public String desc(){
		return Messages.get(HeroClass.class, name()+"_desc");
	}

	public HeroSubClass[] subClasses() {
		return subClasses;
	}

	public String spritesheet() {
		switch (this) {
			case WARRIOR: default:
				return Assets.Sprites.WARRIOR;
			case MAGE:
				return Assets.Sprites.MAGE;
			case ROGUE:
				return Assets.Sprites.ROGUE;
			case HUNTRESS:
				return Assets.Sprites.HUNTRESS;
			case REISEN:
				return Assets.Sprites.REISEN;
			case NITORI:
				return Assets.Sprites.NITORI;
			case YUYUKO:
				return Assets.Sprites.YUYUKO;
			case MURASA:
				return Assets.Sprites.MURASA;
			case HINAPLAYER:
				return Assets.Sprites.HINAPLAYER;
			case KAGUYAPLAYER:
				return Assets.Sprites.KAGUYAPLAYER;
		}
	}

	public String splashArt(){
		switch (this) {
			case WARRIOR: default:
				return Assets.Splashes.WARRIOR;
			case MAGE:
				return Assets.Splashes.MAGE;
			case ROGUE:
				return Assets.Splashes.ROGUE;
			case HUNTRESS:
				return Assets.Splashes.HUNTRESS;
			case REISEN:
				return Assets.Splashes.REISEN;
			case NITORI:
				return Assets.Splashes.NITORI;
			case YUYUKO:
				return Assets.Splashes.YUYUKO;
			case MURASA:
				return Assets.Splashes.MURASA;
			case HINAPLAYER:
				return Assets.Splashes.HINAPLAYER;
			case KAGUYAPLAYER:
				return Assets.Splashes.KAGUYAPLAYER;
		}
	}

	public String[] perks() {
		switch (this) {
			case WARRIOR: default:
				return new String[]{
						Messages.get(HeroClass.class, "warrior_perk1"),
						Messages.get(HeroClass.class, "warrior_perk2"),
						Messages.get(HeroClass.class, "warrior_perk3"),
						Messages.get(HeroClass.class, "warrior_perk4"),
						Messages.get(HeroClass.class, "warrior_perk5"),
				};
			case MAGE:
				return new String[]{
						Messages.get(HeroClass.class, "mage_perk1"),
						Messages.get(HeroClass.class, "mage_perk2"),
						Messages.get(HeroClass.class, "mage_perk3"),
						Messages.get(HeroClass.class, "mage_perk4"),
						Messages.get(HeroClass.class, "mage_perk5"),
				};
			case ROGUE:
				return new String[]{
						Messages.get(HeroClass.class, "rogue_perk1"),
						Messages.get(HeroClass.class, "rogue_perk2"),
						Messages.get(HeroClass.class, "rogue_perk3"),
						Messages.get(HeroClass.class, "rogue_perk4"),
						Messages.get(HeroClass.class, "rogue_perk5"),
				};
			case HUNTRESS:
				return new String[]{
						Messages.get(HeroClass.class, "huntress_perk1"),
						Messages.get(HeroClass.class, "huntress_perk2"),
						Messages.get(HeroClass.class, "huntress_perk3"),
						Messages.get(HeroClass.class, "huntress_perk4"),
						Messages.get(HeroClass.class, "huntress_perk5"),
				};
			case REISEN:
				return new String[]{
						Messages.get(HeroClass.class, "reisen_perk1"),
						Messages.get(HeroClass.class, "reisen_perk2"),
						Messages.get(HeroClass.class, "reisen_perk3"),
						Messages.get(HeroClass.class, "reisen_perk4"),
						Messages.get(HeroClass.class, "reisen_perk5"),
				};
			case NITORI:
				return new String[]{
						Messages.get(HeroClass.class, "nitori_perk1"),
						Messages.get(HeroClass.class, "nitori_perk2"),
						Messages.get(HeroClass.class, "nitori_perk3"),
						Messages.get(HeroClass.class, "nitori_perk4"),
						Messages.get(HeroClass.class, "nitori_perk5"),
				};
			case YUYUKO:
				return new String[]{
						Messages.get(HeroClass.class, "yuyuko_perk1"),
						Messages.get(HeroClass.class, "yuyuko_perk2"),
						Messages.get(HeroClass.class, "yuyuko_perk3"),
						Messages.get(HeroClass.class, "yuyuko_perk4"),
						Messages.get(HeroClass.class, "yuyuko_perk5"),
				};
			case MURASA:
				return new String[]{
						Messages.get(HeroClass.class, "murasa_perk1"),
						Messages.get(HeroClass.class, "murasa_perk2"),
						Messages.get(HeroClass.class, "murasa_perk3"),
						Messages.get(HeroClass.class, "murasa_perk4"),
						Messages.get(HeroClass.class, "murasa_perk5"),
				};
			case HINAPLAYER:
				return new String[]{
						Messages.get(HeroClass.class, "hinaplayer_perk1"),
						Messages.get(HeroClass.class, "hinaplayer_perk2"),
						Messages.get(HeroClass.class, "hinaplayer_perk3"),
						Messages.get(HeroClass.class, "hinaplayer_perk4"),
						Messages.get(HeroClass.class, "hinaplayer_perk5"),
				};
			case KAGUYAPLAYER:
				return new String[]{
						Messages.get(HeroClass.class, "kaguyaplayer_perk1"),
						Messages.get(HeroClass.class, "kaguyaplayer_perk2"),
						Messages.get(HeroClass.class, "kaguyaplayer_perk3"),
						Messages.get(HeroClass.class, "kaguyaplayer_perk4"),
						Messages.get(HeroClass.class, "kaguyaplayer_perk5"),
				};
		}
	}

	public boolean isUnlocked(){
		//always unlock on debug builds
		if (DeviceCompat.isDebug()) return true;

		switch (this){
			case WARRIOR:
			default:
				return true;
			case MAGE:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_MAGE);
			case ROGUE:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_ROGUE);
			case HUNTRESS:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_HUNTRESS);
			case REISEN:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_REISEN);
			case NITORI:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_NITORI);
			case YUYUKO:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_YUYUKO);
			case MURASA:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_MURASA);
			case HINAPLAYER:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_HINAPLAYER);
			case KAGUYAPLAYER:
				return Badges.isUnlocked(Badges.Badge.UNLOCK_KAGUYAPLAYER);
		}
	}

	public String unlockMsg() {
		switch (this){
			case WARRIOR:
			default:
				return "";
			case MAGE:
				return Messages.get(HeroClass.class, "mage_unlock");
			case ROGUE:
				return Messages.get(HeroClass.class, "rogue_unlock");
			case HUNTRESS:
				return Messages.get(HeroClass.class, "huntress_unlock");
			case REISEN:
				return Messages.get(HeroClass.class, "reisen_unlock");
			case NITORI:
				return Messages.get(HeroClass.class, "nitori_unlock");
			case YUYUKO:
				return Messages.get(HeroClass.class, "yuyuko_unlock");
			case MURASA:
				return Messages.get(HeroClass.class, "murasa_unlock");
			case HINAPLAYER:
				return Messages.get(HeroClass.class, "hinaplayer_unlock");
			case KAGUYAPLAYER:
				return Messages.get(HeroClass.class, "kaguyaplayer_unlock");
		}
	}

}