public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> locations;

    public boolean hasNext(){
        return locations.size() > 0;
    }

    public Location next(){
        return locations.remove();
    }

    public void add(Location l){
        locations.add(l);
    }

    public FrontierPriorityQueue(){
        locations = new MyHeap<Location>(false);
    }
}