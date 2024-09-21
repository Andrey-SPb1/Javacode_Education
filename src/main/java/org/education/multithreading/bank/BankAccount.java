package org.education.multithreading.bank;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {

    private final int id;

    private final AtomicInteger balance;

    public BankAccount(int id, int balance) {
        this.id = id;
        this.balance = new AtomicInteger(balance);
    }

    public void deposit(int amount) {
        balance.addAndGet(amount);
    }

    public boolean withdraw(int amount) {
        if(amount > balance.get()){
            System.out.println("Недостаточно средств");
            return false;
        }
        else {
            balance.addAndGet(-amount);
            return true;
        }
    }

    public int getBalance() {
        return balance.get();
    }
}
