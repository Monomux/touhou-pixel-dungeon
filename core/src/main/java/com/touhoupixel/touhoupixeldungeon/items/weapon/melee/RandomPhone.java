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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AnkhInvulnerability;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Light;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MindVision;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.PotionPreserve;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Stamina;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfStrength;
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
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class RandomPhone extends MeleeWeapon {

	{
		image = ItemSpriteSheet.RANDOMPHONE;
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
	public int warpResistFactor(Char owner) {
		return 2;
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.remove(AC_XYZ);
		return actions;
	}

	@Override
	public int damageRoll(Char owner) {
		if (owner instanceof Hero) {
			Hero hero = (Hero) owner;
			Char enemy = hero.enemy();
			Statistics.happyworldCounter += 1;
			Dungeon.gold -= 25;
				if (Dungeon.hero.belongings.weapon() instanceof RandomPhone && (Dungeon.gold > 24) && !enemy.properties().contains(Char.Property.BOSS)) {
					if (Statistics.happyworldCounter > 10) {
						Statistics.happyworldCounter = 0;
						switch (Random.Int(7)) {
							case 0:
							default:
								GameScene.flash(0x80FFFFFF);
								Sample.INSTANCE.play(Assets.Sounds.BLAST);
								enemy.die(null);
							case 1:
								Buff.prolong(hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION * 2f);
								break;
							case 2:
								Buff.prolong(hero, Might.class, Might.DURATION * 2f);
								break;
							case 3:
								Buff.prolong(hero, Hisou.class, Hisou.DURATION * 2f);
								break;
							case 4:
								Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION * 2f);
								break;
							case 5:
								Dungeon.energy += 5;
								break;
							case 6:
								PotionOfStrength Postr = new PotionOfStrength();
								Postr.collect();
								break;
						}
					} else if (Random.Int(33) == 0) {
						switch (Random.Int(7)) {
							case 0:
							default:
								GameScene.flash(0x80FFFFFF);
								Sample.INSTANCE.play(Assets.Sounds.BLAST);
								enemy.die(null);
							case 1:
								Buff.prolong(hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION * 2f);
								break;
							case 2:
								Buff.prolong(hero, Might.class, Might.DURATION * 2f);
								break;
							case 3:
								Buff.prolong(hero, Hisou.class, Hisou.DURATION * 2f);
								break;
							case 4:
								Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION * 2f);
								break;
							case 5:
								Dungeon.energy += 5;
								break;
							case 6:
								PotionOfStrength Postr = new PotionOfStrength();
								Postr.collect();
								break;
						}
					} else if (Random.Int(12) == 0) {
						switch (Random.Int(7)) {
							case 0:
							default:
								enemy.damage(30, enemy);
							case 1:
								Buff.prolong(hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION / 3f);
								break;
							case 2:
								Buff.prolong(hero, Might.class, Might.DURATION / 10f);
								break;
							case 3:
								Buff.prolong(hero, Hisou.class, Hisou.DURATION / 10f);
								break;
							case 4:
								Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION / 10f);
								break;
							case 5:
								Buff.prolong(hero, PotionPreserve.class, PotionPreserve.DURATION / 5f);
								break;
							case 6:
								Dungeon.energy += 1;
								break;
						}
					}
				} else {
						switch (Random.Int(7)) {
							case 0:
							default:
								enemy.damage(10, enemy);
							case 1:
								Buff.prolong(hero, Light.class, Light.DURATION/10f);
								break;
							case 2:
								Buff.prolong(hero, Bless.class, Bless.DURATION/10f);
								break;
							case 3:
								Buff.prolong(hero, MindVision.class, MindVision.DURATION/10f);
								break;
							case 4:
								Buff.prolong(hero, Haste.class, Haste.DURATION/10f);
								break;
							case 5:
								Buff.prolong(hero, Stamina.class, Stamina.DURATION/25f);
								break;
							case 6:
								if (Random.Int(2) == 0) {
									Dungeon.energy += 1;
									break;
						}
					}
				}
			}
		return super.damageRoll(owner);
	}
}