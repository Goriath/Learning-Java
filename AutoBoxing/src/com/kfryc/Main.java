package com.kfryc;

import java.util.ArrayList;


class IntClass{
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Tim");

//        ArrayList<int> intArrayList = new ArrayList<int>();   // cannot use int or other primitive types to ArrayList!
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();

        intClassArrayList.add(new IntClass(54));


        //Better to use Classes rather than the above for primitive types.
        Integer integer = new Integer(54);
        Double doubleValue = new Double(12.25);

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for(int i=0;i<=10;i++){
            intArrayList.add(Integer.valueOf(i));   // AutoBoxing from int to Integer.
        }

        for (int i =0;i<=10;i++){
            System.out.println(i + " -> " + intArrayList.get(i).intValue());
        }


        Integer myIntValue = 56;        //can be used in this case, replaces new Integer(54).
                                        // Better to use the short way
        int myInt = myIntValue;         //Java is putting myInt.intValue() automatically

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl = 0.0;dbl<=10.0;dbl+=0.5){
            myDoubleValues.add(dbl);            //same as: myDoubleValues.add(Double.valueOf(dbl));
        }

        for (int i=0;i<myDoubleValues.size();i++){
            double value = myDoubleValues.get(i); // same as: myDoubleValues.get(i).doubleValue()
            System.out.println(i + " --> "+ value);
        }

    }
}
