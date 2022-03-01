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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.KyoukoSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class Kyouko extends Mob {

	{
		spriteClass = KyoukoSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 444;
		} else HP = HT = 84;

		if (Dungeon.depth > 50){
			defenseSkill = 80;
		} else defenseSkill = 30;

		if (Dungeon.depth > 50){
			EXP = 63;
		} else EXP = 13;

		if (Dungeon.depth > 50){
			maxLvl = 80;
		} else maxLvl = 30;

		loot = new PotionOfHealing();
		lootChance = 0.2f;

		properties.add(Property.ANIMAL);
		properties.add(Property.YOKAI);
		properties.add(Property.HAPPY);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(31, 35);
		} else return Random.NormalIntRange(12, 19);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 78;
		} else return 28;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int defenseProc(Char enemy, int damage) {
		if (this.buff(Incompetence.class) == null) {
			if (Dungeon.hero.belongings.weapon() instanceof MeleeWeapon) {
				//takes 5/6/7/8/9/10 dmg at 5/7/10/14/19/25 incoming dmg
				enemy.damage(damage / 2, target);
				GLog.w(Messages.get(this, "reflect"));
			}
		}
		return super.defenseProc(enemy, damage);
	}
}