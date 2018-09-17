//run this program to test the car

public class R3_18CarTester
{ 
   public static void main(String [] args)
   { 
      Car myHybrid = new Car(50); // 50 miles per gallon       
      myHybrid.addGas(20); //20 gallons in the tank
      myHybrid.drive(100); // Drive 100 miles so that consume 2 gallons out of 20
      myHybrid.addGas(20); //38 gallons in the tank
      myHybrid.drive(100); // Drive 100 miles so that consume 2 gallons out of 20
      double gasLeft = myHybrid.getGasInTank(); //Get gas remaining in tank
      
      System.out.println("Gas left is "+gasLeft);
      System.out.println("Expected gas left is 36.");
   } 
}