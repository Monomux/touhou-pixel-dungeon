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

package com.touhoupixel.touhoupixeldungeon.items.weapon.melee;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;

import java.util.ArrayList;

public class JeweledBranch extends MeleeWeapon {

	{
		image = ItemSpriteSheet.JEWELEDBRANCH;
		hitSound = Assets.Sounds.HIT;
		hitSoundPitch = 1f;

		tier = 1;
	}

	@Override
	public int warpResistFactor(Char owner) {
		return 2;
	}

	@Override
	public int powerfulResistFactor(Char owner) {
		return 2;
	}

	@Override
	public int coolResistFactor(Char owner) {
		return 2;
	}

	@Override
	public int pureResistFactor(Char owner) {
		return 2;
	}

	@Override
	public int happyResistFactor(Char owner) {
		return 2;
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.remove(AC_XYZ);
		return actions;
	}

	@Override
	public int max(int lvl) {
		return 7*(tier+1)+
				lvl*(tier+2);
	}
}