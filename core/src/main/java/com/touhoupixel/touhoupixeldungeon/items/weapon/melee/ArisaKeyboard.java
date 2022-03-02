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
import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AnkhInvulnerability;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank1;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank2;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank3;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doubleevasion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Belongings;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.Stylus;
import com.touhoupixel.touhoupixeldungeon.items.bags.Bag;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.touhoupixel.touhoupixeldungeon.windows.WndBag;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class ArisaKeyboard extends MeleeWeapon {

	{
		image = ItemSpriteSheet.ARISA_KEYBOARD;
		hitSound = Assets.Sounds.HIT;
		hitSoundPitch = 1f;

		tier = 5;
	}

	@Override
	public int max(int lvl) {
		return  3*(tier+1) +
				lvl*(tier);
	}

	@Override
	public int happyResistFactor( Char owner ) {
		return 3;
	}

	@Override
	public int damageRoll(Char owner) {
		if (owner instanceof Hero) {
			Hero hero = (Hero) owner;
			Char enemy = hero.enemy();
			if (Dungeon.hero.belongings.weapon() instanceof ArisaKeyboard && hero.buff(ArisastarRank1.class) == null && hero.buff(ArisastarRank2.class) == null && hero.buff(ArisastarRank3.class) == null && (Random.Int(3) == 0)) {
				Buff.prolong(owner, ArisastarRank1.class, ArisastarRank1.DURATION);
			} else if (Dungeon.hero.belongings.weapon() instanceof ArisaKeyboard && hero.buff(ArisastarRank1.class) != null && hero.buff(ArisastarRank2.class) == null && hero.buff(ArisastarRank3.class) == null && (Random.Int(3) == 0)) {
				Buff.detach(hero, ArisastarRank1.class);
				Buff.prolong(owner, ArisastarRank2.class, ArisastarRank2.DURATION);
			} else if (Dungeon.hero.belongings.weapon() instanceof ArisaKeyboard && hero.buff(ArisastarRank1.class) == null && hero.buff(ArisastarRank2.class) != null && hero.buff(ArisastarRank3.class) == null && (Random.Int(3) == 0)) {
				Buff.detach(hero, ArisastarRank2.class);
				Buff.prolong(owner, ArisastarRank3.class, ArisastarRank3.DURATION);
			} else if (Dungeon.hero.belongings.weapon() instanceof ArisaKeyboard && hero.buff(ArisastarRank3.class) != null && (Random.Int(3) == 0)) {
				Buff.prolong(owner, ArisastarRank3.class, ArisastarRank3.DURATION);
			}
			if (Dungeon.isChallenged(Challenges.ANTI_FUMO) && Dungeon.hero.belongings.weapon() instanceof ArisaKeyboard) {
				Buff.prolong(owner, Weakness.class, Weakness.DURATION);
				Buff.prolong(owner, Vulnerable.class, Vulnerable.DURATION);
				Buff.prolong(owner, Hex.class, Hex.DURATION);
				Buff.prolong(owner, Cripple.class, Cripple.DURATION);
			}
		}
		return super.damageRoll(owner);
	}
	@Override
	public void execute(final Hero hero, String action) {

		super.execute(hero, action);

		if (action.equals(AC_XYZ) && curItem.isEquipped(hero)){
			GLog.w( Messages.get(Stylus.class, "xyzbeforeunequip") );
		} else if (action.equals(AC_XYZ) && curItem.level() == 7) {
			GameScene.selectItem(itemSelector);
		}
	}

	private final WndBag.ItemSelector itemSelector = new WndBag.ItemSelector() {

		@Override
		public String textPrompt() {
			return Messages.get(Stylus.class, "promptxyz");
		}

		@Override
		public Class<? extends Bag> preferredBag() {
			return Belongings.Backpack.class;
		}

		@Override
		public boolean itemSelectable(Item item) {
			return item instanceof Greatshield;
		}

		@Override
		public void onSelect(Item item) {
			if (item != null && item.isEquipped(curUser)){
				GLog.w( Messages.get(Stylus.class, "xyzbeforeunequip") );
			} else if (item != null && item.level() == 7){
				curItem.detach(curUser.belongings.backpack);
				item.detach(curUser.belongings.backpack);
				HellKeyboard hkb = new HellKeyboard();
				hkb.identify().collect();
			}
		}
	};
}