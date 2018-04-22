import java.util.*;
import java.io.*;

public class Driver{

    public static void main(String[]args){
	try {
	Maze f;
        f = new Maze("data3.dat");//true animates the maze.
        
        f.setAnimate(true);
        f.solve();

        System.out.println(f);
	}
	catch(FileNotFoundException e) {
	    System.out.println("oopsies");
	}
    }
}

