package logic;

public class Circulo extends Figura{
  protected Ponto centro;
  protected int raio;


    public Circulo(Ponto p, int raio) {
        if(raio<0)
            throw new IllegalArgumentException();

        this.raio=raio;
        this.centro=p;

        this.area=Math.PI * raio *raio;

    }


    public Ponto getCentro(){
        return centro;
    }

    public int getRaio() {
        return raio;
    }
}
