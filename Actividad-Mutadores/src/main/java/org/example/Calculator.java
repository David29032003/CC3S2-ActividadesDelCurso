package org.example;

public class Calculator {
    public int add(int a, int b) {
        return a + b;// Error intencional
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;// Error intencional
    }
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        return a / b;
    }
    public int calculate(String operation, int a, int b) {
        switch (operation) {
            case "add":
                return add(a, b);
            case "subtract":
                return subtract(a, b);
            case "multiply":
                return multiply(a, b);
            case "divide":
                return divide(a, b);
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
