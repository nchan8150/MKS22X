//help for swapping from Peter

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
    swapUp(size);
    size++;
    }
    
    public T remove() {
        if (size == 0) {
        throw new IllegalStateException();
        }
        T ans = data[0];
        data[0] = data[size-1];
        data[size-1] = null;
        size-=1;
        swapDown(0);

        return ans;
    }

    public T peek() {
        return data[0];
    }
    
    public int size() {
        return size;
    }

    private void swapUp(int ind) {
        int pos = (ind-1)/2;

        while (max && (pos>=0) && (data[ind].compareTo(data[pos]))>0){
            swap(data,pos,ind);
            ind = pos;
            pos = (ind - 1)/2;
        }
        while (!max && (pos>=0) && (data[ind].compareTo(data[pos]))<0){
            swap(data,pos,ind);
            ind = pos;
            pos = (ind - 1)/2;
        }

    }
    
    private void swap(T[] arr, int x, int y) {
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private void swapDown(int ind) {
        int pos1 = 2*ind+1;
        int pos2 = 2*ind+2;
        if (max) {
            if (((pos1 < size) && (data[ind].compareTo(data[pos1]) < 0)) || 
                ((pos2 < size) && (data[ind].compareTo(data[pos2]) < 0))) {
                if (pos2 >= size || data[pos1].compareTo(data[pos2]) > 0) {
                    swap(data,pos1,ind);
                    ind = pos1;
                    swapDown(pos1);
                }
                else if (pos2 < size && data[ind].compareTo(data[pos2]) < 0) {
                    swap(data,pos2,ind);
                    ind = pos2;
                    swapDown(pos2);
                }
            }
        }
        else {
            if ((pos1 < size) && (data[ind].compareTo(data[pos1]) > 0) ||
                (pos2 < size) && (data[ind].compareTo(data[pos2]) > 0)) {
                if (pos2 >= size || data[pos1].compareTo(data[pos2]) < 0) {
                    swap(data,pos1,ind);
                    ind = pos1;
                    swapDown(pos1);
                }
                else if(data[ind].compareTo(data[pos2]) > 0){
                    swap(data,pos2,ind);
                    ind = pos2;
                    swapDown(pos2);
                }
            }
        }
    }
    
    public String toString(){
        String ans = "[";
        for(int x = 0; x < size; x++){
            ans += data[x] + ", ";
        }
        ans += "]";
        return ans;
    }
}
