import java.util.Scanner;

/*
    Write a program that reads a set of floating-point values. Ask the user to enter the values, then print:
        -the average of the values
        -the smallest of the values
        -the largest of the values
        -the range, that is the difference between the smallest and largest.
    Your program should use a class DataSet. 
*/
 
public class E6_6 
{
    public static void main (String [] args)
    {       
            //**NOTICE smallest & largest**//
            double smallest = Double.MAX_VALUE;        //smallest number
            double largest = -Double.MAX_VALUE;     //largest number
            int count = 0;              //Total # of values
            double sum = 0;         //Sum of all values
     
            Scanner in = new Scanner(System.in);
            //Process values when sentinel is entered.
            System.out.println("Enter values. Use Q to finish.");
            while (in.hasNextDouble())
            {
                double value = in.nextDouble();
                //Find maximum
                if (value > largest)
                {largest = value;}
                //Find minimum
                if (value < smallest)
                {smallest = value;}
                //Find average
                count++;                //Counts values
                sum += value;       //Keeps running total
            }
            if (count > 0)
             {
             double average = sum / count;
                //Find range
                double range = largest - smallest;
                System.out.println("The average is: " + average);
                System.out.println("The largest is: " + largest);
                System.out.println("The smallest is: " + smallest);
                System.out.println("The range is: " + range);
                }
            else
            {System.out.println("You didn't input enough data");}
        }
    }
