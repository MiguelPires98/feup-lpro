public class GateAnd extends LogicGate{


    public GateAnd(LogicVariable res, LogicVariable in1, LogicVariable in2) {

       this.in=new LogicVariable[2];

       in[0]=in1;
       in[1]=in2;

       this.res=res;

       this.symbol="AND";

    }


}
