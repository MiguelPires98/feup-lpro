package logic;

public class FiguraComposta extends Figura implements Countable{

    private double sum;

    protected Figura[] figuras;

    public FiguraComposta(Figura[] figuras){
        this.figuras=figuras;
    }

    public double getArea() {
        for (int i=0; i<figuras.length;i++)
            sum+=figuras[i].getArea();
        return sum;
    }

@Override
    public int count(){
        return figuras.length;
    }
}
