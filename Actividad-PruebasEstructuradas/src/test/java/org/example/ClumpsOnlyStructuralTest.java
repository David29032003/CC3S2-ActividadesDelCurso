package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClumpsOnlyStructuralTest {
    @ParameterizedTest
    @MethodSource("generator")
    void testClumps(int[] nums, int expectedNoOfClumps) {
        // Verifica que el resultado de countClumps(nums) sea igual al número esperado de clumps.
        assertThat(Clumps.countClumps(nums)).isEqualTo(expectedNoOfClumps);
    }

    //Generador de argumentos para las pruebas parametrizadas.
    static Stream<Arguments> generator() {
        return Stream.of(
                // Prueba con un array vacío, debería retornar 0 clumps.
                Arguments.of(new int[]{}, 0), // vacío

                // Prueba con un array nulo, debería retornar 0 clumps.
                Arguments.of(null, 0), // null

                // Prueba con un array que contiene [1, 2, 2, 2, 1], debería retornar 1 clump.
                Arguments.of(new int[]{1, 2, 2, 2, 1}, 1), // 1 grupo

                // Prueba con un array que contiene un solo elemento [1], debería retornar 0 clumps.
                Arguments.of(new int[]{1}, 0), // 1 elemento

                // Prueba con un array que contiene [2, 2], debería retornar 1 clump.
                Arguments.of(new int[]{2, 2}, 1), // 1 grupo

                // Prueba con un array que contiene [1, 1, 2, 2, 3, 3], debería retornar 3 clumps.
                Arguments.of(new int[]{1, 1, 2, 2, 3, 3}, 3), // T10: 3 grupos

                // Prueba con un array que contiene [1, 1, 1, 2, 2, 2, 3, 3, 3], debería retornar 3 clumps grandes.
                Arguments.of(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}, 3), // T11: 3 grupos grandes

                // Prueba con un array que contiene [1, 2, 2, 2, 3, 3, 4, 4, 4], debería retornar 3 clumps separados.
                Arguments.of(new int[]{1, 2, 2, 2, 3, 3, 4, 4, 4}, 3) // T12: 3 grupos separados
        );
    }

    @Test
    void sameInstance() {
        int[] nums = {1, 2, 3};
        // El método countClumps no debe modificar el array de entrada.
        Clumps.countClumps(nums);
        assertThat(nums).isEqualTo(new int[]{1, 2, 3});
    }
}
