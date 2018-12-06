package com.kfryc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int count = 1;
        while (count !=6){
            System.out.println("Count value is " + count);
            count++;
        }

        count = 6;
        do {
            System.out.println("Count value was "+ count);
            count++;

            if(count > 100){
                break;
            }
        }while (count!= 6);


        int number = 4;
        int finishnumber = 20;

        int sum  = 0;
        count = 0;
        while(number <= finishnumber){
            number++;
            if(!isEvenNumber(number)){
                continue;   // goes back to the start of the loop, goes to the next iteration of the loop
            }
            sum += number;
            count++;
            System.out.println("Even number "+ number);

            if (count>= 5){
                break;
            }
        }
        System.out.println("The sum of even numbers "+ sum);


    }

    public static boolean isEvenNumber(int number){
        if ((number % 2) == 0){
            return true;
        }
        return false;
    }
}
