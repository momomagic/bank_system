package com.bank.service.impl;

import com.bank.BankAccount;
import org.junit.Test;

import static org.mockito.Mockito.*;


public class BankServiceImplTest {

    private static final double BANK_ACCOUNT_BALANCE = 2000.0;
    private static final double BANK_ACCOUNT_BALANCE_PLUS_ONE = BANK_ACCOUNT_BALANCE +1;

    private BankServiceImpl bankService = new BankServiceImpl();
    private BankAccount bankAccountMock = mock(BankAccount.class);

    @Test
    public void testWithdrawSuccessfully() {
        when(bankAccountMock.getBalance()).thenReturn(BANK_ACCOUNT_BALANCE);
        bankService.withdraw(bankAccountMock, BANK_ACCOUNT_BALANCE);

        verify(bankAccountMock, times(1)).setBalance(anyDouble());
        verify(bankAccountMock, times(1)).setPrevTrans(anyDouble());
    }

    @Test
    public void testWithdrawFailed() {
        when(bankAccountMock.getBalance()).thenReturn(BANK_ACCOUNT_BALANCE);
        bankService.withdraw(bankAccountMock, BANK_ACCOUNT_BALANCE_PLUS_ONE);

        verify(bankAccountMock, times(0)).setBalance(anyDouble());
        verify(bankAccountMock, times(0)).setPrevTrans(anyDouble());
    }
}
