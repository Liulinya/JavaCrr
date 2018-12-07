public class CityTester {
  public static void main(String[] args) {
    Graph a = new United();
    Path p1 = a.shortestPath(new Vertex("los angeles"), new Paths(new Path(new Vertex("montreal"))));
    System.out.println( "Shortest path from \"los angeles\" to \"montreal\" is ");
    System.out.println( p1 );
    Path p2 = a.shortestPath(new Vertex("los angeles"), new Paths(new Path(new Vertex("toronto"))));
    System.out.println(  );
    System.out.println( "Shortest path from \"los angeles\" to \"toronto\" is ");
    System.out.println( p2 );
  }
}