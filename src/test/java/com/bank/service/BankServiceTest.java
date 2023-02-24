package com.bank.service;

import com.bank.BankAccount;
import com.bank.service.impl.BankServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class BankServiceTest {

    private BankAccount bankAccount;
    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount("Ismail", "1");
        bankService = new BankServiceImpl();
        bankAccount.setBalance(500);
    }

    @Test
    void testWithdraw() {
        bankService.withdraw(bankAccount, 300);
        double balance = bankAccount.getBalance();
        assertEquals(200, balance);
    }

    @Test
    void testWithdrawAmountHigherThanAccountBalance() {
        assertThrows(RuntimeException.class, () -> {
            bankService.withdraw(bankAccount, 1000);
        });
    }

    @Test
    void testDeposit() {
        bankService.deposit(bankAccount, 500);
        double balance = bankAccount.getBalance();
        assertEquals(1000, balance);
    }

    @Test
    void testDepositNegativeAmount() {
        bankService.deposit(bankAccount, -100);
        double balance = bankAccount.getBalance();
        assertEquals(500, balance);
    }

}