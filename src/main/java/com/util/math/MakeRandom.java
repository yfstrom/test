package com.util.math;

import java.util.Random;

public class MakeRandom {

	/**
	 * 随机数生成[min,max)
	 * @param min 
	 * @param max
	 * @return
	 */
	public static int makeRandomNum(int min, int max) {

		
		return new Random().nextInt(max - min) + min;

	}

}
