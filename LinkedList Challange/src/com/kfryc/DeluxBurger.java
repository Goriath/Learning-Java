package com.kfryc;

public class DeluxBurger extends Burger{
    private boolean fries=true;
    private boolean drink=true;


    public DeluxBurger() {
        super("Delux Burger", "Wheat", "Patty", 3.99);
    }


    @Override
    public void setLettuce(boolean lettuce) {
        System.out.println("Cannot add lettuce to Delux Burger.");
    }

    @Override
    public void setTomato(boolean tomato) {
        System.out.println("Cannot add tomato to Delux Burger.");
    }

    @Override
    public void setCarrot(boolean carrot) {
        System.out.println("Cannot add carrot to Delux Burger.");
    }

    @Override
    public void setBacon(boolean bacon) {
        System.out.println("Cannot add bacon to Delux Burger.");
    }

    @Override
    public void getTotal() {
        System.out.println("Extra fries");
        System.out.println("Extra drink");
        super.getTotal();
//        System.out.println("Total: "+ getPrice());
    }
}
