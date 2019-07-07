package com.kfryc;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @org.junit.Before       //initializing before every test
    public void setup() {
        account = new BankAccount("Krzysztof", "Fryc", 1000.0, BankAccount.CHECKING);
        System.out.println("running a test...");
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200.0, true);
        assertEquals(1200.0, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)      //that way we show that we expect an exception
    public void withdraw_notBranch() throws Exception {
        account.withdraw(600.00, false);
        fail("Should have thrown an IllegalArgumentException");

    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200.0, true);
        assertEquals(1200.0, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200.0, true);
        assertEquals(800.0, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
        // assertEquals(true, account.isChecking()); // works too
        assertTrue("The account is NOT a checking account", account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }

}