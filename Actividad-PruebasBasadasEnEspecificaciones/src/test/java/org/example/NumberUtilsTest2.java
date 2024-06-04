package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class NumberUtilsTest2 {
    @Test void testBasicAddition() {
        assertThat(NumberUtils.add(numbers(1), numbers(1))).isEqualTo(numbers(2));
        assertThat(NumberUtils.add(numbers(1, 5), numbers(1, 0))).isEqualTo(numbers(2, 5));
        assertThat(NumberUtils.add(numbers(1, 5), numbers(1, 5))).isEqualTo(numbers(3, 0));
        assertThat(NumberUtils.add(numbers(5, 0, 0), numbers(2, 5, 0))).isEqualTo(numbers(7, 5, 0));
    }

    @Test void testNullAndEmptyLists() {
        assertThat(NumberUtils.add(null, numbers(1))).isNull();
        assertThat(NumberUtils.add(numbers(1), null)).isNull();
        assertThat(NumberUtils.add(numbers(), numbers(1))).isEqualTo(numbers(1));
        assertThat(NumberUtils.add(numbers(1), numbers())).isEqualTo(numbers(1));
    }

    @Test void testLeadingZeros() {
        assertThat(NumberUtils.add(numbers(0, 0, 1), numbers(0, 0, 9))).isEqualTo(numbers(1, 0));
        assertThat(NumberUtils.add(numbers(0, 0, 9), numbers(0, 0, 1))).isEqualTo(numbers(1, 0));
    }

    @Test void testCarryOperations() {
        assertThat(NumberUtils.add(numbers(9), numbers(2))).isEqualTo(numbers(1, 1));
        assertThat(NumberUtils.add(numbers(9, 9, 8), numbers(1, 7, 2))).isEqualTo(numbers(1, 1, 7, 0));
    }

    @Test void testInvalidDigits() {
        assertThatThrownBy(() -> NumberUtils.add(numbers(1, -1, 1), numbers(1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> NumberUtils.add(numbers(1), numbers(1, -1, 1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> NumberUtils.add(numbers(1, 11, 1), numbers(1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> NumberUtils.add(numbers(1), numbers(1, 11, 1))).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("digitsOutOfRange")
    void shouldThrowExceptionWhenDigitsAreOutOfRange(List<Integer> left, List<Integer> right) {
        assertThatThrownBy(() -> NumberUtils.add(left, right)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> digitsOutOfRange() {
        return Stream.of(
                Arguments.of(numbers(1, -1, 1), numbers(1)),
                Arguments.of(numbers(1), numbers(1, -1, 1)),
                Arguments.of(numbers(1, 11, 1), numbers(1)),
                Arguments.of(numbers(1), numbers(1, 11, 1))
        );
    }

    private static List<Integer> numbers(int... nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        return list;
    }
}