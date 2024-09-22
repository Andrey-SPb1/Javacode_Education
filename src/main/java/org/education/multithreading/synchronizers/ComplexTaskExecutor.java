package org.education.multithreading.synchronizers;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ComplexTaskExecutor {

    private final CyclicBarrier barrier;

    public ComplexTaskExecutor(int amountOfTasks) {
        barrier = new CyclicBarrier(amountOfTasks, () -> System.out.println("Barrier open"));
    }

    public int executeTasks(int amountOfTasks) {
        ExecutorService executorService = Executors.newFixedThreadPool(amountOfTasks);
        List<Future<Integer>> futures = IntStream.range(0, amountOfTasks)
                .mapToObj(i -> executorService.submit(new ComplexTask(barrier)))
                .toList();

        executorService.shutdown();
        return calculatingResult(futures);
    }

    private int calculatingResult(List<Future<Integer>> futures) {
        int result = 0;

        for (Future<Integer> integerFuture : futures) {
            try {
                result += integerFuture.get();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
