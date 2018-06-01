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

    public static void insertionsort(int[] data, int lo, int hi){ 
        int ind;
        for (int i = lo; i < hi+1; i ++) {
            int k = data[i];
            for (ind = i; ind > lo && k < data[ind-1]; ind --) {
                data[ind] = data[ind-1];
            }
            data[ind] = k;
        }    
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
		if (end - start <= 2){
	    	insertionsort(data, start, end);
		}
		else{ int[] pivot = partitionD(data, start, end);
            quicksorter(data, start, pivot[0]);
           	quicksorter(data, pivot[1], end);
        }
	}

    private static void swap(int[]arr, int x, int y) {
	int i = arr[x];
	arr[x] = arr[y];
	arr[y] = i;
    }

    public static int[] partitionD(int[]data, int low, int hi){
        int pivot = (int) (Math.random() * (hi - low)) + low; 
        int pivoter = data[pivot];
        swap (data,low,pivot);
        int lt = low;
        int gt = hi;
        int i = lt + 1;
        while(i <= gt){
            if (data[i] < pivoter){
                swap(data,i,lt);
                i ++;
                lt++;
            }
            else if (data[i] == pivoter){
                i++;
            }
            else if (data[i] > pivoter){
                swap(data,i,gt);
                gt--;
            }
        }
        return new int[] {lt, i};
    }
    
    
    
}
