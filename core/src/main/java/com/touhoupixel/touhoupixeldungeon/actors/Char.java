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

package com.touhoupixel.touhoupixeldungeon.actors;

import com.touhoupixel.touhoupixeldungeon.Assets;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.Electricity;
import com.touhoupixel.touhoupixeldungeon.actors.blobs.ToxicGas;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Adrenaline;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.AllyBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArcaneArmor;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank1;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank2;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ArisastarRank3;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Barkskin;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Berserk;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bleeding;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Bless;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Burning;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ChampionEnemy;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Charm;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Chill;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Corrosion;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doom;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublerainbow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Dread;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Drowsy;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FireImbue;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Frost;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.FrostImbue;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Fury;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Haste;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Hunger;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.LifeLink;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.LostInventory;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.MagicalSleep;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Momentum;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.OneDamage;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.OneDefDamage;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Ooze;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Paralysis;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Preparation;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.ShieldBuff;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.SnipersMark;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Stamina;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Terror;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Triplespeed;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vertigo;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Vulnerable;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeon.actors.buffs.YuukaRage;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.actors.hero.HeroSubClass;
import com.touhoupixel.touhoupixeldungeon.actors.hero.Talent;
import com.touhoupixel.touhoupixeldungeon.actors.mobs.Elemental;
import com.touhoupixel.touhoupixeldungeon.items.Heap;
import com.touhoupixel.touhoupixeldungeon.items.armor.glyphs.AntiMagic;
import com.touhoupixel.touhoupixeldungeon.items.armor.glyphs.Potential;
import com.touhoupixel.touhoupixeldungeon.items.potions.exotic.PotionOfCleansing;
import com.touhoupixel.touhoupixeldungeon.items.rings.RingOfElements;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfRetribution;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfChallenge;
import com.touhoupixel.touhoupixeldungeon.items.scrolls.exotic.ScrollOfPsionicBlast;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfFireblast;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfFrost;
import com.touhoupixel.touhoupixeldungeon.items.wands.WandOfLightning;
import com.touhoupixel.touhoupixeldungeon.items.weapon.enchantments.Blazing;
import com.touhoupixel.touhoupixeldungeon.items.weapon.enchantments.Blocking;
import com.touhoupixel.touhoupixeldungeon.items.weapon.enchantments.Grim;
import com.touhoupixel.touhoupixeldungeon.items.weapon.enchantments.Shocking;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.BlazingStar;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.DoubleSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FireBrand2;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Flintlock;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.FrostBrand2;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.Grayswandir;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.HellMic;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.MomoyoShovel;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.RandomPhone;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.RunicBlade;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.TurnaboutCloak;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.TurnaboutSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.WatermelonSword;
import com.touhoupixel.touhoupixeldungeon.items.weapon.melee.YukinaMic;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.MissileWeapon;
import com.touhoupixel.touhoupixeldungeon.items.weapon.missiles.darts.ShockingDart;
import com.touhoupixel.touhoupixeldungeon.levels.Terrain;
import com.touhoupixel.touhoupixeldungeon.levels.features.Chasm;
import com.touhoupixel.touhoupixeldungeon.levels.features.Door;
import com.touhoupixel.touhoupixeldungeon.levels.traps.GrimTrap;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.CharSprite;
import com.touhoupixel.touhoupixeldungeon.utils.BArray;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundlable;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.Arrays;
import java.util.HashSet;

public abstract class Char extends Actor {

	public int pos = 0;

	public CharSprite sprite;

	public int HT;
	public int HP;

	protected float baseSpeed	= 1;
	protected PathFinder.Path path;

	public int paralysed	    = 0;
	public boolean rooted		= false;
	public boolean flying		= false;
	public int invisible		= 0;

	//these are relative to the hero
	public enum Alignment{
		ENEMY,
		NEUTRAL,
		ALLY
	}
	public Alignment alignment;

	public int viewDistance	= 8;

	public boolean[] fieldOfView = null;

	private HashSet<Buff> buffs = new HashSet<>();

	@Override
	protected boolean act() {
		if (fieldOfView == null || fieldOfView.length != Dungeon.level.length()){
			fieldOfView = new boolean[Dungeon.level.length()];
		}
		Dungeon.level.updateFieldOfView( this, fieldOfView );

		//throw any items that are on top of an immovable char
		if (properties().contains(Property.IMMOVABLE)){
			throwItems();
		}
		return false;
	}

