package task3_2;

import java.util.Random;

public class RandomNumber {
	public static int getNumber() {
		Random rnd = new Random(System.currentTimeMillis());
		int number = 100 + rnd.nextInt(999-100);
		return number;
	}
}
