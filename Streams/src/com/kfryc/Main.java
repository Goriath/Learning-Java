package com.kfryc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");

        List<String> gNumbers = new ArrayList<>();


//        // Using foreach to add and sort the arraylist
//        someBingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
////                System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        // Using Stream to do exactly the same
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)   //same as .map(s -> s.toUpperCase())
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("---------------------");
        System.out.println(concatStream
                .distinct()                 // distinct() removes duplicates
                .peek(System.out::println)  // peek() enables us to continue the chain - mainly used for debugging
                .count());


        Employee krzysiek = new Employee("Krzysztof Fryc", 32);
        Employee anna = new Employee("Anna Rodo", 25);
        Employee magda = new Employee("Magda Kowalska", 28);
        Employee pawel = new Employee("Pawel Nowak", 35);

        Department hr = new Department("Human Resources");
        hr.addEmployee(anna);
        hr.addEmployee(magda);
        hr.addEmployee(pawel);
        Department it = new Department("IT");
        it.addEmployee(krzysiek);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(it);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())  //flatMap() wants a stream
                .forEach(System.out::println);

        System.out.println("------------------------");
//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

        Map<Integer, List<Employee>> groupByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));


        // Using BiFunction for finding the youngest employee
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();

    }
}
