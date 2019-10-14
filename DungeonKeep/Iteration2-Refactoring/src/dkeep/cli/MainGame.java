package dkeep.cli;
import dkeep.logic.*;

import java.util.Scanner;

public class MainGame {
    public static void main(String[] args){

       GameLogic newGame = new GameLogic();

       newGame.printMap();

        int HeroXPos = newGame.getXPos('h');
        int HeroYPos = newGame.getYPos('h');

        while(true){

            Scanner letter = new Scanner(System.in);
            char move = letter.next().charAt(0);

            if (move == 'a' && newGame.getCharacter(HeroXPos - 1, HeroYPos) != 'x') {
                newGame.setCharacter(HeroXPos, HeroYPos, ' ');
                newGame.setCharacter(HeroXPos - 1, HeroYPos, 'h');

            } else if (move == 'd' && newGame.getCharacter(HeroXPos + 1, HeroYPos) != 'x') {

                newGame.setCharacter(HeroXPos, HeroYPos, ' ');
                newGame.setCharacter(HeroXPos + 1, HeroYPos, 'h');

            } else if (move == 'w' && newGame.getCharacter (HeroXPos, HeroYPos-1) != 'x') {

                newGame.setCharacter(HeroXPos, HeroYPos, ' ');
                newGame.setCharacter(HeroXPos, HeroYPos - 1, 'h');

            } else if (move == 's' && newGame.getCharacter (HeroXPos, HeroYPos+1) != 'x') {

                newGame.setCharacter(HeroXPos, HeroYPos, ' ');
                newGame.setCharacter(HeroXPos, HeroYPos + 1, 'h');
            }
            else{
                System.out.println();
                System.out.println("Don't go through wall you idiot!");
            }

            if(newGame.getGameState()==-1) {
                System.out.println("You died! >:(");
                break;
            }
            else if(newGame.getGameState()==1) {
                System.out.println("You Win!!");
                break;
            }

        }
        System.exit(0);
    }
}
