package com.example.Ejemplo3ActividadMetricasDeCalidadDeSoftware;

public class Refactor {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        if (a > 50) {
            if (a > 100) {
                System.out.println("A is greater than 100");
            } else {
                System.out.println("A is greater than 50 but not more than 100");
            }
        } else {
            if (a < 20) {
                System.out.println("A is less than 20");
            } else {
                System.out.println("A is between 20 and 50");
            }
        }
    }
}
