package bj.logic;

import java.util.Random;

public class Deck {

    //um baralho normal de 52 cartas
    int[][] deck = {{0,1,2,3,4,5,6,7,8,9,10,11,12},
            {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
    };
    /*
    as->0
    rei->1
    2->2
    3->3
    4->4
    5->5
    6->6
    7->7
    8->8
    9->9
    10->10
    dama->11
    valete->12
    */

    //convert card number id into actual card String
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
    private int draw(){
        int id;
        do {
            Random rand = new Random();
            id = rand.nextInt((12 - 0) + 1) +0 ;
        }while(!stillHasCard(id));
        deck[1][id]--;

        return id;
    }

    //checks if the deck still has cards of that id
    private boolean stillHasCard(int id){
        if(deck[1][id]!=0)
            return true;
        return false;
    }

    public int getRandomCard(){
        return draw();
    }

    public String getCardStr(int id){
        return whichCard(id);
    }
}
