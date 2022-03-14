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

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublerainbow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfSilence;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.TenkyuuSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class TenkyuuBoss extends Mob {

	public Item item;

	{
		spriteClass = TenkyuuSprite.class;

		HP = HT = Dungeon.isChallenged(Challenges.STRONGER_BOSSES) ? 180 : 120;

		defenseSkill = 25;

		EXP = 0;

		maxLvl = 99;

		properties.add(Property.BOSS);
		properties.add(Property.GOD);
		properties.add(Property.WARP);

		WANDERING = new Wandering();
		FLEEING = new Fleeing();
	}

	private static final String ITEM = "item";

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put(ITEM, item);
	}

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		item = (Item) bundle.get(ITEM);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(14, 18);
	}

	@Override
	public int attackSkill(Char target) {
		return 25;
	}

	@Override
	protected Item createLoot() {
		Dungeon.LimitedDrops.THEIF_MISC.count++;
		return super.createLoot();
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );
		Statistics.forestbosskillcount += 1;

		if (Statistics.forestbosskillcount > 3){
			Dungeon.level.unseal();
			GameScene.bossSlain();
		}
	}

	@Override
	public int attackProc(Char enemy, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			if (alignment == Alignment.ENEMY && item == null
					&& enemy instanceof Hero && steal((Hero) enemy)) {
				state = WANDERING;
				ScrollOfSilence Silence = new ScrollOfSilence();
				Silence.quantity(1).collect();
				Buff.prolong(this, Doublerainbow.class, Doublerainbow.DURATION);
			}
		}
		return damage;
	}

	protected boolean steal(Hero hero) {

		Item toSteal = hero.belongings.randomUnequipped();

		if (toSteal != null && !toSteal.unique && toSteal.level() < 1) {

			GLog.w(Messages.get(TenkyuuBoss.class, "stole", toSteal.name()));
			if (!toSteal.stackable) {
				Dungeon.quickslot.convertToPlaceholder(toSteal);
				Sample.INSTANCE.play( Assets.Sounds.CURSED );
			}
			Item.updateQuickslot();

			item = toSteal.detach(hero.belongings.backpack);
			return true;
		} else {
			return false;
		}
	}
}
