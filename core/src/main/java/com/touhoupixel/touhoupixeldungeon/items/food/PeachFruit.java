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

package com.touhoupixel.touhoupixeldungeon.items.food;

import com.touhoupixel.touhoupixeldungeon.actors.buffs.AnkhInvulnerability;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublerainbow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hunger;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Levitation;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.items.quest.Peach;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;

public class PeachFruit extends Food {

	{
		image = ItemSpriteSheet.PEACHFRUIT;
		energy = Hunger.STARVING;
	}
	
	@Override
	protected void satisfy(Hero hero) {
		super.satisfy(hero);
		effect(hero);
	}
	
	public int value() {
		return 10 * quantity;
	}

	public static void effect(Hero hero){
		switch (Random.Int( 0 )) {
			case 0:
				//GLog.i( Messages.get(MiracleFruit.class, "invis") );
				Buff.affect( hero, Doublerainbow.class, Doublerainbow.DURATION/4f );
				Buff.affect( hero, Levitation.class, Levitation.DURATION );
				break;
		}
	}
	public static class Recipe extends com.touhoupixel.touhoupixeldungeon.items.Recipe.SimpleRecipe {

		{
			inputs =  new Class[]{Peach.class, MiracleFruit.class};
			inQuantity = new int[]{1, 1};

			cost = 4;

			output = PeachFruit.class;
			outQuantity = 1;
		}

	}
}
