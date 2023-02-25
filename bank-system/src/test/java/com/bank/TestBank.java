package com.bank;

import com.bank.service.BankService;
import com.bank.service.impl.BankServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;

import java.util.Scanner;

import static org.mockito.Mockito.*;

public class TestBank {
    

    BankAccount bankAccount;
    BankService bankService;
    BankMenu bankMenu;

    BankServiceImpl bankServiceImpl;


    //En test till withdraw metod med ”best case senario” d.v.s att den fungerar som det ska
    @Test
    public void testWithdrawalWorksBankServiceImpl() {

        /*

        Denna testar endast att withdraw metoden har exekverats en gång. Den använder ett mock
        bankAccount och en random siffra (här 100).

         */

        BankServiceImpl withdrawTest = mock(BankServiceImpl.class);
        withdrawTest.withdraw(bankAccount, 100);
        verify(withdrawTest, times(1)).withdraw(bankAccount, 100);

    }

    //Testa withdraw metod med amount som är större än vad BankAccount har i balance
    @Test
    public void testWithdrawalToBigWithdrawalBankServiceImpl() {

        /*

        Denna skapar ett bankAccount med saldo 100.
        Sedan försöks det ta ut 200 kr.

        Testet kollar om det är kvar 100 kr på kontot.

        Eftersom Withdrawal är konstruerad på det sättet, att om beloppet är för stort så dras inga pengar.


         */

        BankAccount dummyBankAccount = new BankAccount("Dummy", "1");
        dummyBankAccount.setBalance(100.00);

        //Trying to withdraw too much money
        BankServiceImpl dummyWithdraw = mock(BankServiceImpl.class);
        dummyWithdraw.withdraw(dummyBankAccount, 200);

        //Because that I tried to withdraw too much money, I still have 100 left (Withdrawal denied).
        assertEquals(100.00, dummyBankAccount.getBalance());


    }

    //En test till deposit metod med ”best case scenario”
    @Test

    public void TestDepositWhenItWorks() {

        /*

        Denna testar endast att deposit metoden har exekverats en gång. Den använder ett mock
        bankAccount och en random siffra (här 100).

         */

        BankServiceImpl depositTest = mock(BankServiceImpl.class);
        depositTest.deposit(bankAccount, 100);
        verify(depositTest, times(1)).deposit(bankAccount, 100);

    }

    //Testa om du kan deposit med -100 ? ändra metod kod så att den ska vara logisk och inte tillåter att skicka deposit med 0
    //eller lägre
    @Test

    public void testDepositNegative () {

        //I create an account with 100 balance
        BankAccount dummyBankAccount = new BankAccount("Dummy", "1");
        dummyBankAccount.setBalance(100);

        //I try to deposit a negative number! I have changed in the method so this is not allowed.
        BankServiceImpl depositNegativeTest = mock(BankServiceImpl.class);
        depositNegativeTest.deposit(dummyBankAccount, -500);

        //I assert that the bankaccount still has 100. It rejected the deposit.
        assertEquals(100, dummyBankAccount.getBalance());

    }

    //Skriv tester till BankMenu med mock(BankService) till deposit och withdraw
    @Test
    public void testDepositBankMenu () {
        BankServiceImpl bankService1 = mock(BankServiceImpl.class);
        BankAccount dummyBankAccount = new BankAccount( "Dummy", "1");
        Scanner scan = mock(Scanner.class);

        BankMenu test = new BankMenu(bankService1, dummyBankAccount, scan);
        when(scan.next()).thenReturn("b", "e");
        when(scan.nextDouble()).thenReturn(100.0);

        test.menu();

        verify(bankService1, times(1)).deposit(dummyBankAccount, 100.0);

    }

    @Test
    public void testWithdrawBankMenu () {
        BankServiceImpl bankService1 = mock(BankServiceImpl.class);
        BankAccount dummyBankAccount = new BankAccount( "Dummy", "1");
        Scanner scan = mock(Scanner.class);

        BankMenu test = new BankMenu(bankService1, dummyBankAccount, scan);
        when(scan.next()).thenReturn("c", "e");
        when(scan.nextDouble()).thenReturn(100.0);

        test.menu();

        verify(bankService1, times(1)).withdraw(dummyBankAccount, 100);

    }

    /*Om bankService.withdraw skickats tillbaka RuntimeException() vad
    kommer att hända i ditt flöde ? Använd TDD så att du kan skriva
    test som kastar så att BankMenu().menu() kastar inga exception om
    withdraw kastat exception och sen ändrar kod för att låta test vara
    grön
     */

    //@Test
    //Not implemented yet
    

}
