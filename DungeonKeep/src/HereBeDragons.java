//import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;

public class HereBeDragons {

    public final static void clearScreen(){

    }

    //attributes
    private boolean hasKey = false;
    private boolean died = false;
    private boolean win = false;

    private char maze[][] ={{'x','x','x','x','x','x','x','x','x','x'},
                        {'x',' ',' ',' ',' ',' ',' ',' ',' ','x'},
                        {'x',' ','x','x',' ','x',' ','x',' ','x'},
                        {'x',' ','x','x',' ','x',' ','x',' ','x'},
                        {'x',' ','x','x',' ','x',' ','x',' ','x'},
                        {'x',' ',' ',' ',' ',' ',' ','x',' ','e'},
                        {'x',' ','x','x',' ','x',' ','x',' ','x'},
                        {'x',' ','x','x',' ','x',' ','x',' ','x'},
                        {'x',' ','x','x',' ',' ',' ',' ',' ','x'},
                        {'x','x','x','x','x','x','x','x','x','x'},
                    };


/*--------------------------------place game objects----------------------------*/
    private void placeDragon(){
        Random rand = new Random();
        int Xpos, Ypos;

        do {
             Xpos = rand.nextInt((8 - 1) + 1) + 1;
             Ypos = rand.nextInt((8 - 1) + 1) + 1;
        }
        while(maze[Ypos][Xpos]!=' '
                && (Ypos!= 8 && ( Xpos!= 4 || Xpos!= 5 || Xpos!= 6 ) ));

        maze[Ypos][Xpos]='d';
    }

    private void placeKey(){
        Random rand = new Random();

        int Xpos, Ypos;

        do {
            Xpos = rand.nextInt((8 - 1) + 1) + 1;
            Ypos = rand.nextInt((8 - 1) + 1) + 1;
        }
        while(maze[Ypos][Xpos]!=' '
                && (Xpos!=getXPos('d')+1 || Xpos!=getXPos('d')-1 || Ypos!=getYPos('d')+1 || Ypos!=getYPos('d')-1 ));

        maze[Ypos][Xpos]='k';
    }

    private void placeHero(){
        Random rand= new Random();
        int Xpos, Ypos;

        do {
            Xpos = rand.nextInt((8 - 1) + 1) + 1;
            Ypos = rand.nextInt((8 - 1) + 1) + 1;
        }
        while(maze[Ypos][Xpos]!=' '
                && ( Xpos!=getXPos('d')+1 || Xpos!=getXPos('d')-1 || Ypos!=getYPos('d')+1 || Ypos!=getYPos('d')-1 )
        );

        maze[Ypos][Xpos]='h';
    }
/*--------------------------------------------------------------------------------*/


/*----------------------------------sets & gets---------------------------------*/

    public char getCharacter(int x, int y) {
        return maze[y][x];
    }

    public void setCharacter(int x, int y, char c){
        maze[y][x]=c;
    }

    private int getXPos(char c){
        int x,y;

        for(x=0; x<maze.length; x++)
            for(y=0;y<maze.length;y++)
                if(maze[y][x]==c)
                    return x;
        return -1;

    }

    public int getYPos(char c){
        int x,y;

        for(y=0; y<maze.length; y++)
            for(x=0;x<maze.length;x++)
                if(maze[y][x]==c)
                    return y;

        return -1;
    }


/*-----------------------------------------------------------------------------*/




    private void printMap(){
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                if (maze[i][j] == 'x')
                    System.out.print("X ");

                if (maze[i][j] == ' ')
                    System.out.print("  ");

                if (maze[i][j] == 'e')
                    System.out.print("E");

                if (maze[i][j] == 'h')
                    System.out.print("H ");
                if (maze[i][j] == 'd')
                    System.out.print("D ");
                if (maze[i][j] == 'k')
                    System.out.print("K ");
            }
            System.out.println( );
        }
    }

public static void main (String[] args) {
    HereBeDragons map = new HereBeDragons();
    boolean foundKey = false;

    map.placeDragon();
    map.placeKey();
    map.placeHero();

    while(true) {
        //   clearScreen();

        map.printMap();

//-----------------------------------hero movement-------------------------------------
        int HeroXPos = map.getXPos('h');
        int HeroYPos = map.getYPos('h');

        Scanner letter = new Scanner(System.in);
        char move = letter.next().charAt(0);

        if (move == 'a' && map.getCharacter(HeroXPos - 1, HeroYPos) != 'x') {
            map.setCharacter(HeroXPos, HeroYPos, ' ');
            map.setCharacter(HeroXPos - 1, HeroYPos, 'h');

        } else if (move == 'd' && map.getCharacter(HeroXPos + 1, HeroYPos) != 'x') {

            map.setCharacter(HeroXPos, HeroYPos, ' ');
            map.setCharacter(HeroXPos + 1, HeroYPos, 'h');

        } else if (move == 'w' && map.getCharacter (HeroXPos, HeroYPos-1) != 'x') {

            map.setCharacter(HeroXPos, HeroYPos, ' ');
            map.setCharacter(HeroXPos, HeroYPos - 1, 'h');

        } else if (move == 's' && map.getCharacter (HeroXPos, HeroYPos+1) != 'x') {

            map.setCharacter(HeroXPos, HeroYPos, ' ');
            map.setCharacter(HeroXPos, HeroYPos + 1, 'h');
        }
        else{
            System.out.println();
            System.out.println("Don't go through wall you idiot!");
        }
        HeroXPos = map.getXPos('h');
        HeroYPos = map.getYPos('h');

//-----------------------------------------------------------------------------------------
        if(map.hasKey==true && HeroXPos==9 && HeroYPos==5){
            map.win=true;
            map.printMap();
            System.out.println();
            System.out.println("You Win!!");
            break;
        }

        if(map.getXPos('k')==-1) {
            map.hasKey=true;
            map.setCharacter(9,5, ' ');
            if(foundKey==false)
                System.out.println("Achievement Unlocked: You got the key!\nYou can now escape the Dungeon!!");
            foundKey=true;
        }

        if( (HeroXPos==map.getXPos('d')+1 && HeroYPos==map.getYPos('d'))  ||
                (HeroXPos==map.getXPos('d')-1 &&  HeroYPos==map.getYPos('d'))||
                        (HeroYPos==map.getYPos('d')+1 &&  HeroXPos==map.getXPos('d'))||
                                (HeroYPos==map.getYPos('d')-1) && HeroXPos==map.getXPos('d')) {
            map.printMap();
            System.out.println("You died! >:(");
            break;
        }

    }
    System.exit(0);
    }
}


