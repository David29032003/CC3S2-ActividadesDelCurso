package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.example.NumberUtils.add;
import static org.junit.jupiter.params.provider.Arguments.of;

class NumberUtilsTest {

    @Test  void t1() {
        assertThat(new NumberUtils().add(numbers(1), numbers(1))) .isEqualTo(numbers(2));
        assertThat(new NumberUtils().add(numbers(1,5), numbers(1,0))) .isEqualTo(numbers(2, 5));
        assertThat(new NumberUtils().add(numbers(1,5), numbers(1,5))) .isEqualTo(numbers(3,0));
        assertThat(new NumberUtils().add(numbers(5,0,0), numbers(2,5,0))) .isEqualTo(numbers(7,5,0));
    }

    private static List<Integer> numbers(int... nums) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums) {
            list.add(n);
        }
        return list;
    }

    @ParameterizedTest
    @CsvSource({
            "'1', '1', '2'",
            "'1,5', '1,0', '2,5'",
            "'1,5', '1,5', '3,0'",
            "'5,0,0', '2,5,0', '7,5,0'",
            "'9', '2', '1,1'",
            "'9,9,8', '1,7,2', '1,1,7,0'",
            "'0,0,1', '0,1,0', '1,1'",
            "'0,9,0', '0,0,1', '9,1'"
    })
    void testAdd(String leftStr, String rightStr, String expectedStr) {
        List<Integer> left = numbers(leftStr);
        List<Integer> right = numbers(rightStr);
        List<Integer> expected = numbers(expectedStr);

        assertThat(new NumberUtils().add(left, right)).isEqualTo(expected);
    }

    private static List<Integer> numbers(String nums) {
        List<Integer> list = new ArrayList<>();
        for (String num : nums.split(",")) {
            list.add(Integer.parseInt(num.trim()));
        }
        return list;
    }

    @ParameterizedTest
    @MethodSource("digitsOutOfRange")
    void shouldThrowExceptionWhenDigitsAreOutOfRange(List<Integer> left, List<Integer> right) {
        // Verificar que se lance una excepción cuando los dígitos están fuera de rango
        assertThatThrownBy(() -> add(left, right)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> digitsOutOfRange() {
        return Stream.of(
                of(numbers(1, -1, 1), numbers(1)),
                of(numbers(1), numbers(1, -1, 1)),
                of(numbers(1, 11, 1), numbers(1)),
                of(numbers(1), numbers(1, 11, 1))
        );
    }
}