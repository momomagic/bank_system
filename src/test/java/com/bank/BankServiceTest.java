package com.bank;

import com.bank.service.impl.BankServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BankServiceTest {
    BankServiceImpl bankService;
    BankAccount bankAccount;

    @Before
    public void initialize() {
        bankService = new BankServiceImpl();
        bankAccount = new BankAccount("Bashar", "1");
    }


    @Test
    public void testWithdrawMethod() {
        bankAccount.setBalance(200.0);
        bankService.withdraw(bankAccount, 100.0);
        Assertions.assertEquals(100.0, bankAccount.getBalance());
        Assertions.assertEquals(-100.0, bankAccount.getPrevTrans());


    }

    @Test
    public void testWithdrawMethodWithUsingAmountBiggerThanYouHave() {
        bankAccount.setBalance(200.0);
        bankService.withdraw(bankAccount, 210.0);
        Assertions.assertEquals(200.0, bankAccount.getBalance());


    }


    @Test
    public void testDepositMethod() {
        bankService.deposit(bankAccount, 200.0);
        Assertions.assertEquals(200.0, bankAccount.getBalance());
        Assertions.assertEquals(200, bankAccount.getPrevTrans());


    }

    @Test
    public void testDepositMethodWithMinusAmount() {
        bankService.deposit(bankAccount, 200.0);
        bankService.deposit(bankAccount, -200.0);
        Assertions.assertEquals(200, bankAccount.getBalance());

    }

}
