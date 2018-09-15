import java.util.Random;

public class P6_9Needle
{
   public static void main(String[] args)
   {
      final int numTried = 10000;
      int numHits = 0;
      Random generator = new Random();// to get a double btw -1 and 1
      
      for (int count = 0; count < numTried; count = count + 1)
      {
         double yLow = generator.nextDouble() * 2;//random num between 0 and 2
         double alpha = generator.nextDouble() * Math.PI;
         double yHigh = yLow + Math.sin(alpha);
         if (yHigh >= 2)
         {numHits= numHits + 1;}
      }
      Double ratio = numTried / (double) numHits;
      System.out.println(numTried + " tries "+numHits+" numHits ratio is "+ ratio);
   }
}

