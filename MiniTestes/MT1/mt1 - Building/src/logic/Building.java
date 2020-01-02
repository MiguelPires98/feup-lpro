package logic;

public class Building extends Facility {

    protected String name;
    protected int min, max;
    protected int cap=0;

    public Building(String name, int min, int max) {
        super(name);
        if (min>max)
            throw new IllegalArgumentException();

        this.name=name;
        this.min=min;
        this.max=max;
    }


    public int getMinFloor(){
        return min;
    }

    public int getMaxFloor(){
        return max;
    }

    public String getName(){
        return name;
    }

    public void setCapacity(int cap){
        this.cap+=cap;
    }

    public int getCapacity(){
        return cap;
    }


    @Override
    public String toString(){
        return "Building("+this.name+")";
    }
}