	protected void throwItems(){
		Heap heap = Dungeon.level.heaps.get( pos );
		if (heap != null && heap.type == Heap.Type.HEAP) {
			int n;
			do {
				n = pos + PathFinder.NEIGHBOURS8[Random.Int( 8 )];
			} while (!Dungeon.level.passable[n] && !Dungeon.level.avoid[n]);
			Dungeon.level.drop( heap.pickUp(), n ).sprite.drop( pos );
		}
	}

	public String name(){
		return Messages.get(this, "name");
	}

	public boolean canInteract(Char c){
		if (Dungeon.level.adjacent( pos, c.pos )){
			return true;
		} else if (c instanceof Hero
				&& alignment == Alignment.ALLY
				&& Dungeon.level.distance(pos, c.pos) <= 2*Dungeon.hero.pointsInTalent(Talent.ALLY_WARP)){
			return true;
		} else {
			return false;
		}
	}

	//swaps places by default
	public boolean interact(Char c){

		//don't allow char to swap onto hazard unless they're flying
		//you can swap onto a hazard though, as you're not the one instigating the swap
		if (!Dungeon.level.passable[pos] && !c.flying){
			return true;
		}

		//can't swap into a space without room
		if (properties().contains(Property.LARGE) && !Dungeon.level.openSpace[c.pos]
				|| c.properties().contains(Property.LARGE) && !Dungeon.level.openSpace[pos]){
			return true;
		}

		int curPos = pos;

		//warp instantly with allies in this case
		if (c == Dungeon.hero && Dungeon.hero.hasTalent(Talent.ALLY_WARP)){
			PathFinder.buildDistanceMap(c.pos, BArray.or(Dungeon.level.passable, Dungeon.level.avoid, null));
			if (PathFinder.distance[pos] == Integer.MAX_VALUE){
				return true;
			}
			ScrollOfTeleportation.appear(this, c.pos);
			ScrollOfTeleportation.appear(c, curPos);
			Dungeon.observe();
			GameScene.updateFog();
			return true;
		}

		//can't swap places if one char has restricted movement
		if (rooted || c.rooted || buff(Vertigo.class) != null || c.buff(Vertigo.class) != null){
			return true;
		}

		moveSprite( pos, c.pos );
		move( c.pos );

		c.sprite.move( c.pos, curPos );
		c.move( curPos );

		c.spend( 1 / c.speed() );

		if (c == Dungeon.hero){
			if (Dungeon.hero.subClass == HeroSubClass.FREERUNNER){
				Buff.affect(Dungeon.hero, Momentum.class).gainStack();
			}

			Dungeon.hero.busy();
		}

		return true;
	}

	protected boolean moveSprite( int from, int to ) {

		if (sprite.isVisible() && (Dungeon.level.heroFOV[from] || Dungeon.level.heroFOV[to])) {
			sprite.move( from, to );
			return true;
		} else {
			sprite.turnTo(from, to);
			sprite.place( to );
			return true;
		}
	}

	public void hitSound( float pitch ){
		Sample.INSTANCE.play(Assets.Sounds.HIT, 1, pitch);
	}

	public boolean blockSound( float pitch ) {
		return false;
	}

	protected static final String POS       = "pos";
	protected static final String TAG_HP    = "HP";
	protected static final String TAG_HT    = "HT";
	protected static final String TAG_SHLD  = "SHLD";
	protected static final String BUFFS	    = "buffs";

	@Override
	public void storeInBundle( Bundle bundle ) {

		super.storeInBundle( bundle );

		bundle.put( POS, pos );
		bundle.put( TAG_HP, HP );
		bundle.put( TAG_HT, HT );
		bundle.put( BUFFS, buffs );
	}

	@Override
	public void restoreFromBundle( Bundle bundle ) {

		super.restoreFromBundle( bundle );

		pos = bundle.getInt( POS );
		HP = bundle.getInt( TAG_HP );
		HT = bundle.getInt( TAG_HT );

		for (Bundlable b : bundle.getCollection( BUFFS )) {
			if (b != null) {
				((Buff)b).attachTo( this );
			}
		}
	}

	final public boolean attack( Char enemy ){
		return attack(enemy, 1f, 0f, 1f);
	}

