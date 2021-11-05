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
        public Producer( BlockingQueue<Integer> obj) {
            this.obj = obj;
        }

        private void produce() {
            for(int i=0;i<10;i++) {
                try {
                    obj.put(i);
                    Log.v(TAG,"Produced the data:"+i);
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

        public Consumer(BlockingQueue<Integer> obj) {
            this.obj = obj;
        }

        int taken = -1;
        private void consume() {
            while (true) {
                try {
                    taken =  obj.take();
                    Log.v(TAG,"Consumed the data:"+taken);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */


        @Override
        public void run() {
            consume();
        }
    }
}
