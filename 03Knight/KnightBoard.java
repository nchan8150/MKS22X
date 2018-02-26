public class KnightBoard{
    private int [][] board;

    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];

    }

    public String toString() {
	String ans = "";
	for(int x = 0; x < board.length; x++) {
	    for(int y = 0; y < board[x].length; y++){
		if(board[x][y] == 0){
		    ans+= " _ ";
		}
		else {
		    if(board[x][y] < 10) {
			ans += " "+board[x][y]+" ";
		    }
		    else {
			ans += board[x][y] + " ";
		    }
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
    /*
    public boolean solve(int startingRow, int startingCol) {
	return true;
    }

    public boolean countSolutions(int startingRow, int startingCol) {
	return true;
    }

    private boolean solveH(int row, int col, int level) {
	return true;
    }
    */
    
}
    
