package com.kfryc;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private String phoneNumber;


    public BankAccount(){
        this("4353", 0.0, "Dafault name",
                "Default email", "Default phone");
        System.out.println("Empty constructor called");

    }

    public BankAccount(String customerName, String email, String phoneNumber) {
        this("9999", 100, customerName, email, phoneNumber);

    }

    public BankAccount(String accountNumber, double balance, String customerName, String email, String phoneNumber){
        System.out.println("Constructor with parameters called.");
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public void setBalance(double balance){
        this.balance = balance;

    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public String getCustomerName(){
        return customerName;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void depositFunds(double deposit){
        this.balance += deposit;
        System.out.println("$"+deposit+" have been deposited to your account. New balance is $"+balance);
    }

    public void withdrawFunds(double withdraw){
        if(this.balance >= withdraw){
            this.balance-= withdraw;
            System.out.println("$"+withdraw + " have been withdrawn from your account. Your current balance is $"
                    +this.balance);
        }
        else{
            System.out.println("Error. Insufficient funds on account to withdraw $"+withdraw+".");
        }
    }

}
