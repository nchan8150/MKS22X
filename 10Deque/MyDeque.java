import java.util.*;

public class MyDeque<E> {
	private int front;
	private int back;
	private int size;
	private E[] data;
	
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
		if(element = null) {
			throw new NullPointerException();
		}
		else if(size == data.length) {
			resize();
		}
		else {
			if(front == 0) {
				data[data.length - 1] = element;
				front = data.length - 1;
			}
			else {
				data[front - 1] = element;
				front--;
			}
		}
	}
	
	public void addLast(E element){
		if(element = null) {
			throw new NullPointerException();
		}
		else if(size == data.length) {
			resize();
		}
		else {
			if(end == data.length - 1) {
				data[0] = element;
				back = 0;
			}
			else {
				data[back + 1] = element;
				back++;
			}
		}
	}
	
	public E removeFirst(){
		if(size == 0) {
			throw new NoSuchElementException();
		}
		else {
			E temp = data[front];
			data[front] = null;
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

	 @SuppressWarnings("unchecked")
	public void resize() {

	}

	public String toString() {
		String ans ="";
		for(int x = front; x < data.length; x++) {
			
		} 
	}


}
