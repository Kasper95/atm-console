package com.kasperskove;

import java.util.Scanner;

public class Terminal {

    public static void run() throws NumberFormatException {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // prompt user for their username and pin
            System.out.println("Welcome... \nPlease sign in by entering your username...\n");
            // creating new User instance and setting userName to entered String
            User user = new User();
            user.setUserName(scanner.nextLine());

            if (!user.hasPin()) {
                System.out.printf("Please SET a four digit pin number... ");
                user.setPin(scanner.nextInt());
            }

            user.setBalance();

        /* Showing three options
            looping options until user cancels */
            int t = 1;
            while (t == 1) {

                System.out.println("Choose an option:\n" +
                        "[1] Check Balance\n" +
                        "[2] Withdraw\n" +
                        "[3] Delete Account\n" +
                        "[4]Cancel Transaction\n");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        System.out.printf("Your balance is $%s\n", user.getBalance());
                        break;

                    case "2":
                        System.out.printf("Enter withdraw amount\n");
                        Double withdraw = Double.valueOf(scanner.nextLine());
                        user.withdraw(withdraw);
                        break;

                    case "3":
                        System.out.println("To delete your account. Enter your four digit pin...\n");
                        int pin = scanner.nextInt();
                        if (pin == user.getPin()) {
                            user = null;
                            t = 2;
                        } else {
                            System.out.println("Invalid Pin...\n");
                        }
                        break;

                    case "4":
                        System.out.println("Transaction canceled.\n\n");
                        t = 2;
                        break;
                }
            }
        }
    }
}
