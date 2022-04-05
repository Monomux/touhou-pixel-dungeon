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

package com.touhoupixel.touhoupixeldungeon.windows;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.TouhouPixelDungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.scenes.PixelScene;
import com.touhoupixel.touhoupixeldungeon.sprites.HeroSprite;
import com.touhoupixel.touhoupixeldungeon.ui.BuffIcon;
import com.touhoupixel.touhoupixeldungeon.ui.BuffIndicator;
import com.touhoupixel.touhoupixeldungeon.ui.IconButton;
import com.touhoupixel.touhoupixeldungeon.ui.Icons;
import com.touhoupixel.touhoupixeldungeon.ui.RenderedTextBlock;
import com.touhoupixel.touhoupixeldungeon.ui.ScrollPane;
import com.touhoupixel.touhoupixeldungeon.ui.StatusPane;
import com.touhoupixel.touhoupixeldungeon.ui.TalentButton;
import com.touhoupixel.touhoupixeldungeon.ui.TalentsPane;
import com.touhoupixel.touhoupixeldungeon.ui.Window;
import com.watabou.gltextures.SmartTexture;
import com.watabou.gltextures.TextureCache;
import com.watabou.noosa.Group;
import com.watabou.noosa.Image;
import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.ui.Component;

import java.util.ArrayList;
import java.util.Locale;

public class WndHero extends WndTabbed {

	private static final int WIDTH		= 120;
	private static final int HEIGHT		= 140;

	private StatsTab stats;
	private TalentsTab talents;
	private BuffsTab buffs;

	public static int lastIdx = 0;

	public WndHero() {

		super();

		resize( WIDTH, HEIGHT );

		stats = new StatsTab();
		add( stats );

		talents = new TalentsTab();
		add(talents);
		talents.setRect(0, 0, WIDTH, HEIGHT);

		buffs = new BuffsTab();
		add( buffs );
		buffs.setRect(0, 0, WIDTH, HEIGHT);
		buffs.setupList();

		add( new IconTab( Icons.get(Icons.RANKINGS) ) {
			protected void select( boolean value ) {
				super.select( value );
				if (selected) lastIdx = 0;
				stats.visible = stats.active = selected;
			}
		} );
		add( new IconTab( Icons.get(Icons.TALENT) ) {
			protected void select( boolean value ) {
				super.select( value );
				if (selected) lastIdx = 1;
				if (selected) StatusPane.talentBlink = 0;
				talents.visible = talents.active = selected;
			}
		} );
		add( new IconTab( Icons.get(Icons.BUFFS) ) {
			protected void select( boolean value ) {
				super.select( value );
				if (selected) lastIdx = 2;
				buffs.visible = buffs.active = selected;
			}
		} );

		layoutTabs();

		talents.setRect(0, 0, WIDTH, HEIGHT);
		talents.pane.scrollTo(0, talents.pane.content().height() - talents.pane.height());
		talents.layout();

		select( lastIdx );
	}

	@Override
	public void offset(int xOffset, int yOffset) {
		super.offset(xOffset, yOffset);
		talents.layout();
		buffs.layout();
	}

	private class StatsTab extends Group {

		private static final int GAP = 6;

		private float pos;

