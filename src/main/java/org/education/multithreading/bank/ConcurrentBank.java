package org.education.multithreading.bank;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentBank {

    private final ConcurrentHashMap<Integer, BankAccount> accounts;
    private final AtomicInteger accountIdCounter;

    public ConcurrentBank() {
        accounts = new ConcurrentHashMap<>();
        this.accountIdCounter = new AtomicInteger(0);
    }

    public BankAccount createAccount(int balance) {
        int id = accountIdCounter.incrementAndGet();
        BankAccount bankAccount = new BankAccount(id, balance);
        accounts.put(id, bankAccount);
        return bankAccount;
    }

    public void transfer(BankAccount accountFrom, BankAccount accountTo, int amount) {
        if(accountFrom.withdraw(amount)) {
            accountTo.deposit(amount);
        }
    }

    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    public int getTotalBalance() {
        int totalBalance = 0;
        for (BankAccount account : accounts.values()) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }
}
