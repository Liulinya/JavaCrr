import java.util.*;
import java.io.*;

public class R15_9{
  public static void main(String args[]){
        // Creating an empty HashSet 
        HashSet<String> set1 = new HashSet<String>(); 
        HashSet<String> set2 = new HashSet<String>(); 
  
        // Using add() method to add elements into the Set 
        set1.add("Welcome"); 
        set1.add("To"); 
        set1.add("Geeks"); 
        set2.add("4"); 
        set2.add("Geeks"); 
        HashSet<String> unionSet = Union(set1,set2);
        HashSet<String> intrsctSet = Intersection(set1,set2);
        
        System.out.println("Set 1 is " + set1);
        System.out.println("Set 2 is " + set2);       
        System.out.println("The union set is " + unionSet);
        System.out.println("The intersection set is " + intrsctSet);

    }
  
  public static HashSet<String> Union (HashSet<String> set1, HashSet<String> set2){
    HashSet<String> unionSet = new HashSet<String> ();
    
    // for loop the whole set
    for (String i: set1){
      unionSet.add(i);
      for (String j: set2){
        unionSet.add(j);
      }
    }
    return unionSet;
  }
  
  public static HashSet<String> Intersection (HashSet<String> set1, HashSet<String> set2){
    HashSet<String> intrsctSet = new HashSet<String> ();

    for (String i: set1){
      intrsctSet.add(i);
      for (String j: set2){
        if (!intrsctSet.contains(j)) {
          intrsctSet = new HashSet<String> ();
          intrsctSet.add(j);
        }
      }
    }
    return intrsctSet;
  }
}