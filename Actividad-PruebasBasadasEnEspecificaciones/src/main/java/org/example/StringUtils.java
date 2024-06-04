package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    //Metodo para verificar si una cadena está vacia o es nula
    private static boolean isEmpty(final String str) {
        return str == null || str.isEmpty();
    }

    //Metodo para obtener substrings entre dos delimitadores dados
    public static String[] substringsBetween(final String str, final String open, final String close) {
        //Verifica si la cadena o los delimitadores son nulos o vacíos
        if (str == null || isEmpty(open) || isEmpty(close)) {
            return null;
        }

        final int strLen = str.length();
        //Si la cadena esta vacia, retorna un arreglo vacío
        if (strLen == 0) {
            return new String[0]; //Inicializacion correcta del arreglo vacio
        }

        final int closeLen = close.length();
        final int openLen = open.length();
        final List<String> list = new ArrayList<>();
        int pos = 0;

        //Bucle para encontrar substrings entre los delimitadores
        while (pos < strLen - closeLen) {
            int start = str.indexOf(open, pos);
            if (start < 0) {
                break; //Salir si no se encuentra el delimitador de apertura
            }
            start += openLen;
            final int end = str.indexOf(close, start);
            if (end < 0) {
                break; //Salir si no se encuentra el delimitador de cierre
            }
            //Añadir substring a la lista
            list.add(str.substring(start, end));
            //Actualizar posicion
            pos = end + closeLen;
        }

        //Si la lista esta vacia, retornar null
        if (list.isEmpty()) {
            return null;
        }

        //Convertir la lista a un arreglo y retornarlo
        return list.toArray(new String[0]); //Inicializacion correcta del arreglo vacio
    }
}


