package com.example.javademo;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class Practice {

    public Practice() {
        countoccrenceofnumber();
    }

    private void countoccrenceofnumber() {

        int[] a = {10, 21,21, 54, 65, -21, 43,43};

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i=0;i<a.length;i++) {

            int count =1;

            if(hashMap.containsKey(a[i])) {
                count = hashMap.get(a[i]);
                count = count +1;

                hashMap.put(a[i],count);

            } else {
                hashMap.put(a[i],count);
            }
        }

        for(Map.Entry<Integer,Integer> entry: hashMap.entrySet()) {
            Log.v("===","Key:"+entry.getKey() + "  Occurence:"+ entry.getValue());
        }

    }

    private void findkthlargest(int k) {

        int[] a = {10, 21, 54, 65, -21, 43};

        //use selection sort to sort the array

        int n = a.length;

        for(int i =0;i<=n;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        for(int x : a) {
            Log.v("===",""+x);
        }

        // find the (k-1) element;

            Log.v("===",k+"th smallest element"+ a[k-1]);
    }

    private void secondSmallest() {
        int[] a = {10, 21, 54, 65, -21, 43};

        int n  = a.length;

        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {

            if(a[i] < smallest && a[i] < secondSmallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if(a[i] > smallest && a[i] < secondSmallest) {
                secondSmallest = a[i];
            }
        }

        Log.v("===","SecondSmallest:"+secondSmallest+ " Smallest:"+smallest);
    }

    private void  secondlargest() {
        int[] a = {100, 21, 54, 65, -21, 43};

        int n  = a.length;

        int largest = Integer.MIN_VALUE, secondlargest = Integer.MIN_VALUE;

        for(int i =0;i<n;i++) {

            if(a[i] > largest && a[i] > secondlargest) {
                secondlargest = largest;
                largest = a[i];
            } else if(a[i] < largest && a[i] > secondlargest) {
                secondlargest = a[i];
            }
        }

        Log.v("===","secondlargest:"+secondlargest+ " largest:"+largest);
    }

    private void swapwithout() {
        int x = 10, y =20;

        int z = x+y;
        y = z-y;
        x = z-y;
        Log.v("===","x:"+x + " Y:"+y);
    }

    private void selectionsort() {
        int[] a = {100, 21, 54, 65, -21, 43};

        int min, n = a.length;

        for (int i = 0; i < n; i++) {
            min = i;

            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;

                    int temp = a[i];
                    a[i] = a[min];
                    a[min] = temp;

                }
            }
        }

        for (int x : a) {
            Log.v("===", "" + x);
        }
    }

    private void bubblesort() {
        int[] a = {10, 21, 54, 65, -21, 43};

        int  n =a.length;

        for(int i=0;i<n;i++) {

            for (int j =0;j<n-i-1;j++) {

                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        for(int x : a) {
            Log.v("===",""+x);
        }
    }

    private void smallest() {
        int a[] = {10,21,54,65,21,-43};

        int smallest = Integer.MAX_VALUE;

        for(int i=0;i<a.length;i++) {
            if(a[i] < smallest) {
                smallest = a[i];
            }
        }
        Log.v("===","Smallest:"+smallest);
    }

    private void largest() {
        int a[] = {10,21,54,65,-21,43};

        int largest = Integer.MIN_VALUE;

        for(int i=0;i<a.length;i++) {
            if(a[i] > largest) {
                largest = a[i];
            }
        }
        Log.v("===","Largest:"+largest);
    }

    private void fibonacci() {
        int n = 11;

        int s1 = 0, s2 = 1, sum = 0;

        for (int i = 1; i < n; i++) {
            Log.v("===", "" + s1);

            sum = s1 + s2;
            s1 = s2;
            s2 = sum;
        }
    }

    private void isPrime() {

        int n = 37;
        boolean flag = false;

        for (int i = 2; i < n / 2; i++) {

            if (n % i == 0) {
                flag = false;
                break;
            } else {
                flag = true;
            }
        }
        if (flag)
            Log.v("===", n + " is Prime");
        else
            Log.v("===", n + " is not Prime");
    }

    private void reversenumber() {
        int number = 2347324, reverse = 0;

        while (number != 0) {
            int r = number % 10;

            reverse = reverse * 10 + r;

            number = number / 10;
        }
        Log.v("===", "Reverse Number:" + reverse);
    }

    private void factorial() {
        int n = 5, fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        Log.v("===", "Factorial of" + n + " is:" + fact);
    }
}
