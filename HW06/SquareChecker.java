import java.util.ArrayList; 

public class SquareChecker {
  public static void main(String[] args) {
    int[][] m = { {16, 3, 2, 13}, { 5, 10, 11, 8}, {9, 6, 7, 12}, { 4, 15, 14, 1} };
    ArrayList<ArrayList<Integer>> n; // declare n of type ArrayList<ArrayList<Integer>>
    n = new ArrayList<ArrayList<Integer>>(); // allocate an object of type ArrayList<ArrayList<Integer>>
    Object a; // declare a
    a = new Object(); // allocation 
    // declare and allocate a like you did for n just as an example 
    for (int i = 0; i < m.length; i++) { // go through all the lines 
      ArrayList<Integer> row; 
      row = new ArrayList<Integer>(); 
      for (int j = 0; j < m[i].length; j++) {
         row.add(m[i][j]);  
      }
      n.add(row); 
    }
    System.out.println( n ); 
    //boolean test = SquareChecker.isMagicSquare( m ); 
    //System.out.println( "Is your matrix " + SquareChecker.toString(m) + "a magic square? Answer: " + test ); 
    boolean test = SquareChecker.isMagicSquare( n ); 
    System.out.println( "Is your matrix " + SquareChecker.toString(n) + "a magic square? Answer: " + test );
  }
  public static boolean isMagicSquare(ArrayList<ArrayList<Integer>> k) {
      boolean result = true;
      //Check same length of rows/columns
      for (int row = 0; row < k.size() ; row++){
        if (k.get(row).size() != k.size()){
          result = false;
        }
      };
      
     for (int col = 0; col < k.size() ; col++){
        if (k.get(col).size() != k.size()){
          result = false;
        }
      };
     
     //sum of each row/column/diagonal is the same
     if (result = true) {
       int sum1 = 0;
       for (int i = 0;i < k.size(); i++){
         int j;
         j = k.size() - 1 - i;
         sum1 = sum1 + k.get(i).get(j);
       }
     
      //System.out.println(sum1);
      //System.out.println("Expected: 34");//diagonal1 value
      
       int sum2 = 0;
       for (int i = 0;i < k.size(); i++){
         int j;
         j = i;
         sum2 = sum2 + k.get(i).get(j);
       }
     
      //System.out.println(sum2);
      //System.out.println("Expected: 34");//diagonal2 value
      
      if (sum1 != sum2){
        result = false;
      }
      
       for (int row = 0;row < k.size(); row++){
         int sum3 = 0;
         int sum4 = 0;
         for (int col = 0; col < k.size() ; col++){
           sum3 += k.get(row).get(col);
           sum4 += k.get(col).get(row);
         
         }
         if (sum1 != sum3 || sum1 != sum4){
           result = false;
         }
     
      //System.out.println(sum3);
      //System.out.println(sum4);
      //System.out.println("Expected: 34");//row/col value
       }
     }
      
    return result; // so when we start all squares are magic   
  }
  
  /*
  public static boolean isMagicSquare(int[][] m) {

      return true;//return true if square is a magic square, false otherwise
  }
  public static String toString(int[][] m) {
    String result = "\n";
    for (int row = 0; row < m.length; row++) {
      for (int col = 0; col < m[row].length; col++) {
         result = result + String.format( " %2d", m[row][col] );
         // also: https://www.cs.indiana.edu/classes/c212-dgerman/fall2015/backmatter.jpg
      }
      result = result + "\n"; 
    }
    return result; // + "\n";
  }
  */
  
  
  public static String toString(ArrayList<ArrayList<Integer>> whatever) {
    String result = "\n";
    for (int row = 0; row < whatever.size(); row++) {
      for (int col = 0; col < whatever.get(row).size(); col++) {
         result = result + String.format( " %2d", whatever.get(row).get(col) );
         // also: https://www.cs.indiana.edu/classes/c212-dgerman/fall2015/backmatter.jpg
      }
      result = result + "\n"; 
    }
    return result; // + "\n";
  }
}