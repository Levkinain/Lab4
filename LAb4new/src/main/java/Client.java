public class Client implements Comparable<Client> {
    private double moneyAmount;
    private double clientMoney;
    private long time;

    public boolean getOperationType() {
        return operationType;
    }

    private boolean operationType;

    public Client(double moneyAmount, boolean operationType, long time) {
        this.moneyAmount = moneyAmount;
        this.operationType = operationType;
        this.time = time;
        if(operationType){
            setClientMoney(moneyAmount);
        }
    }

    public boolean moneyOperation() {
        return operationType;
    }

    public double getMoney() {
        return moneyAmount;
    }

    public long getTime() {
        return time;
    }

    public void setClientMoney(double money) {
        this.clientMoney = money;
    }

    public double getClientMoney() {
        return clientMoney;
    }


    @Override
    public int compareTo(Client o) {
        operationType = o.getOperationType();
        if (operationType = o.getOperationType()) {
           int result = clientMoney - o.getClientMoney() > 0 ? 1 : -1;
            return result;
        }else{
            return 0;
        }
    }
}
