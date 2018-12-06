package com.kfryc;

public class Burger {
    private String name;
    private String roll;
    private String meat;
    private double price;
    private boolean lettuce=false;
    private boolean tomato=false;
    private boolean carrot=false;
    private boolean bacon=false;
    private double additionalPrice=0.5;
    private double sum;


    public Burger(String name, String roll, String meat, double price) {
        this.name = name;
        this.roll = roll;
        this.meat = meat;
        this.price = price;
        this.sum = price;
    }

    public Burger() {
        this("Standard burger", "Wheat", "Patty", 2.99);
    }

    public void getTotal(){
        System.out.println(name+" price: "+getPrice());
        countAdditions();
        System.out.println("Total: "+getSum());
    }

    public void countAdditions(){
        if(isTomato()){
            addSum(getAdditionalPrice());
            System.out.println("Extra tomato: "+ getAdditionalPrice());
        }
        if(isLettuce()){
            addSum(getAdditionalPrice());
            System.out.println("Extra lettuce: "+ getAdditionalPrice());
        }
        if(isCarrot()){
            addSum(getAdditionalPrice());
            System.out.println("Extra carrot: "+ getAdditionalPrice());
        }
        if(isBacon()){
            addSum(getAdditionalPrice());
            System.out.println("Extra bacon: "+ getAdditionalPrice());
        }
    }

    public void addSum(double add){
        this.sum+=add;
    }

    public double getSum() {
        return sum;
    }

    public void setLettuce(boolean lettuce) {
        if(lettuce) {
            System.out.println("Added lettuce to burger");
            this.lettuce = lettuce;
        }
        else {
            System.out.println("Removed lettuce from burger");
            this.lettuce = lettuce;
        }
    }

    public void setTomato(boolean tomato) {
        if(tomato) {
            System.out.println("Added tomato to burger");
            this.tomato = tomato;
        }
        else {
            System.out.println("Removed tomato from burger");
            this.tomato = tomato;
        }
    }

    public void setCarrot(boolean carrot) {
        if(carrot) {
            System.out.println("Added carrot to burger");
            this.carrot = carrot;
        }
        else {
            System.out.println("Removed carrot from burger");
            this.carrot = carrot;
        }
    }

    public void setBacon(boolean bacon) {
        if(bacon) {
            System.out.println("Added bacon to burger");
            this.bacon = bacon;
        }
        else {
            System.out.println("Removed bacon from burger");
            this.bacon = bacon;
        }
    }

    public String getRoll() {
        return roll;
    }

    public String getMeat() {
        return meat;
    }

    public double getPrice() {
        return price;
    }

    public boolean isLettuce() {
        return lettuce;
    }

    public boolean isTomato() {
        return tomato;
    }

    public boolean isCarrot() {
        return carrot;
    }

    public boolean isBacon() {
        return bacon;
    }

    public double getAdditionalPrice() {
        return additionalPrice;
    }
}
