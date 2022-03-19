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

package com.touhoupixel.touhoupixeldungeon.actors.buffs;

import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.CloakOfShadows;
import com.touhoupixel.touhoupixeldungeon.items.artifacts.TimekeepersHourglass;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.plants.Swiftthistle;
import com.touhoupixel.touhoupixeldungeon.sprites.CharSprite;
import com.touhoupixel.touhoupixeldungeon.ui.BuffIndicator;

public class Invisibility extends FlavourBuff {

	public static final float DURATION	= 20f;

	{
		type = buffType.POSITIVE;
		announced = true;
	}

	@Override
	public boolean attachTo( Char target ) {
		if (Dungeon.isChallenged(Challenges.SPELLCARD_RULE)){
			Buff.prolong(target, MurasaInfEvasion.class, MurasaInfEvasion.DURATION);
		} else if (super.attachTo( target )) {
			target.invisible++;
			if (target instanceof Hero && ((Hero) target).subClass == HeroSubClass.ASSASSIN){
				Buff.affect(target, Preparation.class);
			}
			return true;
		} else {
		}
		return false;
	}
	
	@Override
	public void detach() {
		if (target.invisible > 0)
			target.invisible--;
		super.detach();
	}
	
	@Override
	public int icon() {
		return BuffIndicator.INVISIBLE;
	}

	@Override
	public float iconFadePercent() {
		return Math.max(0, (DURATION - visualcooldown()) / DURATION);
	}

	@Override
	public void fx(boolean on) {
		if (on) target.sprite.add( CharSprite.State.INVISIBLE );
		else if (target.invisible == 0) target.sprite.remove( CharSprite.State.INVISIBLE );
	}

	@Override
	public String toString() {
		return Messages.get(this, "name");
	}

	@Override
	public String desc() {
		return Messages.get(this, "desc", dispTurns());
	}

	public static void dispel() {
		for ( Buff invis : Dungeon.hero.buffs( Invisibility.class )){
			invis.detach();
		}
		CloakOfShadows.cloakStealth cloakBuff = Dungeon.hero.buff( CloakOfShadows.cloakStealth.class );
		if (cloakBuff != null) {
			cloakBuff.dispel();
		}
		
		//these aren't forms of invisibilty, but do dispel at the same time as it.
		TimekeepersHourglass.timeFreeze timeFreeze = Dungeon.hero.buff( TimekeepersHourglass.timeFreeze.class );
		if (timeFreeze != null) {
			timeFreeze.detach();
		}
		
		Preparation prep = Dungeon.hero.buff( Preparation.class );
		if (prep != null){
			prep.detach();
		}
		
		Swiftthistle.TimeBubble bubble =  Dungeon.hero.buff( Swiftthistle.TimeBubble.class );
		if (bubble != null){
			bubble.detach();
		}
	}
}
