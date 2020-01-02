package logic;

import java.util.ArrayList;

public class Comboio{

    private String name;
    private ArrayList <Carruagem> carruagem= new ArrayList<Carruagem>() ;


    public Comboio(String name){

        this.name=name;
    }

    public String getNome(){
        return name;
    }


    public int getNumLugares(){
        int nLugares=0;
            for (Carruagem a : carruagem)
                nLugares+=a.getNumLugares();

        return nLugares;

    }
    public int getNumCarruagens(){
       return carruagem.size();
    }

    public void addCarruagem(Carruagem a){
        this.carruagem.add(a);
    }

    public Carruagem getCarruagemByOrder(int i){
        return carruagem.get(i);
    }


    public void removeAllCarruagens(int x){
        ArrayList <Carruagem> temp= new ArrayList<Carruagem>() ;

        for (Carruagem i : carruagem)
            if(i.getNumLugares()!=x)
                temp.add(i);
        this.carruagem=temp;
    }

}


