package com.kfryc;

public class Main {

    public static void main(String[] args) {
	    int newScore = calculateScore("Tim", 500);
        System.out.println("new score is " + newScore);

        calculateScore(75);
        calculateScore();

        calcFeetAndInchesToCentimeters(1);
        calcFeetAndInchesToCentimeters(1,0);

        System.out.println("");
        System.out.println(getDurationString(900000));
        System.out.println(getDurationString(140, 40));

    }

    public static int calculateScore(String playerName, int score){
        System.out.println("Player " + playerName + " score " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(int score){
        System.out.println("Unnamed player scored " + score + " points");
        return score * 1000;
    }

    public static int calculateScore(){
        System.out.println("No player name, no player score");
        return 0;
    }


    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if ( (feet >0) && (inches >=0 && inches <=12)){
            double cm = ((feet*12)*2.54d) + (inches*2.54d);
            System.out.println(cm + "cm");
            return cm;
        }
        return -1;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){
        if (inches >=0){
            double cm = inches*2.54;
            System.out.println(cm + "cm");
            return cm;
        }
        return -1;
    }

    public static String getDurationString(int minutes, int seconds){
        if (minutes < 0 || seconds < 0 || seconds > 60)
            return "Invalid value";

        int hour = minutes/60;
        minutes = minutes % 60;
        return hour + "h " + minutes + "m " + seconds + "s";

    }

    public static String getDurationString(int seconds){
        if (seconds < 0)
            return "Invalid value";
        int minutes = seconds/60;
        seconds = seconds % 60;
        return getDurationString(minutes, seconds);

    }



}
