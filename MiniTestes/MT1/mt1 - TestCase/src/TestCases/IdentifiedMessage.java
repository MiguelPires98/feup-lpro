package TestCases;

public class IdentifiedMessage  extends Message{
    private String user, m;

    public IdentifiedMessage(String user,String m){
        super(m);
        this.m=m;
        this.user=user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
    public String getMsg() {
        return m;
    }
    @Override
    public boolean equals(Object o){
        IdentifiedMessage im=(IdentifiedMessage) o;
        return im.getUser()==this.user && im.getMsg()==this.m;
    }


    @Override
    public String toString(){
        return "user:["+user+"], msg:["+m+"]";
    }
}
