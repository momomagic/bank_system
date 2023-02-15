package com.bank;

import com.bank.service.impl.BankServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BankServiceImplTest {

    private BankServiceImpl bankServiceImpl;
    private BankAccount bankAccount;

    @BeforeEach
    public void initializeBankServiceImpl(){
        bankServiceImpl = new BankServiceImpl();
        bankAccount = new BankAccount("Chris", "1");
        bankAccount.balance = 1000.0;
    }

    @Test
    public void testWithdrawMethodWorks(){
        bankServiceImpl.withdraw(bankAccount,100);
        Assertions.assertEquals(900, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawMethodNotEnoughBalance(){
        bankServiceImpl.withdraw(bankAccount,1100);
        Assertions.assertEquals(1000, bankAccount.getBalance());
    }

    @Test
    public void testDepositMethodWorks(){
        bankServiceImpl.deposit(bankAccount,500);
        Assertions.assertEquals(1500, bankAccount.getBalance());
    }

    @Test
    public void testNegativeAmountDepositMethod(){
        bankServiceImpl.deposit(bankAccount,-500);
        Assertions.assertEquals(1000, bankAccount.getBalance());
    }


}
