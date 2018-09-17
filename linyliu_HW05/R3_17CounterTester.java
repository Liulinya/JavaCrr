//run this program to test the car

public class R3_17CounterTester
{ 
   public static void main(String [] args)
   {   
     Counter unit = new Counter(); 
     unit.reset();  
     unit.click(); 
     double value = unit.getValue(); 
      
     System.out.println("The value is "+value);//expected is 1

   } 
}