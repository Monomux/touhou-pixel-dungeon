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

package com.touhoupixel.touhoupixeldungeon.ui;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.TPDAction;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.journal.Document;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.scenes.PixelScene;
import com.touhoupixel.touhoupixeldungeon.sprites.HeroSprite;
import com.touhoupixel.touhoupixeldungeon.windows.WndGame;
import com.touhoupixel.touhoupixeldungeon.windows.WndHero;
import com.touhoupixel.touhoupixeldungeon.windows.WndJournal;
import com.touhoupixel.touhoupixeldungeon.windows.WndStory;
import com.watabou.input.GameAction;
import com.watabou.noosa.BitmapText;
import com.watabou.noosa.Camera;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;
import com.watabou.noosa.NinePatch;
import com.watabou.noosa.audio.Sample;
import com.watabou.noosa.particles.Emitter;
import com.watabou.noosa.ui.Button;
import com.watabou.noosa.ui.Component;
import com.watabou.utils.ColorMath;

public class StatusPane extends Component {

	private NinePatch bg;
	private Image avatar;
	public static float talentBlink;
	private float warning;

	private static final float FLASH_RATE = (float)(Math.PI*1.5f); //1.5 blinks per second

	private int lastTier = 0;

	private Image rawShielding;
	private Image shieldedHP;
	private Image hp;
	private BitmapText hpText;

	private Image exp;

	private BossHealthBar bossHP;

	private int lastLvl = -1;

	private BitmapText level;

	private BuffIndicator buffs;
	private Compass compass;

	private BusyIndicator busy;

	private Toolbar.PickedUpItem pickedUp;

	@Override
	protected void createChildren() {

		bg = new NinePatch( Assets.Interfaces.STATUS, 0, 0, 128, 36, 85, 0, 45, 0 );
		add( bg );

		add( new Button(){
			@Override
			protected void onClick () {
				Camera.main.panTo( Dungeon.hero.sprite.center(), 5f );
				GameScene.show( new WndHero() );
			}
		}.setRect( 0, 1, 30, 30 ));

		avatar = HeroSprite.avatar( Dungeon.hero.heroClass, lastTier );
		add( avatar );

		talentBlink = 0;

		compass = new Compass( Statistics.amuletObtained ? Dungeon.level.entrance : Dungeon.level.exit );
		add( compass );

		rawShielding = new Image( Assets.Interfaces.SHLD_BAR );
		rawShielding.alpha(0.5f);
		if (!Dungeon.isChallenged(Challenges.KEINE_TIME)) {
			add(rawShielding);
		}

		shieldedHP = new Image( Assets.Interfaces.SHLD_BAR );
		if (!Dungeon.isChallenged(Challenges.KEINE_TIME)) {
			add(shieldedHP);
		}

		hp = new Image( Assets.Interfaces.HP_BAR );
		if (!Dungeon.isChallenged(Challenges.KEINE_TIME)) {
			add(hp);
		}

		hpText = new BitmapText(PixelScene.pixelFont);
		hpText.alpha(0.6f);
		if (!Dungeon.isChallenged(Challenges.KEINE_TIME)) {
			add(hpText);
		}

		exp = new Image( Assets.Interfaces.XP_BAR );
		add( exp );

		bossHP = new BossHealthBar();
		add( bossHP );

		level = new BitmapText( PixelScene.pixelFont);
		level.hardlight( 0xFFFFAA );
		add( level );

		buffs = new BuffIndicator(Dungeon.hero);
		add( buffs );

		busy = new BusyIndicator();
		add( busy );

		add( pickedUp = new Toolbar.PickedUpItem());
	}

