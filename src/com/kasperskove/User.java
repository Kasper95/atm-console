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

    void setPin(String pin) {
        this.pin = Integer.parseInt(pin);
    }

    Double getBalance() {
        return balance;
    }

    void setBalance(Double balance) {
        this.balance = balance;
    }

    void setBalance() {
        this.balance = (double) Math.round(Math.random() * 1000);
    }
}
