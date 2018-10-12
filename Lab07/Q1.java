import java.util.*;

public class Q1{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int s = in.nextLine();
    ArrayList a = new ArrayList(s);
    Randome r = new Random();
    //ArrayList(ArrayList(Integer)) m = new ArrayList(ArrayList((a))<>;
    ArrayList<Double> m = new ArrayList<Double>();
    int i = 0;
    int j = 0;
    
    for (int i; i< m.size(); i++){//row
      for (int j; j< m.size(); j++){//col
        a.add(r(101)-50);
      }
    }
    System.out.println(m.toString());
  }
}