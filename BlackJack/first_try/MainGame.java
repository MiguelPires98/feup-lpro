import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainGame {

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

    private static int countCard(int id, int previousSum){

        //as
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
    private static String whichCard(int id){
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
    public static int draw(int[][] deck){
        int id;
        do {
            Random rand = new Random();
            id = rand.nextInt((12 - 0) + 1) +0 ;
        }while(!stillHasCard(deck,id));
        deck[1][id]--;

        return id;
    }

    //checks if the deck still has cards of that dd
    private static boolean stillHasCard(int[][] deck, int id){
        if(deck[1][id]!=0)
            return true;

        return false;
    }

    public static void main(String[] args){
        int[][] deck = {{0,1,2,3,4,5,6,7,8,9,10,11,12},
                {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}
        };
        ArrayList<Integer> dealersHand = new ArrayList<Integer>();
        ArrayList<Integer> playersHand = new ArrayList<Integer>();

        int id, idP;
        boolean endThisSet=false;
        int money = 10, bet;
        int playerCount;
        int dealerCount;

        do{
    //--------------tira carta do dealer virada para baixo------------------------
        id=draw(deck);
        String dealerCard = whichCard(id);
        dealersHand.add(id);

        dealerCount=countCard(id,0);
    //----------------------------------------------------------------------------

        id=draw(deck);
        dealersHand.add(id);
        do {
            System.out.print("your money: " + money + "\nhow much do you wan to bet? ");
            Scanner sc = new Scanner(System.in);
            bet = sc.nextInt();

            if(bet>money)
                System.out.println("you can't bet more than the money you have");
        }while(bet>money);

        System.out.println("\nyour bet: " + bet );


        System.out.print("\ndealer's hand: X\t" + whichCard(id) +"\t");
        dealerCount=countCard(id,dealerCount);

        idP=draw(deck);
        playersHand.add(idP);
        playerCount=countCard(idP, 0);
        System.out.print("\tyour hand: ");

        idP=draw(deck);
        playersHand.add(idP);
        playerCount=countCard(idP, playerCount);
        for(Integer i: playersHand)
            System.out.print(whichCard(i) + "\t");

    while(playerCount<22) {
        Scanner action = new Scanner(System.in);
        System.out.println("\n\nWhat do you want to do?\n\nhit->h\t\tdouble it->d\t\tskip->s\t\texit game->e");
        char move = action.next().charAt(0);

        if (move == 'e')
            System.exit(0);


        else if (move == 'h') {
            idP = draw(deck);
            playersHand.add(idP);
            playerCount = countCard(idP, playerCount);
            System.out.print("your hand: ");
            for (Integer i : playersHand)
                System.out.print(whichCard(i) + "\t");
            if(playerCount>21) {
                bet=0;
                endThisSet = true;
            }
        } else if (move == 'd') {
            idP = draw(deck);
            playersHand.add(idP);
            playerCount = countCard(idP, playerCount);
            System.out.print("your hand: ");
            for (Integer i : playersHand)
                System.out.print(whichCard(i) + "\t");
            if(playerCount>21)
            {
                bet=0;
                endThisSet = true;
            }
            bet = bet * 2;

        } else if (move == 's') {
            endThisSet = true;
            while (dealerCount < 16) {
                id = draw(deck);
                dealersHand.add(id);
                dealerCount = countCard(id, dealerCount);
            }

            System.out.print("dealer's hand: ");
            for (Integer i : dealersHand)
                System.out.print(whichCard(i) + "\t");
            System.out.println("\ndealer's count: " + dealerCount);

            System.out.print("\nyour hand: ");
            for (Integer i : playersHand)
                System.out.print(whichCard(i) + "\t");
            System.out.println("\nyour score: " + playerCount);
            endThisSet=true;
            break;

        }
        else
            System.out.print("enter a value option");
}
        while(endThisSet) {

            if ((dealerCount > playerCount && dealerCount<22) || playerCount>21){
                money=money-bet;
                System.out.println("\n-------------you lose!------------\nyour money:" + money);
            }
            else if(dealerCount==playerCount){
                money=money+bet/2;
                System.out.println("---------------draw!----------------\nyour money:" + money);
            }
            else {
                money=money+bet;
                System.out.println("\n------------you win!---------------\nyour money:" + money);
            }

            Scanner whatToDo = new Scanner(System.in);
            System.out.println("\nDo you want to keep playing?\n\nyes->y\t\tno->n");
            char quit = whatToDo.next().charAt(0);

            if (quit == 'n')
                System.exit(0);
            else if(quit=='y'){
                if(money<=0) {
                    System.out.println("you don't have enough money");
                    System.exit(0);
                }
            else{
                dealersHand.clear();
                playersHand.clear();
                playerCount=0;
                dealerCount=0;
                endThisSet=false;
            }

            }
        }
    }while(money>0);
    }

}
