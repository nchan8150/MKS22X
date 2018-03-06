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
	int col = 0;
	int row = 0;
	String sMaze = "";
	File text= new File(filename);
	Scanner file = new Scanner(text);
	while(file.hasNextLine()) {
	    String line = file.nextLine();
	    sMaze += line + "\n";
	    col = line.length();
	    row++;
	}
	maze = new char[row][col];
	int i = 0;
	int numE = 0;
	int numS = 0;
	for (int x = 0; x < row; x++) {
	    for (int y = 0; y < col; y++) {
		if(sMaze.charAt(i) == 'E') {
		    numE++;
		}
		if(sMaze.charAt(i) == 'S') {
		    numS++;
		}
		maze[x][y] = sMaze.charAt(i);
		i++;
	    }
	}
	if(numE != 1 || numS != 1) {
	    throw new IllegalStateException("You're ove! You need 1 E and 1 S");
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

        //COMPLETE SOLVE
	//maze[row][col] = '@';
	for(int x = 0; x < 4; x++) {
	    maze[row][col] = '@';
	    int rNext = row + move[x][0];
	    int cNext = col + move[x][1];
	    if(maze[rNext][cNext] == 'E') {
		return 1;
	    }
	    if (maze[rNext][cNext] == ' ' || maze[rNext][cNext] == 'E') {
		int ans = solve(rNext,cNext, numAt+1);
		if (ans != 0) {
		    return ans;
		}
	    }
	    maze[rNext][cNext] = '.';
	}

	    return -1; //so it compiles
    }


}


