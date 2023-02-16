package com.bank;

import com.bank.service.BankService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.Scanner;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;


public class BankMenuTest {

    BankService bankService;
    BankAccount bankAccount;
    BankMenu bankMenu;

    @Test
    public void testWithdrawMenu() {
        bankService = mock(BankService.class);
        bankAccount = new BankAccount("Dummy", "123");
        Scanner sc = mock(Scanner.class);
        bankMenu = new BankMenu(bankService, bankAccount, sc);
        double amountWithdraw = 2000.0;
        when(sc.next()).thenReturn("c", "e");
        when(sc.nextDouble()).thenReturn(2000.0);
        bankMenu.menu();
        verify(bankService, atLeast(1)).withdraw(bankAccount, amountWithdraw);
    }

    @Test
    public void testDepositMenu() {
        bankService = mock(BankService.class);
        bankAccount = new BankAccount("Dummy", "123");
        Scanner scan = mock(Scanner.class);
        bankMenu = new BankMenu(bankService, bankAccount, scan);
        when(scan.next()).thenReturn("b", "e");
        when(scan.nextDouble()).thenReturn(2000.0);
        bankMenu.menu();
        verify(bankService, atLeast(1)).deposit(bankAccount, 2000);
    }

    @Test
    public void testBankMenuShouldNotThrowRunTimeException(){
        bankService = mock(BankService.class);
        Scanner sc = mock(Scanner.class);
        bankAccount = new BankAccount("Dummy", "123");
        bankMenu = new BankMenu(bankService, bankAccount, sc);
        doThrow(new RuntimeException()).when(bankService).withdraw(any(), anyDouble());
        assertThrows(RuntimeException.class, ()->{
            bankService.withdraw(any(),anyDouble());
        });
        when(sc.next()).thenReturn("c", "e");
        when(sc.nextDouble()).thenReturn(0.0);
        bankMenu.menu();
        assertDoesNotThrow(() -> bankMenu.menu());

    }


}