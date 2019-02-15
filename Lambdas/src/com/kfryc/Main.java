package com.kfryc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Option 1
//	    new Thread(new CodeToRun()).start();

        //Option 2
//	    new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from the Runnable");
//            }
//        }).start();

        // Option 3 using lambda
//        new Thread(() -> {
//            System.out.println("Printing from the Runnable");
//            System.out.println("Line 2");
//            System.out.format("This is line %d\n",3);
//        }).start();

        Employee pawel = new Employee("Pawel Nowak", 35);
        Employee krzysztof = new Employee("Krzysztof Fryc", 32);
        Employee magda = new Employee("Magda Kowalska", 30);
        Employee anna = new Employee("Anna Rodo", 28);


        List<Employee> employees = new ArrayList<>();
        employees.add(pawel);
        employees.add(krzysztof);
        employees.add(magda);
        employees.add(anna);

        // Option 1 with lambda
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        // Option 2 with lambda
//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//            //new Thread(() -> System.out.println(employee.getAge())).start();
//        }


        // Variables can be changed within lambda expression but not variables that are outside lambda
//        System.out.println("**************");
//        for(int i =0;i<employees.size();i++){
//            Employee employee = employees.get(i);
//            System.out.println(employee.getName());
//            new Thread(() -> System.out.println(employee.getAge())).start();
//        }

//        // Option 1
////        Collections.sort(employees, new Comparator<Employee>() {
////            @Override
////            public int compare(Employee employee1, Employee employee2) {
////                return employee1.getName().compareTo(employee2.getName());
////            }
////        });
//
//        // Option 2 using lambda - compiler knows that Employee class is being used
//        Collections.sort(employees, (employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName()));
//
//        for(Employee employee : employees){
//            System.out.println(employee.getName());
//        }
//
//        // Option 1
////        String sillyString = doStringStuff(new UpperConcat() {
////            @Override
////            public String upperAndConcat(String s1, String s2) {
////                return s1.toUpperCase() + s2.toUpperCase();
////            }
////        }, employees.get(0).getName(), employees.get(1).getName());
////        System.out.println(sillyString);
//
//        // Option 2 using lambda
////        UpperConcat uc = ( s1,  s2) -> s1.toUpperCase() + s2.toUpperCase();
////        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
////        System.out.println(sillyString);
//
//        // Option 3 using lambda with return
//        UpperConcat uc = (s1, s2) -> {
//                String result = s1.toUpperCase() + s2.toUpperCase();
//                return result;
//        };
//        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

//        AnotherClass anotherClass = new AnotherClass();
//        String s = anotherClass.doSomething();
//        System.out.println(s);

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}


class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
        int i = 0;  // the variable has to be final or never changed in order to be used in lambda expression
        //i++; //will not work
        // Option 1
//        UpperConcat uc = new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("i (within anonymous class) = " + i);
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        };

        // Option 2 using lambda
        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression's class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
        return Main.doStringStuff(uc, "String1", "String2");


//        UpperConcat uc = (s1, s2) -> {
//            System.out.println("The lambda expression's class is: " +getClass().getSimpleName());
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(uc, "String1", "String2");

//        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " +getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1" , "String2");
    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("The value is " + number);
        };

        new Thread(r).start();
    }
}

// To option 1
//class CodeToRun implements Runnable {
//    @Override
//    public void run() {
//        System.out.println("Printing from the Runnable");
//    }
//}