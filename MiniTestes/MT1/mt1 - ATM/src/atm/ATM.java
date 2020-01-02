package atm;

public class ATM {

    private int id;
    private String local, bank;

    public ATM(int id, String local, String banco){
        this.id=id;
        this.local=local;
        this.bank=banco;
    }

    public int getID() {
        return id;
    }
    public String getBank() {
        return bank;
    }
    public String getLocal() {
        return local;
    }
}
