package com.touhoupixel.touhoupixeldungeon.items.tailsmans;

import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Paralysis;
import com.touhoupixel.touhoupixeldungeon.levels.traps.ExplosiveTrap;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;

public class ExplosionTailsman extends Tailsman {
    {
        image = ItemSpriteSheet.EXPLOSION;
    }

    @Override
    protected void onThrow(int cell) {

        Char ch = Actor.findChar( cell );

        if (ch != null){
            new ExplosiveTrap().set(cell).activate();
        }
    }
}