	public boolean attack( Char enemy, float dmgMulti, float dmgBonus, float accMulti ) {

		if (enemy == null) return false;

		boolean visibleFight = Dungeon.level.heroFOV[pos] || Dungeon.level.heroFOV[enemy.pos];

		if (enemy.isInvulnerable(getClass())) {

			if (visibleFight) {
				enemy.sprite.showStatus( CharSprite.POSITIVE, Messages.get(this, "invulnerable") );

				Sample.INSTANCE.play(Assets.Sounds.HIT_PARRY, 1f, Random.Float(0.96f, 1.05f));
			}

			return false;

		} else if (hit( this, enemy, accMulti )) {

			int dr = enemy.drRoll();

			Barkskin bark = enemy.buff(Barkskin.class);
			if (bark != null)   dr += Random.NormalIntRange( 0 , bark.level() );

			Blocking.BlockBuff block = enemy.buff(Blocking.BlockBuff.class);
			if (block != null)  dr += block.blockingRoll();

			if (this instanceof Hero){
				Hero h = (Hero)this;
				if (h.belongings.weapon() instanceof MissileWeapon
						&& h.subClass == HeroSubClass.SNIPER
						&& !Dungeon.level.adjacent(h.pos, enemy.pos)){
					dr = 0;
				}
			}

			int dmg;
			Preparation prep = buff(Preparation.class);
			if (prep != null){
				dmg = prep.damageRoll(this);
				if (this == Dungeon.hero && Dungeon.hero.hasTalent(Talent.BOUNTY_HUNTER)) {
					Buff.affect(Dungeon.hero, Talent.BountyHunterTracker.class, 0.0f);
				}
			} else {
				dmg = damageRoll();
			}

			dmg = Math.round(dmg*dmgMulti);

			Berserk berserk = buff(Berserk.class);
			if (berserk != null) dmg = berserk.damageFactor(dmg);

			if (buff( Fury.class ) != null) {
				dmg *= 1.5f;
			}

			dmg += dmgBonus;

			if (enemy.buff(ScrollOfChallenge.ChallengeArena.class) != null){
				dmg *= 0.67f;
			}

			int effectiveDamage = enemy.defenseProc( this, dmg );
			effectiveDamage = Math.max( effectiveDamage - dr, 0 );

			if ( enemy.buff( Vulnerable.class ) != null){
				effectiveDamage *= 1.33f;
			}

			effectiveDamage = attackProc( enemy, effectiveDamage );

			if (visibleFight) {
				if (effectiveDamage > 0 || !enemy.blockSound(Random.Float(0.96f, 1.05f))) {
					hitSound(Random.Float(0.87f, 1.15f));
				}
			}

			// If the enemy is already dead, interrupt the attack.
			// This matters as defence procs can sometimes inflict self-damage, such as armor glyphs.
			if (!enemy.isAlive()){
				return true;
			}

			enemy.damage( effectiveDamage, this );

			if (buff(FireImbue.class) != null)  buff(FireImbue.class).proc(enemy);
			if (buff(FrostImbue.class) != null) buff(FrostImbue.class).proc(enemy);

			if (enemy.isAlive() && prep != null && prep.canKO(enemy)){
				enemy.HP = 0;
				if (!enemy.isAlive()) {
					enemy.die(this);
				} else {
					//helps with triggering any on-damage effects that need to activate
					enemy.damage(-1, this);
				}
				enemy.sprite.showStatus(CharSprite.NEGATIVE, Messages.get(Preparation.class, "assassinated"));
			}

			enemy.sprite.bloodBurstA( sprite.center(), effectiveDamage );
			enemy.sprite.flash();

			if (!enemy.isAlive() && visibleFight) {
				if (enemy == Dungeon.hero) {

					if (this == Dungeon.hero) {
						return true;
					}

					Dungeon.fail( getClass() );
					GLog.n( Messages.capitalize(Messages.get(Char.class, "kill", name())) );

				} else if (this == Dungeon.hero) {
					GLog.i( Messages.capitalize(Messages.get(Char.class, "defeat", enemy.name())) );
				}
			}

			return true;

		} else {

			if (visibleFight) {
				String defense = enemy.defenseVerb();
				enemy.sprite.showStatus( CharSprite.NEUTRAL, defense );

				//TODO enemy.defenseSound? currently miss plays for monks/crab even when they parry
				Sample.INSTANCE.play(Assets.Sounds.MISS);
			}

			return false;

		}
	}

	public static int INFINITE_ACCURACY = 1_000_000;
	public static int INFINITE_EVASION = 1_000_000;

	final public static boolean hit( Char attacker, Char defender, boolean magic ) {
		return hit(attacker, defender, magic ? 2f : 1f);
	}

