public class Car 
{ 
   private double gas;
   private double efficiency;
   
   public Car(double anEfficiency) //given fuel efficiency in the constructor
   {
      gas = 0;
      efficiency = anEfficiency;
   }

   public void drive(double distance) 
   { 
      gas = gas - distance / efficiency;//consuming gas
   } 
   
   public double getGasInTank() //getter method
   { 
      return gas;//return the current amount in tank
   } 

   public void addGas(double amount) 
   { 
      gas = gas + amount;//add gas to the tank
   } 
} 
