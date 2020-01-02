package TestCases;

import java.util.ArrayList;

public class Conversation {

    private int maxUsers=0;
    private ArrayList <String> users = new ArrayList<String>();
    private ArrayList <IdentifiedMessage> im = new ArrayList<IdentifiedMessage>();

    public Conversation(int n){
        this.maxUsers=n;
    }

    public int getMaxNumberOfUsers(){
        return maxUsers;
    }

    public int getUserCount(){
        return users.size();
    }
    public void addUser(String u){
        if(users.size()<maxUsers && !users.contains(u))
            users.add(u);
    }
    public void addMessage(IdentifiedMessage i){
        if(!im.contains(i.getUser()))
        this.im.add(i);
    }

    public int getMessageCount(){
        return im.size();
    }

    public void removeUser(String u){
        users.remove(u);
    }


}
