package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//Clase de pruebas para StringUtils
class StringUtilsTest {

    //Instancia de StringUtils para realizar las pruebas
    StringUtils stringUtils = new StringUtils();

    //Test para un caso simple
    @Test
    void simpleCase() {
        //Verifica que el metodo substringsBetween funcione correctamente con una cadena simple
        assertThat(stringUtils.substringsBetween("abcd", "a", "d")).isEqualTo(new String[] { "bc" });
    }

    //Test para varias ocurrencias de delimitadores en la cadena de entrada
    @Test
    void manyStrings() {
        //Verifica que el metodo substringsBetween funcione correctamente con múltiples ocurrencias de delimitadores
        assertThat(stringUtils.substringsBetween("abcdabcdab", "a", "d")).isEqualTo(new String[] { "bc", "bc" });
    }

    //Test para delimitadores que son mas largos que un caracter
    @Test
    void openAndCloseTagsThatAreLongerThan1Char() {
        //Verifica que el metodo substringsBetween funcione correctamente con delimitadores mas largos
        assertThat(stringUtils.substringsBetween("aabcddaabfddaab", "aa", "dd")).isEqualTo(new String[] { "bc", "bf" });
    }
}
