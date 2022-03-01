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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.YuukaRage;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.KyoukoSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.YuukaSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class Yuuka extends Mob {

	{
		spriteClass = YuukaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 999;
		} else HP = HT = 500;

		if (Dungeon.depth > 50){
			defenseSkill = 94;
		} else defenseSkill = 44;

		EXP = 1;
		maxLvl = 99;

		loot = new PotionOfHealing();
		lootChance = 0.1f;

		baseSpeed = 0.1f;

		properties.add(Property.YOKAI);
		properties.add(Property.POWERFUL);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(2, 2);
		} else return Random.NormalIntRange(1, 1);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 99;
		} else return 50;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(10, 20);
	}

	@Override
	public float attackDelay() { return super.attackDelay()*3f; }

	@Override
	public int defenseProc(Char enemy, int damage) {
		if (this.buff(Incompetence.class) == null) {
			if (Dungeon.hero.belongings.weapon() instanceof MeleeWeapon) {
				//takes 5/6/7/8/9/10 dmg at 5/7/10/14/19/25 incoming dmg
				enemy.damage(damage*2, target);
				Buff.prolong(this, Bless.class, Bless.DURATION*10000f);
				Buff.prolong(this, YuukaRage.class, YuukaRage.DURATION*10000f);
				Buff.prolong(this, Haste.class, Haste.DURATION*10000f);
				Buff.prolong(this, Triplespeed.class, Triplespeed.DURATION*10000f);
				GLog.w(Messages.get(this, "reflect"));
			}
		}
		return super.defenseProc(enemy, damage);
	}
}