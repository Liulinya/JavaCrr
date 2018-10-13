import java.util.*;

public class Q1{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
    /*
     Code: 1. ArrayList a = new ArrayList(s);
              ArrayList(ArrayList(Integer)) m = new ArrayList(ArrayList((a))<>;
           2. Random r = new Random();
     Wrong: 1. typo of ArrayList definition
               should create matrix not
            2. confused Math.random() with new Random()
     Points deducted: 0.2
     */
    
    for (int line = 0; line < s; line++){
      ArrayList<Integer> row = new ArrayList<Integer>();
      for (int col = 0; col < s; col++){
        row.add(0);
        }
      a.add(row);
      }
     /*
     Wrong: didn't create a for loop for ArrayList and add method correctly
     Points deducted: 0.2
     */
    
    for (int i = 0; i < s; i++){
      for (int j = 0; j < s; j++){
        a.get(i).set(j,(int)(Math.random()*100-50));
     /*
     Code: 1. for (int i; i< m.size(); i++){//row
              for (int j; j< m.size(); j++){//col
           2. a.add(r(101)-50);
     Wrong: 1. integer doesn't have size() method
            2. confused Math.random() with new Random() <mistake mentioned before>
     Points deducted: 0.1
     */
      }
    }
    System.out.println(Q1.toString(a));
    /*
     Code: System.out.println(m.toString());
     Wrong: typo of toString method
     Points deducted: 0.1
     */
  }
  
  public static String toString(ArrayList<ArrayList<Integer>> whatever) {
    String result = "\n";
    for (int row = 0; row < whatever.size(); row++) {
      for (int col = 0; col < whatever.get(row).size(); col++) {
         result = result + String.format( " %3d", whatever.get(row).get(col) );
      }
      result = result + "\n"; 
    }
    return result; // + "\n";
  }
  /*
     Wrong: forgot to define toString method
     Points deducted: 0.2
  */
}