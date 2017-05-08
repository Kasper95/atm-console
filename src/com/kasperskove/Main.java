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

        System.out.printf("%s, your pin is %s\n your balance is %s", user.getUserName(), user.getPin(), user.getBalance());
    }
}