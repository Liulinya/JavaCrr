// pass an appropriate lambda expression to Arrays.sort

import java.util.*;
public class LambdaTester{
   public static void main(String[] args){
      BankAccount[] accountsObj = { new BankAccount(99.63), new BankAccount(73.15), new BankAccount(1.00) };
     // ArrayList<Double> accounts = new ArrayList<Double>(accountsObj);
      Arrays.sort(accounts, Comparator.comparing(acct -> acct.getBalance()));
  
      System.out.println(accounts[0]);
      System.out.println("Expected: BankAccount[balance=1.00]");
      System.out.println(accounts[1]);
      System.out.println("Expected: BankAccount[balance=73.15]");
      System.out.println(accounts[2]);
      System.out.println("Expected: BankAccount[balance=99.63]");
   }
}