	public static boolean hit( Char attacker, Char defender, float accMulti ) {
		float acuStat = attacker.attackSkill( defender );
		float defStat = defender.defenseSkill( attacker );

		//if accuracy or evasion are large enough, treat them as infinite.
		//note that infinite evasion beats infinite accuracy
		if (defStat >= INFINITE_EVASION){
			return false;
		} else if (acuStat >= INFINITE_ACCURACY){
			return true;
		}

		float acuRoll = Random.Float( acuStat );
		if (attacker.buff(Bless.class) != null) acuRoll *= 1.25f;
		if (attacker.buff(Doublerainbow.class) != null) acuRoll *= 1.75f;
		if (attacker.buff(  Hex.class) != null) acuRoll *= 0.8f;
		for (ChampionEnemy buff : attacker.buffs(ChampionEnemy.class)){
			acuRoll *= buff.evasionAndAccuracyFactor();
		}

		float defRoll = Random.Float( defStat );
		if (defender.buff(Bless.class) != null) defRoll *= 1.25f;
		if (defender.buff(Doublerainbow.class) != null) defRoll *= 1.75f;
		if (defender.buff(  Hex.class) != null) defRoll *= 0.8f;
		for (ChampionEnemy buff : defender.buffs(ChampionEnemy.class)){
			defRoll *= buff.evasionAndAccuracyFactor();
		}

		return (acuRoll * accMulti) >= defRoll;
	}

	public int attackSkill( Char target ) {
		return 0;
	}

	public int defenseSkill( Char enemy ) {
		return 0;
	}

	public String defenseVerb() {
		return Messages.get(this, "def_verb");
	}

	public int drRoll() {
		return 0;
	}

	public int damageRoll() {
		return 1;
	}

	//TODO it would be nice to have a pre-armor and post-armor proc.
	// atm attack is always post-armor and defence is already pre-armor

