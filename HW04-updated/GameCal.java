//calculates the win number and loss number for throwing dies 4 or 24 times

public class GameCal
{
   private int tries;
   private Die d1, d2;
   private int winNum;
   private int lossNum;

   //sideNum: num of sides on the die
   //triedNum: num of times to run the calculation
   
   public GameCal(int sideNum, int triedNum)
   {
      tries = triedNum;
      d1 = new Die(sideNum);
      d2 = new Die(sideNum);
   }

   //run a single die calculation
   //one die 4 times. If a 6 appears in those 4 casts, then winNum +1, otherwise lossNum +1
   
   public void runSingle()
   {
      winNum = lossNum = 0;
      for (int i = 0; i < tries; i = i + 1)
      {
         boolean gotOne6 = false;
         // roll a single die 4 times
         for (int roll = 0; roll < 4; roll = roll + 1)
         {
            if (d1.cast() == 6)
            {gotOne6 = true;}
         }
         if (gotOne6)
         {winNum = winNum + 1;}
         else
         {lossNum = lossNum + 1;}
      }
   }

  //runs a single die calculation
  //one die 24 times. If a double 6 appears in those 4 casts, then winNum +1, otherwise lossNum +1
   
   public void runDouble()
   {
      winNum = lossNum = 0;
      for (int i = 0; i < tries; i = i + 1)
      {
         boolean gotTwo6 = false;
         // roll a pair of dice 24 times
         for (int roll = 0; roll < 24; roll = roll + 1)
         {
            int pair = d1.cast() + d2.cast();
            if (pair == 12)   // double six
            {gotTwo6 = true;}
         }
         if (gotTwo6)
         {winNum = winNum + 1;}
         else
         {lossNum = lossNum + 1;}
      }
   }

   public double getWinPct()
   {return (double)(winNum) / (winNum + lossNum);}//% of winNum

   public int getWinNum()
   {return winNum;}//# of winNum

   public int getLossNum()
   {return lossNum;}//num of lossNum
}
