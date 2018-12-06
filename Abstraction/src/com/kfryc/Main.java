package com.kfryc;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Dog dog = new Dog("Yorkie");
        dog.breath();
        dog.eat();

        Bird bird = new Parrot("Parrot");
        bird.breath();
        bird.eat();
        bird.fly();


        Penguin penguin = new Penguin("Emperor");
        penguin.fly();

    }
}
