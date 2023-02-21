package com.bank;

import com.bank.service.BankService;

import java.util.Scanner;

public class BankMenu {
    private BankService bankService;
    private BankAccount bankAccount;

    public BankMenu(BankService bankService, BankAccount bankAccount) {
        this.bankService = bankService;
        this.bankAccount = bankAccount;
    }

    void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + bankAccount.getCustomerName());
        System.out.println("Your ID:" + bankAccount.getCustomerId());
        System.out.println("\n");
        System.out.println("a) Check Balance");
        System.out.println("b) Deposit Amount");
        System.out.println("c) Withdraw Amount");
        System.out.println("d) Previous Transaction");
        System.out.println("e) Exit");

        char option;
        do {
            System.out.println("********************************************");
            System.out.println("Choose an option");
            option = sc.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'a' -> {
                    System.out.println("......................");
                    System.out.println("Balance =" + bankAccount.getBalance());
                    System.out.println("......................");
                    System.out.println("\n");
                }
                case 'b' -> {
                    System.out.println("......................");
                    System.out.println("Enter a amount to deposit :");
                    System.out.println("......................");
                    double amount = sc.nextDouble();
                    deposit(amount, bankAccount);
                    System.out.println("\n");
                }
                case 'c' -> {
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    System.out.println("......................");
                    double amountWithdraw = sc.nextDouble();
                    withdraw(amountWithdraw, bankAccount);
                    System.out.println("\n");
                }
                case 'd' -> {
                    System.out.println("......................");
                    System.out.println("Previous Transaction:");
                    bankAccount.getPreviousTrans();
                    System.out.println("......................");
                    System.out.println("\n");
                }
                case 'e' -> System.out.println("......................");
                default -> System.out.println("Choose a correct option to proceed");
            }

        } while (option != 'e');

        System.out.println("Thank you for using our banking services");
    }

    // breaking out to its own method as I don't find any way to test with Scanner
    public void withdraw(double amount, BankAccount bankAccount) {
        bankService.withdraw(bankAccount, amount);
    }

    // breaking out to its own method as I don't find any way to test with Scanner
    public void deposit(double amount, BankAccount bankAccount) {
        bankService.deposit(bankAccount, amount);
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
