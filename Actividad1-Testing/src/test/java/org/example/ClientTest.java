package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class ClientTest {
    //Arrange
    private Address address = new Address("street A");
    private Address otherAddress = new Address("street A");
    private  Client client ;
    @BeforeEach
    void setUp() {
        client =new Client();
    }
    @Test

    void afterCreationShouldHaveNoAddress() {
        //Act
        int num_direcciones = client.getAddresses().size();
        //Assert
        assertEquals(0,num_direcciones);
    }

    @Test
    void shouldAllowToAddAddress() {
        //Act
        client.addAddress(address);
        int num_direcciones = client.getAddresses().size();
        //Assert
        assertEquals(1, num_direcciones);
    }
    @Test
    void shouldAllowToAddSameAddresses() {
        //Act
        client.addAddress(address);
        client.addAddress(otherAddress);
        String direccion1_cliente = client.getAddresses().get(0).getStreet();
        String direccion2_cliente = client.getAddresses().get(1).getStreet();
        //Assert
        assertEquals(direccion2_cliente, direccion1_cliente);
    }


}
