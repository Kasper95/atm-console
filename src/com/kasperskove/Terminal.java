package com.kasperskove;

import java.util.Scanner;

public class Terminal {

    User user = new User();

    static void run() {

        Scanner scanner = new Scanner(System.in);
        User user = new User();

        signIn(user);

        while (true) {

        /* Showing three options
            looping options until user cancels */
            int t = 1;
            while (t == 1) {

                System.out.println("Choose an option:\n" +
                        "[1] Check Balance\n" +
                        "[2] Withdraw\n" +
                        "[3] Delete Account\n" +
                        "[4] Sign Out\n" +
                        "[5] Close ATM");
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

                    case "5":
                        System.out.println("Closing ATM...    ");
                        System.exit(0);
                        break;
                }
            }
        }
    }

    private static User signIn (User user) {

        if (user.getUserName() == null) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome... \nPlease sign in by entering your username...\n");

            // creating new User instance and setting userName to entered String
            user.setUserName(scanner.nextLine());
            System.out.printf("Welcome, %s, we've created an account for you...%n", user.getUserName());

            // if user has a pin already, they do not need to create one, but rather enter it in
            if (!user.hasPin()) {
                System.out.printf("Please SET a four digit pin number... %n");
                user.setPin(scanner.nextInt());
            } else {
                // TODO: prompt for pin and validate
            }
            user.setBalance();
        }

        return user;
    }
}
