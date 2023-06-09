package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private int balance = 0;
    public Customer(String name, int id){
        this.name = name;
        this.id = id;
    }
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        //update this
        return this.balance;
    }
    public void addCharge(AccountRecord c){
        charges.add(c);
        balance+=c.getCharge();
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        return "Hi my name is " + this.name + " I have a balance of " +this.balance;
    }
}
