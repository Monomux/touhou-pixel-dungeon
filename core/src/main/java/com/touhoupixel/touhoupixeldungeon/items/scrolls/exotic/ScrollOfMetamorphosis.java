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

package com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Adrenaline;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AdrenalineSurge;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AnkhInvulnerability;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArcaneArmor;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArtifactRecharge;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Awareness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Barkskin;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.BlobImmunity;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doubleevasion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Foresight;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FrostImbue;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Healing;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Invisibility;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Levitation;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Light;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MagicImmune;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MagicalSight;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MindVision;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.PotionPreserve;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.PrismaticGuard;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Recharging;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.RingoSurge;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ScrollEmpower;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Stamina;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ToxicImbue;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.WellFed;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroClass;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.effects.Transmuting;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.InventoryScroll;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.scenes.PixelScene;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSprite;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.ui.RenderedTextBlock;
import com.touhoupixel.touhoupixeldungeon.ui.TalentButton;
import com.touhoupixel.touhoupixeldungeon.ui.TalentsPane;
import com.touhoupixel.touhoupixeldungeon.ui.Window;
import com.touhoupixel.touhoupixeldungeon.windows.IconTitle;
import com.touhoupixel.touhoupixeldungeon.windows.WndOptions;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class ScrollOfMetamorphosis extends ExoticScroll {

	{
		icon = ItemSpriteSheet.Icons.SCROLL_METAMORPH;
	}

	protected static boolean identifiedByUse = false;

	@Override
	public void doRead() {
		if (!isKnown()) {
			identify();
			identifiedByUse = true;
		} else {
			identifiedByUse = false;
		}

		switch (Random.Int(32)) {
			case 0:
			default:
				Buff.prolong(curUser, Adrenaline.class, Adrenaline.DURATION);
				break;
			case 1:
				Buff.affect(curUser, AdrenalineSurge.class).reset(2, 200f);
				break;
			case 2:
				Buff.prolong(curUser, AnkhInvulnerability.class, AnkhInvulnerability.DURATION);
				break;
			case 3:
				Buff.affect(curUser, ArcaneArmor.class).set(5 + curUser.lvl/2, 80);
				break;
			case 4:
				Buff.affect(curUser, ArtifactRecharge.class).prolong( 8 ).ignoreHornOfPlenty = false;
				break;
			case 5:
				Buff.affect(curUser, Awareness.class, Awareness.DURATION );
				break;
			case 6:
				Buff.affect(curUser, Barkskin.class ).set(curUser.HT / 4, 1 );
				break;
			case 7:
				Buff.prolong(curUser, Bless.class, Bless.DURATION);
				break;
			case 8:
				Buff.prolong(curUser, BlobImmunity.class, BlobImmunity.DURATION );
				break;
			case 9:
				Buff.prolong(curUser, Doubleevasion.class, Doubleevasion.DURATION);
				break;
			case 10:
				Buff.prolong(curUser, Doublespeed.class, Doublespeed.DURATION);
				break;
			case 11:
				Buff.affect(curUser, Foresight.class, Foresight.DURATION);
				break;
			case 12:
				Buff.affect(curUser, FrostImbue.class, FrostImbue.DURATION );
				break;
			case 13:
				Buff.prolong(curUser, Haste.class, Haste.DURATION);
				break;
			case 14:
				Buff.affect(curUser, Healing.class).setHeal((int) (0.8f * curUser.HT + 14), 0.25f, 0);
				break;
			case 15:
				Buff.prolong(curUser, Hisou.class, Hisou.DURATION);
				break;
			case 16:
				Buff.prolong(curUser, Invisibility.class, Invisibility.DURATION);
				break;
			case 17:
				Buff.prolong(curUser, Levitation.class, Levitation.DURATION);
				break;
			case 18:
				Buff.prolong(curUser, Light.class, Light.DURATION);
				break;
			case 19:
				Buff.prolong(curUser, MagicalSight.class, MagicalSight.DURATION);
				break;
			case 20:
				Buff.prolong(curUser, MagicImmune.class, MagicImmune.DURATION);
				break;
			case 21:
				Buff.prolong(curUser, Might.class, Might.DURATION);
				break;
			case 22:
				Buff.prolong(curUser, MindVision.class, MindVision.DURATION);
				break;
			case 23:
				Buff.prolong(curUser, PotionPreserve.class, PotionPreserve.DURATION);
				break;
			case 24:
				Buff.affect(curUser, PrismaticGuard.class).set( PrismaticGuard.maxHP( curUser ) );
				break;
			case 25:
				Buff.affect(curUser, Recharging.class, 2f ); //half of a charge
				break;
			case 26:
				Buff.affect(curUser, RingoSurge.class).reset(2, 200f);
				break;
			case 27:
				Buff.affect(curUser, ScrollEmpower.class);
				break;
			case 28:
				Buff.prolong(curUser, Stamina.class, Stamina.DURATION);
				break;
			case 29:
				Buff.affect(curUser, ToxicImbue.class).set(ToxicImbue.DURATION);
				break;
			case 30:
				Buff.prolong(curUser, Triplespeed.class, Triplespeed.DURATION);
				break;
			case 31:
				Buff.affect(curUser, WellFed.class).reset();
				break;
		}

		switch (Random.Int(32)) {
			case 0:
			default:
				Buff.prolong(curUser, Adrenaline.class, Adrenaline.DURATION);
				break;
			case 1:
				Buff.affect(curUser, AdrenalineSurge.class).reset(2, 200f);
				break;
			case 2:
				Buff.prolong(curUser, AnkhInvulnerability.class, AnkhInvulnerability.DURATION);
				break;
			case 3:
				Buff.affect(curUser, ArcaneArmor.class).set(5 + curUser.lvl/2, 80);
				break;
			case 4:
				Buff.affect(curUser, ArtifactRecharge.class).prolong( 8 ).ignoreHornOfPlenty = false;
				break;
			case 5:
				Buff.affect(curUser, Awareness.class, Awareness.DURATION );
				break;
			case 6:
				Buff.affect(curUser, Barkskin.class ).set(curUser.HT / 4, 1 );
				break;
			case 7:
				Buff.prolong(curUser, Bless.class, Bless.DURATION);
				break;
			case 8:
				Buff.prolong(curUser, BlobImmunity.class, BlobImmunity.DURATION );
				break;
			case 9:
				Buff.prolong(curUser, Doubleevasion.class, Doubleevasion.DURATION);
				break;
			case 10:
				Buff.prolong(curUser, Doublespeed.class, Doublespeed.DURATION);
				break;
			case 11:
				Buff.affect(curUser, Foresight.class, Foresight.DURATION);
				break;
			case 12:
				Buff.affect(curUser, FrostImbue.class, FrostImbue.DURATION );
				break;
			case 13:
				Buff.prolong(curUser, Haste.class, Haste.DURATION);
				break;
			case 14:
				Buff.affect(curUser, Healing.class).setHeal((int) (0.8f * curUser.HT + 14), 0.25f, 0);
				break;
			case 15:
				Buff.prolong(curUser, Hisou.class, Hisou.DURATION);
				break;
			case 16:
				Buff.prolong(curUser, Invisibility.class, Invisibility.DURATION);
				break;
			case 17:
				Buff.prolong(curUser, Levitation.class, Levitation.DURATION);
				break;
			case 18:
				Buff.prolong(curUser, Light.class, Light.DURATION);
				break;
			case 19:
				Buff.prolong(curUser, MagicalSight.class, MagicalSight.DURATION);
				break;
			case 20:
				Buff.prolong(curUser, MagicImmune.class, MagicImmune.DURATION);
				break;
			case 21:
				Buff.prolong(curUser, Might.class, Might.DURATION);
				break;
			case 22:
				Buff.prolong(curUser, MindVision.class, MindVision.DURATION);
				break;
			case 23:
				Buff.prolong(curUser, PotionPreserve.class, PotionPreserve.DURATION);
				break;
			case 24:
				Buff.affect(curUser, PrismaticGuard.class).set( PrismaticGuard.maxHP( curUser ) );
				break;
			case 25:
				Buff.affect(curUser, Recharging.class, 2f ); //half of a charge
				break;
			case 26:
				Buff.affect(curUser, RingoSurge.class).reset(2, 200f);
				break;
			case 27:
				Buff.affect(curUser, ScrollEmpower.class);
				break;
			case 28:
				Buff.prolong(curUser, Stamina.class, Stamina.DURATION);
				break;
			case 29:
				Buff.affect(curUser, ToxicImbue.class).set(ToxicImbue.DURATION);
				break;
			case 30:
				Buff.prolong(curUser, Triplespeed.class, Triplespeed.DURATION);
				break;
			case 31:
				Buff.affect(curUser, WellFed.class).reset();
				break;
		}

		switch (Random.Int(32)) {
			case 0:
			default:
				Buff.prolong(curUser, Adrenaline.class, Adrenaline.DURATION);
				break;
			case 1:
				Buff.affect(curUser, AdrenalineSurge.class).reset(2, 200f);
				break;
			case 2:
				Buff.prolong(curUser, AnkhInvulnerability.class, AnkhInvulnerability.DURATION);
				break;
			case 3:
				Buff.affect(curUser, ArcaneArmor.class).set(5 + curUser.lvl/2, 80);
				break;
			case 4:
				Buff.affect(curUser, ArtifactRecharge.class).prolong( 8 ).ignoreHornOfPlenty = false;
				break;
			case 5:
				Buff.affect(curUser, Awareness.class, Awareness.DURATION );
				break;
			case 6:
				Buff.affect(curUser, Barkskin.class ).set(curUser.HT / 4, 1 );
				break;
			case 7:
				Buff.prolong(curUser, Bless.class, Bless.DURATION);
				break;
			case 8:
				Buff.prolong(curUser, BlobImmunity.class, BlobImmunity.DURATION );
				break;
			case 9:
				Buff.prolong(curUser, Doubleevasion.class, Doubleevasion.DURATION);
				break;
			case 10:
				Buff.prolong(curUser, Doublespeed.class, Doublespeed.DURATION);
				break;
			case 11:
				Buff.affect(curUser, Foresight.class, Foresight.DURATION);
				break;
			case 12:
				Buff.affect(curUser, FrostImbue.class, FrostImbue.DURATION );
				break;
			case 13:
				Buff.prolong(curUser, Haste.class, Haste.DURATION);
				break;
			case 14:
				Buff.affect(curUser, Healing.class).setHeal((int) (0.8f * curUser.HT + 14), 0.25f, 0);
				break;
			case 15:
				Buff.prolong(curUser, Hisou.class, Hisou.DURATION);
				break;
			case 16:
				Buff.prolong(curUser, Invisibility.class, Invisibility.DURATION);
				break;
			case 17:
				Buff.prolong(curUser, Levitation.class, Levitation.DURATION);
				break;
			case 18:
				Buff.prolong(curUser, Light.class, Light.DURATION);
				break;
			case 19:
				Buff.prolong(curUser, MagicalSight.class, MagicalSight.DURATION);
				break;
			case 20:
				Buff.prolong(curUser, MagicImmune.class, MagicImmune.DURATION);
				break;
			case 21:
				Buff.prolong(curUser, Might.class, Might.DURATION);
				break;
			case 22:
				Buff.prolong(curUser, MindVision.class, MindVision.DURATION);
				break;
			case 23:
				Buff.prolong(curUser, PotionPreserve.class, PotionPreserve.DURATION);
				break;
			case 24:
				Buff.affect(curUser, PrismaticGuard.class).set( PrismaticGuard.maxHP( curUser ) );
				break;
			case 25:
				Buff.affect(curUser, Recharging.class, 2f ); //half of a charge
				break;
			case 26:
				Buff.affect(curUser, RingoSurge.class).reset(2, 200f);
				break;
			case 27:
				Buff.affect(curUser, ScrollEmpower.class);
				break;
			case 28:
				Buff.prolong(curUser, Stamina.class, Stamina.DURATION);
				break;
			case 29:
				Buff.affect(curUser, ToxicImbue.class).set(ToxicImbue.DURATION);
				break;
			case 30:
				Buff.prolong(curUser, Triplespeed.class, Triplespeed.DURATION);
				break;
			case 31:
				Buff.affect(curUser, WellFed.class).reset();
				break;
		}

		switch (Random.Int(9)) {
			case 0:
			default:
				Buff.prolong(curUser, Doublespeed.class, Doublespeed.DURATION);
				break;
			case 1:
				Buff.prolong(curUser, Triplespeed.class, Triplespeed.DURATION);
				break;
			case 2:
				Buff.prolong(curUser, Might.class, Might.DURATION);
				break;
			case 3:
				Buff.prolong(curUser, Hisou.class, Hisou.DURATION);
				break;
			case 4:
				Buff.prolong(curUser, Haste.class, Haste.DURATION);
				break;
			case 5:
				Buff.prolong(curUser, Bless.class, Bless.DURATION);
				break;
			case 6:
				Buff.prolong(curUser, Adrenaline.class, Adrenaline.DURATION);
				break;
			case 7:
				Buff.prolong(curUser, Doubleevasion.class, Doubleevasion.DURATION);
				break;
			case 8:
				Buff.prolong(curUser, MagicImmune.class, MagicImmune.DURATION);
				break;
		}

		//GameScene.show(new WndMetamorphChoose());
		//currently, I don't know how to make stable, so replaced it with another effect... sorry.
	}

	public static void onMetamorph( Talent oldTalent, Talent newTalent ){
		((ScrollOfMetamorphosis) curItem).readAnimation();
		Sample.INSTANCE.play( Assets.Sounds.READ );
		curUser.sprite.emitter().start(Speck.factory(Speck.CHANGE), 0.2f, 10);
		Transmuting.show(curUser, oldTalent, newTalent);
	}

	private void confirmCancelation( Window chooseWindow ) {
		GameScene.show( new WndOptions(new ItemSprite(this),
				Messages.titleCase(name()),
				Messages.get(InventoryScroll.class, "warning"),
				Messages.get(InventoryScroll.class, "yes"),
				Messages.get(InventoryScroll.class, "no") ) {
			@Override
			protected void onSelect( int index ) {
				switch (index) {
					case 0:
						curUser.spendAndNext( TIME_TO_READ );
						identifiedByUse = false;
						chooseWindow.hide();
						break;
					case 1:
						//do nothing
						break;
				}
			}
			public void onBackPressed() {}
		} );
	}

	public static class WndMetamorphChoose extends Window {

		public static WndMetamorphChoose INSTANCE;

		public WndMetamorphChoose(){
			super();

			INSTANCE = this;

			float top = 0;

			IconTitle title = new IconTitle( curItem );
			title.color( TITLE_COLOR );
			title.setRect(0, 0, 120, 0);
			add(title);

			top = title.bottom() + 2;

			RenderedTextBlock text = PixelScene.renderTextBlock(Messages.get(ScrollOfMetamorphosis.class, "choose_desc"), 6);
			text.maxWidth(120);
			text.setPos(0, top);
			add(text);

			top = text.bottom() + 2;

			ArrayList<LinkedHashMap<Talent, Integer>> talents = new ArrayList<>();
			Talent.initClassTalents(Dungeon.hero.heroClass, talents, Dungeon.hero.metamorphedTalents);

			for (LinkedHashMap<Talent, Integer> tier : talents){
				for (Talent talent : tier.keySet()){
					tier.put(talent, Dungeon.hero.pointsInTalent(talent));
				}
			}

			TalentsPane p = new TalentsPane(TalentButton.Mode.METAMORPH_CHOOSE, talents);
			add(p);
			p.setPos(0, top);
			p.setSize(120, p.content().height());
			resize((int)p.width(), (int)p.bottom());
			p.setPos(0, top);
		}

		@Override
		public void hide() {
			super.hide();
			INSTANCE = null;
		}

		@Override
		public void onBackPressed() {

			if (identifiedByUse){
				((ScrollOfMetamorphosis)curItem).confirmCancelation(this);
			} else {
				super.onBackPressed();
				curItem.collect();
			}
		}
	}

	public static class WndMetamorphReplace extends Window {

		//talents that can only be used by one hero class
		//TODO could some of these be made more generic?
		private static HashMap<Talent, HeroClass> restrictedTalents = new HashMap<>();
		static {
			restrictedTalents.put(Talent.IRON_WILL, HeroClass.WARRIOR);
			restrictedTalents.put(Talent.RESTORED_WILLPOWER, HeroClass.WARRIOR);
			restrictedTalents.put(Talent.RUNIC_TRANSFERENCE, HeroClass.WARRIOR);

			restrictedTalents.put(Talent.BACKUP_BARRIER, HeroClass.MAGE);
			restrictedTalents.put(Talent.ENERGIZING_UPGRADE, HeroClass.MAGE);
			restrictedTalents.put(Talent.WAND_PRESERVATION, HeroClass.MAGE);

			restrictedTalents.put(Talent.PROTECTIVE_SHADOWS, HeroClass.ROGUE);
			restrictedTalents.put(Talent.MYSTICAL_UPGRADE, HeroClass.ROGUE);
			restrictedTalents.put(Talent.LIGHT_CLOAK, HeroClass.ROGUE);

			restrictedTalents.put(Talent.SEER_SHOT, HeroClass.HUNTRESS);
		}

		public static WndMetamorphReplace INSTANCE;

		public Talent replacing;
		public int tier;
		LinkedHashMap<Talent, Integer> replaceOptions;

		//for window restoring
		public WndMetamorphReplace(){
			super();

			if (INSTANCE != null){
				replacing = INSTANCE.replacing;
				tier = INSTANCE.tier;
				replaceOptions = INSTANCE.replaceOptions;
				INSTANCE = this;
				setup(replacing, tier, replaceOptions);
			} else {
				hide();
			}
		}

		public WndMetamorphReplace(Talent replacing, int tier){
			super();

			INSTANCE = this;

			this.replacing = replacing;
			this.tier = tier;

			LinkedHashMap<Talent, Integer> options = new LinkedHashMap<>();
			Set<Talent> curTalentsAtTier = Dungeon.hero.talents.get(tier-1).keySet();

			for (HeroClass cls : HeroClass.values()){
				ArrayList<LinkedHashMap<Talent, Integer>> clsTalents = new ArrayList<>();
				Talent.initClassTalents(cls, clsTalents);

				Set<Talent> clsTalentsAtTier = clsTalents.get(tier-1).keySet();
				boolean replacingIsInSet = false;
				for (Talent talent : clsTalentsAtTier.toArray(new Talent[0])){
					if (talent == replacing){
						replacingIsInSet = true;
						break;
					} else {
						if (curTalentsAtTier.contains(talent)){
							clsTalentsAtTier.remove(talent);
						}
						if (restrictedTalents.containsKey(talent)
								&& restrictedTalents.get(talent) != curUser.heroClass){
							clsTalentsAtTier.remove(talent);
						}
					}
				}
				if (!replacingIsInSet && !clsTalentsAtTier.isEmpty()) {
					options.put(Random.element(clsTalentsAtTier), Dungeon.hero.pointsInTalent(replacing));
				}
			}

			replaceOptions = options;
			setup(replacing, tier, options);
		}

		private void setup(Talent replacing, int tier, LinkedHashMap<Talent, Integer> replaceOptions){
			float top = 0;

			IconTitle title = new IconTitle( curItem );
			title.color( TITLE_COLOR );
			title.setRect(0, 0, 120, 0);
			add(title);

			top = title.bottom() + 2;

			RenderedTextBlock text = PixelScene.renderTextBlock(Messages.get(ScrollOfMetamorphosis.class, "replace_desc"), 6);
			text.maxWidth(120);
			text.setPos(0, top);
			add(text);

			top = text.bottom() + 2;

			TalentsPane.TalentTierPane optionsPane = new TalentsPane.TalentTierPane(replaceOptions, tier, TalentButton.Mode.METAMORPH_REPLACE);
			add(optionsPane);
			optionsPane.title.text(" ");
			optionsPane.setPos(0, top);
			optionsPane.setSize(120, optionsPane.height());
			resize((int)optionsPane.width(), (int)optionsPane.bottom());

			resize(120, (int)optionsPane.bottom());
		}

		@Override
		public void hide() {
			super.hide();
			if (INSTANCE == this) {
				INSTANCE = null;
			}
		}

		@Override
		public void onBackPressed() {
			((ScrollOfMetamorphosis)curItem).confirmCancelation(this);
		}
	}
}


