import java.util.*;

public class FrontierStack implements Frontier{
    private Stack<Location> locations;

    public void add(Location n){
        locations.push(n);
    }

    public boolean hasNext(){
        return locations.size() != 0;
    }

    public Location next(){
	   return locations.pop();
    }

    public FrontierStack(){
        locations = new Stack<Location>();
    }

}