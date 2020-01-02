package logic;

import java.util.DuplicateFormatFlagsException;

public class Room extends Facility {

    private Building b;
    private String num;
    private int floor, capRoom=0;

    public Room(Building b, String nr, int floor) throws DuplicateRoomException{
        super(b.getName()+nr);
        if(floor>b.getMaxFloor())
            throw new IllegalArgumentException();

        this.b=b;
        this.num=nr;
        this.floor=floor;
    }

    public Room(Building b, String nr, int floor, int capRoom) throws DuplicateRoomException {
        super(b.getName()+nr);
        if(floor>b.getMaxFloor())
            throw new IllegalArgumentException();

        this.b=b;
        this.num=nr;
        this.floor=floor;
        this.capRoom=capRoom;
        this.b.setCapacity(capRoom);
    }


    public Building getBuilding(){
        return b;
    }
    public String getNumber(){
        return num;
    }
    public String getName(){
        return b.getName()+num;
    }
    public int getFloor(){
        return floor;
    }

    public int getCapacity(){
        return b.getCapacity();
    }

    @Override
    public String toString(){
        return "Room("+this.b.getName()+","+this.num+")";
    }

}

