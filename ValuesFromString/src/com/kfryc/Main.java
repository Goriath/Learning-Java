package com.kfryc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String numberAsString = "2018.125";
        System.out.println("numberAsString = " + numberAsString);

        double number = Double.parseDouble(numberAsString);

        System.out.println("number = " + number);

        numberAsString +=1;
        number+=1;
        System.out.println("numberAsString = " + numberAsString);
        System.out.println("number = " + number);


        System.out.println(getLargestPrime(21));


    }



    public static int getLargestPrime(int number){
        int count = 0;
        for (int i = number;i>=1;i--){
            if(number%i==0) {
                for (int j = i; j >= 2; j--) {
                    if (i % j == 0) {
                        System.out.println(i + " " + j);
                        count++;
                    }

                }
            }
            if (count == 1){
                return i;
            }
            count= 0;
        }

        return -1;
    }
}
