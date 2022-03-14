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

package com.touhoupixel.touhoupixeldungeon.actors.blobs;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hunger;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.effects.BlobEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeon.effects.Speck;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeon.effects.particles.ShaftParticle;
import com.touhoupixel.touhoupixeldungeon.items.Ankh;
import com.touhoupixel.touhoupixeldungeon.items.Item;
import com.touhoupixel.touhoupixeldungeon.items.Waterskin;
import com.touhoupixel.touhoupixeldungeon.items.potions.PotionOfHealing;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfElements;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HisoutenMankind;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HorouBook;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.JeweledBranch;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.KeineBook;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.KokoroFan;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.NazrinRod;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Psalms;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.SwordofHisou;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.ToyohimeFan;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YorihimeSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YoumuSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YuyukoFoldingFan;
import com.touhoupixel.touhoupixeldungeon.journal.Notes.Landmark;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;

public class WaterOfHealth extends WellWater {

	@Override
	protected boolean affectHero( Hero hero ) {

		if (!hero.isAlive()) return false;

		Sample.INSTANCE.play( Assets.Sounds.DRINK );

		PotionOfHealing.cure( hero );
		hero.belongings.uncurseEquipped();
		hero.buff( Hunger.class ).satisfy( Hunger.STARVING );

		hero.HP = hero.HT;
		hero.sprite.emitter().start( Speck.factory( Speck.HEALING ), 0.4f, 4 );

		CellEmitter.get( hero.pos ).start( ShaftParticle.FACTORY, 0.2f, 3 );

		Dungeon.hero.interrupt();

		GLog.p( Messages.get(this, "procced") );

		return true;
	}

	@Override
	protected Item affectItem( Item item, int pos ) {
		if (item instanceof Waterskin && !((Waterskin)item).isFull()) {
			((Waterskin)item).fill();
			CellEmitter.get( pos ).start( Speck.factory( Speck.HEALING ), 0.4f, 4 );
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		} else if ( item instanceof Ankh && !(((Ankh) item).isBlessed())){
			((Ankh) item).bless();
			CellEmitter.get( pos ).start(Speck.factory(Speck.LIGHT), 0.2f, 3);
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		} else if ( item instanceof NazrinRod){
			JeweledBranch Transmute1 = new JeweledBranch();
			Transmute1.collect();
			CellEmitter.get( pos ).start(Speck.factory(Speck.LIGHT), 0.2f, 3);
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		} else if ( item instanceof KokoroFan){
			ToyohimeFan Transmute2 = new ToyohimeFan();
			Transmute2.collect();
			CellEmitter.get( pos ).start(Speck.factory(Speck.LIGHT), 0.2f, 3);
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		} else if ( item instanceof YuyukoFoldingFan){
			ToyohimeFan Transmute3 = new ToyohimeFan();
			Transmute3.collect();
			CellEmitter.get( pos ).start(Speck.factory(Speck.LIGHT), 0.2f, 3);
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		} else if ( item instanceof SwordofHisou){
			HisoutenMankind Transmute4 = new HisoutenMankind();
			Transmute4.collect();
			CellEmitter.get( pos ).start(Speck.factory(Speck.LIGHT), 0.2f, 3);
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		} else if ( item instanceof YoumuSword){
			YorihimeSword Transmute5 = new YorihimeSword();
			Transmute5.collect();
			CellEmitter.get( pos ).start(Speck.factory(Speck.LIGHT), 0.2f, 3);
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		} else if ( item instanceof RingOfElements){
			YorihimeSword Transmute6 = new YorihimeSword();
			Transmute6.collect();
			CellEmitter.get( pos ).start(Speck.factory(Speck.LIGHT), 0.2f, 3);
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		} else if ( item instanceof KeineBook){
			Psalms Transmute7 = new Psalms();
			Transmute7.collect();
			CellEmitter.get( pos ).start(Speck.factory(Speck.LIGHT), 0.2f, 3);
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		} else if ( item instanceof HorouBook){
			Psalms Transmute8 = new Psalms();
			Transmute8.collect();
			CellEmitter.get( pos ).start(Speck.factory(Speck.LIGHT), 0.2f, 3);
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		} else if (ScrollOfRemoveCurse.uncursable(item)) {
			if (ScrollOfRemoveCurse.uncurse( null, item )){
				CellEmitter.get( pos ).start( ShadowParticle.UP, 0.05f, 10 );
			}
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			return item;
		}
		return null;
	}

	@Override
	protected Landmark record() {
		return Landmark.WELL_OF_HEALTH;
	}

	@Override
	public void use( BlobEmitter emitter ) {
		super.use( emitter );
		emitter.start( Speck.factory( Speck.HEALING ), 0.5f, 0 );
	}

	@Override
	public String tileDesc() {
		return Messages.get(this, "desc");
	}
}
