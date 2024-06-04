package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilsTest2 {

    //Instancia de la clase StringUtils para realizar las pruebas
    StringUtils stringUtils = new StringUtils();

    //Test para verificar cuando todos los parametros son nulos
    @Test
    void TodosLosParametrosSonNulos() {
        //Verifica que el resultado de substringsBetween con todos los parametros nulos sea null
        assertThat(stringUtils.substringsBetween(null, null, null)).isNull();
    }

    //Test para verificar cuando la cadena de entrada es nula
    @Test
    void CadenaDeEntradaEsNula() {
        //Verifica que el resultado de substringsBetween con la cadena de entrada nula sea null
        assertThat(stringUtils.substringsBetween(null, "a", "c")).isNull();
    }

    //Test para verificar cuando el delimitador de apertura es nulo
    @Test
    void DelimitadorDeAperturaEsNulo() {
        //Verifica que el resultado de substringsBetween con el delimitador de apertura nulo sea null
        assertThat(stringUtils.substringsBetween("axcaycazc", null, "c")).isNull();
    }

    //Test para verificar cuando el delimitador de cierre es nulo
    @Test
    void DelimitadorDeCierreEsNulo() {
        //Verifica que el resultado de substringsBetween con el delimitador de cierre nulo sea null
        assertThat(stringUtils.substringsBetween("axcaycazc", "a", null)).isNull();
    }

    //Test para verificar cuando la cadena de entrada es vacia
    @Test
    void CadenaDeEntradaEsVacia() {
        //Verifica que el resultado de substringsBetween con la cadena de entrada vacia sea una matriz vacia
        assertThat(stringUtils.substringsBetween("", "a", "c")).isEqualTo(new String[0]);
    }
}
