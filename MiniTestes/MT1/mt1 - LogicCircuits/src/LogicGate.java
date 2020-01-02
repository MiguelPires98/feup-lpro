public abstract class LogicGate {

    protected LogicVariable res;
    protected LogicVariable[] in;
    protected String symbol=null;

    public LogicVariable getOutput(){
        return res;
    }

    public LogicVariable[] getInputs(){
        return in;
    }


    public String getSymbol(){
        return this.symbol;
    }

}