	public int attackProc( Char enemy, int damage ) {
		if (buff(Weakness.class) != null ) {
			damage *= 0.67f;
		}
		if (buff(OneDamage.class) != null ) {
			damage = 1;
		}
		if (buff(Might.class) != null ){
			damage *= 2f;
		}
		if (buff(Hisou.class) != null && !enemy.flying ){
			damage *= 3f;
		}
		if (buff(YuukaRage.class) != null){
			damage += 100;
		}
		if (Dungeon.hero.belongings.weapon() instanceof MomoyoShovel){
			if (this.HP == 2 || this.HP == 3 || this.HP == 5 || this.HP == 7 || this.HP == 11 || this.HP == 13 || this.HP == 17 || this.HP == 19 || this.HP == 23 || this.HP == 29 || this.HP == 31 || this.HP == 37 || this.HP == 41 || this.HP == 43 || this.HP == 47 || this.HP == 53 || this.HP == 59 || this.HP == 61 || this.HP == 67 || this.HP == 71 || this.HP == 73 || this.HP == 79 || this.HP == 83 || this.HP == 89 || this.HP == 97 || this.HP == 101 || this.HP == 103 || this.HP == 107 || this.HP == 109 || this.HP == 113 || this.HP == 127 || this.HP == 131 || this.HP == 137 || this.HP == 139 || this.HP == 149 || this.HP == 151 || this.HP == 157 || this.HP == 163 || this.HP == 167 || this.HP == 173 || this.HP == 179 || this.HP == 181 || this.HP == 191 || this.HP == 193 || this.HP == 197 || this.HP == 199 || this.HP == 211 || this.HP == 223 || this.HP == 227 || this.HP == 229 || this.HP == 233 || this.HP == 239 || this.HP == 241 || this.HP == 251 || this.HP == 257 || this.HP == 263 || this.HP == 269 || this.HP == 271 || this.HP == 277 || this.HP == 281 || this.HP == 283 || this.HP == 293){
				damage *= 3f;
			}
		}
		if (Dungeon.hero.belongings.weapon() instanceof WatermelonSword){
			if (this.HP == 9 || this.HP == 19 || this.HP == 29 || this.HP == 39 || this.HP == 49 || this.HP == 59 || this.HP == 69 || this.HP == 79 || this.HP == 89 || this.HP == 90 || this.HP == 91 || this.HP == 92 || this.HP == 93 || this.HP == 94 || this.HP == 95 || this.HP == 96 || this.HP == 97 || this.HP == 98 || this.HP == 109 || this.HP == 119 || this.HP == 129 || this.HP == 139 || this.HP == 149 || this.HP == 159 || this.HP == 169 || this.HP == 179 || this.HP == 189 || this.HP == 190 || this.HP == 191 || this.HP == 192 || this.HP == 193 || this.HP == 194 || this.HP == 195 || this.HP == 196 || this.HP == 197 || this.HP == 198 || this.HP == 209 || this.HP == 219 || this.HP == 229 || this.HP == 239 || this.HP == 249 || this.HP == 259 || this.HP == 269 || this.HP == 279 || this.HP == 289 || this.HP == 290 || this.HP == 291 || this.HP == 292 || this.HP == 293 || this.HP == 294 || this.HP == 295 || this.HP == 296 || this.HP == 297 || this.HP == 298){
				damage *= 3f;
			}
		}
		if (Dungeon.hero.belongings.weapon() instanceof WatermelonSword){
			if (this.HP == 99 || this.HP == 199 || this.HP == 299){
				damage *= 9f;
			}
		}
		if (Dungeon.hero.belongings.weapon() instanceof BlazingStar){
			if (this.HP == 1 || this.HP == 2 || this.HP == 3 || this.HP == 5 || this.HP == 8 || this.HP == 13 || this.HP == 16 || this.HP == 21 || this.HP == 34 || this.HP == 55 || this.HP == 81 || this.HP == 89 || this.HP == 144 || this.HP == 233 || this.HP == 256 || this.HP == 377 || this.HP == 610 || this.HP == 625 || this.HP == 987){
				damage *= 4f;
			}
		}
		if (Dungeon.hero.belongings.weapon() instanceof Flintlock){
			if (this.HP == 1 || this.HP == 4 || this.HP == 9 || this.HP == 16 || this.HP == 25 || this.HP == 36 || this.HP == 49 || this.HP == 64 || this.HP == 81 || this.HP == 100 || this.HP == 121 || this.HP == 144 || this.HP == 169 || this.HP == 196 || this.HP == 225 || this.HP == 256 || this.HP == 289 || this.HP == 324 || this.HP == 361 || this.HP == 400 || this.HP == 441 || this.HP == 484 || this.HP == 529 || this.HP == 576 || this.HP == 625 || this.HP == 676 || this.HP == 729 || this.HP == 784 || this.HP == 841 || this.HP == 900 || this.HP == 961 || this.HP == 1024){
				damage *= 5f;
			}
		}
		if (Dungeon.hero.belongings.weapon() instanceof FireBrand2 && enemy.properties().contains(Char.Property.ANIMAL)){
			damage *= 2f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof FrostBrand2 && enemy.properties().contains(Char.Property.YOKAI)){
			damage *= 2f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof FireBrand2 && enemy.buff(Burning.class) != null){
			damage *= 10f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof FrostBrand2 && enemy.buff(Chill.class) != null){
			damage *= 10f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof TurnaboutSword && (Random.Int(3) == 0) && !enemy.properties().contains(Char.Property.BOSS)){
			damage = enemy.HP-1;
		}
		if (Dungeon.hero.belongings.weapon() instanceof Grayswandir){
			if (Dungeon.depth == 46 || Dungeon.depth == 47 || Dungeon.depth == 48 || Dungeon.depth == 49 || Dungeon.depth == 50 || Dungeon.depth == 96 || Dungeon.depth == 97 || Dungeon.depth == 98 || Dungeon.depth == 99 || Dungeon.depth == 100){
				damage *= 2.5f;
			}
		}
		if (Dungeon.hero.belongings.weapon() instanceof RandomPhone && Dungeon.gold > 9999){
			damage *= 1.2f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof YukinaMic && enemy.properties().contains(Char.Property.ANIMAL)) {
			damage *= 0.05f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof YukinaMic && !enemy.properties().contains(Char.Property.ANIMAL)) {
			damage *= 2f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof HellMic && !enemy.properties().contains(Char.Property.ANIMAL)) {
			damage *= 2.5f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof WatermelonSword && enemy.properties().contains(Char.Property.BOSS)){
			damage *= 0.5f;
		}
		if (Dungeon.hero.belongings.weapon() instanceof RunicBlade && Statistics.amuletObtained){
			damage *= 2f;
		}
		if (Dungeon.hero.HP < enemy.HP && Dungeon.hero.belongings.weapon() instanceof TurnaboutCloak){
			damage *= 2f;
		}
		if (Dungeon.hero.HP < Dungeon.depth && Dungeon.hero.belongings.weapon() instanceof DoubleSword){
			damage *= 3f;
		}
		if (buff(ArisastarRank1.class) != null){
			damage *= 1.5f;
		}
		if (buff(ArisastarRank2.class) != null){
			damage *= 2f;
		}
		if (buff(ArisastarRank3.class) != null){
			damage *= 3f;
		}

		for (ChampionEnemy buff : buffs(ChampionEnemy.class)){
			damage *= buff.meleeDamageFactor();
			buff.onAttackProc( enemy );
		}
		return damage;
	}

