package com.example.javademo;

import android.util.Log;

import java.util.LinkedList;

public class PC {

    private final String TAG = PC.class.getSimpleName();

    Object object = new Object();
    int capacity = 1;
    LinkedList<Integer> list = new LinkedList<>();
    Thread producer = new Thread(new Runnable() {
        @Override
        public void run() {
            produce();
        }
    });
    Thread consumer = new Thread(new Runnable() {
        @Override
        public void run() {
            consume();
        }
    });

    public PC() {
        producer.start();
        consumer.start();
    }

    private void produce() {

        int value = 0;

        while (true) {
            synchronized (object) {
                while (list.size() == capacity) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int x = value++;
                list.add(x);
                Log.v(TAG, "Producer produced the value:" + x);
                object.notify();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }

            }
        }

    }


    private void consume() {

        while (true) {
            synchronized (object) {
                while (list.isEmpty() == true) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int x = list.removeFirst();
                Log.v(TAG, "Consumer consumed the value:" + x);
                object.notify();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
