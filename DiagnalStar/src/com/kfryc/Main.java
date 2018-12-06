package com.kfryc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        printSquareStar(9);
    }

    public static void printSquareStar(int number){
        if (number < 5){
            System.out.println("Invalid Value");
        }


        String star ="*";

        for(int i=1;i<=number;i++){
            System.out.print(star);
            for(int j=2;j<=number;j++){
                if(i==1 || i==number || j==number){
                    System.out.print(star);
                }
                else if(j==number-i+1 || j==number-(number-i)){
                    System.out.print(star);
                }
                else System.out.print(" ");

            }

            System.out.println();
        }
    }
}
