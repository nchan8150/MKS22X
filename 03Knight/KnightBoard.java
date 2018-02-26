//learned and inspired by jerry

public class KnightBoard{
    private int [][] board;
    private int[] moveX;
    private int[] moveY;

    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	int[] moveX = new int[]{1,1,2,2,-1,-1,-2,-2};
	int[] moveY = new int[]{2,-2,1,-1,2,-2,1,-1};
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
    
    public boolean solve(int startingRow, int startingCol) {
	if (startingRow < 0 || startingCol < 0) {
	    throw new IllegalArgumentException();
	}
	for(int x = 0; x < board.length; x++) {
	    for(int y = 0; y < board[x].length; y++){
		if(board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return solveH(startingRow, startingCol, 1);
    }

    private boolean solveH(int row, int col, int level) {
	if(board[row].length * board.length == level) {
	    board[row][col] = level;
	    return true;
	}
	for (int x = 0; x < 8; x++) {
	    int newRow = row + moveX[x];
	    int newCol = col + moveY[x];
	    if(board[row][col] == 0 &&
	       newRow >= 0 &&
	       newRow < board.length &&
	       newCol >= 0 &&
	       newCol < board[1].length) {
		board[row][col] = level;
		if(solveH(newRow, newCol, level + 1)) {
		    return true;
		}
		board[row][col] = 0;
	    }
	}
	return false;
    }

    public int countSolutions(int startingRow, int startingCol) {
	if (startingRow < 0 || startingCol < 0) {
	    throw new IllegalArgumentException();
	}
	for(int x = 0; x < board.length; x++) {
	    for(int y = 0; y < board[x].length; y++){
		if(board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return countSolutionsH(startingRow, startingCol, 1);
    }

    public int countSolutionsH (int row, int col, int level) {
	if (board.length * board[1].length == level) {
	    board[row][col] = 0;
	    return 1;
	}
	int total = 0;
	for (int x = 0; x < 8; x++) {
	    int newRow = row + moveX[x];
	    int newCol = col + moveY[x];
	    total += countSolutionsH(newRow, newCol, level + 1);
	}
	board[row][col] = 0;
	return total;
    }
    
    
}
    
