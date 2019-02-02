package com.kfryc;

import java.io.IOException;
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

    private static Locations locations = new Locations();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);



        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");



        Location currentLocation = locations.getLocation(1);
        while(true){
            System.out.println(currentLocation.getDescription());
            if(currentLocation.getLocationID()==0){
                break;
            }

            Map<String,Integer> exits = currentLocation.getExists();
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
                currentLocation = locations.getLocation(currentLocation.getExists().get(direction));
            } else {
                System.out.println("You cannot go in that direction");
            }
        }

        locations.close();
    }
}
