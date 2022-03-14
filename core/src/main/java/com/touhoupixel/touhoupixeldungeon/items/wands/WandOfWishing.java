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

package com.touhoupixel.touhoupixeldungeon.items.wands;

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.NoWishing;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.PotionPreserve;
import com.touhoupixel.touhoupixeldungeon.effects.Beam;
import com.touhoupixel.touhoupixeldungeon.effects.particles.BloodParticle;
import com.touhoupixel.touhoupixeldungeon.items.Generator;
import com.touhoupixel.touhoupixeldungeon.items.potions.Potion;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.Scroll;
import com.touhoupixel.touhoupixeldungeon.items.stones.Runestone;
import com.touhoupixel.touhoupixeldungeon.items.tailsmans.Tailsman;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MagesStaff;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.tiles.DungeonTilemap;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.utils.Bundle;
import com.watabou.utils.Callback;
import com.watabou.utils.PointF;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

public class WandOfWishing extends Wand {

	{
		image = ItemSpriteSheet.WAND_WISHING;

		collisionProperties = Ballistica.PROJECTILE;
	}

	protected int initialCharges() {
		return 1;
	}

	private boolean freeCharge = false;

	@Override
	public void onZap(Ballistica beam) {

		if (curUser.buff(NoWishing.class) != null){
			GLog.w(Messages.get(this, "nowishing"));
		} else if (Statistics.upgradesUsed > 2) {
			Generator.Category c = Generator.Category.WEP_T5;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
			Generator.Category c2 = Generator.Category.TAILSMAN;
			Tailsman w2 = (Tailsman) Reflection.newInstance(c2.classes[Random.chances(c2.probs)]);
			w2.collect();
			Generator.Category c3 = Generator.Category.POTION;
			Potion w3 = (Potion) Reflection.newInstance(c3.classes[Random.chances(c3.probs)]);
			w3.collect();
			Generator.Category c4 = Generator.Category.SCROLL;
			Scroll w4 = (Scroll) Reflection.newInstance(c4.classes[Random.chances(c4.probs)]);
			w4.collect();
			Generator.Category c5 = Generator.Category.STONE;
			Runestone w5 = (Runestone) Reflection.newInstance(c5.classes[Random.chances(c5.probs)]);
			w5.collect();
			Buff.prolong(curUser, NoWishing.class, NoWishing.DURATION);
			GLog.w(Messages.get(this, "wishingsuccess"));
			GameScene.flash(0x80FFFFFF);
		} else if (curUser.lvl < 6) {
			Generator.Category c = Generator.Category.WEP_T2;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
			Buff.prolong(curUser, NoWishing.class, NoWishing.DURATION);
			GLog.w(Messages.get(this, "wishingsuccess"));
			GameScene.flash(0x80FFFFFF);
		} else if (curUser.lvl < 11) {
			Generator.Category c = Generator.Category.WEP_T3;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
			Buff.prolong(curUser, NoWishing.class, NoWishing.DURATION);
			GLog.w(Messages.get(this, "wishingsuccess"));
			GameScene.flash(0x80FFFFFF);
		} else if (curUser.lvl < 16) {
			Generator.Category c = Generator.Category.WEP_T4;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
			Buff.prolong(curUser, NoWishing.class, NoWishing.DURATION);
			GLog.w(Messages.get(this, "wishingsuccess"));
			GameScene.flash(0x80FFFFFF);
		} else {
			Generator.Category c = Generator.Category.WEP_T5;
			MeleeWeapon w = (MeleeWeapon) Reflection.newInstance(c.classes[Random.chances(c.probs)]);
			w.collect();
			Buff.prolong(curUser, NoWishing.class, NoWishing.DURATION);
			GLog.w(Messages.get(this, "wishingsuccess"));
			GameScene.flash(0x80FFFFFF);
		}
	}

	@Override
	public void onHit(MagesStaff staff, Char attacker, Char defender, int damage) {
			Buff.prolong(attacker, PotionPreserve.class, PotionPreserve.DURATION);
			attacker.sprite.emitter().burst(BloodParticle.BURST, 20);
		}

	@Override
	public void fx(Ballistica beam, Callback callback) {
		curUser.sprite.parent.add(
				new Beam.HealthRay(curUser.sprite.center(), DungeonTilemap.raisedTileCenterToWorld(beam.collisionPos)));
		callback.call();
	}

	@Override
	public void staffFx(MagesStaff.StaffParticle particle) {
		particle.color( 0xCC0000 );
		particle.am = 0.6f;
		particle.setLifespan(1f);
		particle.speed.polar( Random.Float(PointF.PI2), 2f );
		particle.setSize( 1f, 2f);
		particle.radiateXY(0.5f);
	}

	@Override
	public String statsDesc() {
		int selfDMG = Math.round(Dungeon.hero.HT*0.05f);
		if (levelKnown)
			return Messages.get(this, "stats_desc", selfDMG, selfDMG + 3*buffedLvl(), 5+buffedLvl(), 3+buffedLvl()/2, 6+ buffedLvl());
		else
			return Messages.get(this, "stats_desc", selfDMG, selfDMG, 5, 3, 6);
	}

	private static final String FREECHARGE = "freecharge";

	@Override
	public void restoreFromBundle(Bundle bundle) {
		super.restoreFromBundle(bundle);
		freeCharge = bundle.getBoolean( FREECHARGE );
	}

	@Override
	public void storeInBundle(Bundle bundle) {
		super.storeInBundle(bundle);
		bundle.put( FREECHARGE, freeCharge );
	}

}
