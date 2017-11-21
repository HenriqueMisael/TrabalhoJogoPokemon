package util;

import java.util.Random;

public class Probabilidade {

	public static boolean calcula(double ratio) {
		return ratio >= getRandom(1,100);
	}
	
	public static double getRandom(double min, double max) {
		Random r = new Random();
		return min+(max-min)*r.nextDouble();
	}
}
