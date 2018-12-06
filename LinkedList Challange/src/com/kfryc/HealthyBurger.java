package com.kfryc;

public class HealthyBurger extends Burger{
    private boolean avocado=false;
    private boolean beans=false;

    public HealthyBurger(String meat) {
        super("Healthy Burger", "Brown rye bread", meat, 3.99);
    }

    @Override
    public void countAdditions() {
        if(isAvocado()){
            System.out.println("Extra avocado: "+ getAdditionalPrice());
            addSum(getAdditionalPrice());
        }
        if(isBeans()){
            System.out.println("Extra beans: "+ getAdditionalPrice());
            addSum(getAdditionalPrice());
        }
        super.countAdditions();

    }

    public void setAvocado(boolean avocado) {
        if(avocado) {
            System.out.println("Added avocado to burger");
            this.avocado = avocado;
        }
        else {
            System.out.println("Removed avocado from burger");
            this.avocado = avocado;
        }
    }

    public void setBeans(boolean beans) {
        if(beans) {
            System.out.println("Added beans to burger");
            this.beans = beans;
        }
        else {
            System.out.println("Removed beans from burger");
            this.beans = beans;
        }
    }

    public boolean isAvocado() {
        return avocado;
    }

    public boolean isBeans() {
        return beans;
    }
}
