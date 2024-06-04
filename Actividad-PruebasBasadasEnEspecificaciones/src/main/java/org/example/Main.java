package org.example;

public class Main {
    public static void main(String[] args) {
        //Llamada al metodo substringsBetween de la clase StringUtils
        //Este metodo busca substrings entre los delimitadores "a" y "c"
        //en la cadena "axcaycazc"
        String[] result = StringUtils.substringsBetween("axcaycazc", "a", "c");

        //Concatenar los resultados y mostrarlos
        if (result != null) {
            //Si se encuentran substrings, se concatenan en un StringBuilder
            StringBuilder concatenatedResult = new StringBuilder();
            for (String s : result) {
                concatenatedResult.append(s);
            }
            //Imprimir el resultado concatenado
            System.out.println(concatenatedResult.toString());
        } else {
            //Si no se encuentran substrings, se imprime un mensaje indicando esto
            System.out.println("No substrings found");
        }
    }
}

