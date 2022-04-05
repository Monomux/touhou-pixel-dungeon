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

package com.touhoupixel.touhoupixeldungeon.items.spells;

import com.touhoupixel.touhoupixeldungeon.Badges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Degrade;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.items.EquipableItem;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.armor.Armor;
import com.touhoupixel.touhoupixeldungeon.items.armor.ClothArmor;
import com.touhoupixel.touhoupixeldungeon.items.potions.Potion;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.touhoupixel.touhoupixeldungeon.items.wands.Wand;
import com.touhoupixel.touhoupixeldungeon.items.weapon.Weapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Dagger;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Gloves;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HinaRibbon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HisoutenMankind;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.JeweledBranch;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MagesStaff;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MiracleMallet;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Psalms;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.SmallSeiranHammer;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.ToyohimeFan;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WornShortsword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YorihimeSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.MissileWeapon;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;

public class KogasaHammer extends InventorySpell {

	{
		image = ItemSpriteSheet.KOGASA_HAMMER;

		unique = true;
	}

	@Override
	protected boolean usableOnItem(Item item) {
		return item instanceof MeleeWeapon && ((MeleeWeapon) item).tier == 1 ||
				item instanceof ClothArmor;
	}

	@Override
	protected void onItemSelected(Item item) {

		ScrollOfUpgrade.upgrade(curUser);

		item.upgrade();

		GLog.p(Messages.get(this, "kogasahammer", item.name()));
		Badges.validateItemLevelAquired(item);
	}
}