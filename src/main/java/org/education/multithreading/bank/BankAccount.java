package org.education.multithreading.bank;

public class BankAccount {

    private final int id;

    private Double balance;

    public BankAccount(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(double amount) {
        synchronized (this) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        synchronized (this) {
            if (amount > balance) {
                System.out.println("Недостаточно средств");
                return false;
            } else {
                balance -= amount;
                return true;
            }
        }
    }

    public double getBalance() {
        return balance;
    }
}

