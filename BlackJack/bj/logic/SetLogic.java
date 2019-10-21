package bj.logic;
import java.util.ArrayList;

public class SetLogic {
    private Deck deckSet;

    private int bet;
    private int id, idP;
    private boolean endThisSet = false;
    private boolean beginning = true;

    private int playerCount;
    private int dealerCount;

    private ArrayList<Integer> dealersHand = new ArrayList<Integer>();
    private ArrayList<Integer> playersHand = new ArrayList<Integer>();


    public SetLogic(Deck deck) {
        this.deckSet = deck;

        dealersHand.clear();
        playersHand.clear();
        playerCount = 0;
        dealerCount = 0;
        endThisSet = false;
        beginning=true;
    }

    public int getStatus(){
        if (endThisSet==true)
            return  -1;
        return 1;
    }

    private int countCard(int id, int previousSum) {
        //ás
        if (id == 0) {
            if (previousSum + 11 < 22)
                return previousSum + 11;
            else
                return previousSum + 1;
        }

        //figuras
        else if (id == 1 || id == 11 || id == 12)
            return previousSum + 10;

            //numeros
        else if (id > 1 || id < 11)
            return previousSum + id;

        return 0;
    }
    public void startSet(int bet){
        //--------------tira carta do dealer virada para baixo------------------------
        id = deckSet.draw();
        String dealerCard = deckSet.getCardStr(id);
        dealersHand.add(id);

        dealerCount = countCard(id, 0);
        //----------------------------------------------------------------------------

        id = deckSet.getRandomCard();
        dealersHand.add(id);
        System.out.println("\nyour bet: " + bet);


        System.out.print("\ndealer's hand: X\t" + deckSet.getCardStr(id) + "\t");
        dealerCount = countCard(id, dealerCount);

        idP = deckSet.getRandomCard();
        playersHand.add(idP);
        playerCount = countCard(idP, 0);
        System.out.print("\tyour hand: ");

        idP = deckSet.getRandomCard();
        playersHand.add(idP);
        playerCount = countCard(idP, playerCount);
        for (Integer i : playersHand)
            System.out.print(deckSet.getCardStr(i) + "\t");
    }

    public int updateSet(char move, int bet) {
        this.bet=bet;

        //----------------------------------------moves------------------------
        if (move == 'h') {
            idP = deckSet.getRandomCard();
            playersHand.add(idP);
            playerCount = countCard(idP, playerCount);
            System.out.print("\nyour hand: ");
            for (Integer i : playersHand)
                System.out.print(deckSet.getCardStr(i) + "\t");
            if (playerCount > 21) {
                endThisSet = true;
            }
        } else if (move == 'd') {
            this.bet=this.bet*2;
            endThisSet = true;
            beginning=true;

        } else if (move == 's') {
            endThisSet = true;
            beginning=true;
        }
        //------------------------------------------------------------------------
        if (endThisSet) {
            if(playerCount>21) {
                System.out.println("\nyour score: " + playerCount);
                return -1;
            }
            while (dealerCount < 16) {
                id = deckSet.getRandomCard();
                dealersHand.add(id);
                dealerCount = countCard(id, dealerCount);
            }

            System.out.println("----------------------------------");
            System.out.print("dealer's hand: ");
            for (Integer i : dealersHand)
                System.out.print(deckSet.getCardStr(i) + "\t");
            System.out.println("\ndealer's count: " + dealerCount);

            System.out.print("\nyour hand: ");
            for (Integer i : playersHand)
                System.out.print(deckSet.getCardStr(i) + "\t");
            System.out.println("\nyour score: " + playerCount);

            if (dealerCount > playerCount && dealerCount < 22) {
                return -1;
            } else if (dealerCount == playerCount) {
                return 0;
            } else {
                return 1;
            }
        }
        return -2;
    }

    public int finalMoney(){
            return this.bet;
    }
}
