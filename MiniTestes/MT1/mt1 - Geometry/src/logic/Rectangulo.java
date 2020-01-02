package logic;

public class Rectangulo extends Figura{

    public Rectangulo(int  x1, int y1 , int x2 ,int y2 ){

        this.perimetro = 2 * Math.abs((y2-y1)) + 2 * Math.abs((x2-x1));
        this.area = Math.abs((y2-y1))  * Math.abs((x2-x1));
    }
}
