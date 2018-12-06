package com.kfryc;

public class Main {

    public static void main(String[] args) {
        //width of int is 32 (4 bytes)
        int myIntValue = 5 / 2;

        //width of float is 32 (4 bytes)
        float myFloatValue = 5f / 3f;    // Put f to assign it as float value - it has smaller decimal point.

        //width of double is 64 (8 bytes)
        double myDoubleValue = 5d / 3d;  // Put d to assign it as float value - Java sets Double by default for decimal numbers

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);

        //Convert pounds do kilograms

        double myPoundValue = 500d;
        double poundToKilogramRatio = 0.45359237d;
        double myKilogramValue = myPoundValue * poundToKilogramRatio;
        System.out.println(myKilogramValue);


    }
}
