package com.kfryc;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        player.name = "Krzysiek";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = "+ player.healthRemaining());

        damage = 11;
        player.health=100;      //it is a bad idea to make changes like that.
        player.loseHealth(damage);
        System.out.println("Remaining health = "+ player.healthRemaining());

        System.out.println();

        EnhancedPlayer player1 = new EnhancedPlayer("Goriath", 50, "Sword");
        System.out.println("Initial health is "+ player1.getHealth() );

        player1.loseHealth(20);
        System.out.println("Remaining health = "+ player1.getHealth());

    }
}
