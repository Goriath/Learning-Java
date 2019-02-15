package com.kfryc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Employee pawel = new Employee("Pawel Nowak", 35);
        Employee krzysztof = new Employee("Krzysztof Fryc", 32);
        Employee magda = new Employee("Magda Kowalska", 30);
        Employee anna = new Employee("Anna Rodo", 28);
        Employee robert = new Employee("Robert Lewandowski", 31);
        Employee johnny = new Employee("Johnny Bravo", 42);


        List<Employee> employees = new ArrayList<>();
        employees.add(pawel);
        employees.add(krzysztof);
        employees.add(magda);
        employees.add(anna);
        employees.add(robert);
        employees.add(johnny);


        // Option 3 using lambda and Predicate
        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        printEmployeesByAge(employees, "Employees 30 and under", employee -> employee.getAge() <= 30);
        printEmployeesByAge(employees, "Employees over 33", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 33;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan50 = i -> i < 50;
        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a + 5));
        System.out.println(greaterThan15.and(lessThan50).test(40)); //combining two predicates with and() method
        System.out.println(greaterThan15.and(lessThan50).test(60)); //combining two predicates with and() method

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i=0;i<10;i++){
            System.out.println(randomSupplier.get());
        }

//        System.out.println("Employees over 30:");
//        System.out.println("__________________");

        // Option 1
//        for(Employee employee : employees){
//            if(employee.getAge()> 30){
//                System.out.println(employee.getName());
//            }
//        }

        // Option 2 using lambda
//        employees.forEach(employee -> {
//            if (employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        });
//
//        System.out.println("\nEmployees 30 and younger:");
//        System.out.println("__________________");
//        employees.forEach(employee -> {
//            if (employee.getAge() <= 30) {
//                System.out.println(employee.getName());
//            }
//        });
    }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("==================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
        System.out.println("__________________");
    }
}
