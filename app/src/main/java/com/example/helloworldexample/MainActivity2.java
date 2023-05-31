package com.example.helloworldexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private static final int NUM_PHILOSOPHERS = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void buttonClicked(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void startPhilosophers(View view) {
        List<Chopstick> chopsticks = new ArrayList<>();
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            chopsticks.add(new Chopstick());
        }

        List<Philosopher> philosophers = new ArrayList<>();
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Chopstick left = chopsticks.get(i);
            Chopstick right = chopsticks.get((i + 1) % NUM_PHILOSOPHERS);
            philosophers.add(new Philosopher(i, left, right));
        }

        for (Philosopher p : philosophers) {
            p.start();
        }
    }
}