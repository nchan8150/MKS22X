import java.util.*;

public class QuickSelect {
    public static int partition (int[] data, int start, int end) {
	Random rand = new Random();
	int indexPivot = rand(end - start + 1) + start;

	int pivot = data[randPivot];
	
        swap(data, 0, indexPivot);
	while( end > start) {
	    if(data[start] < pivot) {
		start++;
	    }
	    else {
		swap(data, start, end);
		end--;
	    }
	}

	swap(data, 0, end);
	return end;
    }

    public static int quickselect(int[] data, int k) {
	if(data[k] < pivot) {
	    partition(0,pivot)
    }

    public static void swap (int[] ary, int a, int b) {
	int c = ary[a];
	ary[a] = ary[b];
	ary[b] = c;
    }  
    
}
