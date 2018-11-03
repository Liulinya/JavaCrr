import java.util.*;
import java.io.*;

public class R15_8{
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
    
    // Setting the ListIterator at a specified position 
    Iterator iter1 = set1.iterator(); 
    Iterator iter2 = set2.iterator(); 
    
    // Iterating through the created list from the position 
    while(iter1.hasNext()){ 
      unionSet.add((String)iter1.next());
      while(iter2.hasNext()){
        unionSet.add((String)iter2.next());
      }
    }
    return unionSet;
  }
  
  public static HashSet<String> Intersection (HashSet<String> set1, HashSet<String> set2){
    HashSet<String> intrsctSet = new HashSet<String> ();
    
    // Setting the ListIterator at a specified position 
    Iterator iter1 = set1.iterator(); 
    Iterator iter2 = set2.iterator(); 
    
    // Iterating through the created list from the position
    try {
    while(iter1.hasNext()){ 
      intrsctSet.add((String)iter1.next());
      while(iter2.hasNext()){
        if (intrsctSet.contains((String)iter2.next())) {
          intrsctSet.remove((String)iter2.next());
        }
      }
    }
    }catch(
           NoSuchElementException e){}
    return intrsctSet;
  }
}