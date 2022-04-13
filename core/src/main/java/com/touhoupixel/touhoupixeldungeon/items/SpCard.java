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

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AnkhInvulnerability;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiHeal;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Burning;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Degrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hunger;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Ooze;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SuperDegrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SuperOoze;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.items.food.Food;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.ArrayList;

public class SpCard extends Item {

	private static final String AC_DRINK	= "DRINK";

	{
		image = ItemSpriteSheet.SPCARD;

		defaultAction = AC_DRINK;

		unique = true;
	}

	@Override
	public ArrayList<String> actions( Hero hero ) {
		ArrayList<String> actions = super.actions( hero );
		actions.remove(AC_DROP);
		actions.remove(AC_THROW);
		actions.add( AC_DRINK );
		return actions;
	}

	@Override
	public void execute( final Hero hero, String action ) {

		super.execute(hero, action);

		if (action.equals(AC_DRINK)) {
			if (Dungeon.gold >= 250+Dungeon.depth*50){
				Dungeon.gold -= 250+Dungeon.depth*50;
				Generator.Category f = Generator.Category.FOOD;
				Food f2 = (Food) Reflection.newInstance(f.classes[Random.chances(f.probs)]);
				f2.collect();
			} else GLog.i( Messages.get(this, "nomoney") );
		}
	}

	@Override
	public boolean isUpgradable() {
		return false;
	}

	@Override
	public boolean isIdentified() {
		return true;
	}
}
