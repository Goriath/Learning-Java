package com.kfryc;

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static ReentrantLock lock = new ReentrantLock(true);    //if true then it is a fair lock First come First served

    public static void main(String[] args) {
	    Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
	    Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
	    Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
	    Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
	    Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");


	    // The higher number the higher priority, but is just a suggestion that the operating system will use.
	    t1.setPriority(10);
	    t2.setPriority(8);
	    t3.setPriority(6);
	    t4.setPriority(4);
	    t5.setPriority(2);

	    t3.start();
	    t2.start();
	    t5.start();
	    t4.start();
	    t1.start();
    }

    private static class Worker implements Runnable{
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i=0;i<100;i++){
                lock.lock();
                try{
                    System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
                    // execute critical section of code
                } finally {
                    lock.unlock();
                }
            }
        }
    }


}
