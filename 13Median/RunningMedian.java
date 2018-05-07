import java.util.*;

public class RunningMedian{

	private int size;
	private MyHeap<Double> max;
	private MyHeap<Double> min;

	public RunningMedian() {
		size = 0;
		max = new MyHeap();
		min = new MyHeap(false);
	}

	public void add (Double added) {
		if(max.size() > min.size() + 1){
            min.add(max.remove());
        }
        else if(size() == 0 || added < min.peek()){
            min.add(added);
        }
        else if(added > min.peek()){
            max.add(added);
        }
        size++;
	}

	public Double getMedian() {
		if(min.size() > max.size()){
            return min.peek();
        }
        else if (min.size() < max.size()){
            return max.peek();
        }
        else{
            return (max.peek() + min.peek())/2;
        }
	}

	public int size() {
		return size;
	}

	public static void main(String[] args){
        RunningMedian test = new RunningMedian();
        test.add(0.);
        test.add(13.);
        test.add(9.);
        test.add(123.);
        test.add(5.);
        test.add(63.);
        test.add(3.);
        test.add(13.);
        test.add(74.);
        test.add(13.);
        
        
        
        
        
        System.out.println(test);
        System.out.println(test.getMedian());
    }	
}
