package org.education.multithreading.blockingqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class BlockingQueue {

    private final Queue<Element> elements;

    private final static int MAX_SIZE = 3;

    public BlockingQueue() {
        elements = new ArrayDeque<>();
    }

    public synchronized void enqueue(Element element) {
        while (elements.size() == MAX_SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был остановлен");
            }
        }

        if (elements.isEmpty()) {
            notifyAll();
        }

        elements.add(element);
        String name = Thread.currentThread().getName();
        System.out.println(name + " положил элемент №" + element.number());
    }

    public synchronized Element dequeue() {
        while (elements.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Поток был остановлен");
            }
        }

        if (elements.size() == MAX_SIZE) {
            notifyAll();
        }

        return elements.poll();
    }

    public int size() {
        return elements.size();
    }

}
