package bj.logic;
import java.util.ArrayList;

public class SetLogic {
    private Deck deckSet;

    private int bet;
    private int id, idP;
    private boolean endThisSet = false;

    private int playerCount;
    private int dealerCount;

//para guardar as cartas do jogador e do dealer
    private ArrayList<Integer> dealersHand = new ArrayList<Integer>();
    private ArrayList<Integer> playersHand = new ArrayList<Integer>();


    //begining of a set
    public void SetLogic(Deck deck) {
        this.deckSet = deck;
    }

    //set has ended?
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

        dealersHand.clear();
        playersHand.clear();
        playerCount = 0;
        dealerCount = 0;
        endThisSet = false;

        //--------------tira carta do dealer virada para baixo-------------------
        id = deckSet.getRandomCard();
        dealersHand.add(id);

        dealerCount = countCard(id, 0);

        System.out.println("\nyour bet: " + bet);

        //--------------tira segunda carta do dealer-------------------------------
        id = deckSet.getRandomCard();
        dealersHand.add(id);

        System.out.print("\ndealer's hand: X\t" + deckSet.getCardStr(id) + "\t");
        dealerCount = countCard(id, dealerCount);

        //--------------tira carta do jogador---------------------------------
        idP = deckSet.getRandomCard();
        playersHand.add(idP);
        playerCount = countCard(idP, 0);

        System.out.print("\tyour hand: ");

        //--------------tira segunda carta do dealer------------------------
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
                endThisSet = true;//rebentou, acaba logo o set
            }

        } else if (move == 'd') {
            this.bet=this.bet*2;
            endThisSet = true;

        } else if (move == 's') {
            endThisSet = true;
        }
//------------------------final do set (contar cartas e ver quem ganhou)------------------------------------
        if (endThisSet) {
            if(playerCount>21) {
                System.out.println("\nyour score: " + playerCount);
                return -1;
            }
            //------------------tirar desto das cartas do dealer-----------------------------
            while (dealerCount < 16) {
                id = deckSet.getRandomCard();
                dealersHand.add(id);
                dealerCount = countCard(id, dealerCount);
            }
             //--------------imprime cartas do dealer--------------------
            System.out.println("----------------------------------");
            System.out.print("dealer's hand: ");
            for (Integer i : dealersHand)
                System.out.print(deckSet.getCardStr(i) + "\t");
            System.out.println("\ndealer's count: " + dealerCount);


            //----------------imprime cartas do jogador-------------------------
            System.out.print("\nyour hand: ");
            for (Integer i : playersHand)
                System.out.print(deckSet.getCardStr(i) + "\t");
            System.out.println("\nyour score: " + playerCount);

            //-------------retorna estado do set (para a classe Game)---------------
            if (dealerCount > playerCount && dealerCount < 22) {
                return -1; //lose
            } else if (dealerCount == playerCount) {
                return 0; //draw
            } else {
                return 1; //win
            }
        }
        return -2; //error
    }

    public int finalMoney(){
        return this.bet; //estado final do dinheiro apostado no set
    }
}
