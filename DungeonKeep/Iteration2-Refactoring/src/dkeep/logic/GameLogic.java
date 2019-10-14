package dkeep.logic;

public class GameLogic {

    private boolean foundKey = false;
    private boolean dead=false;
    private boolean win =false;

    Maze map = new Maze();
    Dragon dragon = new Dragon();
    Key key = new Key();
    Hero hero = new Hero();

    int ExitX=getExitX();
    int ExitY=getExitY();


    if(foundKey==true && this.hero.getXPos==ExitX && hero.getYPos==ExitY){
       win=true;
    }

        if(map.getXPos('k')==-1) {
        map.hasKey=true;
        map.setCharacter(9,5, ' ');
        if(foundKey==false)
            System.out.println("Achievement Unlocked: You got the key!\nYou can now escape the Dungeon!!");
        foundKey=true;
    }

        if( (hero.getXPos('h')==map.getXPos('d')+1 && getYPos('h')==map.getYPos('d'))  ||
            (HeroXPos==map.getXPos('d')-1 &&  HeroYPos==map.getYPos('d'))||
            (HeroYPos==map.getYPos('d')+1 &&  HeroXPos==map.getXPos('d'))||
            (HeroYPos==map.getYPos('d')-1) && HeroXPos==map.getXPos('d')) {
        map.printMap();
dead=true;
    }

        public int getGameState() {
            if(dead)
                return -1;
            else if(win)
                return 1;
            else
                return 0;
        }
    }
}
