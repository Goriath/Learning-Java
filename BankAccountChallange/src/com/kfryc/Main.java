package com.kfryc;

public class Main {

    public static void main(String[] args) {
        // write your code here


        BankAccount bankAccount = new BankAccount("12341", 100, "Krzysztof Fryc", "kr.fryc@gmail.com",
                "(+48) 123 122 553");
//        BankAccount bankAccount = new BankAccount();
//        bankAccount.setAccountNumber("11234551");
//        bankAccount.setBalance(100.0);
//        bankAccount.setCustomerName("Krzysztof Fryc");
//        bankAccount.setEmail("kr.fryc@gmail.com");
//        bankAccount.setPhoneNumber("123151324");

        bankAccount.depositFunds(50);
        bankAccount.withdrawFunds(150);
        bankAccount.withdrawFunds(100);

        BankAccount bobAccount = new BankAccount("Bob", "bob@fas.com", "1234");
        System.out.println(bobAccount.getAccountNumber() + " name " + bobAccount.getCustomerName());


        VipCustomer person1 = new VipCustomer();
        System.out.println(person1.getName());

        VipCustomer person2 = new VipCustomer("Bob", "bob@asd.com");
        System.out.println(person2.getName());

        VipCustomer person3 = new VipCustomer("Tim", 2000, "Tim@asda.com");
        System.out.println(person3.getName());
        System.out.println(person3.getEmail());


    }
}
