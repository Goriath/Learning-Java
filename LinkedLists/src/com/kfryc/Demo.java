package com.kfryc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {    //psvm will create a public static void main method
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Andelaide");
        addInOrder(placesToVisit, "Darwin");


        printList(placesToVisit);

        addInOrder(placesToVisit, "Alice Springs");
        addInOrder(placesToVisit, "Darwin");


        printList(placesToVisit);

        placesToVisit.remove(4);

        printList(placesToVisit);


        visit(placesToVisit);



    }

    public static void printList(LinkedList<String> linkedList){
        Iterator<String> i = linkedList.iterator();     //Different way to go through Array or List
        while (i.hasNext()){
            System.out.println("Now visiting "+ i.next());
        }
        System.out.println("====================");
    }




    private static boolean addInOrder(LinkedList<String> linkedList, String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);

            if(comparison== 0){
                //the new City is equal, do not add to list
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if(comparison>0){
                // new City should appear before this one (in alphabetical order)
                // Brisbane -> Adelaide
                stringListIterator.previous();  //because earlier we used .next() method and already went ahead
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0){
                //move on next city
                //we already used .next earlier so we do not need to do anything.
            }


        }
        stringListIterator.add(newCity);
        return true;
    }


    private static void visit(LinkedList<String> cities){
        Scanner scanner = new Scanner(System.in);
        boolean goingForward = true;       //this is used to control the LinkList issue when going forward
                                           //and backward. Otherwise it will print the same city twice.

        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()){
            System.out.println("No cities in the itenerary");
        } else {
            System.out.println("Now visiting "+ listIterator.next());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit=true;
                    break;
                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting "+ listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting "+ listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward =true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }


    }

    private static void printMenu(){
        System.out.println("Available actions: /n press ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city \n"+
                "2 - go to previous city \n"+
                "3 - print menu options");
    }


}
