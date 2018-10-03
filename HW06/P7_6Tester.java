//run this program to test P7_6 Magic Square

public class P7_6Tester
{ 
   public static void main(String [] args)
   {  
      P7_6MagicSquareBuilder newsq1 = new P7_6MagicSquareBuilder(3); 
      System.out.println("Expected Answer:\n4 9 2\n3 5 7\n8 1 6");
      System.out.println( "Actual Answer:\n" + newsq1.toString() ); 
      
      P7_6MagicSquareBuilder newsq2 = new P7_6MagicSquareBuilder(5); 
      System.out.println("Expected Answer:\n11 18 25 2 9\n10 12 19 21 3\n4 6 13 20 22\n23 5 7 14 16\n17 24 1 8 15");
      System.out.println( "Actual Answer:\n" + newsq2.toString() ); 
   } 
}
