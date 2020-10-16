package com.example.javademo;

public class BinarySeries {

    Thread zeroThread, oneThread;
    private Object object = new Object();
    private int maxlimit  =10;

    public BinarySeries() {
        createThread();
        zeroThread.start();
        oneThread.start();
    }

    public void createThread() {
        zeroThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int count =0;
                while (count!=maxlimit) {
                    synchronized (object) {
                        System.out.println(0);
                        count = count +1;
                        object.notify();
                    }
                }

            }
        });


        oneThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int count =0;
                while (count!=maxlimit) {
                synchronized (object) {
                    System.out.println(1);
                    count = count + 1;
                    object.notify();
                }
                }
            }
        });
    }
}
