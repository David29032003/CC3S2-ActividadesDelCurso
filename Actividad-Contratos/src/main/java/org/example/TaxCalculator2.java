package org.example;

public class TaxCalculator2 {

    public double calculateTax(double value){
        //No hay precondiciones para verificar,cualquier valor es válido
        // Simulación de lógica de cálculo de impuestos
        double taxValue = value * 0.18;

        // Postcondición: el valor del impuesto debe ser no negativo
        if(taxValue < 0){
            return 0;
        }

        return taxValue;
    }
}
