package com.kfryc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int count = 1;
        int sum = 0;
        Scanner scanner = new Scanner(System.in);


        while (count<11){
            System.out.println("Enter number #"+ count);
            boolean hasInt = scanner.hasNextInt();

            if (hasInt){
                sum += scanner.nextInt();
                count++;
            }
            else {

                System.out.println("Invalid number, please try again.");
            }
            scanner.nextLine();
        }
        System.out.println("The sum of numbers is: "+ sum);
        scanner.close();

    }
}
