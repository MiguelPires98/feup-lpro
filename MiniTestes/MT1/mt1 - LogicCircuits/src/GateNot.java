public class GateNot extends LogicGate{

    public GateNot(LogicVariable out, LogicVariable input) {

        in=new LogicVariable[1];
        in[0]=input;


        this.res=out;
        this.symbol="NOT";
    }

}
