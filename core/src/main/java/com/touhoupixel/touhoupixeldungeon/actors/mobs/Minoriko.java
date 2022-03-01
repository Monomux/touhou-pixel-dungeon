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

package com.touhoupixel.touhoupixeldungeon.actors.mobs;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.food.Food;
import com.touhoupixel.touhoupixeldungeon.items.quest.Peach;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.MinorikoSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Minoriko extends Mob {

	public Item item;

	{
		spriteClass = MinorikoSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 473;
		} else HP = HT = 30;

		if (Dungeon.depth > 50){
			defenseSkill = 64;
		} else defenseSkill = 14;

		if (Dungeon.depth > 50){
			EXP = 57;
		} else EXP = 7;

		if (Dungeon.depth > 50){
			maxLvl = 65;
		} else maxLvl = 15;

		WANDERING = new Wandering();
		FLEEING = new Fleeing();

		loot = new Food();
		lootChance = 0.1f;

		properties.add(Property.GOD);
		properties.add(Property.COOL);
	}

	private static final String ITEM = "item";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(ITEM, item);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		item = (Item) bundle.get(ITEM);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(40, 46);
		} else return Random.NormalIntRange(8, 11);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 80;
		} else return 30;
	}

	@Override
	protected Item createLoot() {
		Dungeon.LimitedDrops.THEIF_MISC.count++;
		return super.createLoot();
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char enemy, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			if (alignment == Alignment.ENEMY && item == null
					&& enemy instanceof Hero && steal((Hero) enemy)) {
				state = WANDERING;
				Food Food = new Food();
				Food.quantity(1).collect();
			}
		}
		return damage;
	}

	protected boolean steal(Hero hero) {

		Item toSteal = hero.belongings.randomUnequipped();

		if (toSteal != null && !toSteal.unique && toSteal.level() < 1) {

			GLog.w(Messages.get(Minoriko.class, "stole", toSteal.name()));
			if (!toSteal.stackable) {
				Dungeon.quickslot.convertToPlaceholder(toSteal);
				Sample.INSTANCE.play( Assets.Sounds.CURSED );
			}
			Item.updateQuickslot();

			item = toSteal.detach(hero.belongings.backpack);
			return true;
		} else {
			return false;
		}
	}
}
