package com.example.javademo;

import android.util.Log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadSync {

    private final String TAG = ThreadSync.class.getSimpleName();

    void DriverCode() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }

    class Producer implements Runnable {

        BlockingQueue<Integer> obj;

        public Producer(BlockingQueue<Integer> obj) {
            this.obj = obj;
        }

        private void produce() {
            for ( int i = 0; i < 10; i++ ) {
                try {
                    obj.put(i);
                    Log.v(TAG, "Produced the data:" + i);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            produce();
        }
    }

    class Consumer implements Runnable {

        BlockingQueue<Integer> obj;
        int taken = -1;

        public Consumer(BlockingQueue<Integer> obj) {
            this.obj = obj;
        }

        private void consume() {
            while (true) {
                try {
                    taken = obj.take();
                    Log.v(TAG, "Consumed the data:" + taken);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        public void run() {
            consume();
        }
    }
}
