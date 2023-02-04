package com.bank;

import com.bank.service.BankService;
import com.bank.service.impl.BankServiceImpl;

import java.util.Scanner;

public class BankApplication {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your 'Name' and 'CustomerId' to access your Bank account:");
        String name = sc.nextLine();
        String customerId = sc.nextLine();
        menu(name, customerId);
    }


    static void menu(final String name, final String customerId) {
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();
        BankAccount bankAccount = new BankAccount(name, customerId);
        System.out.println("Welcome " + name);
        System.out.println("Your ID:" + customerId);
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
                    bankService.deposit(bankAccount, amount);
                    System.out.println("\n");
                }
                case 'c' -> {
                    System.out.println("......................");
                    System.out.println("Enter a amount to Withdraw :");
                    System.out.println("......................");
                    double amountWithdraw = sc.nextDouble();
                    bankService.withdraw(bankAccount, amountWithdraw);
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
}
