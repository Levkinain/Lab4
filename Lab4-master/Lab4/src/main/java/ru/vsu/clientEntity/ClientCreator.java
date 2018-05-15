package ru.vsu.clientEntity;

import ru.vsu.bankEntity.Teller;

import java.util.Random;

public class ClientCreator implements Runnable {
    Random random = new Random(System.currentTimeMillis());
    // массив доступных операций
    //enum String {WITHDRAW, ACCEPTANCE};
    String operation[] = {"withdraw", "acceptance"};
    Teller[] pool;

    public ClientCreator(Teller[] pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            pool[getTellerWithMinClients()].getQueue().offer(
                    new Client(operation[random.nextInt(operation.length)], random.nextDouble() * 10000, random.nextInt(10)));
            try {
                Thread.sleep(random.nextInt(10) * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int getTellerWithMinClients(){

        int minCountOfClients = Integer.MAX_VALUE;
        int tellerWithMinClients = 0;
        for (int i = 0; i < pool.length; i++) {
            if (pool[i].getQueue().size() < minCountOfClients) {
                minCountOfClients = pool[i].getQueue().size();
                tellerWithMinClients = i;
            }
        }
        return tellerWithMinClients;
    }


}
