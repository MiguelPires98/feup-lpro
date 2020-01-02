public class GateOr extends LogicGate {


    public GateOr(LogicVariable out, LogicVariable in1, LogicVariable in2) {

        in=new LogicVariable[2];

        in[0]=in1;
        in[1]=in2;

        res=out;

        symbol="OR";

    }
}
