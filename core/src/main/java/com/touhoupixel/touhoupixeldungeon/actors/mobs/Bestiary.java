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

import com.touhoupixel.touhoupixeldungeon.Challenges;
import com.touhoupixel.touhoupixeldungeon.Dungeon;
import com.touhoupixel.touhoupixeldungeon.Statistics;
import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.Arrays;

public class Bestiary {

	public static ArrayList<Class<? extends Mob>> getMobRotation(int depth) {
		ArrayList<Class<? extends Mob>> mobs = standardMobRotation(depth);
		Random.shuffle(mobs);
		return mobs;
	}

	//returns a rotation of standard mobs, unshuffled.
	private static ArrayList<Class<? extends Mob>> standardMobRotation(int depth) {
		switch (depth) {
			case 1:
			case 2:
			default:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Wriggle.class, Shinmyomaru.class, Nazrin.class, Mike.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Wriggle.class, Shinmyomaru.class, Nazrin.class, Mike.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Mystia.class, Kisume.class, Albino.class, Aunn.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Mystia.class, Kisume.class, Albino.class, Aunn.class));
				}
			case 3:
			case 4:
			case 5:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Wriggle.class, Shinmyomaru.class, Nazrin.class, Ringo.class, Mike.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Wriggle.class, Shinmyomaru.class, Nazrin.class, Ringo.class, Mike.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Mystia.class, Kisume.class, Albino.class, Saki.class, Aunn.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Mystia.class, Kisume.class, Albino.class, Saki.class, Aunn.class));
				}
			case 6:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Rumia.class, Patchouli.class, Marisa.class, Joon.class, Lily.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Rumia.class, Patchouli.class, Marisa.class, Joon.class, Lily.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Koakuma.class, Kogasa.class, Kosuzu.class, Yachie.class, Nemuno.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Koakuma.class, Kogasa.class, Kosuzu.class, Yachie.class, Nemuno.class));
				}
			case 7:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Rumia.class, Patchouli.class, Marisa.class, Joon.class, Lily.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Rumia.class, Patchouli.class, Marisa.class, Joon.class, Lily.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Koakuma.class, Kogasa.class, Kosuzu.class, Yachie.class, Nemuno.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Koakuma.class, Kogasa.class, Kosuzu.class, Yachie.class, Nemuno.class));
				}
			case 8:
			case 9:
			case 10:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Rumia.class, Patchouli.class, Marisa.class, Cirno.class, Joon.class, Lily.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Rumia.class, Patchouli.class, Marisa.class, Cirno.class, Joon.class, Lily.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Koakuma.class, Kogasa.class, Kosuzu.class, Remilia.class, Yachie.class, Nemuno.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Koakuma.class, Kogasa.class, Kosuzu.class, Remilia.class, Yachie.class, Nemuno.class));
				}
			case 11:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Aya.class, Tsukasa.class, Shion.class, Minoriko.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Aya.class, Tsukasa.class, Shion.class, Minoriko.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hatate.class, Momiji.class, Misumaru.class, Yuugi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hatate.class, Momiji.class, Misumaru.class, Yuugi.class));
				}
			case 12:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Aya.class, Tsukasa.class, Shion.class, Minoriko.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Aya.class, Tsukasa.class, Shion.class, Minoriko.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Hatate.class, Momiji.class, Misumaru.class, Yuugi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hatate.class, Momiji.class, Misumaru.class, Yuugi.class));
				}
			case 13:
			case 14:
			case 15:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Aya.class, Tsukasa.class, Shion.class, Nitori.random(), Minoriko.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Aya.class, Tsukasa.class, Shion.class, Nitori.random(), Minoriko.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Hatate.class, Momiji.class, Misumaru.class, Nitori.random(), Yuugi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hatate.class, Momiji.class, Misumaru.class, Nitori.random(), Yuugi.class));
				}
			case 16:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Youmu.class, Elemental.random(), Kasen.class, Meiling.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Youmu.class, Elemental.random(), Kasen.class, Meiling.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Momoyo.class, Elemental.random(), Kasen.class, Meiling.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Momoyo.class, Elemental.random(), Kasen.class, Meiling.class));
				}
			case 17:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Youmu.class, Elemental.random(), Kasen.class, Meiling.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Youmu.class, Elemental.random(), Kasen.class, Meiling.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Momoyo.class, Elemental.random(), Kasen.class, Meiling.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Momoyo.class, Elemental.random(), Kasen.class, Meiling.class));
				}
			case 18:
			case 19:
			case 20:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Youmu.class, Elemental.random(), Kasen.class, Meiling.class, Elemental.ChaosElemental.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Youmu.class, Elemental.random(), Kasen.class, Meiling.class, Elemental.ChaosElemental.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Momoyo.class, Elemental.random(), Kasen.class, Meiling.class, Eika.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Momoyo.class, Elemental.random(), Kasen.class, Meiling.class, Eika.class));
				}
			case 21:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Keine.class, Kagerou.class, Kaguya.class, Parsee.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Keine.class, Kagerou.class, Kaguya.class, Parsee.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Reisen.class, Alice.class, Takane.class, Mokou.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Reisen.class, Alice.class, Takane.class, Mokou.class));
				}
			case 22:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Keine.class, Kagerou.class, Kaguya.class, Parsee.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Keine.class, Kagerou.class, Kaguya.class, Parsee.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Reisen.class, Alice.class, Takane.class, Mokou.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Reisen.class, Alice.class, Takane.class, Mokou.class));
				}
			case 23:
			case 24:
			case 25:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Keine.class, Kagerou.class, Kaguya.class, Parsee.class, Sunny.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Keine.class, Kagerou.class, Kaguya.class, Parsee.class, Sunny.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Reisen.class, Alice.class, Takane.class, Mokou.class, Sunny.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Reisen.class, Alice.class, Takane.class, Mokou.class, Sunny.class));
				}
			case 26:
			case 27:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Kanako.class, Suwako.class, Hina.class, Benben.class, Miyoi.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Kanako.class, Suwako.class, Hina.class, Benben.class, Miyoi.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Kyouko.class, Shizuha.class, Akyuu.class, Chen.class, Miyoi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Kyouko.class, Shizuha.class, Akyuu.class, Chen.class, Miyoi.class));
				}
			case 28:
			case 29:
			case 30:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Kanako.class, Suwako.class, Hina.class, Benben.class, Luna.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Kanako.class, Suwako.class, Hina.class, Benben.class, Luna.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Kyouko.class, Shizuha.class, Akyuu.class, Chen.class, Luna.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Kyouko.class, Shizuha.class, Akyuu.class, Chen.class, Luna.class));
				}
			case 31:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Miyoi.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Miyoi.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Yamame.class, Ran.class, Tojiko.class, Koishi.class, Miyoi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Yamame.class, Ran.class, Tojiko.class, Koishi.class, Miyoi.class));
				}
			case 32:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Miyoi.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Miyoi.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Yamame.class, Ran.class, Tojiko.class, Koishi.class, Miyoi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Yamame.class, Ran.class, Tojiko.class, Koishi.class, Miyoi.class));
				}
			case 33:
			case 34:
			case 35:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Star.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Star.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Yamame.class, Ran.class, Tojiko.class, Koishi.class, Star.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Yamame.class, Ran.class, Tojiko.class, Koishi.class, Star.class));
				}
			case 36:
			case 37:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sagume.class, Eirin.class, Sannyo.class, Junko.class, Okina.class, Yuuka.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Sagume.class, Eirin.class, Sannyo.class, Junko.class, Okina.class, Yuuka.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Doremy.class, Mai.class, Satono.class, Kokoro.class, Okina.class, Yuuka.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Doremy.class, Mai.class, Satono.class, Kokoro.class, Okina.class, Yuuka.class));
				}
			case 38:
			case 39:
			case 40:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sagume.class, Eirin.class, Sannyo.class, Junko.class, Yorihime.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Sagume.class, Eirin.class, Sannyo.class, Junko.class, Yorihime.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Doremy.class, Mai.class, Satono.class, Kokoro.class, Toyohime.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Doremy.class, Mai.class, Satono.class, Kokoro.class, Toyohime.class));
				}
			case 41:
			case 42:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Keiki.class, Tenkyuu.class, Iku.class, Tenshi.class, Okina.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Keiki.class, Tenkyuu.class, Iku.class, Tenshi.class, Okina.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Megumu.class, Clownpiece.class, Sakuya.class, Hijiri.class, Okina.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Megumu.class, Clownpiece.class, Sakuya.class, Hijiri.class, Okina.class));
				}
			case 43:
			case 44:
			case 45:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Keiki.class, Tenkyuu.class, Iku.class, Tenshi.class, Yorihime.class, Yuuka.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Keiki.class, Tenkyuu.class, Iku.class, Tenshi.class, Yorihime.class, Yuuka.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Megumu.class, Clownpiece.class, Sakuya.class, Hijiri.class, Toyohime.class, Yuuka.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Megumu.class, Clownpiece.class, Sakuya.class, Hijiri.class, Toyohime.class, Yuuka.class));
				}
			case 46:
			case 47:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sumireko.class, Yuuma.class, Komachi.class, Eiki.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sumireko.class, Yuuma.class, Komachi.class, Eiki.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Seija.class, Shou.class, Yatsuhashi.class, Miko.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Seija.class, Shou.class, Yatsuhashi.class, Miko.class));
				}
			case 48:
			case 49:
			case 50:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sumireko.class, Yuuma.class, Komachi.class, Eiki.class, Yorihime.class, Yuuka.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sumireko.class, Yuuma.class, Komachi.class, Eiki.class, Yorihime.class, Yuuka.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Seija.class, Shou.class, Yatsuhashi.class, Miko.class, Toyohime.class, Yuuka.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Seija.class, Shou.class, Yatsuhashi.class, Miko.class, Toyohime.class, Yuuka.class));
				}
			case 51:
			case 52:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Wriggle.class, Shinmyomaru.class, Nazrin.class, Mike.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Wriggle.class, Shinmyomaru.class, Nazrin.class, Mike.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Mystia.class, Kisume.class, Albino.class, Aunn.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Mystia.class, Kisume.class, Albino.class, Aunn.class));
				}
			case 53:
			case 54:
			case 55:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Wriggle.class, Shinmyomaru.class, Nazrin.class, Ringo.class, Mike.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Wriggle.class, Shinmyomaru.class, Nazrin.class, Ringo.class, Mike.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Mystia.class, Kisume.class, Albino.class, Saki.class, Aunn.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Mystia.class, Kisume.class, Albino.class, Saki.class, Aunn.class));
				}
			case 56:
			case 57:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Rumia.class, Patchouli.class, Marisa.class, Joon.class, Lily.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Rumia.class, Patchouli.class, Marisa.class, Joon.class, Lily.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Koakuma.class, Kogasa.class, Kosuzu.class, Yachie.class, Nemuno.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Koakuma.class, Kogasa.class, Kosuzu.class, Yachie.class, Nemuno.class));
				}
			case 58:
			case 59:
			case 60:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Rumia.class, Patchouli.class, Marisa.class, Cirno.class, Joon.class, Lily.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Rumia.class, Patchouli.class, Marisa.class, Cirno.class, Joon.class, Lily.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Koakuma.class, Kogasa.class, Kosuzu.class, Remilia.class, Yachie.class, Nemuno.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Koakuma.class, Kogasa.class, Kosuzu.class, Remilia.class, Yachie.class, Nemuno.class));
				}
			case 61:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Aya.class, Tsukasa.class, Shion.class, Minoriko.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Aya.class, Tsukasa.class, Shion.class, Minoriko.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hatate.class, Momiji.class, Misumaru.class, Yuugi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hatate.class, Momiji.class, Misumaru.class, Yuugi.class));
				}
			case 62:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Aya.class, Tsukasa.class, Shion.class, Minoriko.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Aya.class, Tsukasa.class, Shion.class, Minoriko.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Hatate.class, Momiji.class, Misumaru.class, Yuugi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hatate.class, Momiji.class, Misumaru.class, Yuugi.class));
				}
			case 63:
			case 64:
			case 65:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Aya.class, Tsukasa.class, Shion.class, Nitori.random(), Minoriko.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Aya.class, Tsukasa.class, Shion.class, Nitori.random(), Minoriko.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Hatate.class, Momiji.class, Misumaru.class, Nitori.random(), Yuugi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hatate.class, Momiji.class, Misumaru.class, Nitori.random(), Yuugi.class));
				}
			case 66:
			case 67:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Youmu.class, Elemental.random(), Kasen.class, Meiling.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Youmu.class, Elemental.random(), Kasen.class, Meiling.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Momoyo.class, Elemental.random(), Kasen.class, Meiling.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Momoyo.class, Elemental.random(), Kasen.class, Meiling.class));
				}
			case 68:
			case 69:
			case 70:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Youmu.class, Elemental.random(), Kasen.class, Meiling.class, Elemental.ChaosElemental.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Youmu.class, Elemental.random(), Kasen.class, Meiling.class, Elemental.ChaosElemental.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Momoyo.class, Elemental.random(), Kasen.class, Meiling.class, Eika.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Momoyo.class, Elemental.random(), Kasen.class, Meiling.class, Eika.class));
				}
			case 71:
			case 72:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Keine.class, Kagerou.class, Kaguya.class, Parsee.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Keine.class, Kagerou.class, Kaguya.class, Parsee.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Reisen.class, Alice.class, Takane.class, Mokou.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Reisen.class, Alice.class, Takane.class, Mokou.class));
				}
			case 73:
			case 74:
			case 75:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Keine.class, Kagerou.class, Kaguya.class, Parsee.class, Sunny.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Keine.class, Kagerou.class, Kaguya.class, Parsee.class, Sunny.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Reisen.class, Alice.class, Takane.class, Mokou.class, Sunny.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Reisen.class, Alice.class, Takane.class, Mokou.class, Sunny.class));
				}
			case 76:
			case 77:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Kanako.class, Suwako.class, Hina.class, Benben.class, Miyoi.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Kanako.class, Suwako.class, Hina.class, Benben.class, Miyoi.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Kyouko.class, Shizuha.class, Akyuu.class, Chen.class, Miyoi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Kyouko.class, Shizuha.class, Akyuu.class, Chen.class, Miyoi.class));
				}
			case 78:
			case 79:
			case 80:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Kanako.class, Suwako.class, Hina.class, Benben.class, Luna.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Kanako.class, Suwako.class, Hina.class, Benben.class, Luna.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Kyouko.class, Shizuha.class, Akyuu.class, Chen.class, Luna.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Kyouko.class, Shizuha.class, Akyuu.class, Chen.class, Luna.class));
				}
			case 81:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Miyoi.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Miyoi.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Yamame.class, Ran.class, Tojiko.class, Koishi.class, Miyoi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Yamame.class, Ran.class, Tojiko.class, Koishi.class, Miyoi.class));
				}
			case 82:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Miyoi.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Miyoi.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Yamame.class, Ran.class, Tojiko.class, Koishi.class, Miyoi.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Yamame.class, Ran.class, Tojiko.class, Koishi.class, Miyoi.class));
				}
			case 83:
			case 84:
			case 85:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Star.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Satori.class, Utsuho.class, Flandre.class, Kutaka.class, Star.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Yamame.class, Ran.class, Tojiko.class, Koishi.class, Star.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Yamame.class, Ran.class, Tojiko.class, Koishi.class, Star.class));
				}
			case 86:
			case 87:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sagume.class, Eirin.class, Sannyo.class, Junko.class, Okina.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Sagume.class, Eirin.class, Sannyo.class, Junko.class, Okina.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Doremy.class, Mai.class, Satono.class, Kokoro.class, Okina.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Doremy.class, Mai.class, Satono.class, Kokoro.class, Okina.class));
				}
			case 88:
			case 89:
			case 90:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sagume.class, Eirin.class, Sannyo.class, Junko.class, Yorihime.class, Yuuka.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Sagume.class, Eirin.class, Sannyo.class, Junko.class, Yorihime.class, Yuuka.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Doremy.class, Mai.class, Satono.class, Kokoro.class, Toyohime.class, Yuuka.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Doremy.class, Mai.class, Satono.class, Kokoro.class, Toyohime.class, Yuuka.class));
				}
			case 91:
			case 92:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Keiki.class, Tenkyuu.class, Iku.class, Tenshi.class, Okina.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Keiki.class, Tenkyuu.class, Iku.class, Tenshi.class, Okina.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Megumu.class, Clownpiece.class, Sakuya.class, Hijiri.class, Okina.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Megumu.class, Clownpiece.class, Sakuya.class, Hijiri.class, Okina.class));
				}
			case 93:
			case 94:
			case 95:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Keiki.class, Tenkyuu.class, Iku.class, Tenshi.class, Yorihime.class, Yuuka.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Keiki.class, Tenkyuu.class, Iku.class, Tenshi.class, Yorihime.class, Yuuka.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Megumu.class, Clownpiece.class, Sakuya.class, Hijiri.class, Toyohime.class, Yuuka.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Megumu.class, Clownpiece.class, Sakuya.class, Hijiri.class, Toyohime.class, Yuuka.class));
				}
			case 96:
			case 97:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sumireko.class, Yuuma.class, Komachi.class, Eiki.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sumireko.class, Yuuma.class, Komachi.class, Eiki.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Seija.class, Shou.class, Yatsuhashi.class, Miko.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Seija.class, Shou.class, Yatsuhashi.class, Miko.class));
				}
			case 98:
			case 99:
				if (Statistics.amuletObtained) {
					return new ArrayList<>(Arrays.asList(
							Yukari.class, Yukari.class));
				} else if (!Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sumireko.class, Yuuma.class, Komachi.class, Eiki.class, Yorihime.class, Yuuka.class));
				} else if (!Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Sumireko.class, Yuuma.class, Komachi.class, Eiki.class, Yorihime.class, Yuuka.class));
				} else if (Statistics.altRoute && Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Seija.class, Shou.class, Yatsuhashi.class, Miko.class, Toyohime.class, Yuuka.class));
				} else if (Statistics.altRoute && !Dungeon.isChallenged(Challenges.HECATIA_TIME)) {
					return new ArrayList<>(Arrays.asList(
							Hecatia.class, Seija.class, Shou.class, Yatsuhashi.class, Miko.class, Toyohime.class, Yuuka.class));
				}
			case 100: //dummy
				return new ArrayList<>(Arrays.asList(
						Wriggle.class, Wriggle.class));
		}
	}
}