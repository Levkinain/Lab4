package ru.vsu;

import ru.vsu.bankEntity.CashBank;
import ru.vsu.bankEntity.Teller;
import ru.vsu.clientEntity.ClientCreator;

public class Main {
    public static void main(String[] args) {
        Teller[] pool = new Teller[5];
        for (int i = 0; i < pool.length; i++){
            pool[i] = new Teller(CashBank.getInstance());
           Thread thread = new Thread(pool[i]);
            thread.start();
            System.out.println(thread.getName());
        }

        System.out.println(Teller.numberTread);
        ClientCreator clientCreator = new ClientCreator(pool);
        clientCreator.run();
    }
}
