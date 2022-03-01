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

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfInvisibility;
import com.touhoupixel.touhoupixeldungeon.sprites.KoishiSprite;
import com.watabou.utils.Random;

public class Koishi extends Mob {

	{
		spriteClass = KoishiSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 500;
		} else HP = HT = 80;

		if (Dungeon.depth > 50){
			defenseSkill = 90;
		} else defenseSkill = 40;

		if (Dungeon.depth > 50){
			EXP = 67;
		} else EXP = 17;

		if (Dungeon.depth > 50){
			maxLvl = 85;
		} else maxLvl = 35;

		loot = PotionOfInvisibility.class;
		lootChance = 0.11f;

		properties.add(Property.YOKAI);
		properties.add(Property.HAPPY);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(56, 60);
		} else return Random.NormalIntRange(32, 36);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 68;
		} else return 8;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}
}