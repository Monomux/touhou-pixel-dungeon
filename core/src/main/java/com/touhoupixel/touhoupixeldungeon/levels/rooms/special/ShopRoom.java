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

package com.touhoupixel.touhoupixeldungeon.levels.rooms.special;

import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Belongings;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Mob;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.npcs.Shopkeeper;
import com.touhoupixel.touhoupixeldungeon.items.Ankh;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.Heap;
import com.touhoupixel.touhoupixeldungeon.items.Honeypot;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.MerchantsBeacon;
import com.touhoupixel.touhoupixeldungeon.items.Stylus;
import com.touhoupixel.touhoupixeldungeon.items.Torch;
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
import com.touhoupixel.touhoupixeldungeon.items.artifacts.DriedRose;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.TimekeepersHourglass;
import com.touhoupixel.touhoupixeldungeon.items.bags.ArcaneHolder;
import com.touhoupixel.touhoupixeldungeon.items.bags.Bag;
import com.touhoupixel.touhoupixeldungeon.items.bags.FoodHolder;
import com.touhoupixel.touhoupixeldungeon.items.bags.MagicalHolster;
import com.touhoupixel.touhoupixeldungeon.items.bags.PotionBandolier;
import com.touhoupixel.touhoupixeldungeon.items.bags.ScrollHolder;
import com.touhoupixel.touhoupixeldungeon.items.bags.TailsmanHolder;
import com.touhoupixel.touhoupixeldungeon.items.bags.VelvetPouch;
import com.touhoupixel.touhoupixeldungeon.items.bombs.Bomb;
import com.touhoupixel.touhoupixeldungeon.items.food.Cucumber;
import com.touhoupixel.touhoupixeldungeon.items.food.SmallRation;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLightHealing;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfIdentify;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.touhoupixel.touhoupixeldungeon.items.spells.Alchemize;
import com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfAugmentation;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.darts.TippedDart;
import com.touhoupixel.touhoupixeldungeon.levels.Level;
import com.touhoupixel.touhoupixeldungeon.levels.Terrain;
import com.touhoupixel.touhoupixeldungeon.levels.painters.Painter;
import com.watabou.utils.Point;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopRoom extends SpecialRoom {

	private ArrayList<Item> itemsToSpawn;

	@Override
	public int minWidth() {
		return Math.max(7, (int)(Math.sqrt(itemCount())+3));
	}

	@Override
	public int minHeight() {
		return Math.max(7, (int)(Math.sqrt(itemCount())+3));
	}

	public int itemCount(){
		if (itemsToSpawn == null) itemsToSpawn = generateItems();
		return itemsToSpawn.size();
	}

	public void paint( Level level ) {

		Painter.fill( level, this, Terrain.WALL );
		Painter.fill( level, this, 1, Terrain.EMPTY_SP );

		placeShopkeeper( level );

		placeItems( level );

		for (Door door : connected.values()) {
			door.set( Door.Type.REGULAR );
		}

	}

	protected void placeShopkeeper( Level level ) {

		int pos = level.pointToCell(center());

		Mob shopkeeper = new Shopkeeper();
		shopkeeper.pos = pos;
		level.mobs.add( shopkeeper );

	}

	protected void placeItems( Level level ){

		if (itemsToSpawn == null){
			itemsToSpawn = generateItems();
		}

		Point itemPlacement = new Point(entrance());
		if (itemPlacement.y == top){
			itemPlacement.y++;
		} else if (itemPlacement.y == bottom) {
			itemPlacement.y--;
		} else if (itemPlacement.x == left){
			itemPlacement.x++;
		} else {
			itemPlacement.x--;
		}

		for (Item item : itemsToSpawn) {

			if (itemPlacement.x == left+1 && itemPlacement.y != top+1){
				itemPlacement.y--;
			} else if (itemPlacement.y == top+1 && itemPlacement.x != right-1){
				itemPlacement.x++;
			} else if (itemPlacement.x == right-1 && itemPlacement.y != bottom-1){
				itemPlacement.y++;
			} else {
				itemPlacement.x--;
			}

			int cell = level.pointToCell(itemPlacement);

			if (level.heaps.get( cell ) != null) {
				do {
					cell = level.pointToCell(random());
				} while (level.heaps.get( cell ) != null || level.findMob( cell ) != null);
			}

			level.drop( item, cell ).type = Heap.Type.FOR_SALE;
		}

	}

	protected static ArrayList<Item> generateItems() {

		ArrayList<Item> itemsToSpawn = new ArrayList<>();

		MeleeWeapon w;
		switch (Dungeon.depth) {
			case 6:
			default:
				w = (MeleeWeapon) Generator.random(Generator.wepTiers[1]);
				itemsToSpawn.add(Generator.random(Generator.misTiers[1]).quantity(2).identify());
				switch (Random.Int(3)) {
					case 0: default:
					itemsToSpawn.add(new LeatherArmor().identify());
						break;
					case 1:
						itemsToSpawn.add(new PC98ReimuArmor().identify());
						break;
					case 2:
						itemsToSpawn.add(new RumiaArmor().identify());
						break;
				}
				if (Dungeon.hero.heroClass == HeroClass.NITORI){
					itemsToSpawn.add(new Cucumber());
					itemsToSpawn.add(new Cucumber());
				}
				if (!Dungeon.isChallenged(Challenges.ROSELIA)){
					itemsToSpawn.add(new DriedRose());
				}
				break;

			case 11:
				w = (MeleeWeapon) Generator.random(Generator.wepTiers[2]);
				itemsToSpawn.add( Generator.random(Generator.misTiers[2]).quantity(2).identify() );
				switch (Random.Int(4)) {
					case 0: default:
						itemsToSpawn.add(new MailArmor().identify());
						break;
					case 1:
						itemsToSpawn.add(new PC98MarisaArmor().identify());
						break;
					case 2:
						itemsToSpawn.add(new HanasakigawaArmor().identify());
						break;
					case 3:
						itemsToSpawn.add(new PoppinPartyArmor().identify());
						break;
				}
				if (Dungeon.hero.heroClass == HeroClass.NITORI){
					itemsToSpawn.add(new Cucumber());
					itemsToSpawn.add(new Cucumber());
				}
				break;

			case 16:
				w = (MeleeWeapon) Generator.random(Generator.wepTiers[3]);
				itemsToSpawn.add( Generator.random(Generator.misTiers[3]).quantity(2).identify() );
				switch (Random.Int(4)) {
					case 0: default:
						itemsToSpawn.add(new ScaleArmor().identify());
						break;
					case 1:
						itemsToSpawn.add(new YorihimeArmor().identify());
						break;
					case 2:
						itemsToSpawn.add(new YuyukoArmor().identify());
						break;
					case 3:
						itemsToSpawn.add(new MaxwellArmor().identify());
						break;
				}
				if (Dungeon.hero.heroClass == HeroClass.NITORI){
					itemsToSpawn.add(new Cucumber());
					itemsToSpawn.add(new Cucumber());
				}
				break;

			case 21: case 31: case 61: case 81:
				w = (MeleeWeapon) Generator.random(Generator.wepTiers[4]);
				itemsToSpawn.add( Generator.random(Generator.misTiers[4]).quantity(2).identify() );
				switch (Random.Int(4)) {
					case 0: default:
						itemsToSpawn.add(new PlateArmor().identify());
						break;
					case 1:
						itemsToSpawn.add(new ToyohimeArmor().identify());
						break;
					case 2:
						itemsToSpawn.add(new HecatiaArmor().identify());
						break;
					case 3:
						itemsToSpawn.add(new GoldenDragonArmor().identify());
						break;
				}
				if (Dungeon.hero.heroClass == HeroClass.NITORI){
					itemsToSpawn.add(new Cucumber());
					itemsToSpawn.add(new Cucumber());
				}
				itemsToSpawn.add( new Torch());
				itemsToSpawn.add( new Torch());
				break;
		}
		w.enchant(null);
		w.cursed = false;
		w.level(0);
		w.identify();
		itemsToSpawn.add(w);

		itemsToSpawn.add( TippedDart.randomTipped(2) );

		itemsToSpawn.add( new Alchemize().quantity(Random.IntRange(3, 4)));

		itemsToSpawn.add(ChooseBag(Dungeon.hero.belongings));


		itemsToSpawn.add( new PotionOfHealing() );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.POTION ) );
		itemsToSpawn.add( Generator.randomUsingDefaults( Generator.Category.POTION ) );

		itemsToSpawn.add( new ScrollOfIdentify() );
		itemsToSpawn.add( new ScrollOfRemoveCurse() );
		itemsToSpawn.add( new ScrollOfMagicMapping() );

		for (int i=0; i < 2; i++)
			itemsToSpawn.add( Random.Int(2) == 0 ?
					Generator.randomUsingDefaults( Generator.Category.POTION ) :
					Generator.randomUsingDefaults( Generator.Category.SCROLL ) );


		itemsToSpawn.add( new SmallRation() );
		itemsToSpawn.add( new SmallRation() );

		switch (Random.Int(4)){
			case 0:
				itemsToSpawn.add( new Bomb() );
				break;
			case 1:
				itemsToSpawn.add( new PotionOfLightHealing() );
				break;
			case 2:
				itemsToSpawn.add( new Bomb.DoubleBomb() );
				break;
			case 3:
				itemsToSpawn.add( new Honeypot() );
				break;
		}

		if (!Dungeon.isChallenged(Challenges.ATHEISM)) {
			itemsToSpawn.add(new Ankh());
		}
		itemsToSpawn.add( new StoneOfAugmentation() );

		TimekeepersHourglass hourglass = Dungeon.hero.belongings.getItem(TimekeepersHourglass.class);
		if (hourglass != null && hourglass.isIdentified() && !hourglass.cursed){
			int bags = 0;
			//creates the given float percent of the remaining bags to be dropped.
			//this way players who get the hourglass late can still max it, usually.
			switch (Dungeon.depth) {
				case 6:
					bags = (int)Math.ceil(( 5-hourglass.sandBags) * 0.20f ); break;
				case 11:
					bags = (int)Math.ceil(( 5-hourglass.sandBags) * 0.25f ); break;
				case 16:
					bags = (int)Math.ceil(( 5-hourglass.sandBags) * 0.50f ); break;
				case 21: case 31: case 61: case 81:
					bags = (int)Math.ceil(( 5-hourglass.sandBags) * 0.80f ); break;
			}

			for(int i = 1; i <= bags; i++){
				itemsToSpawn.add( new TimekeepersHourglass.sandBag());
				hourglass.sandBags ++;
			}
		}

		Item rare;
		switch (Random.Int(10)){
			case 0:
				rare = Generator.random( Generator.Category.WAND );
				rare.level( 0 );
				break;
			case 1:
				rare = Generator.random(Generator.Category.RING);
				rare.level( 0 );
				break;
			case 2:
				rare = Generator.random( Generator.Category.ARTIFACT );
				break;
			default:
				rare = new Stylus();
		}
		rare.cursed = false;
		rare.cursedKnown = true;
		itemsToSpawn.add( rare );

		//hard limit is 63 items + 1 shopkeeper, as shops can't be bigger than 8x8=64 internally
		if (itemsToSpawn.size() > 63)
			throw new RuntimeException("Shop attempted to carry more than 63 items!");

		//use a new generator here to prevent items in shop stock affecting levelgen RNG (e.g. sandbags)
		Random.pushGenerator(Random.Long());
		Random.shuffle(itemsToSpawn);
		Random.popGenerator();

		return itemsToSpawn;
	}

	protected static Bag ChooseBag(Belongings pack){

		//generate a hashmap of all valid bags.
		HashMap<Bag, Integer> bags = new HashMap<>();
		if (!Dungeon.LimitedDrops.VELVET_POUCH.dropped()) bags.put(new VelvetPouch(), 1);
		if (!Dungeon.LimitedDrops.SCROLL_HOLDER.dropped()) bags.put(new ScrollHolder(), 0);
		if (!Dungeon.LimitedDrops.POTION_BANDOLIER.dropped()) bags.put(new PotionBandolier(), 0);
		if (!Dungeon.LimitedDrops.MAGICAL_HOLSTER.dropped()) bags.put(new MagicalHolster(), 1);
		if (!Dungeon.LimitedDrops.FOOD_HOLDER.dropped()) bags.put(new FoodHolder(), 1);
		if (!Dungeon.LimitedDrops.TAILSMAN_HOLDER.dropped()) bags.put(new TailsmanHolder(), 1);
		if (!Dungeon.LimitedDrops.ARCANE_HOLDER.dropped()) bags.put(new ArcaneHolder(), 0);

		if (bags.isEmpty()) return null;

		//count up items in the main bag
		for (Item item : pack.backpack.items) {
			for (Bag bag : bags.keySet()){
				if (bag.canHold(item)){
					bags.put(bag, bags.get(bag)+1);
				}
			}
		}

		//find which bag will result in most inventory savings, drop that.
		Bag bestBag = null;
		for (Bag bag : bags.keySet()){
			if (bestBag == null){
				bestBag = bag;
			} else if (bags.get(bag) > bags.get(bestBag)){
				bestBag = bag;
			}
		}

		if (bestBag instanceof VelvetPouch){
			Dungeon.LimitedDrops.VELVET_POUCH.drop();
		} else if (bestBag instanceof ScrollHolder){
			Dungeon.LimitedDrops.SCROLL_HOLDER.drop();
		} else if (bestBag instanceof PotionBandolier){
			Dungeon.LimitedDrops.POTION_BANDOLIER.drop();
		} else if (bestBag instanceof MagicalHolster){
			Dungeon.LimitedDrops.MAGICAL_HOLSTER.drop();
		} else if (bestBag instanceof FoodHolder){
			Dungeon.LimitedDrops.FOOD_HOLDER.drop();
		} else if (bestBag instanceof ArcaneHolder){
			Dungeon.LimitedDrops.ARCANE_HOLDER.drop();
		} else if (bestBag instanceof TailsmanHolder){
			Dungeon.LimitedDrops.TAILSMAN_HOLDER.drop();
		}

		return bestBag;

	}

}