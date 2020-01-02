package TestCases;

public class Message {
  private String m;

  public Message(String s){
      this.m=s;
  }

  public void setMessage(String m){
      this.m=m;
  }

  public String getMessage(){
      return m;
  }

    @Override
    public boolean equals(Object o){
      Message msg=(Message) o;
      return msg.getMessage()==this.m;
    }

    @Override
    public String toString(){
        return "msg:["+m+"]";
    }

}
