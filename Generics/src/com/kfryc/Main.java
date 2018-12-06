package com.kfryc;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
	// write your code here

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
//        adelaideCrows.addPlayer(pat);
//        adelaideCrows.addPlayer(beckham);

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> soccerTeam = new Team<>("FC Barcelona");
        soccerTeam.addPlayer(beckham);

        System.out.println(adelaideCrows.numPlayers());


        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn= new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle= new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);

        adelaideCrows.matchResult(fremantle, 2, 1);
//        adelaideCrows.matchResult(baseballTeam, 1, 1);

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": "+ adelaideCrows.ranking());
        System.out.println(melbourne.getName() + ": "+ melbourne.ranking());
        System.out.println(fremantle.getName() + ": "+ fremantle.ranking());
        System.out.println(hawthorn.getName() + ": "+ hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo(fremantle));


        ArrayList<Team> teams;
        Collections.sort(teams);







//        ArrayList<Integer> items = new ArrayList<>();
//        items.add(1);
//        items.add(2);
//        items.add(3);
//        items.add("tim");
//        items.add(4);
//        items.add(5);
//
//
//        printDoubled(items);

    }


//    private static void printDoubled(ArrayList<Integer> n){
//        for(int i : n){
//            System.out.println(i*2);
//        }
//    }

}
