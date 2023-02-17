package com.bank.service;

import com.bank.BankAccount;
import com.bank.service.impl.BankServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankServiceTest {

    private BankAccount bankAccount;
    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount("Ismail","1");
        bankService = new BankServiceImpl();
    }

    @Test
    void testWithdraw() {
        bankAccount.setBalance(500);
        bankService.withdraw(bankAccount,300);
        double balance = bankAccount.getBalance();
        assertEquals(200,balance);
    }

    @Test
    void testWithdrawAmountHigherThanAccountBalance() {
        bankAccount.setBalance(500);
        bankService.withdraw(bankAccount,1000);
        double balance = bankAccount.getBalance();
        assertEquals(500,balance);
    }

    @Test
    void testDeposit() {
        bankAccount.setBalance(0);
        bankService.deposit(bankAccount,500);
        double balance = bankAccount.getBalance();
        assertEquals(500,balance);
    }

    @Test
    void testDepositNegativeAmount() {
        bankService.deposit(bankAccount,-100);
        double balance = bankAccount.getBalance();
        assertEquals(0,balance);
    }

}