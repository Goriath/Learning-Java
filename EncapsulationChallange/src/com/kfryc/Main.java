package com.kfryc;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Printer printer = new Printer(1,0,false);
        printer.print(4);

        System.out.println("Printer has printed "+ printer.getNumberOfPages()+ " pages in total and the toner level is " +
                printer.getTonerLevel());

        printer.fillUpToner(100);
        printer.print(10);

        System.out.println("Printer has printed "+ printer.getNumberOfPages()+ " pages in total and the toner level is " +
                printer.getTonerLevel());

    }
}
