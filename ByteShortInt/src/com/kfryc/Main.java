package com.kfryc;

public class Main {

    public static void main(String[] args) {


        //int has width of 32
        int myValue = 10_000;
        int myTotal = myValue/2;

        //byte has width of 8
	    byte myByteValue = 10;
	    byte myNewByteValue = (byte) (myByteValue/2);

	    //short has a width of 16
	    short myShortValue = 30_000;

	    //long has a width of 64
	    long myLongValue = 100L;    //L is used to define that it is a long value
        long myChallangeValue = 50_000 + 10L * (myValue + myByteValue + myShortValue);

        System.out.println(myChallangeValue);
    }
}