		public StatsTab() {

			Hero hero = Dungeon.hero;

			IconTitle title = new IconTitle();
			title.icon( HeroSprite.avatar(hero.heroClass, hero.tier()) );
			if (hero.name().equals(hero.className()))
				title.label( Messages.get(this, "title", hero.lvl, hero.className() ).toUpperCase( Locale.ENGLISH ) );
			else
				title.label((hero.name() + "\n" + Messages.get(this, "title", hero.lvl, hero.className())).toUpperCase(Locale.ENGLISH));
			title.color(Window.TITLE_COLOR);
			title.setRect( 0, 0, WIDTH-16, 0 );
			add(title);

			IconButton infoButton = new IconButton(Icons.get(Icons.INFO)){
				@Override
				protected void onClick() {
					super.onClick();
					TouhouPixelDungeon.scene().addToFront(new WndHeroInfo(hero.heroClass));
				}
			};
			infoButton.setRect(title.right(), 0, 16, 16);
			add(infoButton);

			pos = title.bottom()+4;

			int strBonus = hero.STR() - hero.STR;
			if (strBonus > 0)           statSlot( Messages.get(this, "str"), hero.STR + " + " + strBonus );
			else if (strBonus < 0)      statSlot( Messages.get(this, "str"), hero.STR + " - " + -strBonus );
			else                        statSlot( Messages.get(this, "str"), hero.STR() );
			statSlot( Messages.get(this, "exp"), hero.exp + "/" + hero.maxExp() );
			statSlot( Messages.get(this, "fireres"), Statistics.fireres );
			statSlot( Messages.get(this, "coldres"), Statistics.coldres );
			statSlot( Messages.get(this, "warpres"), Statistics.warpres );
			statSlot( Messages.get(this, "powerfulres"), Statistics.powerfulres );
			statSlot( Messages.get(this, "coolres"), Statistics.coolres );
			statSlot( Messages.get(this, "pureres"), Statistics.pureres );
			statSlot( Messages.get(this, "happyres"), Statistics.happyres );
		}

		private void statSlot( String label, String value ) {

			RenderedTextBlock txt = PixelScene.renderTextBlock( label, 8 );
			txt.setPos(0, pos);
			add( txt );

			txt = PixelScene.renderTextBlock( value, 8 );
			txt.setPos(WIDTH * 0.6f, pos);
			PixelScene.align(txt);
			add( txt );

			pos += GAP + txt.height();
		}

		private void statSlot( String label, int value ) {
			statSlot( label, Integer.toString( value ) );
		}

		public float height() {
			return pos;
		}
	}

	public class TalentsTab extends Component {

		TalentsPane pane;

		@Override
		protected void createChildren() {
			super.createChildren();
			pane = new TalentsPane(TalentButton.Mode.UPGRADE);
			add(pane);
		}

		@Override
		protected void layout() {
			super.layout();
			pane.setRect(x, y, width, height);
		}

	}

	private class BuffsTab extends Component {

		private static final int GAP = 2;

		private float pos;
		private ScrollPane buffList;
		private ArrayList<BuffSlot> slots = new ArrayList<>();

		@Override
		protected void createChildren() {

			super.createChildren();

			buffList = new ScrollPane( new Component() ){
				@Override
				public void onClick( float x, float y ) {
					int size = slots.size();
					for (int i=0; i < size; i++) {
						if (slots.get( i ).onClick( x, y )) {
							break;
						}
					}
				}
			};
			add(buffList);
		}

		@Override
		protected void layout() {
			super.layout();
			buffList.setRect(0, 0, width, height);
		}

		private void setupList() {
			Component content = buffList.content();
			for (Buff buff : Dungeon.hero.buffs()) {
				if (buff.icon() != BuffIndicator.NONE) {
					BuffSlot slot = new BuffSlot(buff);
					slot.setRect(0, pos, WIDTH, slot.icon.height());
					content.add(slot);
					slots.add(slot);
					pos += GAP + slot.height();
				}
			}
			content.setSize(buffList.width(), pos);
			buffList.setSize(buffList.width(), buffList.height());
		}

		private class BuffSlot extends Component {

			private Buff buff;

			Image icon;
			RenderedTextBlock txt;

			public BuffSlot( Buff buff ){
				super();
				this.buff = buff;

				icon = new BuffIcon(buff, true);
				icon.y = this.y;
				add( icon );

				txt = PixelScene.renderTextBlock( buff.toString(), 8 );
				txt.setPos(
						icon.width + GAP,
						this.y + (icon.height - txt.height()) / 2
				);
				PixelScene.align(txt);
				add( txt );

			}

			@Override
			protected void layout() {
				super.layout();
				icon.y = this.y;
				txt.maxWidth((int)(width - icon.width()));
				txt.setPos(
						icon.width + GAP,
						this.y + (icon.height - txt.height()) / 2
				);
				PixelScene.align(txt);
			}

			protected boolean onClick ( float x, float y ) {
				if (inside( x, y )) {
					GameScene.show(new WndInfoBuff(buff));
					return true;
				} else {
					return false;
				}
			}
		}
	}
}