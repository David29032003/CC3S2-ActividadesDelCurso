package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils2 {

    // Excepción personalizada para indicar un delimitador inválido
    public static class InvalidDelimiterException extends RuntimeException {
        // Constructor de la excepción
        public InvalidDelimiterException(String message) {
            super(message);
        }
    }

    public static String[] substringsBetween(final String str, final String open, final String close) {
        // Verifica si la cadena o los delimitadores son nulos
        if (str == null) {
            return null;
        }
        // Lanza una excepción si los delimitadores están vacíos
        if (isEmpty(open) || isEmpty(close)) {
            throw new InvalidDelimiterException("Open or close delimiter cannot be empty");
        }

        final int strLen = str.length();
        // Si la longitud de la cadena es 0, retorna un arreglo vacío
        if (strLen == 0) {
            return EMPTY_STRING_ARRAY;
        }

        final int closeLen = close.length();
        final int openLen = open.length();
        final List<String> list = new ArrayList<>();
        int pos = 0;

        // Itera sobre la cadena buscando las subcadenas entre los delimitadores
        while (pos < strLen - closeLen) {
            int start = str.indexOf(open, pos);
            // Si no se encuentra el delimitador de apertura, se detiene la búsqueda
            if (start < 0) {
                break;
            }
            start += openLen;
            final int end = str.indexOf(close, start);
            // Si no se encuentra el delimitador de cierre, se detiene la búsqueda
            if (end < 0) {
                break;
            }
            // Filtra caracteres especiales de la subcadena encontrada
            String substring = str.substring(start, end).replaceAll("[^a-zA-Z0-9]", "");
            list.add(substring);
            pos = end + closeLen;
        }

        // Si la lista está vacía, retorna null
        if (list.isEmpty()) {
            return null;
        }

        // Retorna las subcadenas encontradas como un arreglo
        return list.toArray(new String[list.size()]);
    }

    // Encuentra todas las subcadenas que coinciden con un patrón entre los delimitadores especificados en una cadena dada
    public static String[] regexSubstringsBetween(final String str, final String open, final String close) {
        // Verifica si la cadena es nula o si los delimitadores son nulos o vacíos
        if (str == null || isEmpty(open) || isEmpty(close)) {
            return null;
        }
        // Crea una expresión regular para encontrar las subcadenas entre los delimitadores
        final String regex = Pattern.quote(open) + "(.*?)" + Pattern.quote(close);
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(str);
        // Lista para almacenar las subcadenas encontradas
        final List<String> list = new ArrayList<>();
        // Itera sobre las coincidencias encontradas por el Matcher
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        // Si no se encontraron coincidencias, devuelve null
        if (list.isEmpty()) {
            return null;
        }
        // Convierte la lista de subcadenas a un array y lo devuelve
        return list.toArray(new String[0]);
    }

    // Verifica si una cadena es nula o vacía
    private static boolean isEmpty(final String str) {
        return str == null || str.isEmpty();
    }

    // Array vacío
    private static final String[] EMPTY_STRING_ARRAY = {};
}






