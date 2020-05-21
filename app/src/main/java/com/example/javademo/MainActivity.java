package com.example.javademo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

//DeadLock example
public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    private Thread thread1, thread2;

    private Object object1 = new Object();
    private Object object2 = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DeadLock deadLock = new DeadLock();
//        ProducerConsumer producerConsumer = new ProducerConsumer();
//        OddEven oddEven = new OddEven();
//        ArrayAlg largestNumber = new ArrayAlg();
        StringAlg stringAlg = new StringAlg();
//        CreateThread();
//        thread1.start();
//        thread2.start();

//        findsmallest();
//        findLargest();
//        factorial();
//        secondLargest();
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


    private void findsmallest() {
        int[] array = {1, 4, 6, 41, 4, 6, 89, 100, 9, 56};

        int smallest = Integer.MAX_VALUE;

        for(int i =0;i<array.length;i++) {
            if(array[i] < smallest) {
                smallest = array[i];
            }
        }
        Log.v(TAG,"smallest:"+smallest);
    }

    private void findLargest() {
        int[] array = {1, 4, 6, 410, 4, 6, 89, 10, 9, 56};

        int largest = Integer.MIN_VALUE;

        for(int i=0;i<array.length;i++) {
            if(array[i] > largest) {
                largest = array[i];
            }
        }
        Log.v(TAG,"largest:"+largest);
    }

    private void factorial() {
        int n =6;
        int fact = 1;
        for(int i= n;i>0;i--) {
            fact = fact * i;
        }
        Log.v(TAG,"fact:"+fact);
    }

    private void secondLargest() {
        int[] array = {10,4,7,2,99,23,41,-61,11};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for( int i=0;i<array.length;i++) {
            if(array[i] > largest && array[i] > secondLargest) {
                secondLargest = largest;
                largest = array[i];
            } else if( array[i] < largest && array[i] > secondLargest) {
                secondLargest = array[i];
            }
        }

        Log.v(TAG,"==>> Largest:"+largest);
        Log.v(TAG,"==>> SecondLargest:"+secondLargest);
    }


}
