package dkeep.logic;

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
        maze[y][x]=c;
    }

    public int getExitX(){
        int x,y=0;
        for(x=0; x<maze.length; x++)
            for(y=0;y<maze.length;y++)
                if(maze[y][x]=='e');
                    return y;
    }
    public int getExitY(){
        int x,y;
        for(x=0; x<maze.length; x++)
            for(y=0;y<maze.length;y++)
                if(maze[y][x]=='e');
                    return x;
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

    public void printMap () {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
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
            System.out.println();
        }
    }

}
