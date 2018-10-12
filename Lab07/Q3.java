import java.util.*;

public class Q3{
  public static void main(String[] args){
    double max = -Double.MAX_VALUE;
    double min = Double.MAX_VALUE;
    /*
     Code: double max = -Double.Max.Value();
           double min = Double.Max.Value();
     Wrong: typo of method
     Points deducted: 0.1
     */
    Scanner in = new Scanner(System.in);
    int i = 0;
    double sum = 0;
    ArrayList<Double> a = new ArrayList<Double>();
    /*
     Code: ArrayList a = new ArrayList();
     Wrong: no definition inside Arraylist<>
     Points deducted: 0.1
     */
    
    System.out.println("Enter values. Use Q to finish.");
     /*
     Wrong: no process values when sentinel is entered.
     Fixed: add command to use Q to quit
     Points deducted: 0.1
     */
    while (in.hasNextDouble()){
      double value = in.nextDouble();
    /*
     Code: if (double value = in.hasNextLine){
     Wrong: 1. double cannot be converted to boolean
            2. miss quotes after hasNextLine stmt
     Fixed: 1. use nextDouble instead of hasNextLine
            2. add if count > 0 at the end
     Points deducted: 0.2
     */

        /*
        Code: ArrayList a = new ArrayList();
              double sum = 0;
        Wrong: cannot find sum variable in the last if statement
        Fixed: switch double sum at the beginning
        Points deducted: 0.1
        */
        
     /*
     Code: for (int i; i < value.length; i++){
     Wrong: not a statement
     Fixed: while loop
     Points deducted: 0.1
     */
        if (value > max) {
          max = value;}
        if (value < min){
          min = value;}
        i++;
        sum += value;
        a.add(value);
      }
    
    if (i>0){
      double avg = sum/i;
      double range = max - min;
      Collections.sort(a);
      /*
       Code: a.sort();
       Wrong: wrong method for arraylist
       Fixed: use collections instead
       Points deducted: 0.1
       */
      System.out.println("Max: "+max+" , min: "+min+" , average: "+avg+" ,range: "+range);
      System.out.println(a.toString());
    }else {System.out.println("No data.");}
  }
}