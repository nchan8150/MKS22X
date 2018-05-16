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
    /*
    private void swapUp(T s, int index){
	swap(i, (i-1)/2);
    }
    
    private void swapDown(T s, int index){
        swap(i, 2*i + 1);
    }
    
    private void pushDownRight(int i){
        swap(i, 2*i + 2);
    }
    */
    
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
    
    public String toString(){
	String ans = "[";
	for(int x = 0; x < size; x++){
	    	ans += data[x] + ", ";
	}
	ans += "]";
	return ans;
    }
    
    public static void main(String[]args){
	MyHeap<String> test = new MyHeap<>(true);
	test.add("0");
	test.add("1");
	test.add("5");
	test.add("8");
	test.add("2");
	test.add("1");  
	test.add("0");
	test.add("1");
	test.add("5");
	test.add("8");
	test.add("2");
	test.add("1");  
	test.add("0");
	test.add("1");
	test.add("5");
	test.add("8");
	test.add("2");
	test.add("1");  
	for(int i = 10; i > 0; i--){
	    test.remove();
	}
	System.out.println(test);
    }
    /*
    public static void main(String[] args){
	MyHeap<Integer> heap = new MyHeap<>();
	for(int i = 0; i < 15; i++){
	    heap.add((int)(i*Math.random()*10));
	}
	System.out.println(heap);
	heap.remove();
	System.out.println(heap);
	
	heap.remove();
	System.out.println(heap);
	
	heap.remove();
	
	System.out.println(heap);
    }
    */   
}
