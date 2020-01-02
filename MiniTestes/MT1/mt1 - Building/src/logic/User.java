package logic;

public class User {

private String name;

    public User(String name){
        this.name=name;
        }

    public String getName(){
        return this.name;
    }


@Override
    public boolean equals(Object o){
        User u = (User)o;
        return u.getName()==this.name;
    }

}
