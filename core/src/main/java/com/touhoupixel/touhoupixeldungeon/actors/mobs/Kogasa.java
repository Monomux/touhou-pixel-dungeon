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

package com.touhoupixel.touhoupixeldungeon.actors.mobs;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Incompetence;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTerror;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfDread;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfBlastWave;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.KogasaSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Kogasa extends Mob {

	{
		spriteClass = KogasaSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 421;
		} else HP = HT = 26;

		if (Dungeon.depth > 50){
			defenseSkill = 57;
		} else defenseSkill = 7;

		if (Dungeon.depth > 50){
			EXP = 54;
		} else EXP = 4;

		if (Dungeon.depth > 50){
			maxLvl = 63;
		} else maxLvl = 13;

		loot = new ScrollOfDread();
		lootChance = 0.2f;

		properties.add(Property.YOKAI);
		properties.add(Property.HAPPY);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(32, 41);
		} else return Random.NormalIntRange(2, 8);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 60;
		} else return 10;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (this.buff(Incompetence.class) == null) {
			if (Random.Int(2) == 0) {
				Ballistica trajectory = new Ballistica(this.pos, enemy.pos, Ballistica.STOP_TARGET);
				//trim it to just be the part that goes past them
				trajectory = new Ballistica(trajectory.collisionPos, trajectory.path.get(trajectory.path.size() - 1), Ballistica.PROJECTILE);
				//knock them back along that ballistica
				WandOfBlastWave.throwChar(enemy, trajectory, 5);
				Sample.INSTANCE.play(Assets.Sounds.CURSED);
				CellEmitter.get(pos).burst(ShadowParticle.UP, 5);
				GLog.w(Messages.get(this, "fear"));
				return damage;
			}
		}
		return damage;
	}
}
