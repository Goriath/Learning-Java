package com.kfryc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        // Challenge 1
        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        // Challenge 2
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i =0;i< s.length();i++){
                if(i % 2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // Challenge 3
        System.out.println(lambdaFunction.apply("1234567890"));

        // Challenge 5
        System.out.println(everySecondCharacter(lambdaFunction, "1234567890"));

        // Challenge 6
        Supplier<String> iLoveJava = () -> "I love Java!";

        // Challenge 7
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        // Challenge 9
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name ->
                firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1)));
//        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
//        firstUpperCaseList.forEach(s -> System.out.println(s));
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

//        topNames2015.stream()
//                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
//                .sorted(String::compareTo)
//                .forEach(System.out::println);

        long numberOfA = topNames2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(s -> s.startsWith("A"))
                .count();

        System.out.println("Number of names beginning with A: " + numberOfA);

    }

    // Challenge 4
    public static String everySecondCharacter(Function<String, String> function, String text){
        return function.apply(text);
    }
}
