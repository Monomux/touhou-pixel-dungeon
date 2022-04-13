package com.touhoupixel.touhoupixeldungeon.items;

import com.touhoupixel.touhoupixeldungeon.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;

import java.util.ArrayList;

public class RenkoMemo extends Item {

	private static final String AC_DRINK	= "DRINK";

	{
		image = ItemSpriteSheet.RENKOMEMO;

		defaultAction = AC_DRINK;

		unique = true;
		bones = false;
	}

	@Override
	public ArrayList<String> actions(Hero hero) {
		ArrayList<String> actions = super.actions(hero);
		actions.remove(AC_DROP);
		actions.remove(AC_THROW);
		actions.remove(AC_DRINK);
		return actions;
	}

	@Override
	public void execute( final Hero hero, String action ) {
		GLog.i(Messages.get(this, "nothing"));
	}

	@Override
	public boolean isUpgradable() {
		return false;
	}

	@Override
	public boolean isIdentified() {
		return true;
	}
}
