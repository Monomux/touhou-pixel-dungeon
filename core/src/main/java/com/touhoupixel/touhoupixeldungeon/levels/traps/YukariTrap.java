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

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Eiki;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Hecatia;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Hijiri;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Iku;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Keiki;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Koishi;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Komachi;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Lily;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Megumu;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Misumaru;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Mob;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Mokou;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Sakuya;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Seija;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Shou;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Sumireko;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Toyohime;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Yatsuhashi;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Yorihime;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Yuuma;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.ArrayList;
import java.util.Arrays;

public class YukariTrap extends Trap{

	private static final float DELAY = 1f;

	{
		color = TEAL;
		shape = LARGE_DOT;
	}

	private static final ArrayList<Class<?extends Mob>> RARE = new ArrayList<>(Arrays.asList(
			Seija.class, Shou.class, Yatsuhashi.class, Sumireko.class, Yuuma.class,
			Komachi.class, Eiki.class, Keiki.class, Iku.class, Megumu.class,
			Sakuya.class, Hijiri.class, Koishi.class, Misumaru.class, Mokou.class, Lily.class));

	@Override
	public void activate() {

		int nMobs = 8;

		ArrayList<Integer> candidates = new ArrayList<>();

		for (int i = 0; i < PathFinder.NEIGHBOURS8.length; i++) {
			int p = pos + PathFinder.NEIGHBOURS8[i];
			if (Actor.findChar( p ) == null && (Dungeon.level.passable[p] || Dungeon.level.avoid[p])) {
				candidates.add( p );
			}
		}

		ArrayList<Integer> respawnPoints = new ArrayList<>();

		while (nMobs > 0 && candidates.size() > 0) {
			int index = Random.index( candidates );

			respawnPoints.add( candidates.remove( index ) );
			nMobs--;
		}

		ArrayList<Mob> mobs = new ArrayList<>();

		int summoned = 0;
		for (Integer point : respawnPoints) {
			summoned++;
			Mob mob;
			switch (summoned){
				case 1: default:
					if (Random.Int(0) == 0){
						mob = new Yorihime();
						break;
					}
				case 2:
					if (Random.Int(0) == 0){
						mob = new Toyohime();
						break;
					}
				case 3:
					if (Random.Int(0) == 0){
						mob = new Hecatia();
						break;
					}
				case 4: case 5: case 6: case 7: case 8:
					mob = Reflection.newInstance(Random.element(RARE));
					break;
			}

			if (Char.hasProp(mob, Char.Property.LARGE) && !Dungeon.level.openSpace[point]){
				continue;
			}

			mob.maxLvl = Hero.MAX_LEVEL;
			mob.state = mob.WANDERING;
			mob.pos = point;
			GameScene.add(mob, DELAY);
			mobs.add(mob);
		}

		//important to process the visuals and pressing of cells last, so spawned mobs have a chance to occupy cells first
		Trap t;
		for (Mob mob : mobs){
			//manually trigger traps first to avoid sfx spam
			if ((t = Dungeon.level.traps.get(mob.pos)) != null && t.active){
				if (t.disarmedByActivation) t.disarm();
				t.reveal();
				t.activate();
			}
			ScrollOfTeleportation.appear(mob, mob.pos);
			Dungeon.level.occupyCell(mob);
		}

	}
}
