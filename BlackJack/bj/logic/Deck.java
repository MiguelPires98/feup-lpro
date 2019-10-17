package bj.logic;

import java.util.Random;

public class Deck {

    //um baralho normal de 52 cartas
    int[][] deck = {{0,1,2,3,4,5,6,7,8,9,10,11,12},
            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
    };


    private int countCard(int id, int previousSum){
        //ás
        if(id==0) {
            if (previousSum + 11 < 22)
                return previousSum + 11;
            else
                return previousSum + 1;
        }

        //figuras
        else if(id==1 || id==11 || id==12)
            return previousSum + 10;

            //numeros
        else if(id > 1 || id < 11)
            return previousSum + id;

        return 0;
    }

    //convert card number id to actual card String
    private String whichCard(int id){
        if(id==0)
            return "as";
        else if(id==1)
            return "rei";
        else if(id > 1 && id < 11)
            return String.valueOf(id);
        else if(id==11)
            return "dama";
        else if (id==12)
            return "valete";

        return null;
    }


    //picks a card (id) that still exists in the deck
    public int draw(int[][] deck){
        int id;
        do {
            Random rand = new Random();
            id = rand.nextInt((12 - 0) + 1) +0 ;
        }while(!stillHasCard(deck,id));
        deck[1][id]--;

        return id;
    }

    //checks if the deck still has cards of that id
    private boolean stillHasCard(int[][] deck, int id){
        if(deck[1][id]!=0)
            return true;
        return false;
    }
}
