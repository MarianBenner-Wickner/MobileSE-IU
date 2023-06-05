package com.example.helloworldexample;
import android.util.Log;

public class Philosopher extends Thread {
    private final Object leftFork;
    private final Object rightFork;
    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }
    private void doAction(String action) throws InterruptedException {
        Log.i("Philosopher", this.getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }
    @Override
    public void run() {
        try {
            while (true) {
                doAction(" Thinking");
                synchronized (leftFork) {
                    doAction(" Picked up left fork");
                    synchronized (rightFork) {
                        doAction(" Picked up right fork - eating");
                        doAction(" Put down right fork");
                    }
                    doAction(" Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
