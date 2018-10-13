import java.util.*;

public class Q2{
  public static void main(String[] args){
    int values[];
    values = new int[10];
    Random r = new Random();
    System.out.println("One Method:");
    //One Loop
    for (int i = 0; i<10; i++){
      values[i] = r.nextInt(100)+1;
      System.out.println(values[i]);
    }
    System.out.println("Another Method:");
    //Two Nested Loops
    for (int i = 0; i<10; i++){
      values[i] = r.nextInt(100)+1;
      for (int j = 0; j<i; j++){
        if(values[i]==values[j]){
          i--;
          break;
        }
      }
      System.out.println(values[i]);
    }
  }
  
  /*
   public values (int[][] values){
    Random r = new Random();
    int i = 1;
    int j = 0;
    int[][] values = new int [i][j];
    for (int j; j<10; j++){
    values[1] = r(91)+1;}
    
    Wrong: 1. no need to create int[][]
            2. wrong code of new Random(): r(91)+1
     Points deducted: 0.2
  }
  
  public values (ArrayList() values){
    Random r = new Random();
    int i = 1;
    int j = 0;
    ArrayList values = new ArrayList(10);
    for (int i; i< m.size(); i++){//row
      for (int j; j< m.size(); j++){//col
        values.add(r(101)-50);
      }
      
     Wrong: 1. no need to create ArrayList
            2. i should compare to 10 instead of random number
            3. wrong code of new Random(): r(101)-50)
     Points deducted: 0.3
   */
}