package ru.vsu.clientEntity;

public class Client implements Comparable<Client> {
    //операция
    private String operation;
    //величина денежных средств для пополнения или снятия
    private double amountOfMoney;
    //время обслуживания клиента
    private long timeOfService;


    public Client(String operation, double amountOfMoney, long timeOfService) {
        this.operation = operation;
        this.amountOfMoney = amountOfMoney;
        this.timeOfService = timeOfService;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amount) {
        this.amountOfMoney = amount;
    }

    public long getTimeOfService() {
        return timeOfService;
    }

    public void setTimeOfService(long time_in_seconds) {
        this.timeOfService = timeOfService;
    }

    @Override
    public String toString() {
        return Client.class.getSimpleName() +
                " operation='" + operation + '\'' +
                ", amount of money=" + amountOfMoney +
                ", time of service=" + timeOfService +
                '}';
    }

    @Override
    public int compareTo(Client o) {
        int result = operation.compareTo(o.getOperation());
        if (result != 0) {
            return result;
        }
        if (amountOfMoney == o.getAmountOfMoney()) return 0;

        result = amountOfMoney - o.getAmountOfMoney() > 0 ? 1 : -1;
        return result;
    }
}
