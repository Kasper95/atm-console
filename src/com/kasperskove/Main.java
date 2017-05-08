package com.kasperskove;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Basic ATM - prompts user to log-in
        allows user to view account balance, withdraw/deposit money */

        // prompt user for their username and pin
        System.out.println("Welcome... \nPlease sign in by entering your username...\n");
        // creating new User instance and setting userName to entered String
        User user = new User();
        user.setUserName(scanner.nextLine());

        System.out.printf("Please SET a four digit pin number... ");
        user.setPin(scanner.nextLine()); user.setBalance();

        /* Showing three options
            looping options until user cancels */

        while (true) {

            System.out.println("Choose an option:\n" +
                    "[1] Check Balance\n" +
                    "[2] Withdraw\n" +
                    "[3] Delete Account\n" +
                    "Cancel Transaction\n");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.printf("Your balance is $%s\n", user.getBalance());
                    break;

                case "2":
                    System.out.printf("Enter withdraw amount\n");
                    Double withdraw = Double.valueOf(scanner.nextLine());
                    user.withdraw(withdraw);
            }
        }
    }
}