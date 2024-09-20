package org.education.multithreading.blockingqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        BlockingQueue queue = new BlockingQueue();

        for (int i = 0; i < 100; i++) {
            service.execute(new Consumer(queue));
            service.execute(new Producer(queue));
        }

        service.shutdown();
    }
}
