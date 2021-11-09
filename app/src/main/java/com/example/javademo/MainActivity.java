package com.example.javademo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

//DeadLock example
public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ProducerConsumer producerConsumer = new ProducerConsumer();
    }

}
