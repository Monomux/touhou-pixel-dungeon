/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2022 Evan Debenham
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

import com.badlogic.gdx.Input;
import com.touhoupixel.touhoupixeldungeon.TouhouPixelDungeon;
import com.watabou.input.GameAction;
import com.watabou.input.KeyBindings;
import com.watabou.utils.Bundle;
import com.watabou.utils.FileUtils;

import java.io.IOException;
import java.util.LinkedHashMap;

public class TPDAction extends GameAction {

	protected TPDAction( String name ){
		super( name );
	}

	//--New references to existing actions from GameAction
	public static final GameAction NONE  = GameAction.NONE;
	public static final GameAction BACK  = GameAction.BACK;

	public static final GameAction LEFT_CLICK   = GameAction.LEFT_CLICK;
	public static final GameAction RIGHT_CLICK  = GameAction.RIGHT_CLICK;
	public static final GameAction MIDDLE_CLICK = GameAction.MIDDLE_CLICK;
	//--

	public static final GameAction N            = new TPDAction("n");
	public static final GameAction W            = new TPDAction("w");
	public static final GameAction S            = new TPDAction("s");
	public static final GameAction E            = new TPDAction("e");
	public static final GameAction NW           = new TPDAction("nw");
	public static final GameAction NE           = new TPDAction("ne");
	public static final GameAction SW           = new TPDAction("sw");
	public static final GameAction SE           = new TPDAction("se");
	public static final GameAction WAIT         = new TPDAction("wait");

	public static final GameAction INVENTORY    = new TPDAction("inventory");
	public static final GameAction QUICKSLOT_1  = new TPDAction("quickslot_1");
	public static final GameAction QUICKSLOT_2  = new TPDAction("quickslot_2");
	public static final GameAction QUICKSLOT_3  = new TPDAction("quickslot_3");
	public static final GameAction QUICKSLOT_4  = new TPDAction("quickslot_4");

	public static final GameAction BAG_1        = new TPDAction("bag_1");
	public static final GameAction BAG_2        = new TPDAction("bag_2");
	public static final GameAction BAG_3        = new TPDAction("bag_3");
	public static final GameAction BAG_4        = new TPDAction("bag_4");
	public static final GameAction BAG_5        = new TPDAction("bag_5");
	public static final GameAction BAG_6        = new TPDAction("bag_6");
	public static final GameAction BAG_7        = new TPDAction("bag_7");

	public static final GameAction EXAMINE      = new TPDAction("examine");
	public static final GameAction REST         = new TPDAction("rest");

	public static final GameAction TAG_ATTACK   = new TPDAction("tag_attack");
	public static final GameAction TAG_DANGER   = new TPDAction("tag_danger");
	public static final GameAction TAG_ACTION   = new TPDAction("tag_action");
	public static final GameAction TAG_LOOT     = new TPDAction("tag_loot");
	public static final GameAction TAG_RESUME   = new TPDAction("tag_resume");

	public static final GameAction HERO_INFO    = new TPDAction("hero_info");
	public static final GameAction JOURNAL      = new TPDAction("journal");

	public static final GameAction ZOOM_IN      = new TPDAction("zoom_in");
	public static final GameAction ZOOM_OUT     = new TPDAction("zoom_out");

