package com.example.helloworldexample;

import android.util.Log;

import java.util.Random;

public class Philosopher extends Thread {
    int id;
    private final Chopstick leftChopstick, rightChopstick;
    private final Random random;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        leftChopstick = left;
        rightChopstick = right;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                synchronized (leftChopstick) {
                    synchronized (rightChopstick) {
                        eat();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think() throws InterruptedException {
        Log.d("Philosopher", "Philosopher " + id + " is thinking...");
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        Log.d("Philosopher", "Philosopher " + id + " is eating...");
        Thread.sleep(random.nextInt(1000));
    }
}
