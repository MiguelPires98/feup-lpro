package atm;

public class Session {

    private ATM atm;

    public Session(ATM atm){
        this.atm=atm;
    }

    public ATM getATM(){
        return this.atm;
    }


    @Override
    public boolean equals(Object o){
        ATM a = (ATM)o;

        return (a.getID()==this.atm.getID() &&
                a.getLocal()==this.atm.getLocal() &&
                a.getBank()==this.atm.getBank());
    }

}
