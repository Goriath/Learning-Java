package com.kfryc;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languagues = new HashMap<>();

        if(languagues.containsKey("Java")){
            System.out.println("Java already exists");
        }
        else {
            languagues.put("Java", "a compiled high level, object-oriented, platform independant language");
            System.out.println("Java added successfully");
        }
        languagues.put("Python", "an interpreted, object-oriented, high level programming language with dynamic semantics");
        languagues.put("Algol", "an algorithmic language");
        languagues.put("BASIC", "Beginners All Purpose Symbolic Instruction Code");
        languagues.put("Lisp", "Madness will consume you");


        if(languagues.containsKey("Java")){
            System.out.println("Java is already in the map");
        } else {
            languagues.put("Java", "this lesson is about Java");
        }
        System.out.println(languagues.get("Java"));

        System.out.println("=======================");

        //languagues.remove("Lisp");
        if(languagues.remove("Algol", "an algorithmic language")){  //value has to be identical to work
            System.out.println("Algol removed");
        }
        else {
            System.out.println("Algol not removed, key/value pair not found");
        }

        if(languagues.replace("Lisp", "Madness will consume you", "a functional programming language with imperative features")){
            System.out.println("Lisp replaced");
        }
        else {
            System.out.println("Lisp was not replaced");
        }


        System.out.println(languagues.replace("Scala", "this will not be added")); //Scala does not exist


        for(String key: languagues.keySet()){
            System.out.println(key + " : " + languagues.get(key));
        }




    }
}
