//run this program to test

public class E3_7BankAccountTester
{  
   public static void main(String[] args)
   {  
      BankAccount momsSavings = new BankAccount(1000);
      momsSavings.addInterest(10);
      
      double balance = momsSavings.getBalance();

      System.out.println("Actual balance is "+balance);      
      System.out.println("Expected balance is 1100");
   }
}
