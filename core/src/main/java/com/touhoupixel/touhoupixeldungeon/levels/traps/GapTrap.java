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

package com.touhoupixel.touhoupixeldungeon.levels.traps;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.TouhouPixelDungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.TormentTailsman;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.darts.PoisonDart;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.MissileSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;
import com.watabou.utils.Random;

public class GapTrap extends Trap {

	{
		color = GREEN;
		shape = DIAMOND;

		avoidsHallways = false;
	}

	@Override
	public void activate() {
		Char c = Actor.findChar(pos);
		if (c != null) {
			if (c instanceof Hero) {
				Hero hero = (Hero) c;
				Char enemy = hero.enemy();
				if (Statistics.altRoute) {
					Statistics.altRoute = false;
					if (hero.pointsInTalent(Talent.GAP_TAILSMAN) == 1){
						TormentTailsman tt = new TormentTailsman();
						tt.quantity(2).collect();
					}
					if (hero.pointsInTalent(Talent.GAP_TAILSMAN) == 2){
						TormentTailsman tt = new TormentTailsman();
						tt.quantity(3).collect();
					}
					if (hero.pointsInTalent(Talent.GAP_HEAL) == 1) {
						hero.HP = Math.min(hero.HP + 20, hero.HT);
						hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
					}
					if (hero.pointsInTalent(Talent.GAP_HEAL) == 2) {
						hero.HP = Math.min(hero.HP + 30, hero.HT);
						hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
					}
					if (hero.pointsInTalent(Talent.GAP_TRIPLESPEED) == 1) {
						Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION/5f);
					}
					if (hero.pointsInTalent(Talent.GAP_TRIPLESPEED) == 2) {
						Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION/2f);
					}
					if (hero.pointsInTalent(Talent.GAP_TRIPLESPEED) == 3) {
						Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION);
					}
					if (hero.pointsInTalent(Talent.GAP_HISOU) == 1) {
						Buff.prolong(hero, Hisou.class, Hisou.DURATION/5f);
					}
					if (hero.pointsInTalent(Talent.GAP_HISOU) == 2) {
						Buff.prolong(hero, Hisou.class, Hisou.DURATION/2f);
					}
					if (hero.pointsInTalent(Talent.GAP_HISOU) == 3) {
						Buff.prolong(hero, Hisou.class, Hisou.DURATION);
					}
				} else {
					Statistics.altRoute = true;
					if (hero.pointsInTalent(Talent.GAP_TAILSMAN) == 1){
						TormentTailsman tt = new TormentTailsman();
						tt.quantity(2).collect();
					}
					if (hero.pointsInTalent(Talent.GAP_TAILSMAN) == 2){
						TormentTailsman tt = new TormentTailsman();
						tt.quantity(3).collect();
					}
					if (hero.pointsInTalent(Talent.GAP_HEAL) == 1) {
						hero.HP = Math.min(hero.HP + 20, hero.HT);
						hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
					}
					if (hero.pointsInTalent(Talent.GAP_HEAL) == 2) {
						hero.HP = Math.min(hero.HP + 30, hero.HT);
						hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
					}
					if (hero.pointsInTalent(Talent.GAP_TRIPLESPEED) == 1) {
						Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION/5f);
					}
					if (hero.pointsInTalent(Talent.GAP_TRIPLESPEED) == 2) {
						Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION/2f);
					}
					if (hero.pointsInTalent(Talent.GAP_TRIPLESPEED) == 3) {
						Buff.prolong(hero, Triplespeed.class, Triplespeed.DURATION);
					}
					if (hero.pointsInTalent(Talent.GAP_HISOU) == 1) {
						Buff.prolong(hero, Hisou.class, Hisou.DURATION/5f);
					}
					if (hero.pointsInTalent(Talent.GAP_HISOU) == 2) {
						Buff.prolong(hero, Hisou.class, Hisou.DURATION/2f);
					}
					if (hero.pointsInTalent(Talent.GAP_HISOU) == 3) {
						Buff.prolong(hero, Hisou.class, Hisou.DURATION);
					}
				}

				GLog.w(Messages.get(this, "alarm"));
				GameScene.flash(0x80FFFFFF);
				Sample.INSTANCE.play(Assets.Sounds.TELEPORT);
			}
		}
	}
}
