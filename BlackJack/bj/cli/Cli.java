package bj.cli;
import  bj.logic.*;

import java.util.Scanner;

public class Cli {

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

    public static void main(String[] args){

        int bet;
        char move;
        GeneralGameLogic game = new GeneralGameLogic();

        while (game.stillOn()) {
            if(game.beginningOfSet()) {
                do {
                    System.out.print("your money: " + game.getPlayerMoney() + "\nhow much do you want to bet? ");
                    Scanner sc = new Scanner(System.in);
                    bet = sc.nextInt();

                    if (bet > game.getPlayerMoney())
                        System.out.println("you can't bet more than the money you have");

                } while (bet > game.getPlayerMoney());

                game.setBet(bet);
            }
            do {
                System.out.println("\n\nWhat do you want to do?\n\nhit->h\t\tdouble it->d\t\tskip->s\t\texit table->e");
                Scanner action = new Scanner(System.in);
                move = action.next().charAt(0);

                if(move!='e' && move !='s'&& move !='h'&& move !='d')
                    System.out.println("enter a value option");

            }while(move!='e' && move !='s'&& move !='h'&& move !='d');

            if (move == 'e')
                 System.exit(0);
            else
                game.setMove(move);

        }
    }

}
