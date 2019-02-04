package com.kfryc;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location implements Serializable {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;
    private long serialVersionUID = 1L;     //needed for Serialization


    public Location(int locationID, String description, Map<String, Integer> exists) {
        this.locationID = locationID;
        this.description = description;
        if(exists!= null){                          //null will crash the programme
            this.exits = new LinkedHashMap<>(exists);    //makes the class immutable (cannot be changed)
        } else {
            this.exits = new LinkedHashMap<>();
        }

        this.exits.put("Q", 0);
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
        return new LinkedHashMap<String, Integer>(exits);    //more secure way to pass map, no changes will be made
                                                        //top the original class map
    }

    protected void addExit(String direction, int location){
        exits.put(direction, location);
    }
}
