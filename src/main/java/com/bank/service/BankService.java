package main.java.com.bank.service;

import main.java.com.bank.BankAccount;

public interface BankService {
    void withdraw(final BankAccount bankAccount, final double amount);

    void deposit(final BankAccount bankAccount, double amount);

}
