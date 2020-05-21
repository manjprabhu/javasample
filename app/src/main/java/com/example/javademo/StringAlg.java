package com.example.javademo;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class StringAlg {

    private final String TAG =  StringAlg.class.getSimpleName();

    public StringAlg() {
        CounttheOccurenceofeachChar();
        reverseString();
    }

    private void CounttheOccurenceofeachChar() {
        String s = "java";
        char[] c = s.toCharArray();
        int count  =1;

        HashMap<Character,Integer> charMap = new HashMap<>();

        Log.v(TAG,"Length:"+c.length);

        for(int i = 0;i<c.length;i++) {
            if(charMap.containsKey(c[i])) {
                count = charMap.get(c[i]);
                count = count + 1;
                charMap.put(c[i],count);
            } else {
                charMap.put(c[i],count);
            }
        }
        for (Map.Entry<Character,Integer> entry : charMap.entrySet()) {
            Log.v(TAG,"Key:"+entry.getKey()+ "   Value:"+entry.getValue());
        }
    }


    private void reverseString() {
        String s = "java";

        char[] c = s.toCharArray();
        char[] reverse = new char[s.length()];

        for(int i=0;i<c.length/2;i++) {
            char x = c[i];
            c[i] = c[c.length-i-1];
            c[c.length-i-1] = x;
        }
        Log.v(TAG,"reverse:"+ String.valueOf(c));
    }



}
