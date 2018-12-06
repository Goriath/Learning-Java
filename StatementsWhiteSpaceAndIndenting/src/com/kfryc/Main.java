package com.kfryc;

public class Main {

    public static void main(String[] args) {
        displayHighScorePosition("Goriath", calculateHighScorePosition(1500));
        displayHighScorePosition("Goriath", calculateHighScorePosition(900));
        displayHighScorePosition("Goriath", calculateHighScorePosition(400));
        displayHighScorePosition("Goriath", calculateHighScorePosition(50));

    }


    public static void displayHighScorePosition(String playerName, int position){
        System.out.println(playerName + " managed to get into position " + position + " on the high score table");

    }

    public static int calculateHighScorePosition(int score){
        int position = 4;       //assuming position 4 will be returned
        if (score>=1000)
            position = 1;
        else if (score >= 500)
            position = 2;
        else if (score >= 100)
            position = 3;

        return position;

    }

}
