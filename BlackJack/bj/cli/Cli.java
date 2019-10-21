package bj.cli;
import  bj.logic.*;

import java.util.Scanner;

public class Cli {
/*
Game Rules:

  - at the beginning of the game, the player has a default money (10 in this case)

  - after placing a bet that isn't higher then his current money, a set begins:


      *  2 cards are draw for the player and the dealer, but the dealer's first card is hidden (marked as an X)

      *  the player can now make his move, he can either:
           > skip: the set ends
           > double: set ends, player's bet is doubled
           > hit: another card is drawn for the player, if his card count exceeds 21, the set ends with him loosing
           > exit: the game ends and system exits program

      * at the end of a set, the dealer draws cards for himself until he reaches at least 16 (already counting the hidden card)

      * if the player had a bigger count than the dealer, he wins the money that he had betted


  - after the set ending, if he still has any money left, the player can bet again and another set will begin

(NOTE: in each game, the deck is not reseated, meaning that in each set the cards that have been drawn in previous sets, will not appear again)
 */

    public static void main(String[] args) {
        boolean play = true;
        int bet;
        char move;
        GameLogic game = new GameLogic();
        boolean betAgain = false;

        while (play) {
            //------------------------------------------place set's bet-----------------------------------------------------------------------

            do {
                System.out.print("your money: " + game.getPlayerMoney() + "\nhow much do you want to bet? ");
                Scanner sc = new Scanner(System.in);
                bet = sc.nextInt();

                if (bet > game.getPlayerMoney())
                    System.out.println("you can't bet more than the money you have");

            } while (bet > game.getPlayerMoney() );
            game.setBet(bet);

            //------------------------------------------begin set-----------------------------------------------------------------------            
            game.playGame(bet);

            while (game.isSetFinish() == false) {
                do {
                    do {
                        System.out.println("\n\nWhat do you want to do?\n\nhit->h\t\tdouble it->d\t\tskip->s\t\texit table->e");
                        Scanner action = new Scanner(System.in);
                        move = action.next().charAt(0);

                        if (move != 'e' && move != 's' && move != 'h' && move != 'd')
                            System.out.println("enter a valuable option");

                        if (move == 'd' && bet * 2 > game.getPlayerMoney()) {
                            betAgain = true;
                            System.out.print("you don't have enough money to double your bet");
                        } else
                            betAgain = false;
                    } while (betAgain);
                } while (move != 'e' && move != 's' && move != 'h' && move != 'd');

                if (move == 'e')
                    System.exit(0);
                else
                    game.setMove(move);

                game.updateSet();
            }
            //------------------------------------------end set-----------------------------------------------------------------------

            //----------------------------------------play another set?---------------------------------------------------------------
            Scanner whatToDo = new Scanner(System.in);
            char quit;
            do {
                System.out.println("\nDo you want to keep playing?\n\nyes->y\t\tno->n");
                quit = whatToDo.next().charAt(0);
                if(quit!='n' && quit!= 'y')
                    System.out.println("enter a valuable option");

            }while(quit!='n' && quit!= 'y');

            if (quit == 'n') {
                play=false;
                System.exit(0);
            } else if (quit == 'y') {
                if (game.getPlayerMoney() <= 0) {
                    play=false;
                    System.out.println("go home you drunk! you don't have any money left");
                    System.exit(0);
                } else
                    play = true; //play another set
            }
            
        }
        //------------------------------------------end game-----------------------------------------------------------------------
    }
}