	private static final LinkedHashMap<Integer, GameAction> defaultBindings = new LinkedHashMap<>();
	static {
		defaultBindings.put( Input.Keys.ESCAPE,         TPDAction.BACK );
		defaultBindings.put( Input.Keys.BACKSPACE,      TPDAction.BACK );
		defaultBindings.put( Input.Keys.BUTTON_START,   TPDAction.BACK );

		defaultBindings.put( Input.Keys.BUTTON_R2,      TPDAction.LEFT_CLICK );
		defaultBindings.put( Input.Keys.BUTTON_THUMBR,  TPDAction.LEFT_CLICK );
		defaultBindings.put( Input.Keys.BUTTON_L2,      TPDAction.RIGHT_CLICK );
		defaultBindings.put( Input.Keys.BUTTON_SELECT,  TPDAction.MIDDLE_CLICK );

		defaultBindings.put( Input.Keys.W,              TPDAction.N );
		defaultBindings.put( Input.Keys.A,              TPDAction.W );
		defaultBindings.put( Input.Keys.S,              TPDAction.S );
		defaultBindings.put( Input.Keys.D,              TPDAction.E );
		defaultBindings.put( Input.Keys.SPACE,          TPDAction.WAIT );

		defaultBindings.put( Input.Keys.UP,             TPDAction.N );
		defaultBindings.put( Input.Keys.LEFT,           TPDAction.W );
		defaultBindings.put( Input.Keys.DOWN,           TPDAction.S );
		defaultBindings.put( Input.Keys.RIGHT,          TPDAction.E );

		defaultBindings.put( Input.Keys.NUMPAD_8,       TPDAction.N );
		defaultBindings.put( Input.Keys.NUMPAD_4,       TPDAction.W );
		defaultBindings.put( Input.Keys.NUMPAD_2,       TPDAction.S );
		defaultBindings.put( Input.Keys.NUMPAD_6,       TPDAction.E );
		defaultBindings.put( Input.Keys.NUMPAD_7,       TPDAction.NW );
		defaultBindings.put( Input.Keys.NUMPAD_9,       TPDAction.NE );
		defaultBindings.put( Input.Keys.NUMPAD_1,       TPDAction.SW );
		defaultBindings.put( Input.Keys.NUMPAD_3,       TPDAction.SE );
		defaultBindings.put( Input.Keys.NUMPAD_5,       TPDAction.WAIT );

		defaultBindings.put( Input.Keys.BUTTON_THUMBL,  TPDAction.WAIT );

		defaultBindings.put( Input.Keys.F,              TPDAction.INVENTORY );
		defaultBindings.put( Input.Keys.I,              TPDAction.INVENTORY );
		defaultBindings.put( Input.Keys.BUTTON_R1,      TPDAction.INVENTORY );
		defaultBindings.put( Input.Keys.NUM_1,          TPDAction.QUICKSLOT_1 );
		defaultBindings.put( Input.Keys.BUTTON_Y,       TPDAction.QUICKSLOT_1 );
		defaultBindings.put( Input.Keys.NUM_2,          TPDAction.QUICKSLOT_2 );
		defaultBindings.put( Input.Keys.BUTTON_B,       TPDAction.QUICKSLOT_2 );
		defaultBindings.put( Input.Keys.NUM_3,          TPDAction.QUICKSLOT_3 );
		defaultBindings.put( Input.Keys.BUTTON_X,       TPDAction.QUICKSLOT_3 );
		defaultBindings.put( Input.Keys.NUM_4,          TPDAction.QUICKSLOT_4 );
		defaultBindings.put( Input.Keys.BUTTON_A,       TPDAction.QUICKSLOT_4 );

		defaultBindings.put( Input.Keys.F1,             TPDAction.BAG_1 );
		defaultBindings.put( Input.Keys.F2,             TPDAction.BAG_2 );
		defaultBindings.put( Input.Keys.F3,             TPDAction.BAG_3 );
		defaultBindings.put( Input.Keys.F4,             TPDAction.BAG_4 );
		defaultBindings.put( Input.Keys.F5,             TPDAction.BAG_5 );
		defaultBindings.put( Input.Keys.F6,             TPDAction.BAG_6 );
		defaultBindings.put( Input.Keys.F7,             TPDAction.BAG_7 );

		defaultBindings.put( Input.Keys.E,              TPDAction.EXAMINE );
		defaultBindings.put( Input.Keys.BUTTON_L1,      TPDAction.EXAMINE );
		defaultBindings.put( Input.Keys.Z,              TPDAction.REST );

		defaultBindings.put( Input.Keys.Q,              TPDAction.TAG_ATTACK );
		defaultBindings.put( Input.Keys.TAB,            TPDAction.TAG_DANGER );
		defaultBindings.put( Input.Keys.X,              TPDAction.TAG_ACTION );
		defaultBindings.put( Input.Keys.C,              TPDAction.TAG_LOOT );
		defaultBindings.put( Input.Keys.ENTER,          TPDAction.TAG_LOOT );
		defaultBindings.put( Input.Keys.R,              TPDAction.TAG_RESUME );

		defaultBindings.put( Input.Keys.H,              TPDAction.HERO_INFO );
		defaultBindings.put( Input.Keys.J,              TPDAction.JOURNAL );

		defaultBindings.put( Input.Keys.PLUS,           TPDAction.ZOOM_IN );
		defaultBindings.put( Input.Keys.EQUALS,         TPDAction.ZOOM_IN );
		defaultBindings.put( Input.Keys.MINUS,          TPDAction.ZOOM_OUT );
	}

	public static LinkedHashMap<Integer, GameAction> getDefaults() {
		return new LinkedHashMap<>(defaultBindings);
	}

