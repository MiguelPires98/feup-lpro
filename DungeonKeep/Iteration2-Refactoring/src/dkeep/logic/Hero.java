package dkeep.logic;

import java.util.Random;

public class Hero extends Maze{

    public boolean hasKey=false;

    private void placeHero(){
    Random rand= new Random();
    int Xpos, Ypos;

        do {
        Xpos = rand.nextInt((8 - 1) + 1) + 1;
        Ypos = rand.nextInt((8 - 1) + 1) + 1;
    }
        while(getCharacter(Xpos,Ypos)!=' '
            && ( Xpos!=getXPos('d')+1 || Xpos!=getXPos('d')-1 || Ypos!=getYPos('d')+1 || Ypos!=getYPos('d')-1));


        setCharacter(Xpos,Ypos,'h');
}
}