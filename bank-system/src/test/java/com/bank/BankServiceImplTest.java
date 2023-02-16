package com.bank;
import com.bank.service.impl.BankServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Scanner;

@ExtendWith(MockitoExtension.class)
public class BankServiceImplTest {

    private BankServiceImpl bankServiceImp;
    private BankAccount bankAccount;

    @Test
    public void setupBankAccount() {
        bankServiceImp = new BankServiceImpl();
        bankAccount = new BankAccount("Pelle","1");
        bankAccount.balance = 50000.0;
    }
}
