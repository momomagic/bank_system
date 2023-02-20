package com.bank;

import com.bank.service.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BankMenuTest {

    BankMenu bankMenu;
    BankAccount bankAccount;
    BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = mock(BankService.class);
        bankAccount = new BankAccount("Ismail", "1");
        bankMenu = new BankMenu(bankService, bankAccount);
    }

    @Test
    void testDeposit() {
        bankAccount.setBalance(0);
        String userInput = "b" + System.lineSeparator() + "1000" + System.lineSeparator() + "e";
        ByteArrayInputStream savedInputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(savedInputStream);
        bankMenu.menu();
        verify(bankService,atLeast(1)).deposit(bankAccount,1000);
    }

}