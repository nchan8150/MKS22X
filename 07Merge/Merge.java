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
	
    public static String toString(int[] data){
	String str = "{";
	for (int i = 0; i < data.length; i++){
	    str += data[i];
	    if (i < data.length -1){
		str += ", ";
	    }
	}
	str += "}";
	return str;
    }
	
	private static final int INCREASE = 0;
    private static final int DECREASE = 1;
    private static final int STANDARD = 2;
    private static final int SMALL_RANGE = 3;
    private static final int EMPTY = 4;

    private static String name(int i){
	if(i==0)return "Increassing";
	if(i==1)return "Decreassing";
	if(i==2)return "Normal Random";
	if(i==3)return "Random with Few Values";
	if(i==4)return "size 0 array";
	return "Error stat array";

    }

    private static int create(int min, int max){
	return min + (int)(Math.random()*(max-min));
    }

    private static int[]makeArray(int size,int type){
	int[]ans =new int[size];
	if(type == STANDARD){
	    for(int i = 0; i < size; i++){
		ans[i]= create(-1000000,1000000);
	    }
	}
	if(type == INCREASE){
	    int current = -5 * size;
	    for(int i = 0; i < size; i++){
		ans[i]= create(current,current + 10);
		current += 10;
	    }
	}
	if(type == DECREASE){
	    int current = 5 * size;
	    for(int i = 0; i < size; i++){
		ans[i]= create(current,current + 10);
		current -= 10;
	    }
	}
	if(type == SMALL_RANGE){
	    for(int i = 0; i < size; i++){
		ans[i]= create(-5,5);
	    }
	}
	if(type == EMPTY){
	    ans = new int[0];
	}
	return ans;
    }

    public static void main(String[]args){
	int[] a = new int[1000000];
	for (int i = 0; i < 1000000; i++){
	    int temp = (int)(Math.random() * 1000000);
	    a[i] = temp;
	}
	mergesort(a);
      
	if(args.length < 2)return;
    
	int size =  Integer.parseInt(args[0]);
	int type =   Integer.parseInt(args[1]);

	int [] start = makeArray(size,type);
	int [] result = Arrays.copyOf(start,start.length);
	Arrays.sort(result);
    
	long startTime = System.currentTimeMillis();
	/*
	 * Test your sort here!
	 */
	long elapsedTime = System.currentTimeMillis() - startTime;
	if(Arrays.equals(start,result)){
	    System.out.println("PASS Case "+name(type)+" array, size:"+size+" "+elapsedTime/1000.0+"sec ");
	}else{
	    System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
	}
    }

  
}
