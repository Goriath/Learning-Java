package com.kfryc;

public class Series {

    public static long fibonacci(int number){
        long result = 0;
        if(number ==0){
            return 0;
        }else if( number == 1 || number == 2){
            return 1;
        } else {
            result = fibonacci(number-1)+ fibonacci(number-2);
        }
        return result;

    }

    public static long factorial(int number){
        if(number == 0){
            return 1;
        }
        long result = 1;
        for(int i=1;i<=number;i++){
            result*=i;
        }
        return result;
    }

    public static long nSum(int number){
        return (number * (number+1))/2;
    }

}
