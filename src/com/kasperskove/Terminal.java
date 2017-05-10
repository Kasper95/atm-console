package com.kasperskove;

import java.util.Scanner;

class Terminal {

    private static User user = new User();
    private static Scanner scanner = new Scanner(System.in);


    static void run() {
        // showing options. looping options until user cancels

//        int t = 1;

        System.out.printf("%s", user.getUserName());

        while (true) {

            signIn(user);

            do {

                System.out.printf(prompt());
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        System.out.printf("Your balance is $%s\n", user.getBalance());
                        break;

                    case "2":
                        System.out.printf("Enter withdraw amount\n");
                        Double withdraw = Double.valueOf(scanner.nextLine());
                        Terminal.user.withdraw(withdraw);
                        break;

                    case "3":
                        System.out.println("To delete your account. Enter your four digit pin...\n");
                        int pin = scanner.nextInt();
                        if (pin == user.getPin()) {
                            user.setPin(null);
                            signOut(user);
                        } else {
                            System.out.println("Invalid Pin...\n");
                        }
                        break;

                    case "4":
                        System.out.println("Transaction canceled" +
                                "\nSigning out... \n");
                        signOut(Terminal.user);
                        break;

                    case "5":
                        System.out.println("Closing ATM...    ");
                        System.exit(0);
                        break;
                }
            } while (user.getUserName() != null);
        }
    }

    private static void signIn(User user) {

        if (Terminal.user.getUserName() == null) {
            System.out.println("Welcome... \nPlease sign in by entering your username...\n");
            Terminal.user.setUserName(scanner.nextLine());
            Terminal.user.setBalance();
            System.out.printf("Welcome, %s, we've created an account for you...%n%n", Terminal.user.getUserName());
            System.out.printf("Please SET a four digit pin number:         ");
            user.setPin(scanner.nextInt());
        } else {

        }
    }

    private static void signOut (User user) {
        Terminal.user.setUserName(null);
    }

    private static String prompt(){
        String options = "Choose an option:\n" +
                "[1] Check Balance\n" +
                "[2] Withdraw\n" +
                "[3] Delete Account\n" +
                "[4] Sign Out\n" +
                "[5] Close ATM\n\n";
        return options;
    }
}
