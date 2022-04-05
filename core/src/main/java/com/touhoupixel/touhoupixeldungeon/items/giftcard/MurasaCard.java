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

package com.touhoupixel.touhoupixeldungeon.items.giftcard;

import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.armor.Armor;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.wands.Wand;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

public class MurasaCard extends GiftCard {

	{
		image = ItemSpriteSheet.BIRTHDAY_CARD;
	}

	@Override
	protected void onCast(Hero hero) {
		Generator.Category c = Generator.Category.WEP_T2;
		MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
		w.collect();
		Generator.Category c2 = Generator.Category.WEP_T3;
		MeleeWeapon w2 = (MeleeWeapon) Reflection.newInstance(c2.classes[Random.chances(c2.probs)]);
		w2.collect();
		Generator.Category c3 = Generator.Category.WEP_T4;
		MeleeWeapon w3 = (MeleeWeapon) Reflection.newInstance(c3.classes[Random.chances(c3.probs)]);
		w3.collect();
		Generator.Category c4 = Generator.Category.WEP_T5;
		MeleeWeapon w4 = (MeleeWeapon) Reflection.newInstance(c4.classes[Random.chances(c4.probs)]);
		w4.collect();
		Generator.Category c5 = Generator.Category.WAND;
		Wand w5 = (Wand) Reflection.newInstance(c5.classes[Random.chances(c5.probs)]);
		w5.collect();
		Generator.Category c6 = Generator.Category.ARMOR_T2;
		Armor w6 = (Armor) Reflection.newInstance(c6.classes[Random.chances(c6.probs)]);
		w6.collect();
		Generator.Category c7 = Generator.Category.ARMOR_T3;
		Armor w7 = (Armor) Reflection.newInstance(c7.classes[Random.chances(c7.probs)]);
		w7.collect();
		Generator.Category c8 = Generator.Category.ARMOR_T4;
		Armor w8 = (Armor) Reflection.newInstance(c8.classes[Random.chances(c8.probs)]);
		w8.collect();
		Generator.Category c9 = Generator.Category.ARMOR_T5;
		Armor w9 = (Armor) Reflection.newInstance(c9.classes[Random.chances(c9.probs)]);
		w9.collect();
		PotionOfHealing Poh = new PotionOfHealing();
		Poh.quantity(3).collect();
		GameScene.flash(0x80FFFFFF);
	}
}
