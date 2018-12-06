package com.kfryc;

public class Main {

    public static void main(String[] args) {
        System.out.println("10,000 at 2% interest = "+ calculateInterest(10000.0,2.0));
        System.out.println("10,000 at 3% interest = "+ calculateInterest(10000.0,3.0));
        System.out.println("10,000 at 4% interest = "+ calculateInterest(10000.0,4.0));
        System.out.println("10,000 at 5% interest = "+ calculateInterest(10000.0,5.0));


        for(int i=2; i <= 8; i++){
            System.out.println("10,000 at "+ i +"% interest = "+ String.format("%.2f", calculateInterest(10000.0,i)));
        }

        System.out.println("******************");

        for(int i=8; i >= 2; i--){
            System.out.println("10,000 at "+ i +"% interest = "+ String.format("%.2f", calculateInterest(10000.0,i)));
        }

        int count = 0;
        for(int i=20;i<=100;i++){

            if(isPrime(i)){
                System.out.println(i+ " is a prime number");
                count++;
                if (count==3){
                    break;
                }
            }


        }


        System.out.println("Challange part");
        System.out.println("");

        count = 0;
        int sum = 0;

        for(int i = 1; 1<=1000;i++){
            if((i % 3 == 0) && (i % 5 ==0)) {
                sum += i;
                System.out.println("Found number " + i);
                count++;
            }
            if(count==5){
                break;
            }
        }
        System.out.println("The sum of number is " + sum);

    }



    public static boolean isPrime(int n){

        if(n==1){
            return false;
        }
        for(int i = 2; i <= (long) Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }



    public static double calculateInterest(double amount, double interestRate){
        return (amount*(interestRate/100));
    }
}
