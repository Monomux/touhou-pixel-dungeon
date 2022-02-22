package com.touhoupixel.touhoupixeldungeon.items.tailsmans;

import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;

public class TormentTailsman extends Tailsman {
    {
        image = ItemSpriteSheet.TORMENT;
    }

    @Override
    protected void onThrow(int cell) {

        Char ch = Actor.findChar( cell );

        if (ch != null && !ch.properties().contains(Char.Property.BOSS) && ch.HP > 1) {
            ch.HP /= 2;
        }
    }
}
