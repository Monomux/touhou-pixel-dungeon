package com.touhoupixel.touhoupixeldungeon.items.tailsmans;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Amok;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bleeding;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Drowsy;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Eirin;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfLightHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfStrength;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfInvulnerability;
import com.touhoupixel.touhoupixeldungeon.levels.traps.BurningTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.DestroyArmorTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.ExplosiveTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.FlashingTrap;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class ChaosTailsman extends Tailsman {
    {
        image = ItemSpriteSheet.CHAOS;
    }

    @Override
    protected void onThrow(int cell) {

        Char ch = Actor.findChar(cell);

        if (ch != null && !ch.properties().contains(Char.Property.BOSS)) {
            switch (Random.Int(7)) {
                case 0:
                default:
                    Buff.prolong(ch, Weakness.class, Weakness.DURATION);
                    break;
                case 1:
                    Buff.prolong(ch, Vulnerable.class, Vulnerable.DURATION);
                    break;
                case 2:
                    Buff.prolong(ch, Hex.class, Hex.DURATION);
                    break;
                case 3:
                    Buff.prolong(ch, Slow.class, Slow.DURATION);
                    break;
                case 4:
                    Buff.affect(ch, Drowsy.class);
                    break;
                case 5:
                    new ExplosiveTrap().set(cell).activate();
                    break;
                case 6:
                    GameScene.flash(0x80FFFFFF);
                    Sample.INSTANCE.play( Assets.Sounds.BLAST );
                    ch.die(null);
                    if (ch.properties().contains(Char.Property.ELIXIR)) {
                        switch (Random.Int(2)) {
                            case 0:
                            default:
                                PotionOfInvulnerability Poi = new PotionOfInvulnerability();
                                Poi.quantity(1).collect();
                                break;
                            case 1:
                                PotionOfStrength Pos = new PotionOfStrength();
                                Pos.quantity(1).collect();
                                break;
                        }
                    } else if (!ch.properties().contains(Char.Property.ELIXIR)) {
                        PotionOfLightHealing Polh = new PotionOfLightHealing();
                        Polh.quantity(1).collect();
                    }
            }
        }
    }
}