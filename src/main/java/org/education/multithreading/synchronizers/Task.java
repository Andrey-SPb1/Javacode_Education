package org.education.multithreading.synchronizers;

public class Task {

    public int execute() throws InterruptedException {
        int sum = 0;
        for (int i = 0; i < 100_000; i++) {
            sum += (int) (Math.random() * 100);
        }
        Thread.sleep(1500);
        return sum;
    }

}
