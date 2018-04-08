//some help from jerry

import java.util.*;

public class Quick{

    public static int quickselect(int[] data, int k) {
	int start = 0;
	int end = data.length - 1;
	int[]temp = partition(data, start, end);
	int low = temp[0];
	int high = temp[1];
	while(k < low || k > high) {
	    if(k < low) {
		end = low - 1;
	    }
	    else {
		start = high;
	    }
	    temp = partition(data, start, end);
	    low = temp[0];
	    high = temp[1];
	}
	return data[low];
    }
	    
    public static int[] partition(int[] arr, int low, int high){
        int pivotIndex = (int)(Math.random() * (high - low) + low);
	int pivot = arr[pivotIndex];
	swap(arr, low, pivot);
	int lt = low;
	int i = lt + 1;
	int gt = high;
	while (i <= gt) {
	    if(arr[i] <= pivot) {
		swap(arr, i, lt);
		i++;
		lt++;
	    }
	    else if (arr[i] == pivot) {
		i++;
	    }
	    else if (arr[i] > pivot) {
		swap(arr, i, gt);
		gt--;
	    }
	}
	return new int[] {lt, i};		
    }
       
    public static void quicksort (int[] data) {
        quicksorter(data, 0, data.length - 1);
    }

    public static void quicksorter (int[] data, int start, int end) {
	if (start < end) {
	    int[] temp = partition(data, start, end);
	    quicksorter(data, start, temp[0]);
	    quicksorter(data, temp[1], end);
	}
    }
    
    private static void swap(int[]arr, int x, int y) {
	int i = arr[x];
	arr[x] = arr[y];
	arr[y] = i;
    }
    
    
    
}
