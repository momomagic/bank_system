package com.bank;

import com.bank.service.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BankMenuTest {

    @Mock
    private BankService bankService;

    BankMenu bankMenu;
    BankAccount bankAccount;

    @BeforeEach
    public void initialize(){
        bankAccount = new BankAccount("Chris", "1");
        bankAccount.setBalance(1000.0);
    }

    @Test
    public void testBankServiceDeposit(){

        String simulatedUserInput = "b" + System.getProperty("line.separator")
                + "1000" + System.getProperty("line.separator")  + "a" + System.getProperty("line.separator")  + "e";

        InputStream savedStandardInputStream = (new ByteArrayInputStream(simulatedUserInput.getBytes()));
        System.setIn(savedStandardInputStream);

        bankMenu = new BankMenu(bankService,bankAccount);
        bankMenu.menu();

        verify(bankService, atLeastOnce()).deposit(bankAccount, 1000);

    }

    @Test
    public void testBankServiceWithdraw(){

        String simulatedUserInput = "c" + System.getProperty("line.separator")
                + "500" + System.getProperty("line.separator")  + "a" + System.getProperty("line.separator")  + "e";

        InputStream savedStandardInputStream = (new ByteArrayInputStream(simulatedUserInput.getBytes()));
        System.setIn(savedStandardInputStream);

        bankMenu = new BankMenu(bankService,bankAccount);
        bankMenu.menu();

        verify(bankService, atLeastOnce()).withdraw(bankAccount, 500);

    }


}