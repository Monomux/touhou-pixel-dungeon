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

package com.touhoupixel.touhoupixeldungeon.items.potions.exotic;

import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiHeal;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;

public class PotionOfYomi extends ExoticPotion {

	{
		icon = ItemSpriteSheet.Icons.POTION_YOMI;

		bones = true;
	}

	@Override
	public void apply(Hero hero) {
		identify();
		if (hero.buff(AntiHeal.class) != null) {
			hero.damage(hero.HT / 2, hero);
		} else hero.HP = Math.min(hero.HP + 10000, hero.HT);
			if (hero.HT > 50) {
				hero.HP -= 30;
				hero.HT -= 30;
			}
		}
	}