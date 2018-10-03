//Calculated a magic square based on particular algorithm
import java.util.ArrayList;

public class P7_6ArrayListsBuilder
{
  public static void main(String[] args)
   {  
     int size = 5;//test 5*5 magic square
     ArrayList<ArrayList<Integer>> mySquare = new ArrayList<ArrayList<Integer>>();
     
      if (size % 2 == 1)
      {  //add 0 to arraylist    
         for (int line = 0; line < size; line++) {
           ArrayList<Integer> row = new ArrayList<Integer>(); 
           for (int column = 0; column < size; column++) {
             row.add(0);  
           }
           mySquare.add(row); 
         }
      }
         else{
         System.out.println("Size must be odd." );
   }
      //set row & column
      int i = size - 1;
      int j = size / 2;
      int previ = i;
      int prevj = j;
      
      //for k = 1 ... n*n
      for (int k = 0; k < size * size ; k++)
      {           
         //place k at [rowi][columnj]
         mySquare.get(i).set(j,k+1);
         previ = i;
         prevj = j;
         //increment row and column
         i = (i + 1) % size;
         j = (j + 1) % size;
         
         //if the row or column is n, replace it with 0
         
         if (mySquare.get(i).get(j) != 0)
         {//set row & column to their previous values
            i = previ;
            j = prevj;
            i--;//decrement row
         }
      }
      
      System.out.println("Expected Answer:\n11 18 25 2 9\n10 12 19 21 3\n4 6 13 20 22\n23 5 7 14 16\n17 24 1 8 15");
      System.out.println("Actual Answer:");
      P7_6ArrayListsBuilder.show(mySquare);
  }
  
  public static void show(ArrayList<ArrayList<Integer>> mySquare) {
    for (ArrayList<Integer> row : mySquare)
      System.out.println( row ); 
  }
}
