import java.util.*;

public class Graph extends HashMap<Vertex, Neighbors> {
  public void show() {
    for (Vertex v : this.keySet())
      System.out.println( v + ":" + this.get(v) ); 
    System.out.println("---"); 
  }
  public Neighbors neighborsOf(Vertex v) {
    return this.get(v);
  }
  public Path shortestPath(Vertex stop, Paths candidates) {
    // System.out.println("Candidates: " + candidates); 
    if (candidates == null) return null;
    else if (candidates.size() == 0) return new Path();
    else {
      for (Path candidate : candidates)
        if (candidate.get(candidate.size() - 1).equals(stop))
          return candidate;
      Paths newSet = new Paths();
      for (Path c : candidates) {
        // if (neighborsOf(c.get(c.size() - 1)) == null) { 
         // System.out.println( c.get(c.size() - 1) + " is a dead end so I give that up... " ); 
        //} else { 
          for (Vertex v : neighborsOf( c.get(c.size() - 1) ) ) {
            Path clone = c.clone();
            if (clone.contains(v)) {
              
            } else {
              clone.add(v);
              newSet.add(clone);
            }
          }      
        }
      //}
      return shortestPath(stop, newSet);
    }
  }
}