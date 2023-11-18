package com.promineotech;

import java.util.Random;

public class TestDemo {

	// I created a new method to calculate the cube of a number which will be tested
	// in my JUnitTest
	public int calculateCubed(int number) {
		return number * number * number;
	}

	public int randomNumberSquared() {
		int result = getRandomInt();
		return result * result;
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters bust be positive!");
		}
	}
}
