package ru.vsu.bankEntity;

public class CashBank {
    private static CashBank instance;
    private double balance;

    private CashBank() {
        this.balance = 1000;
    }

    public static CashBank getInstance() {
        if (instance == null) {
            instance = new CashBank();
        }
        return instance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
