package bj.logic;

public class GeneralGameLogic {

    private Player player;
    private Deck deck;
    private char move;
    int beat=0;

    public GeneralGameLogic(){
       this.player =new Player();
       this.deck =new Deck();
   }


   public int getPlayerMoney(){
        return this.player.getMoney();
   }


   public void setBeat(int beat){
        this.beat=beat;
   }


   public boolean stillOn(){
    if (this.player.getMoney()<=0) {
        System.out.println("go home you drunk! you don't have any money left");
        return false;
    }
    return true;

   }

    public boolean beginningOfSet(){
        if(beginning)
            return true;
        return false;
    }

   public void setMove(char move){
        this.move=move;
   }

}
