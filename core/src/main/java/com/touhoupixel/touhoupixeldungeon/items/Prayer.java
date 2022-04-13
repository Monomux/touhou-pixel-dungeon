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
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AnkhInvulnerability;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AntiHeal;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Burning;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Degrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.HighStress;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hunger;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Ooze;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Silence;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SuperDegrade;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SuperOoze;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;

import java.util.ArrayList;

public class Prayer extends Item {

	private static final int MAX_VOLUME	= 20;

	private static final String AC_DRINK	= "DRINK";

	private static final float TIME_TO_DRINK = 1f;

	private static final String TXT_STATUS	= "%d/%d";

	{
		image = ItemSpriteSheet.PRAYER;

		defaultAction = AC_DRINK;

		unique = true;
	}

	private int volume = 0;

	private static final String VOLUME	= "volume";

	@Override
	public void storeInBundle( Bundle bundle ) {
		super.storeInBundle( bundle );
		bundle.put( VOLUME, volume );
	}

	@Override
	public void restoreFromBundle( Bundle bundle ) {
		super.restoreFromBundle( bundle );
		volume	= bundle.getInt( VOLUME );
	}

	@Override
	public ArrayList<String> actions( Hero hero ) {
		ArrayList<String> actions = super.actions( hero );
		actions.remove(AC_DROP);
		actions.remove(AC_THROW);
		if (volume > 19) {
			actions.add( AC_DRINK );
		}
		return actions;
	}

	@Override
	public void execute( final Hero hero, String action ) {

		super.execute(hero, action);

		if (action.equals(AC_DRINK)) {
			if( Dungeon.depth == 46 ||Dungeon.depth == 47 ||Dungeon.depth == 48 ||Dungeon.depth == 49 ||Dungeon.depth == 50 ||Dungeon.depth == 96 ||Dungeon.depth == 97 ||Dungeon.depth == 98 ||Dungeon.depth == 99 ||Dungeon.depth == 100){
				GLog.i(Messages.get(this, "gehennom"));
			} else if (hero.buff( Silence.class ) != null) {
				GLog.w(Messages.get(this, "silence"));
			} else if (volume > 19) {
				if ( hero.buff(AntiHeal.class) != null ){
					hero.damage(hero.HP/2, this);
				} else
				PotionOfHealing.cure(hero);
				Buff.affect(hero, AnkhInvulnerability.class, AnkhInvulnerability.DURATION);
				hero.sprite.emitter().burst(Speck.factory(Speck.HEALING), 1);
				hero.belongings.uncurseEquipped();
				hero.buff(Hunger.class).satisfy( Hunger.STARVING );
				Degrade.detach( curUser, Degrade.class );
				SuperDegrade.detach( curUser, SuperDegrade.class );
				Ooze.detach( curUser, Ooze.class );
				SuperOoze.detach( curUser, SuperOoze.class );
				Burning.detach( curUser, Burning.class );
				if (hero.HP < hero.HT) {
					hero.HP = Math.min(hero.HP + hero.HT, hero.HT);
				}
				volume = 0;
				GLog.p( Messages.get(this, "pray") );

				hero.spend(TIME_TO_DRINK);
				hero.busy();

				Sample.INSTANCE.play(Assets.Sounds.DRINK);
				hero.sprite.operate(hero.pos);

				updateQuickslot();
			} else GLog.i( Messages.get(this, "notready") );
		}
	}

	@Override
	public String info() {
		String info = desc();

		if (volume >= 0){
			info += "\n\n" + Messages.get(this, "desc_water");
		}

		return info;
	}

	public void empty() {
		volume = 0;
		updateQuickslot();
	}

	@Override
	public boolean isUpgradable() {
		return false;
	}

	@Override
	public boolean isIdentified() {
		return true;
	}

	public boolean isFull() {
		return volume >= MAX_VOLUME;
	}

	public void collectPray( Gold gold ) {

		GLog.i( Messages.get(this, "collected") );
		volume += 1;
		if (volume >= MAX_VOLUME) {
			volume = MAX_VOLUME;
			GLog.p( Messages.get(this, "full") );
		}

		updateQuickslot();
	}

	public void fill() {
		volume = MAX_VOLUME;
		updateQuickslot();
	}

	@Override
	public String status() {
		return Messages.format( TXT_STATUS, volume, MAX_VOLUME );
	}

}
