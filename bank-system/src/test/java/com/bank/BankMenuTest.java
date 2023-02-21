package com.bank;

import com.bank.service.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

public class BankMenuTest {

    private static final double BANK_ACCOUNT_BALANCE = 2000.0;
    private static final double AMOUNT = 200;

    private BankService bankServiceMock = mock(BankService.class);
    private BankAccount bankAccountStub = new BankAccountStub("Tester Testsson", "123456");

    private BankMenu bankMenu = new BankMenu(bankServiceMock, bankAccountStub);

    @BeforeEach
    void resetAccountBalance() {
        bankAccountStub.setBalance(BANK_ACCOUNT_BALANCE);
    }

    @Test
    void testWithdraw() {
        bankMenu.withdraw(AMOUNT, bankAccountStub);

        verify(bankServiceMock, times(1)).withdraw(any(), anyDouble());
    }

    @Test
    void testWithdrawWithException() {
        doThrow(new RuntimeException()).when(bankServiceMock).withdraw(any(), anyDouble());

        bankMenu.withdraw(AMOUNT, bankAccountStub);
    }

    @Test
    void testDeposit() {
        bankMenu.deposit(AMOUNT, bankAccountStub);

        verify(bankServiceMock, times(1)).deposit(any(), anyDouble());
    }
}
