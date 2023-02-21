package com.bank.service.impl;

import com.bank.BankAccount;
import com.bank.BankAccountStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class BankServiceImplTest {
    private static final double BANK_ACCOUNT_BALANCE = 2000.0;
    private static final double WITHDRAW_AMOUNT = 200;
    private static final double DEPOSIT_AMOUNT = 100;
    private static final double NEGATIVE_DEPOSIT_AMOUNT = -100;

    private BankServiceImpl bankService = new BankServiceImpl();
    private BankAccount bankAccountStub = new BankAccountStub("Tester Testsson", "123456");

    @BeforeEach
    void resetAccountBalance() {
        bankAccountStub.setBalance(BANK_ACCOUNT_BALANCE);
    }
    @Test
    void testWithdrawSuccessfully() {
        bankService.withdraw(bankAccountStub, WITHDRAW_AMOUNT);
        assertEquals(BANK_ACCOUNT_BALANCE - WITHDRAW_AMOUNT, bankAccountStub.getBalance());
    }

    @Test
    void testWithdrawFailed() {
        bankService.withdraw(bankAccountStub, WITHDRAW_AMOUNT + BANK_ACCOUNT_BALANCE);
        assertEquals(BANK_ACCOUNT_BALANCE, bankAccountStub.getBalance());
    }

    @Test
    void testDepositSuccessfully() {
        bankService.deposit(bankAccountStub, DEPOSIT_AMOUNT);
        assertEquals(BANK_ACCOUNT_BALANCE + DEPOSIT_AMOUNT, bankAccountStub.getBalance());
    }

    @Test
    void testDepositNegativeNumber() {
        bankService.deposit(bankAccountStub, NEGATIVE_DEPOSIT_AMOUNT);
        assertEquals(BANK_ACCOUNT_BALANCE, bankAccountStub.getBalance());
    }
}