package com.touhoupixel.touhoupixeldungeon.items.tailsmans;

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Amok;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.items.armor.MaxwellArmor;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.BArray;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.utils.PathFinder;

public class SwapTailsman extends Tailsman {
    {
        image = ItemSpriteSheet.SWAP;
    }

    private static Ballistica throwPath;

    @Override
    public int throwPos(Hero user, int dst) {
        throwPath = new Ballistica(user.pos, dst, Ballistica.PROJECTILE);
        return throwPath.collisionPos;
    }

    @Override
    protected void onThrow(int cell) {

        Char ch = Actor.findChar(cell);

        if (Dungeon.hero.belongings.armor() instanceof MaxwellArmor) {
            GLog.w(Messages.get(ScrollOfTeleportation.class, "tele_interrupt"));
        } else if (ch != null) {
            cell = throwPath.path.get(throwPath.dist);
            throwPath = null;
            super.onThrow(cell);

            ch.move(curUser.pos);
            ch.sprite.move(cell, curUser.pos);

            ScrollOfTeleportation.teleportToLocation(curUser, cell);
        }
    }
}