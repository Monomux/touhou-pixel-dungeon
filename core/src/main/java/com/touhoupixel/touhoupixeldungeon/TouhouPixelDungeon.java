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

package com.touhoupixel.touhoupixeldungeon;

import com.touhoupixel.touhoupixeldungeon.actors.mobs.Suika;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.TenshiBoss;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfMetamorphosis;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.scenes.PixelScene;
import com.touhoupixel.touhoupixeldungeon.scenes.TitleScene;
import com.touhoupixel.touhoupixeldungeon.scenes.WelcomeScene;
import com.watabou.noosa.Game;
import com.watabou.noosa.audio.Music;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.DeviceCompat;
import com.watabou.utils.PlatformSupport;

public class TouhouPixelDungeon extends Game {

	//variable constants for specific older versions of shattered, used for data conversion
	//versions older than v0.9.0b are no longer supported, and data from them is ignored
	public static final int v0_9_0b  = 489;
	public static final int v0_9_1d  = 511;
	public static final int v0_9_2b  = 531;
	public static final int v0_9_3c  = 557; //557 on iOS, 554 on other platforms

	public static final int v1_0_3   = 574;
	public static final int v1_1_0   = 583;
	
	public TouhouPixelDungeon(PlatformSupport platform ) {
		super( sceneClass == null ? WelcomeScene.class : sceneClass, platform );

		//v1.1.0
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfDread.class,
				"com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfPetrification" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfSirensSong.class,
				"com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfAffection" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfChallenge.class,
				"com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfConfusion" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfDivineInspiration.class,
				"com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfHolyFuror" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfMastery.class,
				"com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfAdrenalineSurge" );
		com.watabou.utils.Bundle.addAlias(
				ScrollOfMetamorphosis.class,
				"com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfPolymorph" );

		//v1.0.0
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfFear.class,
				"com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfAffection" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfDeepSleep.class,
				"com.touhoupixel.touhoupixeldungeon.items.stones.StoneOfDeepenedSleep" );

		//v0.9.3
		com.watabou.utils.Bundle.addAlias(
				Suika.class,
				"com.touhoupixel.touhoupixeldungeon.actors.mobs.NewTengu" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.PrisonBossLevel.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewPrisonBossLevel" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.PrisonBossLevel.ExitVisual.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewPrisonBossLevel$exitVisual" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.PrisonBossLevel.ExitVisualWalls.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewPrisonBossLevel$exitVisualWalls" );
		com.watabou.utils.Bundle.addAlias(
				TenshiBoss.class,
				"com.touhoupixel.touhoupixeldungeon.actors.mobs.NewDM300" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.CavesBossLevel.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewCavesBossLevel" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.CavesBossLevel.PylonEnergy.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewCavesBossLevel$PylonEnergy" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.CavesBossLevel.ArenaVisuals.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewCavesBossLevel$ArenaVisuals" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.CavesBossLevel.CityEntrance.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewCavesBossLevel$CityEntrance" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.CavesBossLevel.EntranceOverhang.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewCavesBossLevel$EntranceOverhang" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.CityBossLevel.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewCityBossLevel" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.CityBossLevel.CustomGroundVisuals.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewCityBossLevel$CustomGroundVisuals" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.CityBossLevel.CustomWallVisuals.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewCityBossLevel$CustomWallVisuals" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.HallsBossLevel.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewHallsBossLevel" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.HallsBossLevel.CenterPieceVisuals.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewHallsBossLevel$CenterPieceWalls" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.levels.HallsBossLevel.CenterPieceWalls.class,
				"com.touhoupixel.touhoupixeldungeon.levels.NewHallsBossLevel$CenterPieceWalls" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.items.Waterskin.class,
				"com.touhoupixel.touhoupixeldungeon.items.DewVial" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.items.TengusMask.class,
				"com.touhoupixel.touhoupixeldungeon.items.TomeOfMastery" );
		com.watabou.utils.Bundle.addAlias(
				com.touhoupixel.touhoupixeldungeon.items.KingsCrown.class,
				"com.touhoupixel.touhoupixeldungeon.items.ArmorKit" );
		
	}
	
	@Override
	public void create() {
		super.create();

		updateSystemUI();
		TPDAction.loadBindings();
		
		Music.INSTANCE.enable( TPDSettings.music() );
		Music.INSTANCE.volume( TPDSettings.musicVol()* TPDSettings.musicVol()/100f );
		Sample.INSTANCE.enable( TPDSettings.soundFx() );
		Sample.INSTANCE.volume( TPDSettings.SFXVol()* TPDSettings.SFXVol()/100f );

		Sample.INSTANCE.load( Assets.Sounds.all );
		
	}

	@Override
	public void finish() {
		if (!DeviceCompat.isiOS()) {
			super.finish();
		} else {
			//can't exit on iOS (Apple guidelines), so just go to title screen
			switchScene(TitleScene.class);
		}
	}

	public static void switchNoFade(Class<? extends PixelScene> c){
		switchNoFade(c, null);
	}

	public static void switchNoFade(Class<? extends PixelScene> c, SceneChangeCallback callback) {
		PixelScene.noFade = true;
		switchScene( c, callback );
	}
	
	public static void seamlessResetScene(SceneChangeCallback callback) {
		if (scene() instanceof PixelScene){
			((PixelScene) scene()).saveWindows();
			switchNoFade((Class<? extends PixelScene>) sceneClass, callback );
		} else {
			resetScene();
		}
	}
	
	public static void seamlessResetScene(){
		seamlessResetScene(null);
	}
	
	@Override
	protected void switchScene() {
		super.switchScene();
		if (scene instanceof PixelScene){
			((PixelScene) scene).restoreWindows();
		}
	}
	
	@Override
	public void resize( int width, int height ) {
		if (width == 0 || height == 0){
			return;
		}

		if (scene instanceof PixelScene &&
				(height != Game.height || width != Game.width)) {
			PixelScene.noFade = true;
			((PixelScene) scene).saveWindows();
		}

		super.resize( width, height );

		updateDisplaySize();

	}
	
	@Override
	public void destroy(){
		super.destroy();
		GameScene.endActorThread();
	}
	
	public void updateDisplaySize(){
		platform.updateDisplaySize();
	}

	public static void updateSystemUI() {
		platform.updateSystemUI();
	}
}