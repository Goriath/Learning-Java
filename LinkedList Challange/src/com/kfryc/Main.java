package com.kfryc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HealthyBurger healthyBurger = new HealthyBurger("Vegge");
        healthyBurger.setLettuce(true);
        healthyBurger.setAvocado(true);
        healthyBurger.getTotal();
        System.out.println("\n");

        Burger burger = new Burger();
        burger.setCarrot(true);
        burger.getTotal();

        System.out.println("\n");

        DeluxBurger deluxBurger = new DeluxBurger();
        deluxBurger.setLettuce(true);
        deluxBurger.getTotal();
    }
}
