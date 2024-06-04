package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.StringUtils.substringsBetween;

public class StringUtilsTest3 {
    //Instancia de la clase StringUtils para realizar las pruebas
    StringUtils stringUtils = new StringUtils();

    //Prueba para verificar si str es nulo o vacio
    @Test void strIsNullOrEmpty() {
        assertThat(substringsBetween(null, "a", "b")).isEqualTo(null);
        assertThat(substringsBetween("", "a", "b")).isEqualTo(new String[]{});
    }

    //Prueba para verificar si open es nulo o vacio
    @Test void openIsNullOrEmpty() {
        assertThat(substringsBetween("abc", null, "b")).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "")).isEqualTo(null);
    }

    //Prueba para verificar si close es nulo o vacio
    @Test void closeIsNullOrEmpty() {
        assertThat(substringsBetween("abc", "a", null)).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "")).isEqualTo(null);
    }

    //Prueba para verificar el comportamiento con cadenas de longitud 1
    @Test void strOfLength1() {
        assertThat(substringsBetween("a", "a", "b")).isEqualTo(null);
        assertThat(substringsBetween("a", "b", "a")).isEqualTo(null);
        assertThat(substringsBetween("a", "b", "b")).isEqualTo(null);
        assertThat(substringsBetween("a", "a", "a")).isEqualTo(null);
    }

    //Prueba para verificar el comportamiento con etiquetas de apertura y cierre de longitud 1
    @Test void openAndCloseOfLength1() {
        assertThat(substringsBetween("abc", "x", "y")).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "y")).isEqualTo(null);
        assertThat(substringsBetween("abc", "x", "c")).isEqualTo(null);
        assertThat(substringsBetween("abc", "a", "c")).isEqualTo(new String[]{"b"});
        assertThat(substringsBetween("abcabyt byrc", "a", "c")).isEqualTo(new String[]{"b", "byt byr"});
    }

    //Prueba para verificar el comportamiento con etiquetas de apertura y cierre de diferentes tamaños
    @Test void openAndCloseTagsOfDifferentSizes() {
        assertThat(substringsBetween("aabcc", "xx", "yy")).isEqualTo(null);
        assertThat(substringsBetween("aabcc", "aa", "yy")).isEqualTo(null);
        assertThat(substringsBetween("aabcc", "xx", "cc")).isEqualTo(null);
        assertThat(substringsBetween("aabbcc", "aa", "cc")).isEqualTo(new String[]{"bb"});
        assertThat(substringsBetween("aabbccaaeecc", "aa", "cc")).isEqualTo(new String[]{"bb", "ee"});
        assertThat(substringsBetween("a abb ddc ca abbcc", "a a", "c c")).isEqualTo(new String[]{"bb dd"});
    }

    //Prueba para verificar el comportamiento cuando no hay subcadena entre las etiquetas de apertura y cierre
    @Test void notSubstringBetweenOpenAndCloseTags() {
        assertThat(substringsBetween("aabb", "aa", "bb")).isEqualTo(new String[]{""});
    }
}

