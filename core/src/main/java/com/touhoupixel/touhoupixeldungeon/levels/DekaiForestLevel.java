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

package com.touhoupixel.touhoupixeldungeon.levels;


import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.effects.particles.FlameParticle;
import com.touhoupixel.touhoupixeldungeon.levels.painters.CavesPainter;
import com.touhoupixel.touhoupixeldungeon.levels.painters.ForestPainter;
import com.touhoupixel.touhoupixeldungeon.levels.painters.Painter;
import com.touhoupixel.touhoupixeldungeon.levels.traps.AlarmTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.AntiHealTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.BlazingTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.CorrosionTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.CursingTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.DegradeTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.DespairTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.DisarmingTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.DisintegrationTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.FlashingTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.FrostTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.GapTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.GatewayTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.GeyserTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.GrimTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.PitfallTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.RockfallTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.StormTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.SummoningTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.WarpingTrap;
import com.touhoupixel.touhoupixeldungeon.levels.traps.WeakeningTrap;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.tiles.DungeonTilemap;
import com.watabou.noosa.Group;
import com.watabou.noosa.Halo;
import com.watabou.noosa.particles.Emitter;
import com.watabou.utils.PointF;
import com.watabou.utils.Random;

public class DekaiForestLevel extends RegularLevel {

	{
		color1 = 0x6a723d;
		color2 = 0x88924c;
	}
	
	@Override
	protected int standardRooms(boolean forceMax) {
		if (forceMax) return 8;
		//6 to 8, average 6.75
		return 6+ Random.chances(new float[]{4, 2, 2});
	}
	
	@Override
	protected int specialRooms(boolean forceMax) {
		if (forceMax) return 3;
		//1 to 3, average 2.0
		return 1+Random.chances(new float[]{3, 4, 3});
	}
	
	@Override
	protected Painter painter() {
		return new ForestPainter()
				.setWater(feeling == Feeling.WATER ? 0.90f : 0.30f, 4)
				.setGrass(feeling == Feeling.GRASS ? 0.80f : 0.20f, 3)
				.setTraps(nTraps(), trapClasses(), trapChances());
	}
	
	@Override
	public String tilesTex() {
		return Assets.Environment.TILES_FOREST;
	}
	
	@Override
	public String waterTex() {
		return Assets.Environment.WATER_FOREST;
	}

	@Override
	protected Class<?>[] trapClasses() {
		return new Class[]{
				FrostTrap.class, CorrosionTrap.class, BlazingTrap.class, DisintegrationTrap.class, GapTrap.class,
				RockfallTrap.class, FlashingTrap.class, WeakeningTrap.class, AlarmTrap.class, DegradeTrap.class, DespairTrap.class, AntiHealTrap.class,
				DisarmingTrap.class, SummoningTrap.class, WarpingTrap.class, CursingTrap.class, GrimTrap.class, PitfallTrap.class, GatewayTrap.class, GeyserTrap.class };
	}

	@Override
	protected float[] trapChances() {
		return new float[]{
				4, 4, 4, 4, 4,
				2, 2, 2, 2, 2, 2, 2,
				1, 1, 1, 1, 1, 1, 1, 1 };
	}

	@Override
	public String tileName( int tile ) {
		switch (tile) {
			case Terrain.WATER:
				return Messages.get(DekaiForestLevel.class, "water_name");
			default:
				return super.tileName( tile );
		}
	}

	@Override
	public String tileDesc(int tile) {
		switch (tile) {
			case Terrain.EMPTY_DECO:
				return Messages.get(DekaiForestLevel.class, "empty_deco_desc");
			case Terrain.BOOKSHELF:
				return Messages.get(DekaiForestLevel.class, "bookshelf_desc");
			default:
				return super.tileDesc( tile );
		}
	}
	
	@Override
	public Group addVisuals() {
		super.addVisuals();
		addPrisonVisuals(this, visuals);
		return visuals;
	}

	public static void addPrisonVisuals(Level level, Group group){
		for (int i=0; i < level.length(); i++) {
			if (level.map[i] == Terrain.WALL_DECO) {
				group.add( new Torch( i ) );
			}
		}
	}

	public static class Torch extends Emitter {
		
		private int pos;
		
		public Torch( int pos ) {
			super();
			
			this.pos = pos;
			
			PointF p = DungeonTilemap.tileCenterToWorld( pos );
			pos( p.x - 1, p.y + 2, 2, 0 );
			
			pour( FlameParticle.FACTORY, 0.15f );
			
			add( new Halo( 12, 0xFFFFCC, 0.4f ).point( p.x, p.y + 1 ) );
		}
		
		@Override
		public void update() {
			if (visible = (pos < Dungeon.level.heroFOV.length && Dungeon.level.heroFOV[pos])) {
				super.update();
			}
		}
	}
}