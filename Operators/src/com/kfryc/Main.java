package com.kfryc;

public class Main {

    public static void main(String[] args) {
        int result = 1 +2 ;

        int previousResult = result;
        result = result -1;

        System.out.println("result = " + result);
        System.out.println(previousResult + " - 1 = " + result);

        previousResult = result;

        result = result * 10;
        System.out.println(previousResult + " * 10 = " + result);

        previousResult = result;

        result = result / 5;

        System.out.println(previousResult + " + 5 = " + result);

        previousResult = result;

        result = result % 3;            // returns the remaining of dividing without the decimal part.

        System.out.println(previousResult + " % 3 = " + result);

        previousResult = result;

        result++;                       // increases by 1
        System.out.println("Result is now " + result);

        result--;                       // decreases by 1
        System.out.println("Result is now " + result);

        result += 2;                    // adds by set amount (2 this case)
        System.out.println("Result is now " + result);

        result *= 10;                   // multiplies by set amount (10 this case)
        System.out.println("Result is now " + result);
        result-=10;                     // substract by a set amount (10 this case)
        System.out.println("Result is now " + result);
        result/=10;                     // divides by a set amount (10 this case)
        System.out.println("Result is now " + result);


        boolean isAlien = true;    //assigns the value
        if (isAlien==false)         //tests if value is equal
            System.out.println("It is not an alien");
        else
            System.out.println("It is an alien!");

        int topScore = 100;
        if (topScore ==100)
            System.out.println("You got the high score!");

        int secondTopScore = 80;

        if ((topScore >secondTopScore) && (topScore <=90))        //And operator &&
            System.out.println("Greater than second top score and more than 90");

        if ((topScore >90) || (secondTopScore <=70))        //Or operator ||
            System.out.println("One of the tests is true");


        int newValue = 50;
        if(newValue ==50)
            System.out.println("This is true :)");

        boolean isCar = false;
        if (isCar = true)           //With boolean it can go through with one =! Because the value is being assigned inside if statement. You have to be careful with this one!
            System.out.println("This is not supposed to happen");

        if(isCar)               // no need to type == true
            System.out.println("Or is it a car?");


        isCar = true;
        boolean wasCar = isCar ? true : false;      //if isCar equal true then return true, if not return false


        if(wasCar)
            System.out.println("wasCar is true");


        //challenge

        double myValue1 = 20d;
        double myValue2 = 80d;
        double myTotal = (myValue1 + myValue2) * 25;
        myTotal = myTotal % 40;
        if (myTotal <= 20)
            System.out.println("Total was over the limit");



    }
}
