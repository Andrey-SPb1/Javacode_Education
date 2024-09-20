package org.education.multithreading.blockingqueue;

import java.util.concurrent.atomic.AtomicInteger;

class Producer implements Runnable {
    private final static AtomicInteger NUM = new AtomicInteger(0);
    private final BlockingQueue blockingQueue;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Element element = new Element(NUM.incrementAndGet());
            blockingQueue.enqueue(element);
        }
    }
}
