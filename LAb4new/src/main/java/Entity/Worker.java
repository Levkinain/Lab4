package Entity;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Worker implements Runnable {
    private PriorityBlockingQueue<Client> queue = new PriorityBlockingQueue();
    private int workerId;

    public Worker(int id) {
        this.workerId = id;
    }

    public void addClient(Client client) {
        queue.add(client);
    }

    public Queue<Client> getQueue() {
        return queue;
    }

    @Override
    public void run() {
        while (true) {
            if (getQueue().size() != 0) {
                Client client = getQueue().poll();
                System.out.println("Worker " + workerId + " start operation" + "(money:" + client.getClientMoney() + ")");
                try {
                    Thread.sleep(client.getTime());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (client.moneyOperation()) {
                    Bank.addMoney(client.getMoney());
                } else {
                    client.setClientMoney(Bank.getMoney(client.getMoney()));
                }
                System.out.println("Worker " + workerId + " finished operation " + "(money:" + client.getClientMoney() + ")" + "\n" + "BankAccount :" + Bank.getBankMoney());
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
