public class BankAccount
{  
   private double balance;//private def can be applied to all public methods

   public BankAccount()
   {   
      balance = 0;
   }

   //bank account with a given balance
   public BankAccount(double initialBalance)
   {   
      balance = initialBalance;
   }

   //deposit money into bank account
   public void deposit(double amount)
   {  
      double newBalance = balance + amount;
      balance = newBalance;
   }

   //withdraw money from bank account.
   public void withdraw(double amount)
   {   
      double newBalance = balance - amount;
      balance = newBalance;
   }
   
      public void addInterest(double rate)
   {   
      double interest = balance * rate / 100;
      balance = balance + interest;
   }
   
   //getter method to grab the result from one class to another
   public double getBalance()
   {   
      return balance;
   }

}
