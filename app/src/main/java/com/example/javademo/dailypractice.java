package com.example.javademo;

import android.util.Log;

import java.util.HashMap;

public class dailypractice {

    public dailypractice() {
        bubblesort();
    }

    private void bubblesort() {

        int a[] = {10,11,54,54,76,65,65};

        for(int x =0;x<a.length;x++) {

            for(int y = 0;y< a.length-x-1;y++) {

                if(a[y] > a[y+1]) {
                    int temp = a[y];
                    a[y] = a[y+1];
                    a[y+1] = temp;
                }
            }
        }

        for(int B : a) {
            Log.v("===","m:"+B);
        }
    }

    private void selectionsort() {
    }

    private void smallest() {
    }

    private void secondlargest() {

    }

    private void countoccurence() {

        int[] array = {10,11,54,54,76,65,65};
        int count  =0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i =0;i<array.length;i++) {

            if(hashMap.containsKey(array[i])) {
                count = hashMap.get(array[i]);
                count = count +1;
                hashMap.put(array[i],count);
            } else {
                hashMap.put(array[i],1);
            }
        }

        for(HashMap.Entry<Integer,Integer> entry : hashMap.entrySet()) {
            Log.v("===","Variable:"+entry.getKey() + "  Occurence:"+entry.getValue());
        }

    }

    private void fibonacci() {
        int n =5;//0,1,1,2,3

        int s1 = 0, s2 =1, sum =1;

        for(int i=0;i<n;i++) {
            Log.v("===","S1:"+s1);
            sum = s1 +s2;
            s1 = s2;
            s2 = sum;
        }


    }

    private void isPrime() {
        int n = 91;
        boolean isprime = false;
        for(int x =2;x<=n/2;x++) {
            if(n%x ==0) {
                isprime = false;
                break;
            } else {
                isprime = true;
            }
        }

        if(isprime)
        Log.v("===",n+ " is prime");
        else
            Log.v("===",n+ " is notprime");

    }

    private void reverseNumber() {

        int number = 123, reverse =0;

        while(number !=0) {

            int r = number %10;

            reverse = (reverse *10) + r;

            number = number/10;
        }

        Log.v("===","Reverse:"+reverse);


    }


}
