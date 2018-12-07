import java.util.*;

public class Neighbors extends ArrayList<Vertex> {
  public Neighbors( Vertex[] neighbors ) {
    for (Vertex v : neighbors)
      this.add(v);
  }
  
}