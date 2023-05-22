package com.bkw.rulesengine.misc;
import java.util.Random;

public class RandTest {
	protected static final int ITERATIONS = 10000;
	protected static final int RAND_ITERATIONS = 20;

	public static void main(String[] args) {
		Random rand = new Random();
		int[] distribution = new int[RAND_ITERATIONS];
		for (int i = 1; i < RAND_ITERATIONS; ++i) {
			for (int j = 0; j < RAND_ITERATIONS; ++j) {
				distribution[j] = 0;
			}
			double sumsqr = 0;
			double sumval = 0;
			for (int j = 0; j < ITERATIONS; ++j) {
				double sum = 0;
				for (int k = 0; k < i; ++k) {
					sum += rand.nextDouble();
					;
				}
				double value = sum / i;
				sumsqr += value * value;
				sumval += value;
				int index = (int) (value * 10);
				// System.out.println("value:"+value+" sum:"+sum+" i:"+i+"
				// "+(int)(value*10));
				++distribution[index];
			}
			double aveval = sumval / ITERATIONS;
			for (int j = 0; j < 10; ++j) {
				System.out.println(distribution[j]);
			}
			
			System.out.println(100 * java.lang.Math.sqrt(sumsqr / ITERATIONS - aveval
					* aveval));
		}
	}
}
