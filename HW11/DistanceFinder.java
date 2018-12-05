// simulate the shortest dist from a city to all other cities
import java.io.*;
import java.util.*;

public class DistanceFinder{
   private String startPt;
   private Map<String, HashSet<DistanceTo>> directConnection;

   public DistanceFinder(String filename) {
      directConnection = new HashMap<String, HashSet<DistanceTo>>();
      try(Scanner in = new Scanner(new File(filename))){
         while (in.hasNext()) {
            String from = in.next();
            String to = in.next();
            int dist = in.nextInt();
            // start from 1st city in 1st line.
            if (startPt == null) {
               startPt = from;}
            if (directConnection.get(from) == null) {
               directConnection.put(from, new HashSet<DistanceTo>());}
            directConnection.get(from).add(new DistanceTo(to, dist));
            if (directConnection.get(to) == null){
               directConnection.put(to, new HashSet<DistanceTo>());}
            directConnection.get(to).add(new DistanceTo(from, dist));
            in.close();
         }}catch(FileNotFoundException e){System.out.println("The file is not reachable.");}
   }

   // return the shortest distance
   public Map<String, Integer> shortestDist() {
      PriorityQueue<DistanceTo> queue = new PriorityQueue<DistanceTo>();
      queue.add(new DistanceTo(startPt, 0));
      Map<String, Integer> shortestKnownDist = new TreeMap<String, Integer>();

      while (queue.size() > 0) {
         DistanceTo newCity = queue.remove();
         String target = newCity.getTarget();
         if (!shortestKnownDist.containsKey(target)) {
            int d = newCity.getDistance();
            shortestKnownDist.put(target, d);
            Set<DistanceTo> neighbors = directConnection.get(target);
            if (neighbors != null) {
               for (DistanceTo neighbor : neighbors) {
                  queue.add(new DistanceTo(neighbor.getTarget(),
                        d + neighbor.getDistance()));}
            }
         }
      }
      return shortestKnownDist;
   }
   
   // return the starting city
   public String getStartingCity() { return startPt;}
}
