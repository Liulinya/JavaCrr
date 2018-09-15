public class P6_10
{
   public static void main(String[] args)
   {

      GameCal simulator = new GameCal(6, 1000000);

      simulator.runSingle();
      System.out.println("Single die game's winning rate is " + simulator.getWinPct());//Expected: .51

      simulator.runDouble();
      System.out.println("Double die game's winning rate is " + simulator.getWinPct());//Expected: .49
   }
}