	public int defenseProc( Char enemy, int damage ) {
		return damage;
	}

	public float speed() {
		float speed = baseSpeed;
		if ( buff( Cripple.class ) != null ) speed /= 2f;
		if ( buff( Stamina.class ) != null) speed *= 1.5f;
		if ( buff( Adrenaline.class ) != null) speed *= 2f;
		if ( buff( Haste.class ) != null) speed *= 3f;
		if ( buff( Dread.class ) != null) speed *= 2f;
		return speed;
	}

	//used so that buffs(Shieldbuff.class) isn't called every time unnecessarily
	private int cachedShield = 0;
	public boolean needsShieldUpdate = true;

	public int shielding(){
		if (!needsShieldUpdate){
			return cachedShield;
		}

		cachedShield = 0;
		for (ShieldBuff s : buffs(ShieldBuff.class)){
			cachedShield += s.shielding();
		}
		needsShieldUpdate = false;
		return cachedShield;
	}

	public void damage( int dmg, Object src ) {

		if (!isAlive() || dmg < 0) {
			return;
		}

		if(isInvulnerable(src.getClass())){
			sprite.showStatus(CharSprite.POSITIVE, Messages.get(this, "invulnerable"));
			return;
		}

		for (ChampionEnemy buff : buffs(ChampionEnemy.class)){
			dmg = (int) Math.ceil(dmg * buff.damageTakenFactor());
		}

		if (buff(OneDefDamage.class) != null ) {
			dmg = 1;
		}

		if (!(src instanceof LifeLink) && buff(LifeLink.class) != null){
			HashSet<LifeLink> links = buffs(LifeLink.class);
			for (LifeLink link : links.toArray(new LifeLink[0])){
				if (Actor.findById(link.object) == null){
					links.remove(link);
					link.detach();
				}
			}
			dmg = (int)Math.ceil(dmg / (float)(links.size()+1));
			for (LifeLink link : links){
				Char ch = (Char)Actor.findById(link.object);
				ch.damage(dmg, link);
				if (!ch.isAlive()){
					link.detach();
				}
			}
		}

		Terror t = buff(Terror.class);
		if (t != null){
			t.recover();
		}
		Dread d = buff(Dread.class);
		if (d != null){
			d.recover();
		}
		Charm c = buff(Charm.class);
		if (c != null){
			c.recover(src);
		}
		if (this.buff(Frost.class) != null){
			Buff.detach( this, Frost.class );
		}
		if (this.buff(MagicalSleep.class) != null){
			Buff.detach(this, MagicalSleep.class);
		}
		if (this.buff(Doom.class) != null && !isImmune(Doom.class)){
			dmg *= 2;
		}

		Class<?> srcClass = src.getClass();
		if (isImmune( srcClass )) {
			dmg = 0;
		} else {
			dmg = Math.round( dmg * resist( srcClass ));
		}

		//TODO improve this when I have proper damage source logic
		if (AntiMagic.RESISTS.contains(src.getClass()) && buff(ArcaneArmor.class) != null){
			dmg -= Random.NormalIntRange(0, buff(ArcaneArmor.class).level());
			if (dmg < 0) dmg = 0;
		}

		if (buff( Paralysis.class ) != null) {
			buff( Paralysis.class ).processDamage(dmg);
		}

		int shielded = dmg;
		//FIXME: when I add proper damage properties, should add an IGNORES_SHIELDS property to use here.
		if (!(src instanceof Hunger)){
			for (ShieldBuff s : buffs(ShieldBuff.class)){
				dmg = s.absorbDamage(dmg);
				if (dmg == 0) break;
			}
		}
		shielded -= dmg;
		HP -= dmg;

		if (sprite != null) {
			sprite.showStatus(HP > HT / 2 ?
							CharSprite.WARNING :
							CharSprite.NEGATIVE,
					Integer.toString(dmg + shielded));
		}

		if (HP < 0) HP = 0;

		if (!isAlive()) {
			die(src);
		}
	}

	public void destroy() {
		HP = 0;
		Actor.remove( this );

		for (Char ch : Actor.chars().toArray(new Char[0])){
			if (ch.buff(Charm.class) != null && ch.buff(Charm.class).object == id()){
				ch.buff(Charm.class).detach();
			}
			if (ch.buff(Dread.class) != null && ch.buff(Dread.class).object == id()){
				ch.buff(Dread.class).detach();
			}
			if (ch.buff(Terror.class) != null && ch.buff(Terror.class).object == id()){
				ch.buff(Terror.class).detach();
			}
			if (ch.buff(SnipersMark.class) != null && ch.buff(SnipersMark.class).object == id()){
				ch.buff(SnipersMark.class).detach();
			}
		}
	}

