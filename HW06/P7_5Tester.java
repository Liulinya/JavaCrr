//run this program to test P7_5 Square

public class P7_5Tester
{ 
   public static void main(String [] args)
   {  
      Square newsq = new Square(); 
      public int m [] = [16, 3, 2, 13, 5, 10, 11, 8, 9, 6, 7, 12, 4, 15, 14, 1];
      //int[][] m = { {16, 3, 2, 13}, { 5, 10, 11, 8}, {9, 6, 7, 12}, { 4, 15, 14, 1} };
      newsq.add(m);
      boolean test = newsq.isMagicSqr(); 
      System.out.println( "Is your matrix a magic square?" ); 
      System.out.println("Expected Answer: true");
      System.out.println( "Actual Answer: " + test ); 
   } 
}
