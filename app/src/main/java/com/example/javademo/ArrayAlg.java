package com.example.javademo;

import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ArrayAlg {

    private final String TAG = ArrayAlg.class.getSimpleName();
    private int[] array = {1, 4, 6, 41, 4, 6, 89, 100, 9, 56};
    private int largest = array[0];
    private int smallest = array[0];

    public ArrayAlg() {
//        findLargert();
//        findSmallest();
//        secondlargest();
//        secondSmallest();
//        reversearray();
//        thirdLargest();
//        factorial(5);

//        findRecurringElementinArray();
//        findMissingNumber();
//        findsingleDuplicateNumber();

        countoccurence();
    }

    private void findLargert() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        Log.v(TAG, "Largest Number is :" + largest);
    }

    private void findSmallest() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        Log.v(TAG, "Smallest Number is :" + smallest);
    }

    private void secondlargest() {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            if (array[i] > largest && array[i] > secondLargest) {
                secondLargest = largest;
                largest = array[i];
            } else if (array[i] < largest && array[i] > secondLargest) {
                secondLargest = array[i];
            }
        }
        Log.v(TAG, "Second largest number is :" + secondLargest);
        Log.v(TAG, "Largest number is :" + largest);
    }

    private void secondSmallest() {

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest && array[i] < secondSmallest) {
                secondSmallest = smallest;
                smallest = array[i];
            } else if (array[i] < secondSmallest && array[i] > smallest) {
                secondSmallest = array[i];
            }
        }

        Log.v(TAG, "Second smallest number is :" + secondSmallest);
        Log.v(TAG, "smallest number is :" + smallest);
    }

    private void thirdLargest() {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {

            if (array[i] > largest && array[i] > secondLargest && array[i] > thirdLargest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = array[i];
            } else if (array[i] < largest && array[i] > secondLargest && array[i] > thirdLargest) {
                thirdLargest = secondLargest;
                secondLargest = array[i];
            } else if (array[i] < largest && array[i] < secondLargest && array[i] > thirdLargest) {
                thirdLargest = array[i];
            }
        }
        Log.v(TAG, "largest number is :" + largest);
        Log.v(TAG, "Second largest number is :" + secondLargest);
        Log.v(TAG, "third largest number is :" + thirdLargest);
    }

    private void reversearray() {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

        for (int i = 0; i < array.length; i++) {
            Log.v(TAG, "R array:" + array[i]);
        }
    }

    private void factorial(int number) {
        int fact = 1;

        for (int i = number; i > 0; i--) {
            fact = fact * i;
            Log.v(TAG, "Factorial1:" + fact + "i:" + i);
        }
        Log.v(TAG, "Factorial:" + fact);
    }

    private void findRecurringElementinArray() {

        Log.v("manju","findDuplicate:");

        int arr1[] = {1, 4,3,6,7,3,7,6};

        //using hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        int count =0;

        for(int i =0;i<arr1.length;i++) {

            if(map.get(arr1[i])!=null) {
                Log.v("manju","findDuplicate!=null:"+i);
                count = map.get(arr1[i]);
                map.put(arr1[i],count+1);
                count = 0;
            } else {
                Log.v("manju","findDuplicate==null:"+i);
                map.put(arr1[i],count+1);
                count = 0;
            }
        }
        Iterator iterator = map.entrySet().iterator();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            Log.v("manju","Key:"+key +" Value:"+value);
            if(value >1) {
//                    Log.v("manju","value:"+value);
                Log.v("manju","Duplicate Element:"+key);
            }
        }

        // end of using hashmap

    }

    private void findMissingNumber() {
        Log.v("manju","findMissingNumber");
        int arr1[] = {1,2,3,5,6,7,8,9,10};

        int sum = 0,sum1=0, n =10;


        for(int i =0;i<arr1.length;i++) {
            sum = sum + arr1[i];
        }
        sum1 = (n*(n+1)) /2;

        int missingnumber  =  sum1-sum;
        Log.v("manju","Missing number:"+missingnumber);
    }

    private void findcommonNumberfromarray() {
        int arr1[] = {1,2,3,5,6,7,8};
        int arr2[] = {2,4,9,10,23};

        for(int i =0;i<arr1.length;i++) {

            for(int j=0;j<arr2.length;j++) {
                if(arr1[i]==arr2[j]) {
                    Log.v(TAG,"");
                }
            }
        }
    }

    private void findsingleDuplicateNumber() {

        Log.v("manju","findsingleDuplicateNumber");

        int arr1[] = {1,2,2,5,6,7,8,9,10};

        int sum = 0,sum1=0, n =10;

        for(int i =0;i< arr1[i];i++) {
            sum  = sum + arr1[i];
        }

        Log.v("manju","sum:"+sum);

        sum1 = (n * (n+1)) /2 ;

        int duplicateNumber  =  sum1-sum;
        Log.v("manju","Missing number:"+duplicateNumber);
    }

    //Count the occurence of each element in array.
    //Create a hashmap with elements in array as Keys and number of occurence as Value.
    // Every time loop through the array, check if element in the array is already present
    //in Hashmap, if present get the count, increment it by one and put it back to hashmap.
    //if element is not present simply put the count as 1.

    private void countoccurence() {
        int[] array = {1,7,3,5,3,4,3,4,6,6,6,6};
        HashMap<Integer,Integer> countMap =  new HashMap<>();

        for (int i=0;i<array.length;i++) {
            int count  = 1;
            if(countMap.containsKey(array[i])) {
                count = countMap.get(array[i]);
                count = count + 1;
                countMap.put(array[i],count);
            } else {
                countMap.put(array[i],count);
            }
        }

        for(Map.Entry<Integer,Integer> entry : countMap.entrySet()) {
            Log.v(TAG,"Key:"+entry.getKey()+"Value:"+entry.getValue());
        }
    }

    private void countOccurenceofWord() {
        String[] words = {"hi","hi"};
    }



}
