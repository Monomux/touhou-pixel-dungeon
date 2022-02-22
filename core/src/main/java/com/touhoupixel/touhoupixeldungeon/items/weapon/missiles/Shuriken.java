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

package com.touhoupixel.touhoupixeldungeon.items.weapon.missiles;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;

public class Shuriken extends com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.MissileWeapon {

	{
		image = ItemSpriteSheet.SHURIKEN;
		hitSound = Assets.Sounds.HIT_STAB;
		hitSoundPitch = 1.2f;

		tier = 2;
		baseUses = 5;
	}

	@Override
	public int max(int lvl) {
		return  15 * tier +                      //8 base, down from 10
				(tier == 1 ? 2*lvl : tier*lvl); //scaling unchanged
	}

	@Override
	public float delayFactor(Char owner) {
		if (owner instanceof Hero && ((Hero) owner).justMoved)  return 0;
		else                                                    return super.delayFactor(owner);
	}
}
