package dkeep.cli;
import dkeep.logic.*;

import java.util.Scanner;
public class Cli {

private static void printMap (char[][] maze) {
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (maze[i][j] == 'x')
                System.out.print("X ");

            if (maze[i][j] == ' ')
                System.out.print("  ");

            if (maze[i][j] == 'e')
                System.out.print("E");

            if (maze[i][j] == 'h')
                System.out.print("H ");

            if (maze[i][j] == 'd')
                System.out.print("D ");
            if (maze[i][j] == 's')
                System.out.print("S ");

            if (maze[i][j] == 'a')
                System.out.print("A ");
        }
            System.out.println(); //next line

    }
}

    public static void main(String[] args){

       GameLogic newGame = new GameLogic();
        System.out.println("Welcome do Dragon's Bane!");
       printMap(newGame.getMaze());
        System.out.println("In order to win, you must find the sword, slay the dragon\nand only then can you try to escape the dungeon and win!\nbut be careful, unarmed heroes may die here!\n");
        while(newGame.checkGameState()==0){

            System.out.println("where do you wanna go?");
            Scanner letter = new Scanner(System.in);
            char move = letter.next().charAt(0);

            if(move=='w'||move=='a'||move=='s'||move=='d')
                newGame.updateGame(move);
            else
                System.out.println("enter a valid move\n left->a\tright->d\tup->w\tdown->s\t");

            printMap(newGame.getMaze());

            if(newGame.checkGameState()==-1) {
                System.out.println("You died! >:(");
                break;
            }
            else if(newGame.checkGameState()==1) {
                System.out.println("You Win!!");
                break;
            }

        }
        System.exit(0);
    }
}
