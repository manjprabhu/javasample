package com.example.javademo;

import android.util.Log;


public class dailypractice {

    private int maxLimit = 100, i=1;

    public dailypractice() {
    }

    private void fibonacci() {
        int n =5, s1 =0, s2 =1,sum =0;

        for(int i=1;i<=n;i++) {
            Log.v("===",""+s1);

            sum = s1+s2;

            s1 = s2;
            s2 = sum;
        }
    }

    private void bubblesort() {

        int a[] = {10,21,43,11,65,34,22};

        for(int i=0;i<a.length;i++) {

            for(int j=0;j<a.length-i-1;j++) {

                if(a[j] > a[j+1]) {

                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        for(int x : a) {
            Log.v("===","x:"+x);
        }
    }

    private void selectionsort() {
        int a[] = {11,32,54,76,21,32,20};

        for(int i =0;i<a.length;i++) {
            int min =i;

            for(int j =i;j<a.length;j++) {

                if(a[j] < a[min]) {

                    min =j;

                    int temp = a[i];
                    a[i] = a[min];
                    a[min] = temp;
                }
            }
        }
        for(int x : a) {
            Log.v("===","x:"+x);
        }
    }
}
