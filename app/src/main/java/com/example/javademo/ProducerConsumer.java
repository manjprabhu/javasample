package com.example.javademo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

    private List<Integer> list = new ArrayList<>();
    private final String TAG =  ProducerConsumer.class.getSimpleName();

    private Thread pThread, cThread;
    private final Object object = new Object();
    private int count = 0, maxLimit = 20;

    public ProducerConsumer() {
        CreateThread();
        pThread.start();
        cThread.start();
    }

    private void CreateThread() {

        pThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.v(TAG, "run Producer:" + count);
                while (count != maxLimit) {
                    synchronized (object) {
                        while (list.size()>=1) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        count++;
                        list.add(count);
                        Log.v(TAG, "Producer produced the item :" + count);
                        object.notify();
                    }
                }
            }
        });

        cThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.v(TAG, "run Consumer" + count);
                while (count!= maxLimit) {
                    synchronized (object) {
                        while (list.isEmpty()) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        int i = list.remove(0);
                        object.notify();

                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Log.v(TAG, "Consumer consumed the item:" + i);
                    }
                }
            }
        });
    }
}
