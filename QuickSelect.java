import java.util.*;

public class QuickSelect {
    public static int partition (int[] data, int start, int end) {
	Random rand = new Random();
	int randPivot = rand(end - start + 1) + start;

	int pivot = data[randPivot];
	/*
	List<Integer> fixed = new ArrayList<Integer>();
	fixed.add(pivot);
	for(int x = 0; x <data.length; x++) {
	}
	*/
	int[] fixed = new int[end - start + 2];
	fixed[fixed.length / 2 + 1] = pivot;
	for(int x = 0; x < data.length; x++) {
	    int index = 0;
	    

    }
    
}
