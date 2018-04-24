import java.util.*;

public class MyDeque<E> {
	private int front;
	private int back;
	private int size;
	private E[] data;
	
	@SuppressWarnings("unchecked")
	public MyDeque() {
		data = (E[])new Object[10];
	}

	@SuppressWarnings("unchecked")
	public MyDeque(int s) {
		if(s < 0) {
			throw new IllegalArgumentException();
		}
		else{
			data = (E[])new Object[s];;
		}
	}

	public int size() {
		return size;
	}

	public void addFirst(E element){
		if(element == null) {
			throw new NullPointerException();
		}
		if(size == data.length) {
			resize();
		}
		if (size == 0){
	    	data[front] = element;
		}
		else if(front == 0) {
			data[data.length - 1] = element;
			front = data.length - 1;
		}
		else {
			data[front - 1] = element;
			front--;
		}
		size++;
	}
	
	public void addLast(E element){
		if(element == null) {
			throw new NullPointerException();
		}
		if(size == data.length) {
			resize();
		}
		if (size == 0){
	    	data[back] = element;
		}
		else if(back == data.length - 1) {
			data[0] = element;
			back = 0;
		}
		else {
			data[back + 1] = element;
			back++;
		}
		size++;
	}
	
	public E removeFirst(){
		if(size == 0) {
			throw new NoSuchElementException();
		}
		else {
			E temp = data[front];
			data[front] = null;
			if(front == data.length - 1){
	    		front = 0;
	    		size--;
			}
			else{
	    		size--;
	    		front++;
			}
			return temp;	
		}
	}

	public E removeLast(){
		if(size == 0) {
			throw new NoSuchElementException();
		}
		else {
			E temp = data[back];
			data[back] = null;
			if(back == 0) {
				back = data.length - 1;
				size--;
			}
			else {
				back--;
				size--;
			}
			return temp;
		}
	}

	public E getFirst(){
		if(size == 0) {
			throw new NoSuchElementException();
		}
		else {
			return data[front];
		}
	}	

	public E getLast(){
		if(size == 0) {
			throw new NoSuchElementException();
		}
		else {
			return data[back];
		}
	}

//had help with resize from robin
	@SuppressWarnings("unchecked")
	public void resize() {
		E[] tmp = (E[]) new Object[data.length * 2];
		if (back < front){
	    	int ind = 0;
	   		for (int i = front; i < data.length; i++){
				tmp[ind] = data[i];
				ind++;
	    	}
	    	for (int i = 0; i <= back; i++){
				tmp[ind] = data[i];
				ind++;
	    	}
		}
		else {
	    	for (int i = front; i <= back; i++){
				tmp[i] = data[i];
	    	}
		}
		data = tmp;
		front = 0;
		back = size() - 1;
	}
/*
	public String toString() {
		String ans ="";
		String ans2 = "";
		if(front != 0) {
			for(int x = front; x < data.length; x++) {
				ans += data[x] + " ";
			}
			for(int y = 0; y < front; y++) {
				ans2 += data[y] + " ";
			} 	
		}
		else {
			for(int z = front; z < data.length; z++) {
				ans += data[z] + " ";
			}
		}
		return ans + ans2;
	}
*/
	public String toString(){
    String ans = "[";
    if(front < back){
      for (int i = front; i <= back; i++){
        ans += data[i] + " , ";
      }
    }
    else{
      for(int i = front; i < data.length; i++){
        ans += data[i] + ", ";
      }
      for(int i = 0; i <= back; i++){
        ans += data[i] + ", ";
      }
    }
    ans = ans.substring(0, ans.length() - 2) + "]";
    return ans;
  }

//from Crytal
  /*
  public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();

    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 1000);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      System.out.println("MyDeque: " + a1);
      System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }
  }
  */


}
