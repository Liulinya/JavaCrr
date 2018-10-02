//run this program to test the Lab06 sorted arrays

public class Tester
{ 
   public static void main(String [] args)
   { 
      Lab06 array = new Lab06(); 
      int list [] = new int[0];
      int num = Integer.parseInt("5");//input new num
      list = array.copyOf(list,list.length+1); //copy the last num to the array
      list[list.length-1] = num; // place the new input in the new spot
      System.out.println("Expected is [5]");
      System.out.println(array.toString(list)); // hashcode gets printed
      
      num = Integer.parseInt("4");//input new num
      list = array.copyOf(list,list.length+1); //copy the last num to the array
      list[list.length-1] = num; // place the new input in the new spot
      System.out.println("Expected is [5 ,4]");
      System.out.println(array.toString(list)); // hashcode gets printed

      num = Integer.parseInt("6");//input new num
      list = array.copyOf(list,list.length+1); //copy the last num to the array
      list[list.length-1] = num; // place the new input in the new spot
      System.out.println("Expected is [5 ,4, 6]");
      System.out.println(array.toString(list)); // hashcode gets printed
      
      array.sort(list); // sort the array in ascending order
      System.out.println("Expected is [4, 5 ,6]");
      System.out.println(array.toString(list)); // hashcode gets printed
   } 
}
