package com.kfryc;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);  //this disables future changes for the class satellites
    }

    public boolean addMoon(HeavenlyBody moon){
        return this.satellites.add(moon);
    }



    @Override
    public boolean equals(Object obj){      //we have overriden the equals() function by using Object type
                                            //(HeavenlyBody would not override but overload the function
                                            // and it would not work for us
        if(this == obj){
            return true;
        }
        System.out.println("obj.getClass() is" + obj.getClass());
        System.out.println("this.getClass() is" + this.getClass());
        if((obj == null) || (obj.getClass() != this.getClass())){
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+57;     //the 57 number is random but high enough to avoid different HashSet "buckets"
    }
}
