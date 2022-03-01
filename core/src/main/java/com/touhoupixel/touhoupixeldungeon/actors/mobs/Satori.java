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

package com.touhoupixel.touhoupixeldungeon.actors.mobs;

import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.actors.Char;
import com.touhoupixel.touhoupixeldungeon.items.journal.Guidebook;
import com.touhoupixel.touhoupixeldungeon.items.quest.Half;
import com.touhoupixel.touhoupixeldungeon.journal.Document;
import com.touhoupixel.touhoupixeldungeon.messages.Messages;
import com.touhoupixel.touhoupixeldungeon.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeon.sprites.SatoriSprite;
import com.touhoupixel.touhoupixeldungeon.utils.GLog;
import com.watabou.utils.Random;

public class Satori extends Mob {
	
	{
		spriteClass = SatoriSprite.class;

		if (Dungeon.depth > 50){
			HP = HT = 500;
		} else HP = HT = 80;

		if (Dungeon.depth > 50){
			defenseSkill = 99;
		} else defenseSkill = 50;

		if (Dungeon.depth > 50){
			EXP = 66;
		} else EXP = 16;

		if (Dungeon.depth > 50){
			maxLvl = 85;
		} else maxLvl = 35;

		loot = new Half();
		lootChance = 0.04f;

		properties.add(Property.YOKAI);
		properties.add(Property.HAPPY);
	}

	@Override
	public int damageRoll() {
		if (Dungeon.depth > 50) {
			return Random.NormalIntRange(56, 60);
		} else return Random.NormalIntRange(32, 36);
	}

	@Override
	public int attackSkill(Char target) {
		if (Dungeon.depth > 50) {
			return 95;
		} else return 35;
	}

	private static int dodges = 0;

	@Override
	public String defenseVerb() {
		dodges++;
		if (dodges >= 2 && !Document.ADVENTURERS_GUIDE.isPageRead(Document.GUIDE_SURPRISE_ATKS)){
			GLog.p(Messages.get(Guidebook.class, "hint"));
			GameScene.flashForDocument(Document.GUIDE_SURPRISE_ATKS);
			dodges = 0;
		}
		return super.defenseVerb();
	}
}
