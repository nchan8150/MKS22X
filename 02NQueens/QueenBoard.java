//JAVAC BOTH AND RUN DRIVER THEN GO FROM THERE.

//size 2 and 3 wont work
//negatives wont work
//cant call solve twice bc its not 0 anymore
//put 1 in each coloumn 
//rewrite add and remove lmao
//runtime? how slow is this really

public class QueenBoard {

    private int[][]board;

    public QueenBoard (int size) {
	board = new int[size][size];
    }

    public boolean addQueen(int r, int c) {
	if (board[r][c] != 0) {
	    return false;
	}
	for(int x = r; x < board.length; x++) {
	    board[x][c] += 1;
	}
	for(int y = c; y < board[r].length; y++) {
	    board[r][y] += 1;
	}
	int inc = 0;
	for(int z = r; z < board.length; z++) {
	    board[z][c + inc] += 1;
	    inc += 1;
	}
	board[r][c] = -1;
	return true;
    }

    private boolean removeQueen(int r, int c) {
	if (board[r][c] != -1) {
	    return false;
	}
	
	for(int x = r; x < board.length; x++) {
	    board[x][c] -= 1;
	}
	for(int y = c; y < board[r].length; y++) {
	    board[r][y] -= 1;
	}
	int inc = 0;
	for(int z = r; z < board.length; z++) {
	    board[z][c + inc] -= 1;
	    inc += 1;
	}
	board[r][c] = 0;
	return true;
    }

    public String toString() {
	String bb = "";
	for(int x = 0; x < board.length; x++) {
	    for (int y = 0; y < board[x].length; y++) {
		if (board[x][y] == -1) {
		    bb += "Q ";
		}
		else bb += board[x][y] + " ";// "_ ";
	    }
	    bb += "\n";
	}
	return bb;
    }

    public boolean toSolve() {
	return true;
    }

    public int countSolutions() {
	return 0;
    }
}

/*
solver(int col) {
    if(col is size) {
	base case;
    }
    for(each row) {
	place a queen;
	if (solver(col+1)) {
	    return true;
	}
	else { removeQueen;}
    }
    return false;
}
*/
