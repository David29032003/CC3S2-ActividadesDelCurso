package org.example;

import java.util.ArrayList;
import java.util.List;

//Clase que representa el carrito de compras.
public class ShoppingCart {
    //Lista de items en el carrito.
    private List<CartItem> items = new ArrayList<>();

    //Metodo para agregar un item al carrito.
    public void add(CartItem item) {
        this.items.add(item);
    }

    //Metodo para calcular el precio total del carrito.
    public double totalPrice() {
        double totalPrice = 0;
        //Itera sobre los items y calcula el precio total sumando el precio unitario por la cantidad de cada item.
        for (CartItem item : items) {
            totalPrice += item.getUnitPrice() * item.getQuantity();
        }
        //Retorna el precio total calculado.
        return totalPrice;
    }
}
