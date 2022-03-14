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
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.GamesInProgress;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AnkhInvulnerability;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArtifactRecharge;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bleeding;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.CounterBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Degrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doubleevasion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.EnhancedRings;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FlavourBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Invisibility;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Light;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.LostInventory;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MagicImmune;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MindVision;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Paralysis;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.PotionPreserve;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Recharging;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.RevealedArea;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Roots;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Stamina;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.WandEmpower;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Mob;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.effects.SpellSprite;
import com.touhoupixel.touhoupixeldungeon.effects.particles.LeafParticle;
import com.touhoupixel.touhoupixeldungeon.items.Ankh;
import com.touhoupixel.touhoupixeldungeon.items.BrokenSeal;
import com.touhoupixel.touhoupixeldungeon.items.EquipableItem;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.armor.Armor;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.CloakOfShadows;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.HornOfPlenty;
import com.touhoupixel.touhoupixeldungeon.items.food.Cucumber;
import com.touhoupixel.touhoupixeldungeon.items.food.FrozenCarpaccio;
import com.touhoupixel.touhoupixeldungeon.items.food.MiracleFruit;
import com.touhoupixel.touhoupixeldungeon.items.food.Pancake;
import com.touhoupixel.touhoupixeldungeon.items.food.Pasty;
import com.touhoupixel.touhoupixeldungeon.items.food.TenshiPeach;
import com.touhoupixel.touhoupixeldungeon.items.food.Waffle;
import com.touhoupixel.touhoupixeldungeon.items.potions.Potion;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfDoublespeed;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfExperience;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfInvisibility;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLevitation;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLightHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLiquidFlame;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfMight;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfParalyticGas;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfStrength;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfAquaticRejuvenation;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfCorrosiveGas;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfInvulnerability;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfPhilosopher;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfTriplespeed;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfYomi;
import com.touhoupixel.touhoupixeldungeon.items.rings.Ring;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.Scroll;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfIdentify;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRage;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRecharging;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfSlowness;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTransmutation;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfChallenge;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfDread;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfSirensSong;
import com.touhoupixel.touhoupixeldungeon.items.spells.AquaBlast;
import com.touhoupixel.touhoupixeldungeon.items.spells.CurseInfusion;
import com.touhoupixel.touhoupixeldungeon.items.wands.Wand;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfHealWounds;
import com.touhoupixel.touhoupixeldungeon.items.weapon.Weapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.KeineBook;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MagesStaff;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.MissileWeapon;
import com.touhoupixel.touhoupixeldungeon.levels.Level;
import com.touhoupixel.touhoupixeldungeon.levels.Terrain;
import com.touhoupixel.touhoupixeldungeon.messages.Languages;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.plants.Sungrass;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.ui.BuffIndicator;
import com.watabou.noosa.Image;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.particles.Emitter;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public enum Talent {

	//Warrior T1
	HEARTY_MEAL(0), ARMSMASTERS_INTUITION(1), TEST_SUBJECT(2), IRON_WILL(3),
	//Warrior T2
	IRON_STOMACH(4), RESTORED_WILLPOWER(5), RUNIC_TRANSFERENCE(6), LETHAL_MOMENTUM(7), IMPROVISED_PROJECTILES(8),
	//Warrior T3
	HOLD_FAST(9, 3), STRONGMAN(10, 3),
	//Berserker T3
	ENDLESS_RAGE(11, 3), BERSERKING_STAMINA(12, 3), ENRAGED_CATALYST(13, 3),
	//Gladiator T3
	CLEAVE(14, 3), LETHAL_DEFENSE(15, 3), ENHANCED_COMBO(16, 3),

	//Mage T1
	EMPOWERING_MEAL(32), SCHOLARS_INTUITION(33), TESTED_HYPOTHESIS(34), BACKUP_BARRIER(35),
	//Mage T2
	ENERGIZING_MEAL(36), ENERGIZING_UPGRADE(37), WAND_PRESERVATION(38), ARCANE_VISION(39), SHIELD_BATTERY(40),
	//Mage T3
	EMPOWERING_SCROLLS(41, 3), ALLY_WARP(42, 3),
	//Battlemage T3
	EMPOWERED_STRIKE(43, 3), MYSTICAL_CHARGE(44, 3), EXCESS_CHARGE(45, 3),
	//Ran T3
	SOUL_EATER(46, 3), SOUL_SIPHON(47, 3), NECROMANCERS_MINIONS(48, 3),

	//Rogue T1
	CACHED_RATIONS(64), THIEFS_INTUITION(65), SUCKER_PUNCH(66), PROTECTIVE_SHADOWS(67),
	//Rogue T2
	MYSTICAL_MEAL(68), MYSTICAL_UPGRADE(69), WIDE_SEARCH(70), SILENT_STEPS(71), ROGUES_FORESIGHT(72),
	//Rogue T3
	ENHANCED_RINGS(73, 3), LIGHT_CLOAK(74, 3),
	//Assassin T3
	ENHANCED_LETHALITY(75, 3), ASSASSINS_REACH(76, 3), BOUNTY_HUNTER(77, 3),
	//Freerunner T3
	EVASIVE_ARMOR(78, 3), PROJECTILE_MOMENTUM(79, 3), SPEEDY_STEALTH(80, 3),

	//Huntress T1
	NATURES_BOUNTY(96), SURVIVALISTS_INTUITION(97), FOLLOWUP_STRIKE(98), NATURES_AID(99),
	//Huntress T2
	INVIGORATING_MEAL(100), RESTORED_NATURE(101), REJUVENATING_STEPS(102), HEIGHTENED_SENSES(103), DURABLE_PROJECTILES(104),
	//Huntress T3
	POINT_BLANK(105, 3), SEER_SHOT(106, 3),
	//Sniper T3
	FARSIGHT(107, 3), SHARED_ENCHANTMENT(108, 3), SHARED_UPGRADES(109, 3),
	//Warden T3
	DURABLE_TIPS(110, 3), BARKSKIN(111, 3), SHIELDING_DEW(112, 3),

	//Reisen T1
	EIENTEI_MEAL(128), POTION_INTUITION(129), DANMAKU_STRIKE(130), EIENTEI_LUCK(131),
	//Reisen T2
	EIENTEI_ENHANCE_MEAL(132), GAINING_HEALING(133), DANMAKU_ENHANCE_STRIKE(134), EIENTEI_ENHANCED_LUCK(135), INVU_IDENTIFY(136),
	//Reisen T3
	SIMPLE_POWER(137, 3), INVU_POWER(138, 3),
	//Moonrabbit T3
	PARA_RESISTANCE(139, 3), GAS_RESISTANCE(140, 3), DEGRADE_RESISTANCE(141, 3),
	//Deserter T3
	DANMAKU_HEAL(142, 3), DANMAKU_BLESS(143, 3), DANMAKU_SPEED(144, 3),

	//Nitori T1
	KAPPA_MEAL(160), SCROLL_INTUITION(161), CUCUMBER_HEAL(162), BASIC_FUSION(163),
	//Nitori T2
	KAPPA_ENHANCE_MEAL(164), RISKY_IDENTIFY(165), FEW_CUCUMBER(166), MEDIUM_FUSION(167), ADVANCED_FUSION(168),
	//Nitori T3
	GAINING_CUCUMBER(169, 3), GAINING_TRANSMUTE(170, 3),
	//Kappa T3
	CUCUMBER_MEAL(171, 3), AQUA_UPGRADE(172, 3), AQUA_POTION(173, 3),
	//Engineer T3
	DANGEROUS_MEAL(174, 3), RISKY_UPGRADE(175, 3), RISKY_POTION(176, 3),

	//YuyukoBoss T1
	ANIMAL_MEAL(192), PASTY_GAIN(193), CUCUMBER_GAIN(194), FROZEN_FOOD_GAIN(195),
	//YuyukoBoss T2
	ANIMAL_ENHANCED_MEAL(196), QUICK_MEAL(197), MORE_FOOD_PANCAKE(198), MORE_FOOD_WAFFLE(199), MORE_FOOD_FRUIT(200),
	//YuyukoBoss T3
	EVERYONE_IS_MEAL(201, 3), TENSHI_PEACH_GAIN(202, 3),
	//Gourmet T3
	TRIPLESPEED_MEAL(203, 3), MIND_VISION_MEAL(204, 3), MAGIC_IMMUNE_MEAL(205, 3),
	//Deathghost T3
	CONTROL_DEATH(206, 3), DOOM_ATTACK(207, 3), COMING_DEATH(208, 3),

	//Murasa T1
	GAIN_AQUA_REGEN(224), GAIN_AQUA_BLAST(225), AQUA_STRIKE(226), AQUA_LIGHT(227),
	//Murasa T2
	GAIN_MORE_AQUA_REGEN(228), GAIN_MORE_AQUA_BLAST(229), EXHAUSTIVE_FOOD(230), GHOST_TENSITY(231), AQUA_BLESS(232),
	//Murasa T3
	AQUA_FOOD(233, 3), MORE_GHOST_TENSITY(234, 3),
	//Captain T3
	AQUA_STAMINA(235, 3), AQUA_HASTE(236, 3), AQUA_MINDVISION(237, 3),
	//Shipghost T3
	AQUA_PARALYSIS(238, 3), AQUA_SLOW(239, 3), AQUA_INSTAKILL(240, 3),

	//Hina T1
	CURSED_MEAL(256), GAIN_CURSED_METAL(257), CURSED_IDENTIFY(258), CURSED_MINDVISION(259),
	//Hina T2
	CURSED_EXTRA_MEAL(260), GAIN_METAL_AND_REMOVE(261), EMER_UNIDENTIFY(262), CURSED_HASTE(263), CURSED_INVU(264),
	//Hina T3
	CURSED_SET(265, 3), CURSED_PRESERVE(266, 3),
	//Spingod T3
	SPIN_BLIND(267, 3), SPIN_HEX(268, 3), SPIN_HEAL(269, 3),
	//Cursegod T3
	CURSED_SNEAKATTACK(270, 3), CURSED_INVISIBILITY(271, 3), CURSED_ACC(272, 3),

	//Kaguya T1
	GAIN_ALCHEMY_ENERGY(288), GAIN_RECHARGE(289), GAIN_CSD(290), GAIN_WAND(291),
	//Kaguya T2
	HEALWAND_SILENCE(292), UPGRADE_MAXHT_UP(293), POTION_PRESERVE(294), GAIN_POTIONOFHEALING(295), GAIN_SUNGRASSSEED(296),
	//Kaguya T3
	HEALWAND_SIMPLE(297, 3), MAXHT_UP(298, 3),
	//Timestop T3
	HEALWAND_MV_AND_LEV(299, 3), HEALWAND_LIGHT_AND_BLESS(300, 3), HEALWAND_THREESPEED(301, 3),
	//Timemove T3
	MAXHP_SPEED(302, 3), MAXHP_EVASION(303, 3), MAXHP_ACC(304, 3);

	public static class ImprovisedProjectileCooldown extends FlavourBuff {
		public int icon() {
			return BuffIndicator.TIME;
		}

		public void tintIcon(Image icon) {
			icon.hardlight(0.15f, 0.2f, 0.5f);
		}

		public float iconFadePercent() {
			return Math.max(0, visualcooldown() / 50);
		}

		public String toString() {
			return Messages.get(this, "name");
		}

		public String desc() {
			return Messages.get(this, "desc", dispTurns(visualcooldown()));
		}
	}

	;

	public static class LethalMomentumTracker extends FlavourBuff {
	}

	;

	public static class StrikingWaveTracker extends FlavourBuff {
	}

	;

	public static class WandPreservationCounter extends CounterBuff {
		{
			revivePersists = true;
		}}

	;

	public static class EmpoweredStrikeTracker extends FlavourBuff {
	}

	;

	public static class BountyHunterTracker extends FlavourBuff {
	}

	;

	public static class RejuvenatingStepsCooldown extends FlavourBuff {
		public int icon() {
			return BuffIndicator.TIME;
		}

		public void tintIcon(Image icon) {
			icon.hardlight(0f, 0.35f, 0.15f);
		}

		public float iconFadePercent() {
			return Math.max(0, visualcooldown() / (15 - 5 * Dungeon.hero.pointsInTalent(REJUVENATING_STEPS)));
		}

		public String toString() {
			return Messages.get(this, "name");
		}

		public String desc() {
			return Messages.get(this, "desc", dispTurns(visualcooldown()));
		}
	}

	;

	public static class RejuvenatingStepsFurrow extends CounterBuff {
		{
			revivePersists = true;
		}}

	;

	public static class SeerShotCooldown extends FlavourBuff {
		public int icon() {
			return target.buff(RevealedArea.class) != null ? BuffIndicator.NONE : BuffIndicator.TIME;
		}

		public void tintIcon(Image icon) {
			icon.hardlight(0.7f, 0.4f, 0.7f);
		}

		public float iconFadePercent() {
			return Math.max(0, visualcooldown() / 20);
		}

		public String toString() {
			return Messages.get(this, "name");
		}

		public String desc() {
			return Messages.get(this, "desc", dispTurns(visualcooldown()));
		}
	}

	;

	public static class SpiritBladesTracker extends FlavourBuff {
	}

	;

	int icon;
	int maxPoints;

	// tiers 1/2/3/4 start at levels 2/7/13/21
	public static int[] tierLevelThresholds = new int[]{0, 2, 7, 13, 21, 31};

	Talent(int icon) {
		this(icon, 2);
	}

	Talent(int icon, int maxPoints) {
		this.icon = icon;
		this.maxPoints = maxPoints;
	}

	public int icon() {
		return icon;
	}

	public int maxPoints(){
		return maxPoints;
	}

	public String title(){
		return Messages.get(this, name() + ".title");
	}

	public String desc(){
		return Messages.get(this, name() + ".desc");
	}

	public static void onTalentUpgraded( Hero hero, Talent talent){
		if (talent == NATURES_BOUNTY){
			if ( hero.pointsInTalent(NATURES_BOUNTY) == 1) Buff.count(hero, NatureBerriesAvailable.class, 4);
			else                                           Buff.count(hero, NatureBerriesAvailable.class, 2);
		}

		if (talent == ARMSMASTERS_INTUITION && hero.pointsInTalent(ARMSMASTERS_INTUITION) == 2){
			if (hero.belongings.weapon() != null) hero.belongings.weapon().identify();
			if (hero.belongings.armor() != null)  hero.belongings.armor.identify();
		}
		if (talent == POTION_INTUITION && hero.pointsInTalent(POTION_INTUITION) == 1){
			new PotionOfExperience().identify();
			new PotionOfLiquidFlame().identify();
			new PotionOfLevitation().identify();
		}
		if (talent == POTION_INTUITION && hero.pointsInTalent(POTION_INTUITION) == 2){
			new PotionOfInvisibility().identify();
			new PotionOfParalyticGas().identify();
			new PotionOfDoublespeed().identify();
		}
		if (talent == SCROLL_INTUITION && hero.pointsInTalent(SCROLL_INTUITION) == 1){
			new ScrollOfIdentify().identify();
			new ScrollOfRemoveCurse().identify();
			new ScrollOfMagicMapping().identify();
		}
		if (talent == SCROLL_INTUITION && hero.pointsInTalent(SCROLL_INTUITION) == 2){
			new ScrollOfRage().identify();
			new ScrollOfSlowness().identify();
			new ScrollOfTransmutation().identify();
		}

		if (talent == FEW_CUCUMBER && hero.pointsInTalent(FEW_CUCUMBER) == 1) {
			Cucumber Cucumber = new Cucumber();
			Cucumber.quantity(3).collect();
		}
		if (talent == FEW_CUCUMBER && hero.pointsInTalent(FEW_CUCUMBER) == 2) {
			Cucumber Cucumber = new Cucumber();
			Cucumber.quantity(3).collect();
		}

		if (talent == GAINING_CUCUMBER && hero.pointsInTalent(GAINING_CUCUMBER) == 1) {
			Cucumber Cucumber = new Cucumber();
			Cucumber.quantity(5).collect();
		}
		if (talent == GAINING_CUCUMBER && hero.pointsInTalent(GAINING_CUCUMBER) == 2) {
			Cucumber Cucumber = new Cucumber();
			Cucumber.quantity(5).collect();
		}
		if (talent == GAINING_CUCUMBER && hero.pointsInTalent(GAINING_CUCUMBER) == 3) {
			Cucumber Cucumber = new Cucumber();
			Cucumber.quantity(5).collect();
		}

		if (talent == SIMPLE_POWER && hero.pointsInTalent(SIMPLE_POWER) == 1){
			ScrollOfUpgrade Healing2 = new ScrollOfUpgrade();
			Healing2.quantity(1).collect();
		}
		if (talent == SIMPLE_POWER && hero.pointsInTalent(SIMPLE_POWER) == 2){
			ScrollOfUpgrade Healing2 = new ScrollOfUpgrade();
			Healing2.quantity(1).collect();
		}
		if (talent == SIMPLE_POWER && hero.pointsInTalent(SIMPLE_POWER) == 3){
			ScrollOfUpgrade Healing2 = new ScrollOfUpgrade();
			Healing2.quantity(1).collect();
		}
		if (talent == INVU_POWER && hero.pointsInTalent(INVU_POWER) == 1){
			PotionOfInvulnerability Poi = new PotionOfInvulnerability();
			Poi.quantity(1).collect();
		}
		if (talent == INVU_POWER && hero.pointsInTalent(INVU_POWER) == 2){
			PotionOfInvulnerability Poi = new PotionOfInvulnerability();
			Poi.quantity(1).collect();
		}
		if (talent == INVU_POWER && hero.pointsInTalent(INVU_POWER) == 3){
			PotionOfInvulnerability Poi = new PotionOfInvulnerability();
			Poi.quantity(1).collect();
		}

		if (talent == GAINING_HEALING && hero.pointsInTalent(GAINING_HEALING) == 1){
			PotionOfHealing Healing4 = new PotionOfHealing();
			Healing4.quantity(2).collect();
		}
		if (talent == GAINING_HEALING && hero.pointsInTalent(GAINING_HEALING) == 2){
			PotionOfHealing Healing4 = new PotionOfHealing();
			Healing4.quantity(2).collect();
		}

		if (talent == GAINING_TRANSMUTE && hero.pointsInTalent(GAINING_TRANSMUTE) == 1){
			ScrollOfTransmutation Healing4 = new ScrollOfTransmutation();
			Healing4.quantity(1).collect();
		}
		if (talent == GAINING_TRANSMUTE && hero.pointsInTalent(GAINING_TRANSMUTE) == 2){
			ScrollOfTransmutation Healing4 = new ScrollOfTransmutation();
			Healing4.quantity(1).collect();
		}
		if (talent == GAINING_TRANSMUTE && hero.pointsInTalent(GAINING_TRANSMUTE) == 3){
			ScrollOfTransmutation Healing4 = new ScrollOfTransmutation();
			Healing4.quantity(1).collect();
		}

		if (talent == PARA_RESISTANCE && hero.pointsInTalent(PARA_RESISTANCE) == 1){
			PotionOfParalyticGas Healing5 = new PotionOfParalyticGas();
			Healing5.quantity(5).collect();
		}
		if (talent == PARA_RESISTANCE && hero.pointsInTalent(PARA_RESISTANCE) == 2){
			PotionOfParalyticGas Healing5 = new PotionOfParalyticGas();
			Healing5.quantity(5).collect();
		}
		if (talent == PARA_RESISTANCE && hero.pointsInTalent(PARA_RESISTANCE) == 3){
			PotionOfParalyticGas Healing5 = new PotionOfParalyticGas();
			Healing5.quantity(5).collect();
		}
		if (talent == GAS_RESISTANCE && hero.pointsInTalent(GAS_RESISTANCE) == 1) {
			PotionOfCorrosiveGas Healing54 = new PotionOfCorrosiveGas();
			Healing54.quantity(5).collect();
		}
		if (talent == GAS_RESISTANCE && hero.pointsInTalent(GAS_RESISTANCE) == 2){
			PotionOfCorrosiveGas Healing54 = new PotionOfCorrosiveGas();
			Healing54.quantity(5).collect();
		}
		if (talent == GAS_RESISTANCE && hero.pointsInTalent(GAS_RESISTANCE) == 3) {
			PotionOfCorrosiveGas Healing54 = new PotionOfCorrosiveGas();
			Healing54.quantity(5).collect();
		}
		if (talent == DEGRADE_RESISTANCE && hero.pointsInTalent(DEGRADE_RESISTANCE) == 1){
			PotionOfPhilosopher pop = new PotionOfPhilosopher();
			pop.quantity(3).collect();
		}
		if (talent == DEGRADE_RESISTANCE && hero.pointsInTalent(DEGRADE_RESISTANCE) == 2){
			PotionOfPhilosopher pop = new PotionOfPhilosopher();
			pop.quantity(3).collect();
		}
		if (talent == DEGRADE_RESISTANCE && hero.pointsInTalent(DEGRADE_RESISTANCE) == 3) {
			PotionOfPhilosopher pop = new PotionOfPhilosopher();
			pop.quantity(3).collect();
		}

		if (talent == BASIC_FUSION && hero.pointsInTalent(BASIC_FUSION) == 1){
			Generator.Category c = Generator.Category.WEP_T2;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
		}
		if (talent == BASIC_FUSION && hero.pointsInTalent(BASIC_FUSION) == 2){
			Generator.Category c = Generator.Category.WEP_T3;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
		}

		if (talent == MEDIUM_FUSION && hero.pointsInTalent(MEDIUM_FUSION) == 1){
			Generator.Category c = Generator.Category.WEP_T3;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
		}
		if (talent == MEDIUM_FUSION && hero.pointsInTalent(MEDIUM_FUSION) == 2){
			Generator.Category c = Generator.Category.WEP_T4;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
		}

		if (talent == ADVANCED_FUSION && hero.pointsInTalent(ADVANCED_FUSION) == 1){
			Generator.Category c = Generator.Category.WEP_T4;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
		}
		if (talent == ADVANCED_FUSION && hero.pointsInTalent(ADVANCED_FUSION) == 2){
			Generator.Category c = Generator.Category.WEP_T5;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
		}

		if (talent == PASTY_GAIN && hero.pointsInTalent(PASTY_GAIN) == 1) {
			Pasty Healing212 = new Pasty();
			Healing212.quantity(2).collect();
		}
		if (talent == PASTY_GAIN && hero.pointsInTalent(PASTY_GAIN) == 2) {
			Pasty Healing212 = new Pasty();
			Healing212.quantity(2).collect();
		}

		if (talent == CUCUMBER_GAIN && hero.pointsInTalent(CUCUMBER_GAIN) == 1) {
			Cucumber Healing211 = new Cucumber();
			Healing211.quantity(5).collect();
		}
		if (talent == CUCUMBER_GAIN && hero.pointsInTalent(CUCUMBER_GAIN) == 2) {
			Cucumber Healing211 = new Cucumber();
			Healing211.quantity(5).collect();
		}

		if (talent == FROZEN_FOOD_GAIN && hero.pointsInTalent(FROZEN_FOOD_GAIN) == 1) {
			FrozenCarpaccio Healing213 = new FrozenCarpaccio();
			Healing213.quantity(5).collect();
		}
		if (talent == FROZEN_FOOD_GAIN && hero.pointsInTalent(FROZEN_FOOD_GAIN) == 2) {
			FrozenCarpaccio Healing213 = new FrozenCarpaccio();
			Healing213.quantity(5).collect();
		}

		if (talent == MORE_FOOD_PANCAKE && hero.pointsInTalent(MORE_FOOD_PANCAKE) == 1) {
			Pancake Healing214 = new Pancake();
			Healing214.quantity(5).collect();
		}
		if (talent == MORE_FOOD_PANCAKE && hero.pointsInTalent(MORE_FOOD_PANCAKE) == 2) {
			Pancake Healing214 = new Pancake();
			Healing214.quantity(5).collect();
		}

		if (talent == MORE_FOOD_WAFFLE && hero.pointsInTalent(MORE_FOOD_WAFFLE) == 1) {
			Waffle Healing215 = new Waffle();
			Healing215.quantity(5).collect();
		}
		if (talent == MORE_FOOD_WAFFLE && hero.pointsInTalent(MORE_FOOD_WAFFLE) == 2) {
			Waffle Healing215 = new Waffle();
			Healing215.quantity(5).collect();
		}

		if (talent == MORE_FOOD_FRUIT && hero.pointsInTalent(MORE_FOOD_FRUIT) == 1) {
			MiracleFruit Healing216 = new MiracleFruit();
			Healing216.quantity(5).collect();
		}
		if (talent == MORE_FOOD_FRUIT && hero.pointsInTalent(MORE_FOOD_FRUIT) == 2) {
			MiracleFruit Healing216 = new MiracleFruit();
			Healing216.quantity(5).collect();
		}

		if (talent == GAIN_CURSED_METAL && hero.pointsInTalent(GAIN_CURSED_METAL) == 1) {
			CurseInfusion Crinfu = new CurseInfusion();
			Crinfu.quantity(3).collect();
		}
		if (talent == GAIN_CURSED_METAL && hero.pointsInTalent(GAIN_CURSED_METAL) == 2) {
			CurseInfusion Crinfu = new CurseInfusion();
			Crinfu.quantity(3).collect();
		}

		if (talent == GAIN_METAL_AND_REMOVE && hero.pointsInTalent(GAIN_METAL_AND_REMOVE) == 1) {
			CurseInfusion Crinfu = new CurseInfusion();
			Crinfu.quantity(3).collect();
			ScrollOfRemoveCurse Sorc = new ScrollOfRemoveCurse();
			Sorc.quantity(3).collect();
		}
		if (talent == GAIN_METAL_AND_REMOVE && hero.pointsInTalent(GAIN_METAL_AND_REMOVE) == 2) {
			CurseInfusion Crinfu = new CurseInfusion();
			Crinfu.quantity(3).collect();
			ScrollOfRemoveCurse Sorc = new ScrollOfRemoveCurse();
			Sorc.quantity(3).collect();
		}

		if (talent == CURSED_SET && hero.pointsInTalent(CURSED_SET) == 1) {
			CurseInfusion Crinfu = new CurseInfusion();
			Crinfu.quantity(3).collect();
			ScrollOfRemoveCurse Sorc = new ScrollOfRemoveCurse();
			Sorc.quantity(3).collect();
			if (!(Dungeon.hero.belongings.weapon() instanceof KeineBook)) {
				Potion.initColors();
				Scroll.initLabels();
				Ring.initGems();
				Item.updateQuickslot();
			}
			Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION);
			Buff.prolong(hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION*5f);
			ScrollOfUpgrade Healing2 = new ScrollOfUpgrade();
			Healing2.quantity(1).collect();
		}
		if (talent == CURSED_SET && hero.pointsInTalent(CURSED_SET) == 2) {
			CurseInfusion Crinfu = new CurseInfusion();
			Crinfu.quantity(3).collect();
			ScrollOfRemoveCurse Sorc = new ScrollOfRemoveCurse();
			Sorc.quantity(3).collect();
			if (!(Dungeon.hero.belongings.weapon() instanceof KeineBook)) {
				Potion.initColors();
				Scroll.initLabels();
				Ring.initGems();
				Item.updateQuickslot();
			}
			Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION);
			Buff.prolong(hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION*5f);
			ScrollOfUpgrade Healing2 = new ScrollOfUpgrade();
			Healing2.quantity(1).collect();
		}
		if (talent == CURSED_SET && hero.pointsInTalent(CURSED_SET) == 3) {
			CurseInfusion Crinfu = new CurseInfusion();
			Crinfu.quantity(3).collect();
			ScrollOfRemoveCurse Sorc = new ScrollOfRemoveCurse();
			Sorc.quantity(3).collect();
			if (!(Dungeon.hero.belongings.weapon() instanceof KeineBook)) {
				Potion.initColors();
				Scroll.initLabels();
				Ring.initGems();
				Item.updateQuickslot();
			}
			Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION);
			Buff.prolong(hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION*5f);
			ScrollOfUpgrade Healing2 = new ScrollOfUpgrade();
			Healing2.quantity(1).collect();
		}

		if (talent == EMER_UNIDENTIFY && hero.pointsInTalent(EMER_UNIDENTIFY) == 1) {
			if (!(Dungeon.hero.belongings.weapon() instanceof KeineBook)) {
				Potion.initColors();
				Scroll.initLabels();
				Ring.initGems();
				Item.updateQuickslot();
			}
			Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION);
			Buff.prolong(hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION*5f);
		}
		if (talent == EMER_UNIDENTIFY && hero.pointsInTalent(EMER_UNIDENTIFY) == 2) {
			if (!(Dungeon.hero.belongings.weapon() instanceof KeineBook)) {
				Potion.initColors();
				Scroll.initLabels();
				Ring.initGems();
				Item.updateQuickslot();
			}
			Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION);
			Buff.prolong(hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION*5f);
		}

		if (talent == AQUA_FOOD && hero.pointsInTalent(AQUA_FOOD) == 1) {
			ElixirOfAquaticRejuvenation murasa1 = new ElixirOfAquaticRejuvenation();
			murasa1.quantity(6).collect();
			Cucumber Healing211 = new Cucumber();
			Healing211.quantity(5).collect();
			AquaBlast murasa2 = new AquaBlast();
			murasa2.quantity(90).collect();
		}
		if (talent == AQUA_FOOD && hero.pointsInTalent(AQUA_FOOD) == 2) {
			ElixirOfAquaticRejuvenation murasa1 = new ElixirOfAquaticRejuvenation();
			murasa1.quantity(6).collect();
			Cucumber Healing211 = new Cucumber();
			Healing211.quantity(5).collect();
			AquaBlast murasa2 = new AquaBlast();
			murasa2.quantity(90).collect();
		}
		if (talent == AQUA_FOOD && hero.pointsInTalent(AQUA_FOOD) == 3) {
			ElixirOfAquaticRejuvenation murasa1 = new ElixirOfAquaticRejuvenation();
			murasa1.quantity(6).collect();
			Cucumber Healing211 = new Cucumber();
			Healing211.quantity(5).collect();
			AquaBlast murasa2 = new AquaBlast();
			murasa2.quantity(90).collect();
		}

		if (talent == GAIN_AQUA_REGEN && hero.pointsInTalent(GAIN_AQUA_REGEN) == 1) {
			ElixirOfAquaticRejuvenation murasa1 = new ElixirOfAquaticRejuvenation();
			murasa1.quantity(4).collect();
		}
		if (talent == GAIN_AQUA_REGEN && hero.pointsInTalent(GAIN_AQUA_REGEN) == 2) {
			ElixirOfAquaticRejuvenation murasa1 = new ElixirOfAquaticRejuvenation();
			murasa1.quantity(4).collect();
		}

		if (talent == GAIN_MORE_AQUA_REGEN && hero.pointsInTalent(GAIN_MORE_AQUA_REGEN) == 1) {
			ElixirOfAquaticRejuvenation murasa1 = new ElixirOfAquaticRejuvenation();
			murasa1.quantity(6).collect();
		}
		if (talent == GAIN_MORE_AQUA_REGEN && hero.pointsInTalent(GAIN_MORE_AQUA_REGEN) == 2) {
			ElixirOfAquaticRejuvenation murasa1 = new ElixirOfAquaticRejuvenation();
			murasa1.quantity(6).collect();
		}

		if (talent == GAIN_AQUA_BLAST && hero.pointsInTalent(GAIN_AQUA_BLAST) == 1) {
			AquaBlast murasa2 = new AquaBlast();
			murasa2.quantity(30).collect();
		}
		if (talent == GAIN_AQUA_BLAST && hero.pointsInTalent(GAIN_AQUA_BLAST) == 2) {
			AquaBlast murasa2 = new AquaBlast();
			murasa2.quantity(30).collect();
		}

		if (talent == GAIN_MORE_AQUA_BLAST && hero.pointsInTalent(GAIN_MORE_AQUA_BLAST) == 1) {
			AquaBlast murasa2 = new AquaBlast();
			murasa2.quantity(60).collect();
		}
		if (talent == GAIN_MORE_AQUA_BLAST && hero.pointsInTalent(GAIN_MORE_AQUA_BLAST) == 2) {
			AquaBlast murasa2 = new AquaBlast();
			murasa2.quantity(60).collect();
		}

		if (talent == TENSHI_PEACH_GAIN && hero.pointsInTalent(TENSHI_PEACH_GAIN) == 1) {
			TenshiPeach Healing217 = new TenshiPeach();
			Healing217.quantity(3).collect();
		}
		if (talent == TENSHI_PEACH_GAIN && hero.pointsInTalent(TENSHI_PEACH_GAIN) == 2) {
			TenshiPeach Healing217 = new TenshiPeach();
			Healing217.quantity(3).collect();
		}
		if (talent == TENSHI_PEACH_GAIN && hero.pointsInTalent(TENSHI_PEACH_GAIN) == 3) {
			TenshiPeach Healing217 = new TenshiPeach();
			Healing217.quantity(3).collect();
		}

		if (talent == CONTROL_DEATH && hero.pointsInTalent(CONTROL_DEATH) == 1) {
			Ankh live = new Ankh();
			live.collect();
			Buff.prolong( hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION/6f );
		}
		if (talent == CONTROL_DEATH && hero.pointsInTalent(CONTROL_DEATH) == 2) {
			Ankh live = new Ankh();
			live.collect();
			Buff.prolong( hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION/6f );
		}
		if (talent == CONTROL_DEATH && hero.pointsInTalent(CONTROL_DEATH) == 3) {
			Ankh live = new Ankh();
			live.collect();
			Buff.prolong( hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION/6f );
		}


		if (talent == GAIN_RECHARGE && hero.pointsInTalent(GAIN_RECHARGE) == 1){
			ScrollOfRecharging Sor = new ScrollOfRecharging();
			Sor.quantity(4).identify().collect();
		}
		if (talent == GAIN_RECHARGE && hero.pointsInTalent(GAIN_RECHARGE) == 2){
			ScrollOfRecharging Sor = new ScrollOfRecharging();
			Sor.quantity(4).identify().collect();
		}

		if (talent == GAIN_CSD && hero.pointsInTalent(GAIN_CSD) == 1){
			ScrollOfChallenge Sor1 = new ScrollOfChallenge();
			Sor1.quantity(2).identify().collect();
			ScrollOfSirensSong Sor2 = new ScrollOfSirensSong();
			Sor2.quantity(2).identify().collect();
			ScrollOfDread Sor3 = new ScrollOfDread();
			Sor3.quantity(2).identify().collect();
		}
		if (talent == GAIN_CSD && hero.pointsInTalent(GAIN_CSD) == 2){
			ScrollOfChallenge Sor1 = new ScrollOfChallenge();
			Sor1.quantity(2).identify().collect();
			ScrollOfSirensSong Sor2 = new ScrollOfSirensSong();
			Sor2.quantity(2).identify().collect();
			ScrollOfDread Sor3 = new ScrollOfDread();
			Sor3.quantity(2).identify().collect();
		}

		if (talent == GAIN_WAND && hero.pointsInTalent(GAIN_WAND) == 1){
			Generator.Category wand1 = Generator.Category.WAND;
			Wand wand2 = (Wand) Reflection.newInstance(wand1.classes[Random.chances(wand1.probs)]);
			wand2.collect();
		}
		if (talent == GAIN_WAND && hero.pointsInTalent(GAIN_WAND) == 2){
			Generator.Category wand1 = Generator.Category.WAND;
			Wand wand2 = (Wand) Reflection.newInstance(wand1.classes[Random.chances(wand1.probs)]);
			wand2.collect();
		}

		if (talent == POTION_PRESERVE && hero.pointsInTalent(POTION_PRESERVE) == 1){
			Buff.prolong(hero, PotionPreserve.class, PotionPreserve.DURATION*6f);
		}
		if (talent == POTION_PRESERVE && hero.pointsInTalent(POTION_PRESERVE) == 2){
			Buff.prolong(hero, PotionPreserve.class, PotionPreserve.DURATION*6f);
		}

		if (talent == GAIN_POTIONOFHEALING && hero.pointsInTalent(GAIN_POTIONOFHEALING) == 1){
			PotionOfLightHealing Healinglh = new PotionOfLightHealing();
			Healinglh.quantity(2).identify().collect();
		}
		if (talent == GAIN_POTIONOFHEALING && hero.pointsInTalent(GAIN_POTIONOFHEALING) == 2){
			PotionOfLightHealing Healinglh = new PotionOfLightHealing();
			Healinglh.quantity(2).identify().collect();
		}

		if (talent == GAIN_SUNGRASSSEED && hero.pointsInTalent(GAIN_SUNGRASSSEED) == 1){
			Sungrass.Seed Healingseed = new Sungrass.Seed();
			Healingseed.quantity(4).collect();
		}
		if (talent == GAIN_SUNGRASSSEED && hero.pointsInTalent(GAIN_SUNGRASSSEED) == 2){
			Sungrass.Seed Healingseed = new Sungrass.Seed();
			Healingseed.quantity(4).collect();
		}

		if (talent == GAIN_ALCHEMY_ENERGY && hero.pointsInTalent(GAIN_ALCHEMY_ENERGY) == 1){
			Dungeon.energy += 15;
		}
		if (talent == GAIN_ALCHEMY_ENERGY && hero.pointsInTalent(GAIN_ALCHEMY_ENERGY) == 2) {
			Dungeon.energy += 15;
		}

		if (talent == THIEFS_INTUITION && hero.pointsInTalent(THIEFS_INTUITION) == 2){
			if (hero.belongings.ring instanceof Ring) hero.belongings.ring.identify();
			if (hero.belongings.misc instanceof Ring) hero.belongings.misc.identify();
			for (Item item : Dungeon.hero.belongings){
				if (item instanceof Ring){
					((Ring) item).setKnown();
				}
			}
		}

		if (talent == THIEFS_INTUITION && hero.pointsInTalent(THIEFS_INTUITION) == 1){
			if (hero.belongings.ring instanceof Ring) hero.belongings.ring.setKnown();
			if (hero.belongings.misc instanceof Ring) ((Ring) hero.belongings.misc).setKnown();
		}

		if (talent == LIGHT_CLOAK && hero.pointsInTalent(LIGHT_CLOAK) == 1){
			for (Item item : Dungeon.hero.belongings.backpack){
				if (item instanceof CloakOfShadows){
					if (hero.buff(LostInventory.class) == null || item.keptThoughLostInvent) {
						((CloakOfShadows) item).activate(Dungeon.hero);
					}
				}
			}
		}

		if (talent == HEIGHTENED_SENSES || talent == FARSIGHT){
			Dungeon.observe();
		}
	}

	public static class CachedRationsDropped extends CounterBuff{{revivePersists = true;}};
	public static class NatureBerriesAvailable extends CounterBuff{{revivePersists = true;}};

	public static void onFoodEaten( Hero hero, float foodVal, Item foodSource ){
		if (hero.hasTalent(HEARTY_MEAL)){
			//3/5 HP healed, when hero is below 25% health
			if (hero.HP <= hero.HT/4) {
				hero.HP = Math.min(hero.HP + 1 + 2 * hero.pointsInTalent(HEARTY_MEAL), hero.HT);
				hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1+hero.pointsInTalent(HEARTY_MEAL));
				//2/3 HP healed, when hero is below 50% health
			} else if (hero.HP <= hero.HT/2){
				hero.HP = Math.min(hero.HP + 1 + hero.pointsInTalent(HEARTY_MEAL), hero.HT);
				hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), hero.pointsInTalent(HEARTY_MEAL));
			}
		}
		if (hero.hasTalent(EIENTEI_MEAL)) {
			//3/5 HP healed, when hero is below 25% health
			if (hero.HP <= hero.HT / 2) {
				Buff.prolong( hero, Hex.class, Hex.DURATION );
				hero.HP = Math.min(hero.HP + 3 + 5 * hero.pointsInTalent(EIENTEI_MEAL), hero.HT);
				hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), hero.pointsInTalent(EIENTEI_MEAL));
			}
		}

		if (hero.hasTalent(EIENTEI_ENHANCE_MEAL)) {
			if (hero.HP <= hero.HT / 2) {
				Buff.prolong( hero, Hex.class, Hex.DURATION );
				hero.HP = Math.min(hero.HP + 8 + 4 * hero.pointsInTalent(EIENTEI_ENHANCE_MEAL), hero.HT);
				hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), hero.pointsInTalent(EIENTEI_ENHANCE_MEAL));
			}
		}

		if (hero.hasTalent(EXHAUSTIVE_FOOD)) {
			hero.HP = Math.min(hero.HP + 5 + 10 * hero.pointsInTalent(EXHAUSTIVE_FOOD), hero.HT);
			hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), hero.pointsInTalent(EXHAUSTIVE_FOOD));
		}

		if (hero.hasTalent(Talent.QUICK_MEAL) && hero.pointsInTalent(Talent.QUICK_MEAL)==2){
			Buff.prolong(hero, Haste.class, Haste.DURATION / 4f);
		}

		if (hero.hasTalent(CUCUMBER_HEAL) && foodSource instanceof Cucumber) {
			hero.HP = Math.min(hero.HP + 10 + 5 * hero.pointsInTalent(CUCUMBER_HEAL), hero.HT);
			hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), hero.pointsInTalent(CUCUMBER_HEAL));
			if (Random.Int(2) == 0)
				Buff.prolong( hero, Blindness.class, Blindness.DURATION );
		}

		if (hero.hasTalent(KAPPA_MEAL)) {
			Buff.prolong( hero, Stamina.class, Stamina.DURATION/10f );
			hero.HP = Math.min(hero.HP + 4 + 5 * hero.pointsInTalent(KAPPA_MEAL), hero.HT);
			hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), hero.pointsInTalent(KAPPA_MEAL));
			if (Random.Int(2) == 0)
				Buff.prolong( hero, Hex.class, Hex.DURATION );
		}

		if (hero.hasTalent(KAPPA_ENHANCE_MEAL)) {
			Buff.prolong( hero, Stamina.class, Stamina.DURATION/10f );
			hero.HP = Math.min(hero.HP + 9 + 6 * hero.pointsInTalent(KAPPA_ENHANCE_MEAL), hero.HT);
			hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), hero.pointsInTalent(KAPPA_ENHANCE_MEAL));
			if (Random.Int(2) == 0)
				Buff.prolong( hero, Hex.class, Hex.DURATION );
		}


		if (hero.hasTalent(CURSED_MEAL)) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					hero.HP = Math.min(hero.HP + 10 + 5 * hero.pointsInTalent(CURSED_MEAL), hero.HT);
					hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), hero.pointsInTalent(CURSED_MEAL));
				}
			}
		}

		if (hero.hasTalent(CURSED_EXTRA_MEAL)) {
			for (Item item : Dungeon.hero.belongings) {
				if (item.cursed) {
					hero.HP = Math.min(hero.HP + 20 + 10 * hero.pointsInTalent(CURSED_EXTRA_MEAL), hero.HT);
					hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), hero.pointsInTalent(CURSED_EXTRA_MEAL));
				}
			}
		}

		if (hero.hasTalent(CUCUMBER_MEAL)) {
			if (Random.Int(10-hero.pointsInTalent(CUCUMBER_MEAL)-2) == 0) {
				Cucumber Healing211 = new Cucumber();
				Healing211.quantity(1).collect();
			}
		}

		if (hero.hasTalent(DANGEROUS_MEAL)) {
			Buff.prolong( hero, Triplespeed.class, Triplespeed.DURATION/2f );
			Buff.prolong( hero, Bless.class, Bless.DURATION );
			if (Random.Int(3+hero.pointsInTalent(DANGEROUS_MEAL)-2) == 0)
				Buff.prolong( hero, Weakness.class, Weakness.DURATION );
			Buff.prolong( hero, Vulnerable.class, Vulnerable.DURATION );
			Buff.prolong( hero, Hex.class, Hex.DURATION );
		}

		if (hero.hasTalent(TRIPLESPEED_MEAL) && hero.pointsInTalent(TRIPLESPEED_MEAL) == 1) {
			Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION / 2f);
		}

		if (hero.hasTalent(TRIPLESPEED_MEAL) && hero.pointsInTalent(TRIPLESPEED_MEAL) == 2) {
			Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION);
		}

		if (hero.hasTalent(TRIPLESPEED_MEAL) && hero.pointsInTalent(TRIPLESPEED_MEAL) == 3) {
			Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION);
			Buff.prolong(hero, Bless.class, Bless.DURATION/2f);
		}

		if (hero.hasTalent(MIND_VISION_MEAL) && hero.pointsInTalent(MIND_VISION_MEAL) == 1) {
			Buff.prolong(hero, MindVision.class, MindVision.DURATION / 2f);
		}

		if (hero.hasTalent(MIND_VISION_MEAL) && hero.pointsInTalent(MIND_VISION_MEAL) == 2) {
			Buff.prolong(hero, MindVision.class, MindVision.DURATION);
		}

		if (hero.hasTalent(MIND_VISION_MEAL) && hero.pointsInTalent(MIND_VISION_MEAL) == 3) {
			Buff.prolong(hero, MindVision.class, MindVision.DURATION);
			Buff.prolong(hero, Light.class, Light.DURATION/5f);
		}

		if (hero.hasTalent(MAGIC_IMMUNE_MEAL) && hero.pointsInTalent(MAGIC_IMMUNE_MEAL) == 1) {
			Buff.prolong(hero, MagicImmune.class, MagicImmune.DURATION / 2f);
		}

		if (hero.hasTalent(MAGIC_IMMUNE_MEAL) && hero.pointsInTalent(MAGIC_IMMUNE_MEAL) == 2) {
			Buff.prolong(hero, MagicImmune.class, MagicImmune.DURATION);
		}

		if (hero.hasTalent(MAGIC_IMMUNE_MEAL) && hero.pointsInTalent(MAGIC_IMMUNE_MEAL) == 3) {
			Buff.prolong(hero, MagicImmune.class, MagicImmune.DURATION);
			Buff.prolong(hero, Might.class, Might.DURATION);
		}

		if (hero.hasTalent(IRON_STOMACH)){
			if (hero.cooldown() > 0) {
				Buff.affect(hero, WarriorFoodImmunity.class, hero.cooldown());
			}
		}
		if (hero.hasTalent(EMPOWERING_MEAL)){
			Buff.affect( hero, WandEmpower.class).set(1 + hero.pointsInTalent(EMPOWERING_MEAL), 3);
			ScrollOfRecharging.charge( hero );
		}
		if (hero.hasTalent(ENERGIZING_MEAL)){
			//5/8 turns of recharging
			Buff.prolong( hero, Recharging.class, 2 + 3*(hero.pointsInTalent(ENERGIZING_MEAL)) );
			ScrollOfRecharging.charge( hero );
		}
		if (hero.hasTalent(MYSTICAL_MEAL)){
			//3/5 turns of recharging
			Buff.affect( hero, ArtifactRecharge.class).set(1 + 2*(hero.pointsInTalent(MYSTICAL_MEAL))).ignoreHornOfPlenty = foodSource instanceof HornOfPlenty;
			ScrollOfRecharging.charge( hero );
		}
		if (hero.hasTalent(INVIGORATING_MEAL)){
			//effectively 1/2 turns of haste
			Buff.prolong( hero, Haste.class, 0.67f+hero.pointsInTalent(INVIGORATING_MEAL));
		}
	}

	public static class WarriorFoodImmunity extends FlavourBuff{
		{ actPriority = HERO_PRIO+1; }
	}

	public static float itemIDSpeedFactor( Hero hero, Item item ){
		// 1.75x/2.5x speed with huntress talent
		float factor = 1f + hero.pointsInTalent(SURVIVALISTS_INTUITION)*0.75f;

		// 2x/instant for Warrior (see onItemEquipped)
		if (item instanceof MeleeWeapon || item instanceof Armor){
			factor *= 1f + hero.pointsInTalent(ARMSMASTERS_INTUITION);
		}
		// 3x/instant for mage (see Wand.wandUsed())
		if (item instanceof Wand){
			factor *= 1f + 2*hero.pointsInTalent(SCHOLARS_INTUITION);
		}
		// 2x/instant for rogue (see onItemEqupped), also id's type on equip/on pickup
		if (item instanceof Ring){
			factor *= 1f + hero.pointsInTalent(THIEFS_INTUITION);
		}
		return factor;
	}

	public static void onHealingPotionUsed( Hero hero ){
		if (hero.hasTalent(RESTORED_WILLPOWER)){
			BrokenSeal.WarriorShield shield = hero.buff(BrokenSeal.WarriorShield.class);
			if (shield != null){
				int shieldToGive = Math.round(shield.maxShield() * 0.33f*(1+hero.pointsInTalent(RESTORED_WILLPOWER)));
				shield.supercharge(shieldToGive);
			}
		}
		if (hero.hasTalent(RESTORED_NATURE)){
			ArrayList<Integer> grassCells = new ArrayList<>();
			for (int i : PathFinder.NEIGHBOURS8){
				grassCells.add(hero.pos+i);
			}
			Random.shuffle(grassCells);
			for (int cell : grassCells){
				Char ch = Actor.findChar(cell);
				if (ch != null && ch.alignment == Char.Alignment.ENEMY){
					Buff.affect(ch, Roots.class, 1f + hero.pointsInTalent(RESTORED_NATURE));
				}
				if (Dungeon.level.map[cell] == Terrain.EMPTY ||
						Dungeon.level.map[cell] == Terrain.EMBERS ||
						Dungeon.level.map[cell] == Terrain.EMPTY_DECO){
					Level.set(cell, Terrain.GRASS);
					GameScene.updateMap(cell);
				}
				CellEmitter.get(cell).burst(LeafParticle.LEVEL_SPECIFIC, 4);
			}
			if (hero.pointsInTalent(RESTORED_NATURE) == 1){
				grassCells.remove(0);
				grassCells.remove(0);
				grassCells.remove(0);
			}
			for (int cell : grassCells){
				int t = Dungeon.level.map[cell];
				if ((t == Terrain.EMPTY || t == Terrain.EMPTY_DECO || t == Terrain.EMBERS
						|| t == Terrain.GRASS || t == Terrain.FURROWED_GRASS)
						&& Dungeon.level.plants.get(cell) == null){
					Level.set(cell, Terrain.HIGH_GRASS);
					GameScene.updateMap(cell);
				}
			}
			Dungeon.observe();
		}
	}

	public static void onUpgradeScrollUsed( Hero hero ){
		if (hero.hasTalent(ENERGIZING_UPGRADE)){
			MagesStaff staff = hero.belongings.getItem(MagesStaff.class);
			if (staff != null){
				staff.gainCharge(1 + 2*hero.pointsInTalent(ENERGIZING_UPGRADE), true);
				ScrollOfRecharging.charge( Dungeon.hero );
				SpellSprite.show( hero, SpellSprite.CHARGE );
			}
		}

		if (hero.hasTalent(AQUA_UPGRADE)) {
			Cucumber Healing211 = new Cucumber();
			Healing211.quantity(1).collect();
			if (Random.Int(4+hero.pointsInTalent(AQUA_UPGRADE)-2) == 0)
				Buff.affect( hero, Bleeding.class ).set( 9-hero.pointsInTalent(AQUA_UPGRADE));
		}

		if (hero.hasTalent(RISKY_UPGRADE)) {
			Cucumber Healing211 = new Cucumber();
			Healing211.quantity(1).collect();
			if (Random.Int(5+hero.pointsInTalent(AQUA_UPGRADE)*2-2) == 0)
				Buff.prolong( hero, Degrade.class, Degrade.DURATION );
			Buff.prolong( hero, Roots.class, Roots.DURATION );
		}

		if (hero.hasTalent(MYSTICAL_UPGRADE)){
			CloakOfShadows cloak = hero.belongings.getItem(CloakOfShadows.class);
			if (cloak != null){
				cloak.overCharge(1 + hero.pointsInTalent(MYSTICAL_UPGRADE));
				ScrollOfRecharging.charge( Dungeon.hero );
				SpellSprite.show( hero, SpellSprite.CHARGE );
			}
		}
	}

	public static void onArtifactUsed( Hero hero ){
		if (hero.hasTalent(ENHANCED_RINGS)){
			Buff.prolong(hero, EnhancedRings.class, 3f*hero.pointsInTalent(ENHANCED_RINGS));
		}
	}

	public static void onItemEquipped( Hero hero, Item item ){
		if (hero.pointsInTalent(ARMSMASTERS_INTUITION) == 2 && (item instanceof Weapon || item instanceof Armor)){
			item.identify();
		}
		if (hero.hasTalent(THIEFS_INTUITION) && item instanceof Ring){
			if (hero.pointsInTalent(THIEFS_INTUITION) == 2){
				item.identify();
			} else {
				((Ring) item).setKnown();
			}
		}
	}

	public static void onItemCollected( Hero hero, Item item ){
		if (hero.pointsInTalent(THIEFS_INTUITION) == 2){
			if (item instanceof Ring) ((Ring) item).setKnown();
		}
	}

	//note that IDing can happen in alchemy scene, so be careful with VFX here
	public static void onItemIdentified( Hero hero, Item item ){
		if (hero.hasTalent(TEST_SUBJECT)){
			//heal for 2/3 HP
			hero.HP = Math.min(hero.HP + 1 + hero.pointsInTalent(TEST_SUBJECT), hero.HT);
			Emitter e = hero.sprite.emitter();
			if (e != null) e.burst(Speck.factory(Speck.HEALING), hero.pointsInTalent(TEST_SUBJECT));
		}
		if (hero.hasTalent(INVU_IDENTIFY)){
			Buff.affect(hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION/3f);
		}
		if (hero.pointsInTalent(INVU_IDENTIFY) == 2){
			Buff.affect(hero, Haste.class, Haste.DURATION/10f);
		}

		if (hero.hasTalent(CURSED_IDENTIFY)) {
			hero.HP = Math.min(hero.HP + 5 + 10 * hero.pointsInTalent(CURSED_IDENTIFY), hero.HT);
			Buff.prolong(hero, Slow.class, Slow.DURATION);
		}

		if (hero.hasTalent(RISKY_IDENTIFY)){
			Buff.affect(hero, Doublespeed.class, Doublespeed.DURATION/5f);
			if (Random.Int(2) == 0)
				Buff.affect(hero, Roots.class, Roots.DURATION);
		}
		if (hero.pointsInTalent(RISKY_IDENTIFY) == 2){
			Buff.affect(hero, Haste.class, Haste.DURATION/4f);
		}

		if (hero.hasTalent(TESTED_HYPOTHESIS)){
			//2/3 turns of wand recharging
			Buff.affect(hero, Recharging.class, 1f + hero.pointsInTalent(TESTED_HYPOTHESIS));
			ScrollOfRecharging.charge(hero);
		}
	}

	public static int onAttackProc( Hero hero, Char enemy, int dmg ) {
		if (hero.hasTalent(Talent.SUCKER_PUNCH)
				&& enemy instanceof Mob && ((Mob) enemy).surprisedBy(hero)
				&& enemy.buff(SuckerPunchTracker.class) == null) {
			dmg += Random.IntRange(hero.pointsInTalent(Talent.SUCKER_PUNCH), 2);
			Buff.affect(enemy, SuckerPunchTracker.class);
		}

		if (hero.hasTalent(Talent.DANMAKU_HEAL) && Dungeon.hero.belongings.weapon() instanceof MissileWeapon) {
			hero.HP = Math.min(hero.HP + 3 * hero.pointsInTalent(DANMAKU_HEAL), hero.HT);
			hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
		}
		if (hero.hasTalent(Talent.DANMAKU_BLESS) && Dungeon.hero.belongings.weapon() instanceof MissileWeapon) {
			Buff.prolong(hero, Bless.class, hero.pointsInTalent(DANMAKU_HEAL) * Bless.DURATION / 10f);
		}
		if (hero.hasTalent(Talent.DANMAKU_SPEED) && Dungeon.hero.belongings.weapon() instanceof MissileWeapon) {
			Buff.prolong(hero, Doublespeed.class, hero.pointsInTalent(DANMAKU_HEAL) * Doublespeed.DURATION / 10f);
		}

		if (hero.hasTalent(Talent.FOLLOWUP_STRIKE)) {
			if (hero.belongings.weapon() instanceof MissileWeapon) {
				Buff.affect(enemy, FollowupStrikeTracker.class);
			} else if (enemy.buff(FollowupStrikeTracker.class) != null) {
				dmg += 1 + hero.pointsInTalent(FOLLOWUP_STRIKE);
				if (!(enemy instanceof Mob) || !((Mob) enemy).surprisedBy(hero)) {
					Sample.INSTANCE.play(Assets.Sounds.HIT_STRONG, 0.75f, 1.2f);
				}
				enemy.buff(FollowupStrikeTracker.class).detach();
			}
		}

		if (hero.hasTalent(Talent.DANMAKU_STRIKE)) {
			if (hero.belongings.weapon() instanceof MissileWeapon)
				dmg += 1 + 2 * hero.pointsInTalent(DANMAKU_STRIKE);
		}
		if (hero.hasTalent(Talent.DANMAKU_ENHANCE_STRIKE)) {
			if (hero.belongings.weapon() instanceof MissileWeapon)
				dmg += 5 + 2 * hero.pointsInTalent(DANMAKU_ENHANCE_STRIKE);
		}

		if (hero.hasTalent(Talent.AQUA_STRIKE) && Dungeon.level.water[enemy.pos]) {
			dmg += 3 + 2 * hero.pointsInTalent(AQUA_STRIKE);
		}

		return dmg;
	}

	public static class SuckerPunchTracker extends Buff{};
	public static class FollowupStrikeTracker extends Buff{};

	public static final int MAX_TALENT_TIERS = 4;

	public static void initClassTalents( Hero hero ){
		initClassTalents( hero.heroClass, hero.talents, hero.metamorphedTalents );
	}

	public static void initClassTalents( HeroClass cls, ArrayList<LinkedHashMap<Talent, Integer>> talents){
		initClassTalents( cls, talents, new LinkedHashMap<>());
	}

	public static void initClassTalents( HeroClass cls, ArrayList<LinkedHashMap<Talent, Integer>> talents, LinkedHashMap<Talent, Talent> replacements ) {
		while (talents.size() < MAX_TALENT_TIERS) {
			talents.add(new LinkedHashMap<>());
		}

		ArrayList<Talent> tierTalents = new ArrayList<>();

		//tier 1
		switch (cls) {
			case WARRIOR:
			default:
				Collections.addAll(tierTalents, HEARTY_MEAL, ARMSMASTERS_INTUITION, TEST_SUBJECT, IRON_WILL);
				break;
			case MAGE:
				Collections.addAll(tierTalents, EMPOWERING_MEAL, SCHOLARS_INTUITION, TESTED_HYPOTHESIS, BACKUP_BARRIER);
				break;
			case ROGUE:
				Collections.addAll(tierTalents, CACHED_RATIONS, THIEFS_INTUITION, SUCKER_PUNCH, PROTECTIVE_SHADOWS);
				break;
			case HUNTRESS:
				Collections.addAll(tierTalents, NATURES_BOUNTY, SURVIVALISTS_INTUITION, FOLLOWUP_STRIKE, NATURES_AID);
				break;
			case REISEN:
				Collections.addAll(tierTalents, EIENTEI_MEAL, POTION_INTUITION, DANMAKU_STRIKE, EIENTEI_LUCK);
				break;
			case NITORI:
				Collections.addAll(tierTalents, KAPPA_MEAL, SCROLL_INTUITION, CUCUMBER_HEAL, BASIC_FUSION);
				break;
			case YUYUKO:
				Collections.addAll(tierTalents, ANIMAL_MEAL, PASTY_GAIN, CUCUMBER_GAIN, FROZEN_FOOD_GAIN);
				break;
			case MURASA:
				Collections.addAll(tierTalents, GAIN_AQUA_REGEN, GAIN_AQUA_BLAST, AQUA_STRIKE, AQUA_LIGHT);
				break;
			case HINAPLAYER:
				Collections.addAll(tierTalents, CURSED_MEAL, GAIN_CURSED_METAL, CURSED_IDENTIFY, CURSED_MINDVISION);
				break;
			case KAGUYAPLAYER:
				Collections.addAll(tierTalents, GAIN_ALCHEMY_ENERGY, GAIN_RECHARGE, GAIN_CSD, GAIN_WAND);
				break;
		}
		for (Talent talent : tierTalents) {
			talents.get(0).put(talent, 0);
		}
		tierTalents.clear();

		//tier 2
		switch (cls) {
			case WARRIOR:
			default:
				Collections.addAll(tierTalents, IRON_STOMACH, RESTORED_WILLPOWER, RUNIC_TRANSFERENCE, LETHAL_MOMENTUM, IMPROVISED_PROJECTILES);
				break;
			case MAGE:
				Collections.addAll(tierTalents, ENERGIZING_MEAL, ENERGIZING_UPGRADE, WAND_PRESERVATION, ARCANE_VISION, SHIELD_BATTERY);
				break;
			case ROGUE:
				Collections.addAll(tierTalents, MYSTICAL_MEAL, MYSTICAL_UPGRADE, WIDE_SEARCH, SILENT_STEPS, ROGUES_FORESIGHT);
				break;
			case HUNTRESS:
				Collections.addAll(tierTalents, INVIGORATING_MEAL, RESTORED_NATURE, REJUVENATING_STEPS, HEIGHTENED_SENSES, DURABLE_PROJECTILES);
				break;
			case REISEN:
				Collections.addAll(tierTalents, EIENTEI_ENHANCE_MEAL, GAINING_HEALING, DANMAKU_ENHANCE_STRIKE, EIENTEI_ENHANCED_LUCK, INVU_IDENTIFY);
				break;
			case NITORI:
				Collections.addAll(tierTalents, KAPPA_ENHANCE_MEAL, RISKY_IDENTIFY, FEW_CUCUMBER, MEDIUM_FUSION, ADVANCED_FUSION);
				break;
			case YUYUKO:
				Collections.addAll(tierTalents, ANIMAL_ENHANCED_MEAL, QUICK_MEAL, MORE_FOOD_PANCAKE, MORE_FOOD_WAFFLE, MORE_FOOD_FRUIT);
				break;
			case MURASA:
				Collections.addAll(tierTalents, GAIN_MORE_AQUA_REGEN, GAIN_MORE_AQUA_BLAST, EXHAUSTIVE_FOOD, GHOST_TENSITY, AQUA_BLESS);
				break;
			case HINAPLAYER:
				Collections.addAll(tierTalents, CURSED_EXTRA_MEAL, GAIN_METAL_AND_REMOVE, EMER_UNIDENTIFY, CURSED_HASTE, CURSED_INVU);
				break;
			case KAGUYAPLAYER:
				Collections.addAll(tierTalents, HEALWAND_SILENCE, UPGRADE_MAXHT_UP, POTION_PRESERVE, GAIN_POTIONOFHEALING, GAIN_SUNGRASSSEED);
				break;
		}
		for (Talent talent : tierTalents) {
			talents.get(1).put(talent, 0);
		}
		tierTalents.clear();

		//tier 3
		switch (cls) {
			case WARRIOR:
			default:
				Collections.addAll(tierTalents, HOLD_FAST, STRONGMAN);
				break;
			case MAGE:
				Collections.addAll(tierTalents, EMPOWERING_SCROLLS, ALLY_WARP);
				break;
			case ROGUE:
				Collections.addAll(tierTalents, ENHANCED_RINGS, LIGHT_CLOAK);
				break;
			case HUNTRESS:
				Collections.addAll(tierTalents, POINT_BLANK, SEER_SHOT);
				break;
			case REISEN:
				Collections.addAll(tierTalents, SIMPLE_POWER, INVU_POWER);
				break;
			case NITORI:
				Collections.addAll(tierTalents, GAINING_CUCUMBER, GAINING_TRANSMUTE);
				break;
			case YUYUKO:
				Collections.addAll(tierTalents, EVERYONE_IS_MEAL, TENSHI_PEACH_GAIN);
				break;
			case MURASA:
				Collections.addAll(tierTalents, AQUA_FOOD, MORE_GHOST_TENSITY);
				break;
			case HINAPLAYER:
				Collections.addAll(tierTalents, CURSED_SET, CURSED_PRESERVE);
				break;
			case KAGUYAPLAYER:
				Collections.addAll(tierTalents, HEALWAND_SIMPLE, MAXHT_UP);
				break;
		}
		for (Talent talent : tierTalents) {
			talents.get(2).put(talent, 0);
		}
		tierTalents.clear();
	}

	public static void initSubclassTalents( Hero hero ){
		initSubclassTalents( hero.subClass, hero.talents );
	}

	public static void initSubclassTalents(com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass cls, ArrayList<LinkedHashMap<Talent, Integer>> talents ){
		if (cls == com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass.NONE) return;

		while (talents.size() < MAX_TALENT_TIERS){
			talents.add(new LinkedHashMap<>());
		}

		ArrayList<Talent> tierTalents = new ArrayList<>();

		//tier 3
		switch (cls){
			case BERSERKER: default:
				Collections.addAll(tierTalents, ENDLESS_RAGE, BERSERKING_STAMINA, ENRAGED_CATALYST);
				break;
			case GLADIATOR:
				Collections.addAll(tierTalents, CLEAVE, LETHAL_DEFENSE, ENHANCED_COMBO);
				break;
			case BATTLEMAGE:
				Collections.addAll(tierTalents, EMPOWERED_STRIKE, MYSTICAL_CHARGE, EXCESS_CHARGE);
				break;
			case WARLOCK:
				Collections.addAll(tierTalents, SOUL_EATER, SOUL_SIPHON, NECROMANCERS_MINIONS);
				break;
			case MOONRABBIT:
				Collections.addAll(tierTalents, PARA_RESISTANCE, GAS_RESISTANCE, DEGRADE_RESISTANCE);
				break;
			case KAPPA:
				Collections.addAll(tierTalents, CUCUMBER_MEAL, AQUA_UPGRADE, AQUA_POTION);
				break;
			case GOURMET:
				Collections.addAll(tierTalents, TRIPLESPEED_MEAL, MIND_VISION_MEAL, MAGIC_IMMUNE_MEAL);
				break;
			case CAPTAIN:
				Collections.addAll(tierTalents, AQUA_STAMINA, AQUA_HASTE, AQUA_MINDVISION);
				break;
			case SPINGOD:
				Collections.addAll(tierTalents, SPIN_BLIND, SPIN_HEX, SPIN_HEAL);
				break;
			case TIMESTOP:
				Collections.addAll(tierTalents, HEALWAND_MV_AND_LEV, HEALWAND_LIGHT_AND_BLESS, HEALWAND_THREESPEED);
				break;
			case ASSASSIN:
				Collections.addAll(tierTalents, ENHANCED_LETHALITY, ASSASSINS_REACH, BOUNTY_HUNTER);
				break;
			case FREERUNNER:
				Collections.addAll(tierTalents, EVASIVE_ARMOR, PROJECTILE_MOMENTUM, SPEEDY_STEALTH);
				break;
			case SNIPER:
				Collections.addAll(tierTalents, FARSIGHT, SHARED_ENCHANTMENT, SHARED_UPGRADES);
				break;
			case WARDEN:
				Collections.addAll(tierTalents, DURABLE_TIPS, BARKSKIN, SHIELDING_DEW);
				break;
			case DESERTER:
				Collections.addAll(tierTalents, DANMAKU_HEAL, DANMAKU_BLESS, DANMAKU_SPEED);
				break;
			case ENGINEER:
				Collections.addAll(tierTalents, DANGEROUS_MEAL, RISKY_UPGRADE, RISKY_POTION);
				break;
			case DEATHGHOST:
				Collections.addAll(tierTalents, CONTROL_DEATH, DOOM_ATTACK, COMING_DEATH);
				break;
			case SHIPGHOST:
				Collections.addAll(tierTalents, AQUA_PARALYSIS, AQUA_SLOW, AQUA_INSTAKILL);
				break;
			case CURSEGOD:
				Collections.addAll(tierTalents, CURSED_SNEAKATTACK, CURSED_INVISIBILITY, CURSED_ACC);
				break;
			case TIMEMOVE:
				Collections.addAll(tierTalents, MAXHP_SPEED, MAXHP_EVASION, MAXHP_ACC);
				break;
		}
		for (Talent talent : tierTalents){
			talents.get(2).put(talent, 0);
		}
		tierTalents.clear();

	}

	private static final String TALENT_TIER = "talents_tier_";

	public static void storeTalentsInBundle( Bundle bundle, Hero hero ){
		for (int i = 0; i < MAX_TALENT_TIERS; i++){
			LinkedHashMap<Talent, Integer> tier = hero.talents.get(i);
			Bundle tierBundle = new Bundle();

			for (Talent talent : tier.keySet()){
				if (tier.get(talent) > 0){
					tierBundle.put(talent.name(), tier.get(talent));
				}
				if (tierBundle.contains(talent.name())){
					tier.put(talent, Math.min(tierBundle.getInt(talent.name()), talent.maxPoints()));
				}
			}
			bundle.put(TALENT_TIER+(i+1), tierBundle);
		}

		Bundle replacementsBundle = new Bundle();
		for (Talent t : hero.metamorphedTalents.keySet()){
			replacementsBundle.put(t.name(), hero.metamorphedTalents.get(t));
		}
		bundle.put("replacements", replacementsBundle);
	}

	public static void restoreTalentsFromBundle( Bundle bundle, Hero hero ){
		//TODO restore replacements
		if (bundle.contains("replacements")){
			Bundle replacements = bundle.getBundle("replacements");
			for (String key : replacements.getKeys()){
				hero.metamorphedTalents.put(Talent.valueOf(key), replacements.getEnum(key, Talent.class));
			}
		}

		if (hero.heroClass != null)     initClassTalents(hero);
		if (hero.subClass != null)      initSubclassTalents(hero);

		for (int i = 0; i < MAX_TALENT_TIERS; i++){
			LinkedHashMap<Talent, Integer> tier = hero.talents.get(i);
			Bundle tierBundle = bundle.contains(TALENT_TIER+(i+1)) ? bundle.getBundle(TALENT_TIER+(i+1)) : null;
			//pre-0.9.1 saves
			if (tierBundle == null && i == 0 && bundle.contains("talents")){
				tierBundle = bundle.getBundle("talents");
			}

			if (tierBundle != null){
				for (Talent talent : tier.keySet()){
					if (tierBundle.contains(talent.name())){
						tier.put(talent, Math.min(tierBundle.getInt(talent.name()), talent.maxPoints()));
					}
				}
			}
		}
	}

}