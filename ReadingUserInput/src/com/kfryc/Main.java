package com.kfryc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   //Scanner class is used to take data.

        System.out.println("Enter your year of birth: ");
        boolean hasNextInt = scanner.hasNextInt();  //checks if the scanner will have int and if not it will return boolean
        if (hasNextInt){
            int yearOfBirth = scanner.nextInt();        //Scanner has multiple methods. This one converts to integer
            scanner.nextLine();                         //We need to enter nextLine(), otherwise it will not handle
            //next line character (Enter key)

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();    // Scanner method to get String

            int age = 2018 - yearOfBirth;
            if (age>=0 && age <=100){
                System.out.println("Your name is "+ name + " and you are " + age + " years old.");
            } else {
                System.out.println("Invalid year of birth");
            }
        }
        else {
            System.out.println("Unable to parse year of birth.");
        }
        scanner.close(); // we need to close the scanner after we do not need it to release memory!

    }

}
