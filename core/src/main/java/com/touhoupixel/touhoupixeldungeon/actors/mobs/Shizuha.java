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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hunger;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.items.food.SmallRation;
import com.touhoupixel.touhoupixeldungeon.sprites.CharSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.ShizuhaSprite;
import com.watabou.utils.Random;

public class Shizuha extends Mob {

	{
		spriteClass = ShizuhaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 550;
		} else HP = HT = 90;

		if (Dungeon.depth > 50){
			defenseSkill = 80;
		} else defenseSkill = 30;

		if (Dungeon.depth > 50){
			EXP = 63;
		} else EXP = 13;

		if (Dungeon.depth > 50){
			maxLvl = 80;
		} else maxLvl = 30;

		loot = SmallRation.class;
		lootChance = 0.1f;

		properties.add(Property.GOD);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(43, 48);
		} else return Random.NormalIntRange(27, 31);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 80;
		} else return 30;
	}

	@Override
	public float attackDelay() { return super.attackDelay()*0.5f; }

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(2) == 0) {

				//assumes using up 10% of starving, and healing of 1 hp per 10 turns;
				int healing = Math.min((int) Hunger.STARVING / 100, hero.HT - hero.HP);

				if (healing > 0) {

					Hunger hunger = Buff.affect(hero, Hunger.class);

					if (!hunger.isStarving()) {

						hunger.affectHunger(healing * -10);

						hero.HP += healing;
						hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
						hero.sprite.showStatus(CharSprite.POSITIVE, Integer.toString(healing));
					}
				}
			}
		}
		return damage;
	}
}