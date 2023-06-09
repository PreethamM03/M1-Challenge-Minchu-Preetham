package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    Customer customer;

    @BeforeEach
    public void setup(){
        customer = new Customer("test",1);
    }

    @Test
    public void shouldAddTwoPositiveChargesAndReturnBalance(){
        customer.addCharge(new AccountRecord("April 4th", 10000));
        customer.addCharge(new AccountRecord("April 5th", 15000));
        assertEquals(25000,customer.getBalance());

    }

    @Test
    public void shouldReturnProperToString(){
        assertEquals("Hi my name is test I have a balance of 0", customer.toString());
    }



}