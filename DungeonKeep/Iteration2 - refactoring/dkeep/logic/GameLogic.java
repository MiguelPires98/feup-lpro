package dkeep.logic;

import java.util.Random;

public class GameLogic {

    //atributos
    private boolean foundKey = false;
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

        //spawn key
        do{
            coords=pickRandomFreeCell();
        }while(dragonArea(coords[0], coords[1]) );
        this.map.setCharacter(coords[0],coords[1],'k');

        //spawn hero
        do{
            coords=pickRandomFreeCell();
        }while(dragonArea(coords[0], coords[1]));
        this.map.setCharacter(coords[0],coords[1],'h');
    }

//---------------------------------------------------------------------------------------------------

//-------------------------------------logica de jogo aqui---------------------------------------------
    public void updateGame(char move){

        int HeroXPos = this.map.getXPos('h') ;
        int HeroYPos = this.map.getYPos('h') ;

        //movimento do heroi
        if (move == 'a' && (this.map.getCharacter(HeroXPos-1, HeroYPos)!= 'x') &&
                this.map.getCharacter(HeroXPos-1, HeroYPos)!= 'e') {
            this.map.setCharacter(HeroXPos, HeroYPos, ' ');
            this.map.setCharacter(HeroXPos - 1, HeroYPos, 'h');
        }

        else if (move == 'd' && (this.map.getCharacter(HeroXPos + 1, HeroYPos) != 'x') &&
        this.map.getCharacter(HeroXPos+1, HeroYPos)!= 'e') {
            this.map.setCharacter(HeroXPos, HeroYPos, ' ');
            this.map.setCharacter(HeroXPos + 1, HeroYPos, 'h');

        } else if (move == 'w' && (this.map.getCharacter (HeroXPos, HeroYPos-1) != 'x')&&
        this.map.getCharacter(HeroXPos, HeroYPos-1)!= 'e') {
            this.map.setCharacter(HeroXPos, HeroYPos, ' ');
            this.map.setCharacter(HeroXPos, HeroYPos - 1, 'h');

        } else if (move == 's' && (this.map.getCharacter (HeroXPos, HeroYPos+1) != 'x')&&
                this.map.getCharacter(HeroXPos, HeroYPos+1)!= 'e') {
            this.map.setCharacter(HeroXPos, HeroYPos, ' ');
            this.map.setCharacter(HeroXPos, HeroYPos + 1, 'h');
        }
        else
            System.out.println("don't go through walls you idiot!");

         //heroi está à porta -> ganhou jogo
        if(this.map.getXPos('h') == exitX && this.map.getYPos('h') == exitY)
            win = true;

        //nao está em nenhuma coordenada do mapa->heroi limpou-a
            if(this.map.getXPos('k')<0 && foundKey==false) {
                this.map.setCharacter(this.map.getExitX(),this.map.getExitY(),' ');
                System.out.println("Achievement Unlocked: You got the key!\nYou can now escape the Dungeon!!");
                foundKey=true;  //depois de encontrar nao precisa de fazer sempre a abrir saída
            }

            //encontrou dragao -> heroi morre aka game over
            if( (this.map.getXPos('h')==(this.map.getXPos('d')+1) && this.map.getYPos('h')==this.map.getYPos('d'))  ||
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
