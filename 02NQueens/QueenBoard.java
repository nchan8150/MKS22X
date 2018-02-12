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
