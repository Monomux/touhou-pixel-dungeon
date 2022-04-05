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

package com.touhoupixel.touhoupixeldungeon.windows;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Badges;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.PixelScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.ui.IconButton;
import com.touhoupixel.touhoupixeldungeon.ui.Icons;
import com.touhoupixel.touhoupixeldungeon.ui.RenderedTextBlock;
import com.touhoupixel.touhoupixeldungeon.ui.TalentButton;
import com.touhoupixel.touhoupixeldungeon.ui.TalentsPane;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;
import com.watabou.noosa.ui.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class WndHeroInfo extends WndTabbed {

	private HeroInfoTab heroInfo;
	private TalentInfoTab talentInfo;

	private static int WIDTH = 120;
	private static int MIN_HEIGHT = 125;
	private static int MARGIN = 2;

	public WndHeroInfo(HeroClass cl) {

		Image tabIcon;
		switch (cl){
			case WARRIOR:
			case REISENPLAYER:
			case NITORIPLAYER:
			case YUYUKOPLAYER:
			case MURASAPLAYER:
			case HINAPLAYER:
			case KAGUYAPLAYER:
			case YUKARIPLAYER:
			case JUNKOPLAYER:
			case KOGASAPLAYER: default:
				tabIcon = new ItemSprite(ItemSpriteSheet.SEAL, null);
				break;
			case MAGE:
				tabIcon = new ItemSprite(ItemSpriteSheet.MAGES_STAFF, null);
				break;
			case ROGUE:
				tabIcon = new ItemSprite(ItemSpriteSheet.ARTIFACT_CLOAK, null);
				break;
			case HUNTRESS:
				tabIcon = new ItemSprite(ItemSpriteSheet.SPIRIT_BOW, null);
				break;
		}

		int finalHeight = MIN_HEIGHT;

		heroInfo = new HeroInfoTab(cl);
		add(heroInfo);
		heroInfo.setSize(WIDTH, MIN_HEIGHT);
		finalHeight = (int) Math.max(finalHeight, heroInfo.height());

		add(new IconTab(tabIcon) {
			@Override
			protected void select(boolean value) {
				super.select(value);
				heroInfo.visible = heroInfo.active = value;
			}
		});

		talentInfo = new TalentInfoTab(cl);
		add(talentInfo);
		talentInfo.setSize(WIDTH, MIN_HEIGHT);
		finalHeight = (int) Math.max(finalHeight, talentInfo.height());

		add(new IconTab(Icons.get(Icons.TALENT)) {
			@Override
			protected void select(boolean value) {
				super.select(value);
				talentInfo.visible = talentInfo.active = value;
			}
		});

		resize(WIDTH, finalHeight);

		layoutTabs();
		talentInfo.layout();

		select(0);

	}

	private static class HeroInfoTab extends Component {

		private RenderedTextBlock title;
		private RenderedTextBlock[] info;
		private Image[] icons;

		public HeroInfoTab(HeroClass cls) {
			super();
			title = PixelScene.renderTextBlock(Messages.titleCase(cls.title()), 9);
			title.hardlight(TITLE_COLOR);
			add(title);

			String[] desc_entries = cls.desc().split("\n\n");

			info = new RenderedTextBlock[desc_entries.length];

			for (int i = 0; i < desc_entries.length; i++) {
				info[i] = PixelScene.renderTextBlock(desc_entries[i], 6);
				add(info[i]);
			}
			switch (cls){
				case WARRIOR:
				case REISENPLAYER:
				case NITORIPLAYER:
				case YUYUKOPLAYER:
				case MURASAPLAYER:
				case HINAPLAYER:
				case KAGUYAPLAYER:
				case YUKARIPLAYER:
				case JUNKOPLAYER:
				case KOGASAPLAYER: default:
					icons = new Image[]{ new ItemSprite(ItemSpriteSheet.SEAL),
							new ItemSprite(ItemSpriteSheet.WORN_SHORTSWORD),
							new ItemSprite(ItemSpriteSheet.SCROLL_ISAZ)};
					break;
				case MAGE:
					icons = new Image[]{ new ItemSprite(ItemSpriteSheet.MAGES_STAFF),
							new ItemSprite(ItemSpriteSheet.WAND_MAGIC_MISSILE),
							new ItemSprite(ItemSpriteSheet.SCROLL_ISAZ)};
					break;
				case ROGUE:
					icons = new Image[]{ new ItemSprite(ItemSpriteSheet.ARTIFACT_CLOAK),
							Icons.get(Icons.DEPTH),
							new ItemSprite(ItemSpriteSheet.DAGGER),
							new ItemSprite(ItemSpriteSheet.SCROLL_ISAZ)};
					break;
				case HUNTRESS:
					icons = new Image[]{ new ItemSprite(ItemSpriteSheet.SPIRIT_BOW),
							new Image(Assets.Environment.TILES_SEWERS, 112, 96, 16, 16),
							new ItemSprite(ItemSpriteSheet.GLOVES),
							new ItemSprite(ItemSpriteSheet.SCROLL_ISAZ)};
					break;
			}
			for (Image im : icons) {
				add(im);
			}

		}

		@Override
		protected void layout() {
			super.layout();

			title.setPos((width - title.width()) / 2, MARGIN);

			float pos = title.bottom() + 4 * MARGIN;

			for (int i = 0; i < info.length; i++) {
				info[i].maxWidth((int) width - 20);
				info[i].setPos(20, pos);

				icons[i].x = (20 - icons[i].width()) / 2;
				icons[i].y = info[i].top() + (info[i].height() - icons[i].height()) / 2;

				pos = info[i].bottom() + 4 * MARGIN;
			}

			height = Math.max(height, pos - 4 * MARGIN);

		}
	}

	private static class TalentInfoTab extends Component {

		private RenderedTextBlock title;
		private RenderedTextBlock message;
		private TalentsPane talentPane;

		public TalentInfoTab(HeroClass cls) {
			super();
			title = PixelScene.renderTextBlock(Messages.titleCase(Messages.get(WndHeroInfo.class, "talents")), 9);
			title.hardlight(TITLE_COLOR);
			add(title);

			message = PixelScene.renderTextBlock(Messages.get(WndHeroInfo.class, "talents_msg"), 6);
			add(message);

			ArrayList<LinkedHashMap<Talent, Integer>> talents = new ArrayList<>();
			Talent.initClassTalents(cls, talents);
			talents.get(2).clear(); //we show T3 talents with subclasses

			talentPane = new TalentsPane(TalentButton.Mode.INFO, talents);
			add(talentPane);
		}

		@Override
		protected void layout() {
			super.layout();

			title.setPos((width - title.width()) / 2, MARGIN);
			message.maxWidth((int) width);
			message.setPos(0, title.bottom() + 4 * MARGIN);

			talentPane.setRect(0, message.bottom() + 3 * MARGIN, width, 85);

			height = Math.max(height, talentPane.bottom());
		}
	}
}