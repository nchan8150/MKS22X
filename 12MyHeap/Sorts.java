import java.util.*;

public class Sorts extends MyHeap{

    public static void heapsort(int[] data){
		MyHeap<Integer> heap = new MyHeap<Integer>(false);
		for (int x = 0; x < data.length; x++){
	    	heap.add(data[x]);
		}
		for (int x = 0; x < data.length; x++){
	    	data[x] = heap.peek();
	    	heap.remove();
		}
    }
/*
    public static void main(String[] args){
    	int[] reg = new int[25];
    	int[] heap = new int[25];

    	for(int i = 0; i < 25; i ++){
      		int temp = (int)(Math.random() * 1000);
      		reg[i] = temp;
      		heap[i] = temp;
    	}

    	Arrays.sort(reg);
    	Sorts.heapsort(heap);

    	for(int i = 0; i < 25; i++){
      		if(reg[i] != heap[i]){
        		System.out.println("There is an error at index " + i);
        		System.out.println("reg: " + Arrays.toString(reg));
        		System.out.println("hea: " + Arrays.toString(heap));
      		}
    	}
  	}
  	*/
}