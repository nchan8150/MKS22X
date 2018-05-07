import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{

	private T[] data;
	private boolean max;
	private int size; 

    public MyHeap() {
    	data = (T[]) new Comparable[10];
		max = true;
		size = 0;
    }

    public MyHeap(boolean type){
    	data = (T[]) new Comparable[10];
		max = type;
		size = 0;
	}

    public void add (T s) {
    	if(data.length == size){
    		T[] temp = (T[]) new Comparable[2 * size];
			for (int x = 0; x < data.length; x++) {
				temp[x] = data[x];
			}
			data = temp;
    	}
    	data[size] = s;
   		swapUp(s, size);
   		size++;
    }

    public T remove() {
    	if (size == 0) {
			throw new IllegalStateException();
		}
		T removed = data[0];
		data[0] = data[size-1];
		swapDown(data[size-1],0);
		data[size-1] = null;
		size --;
		return removed;
	}

    public T peak() {
    	return data[0];
    }

    public int size() {
    	return size;
    }

    public void swapUp(T s, int index) {
    	if(max == true) {
    		if(s.compareTo(data[(index - 1) / 2]) > 0) {
    			swap(data, (index - 1) / 2, index);
    			swapUp(s, (index - 1) / 2);
    		}
    	}
    	else if(max == false) { 
    		if(s.compareTo(data[(index - 1) / 2]) < 0) {
    			swap(data, (index - 1) / 2, index);
    			swapUp(s, (index - 1) / 2);
    		}
    	}
    }

    public void swapDown(T s, int index) {
    	if(max == true) {
    		if(s.compareTo(data[2 * index + 2]) < 0 && data[2 * index + 2].compareTo(data[2 * index + 1]) > 0) {
    			swap(data, index, 2 * index + 2);
    			swapDown(s, 2 * index + 2);
    		}
    		else if(s.compareTo(data[2 * index + 1]) < 0 && data[2 * index + 1].compareTo(data[2 * index + 2]) > 0) {
    			swap(data, index, 2 * index + 1);
    			swapDown(s, 2 * index + 1);
    		}
    	}
    	else if (max == false) {
    		if(s.compareTo(data[2 * index + 2]) > 0 && data[2 * index + 2].compareTo(data[2 * index + 1]) < 0) {
    			swap(data, index, 2 * index + 2);
    			swapDown(s, 2 * index + 2);
    		}
    		else if(s.compareTo(data[2 * index + 1]) > 0 && data[2 * index + 1].compareTo(data[2 * index + 2]) < 0) {
    			swap(data, index, 2 * index + 1);
    			swapDown(s, 2 * index + 1);
    		}
    	} 
    }

    private void swap(T[] arr, int x, int y) {
		T temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

}
