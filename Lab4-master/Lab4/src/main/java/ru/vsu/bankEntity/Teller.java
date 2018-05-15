package ru.vsu.bankEntity;

import ru.vsu.clientEntity.Client;

import java.util.concurrent.PriorityBlockingQueue;

public class Teller implements Runnable {
    private PriorityBlockingQueue<Client> queue = new PriorityBlockingQueue();

    public int getNumberTeller() {
        return numberTeller;
    }

    private int numberTeller;
    public static int numberTread = 0;
    CashBank cashBank;


    public Teller(CashBank cashBank) {
        this.cashBank = cashBank;
        numberTread ++;
    }

    public PriorityBlockingQueue<Client> getQueue() {
        return queue;
    }

    public void setQueue(PriorityBlockingQueue<Client> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        this.numberTeller = numberTread;

        while (true) {

            Client client = queue.poll();

            if (client != null) {
                if (client.getOperation().equals("withdraw")) {
                    try {
                        Thread.sleep(client.getTimeOfService()* 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    withdraw(client.getAmountOfMoney());
                }
                if (client.getOperation().equals("acceptance")) {

                    try {
                        Thread.sleep(client.getTimeOfService() * 100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    acceptance(client.getAmountOfMoney());
                }
            }
        }
    }

    private void withdraw(double amount) {
        System.out.println(cashBank.getBalance() + " before withdraw");
        synchronized (cashBank) {
            System.out.println(Thread.currentThread().getName());
            if (cashBank.getBalance() > amount)
                cashBank.setBalance(cashBank.getBalance() - amount);
            else System.out.println("Not enough money");
        }
        System.out.println(cashBank.getBalance() + " after withdraw");
    }

    private void acceptance(double amount) {
        System.out.println(cashBank.getBalance() + " before acceptance");
        synchronized (cashBank) {
            System.out.println(Thread.currentThread().getName());
            cashBank.setBalance(cashBank.getBalance() + amount);
        }
        System.out.println(cashBank.getBalance() + " after acceptance");
    }
}
