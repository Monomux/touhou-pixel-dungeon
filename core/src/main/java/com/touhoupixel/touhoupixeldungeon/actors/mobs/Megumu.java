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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfTriplespeed;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.sprites.MegumuSprite;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Megumu extends Mob {

    {
        spriteClass = MegumuSprite.class;

        if (Dungeon.depth > 50){
            HP = HT = 571;
        } else HP = HT = 156;

        if (Dungeon.depth > 50){
            defenseSkill = 94;
        } else defenseSkill = 44;

        if (Dungeon.depth > 50){
            EXP = 71;
        } else EXP = 21;

        if (Dungeon.depth > 50){
            maxLvl = 95;
        } else maxLvl = 45;

        baseSpeed = 2f;

        flying = true;

        loot = new PotionOfTriplespeed();
        lootChance = 0.05f;

        properties.add(Property.YOKAI);
        properties.add(Property.PURE);
    }

    private int pumpedUp = 0;
    private int healInc = 1;

    @Override
    public int damageRoll() {
        int min = 8;
        int max = 10;
        if (pumpedUp > 0) {
            Buff.prolong( enemy, Silence.class, Silence.DURATION );
            pumpedUp = 0;
            return Random.NormalIntRange( min*3, max*3 );
        } else {
            return Random.NormalIntRange( min, max );
        }
    }

    @Override
    public int attackSkill( Char target ) {
        int attack = 80;
        if (HP*2 <= HT) attack = 100;
        if (pumpedUp > 0) attack *= 2;
        return attack;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(0, 2);
    }

    @Override
    protected boolean canAttack( Char enemy ) {
        if (pumpedUp > 0){
            //we check both from and to in this case as projectile logic isn't always symmetrical.
            //this helps trim out BS edge-cases
            return Dungeon.level.distance(enemy.pos, pos) <= 2
                    && new Ballistica( pos, enemy.pos, Ballistica.PROJECTILE).collisionPos == enemy.pos
                    && new Ballistica( enemy.pos, pos, Ballistica.PROJECTILE).collisionPos == pos;
        } else {
            return super.canAttack(enemy);
        }
    }

    @Override
    public void updateSpriteState() {
        super.updateSpriteState();

        if (pumpedUp > 0){
            ((MegumuSprite)sprite).pumpUp( pumpedUp );
        }
    }

    @Override
    protected boolean doAttack( Char enemy ) {
        if (pumpedUp == 1) {
            pumpedUp++;
            ((MegumuSprite)sprite).pumpUp( pumpedUp );

            spend( attackDelay() );

            return true;
        } else if (pumpedUp >= 2 || Random.Int( 0 ) > 0) {

            boolean visible = Dungeon.level.heroFOV[pos];

            if (visible) {
                if (pumpedUp >= 2) {
                    ((MegumuSprite) sprite).pumpAttack();
                } else {
                    sprite.attack(enemy.pos);
                }
            } else {
                if (pumpedUp >= 2){
                    ((MegumuSprite)sprite).triggerEmitters();
                }
                attack( enemy );
            }

            spend( attackDelay() );

            return !visible;

        } else {

            pumpedUp++;
            pumpedUp++;
            pumpedUp++;
            pumpedUp++;
            pumpedUp++;
            pumpedUp++;
            pumpedUp++;
            }

            ((MegumuSprite)sprite).pumpUp( pumpedUp );

            spend( attackDelay() );

            return true;
        }

    @Override
    public boolean attack( Char enemy, float dmgMulti, float dmgBonus, float accMulti ) {
        boolean result = super.attack( enemy, dmgMulti, dmgBonus, accMulti );
        pumpedUp = 0;
        return result;
    }

    @Override
    protected boolean getCloser( int target ) {
        if (pumpedUp != 0) {
            pumpedUp = 0;
            sprite.idle();
        }
        return super.getCloser( target );
    }

    private final String PUMPEDUP = "pumpedup";
    private final String HEALINC = "healinc";

    @Override
    public void storeInBundle( Bundle bundle ) {

        super.storeInBundle( bundle );

        bundle.put( PUMPEDUP , pumpedUp );
        bundle.put( HEALINC, healInc );
    }

    @Override
    public void restoreFromBundle( Bundle bundle ) {

        super.restoreFromBundle( bundle );

        //if check is for pre-0.9.3 saves
        healInc = bundle.getInt(HEALINC);

    }

}
