import java.util.*;

public class Merge {

    public void mergesort(int[] data) {
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length - 1);
    }

    public void msort(int[]data, int[]temp, int lo, int hi) {
	if(hi - lo < 2) {
	    insertionSort(temp);
	}
	msort(temp, data, lo, (lo+hi) / 2);
	msort(temp, data, (lo+hi) / 2, hi);
	merge(data, temp, lo, hi);
	}

    public void merge(int[]data, int[]temp, int lo, int hi) {
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

    public void insertionSort(int[] data) {
	for(int i = 0; i < data.length; i++) {
	    int key = data[i];
	    int j = i - 1;
	    while( j >= 0 && data[j] > key) {
		data[j + 1] = data[j];
		j = j- 1;
	    }
	    data[j+1] = key;
	}
    }

  
}
