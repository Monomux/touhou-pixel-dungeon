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

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublerainbow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Light;
import com.touhoupixel.touhoupixeldungeon.effects.Beam;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.effects.particles.BloodParticle;
import com.touhoupixel.touhoupixeldungeon.effects.particles.RainbowParticle;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.armor.MaxwellArmor;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MagesStaff;
import com.touhoupixel.touhoupixeldungeon.levels.Terrain;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.tiles.DungeonTilemap;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;
import com.watabou.utils.PathFinder;
import com.watabou.utils.PointF;
import com.watabou.utils.Random;

public class WandOfSetsunatrip extends DamageWand {

	{
		image = ItemSpriteSheet.WAND_SETSUNATRIP;

		collisionProperties = Ballistica.MAGIC_BOLT;
	}

	public int min(int lvl){
		return 1+lvl;
	}

	public int max(int lvl){
		return 5+3*lvl;
	}

	@Override
	public void onZap(Ballistica beam) {

		int cell = beam.collisionPos;

		Char ch = Actor.findChar(cell);

		if (Dungeon.hero.belongings.armor() instanceof MaxwellArmor) {
			GLog.w(Messages.get(ScrollOfTeleportation.class, "tele_interrupt"));
			ch.damage(damageRoll(), this);
		} else if (ch != null) {
			ch.move(curUser.pos);
			ch.sprite.move(cell, curUser.pos);
			ScrollOfTeleportation.teleportToLocation(curUser, cell);
			ch.damage(damageRoll(), this);
			}
		}

	@Override
	public void fx(Ballistica beam, Callback callback) {
		curUser.sprite.parent.add(
				new Beam.LightRay(curUser.sprite.center(), DungeonTilemap.raisedTileCenterToWorld(beam.collisionPos)));
		callback.call();
	}

	@Override
	public void onHit(MagesStaff staff, Char attacker, Char defender, int damage) {
		Buff.prolong(attacker, Doublerainbow.class, 5f);
		attacker.sprite.emitter().burst(BloodParticle.BURST, 20);
	}

	@Override
	public void staffFx(MagesStaff.StaffParticle particle) {
		particle.color( Random.Int( 0x1000000 ) );
		particle.am = 0.5f;
		particle.setLifespan(1f);
		particle.speed.polar(Random.Float(PointF.PI2), 2f);
		particle.setSize( 1f, 2f);
		particle.radiateXY( 0.5f);
	}

}
