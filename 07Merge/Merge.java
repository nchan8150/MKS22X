//no idea why I have only 2 passed test cases and 0 failed ones so I asked jerry for help.

import java.util.*;

public class Merge {

    public static void mergesort(int[] data) {
		int[] temp = new int[data.length];
		msort(data, temp, 0, data.length - 1);
    }

    private static void msort(int[]data, int[]temp, int lo, int hi) {
	if(hi - lo <= 2) {
	    insertionSort(data, lo, hi);
	    return;
	}
	for(int x = lo; x <= hi; x++) {
		temp[x] = data[x];
	}
    msort(temp, data, lo, (lo+hi) / 2);
    msort(temp, data, (lo+hi) / 2 + 1, hi);
	merge(data, temp, lo, (lo+hi) / 2, hi);
	}

    public static void merge(int[]data, int[]temp, int lo, int mid, int hi){
        int num1 = lo;
        int num2 = mid + 1;
        int counter = lo;
        while (num1 <= mid && num2 <=   hi){
            if (temp[num1] < temp[num2]){
                data[counter] = temp[num1];
                num1 ++;
            }
            else{
                data[counter] = temp[num2];
                num2++;
            }
            counter ++;
        }
        if (num1 <= mid ){
            for(int x = num1; x <= mid; x++){
                data[counter] = temp[x];
                counter++;
            }
        }
        else{
            for (int y = num2; y <=hi ; y++){
                data[counter] = temp[y];
                counter++;
            }
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

