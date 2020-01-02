package atm;

import java.text.DecimalFormat;

public class Withdrawal {

    private ATM atm;
    private Session s;
    private Card c;
    private double money;


    public Withdrawal(ATM atm, Session s, Card c, int id){
        this.atm=atm;
        this.s=s;
        this.c=c;
    }

    public void setAmount(double i){
        money=i;
    }

    public double getAmount(){
        return money;
    }

    DecimalFormat formatter = new DecimalFormat("#.00");
    @Override
    public String toString(){
        return "Withdrawal at ATM "+atm.getID()+" ("+atm.getLocal()+", "+atm.getBank()+") of "+formatter.format(money);
    }

}
