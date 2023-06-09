package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        List<Customer> customers= new ArrayList<>();
        Set<String> names = new HashSet<String>();
        HashMap<Integer, Customer> cust = new HashMap<Integer, Customer>();
        for(String[] s: customerData){
            int id = Integer.parseInt(s[0]);

            if (cust.containsKey(id)){
                AccountRecord accountRecord = new AccountRecord(s[3],Integer.parseInt(s[2]));
                Customer c = cust.get(id);
                c.addCharge(accountRecord);
            }
            else{
                Customer c = new Customer(s[1], id);
                c.addCharge(new AccountRecord(s[3],Integer.parseInt(s[2])));
                cust.put(id, c);
            }

        }
        System.out.println(cust.values());

        List<Customer> positiveAccounts = cust.values().stream().filter(customer -> customer.getBalance()>=0).collect(Collectors.toList());
        List<Customer> negativeAccount = cust.values().stream().filter(customer -> customer.getBalance()<0).collect(Collectors.toList());
        //Update this
        System.out.println("Positive accounts:" + positiveAccounts);
        System.out.println("Negative accounts:" + negativeAccount);
    }
}
