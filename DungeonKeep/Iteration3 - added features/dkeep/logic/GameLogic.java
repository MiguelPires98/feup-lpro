package dkeep.logic;

import java.util.Random;

public class GameLogic {

    //atributos
    private boolean foundSword = false;
    private boolean dragonSlayed = false;
    private boolean dead=false;
    private boolean win =false;

    //objetos?
    private Maze map;
    private Dragon dragon;
    private Hero hero;

    int exitX, exitY;

    //construtor
    public GameLogic() { //futuramente acrescentar como argumento nDragons
        this.map = new Maze();
        this.hero = new Hero();
        this.dragon = new Dragon();

         exitX=this.map.getExitX();
         exitY=this.map.getExitY();

        spawnCharacters();
    }
//---------------------------------metodos da classe----------------------------------
    public char[][] getMaze(){
            return this.map.getMaze();
    }

    private int[] pickRandomFreeCell(){
        Random rand = new Random();

        int[] coords={0,0};

        do {
            /*x*/coords[0] = rand.nextInt((8 - 1) + 1) + 1;
            /*y*/coords[1] = rand.nextInt((8 - 1) + 1) + 1;
        }
        while( this.map.getCharacter(coords[0],coords[1])!=' ');

        return coords;
    }

    private boolean dragonArea(int x, int y){

        if(x!=this.map.getXPos('d')+1||
                x!=this.map.getXPos('d')-1 ||
                y!=this.map.getXPos('d')+1 ||
                y!=this.map.getXPos('d')-1)
            return false;

        return true;
    }

    private void spawnCharacters(){
        int[] coords;

        //spawn dragon
        do{
            coords=pickRandomFreeCell();
        }while( (coords[0]==this.map.getExitX()-1) &&
                (coords[1]==this.map.getExitY() || coords[1]==this.map.getExitY()-1 ||coords[1]==this.map.getExitY()+1));

        this.map.setCharacter(coords[0],coords[1],'d');

        //spawn sword
        coords=pickRandomFreeCell();

        this.map.setCharacter(coords[0],coords[1],'s');

        //spawn hero
        do{
            coords=pickRandomFreeCell();
        }while(dragonArea(coords[0], coords[1]));
        this.map.setCharacter(coords[0],coords[1],'h');
    }

//---------------------------------------------------------------------------------------------------

//-------------------------------------logica de jogo aqui---------------------------------------------
    public void updateGame(char move){
        int heroXPos=0 , heroYPos=0;

        if(foundSword) {
            heroXPos = this.map.getXPos('a');
            heroYPos = this.map.getYPos('a');
        }
        else{
            heroXPos = this.map.getXPos('h');
            heroYPos = this.map.getYPos('h');
        }


        if(foundSword && this.map.getXPos('h')>0)
            this.map.setCharacter(heroXPos, heroYPos, 'a');


      //movimento do heroi
        if (move == 'a' && (this.map.getCharacter(heroXPos-1, heroYPos)!= 'x') &&
                this.map.getCharacter(heroXPos-1, heroYPos)!= 'e') {
            this.map.setCharacter(heroXPos, heroYPos, ' ');
            if(!foundSword)
                this.map.setCharacter(heroXPos - 1, heroYPos, 'h');
            else
                this.map.setCharacter(heroXPos - 1, heroYPos, 'a');
        }

        else if (move == 'd' && (this.map.getCharacter(heroXPos + 1, heroYPos) != 'x') &&
        this.map.getCharacter(heroXPos+1, heroYPos)!= 'e') {
            this.map.setCharacter(heroXPos, heroYPos, ' ');
            if(!foundSword)
                this.map.setCharacter(heroXPos + 1, heroYPos, 'h');
            else
                this.map.setCharacter(heroXPos + 1, heroYPos, 'a');

        } else if (move == 'w' && (this.map.getCharacter (heroXPos, heroYPos-1) != 'x')&&
        this.map.getCharacter(heroXPos, heroYPos-1)!= 'e') {
            this.map.setCharacter(heroXPos, heroYPos, ' ');
            if(!foundSword)
                this.map.setCharacter(heroXPos , heroYPos- 1, 'h');
            else
                this.map.setCharacter(heroXPos , heroYPos- 1, 'a');

        } else if (move == 's' && (this.map.getCharacter (heroXPos, heroYPos+1) != 'x')&&
                this.map.getCharacter(heroXPos, heroYPos+1)!= 'e') {
            this.map.setCharacter(heroXPos, heroYPos, ' ');
            if(!foundSword)
                this.map.setCharacter(heroXPos , heroYPos+ 1, 'h');
            else
                this.map.setCharacter(heroXPos , heroYPos+ 1, 'a');
        }
        else
            System.out.println("don't go through walls you idiot!");

      //heroi está à porta -> ganhou jogo
        if(this.map.getXPos('a') == exitX && this.map.getYPos('a') == exitY)
            win = true;

      //nao está em nenhuma coordenada do mapa->heroi limpou-a
            if(this.map.getXPos('s')<0 && !foundSword) {
                System.out.println("\nAchievement Unlocked: You got the sword!\n\nYou can now slay the Dragon to escape the Dungeon!!");
                foundSword=true;  //depois de encontrar nao precisa de fazer sempre a abrir saída
                this.map.setCharacter(this.map.getXPos('h'),this.map.getYPos('h'), 'a');
            }

        if(this.map.getXPos('d')<0 && !dragonSlayed) {
            this.map.setCharacter(exitX, exitY, ' ');
            dragonSlayed=true;
        }

            //encontrou dragao -> heroi desarmado morre aka game over
            if((this.map.getXPos('h')==(this.map.getXPos('d')+1) && this.map.getYPos('h')==this.map.getYPos('d'))  ||
                    (this.map.getXPos('h')==(this.map.getXPos('d')-1) && this.map.getYPos('h')==this.map.getYPos('d'))  ||
                    (this.map.getYPos('h')==(this.map.getYPos('d')+1) && this.map.getXPos('h')==this.map.getXPos('d'))  ||
                    (this.map.getYPos('h')==(this.map.getYPos('d')-1) && this.map.getXPos('h')==this.map.getXPos('d'))
            )
            dead=true;

    }
    //final do jogo
    public int checkGameState(){
        if(dead)
            return -1;
        else if(win)
            return 1;
        else
            return 0;
    }
}
