package com.kfryc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//A Strategy for Defining Immutable Objects
//      1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
//      2. Make all fields final and private.
//      3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final. A more sophisticated approach is to make the constructor private and construct instances in factory methods.
//      4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
//        - Don't provide methods that modify the mutable objects.
//        - Don't share references to the mutable objects. Never store references to external, mutable objects passed to the constructor; if necessary, create copies, and store references to the copies. Similarly, create copies of your internal mutable objects when necessary to avoid returning the originals in your methods.


public class Main {

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0,"You are sitting in front of a computer learning Java", tempExit));
        
        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
//        tempExit.put("Q", 0);         //we have added this in constructor as exit is by default available
        locations.put(1, new Location(1,"You are standing at the end of road before a brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
//        tempExit.put("Q", 0);
        locations.put(2, new Location(2,"You are in a busy street", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
//        tempExit.put("Q", 0);
        locations.put(3, new Location(3,"You are inside skyscraper, a corporation rat-race cage", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
//        tempExit.put("Q", 0);
        locations.put(4, new Location(4,"You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
//        tempExit.put("Q", 0);
        locations.put(5, new Location(5,"You are in the forest", tempExit));

        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");



        int loc = 1;
        while(true){
            System.out.println(locations.get(loc).getDescription());
            if(loc==0){
                break;
            }

            Map<String,Integer> exits = locations.get(loc).getExists();
            System.out.println("Available exits are ");
            for(String exit : exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();

            String[] input = scanner.nextLine().toUpperCase().split(" ");
            String direction = input[0];
            for(String text : input){
                if(vocabulary.containsKey(text)){
                    direction = vocabulary.get(text);
                    break;
                } else {
                    direction = text;
                }
            }

            if(exits.containsKey(direction)){
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
