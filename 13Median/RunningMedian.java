import java.util.*;

public class RunningMedian extends MyHeap{

    private MyHeap<Double> min;
    private MyHeap<Double> max;
    private int size;
    
    public RunningMedian(){
        max = new MyHeap<Double>();
        min = new MyHeap<Double>(false);
        size = 0;
    }


    public int size(){
        return size;
    }


    public double getMedian(){
        if (size() == 0){
            throw new NoSuchElementException();
        }
        if (max.size() > min.size()){
            return max.peek();
        }
        if (min.size() > max.size()){
            return min.peek();
        }
        return (max.peek() + min.peek()) / 2.0;
    }
    
    public void add(double added){
        if (size() == 0 || added > min.peek()){
            min.add(added);
        }
        else{
            max.add(added);
        }
        if (min.size() - max.size() > 1){
            double temp = min.remove();
            max.add(temp);
        }
        if (max.size() - min.size() > 1){
            double temp = max.remove();
            min.add(temp);
        }
        size++;
    }

    /*
    public static void main(String[]args){
    RunningMedian x = new RunningMedian();
    x.add(10);
    x.add(2);
    x.add(10);
    x.add(7);
    x.add(5);
    x.add(13);
    x.add(7);
    System.out.println(x.getMedian());
    }
    */
}
