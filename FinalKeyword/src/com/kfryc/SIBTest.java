package com.kfryc;

public class SIBTest {
    public static final String owner;
    static {        //static initialization block, it will be printed first
        owner = "tim";
        System.out.println("SIBTest static initialization block called");
    }

    public SIBTest(){
        System.out.println("SIB constructor called");
    }

    static {        //static initialization block, it will be printed second. They are called even before constructor!
        System.out.println("2nd initialization block called");
    }

    public void someMethod(){
        System.out.println("someMethod called");
    }

}
