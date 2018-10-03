//Calculated a magic square based on particular algorithm
import java.util.Scanner;

public class P7_6MagicSquareBuilder
{  
   private int[][] square;
   private int size;

   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.print("Enter size of the square (must be odd): ");
      int size = in.nextInt();

      if (size % 2 == 1)
      {  
         MagicSquare mySquare = new MagicSquare(size);         
         System.out.println(mySquare.toString());
      }
      else
         System.out.println("Size must be odd." );
   }
   
   //Construct a MagicSquare object
      public P7_6MagicSquareBuilder(int n)//n: size of the square, must be odd
     {size = n;
      square = new int[size][size];

      for (int i = 0; i < size ; i++)//i is row
         for (int j = 0; j < size ; j++)//j is column
            square[i][j] = 0;

      int i = size - 1;
      int j = size / 2;
      int previ = i;
      int prevj = j;
      
      //for k = 1 ... n*n
      for (int k = 0; k < size * size ; k++)
      {           
         //place k at [row][column]
         square[i][j] = k + 1;
         previ = i;
         prevj = j;
         //increment row and column
         i = (i + 1) % size;
         j = (j + 1) % size;
         
         //if the row or column is n, replace it with 0
         
         if (square[i][j] != 0)
         {//set row & column to their previous values
            i = previ;
            j = prevj;
            i--;//decrement row
         }
      }
   }

   //Return a string demonstration of square
   public String toString()
   {        
      String r = "";
      for (int i = 0; i < size ; i++)
      {
        for (int j = 0; j < size ; j++)
            r = r + String.format("%4d", square[i][j]);
         r = r + "\n";
      }
      return r;//return a string of the square
   }
}
