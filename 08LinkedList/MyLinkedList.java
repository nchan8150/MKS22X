public class MyLinkedList {
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

    public int get(int index) {
	return getNode(index).getValue();
    }

    public void set(int index, Integer value) {
	if(index >= length || index < 0) {
	    throw new IndexOutOfBoundsException();
	}
	Node temp = getNode(index);
	temp.setValue(value);
    }

    public int size() {
	return length;
    }

    public boolean add(Integer value){
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

    public void add(int index, Integer value) {
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

    public Integer remove(int index) {
	if (index > length || index < 0) {
	    throw new IndexOutOfBoundsException();
	}

	Node temp = getNode(index);
	Integer removed = temp.getValue();
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

    public boolean remove(Integer value){ 
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

    public int indexOf(Integer value){
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

    public MyLinkedList() {
	first = null;
	last = null;
	length = 0;
    }





    private class Node {
	private Node next, prev;
	private Integer data;

	public Node getNext() {
	    return next;
	}

	public Node getPrev() {
	    return prev;
	}

	public Integer getValue() {
	    return data;
	}

	public void setValue(Integer value) {
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

	private Node(Integer value) {
	    data = value;
	    next = null;
	    prev = null;
	}
    }
}
    
