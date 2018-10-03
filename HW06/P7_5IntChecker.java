/*
   A magic square is am m x m matrix which
   the sum of the elements in each row/column/2 diagonals are equal
*/

import java.util.ArrayList;
import java.util.Scanner;

public class P7_5IntChecker
{
   private ArrayList<Integer> m;
   private int[][] sqr;
   private int size;

   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      P7_5IntChecker sq = new P7_5IntChecker();

      System.out.println("Enter a sequence of integers, Q to quit: ");
      while (in.hasNextInt())
      {sq.add(in.nextInt());}

      if(sq.isMagicSqr())
         System.out.println("It is a magic square.");
      else
         System.out.println("It's not a magic square.");
   }
      
   public P7_5IntChecker()
   { m = new ArrayList<>();}

   //add a number to the arrayList m
   public void add(int num)
   {m.add(num);}

   //Add the arraylist m in a square row
   public int rowTotal(int i)//the row index
   {int sum = 0;
      for (int j = 0; j < size; j++)//temp col
      {sum = sum + sqr[i][j];}
      return sum;//return the sum of the row
   }

   //Add the arraylist m in a square column
   public int colTotal(int i)//the column index
   {int sum = 0;
      for (int j = 0; j < size; j++)//temp row
      {sum = sum + sqr[j][i];}
      return sum;//return the sum of the column
   }

   //Find sum of the diagonal
   public int diagonalTotal(boolean mainDiagonal)//mainDiagonal: true if it's the main diagonal
   {int sum = 0;
    for (int i = 0; i < size; i++)
      {int j;
         if (mainDiagonal) j = i;
         else j = size - 1 - i;
         sum = sum + sqr[i][j];
      }
      return sum;//return sum of the diagonal
   }

   //Determine whether if the square is a magic square
   public boolean isMagicSqr()
   {
      //***Check if the input set is square
      size = (int) Math.sqrt(m.size());
      if (size * size != m.size()) return false;

      //***Check to see if each of the square 1, 2, ... n^2, appear only once in the input
      for (int n = 1; n <= size * size; n++)
      {if (m.indexOf(n) == -1) return false;}

      //Put numbers into a square for row/col check
      sqr = new int[size][size];
      for (int i = 0; i < size ; i++)
         for (int j = 0; j < size ; j++)
            sqr[i][j] = m.get(i * size + j);//???
      
      //Check whether sum equals to each diagonal sum
      int sum = diagonalTotal(true);
      if (sum != diagonalTotal(false)) return false;
      
      //Check whether sum equals to each row amd column
      for (int i = 0; i < size; i++)
      {if (sum != rowTotal(i)) return false;
       if (sum != colTotal(i)) return false;}

      return true;//return true if square is a magic square, false otherwise
   }
}
