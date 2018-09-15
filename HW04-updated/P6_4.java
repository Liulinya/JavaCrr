import java.util.Scanner;

/*Factoring of integers. Write a program that asks the user for an integer and then
prints out all its factors.*/

public class P6_4 {

    public static void main(String[] args) { 

            Scanner in = new Scanner(System.in);
            System.out.println("Enter an integer value.");
            long value = in.nextLong();
            System.out.print("The prime factorization of " + value + " is: ");
            
              // for each potential factor
              for (long factor = 2; factor <= value; factor++) {
                
              // if factor is a factor of value, repeatedly divide it out
              while (value % factor == 0) {
                System.out.print(factor + " "); 
                value = value / factor;}
              }
              
              // if biggest factor occurs only once, n > 1
              if (value > 1) System.out.println(value);
              else       System.out.println("");
    }
}