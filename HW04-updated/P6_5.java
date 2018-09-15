import java.util.Scanner;

/*Factoring of integers. Write a program that asks the user for an integer and then
prints out all its factors.*/

public class P6_5 {

    public static void main(String[] args) { 

       int i =0;
       int num =0;
       //Empty String
       String  primeNumbers = "";

       Scanner in = new Scanner(System.in);
       System.out.println("Enter an integer value.");
       long value = in.nextLong();
       
       //for each value (i) less than the input (value)
       for (i = 1; i <= value; i++)         
       {        
          int factor=0;    
          //from i keep minus 1 until 1 to get each (num)
          for(num =i; num>=1; num--)
          {
            //if num is a factor of i, repeatedly divide it out
             if(i%num==0)
             {factor = factor + 1;}
          }
         //Appended the Prime number to the String: for each i, ...
         if (factor ==2)// the numbers have exactly two factors which is 1 and itself
         {primeNumbers = primeNumbers + i + " ";} }
       
       System.out.println("Prime numbers from 1 to " + value +" are :");
       System.out.println(primeNumbers);
   }
}