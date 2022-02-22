package com.touhoupixel.touhoupixeldungeon.actors.buffs;

import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.ui.BuffIndicator;

public class HatResistance extends FlavourBuff {

	{
		type = buffType.POSITIVE;
	}

	public static final float DURATION	= 10f;

	@Override
	public int icon() {
		return BuffIndicator.HATRESIST;
	}

	@Override
	public float iconFadePercent() {
		return Math.max(0, (DURATION - visualcooldown()) / DURATION);
	}

	@Override
	public String toString() {
		return Messages.get(this, "name");
	}

	@Override
	public String desc() {
		return Messages.get(this, "desc", dispTurns());
	}

	{
		immunities.add(AntiHeal.class);
		immunities.add(AntiSneakattack.class);
		immunities.add(Bleeding.class);
		immunities.add(Blindness.class);
		immunities.add(Burning.class);
		immunities.add(Chill.class);
		immunities.add(Corrosion.class);
		immunities.add(Cripple.class);
		immunities.add(Degrade.class);
		immunities.add(Frost.class);
		immunities.add(Hex.class);
		immunities.add(HighStress.class);
		immunities.add(MoveDetect.class);
		immunities.add(OneDamage.class);
		immunities.add(Ooze.class);
		immunities.add(Paralysis.class);
		immunities.add(Poison.class);
		immunities.add(Roots.class);
		immunities.add(Silence.class);
		immunities.add(SuperDegrade.class);
		immunities.add(SuperOoze.class);
		immunities.add(Vertigo.class);
		immunities.add(Vulnerable.class);
		immunities.add(Weakness.class);
	}
}
