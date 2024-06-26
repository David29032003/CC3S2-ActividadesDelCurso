package org.example;

public class TaxCalculator1 {

    public double calculateTax(double value){
        // Precondición: el valor debe ser no negativo
        assert value >= 0: "Value has to be positive";

        double taxValue = value*0.18;

        // Postcondición: el valor del impuesto debe ser no negativo
        assert taxValue >=0: "Calculated tax cannot be negative";

        return taxValue;
    }
}
