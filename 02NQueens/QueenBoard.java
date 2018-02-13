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

    private boolean addQueen(int r, int c) {
	if (board[r][c] != 0) {
	    return false;
	}
	for(int x = r; x < board.length; x++) {
	    board[x][c] += 1;
	}
	for(int y = c; y < board[r].length; y++) {
	    board[r][y] += 1;
	}
	int diagDown = 0;
	for(int z = r; z < board.length && c + diagDown < board.length; z++) {
	    board[z][c + diagDown] += 1;
	    diagDown += 1;
	}
	int diagUp = 0;
	for(int i = r; i >= 0 && c + diagUp < board.length; i--) {
	    board[i][c + diagUp] += 1;
	    diagUp += 1;
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
	int diagDown = 0;
	for(int z = r; z < board.length && c + diagDown < board.length; z++) {
	    board[z][c + diagDown] -= 1;
	    diagDown += 1;
	}
	int diagUp = 0;
	for(int i = r; i >= 0 && c + diagUp < board.length; i--) {
	    board[i][c + diagUp] -= 1;
	    diagUp += 1;
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
		else bb +=  "_ "; //board[x][y] + " ";
	    }
	    bb += "\n";
	}
	return bb;
    }

    public boolean solve() {
	for(int x = 0; x < board.length; x++) {
	    for(int y = 0; y < board[x].length; y++) {
		if(board[x][y] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return solver(0);
    }
    
    public boolean solver(int col) {
	if(col >= board.length) {
	   return true;
	}
	for(int x = 0; x < board.length; x++) {
	    if(addQueen(x, col)) {
		if(solver(col+1)) {
		    return true;
		}
		else {
		    removeQueen(x, col);
		}
	    }
	}
	return false;
    }


    public int countSolutions() {
	for(int x = 0; x < board.length; x++) {
	    for(int y = 0; y < board[x].length; y++) {
		if(board[x][y] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return countSolutionsHelp(0);
    }

    public int countSolutionsHelp(int col) {
	if(col >= board.length) {
	    return 1;
	}
	int total = 0;
	for(int x = 0; x < board.length; x++) {
	    if(addQueen(x, col)) {
		total += countSolutionsHelp(col+1);
		removeQueen(x,col);
	    }
	}
	return total;
    }
    
}


