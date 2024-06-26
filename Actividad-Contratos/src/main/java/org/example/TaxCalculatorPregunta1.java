package org.example;

public class TaxCalculatorPregunta1 {

    public double calculateTax(double value){
        //Precondición: el valor debe ser no negativo
        if(value < 0){
            throw new RuntimeException("Value has to be positive");
        }

        double tax = value*0.18;

        //Postcondición: el valor del impuesto debe ser no negativo
        if(tax<0){
            throw new RuntimeException("Tax has to be positive");
        }

        return tax;
    }
}
