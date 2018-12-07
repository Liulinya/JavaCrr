import java.util.*; 

public class Vertex {
  String name;
  public Vertex(String name) {
    this.name = name;
  }
  public String toString() {
    return this.name;
  }
  public int hashCode() { 
    return this.name.hashCode(); 
  }
  public boolean equals(Object v)  { 
    if (v instanceof Vertex) 
      return this.name.equals(((Vertex)v).name);
    else 
      return false;
  }
  public static void main(String[] args) { // some unit testing for good measure
    Map<Vertex, String> a = new HashMap<Vertex, String>(); 
    a = new HashMap<Vertex, String>();
    a.put(new Vertex("san francisco"), "something"); 
    a.put(new Vertex("san francisco"), "something else"); 
    System.out.println( a ); 
    Vertex b = new Vertex("san francisco"); 
    Vertex c = new Vertex("san francisco"); 
    System.out.println(b.hashCode()); 
    System.out.println(c.hashCode()); 
    System.out.println(b.equals(c)); 
    System.out.println(a.get(b)); 
    System.out.println(a.get(c)); 
  }
}