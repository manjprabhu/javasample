package com.example.javademo;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;

public class CollectionTest {

    public CollectionTest() {
        failfastDemo();
    }

    private void failfastDemo() {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(10);
        list.add(4);
        list.add(7);
        list.add(9);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            Log.v("===","Element:"+iterator.next());
//            list.add(11);// This line will thorw ConcurrentModification exception
        }

    }


    private void findsmallest() {
        int[] a = {21,32,54,65,12,23,34,45};

        int smallest = Integer.MAX_VALUE;

        for(int i =0;i<a.length;i++) {
            if(a[i] < smallest)
                smallest = a[i];
        }

        Log.v("===>>","Smallest:"+smallest);
    }

    private void findlargest() {
        int a[] = {21,32,54,65,12,23,34,45};

        int largest = Integer.MIN_VALUE;

        for(int i =0;i<a.length;i++) {
            if(a[i] > largest)
                largest = a[i];
        }

        Log.v("===>>","largest:"+largest);
    }

    private void reverseArray() {
        int a[] = {21,32,54,65,12,23,34,45};

        for(int i=0;i<a.length/2;i++) {
            int temp = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = temp;
        }

        for(int i=0;i<a.length;i++) {
            Log.v("===>>","array:"+a[i]);
        }
    }

    private void isPrime() {
        int n =5;
        boolean isprime = false;

        for(int i=2;i<=n/2;i++) {
            if(n%i ==0) {
                isprime = false;
                break;
            } else {
                isprime = true;
            }
        }

        if(isprime) {
            Log.v("===>>",n+" isPrime:");
        } else {
            Log.v("===>>",n+" is not Prime:");
        }
    }

    private void fibonacci() {
        int n =6;
        int s1=0,s2=1,sum;

        for(int i=1;i<=n;i++) {
            Log.v("===>>","Number:"+s1);
            sum = s1+s2;
            s1 = s2;
            s2 = sum;

        }
    }

    private void factorialNumber() {
        int n =5;

        int fact =1;

        for(int i=1;i<=n;i++) {
            fact = fact * i;
        }

        Log.v("===>>","Factorial:"+fact);
    }

    private void countTheoccurence() {

        int a [] =  {21,32,54,65,12,12,45,45};

        HashMap<Integer,Integer> hashmap = new HashMap<>();

        for(int i =0;i< a.length;i++) {
            int count = 1;
            if(hashmap.containsKey(a[i])) {
                count = hashmap.get(a[i]);
                count = count +1;
                hashmap.put(a[i],count);
            } else {
                hashmap.put(a[i],count);
            }
        }
        for(HashMap.Entry<Integer,Integer> entry : hashmap.entrySet()) {
            Log.v("===>>","Key:"+entry.getKey() + " Values:"+ entry.getValue());
        }
    }


    private void findMissingNUmber() {
        int [] a = {1,2,3,4,5,7,8,9};

        int sum =0,sum1 =0;

        for(int i = 0;i<a.length;i++) {
            sum = sum + a[i];
        }

        sum1 = a[a.length-1] *(a[a.length-1] +1 )/2;

        Log.v("===>>","Missing Number:"+(sum1-sum));
    }

    private void findsecondlargest() {
        int a [] =  {21,32,154,65,12,12,45,45};

        int largest = Integer.MIN_VALUE, secondlargest = Integer.MIN_VALUE;

        for(int i =0;i<a.length;i++) {
            if(a[i] >largest  && a[i] > secondlargest) {
                secondlargest = largest;
                largest = a[i];
            } else if(a[i] < largest && a[i] > secondlargest) {
                secondlargest = a[i];
            }
        }

        Log.v("===","Largest:"+largest + " SecondLargest:"+secondlargest);

    }


    private  void findsecondSmallest() {

        int a [] =  {21,32,-154,-65,12,12,45,45};
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

        for(int i =0;i< a.length;i++) {
            if(a[i] < smallest && a[i] < secondSmallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if(a[i] > smallest && a[i] < secondSmallest) {
                secondSmallest = a[i];
            }
        }

        Log.v("===","smallest:"+smallest+ " Second smallest:"+secondSmallest);

    }


    private void thirdsmallest() {
        int a [] =  {21,32,54,65,12,12,45,45};
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE,thirdSmallest = Integer.MAX_VALUE;

        for(int i=0;i<a.length;i++) {

            if(a[i] <smallest && a[i] < secondSmallest && a[i] < thirdSmallest) {
                thirdSmallest = secondSmallest;
                secondSmallest = smallest;
                smallest = a[i];
            } else if(a[i] > smallest && a[i] < secondSmallest && a[i] < thirdSmallest) {
                thirdSmallest = secondSmallest;
                secondSmallest = a[i];
            } else if(a[i] > smallest && a[i] > secondSmallest && a[i] < thirdSmallest) {
                thirdSmallest = a[i];
            }
        }

        Log.v("===","Smallest:"+smallest + "  SecondSmallest:"+secondSmallest +" ThirdSmallest: "+thirdSmallest);
    }


    private void thirdLargest() {
        int a [] =  {21,32,54,65,12,12,45,145};

        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE, thirdLargest = Integer.MIN_VALUE;

        for(int i =0;i<a.length;i++) {

            if(a[i] >largest && a[i] > secondLargest && a[i] > thirdLargest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = a[i];
            } else if(a[i] <largest && a[i] > secondLargest && a[i] > thirdLargest) {
                thirdLargest = secondLargest;
                secondLargest = a[i];
            } else if(a[i] < largest && a[i] < secondLargest && a[i] > thirdLargest) {
                thirdLargest = a[i];
            }
        }

        Log.v("===","largest:"+largest + "  secondLargest:"+secondLargest +" thirdLargest: "+thirdLargest);
    }

    private void printallPrime() {

        int l = 1, n =100;

        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        for(int i=l;i<=n;i++) {
            if(isPrime(i)) {
                list.add(i);
            }
        }

        ListIterator<Integer> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            Log.v("===",listIterator.next()+" is Prime number");
        }

    }

    private boolean isPrime(int n) {
        boolean isprime = false;
        for(int i=2;i<=n/2;i++) {
            if(n%i == 0) {
                isprime = false;
                break;
            } else {
                isprime = true;
            }
        }
        return isprime;
    }
 }
