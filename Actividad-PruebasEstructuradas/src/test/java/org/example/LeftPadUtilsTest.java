package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

class LeftPadUtilsTest {

    @ParameterizedTest
    @MethodSource("generator")
    void test(String originalStr, int size, String padString, String expectedStr) {  // 1
        assertThat(LeftPadUtils.leftPad(originalStr, size, padString)).isEqualTo(expectedStr);
    }

    @Test
    void sameInstance() {
        String str = "sometext";
        assertThat(LeftPadUtils.leftPad(str, 5, "-")).isSameAs(str);
    }

    static Stream<Arguments> generator() { // 2
        return Stream.of(
                Arguments.of(null, 10, "-", null),// T1
                Arguments.of("", 5, "-", "-----"),// T2
                Arguments.of("abc", -1, "-", "abc"),// T3
                Arguments.of("abc", 5, null, "  abc"),// T4
                Arguments.of("abc", 5, "", "  abc"),// T5
                Arguments.of("abc", 5, "-", "--abc"),// T6
                Arguments.of("abc", 3, "-", "abc"),//T7
                Arguments.of("abc", 0, "-", "abc"),//T8
                Arguments.of("abc", 2, "-", "abc"),//T9
                Arguments.of("abc", 5, "--", "--abc"), // T10
                Arguments.of("abc", 5, "---", "--abc"), // T11
                Arguments.of("abc", 5, "-", "--abc") // T12
        );
    }
}