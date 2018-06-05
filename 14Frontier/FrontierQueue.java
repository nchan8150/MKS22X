import java.util.*;

public class FrontierQueue implements Frontier{

    private LinkedList<Location> locations;

     public boolean hasNext(){
       return locations.peek() != null;
    }

    public Location next(){
       return locations.remove();
    }

    public void add(Location n){
       locations.add(n);
    }

    public FrontierQueue(){
	   locations = new LinkedList<Location>();
    }
   
}