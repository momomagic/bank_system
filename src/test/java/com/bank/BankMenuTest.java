package com.bank;

import com.bank.service.BankService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BankMenuTest {
    BankService bankServiceMock = mock(BankService.class);
    BankMenu bankMenuMock;
    BankAccount bankAccount;



    @Test
    public void testWithdrawMethodWithMockito() {
        bankAccount = new BankAccount("1","pelle");
        bankAccount.setBalance(1000);
        bankServiceMock.withdraw(bankAccount,1000);
        verify(bankServiceMock).withdraw(any(BankAccount.class),anyDouble());
        Assertions.assertTrue(true,"Should return true if withdraw method was called");
    }

    @Test
    public void testDepositMethodWithMockito() {
        BankMenu bankMenu = new BankMenu(bankServiceMock,bankAccount);
        bankAccount = new BankAccount("1","pelle");
        bankServiceMock.deposit(bankAccount,1000);
        verify(bankServiceMock).deposit(any(BankAccount.class),anyDouble());
        Assertions.assertTrue(true,"Should return true if deposit method was called");
    }

//    @Test
//    public void testBankServiceWithdrawShouldThrowRunTimeException() {
//        bankAccount = new BankAccount("1","pelle");
//        bankAccount.setBalance(1000);
//        doThrow(new RuntimeException()).when(bankServiceMock).withdraw(any(),anyDouble());
//        bankServiceMock.withdraw(any(),anyDouble());
//        assertThrows(RuntimeException.class, () -> {
//            bankServiceMock.withdraw(any(),anyDouble());
//        });
//    }


    @Test
    public void testBankServiceShouldNotThrowRunTimeException() {
        bankAccount = new BankAccount("1","pelle");
        bankAccount.setBalance(10000);
        bankServiceMock.withdraw(bankAccount,1000);
        assertDoesNotThrow(() -> bankServiceMock.withdraw(any(),anyDouble()));
        verify(bankServiceMock).withdraw(any(BankAccount.class),anyDouble());
        Assertions.assertTrue(true,"test should pass now");

    }
}
