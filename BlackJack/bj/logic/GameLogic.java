package bj.logic;

public class GameLogic {

    private Player player;
    private Deck deck;
    private char move;
    private int bet=0;
    private SetLogic set;

    public GameLogic(){
       this.player =new Player();
       this.deck =new Deck();
       this.set = new SetLogic(deck);
   }

   public int getPlayerMoney(){
        return this.player.getMoney();
   }

   public void setBet(int bet){
        this.bet=bet;
   }

   public int getBet(){ return bet; }

   public void setMove(char move){ this.move=move; }


   public void playGame(int bet) {

       set = new SetLogic(this.deck);
       set.startSet(bet);

   }
   public boolean setFinish(){
        if (set.getStatus()==-1)
            return true;
        return false;
   }
   public void updateSet(){
        int result = -2;

        result=set.updateSet(this.move, bet);

        bet=set.finalMoney();
       if (result==-1) {
           player.setMoney(player.getMoney()-bet);
           System.out.println("\n-------------you lose!------------\nyour money:" + player.getMoney());
       } else if (result==0) {
           player.setMoney(player.getMoney()+bet/2);
           System.out.println("---------------draw!----------------\nyour money:" + player.getMoney());
       } else if(result ==1){
           player.setMoney(player.getMoney()+bet);
           System.out.println("\n------------you win!---------------\nyour money:" + player.getMoney());
       }

    }

}
