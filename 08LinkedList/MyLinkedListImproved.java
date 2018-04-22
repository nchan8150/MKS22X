public class MyLinkedListImproved <T extends Comparable<T>> {
    private Node first, last;
    private int length;

    public String toString() {
	String ans = "[";
	Node temp = first;
	while(temp != null) {
	    ans += temp;
	    if(temp.getNext() != null) {
		ans += ", ";
	    }
	    temp = temp.getNext();
	}
	ans += "]";
	return ans;
    }

    public T get(int index) {
	return getNode(index).getValue();
    }

    public void set(int index, T value) {
	if(index >= length || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	Node temp = getNode(index);
	temp.setValue(value);
    }

    public int size() {
	return length;
    }

    public boolean add(T value){
	Node create = new Node(value);
	if (length == 0){
	    first = create;
	}	
	else{
	    last.setNext(create);
	    create.setPrev(last);			
	}		
	last = create;
	length++;
	return true;
    }

    public void add(int index, T value) {
	Node created = new Node(value);
	if(index > length || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	else if(index == length) {
	    add(value);
	    return;
	}
	else if (index == 0) {
	    first.setPrev(created);
	    created.setNext(first);
	    first = created;
	}
	else {
	    created.setNext(getNode(index));
	    created.setPrev(created.getNext().getPrev());
	    created.getNext().setPrev(created);
	    created.getPrev().setNext(created);
	}
	length++;
	
    }

    public T remove(int index) {
	if (index > length || index < 0) {
	    throw new IndexOutOfBoundsException();
	}

	Node temp = getNode(index);
	T removed = temp.getValue();
		if (index == 0){
		first = first.getNext();
		first.setPrev(null);
		}	
		else if (index == length -1){
		last = last.getPrev();
		last.setNext(null);
		}
		else{
		temp.getPrev().setNext(temp.getNext());
		temp.getNext().setPrev(temp.getPrev());	
		}		
		length--;
		return removed;
    }

    public boolean remove(T value){ 
	Node temp = first;
	for (int x = 0; x < length; x++){
	    if(temp.getValue().equals(value)){
		remove(x);
		return true;
	    }
	    temp = temp.getNext();
	}	
	return false;
    }

    public int indexOf(T value){
	Node temp = first;
	for (int x = 0; x < length; x++){
	    if (temp.getValue().equals(value)){
		return x;
	    }
	    temp = temp.getNext();
	}
	return -1;
    }

    private Node getNode(int index){
	if(index >= length || index < 0){
	    throw new IndexOutOfBoundsException(); 
	}
	
	Node temp = first;
	for (int x = 0; x < index; x++){
	    temp = temp.getNext();
	}
		
	return temp;
    }

    public void clear() {
	first = null;
	last = null;
	length = 0;
    }

    public MyLinkedListImproved() {
	first = null;
	last = null;
	length = 0;
    }





    private class Node {
	private Node next, prev;
	private T data;

	public Node getNext() {
	    return next;
	}

	public Node getPrev() {
	    return prev;
	}

	public T getValue() {
	    return data;
	}

	public void setValue(T value) {
	    data = value;
	}

	public void setNext(Node newN) {
	    next = newN;
	}

	public void setPrev(Node newN) {
	    prev = newN;
	}

	public String toString() {
	    return data + "";
	}

	private Node(T value) {
	    data = value;
	    next = null;
	    prev = null;
	}
    }




    public class Sorts {
	public void radixsort(MyLinkedList<T> data) {

	}
    }
}
    
