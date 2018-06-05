public class MazeSolver{
  private Maze maze;
  private Frontier frontier;

  public MazeSolver(String mazeText){
    maze = new Maze(mazeText);
  }

  //Default to BFS
  public boolean solve(){ 
    return solve(0); 
  }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
    //initialize your frontier
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
    if (mode == 0){
      frontier = new FrontierQueue();
    }
    if (mode == 1){
      frontier = new FrontierStack();
    }
    if (mode == 2){
      frontier = new FrontierPriorityQueue();
    }
    else{
      frontier = new FrontierPriorityQueue();
      maze.setAStar(true);
    }
    frontier.add(maze.getStart());
    while (frontier.hasNext()){
      Location n = frontier.next();
      if (!(n.equals(maze.getStart()))){
        maze.set(n.getx(), n.gety(), '.');
      }
      Location[] locs = maze.getNeighbors(n);
      for (Location l : locs){
        if (l != null){
          if (l.equals(maze.getEnd())){
            while (!(n.equals(maze.getStart()))){
              maze.set(n.getx(), n.gety(), '@');
              n = n.getprev();
            }
          return true;
          }
          frontier.add(l);
          maze.set(l.getx(), l.gety(), '?');
        }
      }
    }
    return false;
  }

  public String toString(){
    return maze.toString();
  }
}