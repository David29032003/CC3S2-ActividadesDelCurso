package org.example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Basket {
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

        // Agrega el producto al carrito.
        basket.put(product, basket.getOrDefault(product,0) + qtyToAdd);

        // Actualiza el valor total del carrito.
        totalValue = totalValue.add(product.getPrice().multiply(BigDecimal.valueOf(qtyToAdd)));
    }

    public void remove(Product product){

    }


}
