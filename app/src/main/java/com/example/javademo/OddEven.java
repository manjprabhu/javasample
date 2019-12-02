package com.example.javademo;

import android.util.Log;

public class OddEven {

    private final String TAG  = OddEven.class.getSimpleName();
    Thread oThread, eThread;
    private int count =1, maxLimit = 100;
    private Object object = new Object();

    public OddEven() {
        CreateThread();
        oThread.start();
        eThread.start();
    }

    private void CreateThread() {
        Log.v(TAG,"CreateThread");
        oThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count != maxLimit) {
//                    synchronized (object) {

                        if (count%2 == 0) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.v(TAG,"Odd thread and Odd Number:"+count);
                        count = count + 1;
                        object.notify();

                        /*if(count%2 == 0) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Log.v(TAG,"Odd thread and Odd Number:"+count);
                            count = count + 1;
                            object.notify();
                        }*/
                    }
                }
//            }
        });

        eThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count != maxLimit) {
                    synchronized (object) {
                        if (count%2 !=0) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.v(TAG," Even thread and Even Number:"+count);
                        count = count +1;
                        object.notify();
                            /*if(count%2 !=0) {
                                try {
                                    object.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            } else {
                                Log.v(TAG," Even thread and Even Number:"+count);
                                count = count +1;
                                object.notify();
                            }*/
                        }

                }

            }
        });
    }
}
