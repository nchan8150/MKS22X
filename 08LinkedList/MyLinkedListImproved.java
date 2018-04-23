public class MyLinkedListImproved <T extends Comparable<T>> implements Iterable<T> {
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

    public boolean add(T value) {
      	Node create = new Node(value);
        if (length == 0) {
            first = last = create;
            length = 1;
            return true;
        }
      	last.setNext(create);
      	create.setPrev(last);
      	length ++;
      	last = create;
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

    
    public boolean remove(T value) {
      	int x = indexOf(value);
      	if (x == -1) {
        	return false;
      	}
      	else {
        	remove(x);
        	return true;
      	}
    }

    public int indexOf(T value){
		Node chosen = first;
		for (int x = 0; x < length; x++){
	    	if (chosen.getValue().equals(value)){
				return x;
	    	}
	    	chosen = chosen.getNext();
		}
		return -1;
    }

    private Node getNode(int index){
		if(index >= length || index < 0){
	    	throw new IndexOutOfBoundsException(); 
		}
		Node gotti = first;
		for (int x = 0; x < index; x++){
	    	gotti = gotti.getNext();
		}	
		return gotti;
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

    public int max() {
    	int index = 0;
    	if(length == 0) {
    		return -1;
    	}
    	for (int x = 0; x < length; x++){
    		if (getNode(index).getValue().compareTo(getNode(x).getValue()) < 0) {
    			index = x;
    		}
    	}
    	return index;
    }

    public int min() {
    	int index = 0;
    	if(length == 0) {
    		return -1;
    	}
    	for (int x = 0; x < length; x++){
    		if (getNode(index).getValue().compareTo(getNode(x).getValue()) > 0) {
    			index = x;
    		}
    	}
    	return index;
    }

    public T getMax() {
    	return getNode(max()).getValue();
    } 

    public T getMin() {
    	return getNode(min()).getValue();
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

    private class ImprovedIterator implements Iterator<T> {
    	Node n;

    	public ImprovedIterator (Node n) {
    		this.n = n;
    	}

    	public boolean hasNext() {
    		return n != null;
    	}

    	public T next() {
    		if(!hasNext()) {
    			System.exit(0);
    		}
    		T x = n.getValue();
    		n = n.getNext();
    		return x;
    	}

    	public void remove() {
    		throw new UnsupportedOperationException();
    	}
    }

    public void extend(MyLinkedListImproved<T> list){
    	if(list.size() > 0){
            if(size()>0){
                last.setNext(list.first);
                list.first.setPrev(last);
                last = list.last;
                length += list.size();
                list.clear();
            }
            else{
                first = list.first;
                last = list.last;
                length = list.size();
                list.clear();
            }
        }
    }
}