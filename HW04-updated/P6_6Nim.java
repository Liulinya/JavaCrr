import java.util.Scanner;
import java.util.Random;

public class P6_6Nim
{
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      Random generator = new Random();

      //random num btw 0 and 100
      int pileSize = generator.nextInt(91) + 10;
      /*int Low = 10;
       int High = 100;
       int Result = r.nextInt(High-Low) + Low;*/
      
      //Random num btw 0 and 1: 0 is cmptr, 1 is human
      int playerNow = generator.nextInt(2);

      // 0 == cmptr smart, 1 == stupid
      int smartOrStupid = generator.nextInt(2);

      while (pileSize > 0)
      {
         System.out.println("Current number of marbles in pile: " + pileSize);

         int removeNum = 0;
         if (playerNow == 0)
         {
            // when stupid mode or size of pile is a power of 2, what cmptr will play...
            // ???- 1, random move
            if (smartOrStupid == 1 || (pileSize == 1 || pileSize == 3 || pileSize == 7 || pileSize == 15 || pileSize == 31 || pileSize == 63))
            {
               // ??? num btw 1 and half the pile
               removeNum = generator.nextInt(pileSize / 2 );
            }
            else
            {
               //cmptr smart mode
               if (pileSize > 63)
               {removeNum = pileSize - 63;}
               else if (pileSize > 31)
               {removeNum = pileSize - 31;}
               else if (pileSize > 15)
               { removeNum = pileSize - 15;}
               else if (pileSize > 7)
               {removeNum = pileSize - 7;}
               else if (pileSize > 3)
               {removeNum = pileSize - 3;}
               else
               {removeNum = pileSize - 1;}
            }
            System.out.println("Comptuer removed " + removeNum + " marbles.");
            playerNow = 1; //human plays
         }
         else
         {//human plays
            do
            {System.out.println("How many marbles you gonna remove: ");
             removeNum = in.nextInt();
             //???
            } while ((removeNum != 1) && (removeNum <= 0 || removeNum > pileSize / 2));
            playerNow = 0; // cmptr plays next
         }
         pileSize -= removeNum;
      }
      if (playerNow == 0)
      {// humans plays last round
       System.out.println("You took last one, so you loose.");}
      else
      {System.out.println("Computer took last one, so computer looses.");}
   }
}
