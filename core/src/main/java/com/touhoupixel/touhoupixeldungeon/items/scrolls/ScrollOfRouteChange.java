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

package com.touhoupixel.touhoupixeldungeon.items.scrolls;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Badges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Mob;
import com.touhoupixel.touhoupixeldungeon.effects.Flare;
import com.touhoupixel.touhoupixeldungeon.effects.Identification;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.SwapTailsman;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.TormentTailsman;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;

public class ScrollOfRouteChange extends Scroll {

	{
		icon = ItemSpriteSheet.Icons.SCROLL_ROUTECHANGE;

		bones = true;
	}

	@Override
	public void doRead() {
		if (Statistics.altRoute){
			Statistics.altRoute = false;
			if (curUser.pointsInTalent(Talent.GAP_TAILSMAN) == 1){
				TormentTailsman tt = new TormentTailsman();
				tt.quantity(2).collect();
			}
			if (curUser.pointsInTalent(Talent.GAP_TAILSMAN) == 2){
				TormentTailsman tt = new TormentTailsman();
				tt.quantity(3).collect();
			}
			if (curUser.pointsInTalent(Talent.GAP_HEAL) == 1){
				curUser.HP = Math.min(curUser.HP + 20, curUser.HT);
				curUser.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
			}
			if (curUser.pointsInTalent(Talent.GAP_HEAL) == 2){
				curUser.HP = Math.min(curUser.HP + 30, curUser.HT);
				curUser.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
			}
			if (curUser.pointsInTalent(Talent.GAP_TRIPLESPEED) == 1) {
				Buff.prolong(curUser, Triplespeed.class, Triplespeed.DURATION/5f);
			}
			if (curUser.pointsInTalent(Talent.GAP_TRIPLESPEED) == 2) {
				Buff.prolong(curUser, Triplespeed.class, Triplespeed.DURATION/2f);
			}
			if (curUser.pointsInTalent(Talent.GAP_TRIPLESPEED) == 3) {
				Buff.prolong(curUser, Triplespeed.class, Triplespeed.DURATION);
			}
			if (curUser.pointsInTalent(Talent.GAP_HISOU) == 1) {
				Buff.prolong(curUser, Hisou.class, Hisou.DURATION/5f);
			}
			if (curUser.pointsInTalent(Talent.GAP_HISOU) == 2) {
				Buff.prolong(curUser, Hisou.class, Hisou.DURATION/2f);
			}
			if (curUser.pointsInTalent(Talent.GAP_HISOU) == 3) {
				Buff.prolong(curUser, Hisou.class, Hisou.DURATION);
			}
		} else {
			Statistics.altRoute = true;
			if (curUser.pointsInTalent(Talent.GAP_TAILSMAN) == 1){
				TormentTailsman tt = new TormentTailsman();
				tt.quantity(2).collect();
			}
			if (curUser.pointsInTalent(Talent.GAP_TAILSMAN) == 2){
				TormentTailsman tt = new TormentTailsman();
				tt.quantity(3).collect();
			}
			if (curUser.pointsInTalent(Talent.GAP_HEAL) == 1){
				curUser.HP = Math.min(curUser.HP + 20, curUser.HT);
				curUser.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
			}
			if (curUser.pointsInTalent(Talent.GAP_HEAL) == 2){
				curUser.HP = Math.min(curUser.HP + 30, curUser.HT);
				curUser.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
			}
			if (curUser.pointsInTalent(Talent.GAP_TRIPLESPEED) == 1) {
				Buff.prolong(curUser, Triplespeed.class, Triplespeed.DURATION/5f);
			}
			if (curUser.pointsInTalent(Talent.GAP_TRIPLESPEED) == 2) {
				Buff.prolong(curUser, Triplespeed.class, Triplespeed.DURATION/2f);
			}
			if (curUser.pointsInTalent(Talent.GAP_TRIPLESPEED) == 3) {
				Buff.prolong(curUser, Triplespeed.class, Triplespeed.DURATION);
			}
			if (curUser.pointsInTalent(Talent.GAP_HISOU) == 1) {
				Buff.prolong(curUser, Hisou.class, Hisou.DURATION/5f);
			}
			if (curUser.pointsInTalent(Talent.GAP_HISOU) == 2) {
				Buff.prolong(curUser, Hisou.class, Hisou.DURATION/2f);
			}
			if (curUser.pointsInTalent(Talent.GAP_HISOU) == 3) {
				Buff.prolong(curUser, Hisou.class, Hisou.DURATION);
			}
		}

		identify();

		GameScene.flash(0x80FFFFFF);

		GLog.i( Messages.get(this, "change") );

		curUser.sprite.centerEmitter().start( Speck.factory( Speck.BUBBLE ), 0.3f, 3 );
		Sample.INSTANCE.play( Assets.Sounds.READ );

		readAnimation();
	}

	@Override
	public int value() {
		return isKnown() ? 40 * quantity : super.value();
	}
}
