package com.kfryc;

public class Main {


    // Deadlock will occur as the order is not correct (it is written for training purpose)
    public static void main(String[] args) {
        final PolitePerson anna = new PolitePerson("Anna");
        final PolitePerson chris = new PolitePerson("Chris");


        new Thread(new Runnable() {
            @Override
            public void run() {
                anna.sayHello(chris);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                chris.sayHello(anna);
            }
        }).start();



    }

    static class PolitePerson{
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void sayHello(PolitePerson person){
            // %s the String (first one will refer to this.name, second to person.getName()), %n is new line
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloback(this);
        }

        public synchronized void sayHelloback(PolitePerson person){
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}
