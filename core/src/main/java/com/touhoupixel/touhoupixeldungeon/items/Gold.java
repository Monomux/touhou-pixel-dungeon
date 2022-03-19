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

package com.touhoupixel.touhoupixeldungeon.items;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Badges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.MasterThievesArmband;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.CharSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class Gold extends Item {

	private static final String TXT_VALUE	= "%+d";
	
	{
		image = ItemSpriteSheet.GOLD;
		stackable = true;
	}
	
	public Gold() {
		this( 1 );
	}
	
	public Gold( int value ) {
		this.quantity = value;
	}
	
	@Override
	public ArrayList<String> actions( Hero hero ) {
		return new ArrayList<>();
	}

	@Override
	public boolean doPickUp(Hero hero, int pos) {

		Prayer flask = hero.belongings.getItem(Prayer.class);
		KogasaPrayer kogasaflask = hero.belongings.getItem(KogasaPrayer.class);

		if (flask != null && !flask.isFull()) {
			flask.collectPray(this);
		}

		if (kogasaflask != null && !kogasaflask.isFull()) {
			kogasaflask.collectPray(this);
		}

		Dungeon.gold += quantity;
		Statistics.goldCollected += quantity;
		Statistics.goldPickedup += 1;
		Badges.validateGoldCollected();

		MasterThievesArmband.Thievery thievery = hero.buff(MasterThievesArmband.Thievery.class);
		if (thievery != null)
			thievery.collect(quantity);

		GameScene.pickUp( this, pos );
		hero.sprite.showStatus( CharSprite.NEUTRAL, TXT_VALUE, quantity );
		hero.spendAndNext( TIME_TO_PICK_UP );

		Sample.INSTANCE.play( Assets.Sounds.GOLD, 1, 1, Random.Float( 0.9f, 1.1f ) );

		return true;
	}
	
	@Override
	public boolean isUpgradable() {
		return false;
	}
	
	@Override
	public boolean isIdentified() {
		return true;
	}
	
	@Override
	public Item random() {
		quantity = Random.Int( 30 + Dungeon.depth * 10, 60 + Dungeon.depth * 20 );
		return this;
	}

}
