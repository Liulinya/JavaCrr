import java.util.Scanner;

/*
 Mean and standard deviation. Write a program that reads a set of floating-point data
 values. Choose an appropriate mechanism for prompting for the end of the data set.
 When all values have been read, print out the count of the values, the aver age, and
 the standard deviation.
*/

public class P6_2
{
  
    public static void main (String [] args)
    {       
            int count = 0;
            double sum = 0;
            double sumsquared = 0;
     
            Scanner in = new Scanner(System.in);
            //Process values when sentinel is entered.
            System.out.println("Enter values. Use Q to finish.");
            while (in.hasNextDouble())
            {
                double value = in.nextDouble();
                count++;
                sum += value;
                sumsquared += value*value;
            }
            if (count > 0)
             {
                double average = sum / count;
                double stddev = Math.sqrt((sumsquared - (sum * sum )/ count) / (count - 1));//find std dev
                System.out.println("The count of value is: " + count);
                System.out.println("The average is: " + average);
                System.out.println("The standard deviation is: " + stddev);
                }
            else
            {System.out.println("You didn't input enough data");}
        }
    
}
