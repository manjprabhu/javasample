package com.example.javademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

//DeadLock example
public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    Thread thread1, thread2;

    private Object object1 = new Object();
    private Object object2 = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ProducerConsumer producerConsumer = new ProducerConsumer();
//        OddEven oddEven = new OddEven();
        ArrayAlg largetNumber = new ArrayAlg();
//        CreateThread();
//        thread1.start();
//        thread2.start();
    }


    private  void methodOne(){
        synchronized (object1) {
            Log.v(TAG, "thread1 is holding lock 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.v(TAG,"thread1 is waiting for lock 2 ");
            synchronized (object2) {
                Log.v(TAG,"thread1 is holding lock 1 & 2");
            }
        }
    }

    private  void methodTwo(){
        synchronized (object2) {
            Log.v(TAG, "thread2 is holding lock 2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Log.v(TAG,"thread2 is waiting for lock 1 ");
            synchronized (object1) {
                Log.v(TAG,"thread2 is holding lock 1 & 2");
            }
        }
    }

    private void CreateThread() {
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                methodOne();
            }
        });
        thread2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                methodTwo();
            }
        });
    }
}
