package com.kfryc;

public class Main {

    public static void main(String[] args) {
	    int swithcValue = 4;

	    switch (swithcValue){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;

            case 3: case 4: case 5:
                System.out.println("Was a 3, or 4, or 5");
                break;
            default:
                System.out.println("Was not 1 or 2");
                break;
        }
    }
}
