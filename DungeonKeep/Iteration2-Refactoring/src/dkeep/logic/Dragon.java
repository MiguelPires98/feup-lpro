package dkeep.logic;

import java.util.Random;

public class Dragon extends Maze{


    private void placeDragon(){
        Random rand = new Random();
        int Xpos, Ypos;

        do {
            Xpos = rand.nextInt((8 - 1) + 1) + 1;
            Ypos = rand.nextInt((8 - 1) + 1) + 1;
        }
        while(getCharacter(Xpos,Ypos)!=' '
                && (Xpos!= getXPos('e')-1 && ( Ypos!= getYPos('e') || Ypos!= getYPos('e')-1 || Ypos!=getYPos('e')+1 ) ));

        setCharacter(Xpos,Ypos,'d');
    }
}
