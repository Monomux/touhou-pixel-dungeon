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
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bleeding;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.DuelOpponent;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FrostBrandBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfBurning;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfIdentify;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfLullaby;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfMirrorImage;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRage;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRecharging;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRetribution;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRouteChange;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfSilence;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfSlowness;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTerror;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTransmutation;
import com.touhoupixel.touhoupixeldungeon.items.wands.CursedWand;
import com.touhoupixel.touhoupixeldungeon.levels.traps.BurningTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.DestroyArmorTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.ExplosiveTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.FlashingTrap;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.ArrayList;

public class PlayMat extends MeleeWeapon {

	{
		image = ItemSpriteSheet.PLAY_MAT;
		hitSound = Assets.Sounds.HIT;
		hitSoundPitch = 1f;

		tier = 3;
	}

	@Override
	public int max(int lvl) {
		return  4*(tier+1) +
				lvl*(tier);
	}

	@Override
	public int warpResistFactor( Char owner ) {
		return 3;
	}

	@Override
	public ArrayList<String> actions(Hero hero ) {
		ArrayList<String> actions = super.actions( hero );
		actions.remove(AC_XYZ);
		return actions;
	}

	@Override
	public int damageRoll(Char owner) {
		if (owner instanceof Hero) {
			Hero hero = (Hero) owner;
			Char enemy = hero.enemy();
			if (Dungeon.hero.belongings.weapon() instanceof PlayMat && (Random.Int(6) == 0) && Statistics.cardDraw < 60 && enemy.buff(DuelOpponent.class) == null) {
				Buff.prolong(enemy, DuelOpponent.class, DuelOpponent.DURATION);
				switch (Random.Int(3)) {
					case 0:
					default:
						Buff.prolong(enemy, Weakness.class, Weakness.DURATION);
						break;
					case 1:
						Buff.prolong(enemy, Vulnerable.class, Vulnerable.DURATION);
						break;
					case 2:
						Buff.prolong(enemy, Hex.class, Hex.DURATION);
						break;
				}
				switch (Random.Int(3)) {
					case 0:
					default:
						Buff.prolong(hero, Weakness.class, Weakness.DURATION);
						break;
					case 1:
						Buff.prolong(hero, Vulnerable.class, Vulnerable.DURATION);
						break;
					case 2:
						Buff.prolong(hero, Hex.class, Hex.DURATION);
						break;
				}
				Statistics.cardDraw += 1;
				GameScene.flash(0x80FFFFFF);
				Sample.INSTANCE.play(Assets.Sounds.BLAST);
				CursedWand.cursedEffect(this, hero, enemy);
				switch (Random.Int(15)) {
					case 0:
					default:
						ScrollOfLullaby duel1 = new ScrollOfLullaby();
						duel1.identify().collect();
						break;
					case 1:
						ScrollOfRouteChange duel2 = new ScrollOfRouteChange();
						duel2.identify().collect();
						break;
					case 2:
						ScrollOfIdentify duel3 = new ScrollOfIdentify();
						duel3.identify().collect();
						break;
					case 3:
						ScrollOfRemoveCurse duel4 = new ScrollOfRemoveCurse();
						duel4.identify().collect();
						break;
					case 4:
						ScrollOfMagicMapping duel5 = new ScrollOfMagicMapping();
						duel5.identify().collect();
						break;
					case 5:
						ScrollOfTeleportation duel6 = new ScrollOfTeleportation();
						duel6.identify().collect();
						break;
					case 6:
						ScrollOfRecharging duel7 = new ScrollOfRecharging();
						duel7.identify().collect();
						break;
					case 7:
						ScrollOfMirrorImage duel8 = new ScrollOfMirrorImage();
						duel8.identify().collect();
						break;
					case 8:
						ScrollOfTerror duel9 = new ScrollOfTerror();
						duel9.identify().collect();
						break;
					case 9:
						ScrollOfRage duel10 = new ScrollOfRage();
						duel10.identify().collect();
						break;
					case 10:
						ScrollOfRetribution duel11 = new ScrollOfRetribution();
						duel11.identify().collect();
						break;
					case 11:
						ScrollOfTransmutation duel12 = new ScrollOfTransmutation();
						duel12.identify().collect();
						break;
					case 12:
						ScrollOfSlowness duel13 = new ScrollOfSlowness();
						duel13.identify().collect();
						break;
					case 13:
						ScrollOfBurning duel14 = new ScrollOfBurning();
						duel14.identify().collect();
						break;
					case 14:
						ScrollOfSilence duel15 = new ScrollOfSilence();
						duel15.identify().collect();
						break;
				}
				if (Dungeon.hero.belongings.weapon() instanceof PlayMat && Statistics.cardDraw > 59) {
					if (Statistics.cardDrawalt == 0) {
						GLog.w(Messages.get(this, "nocards"));
						Statistics.cardDrawalt += 1;
					}
				}
			}
		}
		return super.damageRoll(owner);
	}
}