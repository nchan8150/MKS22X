public class Location implements Comparable<Location>{
    private int x, y;
    private int startDistance;
    private int priority;
    private Location prev;

    public Location(int x, int y, Location previous, int p, int dist){
	   this.x = x;
	   this.y = y;
	   prev = previous;
	   startDistance = dist;
	   priority = p;
    }

    public int getx(){
	   return x;
    }

    public int gety(){
	   return y;
    }

    public Location getprev(){
       return prev;
    }

    public int getpriority(){
	   return priority;
    }

    public int getdist(){
       return startDistance;
    }


    public void setPrev(Location loc){
	   prev = loc;
    }

    public boolean equals(Location loc){
       if (x == loc.getx()){
           return y == loc.gety();
       }
       return false;
    }

    public int compareTo(Location loc){
	   return getpriority() - loc.getpriority();
    }
}