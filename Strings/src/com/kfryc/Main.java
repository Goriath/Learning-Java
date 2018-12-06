package com.kfryc;

public class Main {

    public static void main(String[] args) {
        String myString = "This is a string";

        System.out.println(myString);

        myString = myString + " \u00A9 2018";

        System.out.println(myString);

        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println("The result is " + numberString);


        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println(lastString);


    }
}
