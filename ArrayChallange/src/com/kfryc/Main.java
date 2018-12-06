package com.kfryc;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Create a program using arrays that sorts a list of integers in descending order.
    // Descending order is highest value to lowest.
    // In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
    // ultimately have an array with 106,81,26, 15, 5 in it.
    // Set up the program so that the numbers to sort are read in from the keyboard.
    // Implement the following methods - getIntegers, printArray, and sortIntegers
    // getIntegers returns an array of entered integers from keyboard
    // printArray prints out the contents of the array
    // and sortIntegers should sort the array and return a new array containing the sorted numbers
    // you will have to figure out how to copy the array elements from the passed array into a new
    // array and sort them and return the new sorted array.

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here

        //int[] myIntegers = {106,26,81,5,15};

        int[] myIntegers = getIntegers(6);
        printArray(myIntegers);

        System.out.println();
        System.out.println("Minimum value of array is: "+findMin(myIntegers));

        sortIntegers(myIntegers);

        System.out.println();
        printArray(myIntegers);




        //a way to copy array to a new one
        int[] newArray = Arrays.copyOf(myIntegers, myIntegers.length);

    }

    public static int[] getIntegers(int size){
        int[] array = new int[size];
        for(int i=0;i<size;i++){
            System.out.println("Enter number #"+(i+1)+"\r");
            array[i] = scanner.nextInt();
        }
        scanner.close();

        return array;


    }

    public static int[] sortIntegers(int[] array){
        int temp;
        for (int i =0; i<array.length;i++){
            for(int j= i+1;j<array.length;j++){
                if(array[i]<array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        return array;


    }

    public static int findMin(int[] array){
        int min = array[0];
        for(int i =0;i<array.length;i++){
            if(min > array[i]){
                min = array[i];
            }
        }
        return min;


    }

    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.println("Element "+i+", value "+array[i]);
        }
    }
}
