package com.example.javademo;

import android.util.Log;

public class OE {

    private final String TAG = OE.class.getSimpleName();
    private Object object = new Object();
    private int value = 1;
    private int limit  = 100;

    public OE() {
       oddThread.start();
       evenThread.start();
    }

    Thread oddThread = new Thread(new Runnable() {
        @Override
        public void run() {
            printOdd();
        }
    });

    Thread evenThread = new Thread(new Runnable() {
        @Override
        public void run() {
            printEven();
        }
    });

    private void printOdd() {

        while(value <limit) {
            synchronized (object) {
                while (value%2 == 0) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Log.v(TAG,"Odd Thread:"+value);
                value++;
                object.notify();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void printEven() {
        while (value <limit) {
            synchronized (object) {
                while (value%2 !=0) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Log.v(TAG,"Even Thread:"+value);
                value++;
                object.notify();
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
