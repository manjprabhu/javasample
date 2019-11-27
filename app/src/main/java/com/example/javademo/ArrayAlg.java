package com.example.javademo;

import android.util.Log;

public class ArrayAlg {

    private final String TAG = ArrayAlg.class.getSimpleName();
    private int[] array = {1, 4, 6, 41, 4, 6, 89, 100, 9, 56};
    private int largest = array[0];
    private int smallest = array[0];

    public ArrayAlg() {
        findLargert();
        findSmallest();
        secondlargest();
        secondSmallest();
        reversearray();
        thirdLargest();
        factorial(5);
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

}