	public void die( Object src ) {
		destroy();
		if (src != Chasm.class) sprite.die();
	}

	//we cache this info to prevent having to call buff(...) in isAlive.
	//This is relevant because we call isAlive during drawing, which has both performance
	//and thread coordination implications
	public boolean deathMarked = false;

	public boolean isAlive() {
		return HP > 0 || deathMarked;
	}

	@Override
	protected void spend( float time ) {

		float timeScale = 1f;
		if (buff( Slow.class ) != null) {
			timeScale *= 0.5f;
			//slowed and chilled do not stack
		} else if (buff( Chill.class ) != null) {
			timeScale *= buff( Chill.class ).speedFactor();
		}
		if (buff( Doublespeed.class ) != null) {
			timeScale *= 2.0f;
		}
		if (buff( Triplespeed.class ) != null) {
			timeScale *= 3.0f;
		}

		super.spend( time / timeScale );
	}

	public synchronized HashSet<Buff> buffs() {
		return new HashSet<>(buffs);
	}

	@SuppressWarnings("unchecked")
	//returns all buffs assignable from the given buff class
	public synchronized <T extends Buff> HashSet<T> buffs( Class<T> c ) {
		HashSet<T> filtered = new HashSet<>();
		for (Buff b : buffs) {
			if (c.isInstance( b )) {
				filtered.add( (T)b );
			}
		}
		return filtered;
	}

	@SuppressWarnings("unchecked")
	//returns an instance of the specific buff class, if it exists. Not just assignable
	public synchronized  <T extends Buff> T buff( Class<T> c ) {
		for (Buff b : buffs) {
			if (b.getClass() == c) {
				return (T)b;
			}
		}
		return null;
	}

	public synchronized boolean isCharmedBy( Char ch ) {
		int chID = ch.id();
		for (Buff b : buffs) {
			if (b instanceof Charm && ((Charm)b).object == chID) {
				return true;
			}
		}
		return false;
	}

	public synchronized void add( Buff buff ) {

		if (buff(PotionOfCleansing.Cleanse.class) != null) { //cleansing buff
			if (buff.type == Buff.buffType.NEGATIVE
					&& !(buff instanceof AllyBuff)
					&& !(buff instanceof LostInventory)){
				return;
			}
		}

		buffs.add( buff );
		if (Actor.chars().contains(this)) Actor.add( buff );

		if (sprite != null && buff.announced)
			switch(buff.type){
				case POSITIVE:
					sprite.showStatus(CharSprite.POSITIVE, buff.toString());
					break;
				case NEGATIVE:
					sprite.showStatus(CharSprite.NEGATIVE, buff.toString());
					break;
				case NEUTRAL: default:
					sprite.showStatus(CharSprite.NEUTRAL, buff.toString());
					break;
			}

	}

	public synchronized void remove( Buff buff ) {

		buffs.remove( buff );
		Actor.remove( buff );

	}

	public synchronized void remove( Class<? extends Buff> buffClass ) {
		for (Buff buff : buffs( buffClass )) {
			remove( buff );
		}
	}

	@Override
	protected synchronized void onRemove() {
		for (Buff buff : buffs.toArray(new Buff[buffs.size()])) {
			buff.detach();
		}
	}

	public synchronized void updateSpriteState() {
		for (Buff buff:buffs) {
			buff.fx( true );
		}
	}

	public float stealth() {
		return 0;
	}

	public final void move( int step ) {
		move( step, true );
	}

	//travelling may be false when a character is moving instantaneously, such as via teleportation
	public void move( int step, boolean travelling ) {

		if (travelling && Dungeon.level.adjacent( step, pos ) && buff( Vertigo.class ) != null) {
			sprite.interruptMotion();
			int newPos = pos + PathFinder.NEIGHBOURS8[Random.Int( 8 )];
			if (!(Dungeon.level.passable[newPos] || Dungeon.level.avoid[newPos])
					|| (properties().contains(Property.LARGE) && !Dungeon.level.openSpace[newPos])
					|| Actor.findChar( newPos ) != null)
				return;
			else {
				sprite.move(pos, newPos);
				step = newPos;
			}
		}

		if (Dungeon.level.map[pos] == Terrain.OPEN_DOOR) {
			Door.leave( pos );
		}

		pos = step;

		if (this != Dungeon.hero) {
			sprite.visible = Dungeon.level.heroFOV[pos];
		}

		Dungeon.level.occupyCell(this );
	}