	@Override
	protected void layout() {

		height = 32;

		bg.size( width, bg.height );

		avatar.x = bg.x + 15 - avatar.width / 2f;
		avatar.y = bg.y + 16 - avatar.height / 2f;
		PixelScene.align(avatar);

		compass.x = avatar.x + avatar.width / 2f - compass.origin.x;
		compass.y = avatar.y + avatar.height / 2f - compass.origin.y;
		PixelScene.align(compass);

		hp.x = shieldedHP.x = rawShielding.x = 30;
		hp.y = shieldedHP.y = rawShielding.y = 3;

		hpText.scale.set(PixelScene.align(0.5f));
		hpText.x = hp.x + 1;
		hpText.y = hp.y + (hp.height - (hpText.baseLine()+hpText.scale.y))/2f;
		hpText.y -= 0.001f; //prefer to be slightly higher
		PixelScene.align(hpText);

		bossHP.setPos( 6 + (width - bossHP.width())/2, 20);

		buffs.setPos( 31, 9 );
	}

	private static final int[] warningColors = new int[]{0x660000, 0xCC0000, 0x660000};

	@Override
	public void update() {
		super.update();

		int health = Dungeon.hero.HP;
		int shield = Dungeon.hero.shielding();
		int max = Dungeon.hero.HT;

		if (!Dungeon.hero.isAlive()) {
			avatar.tint(0x000000, 0.5f);
		} else if ((health / (float) max) < 0.3f) {
			warning += Game.elapsed * 5f * (0.4f - (health / (float) max));
			warning %= 1f;
			avatar.tint(ColorMath.interpolate(warning, warningColors), 0.5f);
		} else if (talentBlink > 0.33f) { //stops early so it doesn't end in the middle of a blink
			talentBlink -= Game.elapsed;
			avatar.tint(1, 1, 0, (float) Math.abs(Math.cos(talentBlink * FLASH_RATE)) / 2f);
		} else {
			avatar.resetColor();
		}

		hp.scale.x = Math.max(0, (health - shield) / (float) max);
		shieldedHP.scale.x = health / (float) max;
		rawShielding.scale.x = shield / (float) max;

		if (shield <= 0) {
			hpText.text(health + "/" + max);
		} else {
			hpText.text(health + "+" + shield + "/" + max);
		}

		exp.scale.x = (width / exp.width) * Dungeon.hero.exp / Dungeon.hero.maxExp();

		if (Dungeon.hero.lvl != lastLvl) {

			if (lastLvl != -1) {
				showStarParticles();
			}

			lastLvl = Dungeon.hero.lvl;
			level.text( Integer.toString( lastLvl ) );
			level.measure();
			level.x = 27.5f - level.width() / 2f;
			level.y = 28.0f - level.baseLine() / 2f;
			PixelScene.align(level);
		}

		int tier = Dungeon.hero.tier();
		if (tier != lastTier) {
			lastTier = tier;
			avatar.copy( HeroSprite.avatar( Dungeon.hero.heroClass, tier ) );
		}
	}

	public void showStarParticles(){
		Emitter emitter = (Emitter)recycle( Emitter.class );
		emitter.revive();
		emitter.pos( 27, 27 );
		emitter.burst( Speck.factory( Speck.STAR ), 12 );
	}

	private static class JournalButton extends Button {

		private Image bg;
		private Image journalIcon;

		private String flashingPage = null;

		public JournalButton() {
			super();

			width = bg.width + 13; //includes the depth display to the left
			height = bg.height + 4;
		}

		@Override
		protected void createChildren() {
			super.createChildren();

			bg = new Image( Assets.Interfaces.MENU, 2, 2, 13, 11 );
			add( bg );

			journalIcon = new Image( Assets.Interfaces.MENU, 31, 0, 11, 7);
			add( journalIcon );
		}

		@Override
		protected void layout() {
			super.layout();

			bg.x = x + 13;
			bg.y = y + 2;

			journalIcon.x = bg.x + (bg.width() - journalIcon.width())/2f;
			journalIcon.y = bg.y + (bg.height() - journalIcon.height())/2f;
			PixelScene.align(journalIcon);
		}

		private float time;

		@Override
		public void update() {
			super.update();

			if (flashingPage != null){
				journalIcon.am = (float)Math.abs(Math.cos( FLASH_RATE * (time += Game.elapsed) ));
				if (time >= Math.PI/FLASH_RATE) {
					time = 0;
				}
			}
		}

