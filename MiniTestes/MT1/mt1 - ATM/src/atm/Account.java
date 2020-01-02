package atm;

public class Account {

    private String name;
    private double money;

    public Account(String name, double money){
        this.name=name;
        this.money=money;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return money;
    }

    public void setBalance(int i) {
        this.money=i;
    }
}
