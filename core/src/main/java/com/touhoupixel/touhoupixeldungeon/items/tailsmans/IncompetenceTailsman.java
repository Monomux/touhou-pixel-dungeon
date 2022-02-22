package com.touhoupixel.touhoupixeldungeon.items.tailsmans;

import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Amok;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;

public class IncompetenceTailsman extends Tailsman {
    {
        image = ItemSpriteSheet.INCOMPETENCE;
    }

    @Override
    protected void onThrow(int cell) {

        Char ch = Actor.findChar( cell );

        if (ch != null){
            Buff.prolong( ch, Incompetence.class, Incompetence.DURATION );
        }
    }
}
