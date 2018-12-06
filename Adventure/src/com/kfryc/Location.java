package com.kfryc;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exists;


    public Location(int locationID, String description, Map<String, Integer> exists) {
        this.locationID = locationID;
        this.description = description;
        if(exists!= null){                          //null will crash the programme
            this.exists = new HashMap<>(exists);    //makes the class immutable (cannot be changed)
        } else {
            this.exists = new HashMap<>();
        }

        this.exists.put("Q", 0);
    }

//    public void addExit(String direction, int location){
//        exists.put(direction, location);
//    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExists() {
        return new HashMap<String, Integer>(exists);    //more secure way to pass map, no changes will be made
                                                        //top the original class map
    }
}