		@Override
		protected void onPointerDown() {
			bg.brightness( 1.5f );
			Sample.INSTANCE.play( Assets.Sounds.CLICK );
		}

		@Override
		protected void onPointerUp() {
				bg.resetColor();
		}

		@Override
		protected void onClick() {
			time = 0;
			if (flashingPage != null){
				if (Document.ADVENTURERS_GUIDE.pageNames().contains(flashingPage)){
					GameScene.show( new WndStory( WndJournal.GuideTab.iconForPage(flashingPage),
							Document.ADVENTURERS_GUIDE.pageTitle(flashingPage),
							Document.ADVENTURERS_GUIDE.pageBody(flashingPage) ));
					Document.ADVENTURERS_GUIDE.readPage(flashingPage);
				} else {
					GameScene.show( new WndJournal() );
				}
				flashingPage = null;
			} else {
				GameScene.show( new WndJournal() );
			}
		}

	}

	private static class MenuButton extends Button {

		private Image image;
		private Image diffi1;
		private Image diffi2;
		private Image diffi3;
		private Image diffi4;
		private Image diffi5;

		public MenuButton() {
			super();

			width = image.width + 4;
			height = image.height + 4;

		}

		@Override
		protected void createChildren() {
			super.createChildren();

			image = new Image( Assets.Interfaces.MENU, 17, 2, 12, 11 );

			if (Challenges.activeChallenges() == 0) {
				diffi1 = new Image(Assets.Interfaces.DIFFI1, 0, 0, 38, 16);add( diffi1 );
			}

			if (Challenges.activeChallenges() == 1 || Challenges.activeChallenges() == 2) {
				diffi2 = new Image(Assets.Interfaces.DIFFI2, 0, 0, 65, 16);add( diffi2 );
			}

			if (Challenges.activeChallenges() == 3 || Challenges.activeChallenges() == 4 || Challenges.activeChallenges() == 5) {
				diffi3 = new Image(Assets.Interfaces.DIFFI3, 0, 0, 49, 16);add( diffi3 );
			}

			if (Challenges.activeChallenges() == 6 || Challenges.activeChallenges() == 7 || Challenges.activeChallenges() == 8 || Challenges.activeChallenges() == 9) {
				diffi4 = new Image(Assets.Interfaces.DIFFI4, 0, 0, 44, 16);add( diffi4 );
			}

			if (Challenges.activeChallenges() > 9) {
				diffi5 = new Image(Assets.Interfaces.DIFFI5, 0, 0, 63, 16);add( diffi5 );
			}
			add( image );
		}

		@Override
		protected void layout() {
			super.layout();

			image.x = x + 2;
			image.y = y + 2;
			if (Challenges.activeChallenges() == 0) {
				diffi1.x = x + -19-3;
				diffi1.y = y + 20;
			}
			if (Challenges.activeChallenges() == 1 || Challenges.activeChallenges() == 2) {
				diffi2.x = x + -33-17;
				diffi2.y = y + 20;
			}
			if (Challenges.activeChallenges() == 3 || Challenges.activeChallenges() == 4 || Challenges.activeChallenges() == 5) {
				diffi3.x = x + -25-8;
				diffi3.y = y + 20;
			}
			if (Challenges.activeChallenges() == 6 || Challenges.activeChallenges() == 7 || Challenges.activeChallenges() == 8 || Challenges.activeChallenges() == 9) {
				diffi4.x = x + -22-7;
				diffi4.y = y + 20;
			}
			if (Challenges.activeChallenges() > 9) {
				diffi5.x = x + -32-15;
				diffi5.y = y + 20;
			}
		}

		@Override
		protected void onPointerDown() {
			image.brightness( 1.5f );
			Sample.INSTANCE.play( Assets.Sounds.CLICK );
		}

		@Override
		protected void onPointerUp() {
			image.resetColor();
		}

		@Override
		protected void onClick() {
			GameScene.show( new WndGame() );
		}
	}
}