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

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeon.levels.traps.AlarmTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.CursingTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.DestroyArmorTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.YukariTrap;
import com.touhoupixel.touhoupixeldungeon.mechanics.Ballistica;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.YukariSprite;
import com.watabou.noosa.tweeners.AlphaTweener;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class YukariWizard extends Mob {

	{
		spriteClass = YukariSprite.class;

		HP = HT = Dungeon.depth*4;

		if (Dungeon.depth > 5){
			defenseSkill = Dungeon.depth;
		} else defenseSkill = 1;

		flying = true;

		EXP = 0;
		maxLvl = 99;

		properties.add(Property.FLOAT);
		properties.add(Property.YOKAI);
		properties.add(Property.WARP);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(Dungeon.depth+1, Dungeon.depth+4);
	}

	@Override
	public int attackSkill(Char target) {
		return Dungeon.depth+4;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc( Char hero, int damage ) {
		damage = super.attackProc( enemy, damage );
		if (Random.Int( 4 ) == 0) {
			new DestroyArmorTrap().set(target).activate();
			new CursingTrap().set(target).activate();
			if (Dungeon.hero.STR > 5) {
				Dungeon.hero.STR--;
				GameScene.flash(0x80FFFFFF);
			}
		}
		return damage;
	}
}