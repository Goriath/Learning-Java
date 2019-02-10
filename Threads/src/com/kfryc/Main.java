package com.kfryc;

import static com.kfryc.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");  // Will not show thread name when we will use anotherThread.run() in main!
        anotherThread.start();

        new Thread(){
            public void run(){
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

//        Thread myRunnableThread = new Thread(new MyRunnable());
        Thread myRunnableThread = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED + "AnotherThread terminated or timed out, so I'm running again");
                } catch (InterruptedException e){
                    System.out.println(ANSI_RED + " I couldn't wait after all. I was interrupted");
                }
            }
        });
        myRunnableThread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread"); // We might see the second line before anotherThread.
                                                                // JVM decides if anotherThread will be before second line

        //  anotherThread.start(); // We cannot start again. We need to instance different AnotherThread

    }
}
