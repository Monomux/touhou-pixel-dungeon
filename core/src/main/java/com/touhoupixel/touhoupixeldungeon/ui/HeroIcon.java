package com.touhoupixel.touhoupixeldungeon.ui;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass;
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
	public static final int MOONRABBIT      = 8;
	public static final int DESERTER      = 9;
	public static final int KAPPA      = 10;
	public static final int ENGINEER      = 11;
	public static final int GOURMET      = 12;
	public static final int DEATHGHOST      = 13;
	public static final int CAPTAIN      = 14;
	public static final int SHIPGHOST      = 15;
	public static final int SPINGOD      = 16;
	public static final int CURSEGOD      = 17;
	public static final int TIMESTOP      = 18;
	public static final int TIMEMOVE      = 19;
	public static final int SLOWGIRL      = 20;
	public static final int HORRORGIRL      = 21;
	public static final int GAPMASTER      = 22;
	public static final int BORDERMASTER      = 23;
	public static final int PURITYGOD      = 24;
	public static final int PUREGOD      = 25;
	public static final int STARSEEKER      = 26;
	public static final int LUNARSEEKER      = 27;
	public static final int TURNMASTER      = 28;
	public static final int GRAVMASTER      = 29;

	public HeroIcon(HeroSubClass subCls){
		super( Assets.Interfaces.HERO_ICONS );
		if (film == null){
			film = new TextureFilm(texture, SIZE, SIZE);
		}
		frame(film.get(subCls.icon()));
	}
}