	//hard bindings for android devices
	static {
		KeyBindings.addHardBinding( Input.Keys.BACK, TPDAction.BACK );
		KeyBindings.addHardBinding( Input.Keys.MENU, TPDAction.INVENTORY );
	}

	//we only save/loads keys which differ from the default configuration.
	private static final String BINDINGS_FILE = "keybinds.dat";

	public static void loadBindings(){

		if (!KeyBindings.getAllBindings().isEmpty()){
			return;
		}

		try {
			Bundle b = FileUtils.bundleFromFile(BINDINGS_FILE);

			Bundle firstKeys = b.getBundle("first_keys");
			Bundle secondKeys = b.getBundle("second_keys");
			Bundle thirdKeys = b.getBundle("third_keys");

			LinkedHashMap<Integer, GameAction> defaults = getDefaults();
			LinkedHashMap<Integer, GameAction> merged = new LinkedHashMap<>();

			for (GameAction a : allActions()) {
				if (firstKeys.contains(a.name())) {
					if (firstKeys.getInt(a.name()) == 0){
						continue; //we have no keys assigned to this action, move to the next one
					} else {
						merged.put(firstKeys.getInt(a.name()), a);
						defaults.remove(firstKeys.getInt(a.name())); //prevent duplicates in other actions
					}
				} else {
					//if we have no custom key here, find the first one from defaults and merge it
					for (int i : defaults.keySet()){
						if (defaults.get(i) == a){
							merged.put(i, defaults.remove(i));
							break;
						}
					}
				}

				if (secondKeys.contains(a.name())) {
					if (secondKeys.getInt(a.name()) == 0){
						continue; //we have no more keys assigned to this action, move to the next one
					} else {
						merged.put(secondKeys.getInt(a.name()), a);
						defaults.remove(secondKeys.getInt(a.name()));
					}
				} else {
					//if we have no custom key here, find the next one from defaults and merge it
					for (int i : defaults.keySet()){
						if (defaults.get(i) == a){
							merged.put(i, defaults.remove(i));
							break;
						}
					}
				}

				if (thirdKeys.contains(a.name())) {
					if (thirdKeys.getInt(a.name()) == 0){
						continue; //we have no more keys assigned to this action, move to the next one
					} else {
						merged.put(thirdKeys.getInt(a.name()), a);
						defaults.remove(thirdKeys.getInt(a.name()));
					}
				} else {
					//if we have no custom key here, find the next one from defaults and merge it
					for (int i : defaults.keySet()){
						if (defaults.get(i) == a){
							merged.put(i, defaults.remove(i));
							break;
						}
					}
				}

			}

			KeyBindings.setAllBindings(merged);

		} catch (Exception e){
			KeyBindings.setAllBindings(getDefaults());
		}

	}

	public static void saveBindings(){

		Bundle b = new Bundle();

		Bundle firstKeys = new Bundle();
		Bundle secondKeys = new Bundle();
		Bundle thirdKeys = new Bundle();

		for (GameAction a : allActions()){
			int firstCur = 0;
			int secondCur = 0;
			int thirdCur = 0;
			int firstDef = 0;
			int secondDef = 0;
			int thirdDef = 0;

			for (int i : defaultBindings.keySet()){
				if (defaultBindings.get(i) == a){
					if (firstDef == 0) {
						firstDef = i;
					} else if (secondDef == 0) {
						secondDef = i;
					} else {
						thirdDef = i;
					}
				}
			}

			LinkedHashMap<Integer, GameAction> curBindings = KeyBindings.getAllBindings();
			for (int i : curBindings.keySet()){
				if (curBindings.get(i) == a){
					if (firstCur == 0) {
						firstCur = i;
					} else if (secondCur == 0) {
						secondCur = i;
					} else {
						thirdCur = i;
					}
				}
			}

			if (firstCur != firstDef){
				firstKeys.put(a.name(), firstCur);
			}
			if (secondCur != secondDef){
				secondKeys.put(a.name(), secondCur);
			}
			if (thirdCur != thirdDef){
				thirdKeys.put(a.name(), thirdCur);
			}

		}

		b.put("first_keys", firstKeys);
		b.put("second_keys", secondKeys);
		b.put("third_keys", thirdKeys);

		try {
			FileUtils.bundleToFile(BINDINGS_FILE, b);
		} catch (IOException e) {
			TouhouPixelDungeon.reportException(e);
		}

	}

}