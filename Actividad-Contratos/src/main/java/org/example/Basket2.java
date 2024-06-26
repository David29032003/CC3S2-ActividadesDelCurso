package org.example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Basket2 {
    private BigDecimal totalValue = BigDecimal.ZERO;
    // Usamos BigDecimal en lugar de double para evitar problemas de redondeo en Java.
    private Map<Product, Integer> basket = new HashMap<>();

    public void add(Product product, int qtyToAdd){
        // Precondición: product no debe ser null.
        if(product == null){
            throw new IllegalArgumentException("El producto no puede ser null");
        }

        // Precondición: qtyToAdd debe ser mayor que 0.
        if(qtyToAdd <= 0){
            throw new IllegalArgumentException("La cantidad a agregar debe ser mayor que 0");
        }

        // Almacena el valor total anterior para la verificación de la postcondición.
        BigDecimal previousTotalValue = totalValue;

        // Agrega el producto al carrito.
        basket.put(product, basket.getOrDefault(product,0) + qtyToAdd);

        // Actualiza el valor total del carrito.
        totalValue = totalValue.add(product.getPrice().multiply(BigDecimal.valueOf(qtyToAdd)));

        // Postcondicion Nueva: el nuevo valor total debe ser mayor que el valor total anterior.
        if(totalValue.compareTo(previousTotalValue) <=0){
            throw new IllegalStateException("El nuevo valor total debe ser mayor que el valor total anterior");
        }
    }

    public void remove(Product product){
        // Precondición: product no debe ser null.
        if(product == null){
            throw new IllegalArgumentException("El producto no puede ser ser null");
        }

        // Precondición: product debe existir en el carrito.
        if (!basket.containsKey(product)){
            throw new IllegalArgumentException("El producto no esta en el carrito");
        }

        // Almacena la cantidad del producto y su valor total antes de la eliminación.
        int qtyInBasket = basket.get(product);
        BigDecimal previousTotalValue = totalValue;

        // Elimina el producto del carrito.
        basket.remove(product);

        // Actualiza el valor total del carrito.
        totalValue = totalValue.subtract(product.getPrice().multiply(BigDecimal.valueOf(qtyInBasket)));

        // Postcondición: el valor total del carrito debe ser mayor o igual a cero.
        if (totalValue.compareTo(BigDecimal.ZERO) <0){
            throw new IllegalArgumentException("El valor del carrito no puede ser negativo");
        }
    }
}
