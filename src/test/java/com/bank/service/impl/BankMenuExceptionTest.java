package com.bank.service.impl;

import com.bank.BankAccount;
import com.bank.BankMenu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class BankMenuExceptionTest {

    BankServiceImpl bankServiceImpl;
    BankMenu bankMenu;
    BankAccount bankAccount;


    @Test
    public void testMethodWithdrawThrowsExceptionNotAffectingMenu(){

        bankServiceImpl = new BankServiceImpl();
        bankAccount = new BankAccount("Chris", "1");
        bankMenu = new BankMenu(bankServiceImpl, bankAccount);

        String simulatedUserInput = "c" + System.getProperty("line.separator")
                + "1500" + System.getProperty("line.separator")  + "a" + System.getProperty("line.separator")  + "e";

        InputStream savedStandardInputStream = (new ByteArrayInputStream(simulatedUserInput.getBytes()));
        System.setIn(savedStandardInputStream);

        Assertions.assertDoesNotThrow(() -> bankMenu.menu());

    }

}
