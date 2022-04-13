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
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.Blob;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.Web;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Drowsy;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.OneDamage;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.OneDefDamage;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.effects.Beam;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.particles.PurpleParticle;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MagesStaff;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.tiles.DungeonTilemap;
import com.watabou.utils.Callback;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class WandOfPurityBeam extends DamageWand {

	{
		image = ItemSpriteSheet.PURITYBEAM;

		collisionProperties = Ballistica.WONT_STOP;

		unique = true;
		bones = false;
	}

	public int min(int lvl){
		return 6+lvl+Dungeon.depth*2;
	}

	public int max(int lvl){
		return 12+4*lvl+Dungeon.depth*2;
	}

	protected int initialCharges() {
		return 8;
	}
	
	@Override
	public int targetingPos(Hero user, int dst) {
		return dst;
	}

	@Override
	public void onZap(Ballistica beam) {
		
		boolean terrainAffected = false;
		
		int level = buffedLvl();
		
		int maxDistance = Math.min(distance(), beam.dist);
		
		ArrayList<Char> chars = new ArrayList<>();

		Blob web = Dungeon.level.blobs.get(Web.class);

		int terrainPassed = 2, terrainBonus = 0;
		for (int c : beam.subPath(1, maxDistance)) {
			
			Char ch;
			if ((ch = Actor.findChar( c )) != null) {

				//we don't want to count passed terrain after the last enemy hit. That would be a lot of bonus levels.
				//terrainPassed starts at 2, equivalent of rounding up when /3 for integer arithmetic.
				terrainBonus += terrainPassed/3;
				terrainPassed = terrainPassed%3;

				chars.add( ch );
			}

			if (Dungeon.level.solid[c]) {
				terrainPassed++;
			}

			if (Dungeon.level.flamable[c]) {

				Dungeon.level.destroy( c );
				GameScene.updateMap( c );
				terrainAffected = true;
				
			}
			
			CellEmitter.center( c ).burst( PurpleParticle.BURST, Random.IntRange( 1, 2 ) );
		}
		
		if (terrainAffected) {
			Dungeon.observe();
		}
		
		int lvl = level + (chars.size()-1) + terrainBonus;
		for (Char ch : chars) {
			wandProc(ch, chargesPerCast());
			ch.damage(damageRoll(lvl), this);
			ch.sprite.centerEmitter().burst(PurpleParticle.BURST, Random.IntRange(1, 2));
			ch.sprite.flash();
			Buff.prolong(ch, Blindness.class, Blindness.DURATION);

			if (curUser.pointsInTalent(Talent.BEAM_DROWSY) == 1) {
				Buff.affect(ch, Drowsy.class);
			}
			if (curUser.pointsInTalent(Talent.BEAM_DROWSY) == 2) {
				Buff.affect(ch, Drowsy.class);
			}
			if (curUser.pointsInTalent(Talent.BEAM_DROWSY) == 2) {
				Buff.prolong(ch, Cripple.class, Cripple.DURATION);
			}
			if (curUser.pointsInTalent(Talent.BEAM_DROWSY) == 3) {
				Buff.affect(ch, Drowsy.class);
			}
			if (curUser.pointsInTalent(Talent.BEAM_DROWSY) == 3) {
				Buff.prolong(ch, Cripple.class, Cripple.DURATION);
			}
			if (curUser.pointsInTalent(Talent.BEAM_DROWSY) == 3) {
				Buff.affect(ch, Doom.class);
			}

			if (curUser.pointsInTalent(Talent.BEAM_SLOW) == 1) {
				Buff.prolong(ch, Slow.class, Slow.DURATION/5f);
			}
			if (curUser.pointsInTalent(Talent.BEAM_SLOW) == 2) {
				Buff.prolong(ch, Slow.class, Slow.DURATION/2f);
			}
			if (curUser.pointsInTalent(Talent.BEAM_SLOW) == 3) {
				Buff.prolong(ch, Slow.class, Slow.DURATION);
			}

			if (curUser.pointsInTalent(Talent.BEAM_ONEDAMAGE) == 1) {
				if ((Random.Int(4) == 0))
				Buff.prolong(ch, OneDamage.class, OneDamage.DURATION/5f);
			}
			if (curUser.pointsInTalent(Talent.BEAM_ONEDAMAGE) == 2) {
				if ((Random.Int(4) == 0))
				Buff.prolong(ch, OneDamage.class, OneDamage.DURATION/2f);
			}
			if (curUser.pointsInTalent(Talent.BEAM_ONEDAMAGE) == 3) {
				if ((Random.Int(4) == 0))
				Buff.prolong(ch, OneDamage.class, OneDamage.DURATION);
			}
		}
	}

	@Override
	public void onHit(MagesStaff staff, Char attacker, Char defender, int damage) {
		//no direct effect, see magesStaff.reachfactor
	}

	private int distance() {
		return buffedLvl()*2 + 6;
	}
	
	@Override
	public void fx(Ballistica beam, Callback callback) {
		
		int cell = beam.path.get(Math.min(beam.dist, distance()));
		curUser.sprite.parent.add(new Beam.DeathRay(curUser.sprite.center(), DungeonTilemap.raisedTileCenterToWorld( cell )));
		callback.call();
	}

	@Override
	public void staffFx(MagesStaff.StaffParticle particle) {
		particle.color(0x220022);
		particle.am = 0.6f;
		particle.setLifespan(1f);
		particle.acc.set(10, -10);
		particle.setSize( 0.5f, 3f);
		particle.shuffleXY(1f);
	}

}
