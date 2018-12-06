package com.kfryc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        numberToWords(1020);
    }

    public static void numberToWords(int number){
        if (number <0){
            System.out.println("Invalid Value");
        }
        int num = reverse(number);
        int j = getDigitCount(number);
        System.out.println(getDigitCount(number));
        System.out.println(reverse(number));

        for (int i = 1;i<=j;i++){
            //System.out.println(num%10);
            switch (num%10){
                case 0: System.out.println("Zero");
                    break;
                case 1: System.out.println("One");
                    break;
                case 2: System.out.println("Two");
                    break;
                case 3: System.out.println("Three");
                    break;
                case 4: System.out.println("Four");
                    break;
                case 5: System.out.println("Five");
                    break;
                case 6: System.out.println("Six");
                    break;
                case 7: System.out.println("Seven");
                    break;
                case 8: System.out.println("Eight");
                    break;
                case 9: System.out.println("Nine");
                    break;
            }
            num/=10;
        }


    }

    public static int getDigitCount(int number){
        if (number <0){
            return -1;
        }

        int count = 1;
        while (number > 9){
            count++;
            number/=10;
        }
        return count;

    }


    public static int reverse(int number){
        int temp = number;
        if (number <0){
            number*=-1;
        }

        int result = 0;
        while (number >0){
            result = (result * 10) + (number % 10);
            number /=10;
        }

        if (temp< 0){
            result*=-1;
        }

        return result;
    }

}
