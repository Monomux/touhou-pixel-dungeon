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

import com.touhoupixel.touhoupixeldungeon.TouhouPixelDungeon;
import com.touhoupixel.touhoupixeldungeon.items.bombs.Bomb;
import com.touhoupixel.touhoupixeldungeon.items.food.Blandfruit;
import com.touhoupixel.touhoupixeldungeon.items.food.BloodWaffle;
import com.touhoupixel.touhoupixeldungeon.items.food.Bloodcake;
import com.touhoupixel.touhoupixeldungeon.items.food.Halfapple;
import com.touhoupixel.touhoupixeldungeon.items.food.Halfcake;
import com.touhoupixel.touhoupixeldungeon.items.food.Iceapple;
import com.touhoupixel.touhoupixeldungeon.items.food.KnifeWaffle;
import com.touhoupixel.touhoupixeldungeon.items.food.MeatPie;
import com.touhoupixel.touhoupixeldungeon.items.food.PeachFruit;
import com.touhoupixel.touhoupixeldungeon.items.food.PeachWaffle;
import com.touhoupixel.touhoupixeldungeon.items.food.StewedMeat;
import com.touhoupixel.touhoupixeldungeon.items.food.TenshiPeach;
import com.touhoupixel.touhoupixeldungeon.items.food.Watermelon;
import com.touhoupixel.touhoupixeldungeon.items.potions.AlchemicalCatalyst;
import com.touhoupixel.touhoupixeldungeon.items.potions.Potion;
import com.touhoupixel.touhoupixeldungeon.items.potions.brews.BlizzardBrew;
import com.touhoupixel.touhoupixeldungeon.items.potions.brews.CausticBrew;
import com.touhoupixel.touhoupixeldungeon.items.potions.brews.InfernalBrew;
import com.touhoupixel.touhoupixeldungeon.items.potions.brews.ShockingBrew;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfAquaticRejuvenation;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfArcaneArmor;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfDragonsBlood;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfHoneyedHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfIcyTouch;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfMight;
import com.touhoupixel.touhoupixeldungeon.items.potions.elixirs.ElixirOfToxicEssence;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.ExoticPotion;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.Scroll;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ExoticScroll;
import com.touhoupixel.touhoupixeldungeon.items.spells.Alchemize;
import com.touhoupixel.touhoupixeldungeon.items.spells.AquaBlast;
import com.touhoupixel.touhoupixeldungeon.items.spells.ArcaneCatalyst;
import com.touhoupixel.touhoupixeldungeon.items.spells.BeaconOfReturning;
import com.touhoupixel.touhoupixeldungeon.items.spells.CurseInfusion;
import com.touhoupixel.touhoupixeldungeon.items.spells.FeatherFall;
import com.touhoupixel.touhoupixeldungeon.items.spells.MagicalInfusion;
import com.touhoupixel.touhoupixeldungeon.items.spells.MagicalPorter;
import com.touhoupixel.touhoupixeldungeon.items.spells.PhaseShift;
import com.touhoupixel.touhoupixeldungeon.items.spells.ReclaimTrap;
import com.touhoupixel.touhoupixeldungeon.items.spells.Recycle;
import com.touhoupixel.touhoupixeldungeon.items.spells.SummonElemental;
import com.touhoupixel.touhoupixeldungeon.items.spells.TelekineticGrab;
import com.touhoupixel.touhoupixeldungeon.items.spells.WildEnergy;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.MissileWeapon;
import com.watabou.utils.Reflection;

import java.util.ArrayList;

public abstract class Recipe {
	
	public abstract boolean testIngredients(ArrayList<Item> ingredients);
	
	public abstract int cost(ArrayList<Item> ingredients);
	
	public abstract Item brew(ArrayList<Item> ingredients);
	
	public abstract Item sampleOutput(ArrayList<Item> ingredients);
	
	//subclass for the common situation of a recipe with static inputs and outputs
	public static abstract class SimpleRecipe extends Recipe {
		
		//*** These elements must be filled in by subclasses
		protected Class<?extends Item>[] inputs; //each class should be unique
		protected int[] inQuantity;
		
		protected int cost;
		
		protected Class<?extends Item> output;
		protected int outQuantity;
		//***
		
		//gets a simple list of items based on inputs
		public ArrayList<Item> getIngredients() {
			ArrayList<Item> result = new ArrayList<>();
			for (int i = 0; i < inputs.length; i++) {
				Item ingredient = Reflection.newInstance(inputs[i]);
				ingredient.quantity(inQuantity[i]);
				result.add(ingredient);
			}
			return result;
		}
		
		@Override
		public final boolean testIngredients(ArrayList<Item> ingredients) {
			
			int[] needed = inQuantity.clone();
			
			for (Item ingredient : ingredients){
				if (!ingredient.isIdentified()) return false;
				for (int i = 0; i < inputs.length; i++){
					if (ingredient.getClass() == inputs[i]){
						needed[i] -= ingredient.quantity();
						break;
					}
				}
			}
			
			for (int i : needed){
				if (i > 0){
					return false;
				}
			}
			
			return true;
		}
		
