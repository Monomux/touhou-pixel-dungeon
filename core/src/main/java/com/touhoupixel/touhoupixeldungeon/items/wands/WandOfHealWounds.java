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
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiHeal;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Healing;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Levitation;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Light;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MindVision;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.NoWishing;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.PotionPreserve;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
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

public class WandOfHealWounds extends Wand {

	{
		image = ItemSpriteSheet.WAND_HEALWOUNDS;

		collisionProperties = Ballistica.PROJECTILE;

		unique = true;
		bones = false;
	}

	private boolean freeCharge = false;

	@Override
	public void onZap(Ballistica beam) {
		if ( curUser.buff(AntiHeal.class) != null ) {
			curUser.damage(curUser.HP / 2, this);
		} else curUser.HP = Math.min(curUser.HP + 12*Dungeon.hero.pointsInTalent(Talent.HEALWAND_SIMPLE) + Dungeon.hero.pointsInTalent(Talent.HEALWAND_LVL)*curUser.lvl + curUser.HT/4, curUser.HT);
		if (curUser.buff( Silence.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_SILENCE) == 1) {
			curUser.HP = Math.min(curUser.HP + 15, curUser.HT);
		}
		if (curUser.buff( Silence.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_SILENCE) == 2) {
			curUser.HP = Math.min(curUser.HP + 30, curUser.HT);
		}
		if (curUser.buff( MindVision.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_MV_AND_LEV) == 1 || curUser.buff( Levitation.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_MV_AND_LEV) == 1) {
			curUser.HP = Math.min(curUser.HP + 15, curUser.HT);
		}
		if (curUser.buff( MindVision.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_MV_AND_LEV) == 2 || curUser.buff( Levitation.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_MV_AND_LEV) == 2) {
			curUser.HP = Math.min(curUser.HP + 30, curUser.HT);
		}
		if (curUser.buff( MindVision.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_MV_AND_LEV) == 3 || curUser.buff( Levitation.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_MV_AND_LEV) == 3) {
			curUser.HP = Math.min(curUser.HP + 45, curUser.HT);
		}
		if (curUser.buff( Light.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_LIGHT_AND_BLESS) == 1 || curUser.buff( Bless.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_LIGHT_AND_BLESS) == 1) {
			curUser.HP = Math.min(curUser.HP + 15, curUser.HT);
		}
		if (curUser.buff( Light.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_LIGHT_AND_BLESS) == 2 || curUser.buff( Bless.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_LIGHT_AND_BLESS) == 2) {
			curUser.HP = Math.min(curUser.HP + 30, curUser.HT);
		}
		if (curUser.buff( Light.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_LIGHT_AND_BLESS) == 3 || curUser.buff( Bless.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_LIGHT_AND_BLESS) == 3) {
			curUser.HP = Math.min(curUser.HP + 45, curUser.HT);
		}
		if (curUser.buff( Haste.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_THREESPEED) == 1 || curUser.buff( Doublespeed.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_THREESPEED) == 1 || curUser.buff( Triplespeed.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_THREESPEED) == 1) {
			curUser.HP = Math.min(curUser.HP + 15, curUser.HT);
		}
		if (curUser.buff( Haste.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_THREESPEED) == 2 || curUser.buff( Doublespeed.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_THREESPEED) == 2 || curUser.buff( Triplespeed.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_THREESPEED) == 2) {
			curUser.HP = Math.min(curUser.HP + 30, curUser.HT);
		}
		if (curUser.buff( Haste.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_THREESPEED) == 3 || curUser.buff( Doublespeed.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_THREESPEED) == 3 || curUser.buff( Triplespeed.class ) != null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_THREESPEED) == 3) {
			curUser.HP = Math.min(curUser.HP + 45, curUser.HT);
		}
		if (Dungeon.hero.belongings.weapon() == null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_NURSE) == 1) {
			curUser.HP = Math.min(curUser.HP + 20, curUser.HT);
		}
		if (Dungeon.hero.belongings.weapon() == null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_NURSE) == 2) {
			curUser.HP = Math.min(curUser.HP + 40, curUser.HT);
		}
		if (Dungeon.hero.belongings.weapon() == null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_NURSE) == 3) {
			curUser.HP = Math.min(curUser.HP + 60, curUser.HT);
		}
		if (Dungeon.hero.belongings.weapon() == null && Dungeon.hero.pointsInTalent(Talent.HEALWAND_NURSE) == 4) {
			curUser.HP = Math.min(curUser.HP + 80, curUser.HT);
		}
		if (Dungeon.hero.hasTalent(Talent.HEALWAND_LVL)){
			Buff.prolong(curUser, Slow.class, Slow.DURATION*2f);
		}
		if (Random.Int(4) == 0 && curUser.HT > 4 && curUser.HP > 4) {
			curUser.HP -= 4;
			curUser.HT -= 4;
			Statistics.deepdwarfHTdown -= 4;
		}
	}

	@Override
	public void onHit(MagesStaff staff, Char attacker, Char defender, int damage) {
			Buff.prolong(attacker, PotionPreserve.class, PotionPreserve.DURATION);
			attacker.sprite.emitter().burst(BloodParticle.BURST, 20);
			//well, there is no way to get this wand for marisa
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
