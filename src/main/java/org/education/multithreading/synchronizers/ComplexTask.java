package org.education.multithreading.synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class ComplexTask implements Callable<Integer> {

    private final CyclicBarrier barrier;

    public ComplexTask(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public Integer call() {
        int totalSum = 0;
        try {
            barrier.await();
            totalSum += new Task().execute();
            totalSum += new Task().execute();
            totalSum += new Task().execute();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        return totalSum;
    }
}
