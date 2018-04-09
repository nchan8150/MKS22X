import java.io.*;
import java.util.*;
	
public class USACO {
    public static int bronze(String filename){
	try {
	    File text = new File(filename);	    
	    Scanner input = new Scanner(text);	  
	    int R = input.nextInt();
	    int C = input.nextInt();
	    int E = input.nextInt();
	    int N = input.nextInt();	    
	
	    int[][] lake = new int[R][C];
	    for (int r = 0; r < R; r++){
		for (int c = 0; c < C; c++){
		    lake[r][c] = input.nextInt();
		}
	    }
	
	    for (int n = N; n > 0; n--){
		int R_s = input.nextInt() -1;
		int C_s = input.nextInt() -1;
		int D_s = input.nextInt();
		int[][] cowLocations = new int[][] {
		    {0,0}, {0,1}, {0,2},
		    {1,0}, {1,1}, {1,2},
		    {2,0}, {2,1}, {2,2}
		};
	
		
	
		for (int d = D_s; d > 0; d--){
		    int max = 0;
		    for (int i[]: cowLocations){
			if (lake[R_s + i[0]][C_s + i[1]] > max){
			    max = lake[R_s + i[0]][C_s + i[1]];
			}
		    }
	
		    for (int i[]: cowLocations){
			if (lake[R_s + i[0]][C_s + i[1]] ==  max){
			    lake[R_s + i[0]][C_s + i[1]]--;
			}
		    }
		}		
	    }
	    
	    int totalDepth = 0;
	    for (int r = 0; r < R; r ++){
		for (int c = 0; c < C; c++){
		    if (E > lake[r][c]){
			totalDepth += E - lake[r][c];
		    }
		}
	    }
	    
	    return totalDepth * 72 *72;
	    
	}catch(Exception e){System.exit(1);}
	
	return 0; 
    }



    public static int silver(String filename) throws FileNotFoundException{
	
	File text = new File(filename);
	Scanner inf = new Scanner(text);
	
	int row = inf.nextInt();
	int col = inf.nextInt();
	int steps = inf.nextInt();
		
	inf.nextLine();
		
	char[][] map = new char[row][col];	
	for (int x = 0; x < row; x++) {
	    String line = inf.nextLine();
	    for (int y = 0; y < col; y++){
		map[x][y] = line.charAt(y);
	    }
	}
	
	int startRow = inf.nextInt();
	int startCol = inf.nextInt();
	int endRow = inf.nextInt();
	int endCol = inf.nextInt();
	
	int[][] allPath = new int[row][col];
	allPath[startRow - 1][startCol - 1] = 1;
		
	int CT = 0;
	while (CT < steps){
	    int[][] currentPath = new int[row][col];
	    for (int x = 0; x < row; x++){
		for (int y = 0; y < col; y++){
		    if (map[x][y] != '*'){
			if ((x+1) < row){
			    currentPath[x][y] = currentPath[x][y] + allPath[x+1][y];
			}
			if ((x-1) >= 0){
			    currentPath[x][y] = currentPath[x][y] + allPath[x-1][y];
			}
			if ((y+1) < col){
			    currentPath[x][y] = currentPath[x][y] + allPath[x][y+1];
			}
			if ((y-1) >= 0){
			    currentPath[x][y] = currentPath[x][y] + allPath[x][y-1];
			}
		    }
		}
	    }
	    for (int x = 0; x < row; x++){
		for (int y = 0; y < col; y++){
		    allPath[x][y] = currentPath[x][y];
		}
	    }
		
	    CT = CT + 1;
	}
	
	return allPath[endRow - 1][endCol - 1];
    }
}
		   
