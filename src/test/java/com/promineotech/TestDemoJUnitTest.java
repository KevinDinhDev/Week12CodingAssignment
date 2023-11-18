package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectedException) {
		if (!expectedException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class)
					.hasMessage(String.valueOf(expected));
		}
	}

	// parameter method source
	static Stream<Arguments> argumentsForAddPositive() {
		// @formatter:off
		return Stream.of(
				arguments(1, 2, 3, false),
//				arguments(1, 0, "Both parameters must be positive.", true),
//				arguments(0, 1, "Both parameters must be positive.", true),
//				arguments(-1, 0, "Both parameters must be positive.", true),
//				arguments(2, -2, "Both parameters must be positive.", true),
//				arguments(-2, -9, "Both parameters must be positive.", true),
				arguments(10, 4, 14, false));
		// @formatter:on

	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(1, 3)).isEqualTo(4);
		assertThat(testDemo.addPositive(21, 24)).isEqualTo(45);
	}

	// I created a test to test my method in TestDemo.java called calculateCubed to
	// determine if the input int number is cubed correctly or not.
	// I added a few assert tests from numbers 1 - 5 to correctly idenfity the
	// correct calculations.
	@Test
	void assertThatCubedNumberIsCorrect() {
		assertThat(testDemo.calculateCubed(1)).isEqualTo(1);
		assertThat(testDemo.calculateCubed(2)).isEqualTo(8);
		assertThat(testDemo.calculateCubed(3)).isEqualTo(27);
		assertThat(testDemo.calculateCubed(4)).isEqualTo(64);
		assertThat(testDemo.calculateCubed(5)).isEqualTo(125);
	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();

		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
}