		public final int cost(ArrayList<Item> ingredients){
			return cost;
		}
		
		@Override
		public final Item brew(ArrayList<Item> ingredients) {
			if (!testIngredients(ingredients)) return null;
			
			int[] needed = inQuantity.clone();
			
			for (Item ingredient : ingredients){
				for (int i = 0; i < inputs.length; i++) {
					if (ingredient.getClass() == inputs[i] && needed[i] > 0) {
						if (needed[i] <= ingredient.quantity()) {
							ingredient.quantity(ingredient.quantity() - needed[i]);
							needed[i] = 0;
						} else {
							needed[i] -= ingredient.quantity();
							ingredient.quantity(0);
						}
					}
				}
			}
			
			//sample output and real output are identical in this case.
			return sampleOutput(null);
		}
		
		//ingredients are ignored, as output doesn't vary
		public final Item sampleOutput(ArrayList<Item> ingredients){
			try {
				Item result = Reflection.newInstance(output);
				result.quantity(outQuantity);
				return result;
			} catch (Exception e) {
				TouhouPixelDungeon.reportException( e );
				return null;
			}
		}
	}
	
	
	//*******
	// Static members
	//*******

	private static Recipe[] variableRecipes = new Recipe[]{
			new LiquidMetal.Recipe()
	};
	
	private static Recipe[] oneIngredientRecipes = new Recipe[]{
		new Scroll.ScrollToStone(),
		new ExoticPotion.PotionToExotic(),
		new ExoticScroll.ScrollToExotic(),
		new ArcaneResin.Recipe(),
		new Alchemize.Recipe(),
		new StewedMeat.oneMeat()
	};
	
	private static Recipe[] twoIngredientRecipes = new Recipe[]{
		new Blandfruit.CookFruit(),
		new Bomb.EnhanceBomb(),
		new AlchemicalCatalyst.Recipe(),
		new ArcaneCatalyst.Recipe(),
		new ElixirOfArcaneArmor.Recipe(),
		new ElixirOfAquaticRejuvenation.Recipe(),
		new ElixirOfDragonsBlood.Recipe(),
		new ElixirOfIcyTouch.Recipe(),
		new ElixirOfMight.Recipe(),
		new ElixirOfHoneyedHealing.Recipe(),
		new ElixirOfToxicEssence.Recipe(),
		new BlizzardBrew.Recipe(),
		new InfernalBrew.Recipe(),
		new ShockingBrew.Recipe(),
		new CausticBrew.Recipe(),
		new AquaBlast.Recipe(),
		new BeaconOfReturning.Recipe(),
		new CurseInfusion.Recipe(),
		new FeatherFall.Recipe(),
		new MagicalInfusion.Recipe(),
		new MagicalPorter.Recipe(),
		new PhaseShift.Recipe(),
		new ReclaimTrap.Recipe(),
		new Recycle.Recipe(),
		new WildEnergy.Recipe(),
		new TelekineticGrab.Recipe(),
		new SummonElemental.Recipe(),
			new Bloodcake.Recipe(),
			new BloodWaffle.Recipe(),
			new Halfapple.Recipe(),
			new Halfcake.Recipe(),
			new Iceapple.Recipe(),
			new KnifeWaffle.Recipe(),
			new PeachFruit.Recipe(),
			new PeachWaffle.Recipe(),
			new TenshiPeach.Recipe(),
			new Watermelon.Recipe(),
		new StewedMeat.twoMeat()
	};
	
	private static Recipe[] threeIngredientRecipes = new Recipe[]{
		new Potion.SeedToPotion(),
		new StewedMeat.threeMeat(),
		new MeatPie.Recipe()
	};
	
	public static ArrayList<Recipe> findRecipes(ArrayList<Item> ingredients){

		ArrayList<Recipe> result = new ArrayList<>();

		for (Recipe recipe : variableRecipes){
			if (recipe.testIngredients(ingredients)){
				result.add(recipe);
			}
		}

		if (ingredients.size() == 1){
			for (Recipe recipe : oneIngredientRecipes){
				if (recipe.testIngredients(ingredients)){
					result.add(recipe);
				}
			}
			
		} else if (ingredients.size() == 2){
			for (Recipe recipe : twoIngredientRecipes){
				if (recipe.testIngredients(ingredients)){
					result.add(recipe);
				}
			}
			
		} else if (ingredients.size() == 3){
			for (Recipe recipe : threeIngredientRecipes){
				if (recipe.testIngredients(ingredients)){
					result.add(recipe);
				}
			}
		}
		
		return result;
	}
	
	public static boolean usableInRecipe(Item item){
		return !item.cursed && (!(item instanceof EquipableItem) || item instanceof MissileWeapon);
	}
}


