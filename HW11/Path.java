import java.util.*;

public class Path extends ArrayList<Vertex> {
  public Path() {

  }
  public Path(Vertex v) {
    this.add(v);
  }
  public Path clone() {
    Path a = new Path();
    for (Vertex v : this)
      a.add(v);
    return a;
  }
}