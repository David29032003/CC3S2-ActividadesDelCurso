package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

class StringUtils2Test {

    //Instancia de la clase StringUtils para realizar las pruebas
    StringUtils2 stringUtils2 = new StringUtils2();

    //Prueba para verificar que el método ignora caracteres especiales al buscar subcadenas
    @Test
    void ignoresSpecialCharacters() {
        //Llamada al método substringsBetween con una cadena que contiene caracteres especiales
        //Se espera que el método ignore los caracteres especiales y devuelva las subcadenas correctas
        assertThat(StringUtils2.substringsBetween("a*b?c!a@d", "a", "d")).isEqualTo(new String[] { "bca" });
    }

    @Test
    void throwsExceptionWhenOpenOrCloseIsEmpty() {
        // Verificamos si el método arroja una excepción cuando open o close están vacíos
        assertThrows(StringUtils2.InvalidDelimiterException.class, () -> {
            stringUtils2.substringsBetween("abc", "", "b");
        });
        assertThrows(StringUtils2.InvalidDelimiterException.class, () -> {
            stringUtils2.substringsBetween("abc", "a", "");
        });
    }

    @Test void regexSimpleCase() {
        assertThat(stringUtils2.regexSubstringsBetween("abcd", "a", "d")).isEqualTo(new String[] { "bc" });
    }

    @Test void regexManyStrings() {
        assertThat(stringUtils2.regexSubstringsBetween("abcdabcdab", "a", "d")).isEqualTo(new String[] { "bc", "bc" });
    }

    @Test void regexOpenAndCloseTagsThatAreLongerThan1Char() {
        assertThat(stringUtils2.regexSubstringsBetween("aabcddaabfddaab", "aa", "dd")).isEqualTo(new String[] { "bc", "bf" });
    }
}


