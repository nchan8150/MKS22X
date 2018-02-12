//size 2 and 3 wont work
//negatives wont work
//cant call solve twice bc its not 0 anymore
//put 1 in each coloumn 

public class QueenBoard {

    private int[][]board;

    public QueenBoard (int size) {
	new board = int[size][size];
    }

    private boolean addQueen(int r, int c) {
	if (board[r][c] != 0) {
	    return false;
	}
	board[r][c] = -1;
	for(int x = r; x < board.length; x++) {
	    board[x][c] += 1;
	}
	for(int y = c; y < board[r].length; y++) {
	    board[r][y] += 1;
	}
	return true;
    }

    private boolean removeQueen(int r, int c) {
	if (board[r][c] != -1) {
	    return false;
	}
	board[r][c] == 0;
	for(int x = r; x < board.length; x++) {
	    board[x][c] -= 1;
	}
	for(int y = c; y < board[r].length; y++) {
	    board[r][y] -= 1;
	}
	return true;
    }

    public String toString() {
	String bb = "";
	for(int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] = -1) {
		    bb += "Q ";
		}
		else bb += "_ ";
	    }
	    bb += "\n";
	}
    }

    public boolean toSolve() {

    }

    public int countSolutions() {

    }
}