	public int distance( Char other ) {
		return Dungeon.level.distance( pos, other.pos );
	}

	public void onMotionComplete() {
		//Does nothing by default
		//The main actor thread already accounts for motion,
		// so calling next() here isn't necessary (see Actor.process)
	}

	public void onAttackComplete() {
		next();
	}

	public void onOperateComplete() {
		next();
	}

	protected final HashSet<Class> resistances = new HashSet<>();

	//returns percent effectiveness after resistances
	//TODO currently resistances reduce effectiveness by a static 50%, and do not stack.
	public float resist( Class effect ){
		HashSet<Class> resists = new HashSet<>(resistances);
		for (Property p : properties()){
			resists.addAll(p.resistances());
		}
		for (Buff b : buffs()){
			resists.addAll(b.resistances());
		}

		float result = 1f;
		for (Class c : resists){
			if (c.isAssignableFrom(effect)){
				result *= 0.5f;
			}
		}
		return result * RingOfElements.resist(this, effect);
	}

	protected final HashSet<Class> immunities = new HashSet<>();

	public boolean isImmune(Class effect ){
		HashSet<Class> immunes = new HashSet<>(immunities);
		for (Property p : properties()){
			immunes.addAll(p.immunities());
		}
		for (Buff b : buffs()){
			immunes.addAll(b.immunities());
		}

		for (Class c : immunes){
			if (c.isAssignableFrom(effect)){
				return true;
			}
		}
		return false;
	}

	//similar to isImmune, but only factors in damage.
	//Is used in AI decision-making
	public boolean isInvulnerable( Class effect ){
		return false;
	}

	protected HashSet<Property> properties = new HashSet<>();

	public HashSet<Property> properties() {
		HashSet<Property> props = new HashSet<>(properties);
		//TODO any more of these and we should make it a property of the buff, like with resistances/immunities
		if (buff(ChampionEnemy.Giant.class) != null) {
			props.add(Property.LARGE);
		}
		return props;
	}

	public enum Property{
		BOSS ( new HashSet<Class>( Arrays.asList(Drowsy.class, Grim.class, GrimTrap.class, ScrollOfRetribution.class, ScrollOfPsionicBlast.class)),
				new HashSet<Class>( Arrays.asList(AllyBuff.class, Dread.class) )),
		MINIBOSS ( new HashSet<Class>(),
				new HashSet<Class>( Arrays.asList(AllyBuff.class, Dread.class) )),
		UNDEAD,
		DEMONIC,
		INORGANIC ( new HashSet<Class>(),
				new HashSet<Class>( Arrays.asList(Bleeding.class, ToxicGas.class, Poison.class) )),
		FIERY ( new HashSet<Class>( Arrays.asList(WandOfFireblast.class, Elemental.FireElemental.class)),
				new HashSet<Class>( Arrays.asList(Burning.class, Blazing.class))),
		ICY ( new HashSet<Class>( Arrays.asList(WandOfFrost.class, Elemental.FrostElemental.class)),
				new HashSet<Class>( Arrays.asList(Frost.class, Chill.class))),
		ACIDIC ( new HashSet<Class>( Arrays.asList(Corrosion.class)),
				new HashSet<Class>( Arrays.asList(Ooze.class))),
		ELECTRIC ( new HashSet<Class>( Arrays.asList(WandOfLightning.class, Shocking.class, Potential.class, Electricity.class, ShockingDart.class, Elemental.ShockElemental.class )),
				new HashSet<Class>()),
		LARGE,
		YOKAI,
		FLOAT,
		ANIMAL,
		GOD,
		ELIXIR,
		FIRE,
		COLD,
		WARP,
		POWERFUL,
		COOL,
		PURE,
		HAPPY,
		IMMOVABLE;

		private HashSet<Class> resistances;
		private HashSet<Class> immunities;

		Property(){
			this(new HashSet<Class>(), new HashSet<Class>());
		}

		Property( HashSet<Class> resistances, HashSet<Class> immunities){
			this.resistances = resistances;
			this.immunities = immunities;
		}

		public HashSet<Class> resistances(){
			return new HashSet<>(resistances);
		}

		public HashSet<Class> immunities(){
			return new HashSet<>(immunities);
		}

	}

	public static boolean hasProp( Char ch, Property p){
		return (ch != null && ch.properties().contains(p));
	}
}