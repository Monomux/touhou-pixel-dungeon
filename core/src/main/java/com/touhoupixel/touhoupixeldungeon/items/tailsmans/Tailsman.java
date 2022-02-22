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

package com.touhoupixel.touhoupixeldungeon.items.tailsmans;

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank1;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank2;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank3;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Corruption;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MagicImmune;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Momentum;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.PinCushion;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.bags.Bag;
import com.touhoupixel.touhoupixeldungeon.items.bags.MagicalHolster;
import com.touhoupixel.touhoupixeldungeon.items.bags.TailsmanHolder;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfSharpshooting;
import com.touhoupixel.touhoupixeldungeon.items.weapon.SpiritBow;
import com.touhoupixel.touhoupixeldungeon.items.weapon.Weapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.enchantments.Projecting;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.MissileWeapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.darts.Dart;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

import java.util.ArrayList;

abstract public class Tailsman extends Item {

    {
        stackable = true;

        bones = true;

        defaultAction = AC_THROW;
        usesTargeting = true;
    }

    public boolean holster;

    public int tier;

    protected MissileWeapon parent;

    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = super.actions(hero);
        return actions;
    }

    @Override
    public boolean collect(Bag container) {
        if (container instanceof MagicalHolster) holster = true;
        return super.collect(container);
    }

    @Override
    public void doThrow(Hero hero) {
        parent = null; //reset parent before throwing, just incase
        super.doThrow(hero);
    }

    @Override
    protected void onThrow(int cell) {
        Char enemy = Actor.findChar(cell);
        if (enemy == null || enemy == curUser) {
            parent = null;
            super.onThrow(cell);
        }
    }

    @Override
    public Item random() {
        if (!stackable) return this;

        quantity = 3;
        if (Random.Int(2) == 0) {
            quantity++;
            if (Random.Int(3) == 0) {
                quantity++;
                if (Random.Int(4) == 0) {
                    quantity++;
                }
            }
        }
        return this;
    }

    protected void rangedMiss(int cell) {
        parent = null;
        super.onThrow(cell);
    }

    @Override
    public boolean doPickUp(Hero hero, int pos) {
        parent = null;
        return super.doPickUp(hero, pos);
    }

    @Override
    public boolean isIdentified() {
        return true;
    }

    @Override
    public int value() {
        return 6 * tier * quantity * (level() + 1);
    }

    public static class PlaceHolder extends Tailsman {

        {
            image = ItemSpriteSheet.TAILSMANHOLD;
        }

        @Override
        public boolean isSimilar(Item item) {
            return item instanceof Tailsman;
        }

        @Override
        public String info() {

            String info = desc();
            info += Messages.get(this, "desc");
            return info;
        }
    }
}