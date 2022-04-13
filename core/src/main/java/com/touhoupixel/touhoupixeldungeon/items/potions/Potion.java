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

package com.touhoupixel.touhoupixeldungeon.items.potions;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Badges;
import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.Fire;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiHeal;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank1;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank2;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank3;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Burning;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Chill;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Degrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FireBrandBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FrostBrandBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hunger;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Invisibility;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.NoPotion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Ooze;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.PotionPreserve;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Stamina;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SuperDegrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SuperOoze;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.WandZeroDamage;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.effects.Splash;
import com.touhoupixel.touhoupixeldungeon.items.EquipableItem;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.ItemStatusHandler;
import com.touhoupixel.touhoupixeldungeon.items.Recipe;
import com.touhoupixel.touhoupixeldungeon.items.bags.Bag;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfHoneyedHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.ExoticPotion;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfCleansing;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfCorrosiveGas;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfShroudingFog;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfSnapFreeze;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfStormClouds;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FireBrand;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FrostBrand;
import com.touhoupixel.touhoupixeldungeon.journal.Catalog;
import com.touhoupixel.touhoupixeldungeon.levels.Terrain;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
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
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.touhoupixel.touhoupixeldungeon.windows.WndBag;
import com.touhoupixel.touhoupixeldungeon.windows.WndOptions;
import com.touhoupixel.touhoupixeldungeon.windows.WndUseItem;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Potion extends Item {

	public static final String AC_DRINK = "DRINK";

	//used internally for potions that can be drunk or thrown
	public static final String AC_CHOOSE = "CHOOSE";

	private static final float TIME_TO_DRINK = 1f;

	private static final HashMap<String, Integer> colors = new HashMap<String, Integer>() {
		{
			put("crimson",ItemSpriteSheet.POTION_CRIMSON);
			put("amber",ItemSpriteSheet.POTION_AMBER);
			put("golden",ItemSpriteSheet.POTION_GOLDEN);
			put("jade",ItemSpriteSheet.POTION_JADE);
			put("turquoise",ItemSpriteSheet.POTION_TURQUOISE);
			put("azure",ItemSpriteSheet.POTION_AZURE);
			put("indigo",ItemSpriteSheet.POTION_INDIGO);
			put("magenta",ItemSpriteSheet.POTION_MAGENTA);
			put("bistre",ItemSpriteSheet.POTION_BISTRE);
			put("charcoal",ItemSpriteSheet.POTION_CHARCOAL);
			put("silver",ItemSpriteSheet.POTION_SILVER);
			put("ivory",ItemSpriteSheet.POTION_IVORY);
			put("pink",ItemSpriteSheet.POTION_PINK);
			put("green",ItemSpriteSheet.POTION_GREEN);
			put("yellow",ItemSpriteSheet.POTION_YELLOW);
			put("spectral",ItemSpriteSheet.POTION_SPECTRAL);
		}
	};

	private static final HashSet<Class<?extends Potion>> mustThrowPots = new HashSet<>();
	static{
		mustThrowPots.add(PotionOfToxicGas.class);
		mustThrowPots.add(PotionOfLiquidFlame.class);
		mustThrowPots.add(PotionOfParalyticGas.class);
		mustThrowPots.add(PotionOfFrost.class);

		//exotic
		mustThrowPots.add(PotionOfCorrosiveGas.class);
		mustThrowPots.add(PotionOfSnapFreeze.class);
		mustThrowPots.add(PotionOfShroudingFog.class);
		mustThrowPots.add(PotionOfStormClouds.class);

		//also all brews, hardcoded
	}

	private static final HashSet<Class<?extends Potion>> canThrowPots = new HashSet<>();
	static{
		canThrowPots.add(AlchemicalCatalyst.class);

		canThrowPots.add(PotionOfPurity.class);
		canThrowPots.add(PotionOfLevitation.class);

		//exotic
		canThrowPots.add(PotionOfCleansing.class);

		//elixirs
		canThrowPots.add(ElixirOfHoneyedHealing.class);
	}

	protected static ItemStatusHandler<Potion> handler;

	protected String color;

	{
		stackable = true;
		defaultAction = AC_DRINK;
	}

	@SuppressWarnings("unchecked")
	public static void initColors() {
		handler = new ItemStatusHandler<>( (Class<? extends Potion>[])Generator.Category.POTION.classes, colors );
	}

	public static void save( Bundle bundle ) {
		handler.save( bundle );
	}

	public static void saveSelectively( Bundle bundle, ArrayList<Item> items ) {
		ArrayList<Class<?extends Item>> classes = new ArrayList<>();
		for (Item i : items){
			if (i instanceof ExoticPotion){
				if (!classes.contains(ExoticPotion.exoToReg.get(i.getClass()))){
					classes.add(ExoticPotion.exoToReg.get(i.getClass()));
				}
			} else if (i instanceof Potion){
				if (!classes.contains(i.getClass())){
					classes.add(i.getClass());
				}
			}
		}
		handler.saveClassesSelectively( bundle, classes );
	}

	@SuppressWarnings("unchecked")
	public static void restore( Bundle bundle ) {
		handler = new ItemStatusHandler<>( (Class<? extends Potion>[])Generator.Category.POTION.classes, colors, bundle );
	}

	public Potion() {
		super();
		reset();
	}

	//anonymous potions are always IDed, do not affect ID status,
	//and their sprite is replaced by a placeholder if they are not known,
	//useful for items that appear in UIs, or which are only spawned for their effects
	protected boolean anonymous = false;
	public void anonymize(){
		if (!isKnown()) image = ItemSpriteSheet.POTION_HOLDER;
		anonymous = true;
	}

	@Override
	public void reset(){
		super.reset();
		if (handler != null && handler.contains(this)) {
			image = handler.image(this);
			color = handler.label(this);
		}
		setAction();
	}

	@Override
	public boolean collect( Bag container ) {
		if (super.collect( container )){
			setAction();
			return true;
		} else {
			return false;
		}
	}

	public void setAction(){
		if (isKnown() && mustThrowPots.contains(this.getClass())) {
			defaultAction = AC_THROW;
		} else if (isKnown() &&canThrowPots.contains(this.getClass())){
			defaultAction = AC_CHOOSE;
		} else {
			defaultAction = AC_DRINK;
		}
	}

	@Override
	public ArrayList<String> actions( Hero hero ) {
		ArrayList<String> actions = super.actions( hero );
		actions.add( AC_DRINK );
		return actions;
	}

	@Override
	public void execute( final Hero hero, String action ) {

		super.execute( hero, action );

		if (action.equals( AC_CHOOSE )){

			GameScene.show(new WndUseItem(null, this) );

		} else if (action.equals( AC_DRINK )) {

			if (Dungeon.hero.belongings.weapon() instanceof FrostBrand) {
				curItem = detach(hero.belongings.backpack);
				Buff.prolong(hero, FrostBrandBuff.class, FrostBrandBuff.DURATION);
				Buff.detach(hero, FireBrandBuff.class);
			}

			if (hero.buff(Silence.class) != null) {
				GLog.w(Messages.get(this, "silence"));
			}

			else if (hero.buff(NoPotion.class) != null) {
				GLog.w(Messages.get(this, "nopotion"));
			}

			else if (hero.buff(Incompetence.class) != null) {
				GLog.w(Messages.get(this, "incompetence"));

			} else if (isKnown() && mustThrowPots.contains(getClass())) {

				GameScene.show(
						new WndOptions(new ItemSprite(this),
								Messages.get(Potion.class, "harmful"),
								Messages.get(Potion.class, "sure_drink"),
								Messages.get(Potion.class, "yes"), Messages.get(Potion.class, "no") ) {
							@Override
							protected void onSelect(int index) {
								if (index == 0) {
									drink( hero );
								}
							}
						}
				);

			} else {
				drink( hero );
				Statistics.extraSTRcheck += 1;
				if (Dungeon.isChallenged(Challenges.YUUMA_POWER_DRAIN)) {
					Buff.prolong(curUser, Degrade.class, Degrade.DURATION/2f);
					Buff.prolong(curUser, WandZeroDamage.class, WandZeroDamage.DURATION/2f);
				}

				if (Dungeon.isChallenged(Challenges.CHERRY_BLOSSOM_BLOOM)) {
					Hunger hunger = Buff.affect(curUser, Hunger.class);
					hunger.affectHunger(10);
				}

				Buff.detach(hero, ArisastarRank1.class);
				Buff.detach(hero, ArisastarRank2.class);
				Buff.detach(hero, ArisastarRank3.class);

				if (Dungeon.isChallenged(Challenges.YUUMA_POWER_DRAIN) && Statistics.extraSTRcheck > 9) {
					Statistics.extraSTRcheck = 0;
					GameScene.flash(0x80FFFFFF);
					if (Dungeon.hero.STR > 5) {
						hero.STR--;
					}
				}

				if (hero.pointsInTalent(Talent.CURSED_PRESERVE) == 1) {
					for (Item item : Dungeon.hero.belongings) {
						if (item instanceof EquipableItem && item.cursed) {
							if (Random.Int(10) == 0) {
								Buff.prolong(hero, PotionPreserve.class, PotionPreserve.DURATION);
							}
						}
					}
				}
				if (hero.pointsInTalent(Talent.CURSED_PRESERVE) == 2) {
					for (Item item : Dungeon.hero.belongings) {
						if (item instanceof EquipableItem && item.cursed) {
							if (Random.Int(8) == 0) {
								Buff.prolong(hero, PotionPreserve.class, PotionPreserve.DURATION);
							}
						}
					}
				}
				if (hero.pointsInTalent(Talent.CURSED_PRESERVE) == 3) {
					for (Item item : Dungeon.hero.belongings) {
						if (item instanceof EquipableItem && item.cursed) {
							if (Random.Int(6) == 0) {
								Buff.prolong(hero, PotionPreserve.class, PotionPreserve.DURATION);
							}
						}
					}
				}

				if (hero.pointsInTalent(Talent.AQUA_POTION) == 1){
					hero.HP = Math.min(hero.HP + 11, hero.HT);
					Buff.prolong( hero, Triplespeed.class, Triplespeed.DURATION );
					hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
					if (Random.Int(2) == 0)
						Buff.affect(hero, SuperOoze.class).set( SuperOoze.DURATION );
				}
				if (hero.pointsInTalent(Talent.AQUA_POTION) == 2){
					hero.HP = Math.min(hero.HP + 18, hero.HT);
					Buff.prolong( hero, Triplespeed.class, Triplespeed.DURATION );
					hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
					if (Random.Int(2) == 0)
						Buff.affect(hero, SuperOoze.class).set( SuperOoze.DURATION );
				}
				if (hero.pointsInTalent(Talent.AQUA_POTION) == 3){
					hero.HP = Math.min(hero.HP + 25, hero.HT);
					Buff.prolong( hero, Triplespeed.class, Triplespeed.DURATION );
					hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
					if (Random.Int(2) == 0)
						Buff.affect(hero, SuperOoze.class).set( SuperOoze.DURATION );
				}

				if (hero.pointsInTalent(Talent.RISKY_POTION) == 1){
					hero.HP = Math.min(hero.HP + 20, hero.HT);
					Buff.prolong( hero, Doublespeed.class, Doublespeed.DURATION/2f );
					hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
					if (Random.Int(2) == 0)
						Buff.prolong( hero, Degrade.class, Degrade.DURATION );
				}
				if (hero.pointsInTalent(Talent.RISKY_POTION) == 2){
					hero.HP = Math.min(hero.HP + 28, hero.HT);
					Buff.prolong( hero, Doublespeed.class, Doublespeed.DURATION/2f );
					hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
					if (Random.Int(2) == 0)
						Buff.prolong( hero, Degrade.class, Degrade.DURATION );
				}
				if (hero.pointsInTalent(Talent.RISKY_POTION) == 3){
					hero.HP = Math.min(hero.HP + 36, hero.HT);
					Buff.prolong( hero, Doublespeed.class, Doublespeed.DURATION/2f );
					hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
					if (Random.Int(2) == 0)
						Buff.prolong( hero, Degrade.class, Degrade.DURATION );
				}
			}
		}
	}

	@Override
	public void doThrow( final Hero hero ) {

		if (isKnown()
				&& !mustThrowPots.contains(this.getClass())
				&& !canThrowPots.contains(this.getClass())) {

			GameScene.show(
					new WndOptions(new ItemSprite(this),
							Messages.get(Potion.class, "beneficial"),
							Messages.get(Potion.class, "sure_throw"),
							Messages.get(Potion.class, "yes"), Messages.get(Potion.class, "no") ) {
						@Override
						protected void onSelect(int index) {
							if (index == 0) {
								Potion.super.doThrow( hero );
							}
						}
					}
			);

		} else {
			super.doThrow( hero );
		}
	}

	protected void drink( Hero hero ) {

		if (hero.buff(PotionPreserve.class) != null && Random.Int(2) == 0) {
			GLog.i(Messages.get(Potion.class, "potionpreserve"));
		} else detach(hero.belongings.backpack);

		hero.spend( TIME_TO_DRINK );
		hero.busy();
		apply( hero );

		Sample.INSTANCE.play( Assets.Sounds.DRINK );

		hero.sprite.operate( hero.pos );
	}

	@Override
	protected void onThrow( int cell ) {
		if (Dungeon.level.map[cell] == Terrain.WELL || Dungeon.level.pit[cell]) {

			super.onThrow( cell );

		} else  {

			Dungeon.level.pressCell( cell );
			shatter( cell );
			Buff.detach(curUser, ArisastarRank1.class);
			Buff.detach(curUser, ArisastarRank2.class);
			Buff.detach(curUser, ArisastarRank3.class);
		}
	}

	public void apply( Hero hero ) {
		shatter( hero.pos );
	}

	public void shatter( int cell ) {
		if (Dungeon.level.heroFOV[cell]) {
			GLog.i( Messages.get(Potion.class, "shatter") );
			Sample.INSTANCE.play( Assets.Sounds.SHATTER );
			splash( cell );
		}
	}

	@Override
	public void cast( final Hero user, int dst ) {
		super.cast(user, dst);
	}

	public boolean isKnown() {
		return anonymous || (handler != null && handler.isKnown( this ));
	}

	public void setKnown() {
		if (!anonymous) {
			if (!isKnown()) {
				handler.know(this);
				updateQuickslot();
				Potion p = Dungeon.hero.belongings.getItem(getClass());
				if (p != null)  p.setAction();
				if (ExoticPotion.regToExo.get(getClass()) != null) {
					p = Dungeon.hero.belongings.getItem(ExoticPotion.regToExo.get(getClass()));
					if (p != null) p.setAction();
				}
			}

			if (Dungeon.hero.isAlive()) {
				Catalog.setSeen(getClass());
			}
		}
	}

	@Override
	public Item identify() {
		super.identify();

		if (!isKnown()) {
			setKnown();
		}
		return this;
	}

	@Override
	public String name() {
		return isKnown() ? super.name() : Messages.get(this, color);
	}

	@Override
	public String info() {
		return isKnown() ? desc() : Messages.get(this, "unknown_desc");
	}

	@Override
	public boolean isIdentified() {
		return isKnown();
	}

	@Override
	public boolean isUpgradable() {
		return false;
	}

	public static HashSet<Class<? extends Potion>> getKnown() {
		return handler.known();
	}

	public static HashSet<Class<? extends Potion>> getUnknown() {
		return handler.unknown();
	}

	public static boolean allKnown() {
		return handler.known().size() == Generator.Category.POTION.classes.length;
	}

	protected int splashColor(){
		return anonymous ? 0x00AAFF : ItemSprite.pick( image, 5, 9 );
	}

	protected void splash( int cell ) {

		Fire fire = (Fire)Dungeon.level.blobs.get( Fire.class );
		if (fire != null)
			fire.clear( cell );

		final int color = splashColor();

		Char ch = Actor.findChar(cell);
		if (ch != null && ch.alignment == Char.Alignment.ALLY) {
			Buff.detach(ch, Burning.class);
			Buff.detach(ch, Ooze.class);
			Splash.at( ch.sprite.center(), color, 5 );
		} else {
			Splash.at( cell, color, 5 );
		}
	}

	@Override
	public int value() {
		return 30 * quantity;
	}

	public static class PlaceHolder extends Potion {

		{
			image = ItemSpriteSheet.POTION_HOLDER;
		}

		@Override
		public boolean isSimilar(Item item) {
			return ExoticPotion.regToExo.containsKey(item.getClass())
					|| ExoticPotion.regToExo.containsValue(item.getClass());
		}

		@Override
		public String info() {
			return "";
		}
	}

	public static class SeedToPotion extends Recipe {

		public static HashMap<Class<?extends Plant.Seed>, Class<?extends Potion>> types = new HashMap<>();
		static {
			types.put(Blindweed.Seed.class,     PotionOfInvisibility.class);
			types.put(Dreamfoil.Seed.class,     PotionOfPurity.class);
			types.put(Earthroot.Seed.class,     PotionOfParalyticGas.class);
			types.put(Fadeleaf.Seed.class,      PotionOfMindVision.class);
			types.put(Firebloom.Seed.class,     PotionOfLiquidFlame.class);
			types.put(Icecap.Seed.class,        PotionOfFrost.class);
			types.put(Rotberry.Seed.class,      PotionOfStrength.class);
			types.put(Sorrowmoss.Seed.class,    PotionOfToxicGas.class);
			types.put(Starflower.Seed.class,    PotionOfExperience.class);
			types.put(Stormvine.Seed.class,     PotionOfLevitation.class);
			types.put(Sungrass.Seed.class,      PotionOfHealing.class);
			types.put(Swiftthistle.Seed.class,  PotionOfHaste.class);
		}

		@Override
		public boolean testIngredients(ArrayList<Item> ingredients) {
			if (ingredients.size() != 3) {
				return false;
			}

			for (Item ingredient : ingredients){
				if (!(ingredient instanceof Plant.Seed
						&& ingredient.quantity() >= 1
						&& types.containsKey(ingredient.getClass()))){
					return false;
				}
			}
			return true;
		}

		@Override
		public int cost(ArrayList<Item> ingredients) {
			return 0;
		}

		@Override
		public Item brew(ArrayList<Item> ingredients) {
			if (!testIngredients(ingredients)) return null;

			for (Item ingredient : ingredients){
				ingredient.quantity(ingredient.quantity() - 1);
			}

			ArrayList<Class<?extends Plant.Seed>> seeds = new ArrayList<>();
			for (Item i : ingredients) {
				if (!seeds.contains(i.getClass())) {
					seeds.add((Class<? extends Plant.Seed>) i.getClass());
				}
			}

			Potion result;

			if ( (seeds.size() == 2 && Random.Int(4) == 0)
					|| (seeds.size() == 3 && Random.Int(2) == 0)) {

				result = (Potion) Generator.randomUsingDefaults( Generator.Category.POTION );

			} else {
				result = Reflection.newInstance(types.get(Random.element(ingredients).getClass()));

			}

			if (seeds.size() == 1){
				result.identify();
			}

			while (result instanceof PotionOfHealing
					&& (Dungeon.isChallenged(Challenges.CURSED_HOURAI_ELIXIR)
					|| Random.Int(10) < Dungeon.LimitedDrops.COOKING_HP.count)) {

				result = (Potion) Generator.randomUsingDefaults(Generator.Category.POTION);
			}

			if (result instanceof PotionOfHealing) {
				Dungeon.LimitedDrops.COOKING_HP.count++;
			}

			return result;
		}

		@Override
		public Item sampleOutput(ArrayList<Item> ingredients) {
			return new WndBag.Placeholder(ItemSpriteSheet.POTION_HOLDER){

				@Override
				public String name() {
					return Messages.get(Potion.SeedToPotion.class, "name");
				}

				@Override
				public String info() {
					return "";
				}
			};
		}
	}
}