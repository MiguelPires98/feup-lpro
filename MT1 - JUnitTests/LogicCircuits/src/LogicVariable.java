

public class LogicVariable {
    private String name;
    private boolean value;

    public LogicVariable(String name,boolean value){
        this.name=name;
        this.value=value;
    }


    public LogicVariable(String name){
        this.name=name;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setValue(boolean value){
        this.value=value;
    }

    public String getName(){
        return this.name;
    }
    public boolean getValue(){
        return this.value;
    }
}
