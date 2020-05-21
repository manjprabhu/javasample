package com.example.javademo;

public class BinarySeries {

    Thread zeroThread, oneThread;

    public BinarySeries() {
        createThread();
        zeroThread.start();
        oneThread.start();
    }

    public void createThread() {
        zeroThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });


        oneThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
