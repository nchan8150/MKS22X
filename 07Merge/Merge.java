import java.util.*;

public class Merge {

    public void mergesort(int[] data) {
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length - 1);
    }

    public void msort(int[]data, int[]temp, int lo, int hi) {
	if(lo < hi) {
	    for(int x = lo; x <= hi; x++) {
		temp[x] = data[x];
	    }
	msort(temp, data, lo, (lo+hi) / 2);
	msort(temp, data, (lo+hi) / 2, hi);
	merge(data, temp, lo, hi);
	}
    }

    public void merge(int[]data) {

    }
}