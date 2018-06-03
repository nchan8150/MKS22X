//worked with jerry on this

import java.util.*;

public class Sorts{
    
    public static void radixsort(MyLinkedListImproved<Integer> data){
        if (data.size() == 0){
            return;
        }
        
        MyLinkedListImproved<Integer> list = data;
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] buckets = new MyLinkedListImproved[10];
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] negBuckets = new MyLinkedListImproved[10];
        
        for(int i = 0; i < 10; i++){
            buckets[i] = new MyLinkedListImproved<>();
        }
        
        for(int i = 0; i < 10; i++){
            negBuckets[i] = new MyLinkedListImproved<>();
        }
        
        int cap = 0;
        int digit = 10;
        
        int Pcap = getCap(list.getMax());
//        System.out.println("cap: " + cap);
        int Ncap = getCap(list.getMin());
        if (Pcap > Ncap){
            cap = Pcap;
        }
        else{
            cap = Ncap;
        }
        
        while(cap >= 0){
            
            for(Integer num : list){
                if (num > 0){
                    buckets[num % digit / (digit / 10)].add(num);
                }
                else{
                    negBuckets[num % digit / (digit / 10) + 9].add(num);
                }
            }
        
//            print(buckets);
            list.clear();
        
            for(int i = 0; i < 10; i ++){
                list.extend(negBuckets[i]);
            }
            
            for(int i = 0; i < 10; i ++){
                list.extend(buckets[i]);
            }
        
//            System.out.println("list: "+ list);
//            print(buckets);
            
            digit *= 10;
            cap --;
        }
        
    }
    
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){ 
        radixsort(data);
    }
    
    public static void print(MyLinkedListImproved<Integer>[] data){
        for (int i = 0; i < 10; i++){
            System.out.println("" + i + data[i]);
        }
    }
    
    public static int getCap(Integer n){
        n = Math.abs(n);
        int cap = 0;
        while (n >= 10){
            n = n/10;
            cap++;
        }
        return cap;
    }        
}