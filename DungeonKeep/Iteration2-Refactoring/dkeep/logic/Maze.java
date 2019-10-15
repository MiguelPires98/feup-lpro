package dkeep.logic;

import java.util.Random;

public class Maze {

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

    /*----------------------------------sets & gets---------------------------------*/

    public char getCharacter(int x, int y) {
        return maze[y][x];
    }

    public void setCharacter(int x, int y, char c){
        this.maze[y][x]=c;
    }

    public int getExitX(){
        return getXPos('e');
    }

    public int getExitY(){
        return getYPos('e');
    }

    public int getXPos(char c){
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

    /*--------------------------------------------------------------------------------*/
    public char[][] getMaze() {
        return this.maze;
    }


/*-------------------------try this later--------------------------
   public Pair getExit(){
        return getCoords('e');
    }

    public Pair getCoords(char c){
        int x,y;

        for(x=0; x<maze.length; x++)
            for(y=0;y<maze.length;y++)
                if(maze[y][x]==c)
                   return coords(y,x);

        return null;
    }


    public Pair getRandomFreeSpace(){
        Random rand= new Random();
        int x, y;

        do {
            x = rand.nextInt((8 - 1) + 1) + 1;
            y = rand.nextInt((8 - 1) + 1) + 1;
        }while(getCharacter( y,x)!=' ' );

        return coords(y,x);
    }

    public int[][] getMaze() {
        return maze[][];
    }
 */

}
