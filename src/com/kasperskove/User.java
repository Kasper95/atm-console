package com.kasperskove;

/**
 * Created by KASPER on 5/4/17.
 */
class User {

    private String userName;
    private int pin;
    private Double balance;

    User(String userName, int pin, Double balance) {
        this.userName = userName;
        this.pin = pin;
        this.balance = balance;
    }

    User() {
    }

    String getUserName() {
        return userName;
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    int getPin() {
        return pin;
    }

    void setPin(int pin) {
        this.pin = pin;
    }

    Double getBalance() {
        return balance;
    }

    void setBalance(Double balance) {
        this.balance = balance;
    }

    void setBalance() {
        this.balance = (double) Math.round(Math.random() * 10000);
    }

    void withdraw (Double amount) {
        // adding logic to prevent overdrawing from account balance
        if (amount > balance) {
            System.out.printf("Sorry, you only have %s in your account. Enter a different amount...\n\n", balance);
        } else {
            balance = balance - amount;
            System.out.printf("You have %s remaining in your account.\n\n", balance);
        }
    }
}
