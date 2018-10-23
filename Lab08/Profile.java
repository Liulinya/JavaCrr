import java.io.*;
import java.util.*;
import java.lang.*;
     
public class Profile implements Comparable<Profile>{
     private String name;
     private int voteCount;
  
     public Profile(String name, int voteCount) {
       this.name = name;
       this.voteCount = voteCount;
     }
  
    public int compareTo(Profile other) {
       //this.compareTo(other) returns 1 if this is larger than other
       //returns 0 if the objects are equal 
      //returns -1 if this is less than other
         if(this.voteCount > other.voteCount) {return 1;} 
         else if(this.voteCount < other.voteCount) {return -1;} 
         else {return 0;}
      }
    
    public String toString(){
      return name + "=" + voteCount;
    }
  public static void main(String[] args) throws FileNotFoundException, IOException{
  
    //Declared file object with the relative file path (Note: file must be in project directory)
    File f = new File("Candidate.txt");
    
    //Declare a scanner object, sending the file object to the Scanner's constructor
    Scanner in = new Scanner(f);

    /*public static void main(String[] args) throws NullPointerException{
    String sizeStr = System.console().readLine();
    Integer size = Integer.parseInt(sizeStr);
    sizeStr = null;*/
    
    Map<String, Integer> candtxt = new HashMap<String, Integer>();
    
    //Iterate through every line in the file
    while(in.hasNextLine()) {
      //Grabbing the next line in the file
      String line = in.nextLine();
      
      //Seperates each word in line using whitespace as the the delimiter
      String[] names = line.split(" ");
      
      Integer voteCount = null;
      //Displays every name in the current line
      for(String name: names) {
        //Getting the value that corresponds to the key word in the map wordCount
        voteCount = candtxt.get(name);
        
        //If value != null, this means that this key already exists in wordCount
        //In this case, we update the count (value) by one 
        //Otherwise, the key does not exist in the map
        //So put it into the map with count(value) 1
        if(voteCount != null) {
          candtxt.put(name, voteCount+1);
        } else {
          candtxt.put(name, 1);
        }
      }
    }
    
    /*/Print formatted key to value
    for(String key : candtxt.keySet()) {
      Integer value = candtxt.get(key);
      System.out.printf("%s = %d\n", key, value); 
    }
    
    in.close();*/
    
    
  
    ArrayList<Profile> candidates = new ArrayList<Profile>();

   //link ArrayList to HashMap
   for(String key : candtxt.keySet()) {
     int value = candtxt.get(key);
     if (value != 95){
      Profile cand = new Profile (key,value);
      candidates.add(cand);}
   }
   
    while (true) { 
    System.out.println("Optional desired size of results to input...");
    Scanner n = new Scanner(System.in);
    String sizeStr = n.nextLine();

   //sort
   Collections.sort(candidates);
   int count = 1;
   try{
     int size = Integer.parseInt(sizeStr);
     
     for(int i=0; i< size; i++){
       System.out.println(count + ". " + candidates.get(i));
       ++count;
     }
         n.close();
        break;
      } catch (Exception e) {
        System.out.println("You didn't input any valid integer. So the whole vote result is:"); 
    for (Profile s : candidates){
      System.out.println(count + ". " + s);
      ++count;
   }
   }
       }
  }
}