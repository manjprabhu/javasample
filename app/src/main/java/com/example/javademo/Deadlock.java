package com.example.javademo;

import android.util.Log;

public class Deadlock {

    private final String TAG = Deadlock.class.getSimpleName();
    private Object object = new Object();
    private Object object1 = new Object();
    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            function1();
        }
    });
    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            function2();

        }
    });
    public Deadlock() {
        thread1.start();
        thread2.start();
    }

    private void function1() {
        synchronized (object) {
            Log.v(TAG, "Thread 1 object :");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            function2();
//            synchronized (object) {
//                Log.v(TAG, "Thread 1 object1 :");
//            }
        }
    }

    private void function2() {
        synchronized (object1) {
            Log.v(TAG, "Thread 2 object :");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            function1();
//            synchronized (object1) {
//                Log.v(TAG, "Thread 2 object1 :");
//            }
        }

    }


}
