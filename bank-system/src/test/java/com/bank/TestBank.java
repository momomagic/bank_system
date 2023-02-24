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

    /*
   Skriv tester till BankServiceImpl så att den testar
o En test till withdraw metod med ”best case senario” d.v.s att
den fungerar som det ska
o Testa withdraw metod med amount som är större än vad
BankAccount har i balance
o En test till deposit metod med ”best case senario”
o Testa om du kan deposit med -100 ? ändra metod kod så att
den ska vara logisk och inte tillåter att skicka deposit med 0
eller lägre
• Skriv tester till BankMenu med mock(BankService) till deposit och
withdraw
• Om bankService.withdraw skickats tillbaka RuntimeException() vad
kommer att hända i ditt flöde ? Använd TDD så att du kan skriva
test som kastar så att BankMenu().menu() kastar inga exception om
withdraw kastat exception och sen ändrar kod för att låta test vara
grön
• Skicka en PR med dina ändringar till andra teammedlemmar .

     */

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

        BankServiceImpl dummyWithdraw = mock(BankServiceImpl.class);
        dummyWithdraw.withdraw(bankAccount, 100);
        verify(dummyWithdraw, times(1)).withdraw(bankAccount, 100);

    }

    @Test
    public void testWithdrawalToBigWithdrawalBankServiceImpl() {

        BankAccount dummyBankAccount = new BankAccount("Dummy", "1");
        dummyBankAccount.setBalance(100.00);

        System.out.println(dummyBankAccount.getCustomerName());
        System.out.println(dummyBankAccount.getCustomerId());
        System.out.println(dummyBankAccount.getBalance());

        BankServiceImpl dummyWithdraw = mock(BankServiceImpl.class);
        dummyWithdraw.withdraw(dummyBankAccount, 200);

        assertEquals(100.00, dummyBankAccount.getBalance());




    }



}
