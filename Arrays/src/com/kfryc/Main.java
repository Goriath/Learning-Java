package com.kfryc;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
//        int[] myIntArray = {1,2,3,4,5,6,7,8,9,10};     //assigned 10 elements to the array of int type
        int[] myIntArray = new int[10];

        myIntArray[5] = 50;                 //saving in slot nr 6! (start counting from 0), a value of 50;
        double[] myDoubleArray = new double[10];
        System.out.println(myIntArray[0]);
        System.out.println(myIntArray[3]);
        System.out.println(myIntArray[5]);
        System.out.println(myIntArray[9]);

        printArray(myIntArray);

        System.out.println();

        int[] myIntegers = getIntegers(5);

        for(int i = 0;i< myIntegers.length;i++) {
            System.out.println("Element " + i + ", value is " + myIntegers[i]);
        }

        System.out.println("The average is "+ getAverage(myIntegers));

    }

    public static int[] getIntegers(int number){
        System.out.println("Enter "+ number + " integer values. \r");
        int[] values = new int[number];
        for(int i =0; i<values.length;i++){
            values[i] = scanner.nextInt();
        }
        scanner.close();

        return values;


    }

    public static double getAverage(int[] array){
        int sum = 0;

        for(int i =0;i<array.length;i++){
            sum+= array[i];
        }
        return (double) (sum/array.length);
    }


    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            array[i] = i*10;
            System.out.println("Element "+i+", value is "+ array[i]);
        }
    }
}
