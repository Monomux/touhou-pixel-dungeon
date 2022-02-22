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

package com.touhoupixel.touhoupixeldungeon.android;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewConfiguration;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidAudio;
import com.badlogic.gdx.backends.android.AsynchronousAndroidAudio;
import com.touhoupixel.touhoupixeldungeon.TPDSettings;
import com.touhoupixel.touhoupixeldungeon.TouhouPixelDungeon;
import com.touhoupixel.touhoupixeldungeon.services.news.News;
import com.touhoupixel.touhoupixeldungeon.services.news.NewsImpl;
import com.touhoupixel.touhoupixeldungeon.services.updates.UpdateImpl;
import com.touhoupixel.touhoupixeldungeon.services.updates.Updates;
import com.watabou.noosa.Game;
import com.watabou.noosa.ui.Button;
import com.watabou.utils.DeviceCompat;
import com.watabou.utils.FileUtils;

public class AndroidGame extends AndroidApplication {

	public static AndroidApplication instance;

	private static AndroidPlatformSupport support;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//there are some things we only need to set up on first launch
		if (instance == null) {

			instance = this;

			try {
				Game.version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
			} catch (PackageManager.NameNotFoundException e) {
				Game.version = "???";
			}
			try {
				Game.versionCode = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
			} catch (PackageManager.NameNotFoundException e) {
				Game.versionCode = 0;
			}

			if (UpdateImpl.supportsUpdates()) {
				Updates.service = UpdateImpl.getUpdateService();
			}
			if (NewsImpl.supportsNews()) {
				News.service = NewsImpl.getNewsService();
			}

			FileUtils.setDefaultFileProperties(Files.FileType.Local, "");

			// grab preferences directly using our instance first
			// so that we don't need to rely on Gdx.app, which isn't initialized yet.
			// Note that we use a different prefs name on android for legacy purposes,
			// this is the default prefs filename given to an android app (.xml is automatically added to it)
			TPDSettings.set(instance.getPreferences("TouhouPixelDungeon"));

		} else {
			instance = this;
		}

		//set desired orientation (if it exists) before initializing the app.
		if (TPDSettings.landscape() != null) {
			instance.setRequestedOrientation( TPDSettings.landscape() ?
					ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE :
					ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT );
		}

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.depth = 0;
		if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
			//use rgb565 on ICS devices for better performance
			config.r = 5;
			config.g = 6;
			config.b = 5;
		}

		config.useCompass = false;
		config.useAccelerometer = false;

		if (support == null) support = new AndroidPlatformSupport();
		else                 support.reloadGenerators();

		support.updateSystemUI();

		Button.longClick = ViewConfiguration.getLongPressTimeout()/1000f;

		initialize(new TouhouPixelDungeon(support), config);

	}

	@Override
	public AndroidAudio createAudio(Context context, AndroidApplicationConfiguration config) {
		return new AsynchronousAndroidAudio(context, config);
	}

	@Override
	protected void onResume() {
		//prevents weird rare cases where the app is running twice
		if (instance != this){
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
				finishAndRemoveTask();
			} else {
				finish();
			}
		}
		super.onResume();
	}

	@Override
	public void onBackPressed() {
		//do nothing, game should catch all back presses
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		support.updateSystemUI();
	}

	@Override
	public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
		super.onMultiWindowModeChanged(isInMultiWindowMode);
		support.updateSystemUI();
	}
}