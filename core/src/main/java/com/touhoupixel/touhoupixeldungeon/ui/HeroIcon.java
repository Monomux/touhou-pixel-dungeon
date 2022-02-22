package com.touhoupixel.touhoupixeldungeon.ui;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass;
import com.touhoupixel.touhoupixeldungeon.actors.hero.abilities.ArmorAbility;
import com.watabou.noosa.Image;
import com.watabou.noosa.TextureFilm;

//icons for hero subclasses and abilities atm, maybe add classes?
public class HeroIcon extends Image {

	private static TextureFilm film;
	private static final int SIZE = 16;

	//transparent icon
	public static final int NONE    = 31;

	//subclasses
	public static final int BERSERKER   = 0;
	public static final int GLADIATOR   = 1;
	public static final int BATTLEMAGE  = 2;
	public static final int WARLOCK     = 3;
	public static final int ASSASSIN    = 4;
	public static final int FREERUNNER  = 5;
	public static final int SNIPER      = 6;
	public static final int WARDEN      = 7;
	public static final int MOONRABBIT      = 21;
	public static final int DESERTER      = 22;
	public static final int KAPPA      = 23;
	public static final int ENGINEER      = 24;
	public static final int GOURMET      = 31;
	public static final int DEATHGHOST      = 32;
	public static final int CAPTAIN      = 36;
	public static final int SHIPGHOST      = 37;
	public static final int SPINGOD      = 41;
	public static final int CURSEGOD      = 42;
	public static final int TIMESTOP      = 46;
	public static final int TIMEMOVE      = 47;

	//abilities
	public static final int HEROIC_LEAP     = 8;
	public static final int SHOCKWAVE       = 9;
	public static final int ENDURE          = 10;
	public static final int ELEMENTAL_BLAST = 11;
	public static final int WILD_MAGIC      = 12;
	public static final int WARP_BEACON     = 13;
	public static final int SMOKE_BOMB      = 14;
	public static final int DEATH_MARK      = 15;
	public static final int SHADOW_CLONE    = 16;
	public static final int SPECTRAL_BLADES = 17;
	public static final int NATURES_POWER   = 18;
	public static final int SPIRIT_HAWK     = 19;
	public static final int RATMOGRIFY      = 20;
	public static final int EIRINAB      = 25;
	public static final int KAGUYAAB      = 26;
	public static final int ULTDESERTER      = 27;
	public static final int BLACKKAPPA     = 28;
	public static final int YELLOWKAPPA      = 29;
	public static final int GREENKAPPA      = 30;
	public static final int DEATHEATER     = 33;
	public static final int NETHERGIRL      = 34;
	public static final int CBGIRL      = 35;
	public static final int REDVENTORA     = 38;
	public static final int BLUEVENTORA      = 39;
	public static final int GREENVENTORA      = 40;
	public static final int SUPERSPINGOD     = 43;
	public static final int SUPERCURSEGOD      = 44;
	public static final int SUPERMEDICINE      = 45;
	public static final int EIRINAB2     = 48;
	public static final int KAGUYAAB2      = 49;
	public static final int MOKOUAB2      = 50;

	public HeroIcon(HeroSubClass subCls){
		super( Assets.Interfaces.HERO_ICONS );
		if (film == null){
			film = new TextureFilm(texture, SIZE, SIZE);
		}
		frame(film.get(subCls.icon()));
	}

	public HeroIcon(ArmorAbility abil){
		super( Assets.Interfaces.HERO_ICONS );
		if (film == null){
			film = new TextureFilm(texture, SIZE, SIZE);
		}
		frame(film.get(abil.icon()));
	}

}