//Had a lot of help from jerry sigh im bad at this
import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate; //false by default
    private int[][] move = {{1,0},{-1,0},{0,1},{0,-1}};

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.

    */

    public Maze(String filename) throws FileNotFoundException{
	animate = false;
	File text = new File(filename);
        Scanner file = new Scanner(text);
        String ans = "";
        int cols = 0;
        int rows = 0;
        while(file.hasNextLine()){
            String line = file.nextLine();
            cols = line.length();
	    rows++;
	    ans += line;
     
        }
	maze = new char[rows][cols];
	int x = 0;
	int numS = 0;
	int numE = 0;
	for (int r = 0; r < rows; r ++){
	    for (int c = 0; c < cols; c++){
		    maze[r][c] = ans.charAt(x);
            if (ans.charAt(x) == 'S'){
                numS++;
            }
            if (ans.charAt(x) == 'E'){
                numE++;
            }
	       x++;
	    }
	}
    if (numS != 1 || numE != 1){
    throw new IllegalStateException("num of S and E incorrect!");
    }
    
    }

    public String toString() {
	String ans = "";
	for (int x = 0; x < maze.length; x++) {
	    for(int y = 0; y < maze[0].length; y++) {
		ans += maze[x][y];
	    }
	    ans += "\n";
	}
	return ans;
    }
    

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){

            //find the location of the S. 
	int Sx = 0;
	int Sy = 0;
	for (int x = 0; x < maze.length; x++) {
	    for(int y = 0; y < maze[0].length; y++) {
		if(maze[x][y] == 'S') {
		    Sx = x;
		    Sy = y;
		}
	    }
	}
      
            //erase the S
	maze[Sx][Sy] = ' ';

            //and start solving at the location of the s.

            //return solve(???,???);
	return solve(Sx,Sy,0);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int numAt){ //you can add more parameters since this is private


        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

	 if(maze[row][col] == 'E') {
		return numAt;
	    }

        //COMPLETE SOLVE
	//maze[row][col] = '@';
	 for(int x[]: move) {
	    maze[row][col] = '@';
	    if (maze[row+x[0]][col+x[1]] == ' ' || maze[row+x[0]][col+x[1]] == 'E' ){
		int ans = solve(row + x[0], col + x[1],numAt + 1);
		if ( ans != -1){
		    return ans;
		}
	    }
	    maze[row][col] = '.';

	  
	}

	    return -1; //so it compiles
    }


}


