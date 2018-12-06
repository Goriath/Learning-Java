package com.kfryc;

public class Printer {
    private int tonerLevel=100;
    private int numberOfPages;
    private boolean duplex;


    public Printer(int tonerLevel, int numberOfPages, boolean duplex) {
        if(tonerLevel > 0 && tonerLevel<=100){
            this.tonerLevel = tonerLevel;
        }

        this.numberOfPages = numberOfPages;
        this.duplex = duplex;
    }

    public void fillUpToner(int toner){
        if(toner > 0 && toner<=100){
            this.tonerLevel = toner;
        } else if (toner>100){
            this.tonerLevel = 100;
        } else this.tonerLevel=0;
    }

    public void print(int numberOfPages){
        for(int i=1;i<=numberOfPages;i++){
            if(this.tonerLevel<=0){
                System.out.println("No more toner to print");
                break;
            }
            else {
                System.out.println("Printed page #"+i);
                this.numberOfPages++;
                this.tonerLevel= this.tonerLevel-1;
            }
        }
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public boolean isDuplex() {
        return duplex;
    }
}
