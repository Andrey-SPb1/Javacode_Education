package org.education.multithreading.blockingqueue;

class Consumer implements Runnable {

    private final BlockingQueue blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            Element element = blockingQueue.dequeue();
            String name = Thread.currentThread().getName();
            System.out.println(name + " взял элемент №" + element.number());
        }
    }
}
