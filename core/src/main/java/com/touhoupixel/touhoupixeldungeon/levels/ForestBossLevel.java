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
import com.touhoupixel.touhoupixeldungeon.actors.Actor;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.HijiriBoss;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.JunkoBoss;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.KeikiBoss;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.LunaBoss;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Mob;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.OkinaBoss;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.StarBoss;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.SunnyBoss;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.TenkyuuBoss;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;

public class ForestBossLevel extends Level {

    private static final int SIZE = 13;

    {
        color1 = 0x534f3e;
        color2 = 0xb9d661;

        viewDistance = 100;
    }

    @Override
    public String tilesTex() {
        return Assets.Environment.TILES_MORIYA;
    }

    @Override
    public String waterTex() {
        return Assets.Environment.WATER_MORIYA;
    }

    @Override
    protected boolean build() {

        setSize(15, 15);

        for (int i=2; i < SIZE; i++) {
            for (int j=2; j < SIZE; j++) {
                map[i * width() + j] = Terrain.EMPTY;
            }
        }

        for (int i=1; i <= SIZE; i++) {
            map[width() + i] =
                    map[width() * SIZE + i] =
                            map[width() * i + 1] =
                                    map[width() * i + SIZE] =
                                            Terrain.WATER;
        }

        entrance = SIZE * width() + SIZE / 2 + 1;
        map[entrance] = Terrain.ENTRANCE;

        exit = SIZE * width() + SIZE / 2 + 2;
        map[exit] = Terrain.LOCKED_EXIT;

        return true;
    }

    @Override
    public void occupyCell( Char ch ) {
        super.occupyCell( ch );

        if (map[entrance] == Terrain.ENTRANCE && map[exit] != Terrain.EXIT
                && ch == Dungeon.hero && Dungeon.level.distance(ch.pos, entrance) >= 2) {
            seal();
        }
    }

    @Override
    public void seal() {
        super.seal();
        set( entrance, Terrain.EMPTY_SP );
        GameScene.updateMap( entrance );

        Dungeon.observe();

        HijiriBoss boss1 = new HijiriBoss();
        OkinaBoss boss2 = new OkinaBoss();
        KeikiBoss boss3 = new KeikiBoss();
        TenkyuuBoss boss4 = new TenkyuuBoss();
        boss1.pos = 111;
        boss2.pos = 112;
        boss3.pos = 113;
        boss4.pos = 114;
        GameScene.add( boss1 );
        GameScene.add( boss2 );
        GameScene.add( boss3 );
        GameScene.add( boss4 );
    }

    @Override
    public void unseal() {
        super.unseal();
        set( entrance, Terrain.ENTRANCE );
        GameScene.updateMap( entrance );

        set( exit, Terrain.EXIT );
        GameScene.updateMap( exit );

        CellEmitter.get(exit-1).burst(ShadowParticle.UP, 25);
        CellEmitter.get(exit).burst(ShadowParticle.UP, 100);
        CellEmitter.get(exit+1).burst(ShadowParticle.UP, 25);

        Dungeon.observe();
    }

    @Override
    public Mob createMob() {
        return null;
    }

    @Override
    protected void createMobs() {
    }

    public Actor addRespawner() {
        return null;
    }

    @Override
    protected void createItems() {
    }

    @Override
    public int randomRespawnCell( Char ch ) {
        return entrance-width();
    }

}