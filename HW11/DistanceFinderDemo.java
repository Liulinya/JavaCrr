import java.util.*;

public class DistanceFinderDemo{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      System.out.print("File with city names: ");
      String f = in.nextLine();
      DistanceFinder d = new DistanceFinder(f);
      System.out.println("Shortest distance from " + d.getStartingCity());
      System.out.println(d.shortestDist());
      in.close();
   }
}
