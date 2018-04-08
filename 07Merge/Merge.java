import java.util.*;

public class Merge {

    public static void mergesort(int[] data) {
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length - 1);
    }

    private static void msort(int[]data, int[]temp, int lo, int hi) {
	if(hi - lo < 11) {
	    insertionSort(data, lo, hi);
	}
	else {
	    for(int x = lo; x <= hi; x++) {
		temp[x] = data[x];
	    }
	    msort(temp, data, lo, (lo+hi) / 2);
	    msort(temp, data, (lo+hi) / 2 + 1, hi);
	    merge(data, temp, lo, hi);
	}
    }

    public static void merge(int[]data, int[]temp, int lo, int hi) {
	int first = lo;
	int next = ((lo + hi) / 2) + 1;
	for (int x = lo; x <= hi; x++) {
	    if(first > (lo + hi) / 2) {
		temp[x] = data[next];
		next++;
	    }
	    else if (next <= hi) {
		if(data[first] < data[next]) {
		    temp[x] = data[first];
		    first++;
		}
		else{
		    temp[x] = data[first];
		    next++;			 
		}
	    }
	    else{
		temp[x] = data[first];
		first++;
	    }
	}
	for (int y = lo; y < hi; y++) {
	    data[y] = temp[y];
	}
	    
    }

    public static void insertionSort(int[] data, int lo, int hi){
	int i;
	for(int x = lo; x < hi + 1; i++) {
	    int key = data[x];
	    for(i = x; i > lo && key < data[i -1]; i--) {
	    
		data[i] = data[i - 1];
  
	    }
	    data[i] = key;
	}
    }
    /*	
    public static void main(String[]args){
        int[] tester = {2,4,6,1,2,2,5,6,8};
        int[] temp = {0,0,0,0,0,0,0,0,0};
        //merge(tester,temp,0, 9/2,9);
        //print(temp);
        mergesort(tester);
        System.out.println(tester);
        
    }
    */

  
}
