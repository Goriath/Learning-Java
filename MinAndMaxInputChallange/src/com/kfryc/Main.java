package com.kfryc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        //boolean first = true;

        while (true){
            System.out.println("Enter number: ");
            boolean hasInt = scanner.hasNextInt();
            if (hasInt){
                int number = scanner.nextInt();
                //if (first){
                //    first = false;
                //    min = number;
                //    max = number;
                //}
                if (number < min){
                    min = number;
                }
                if (number > max){
                    max = number;
                }
                scanner.nextLine();
            }
            else{
                break;
            }

        }
        scanner.close();

        System.out.println("Minimum number: "+min);
        System.out.println("Maximum number: "+max);
    }
}
