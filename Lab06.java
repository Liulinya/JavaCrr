import java.util.Arrays; 
import java.util.Scanner; 

class Lab06 {
  public static void main(String[] args) {
    int[] numbers = new int[0]; // set up an array with zero elements 
    Scanner s = new Scanner(System.in); // get a scanner ready to read from keyboard 
    System.out.print("Enter: "); // prompt and then 
    String line = s.nextLine(); // read the next line 
    while (! line.equals("bye")) { // while the line is not "bye" 
      int number = Integer.parseInt(line); // parse the line into a number 
      numbers = Lab06.copyOf(numbers, numbers.length+1); // "grow" the array 
      numbers[numbers.length-1] = number; // place the new input in the new spot 
      System.out.println(Lab06.toString(numbers)); // print the array 
      System.out.print("Enter: "); // prompt and 
      line = s.nextLine(); // read new input (read entire line) 
    } // resume while, if line.equals("bye") while ends 
    Lab06.sort(numbers);
    System.out.println(Lab06.toString(numbers)); // print array 
    s.close(); // close the scanner since we don't need it any more 
  }
  // code for toString
   public static String toString(int[] a) {
     String result = "";
     for (int i = 0; i < a.length; i++){
       result = result + a[i] + ", ";
       if (i == a.length-1){//check the last position of number
         result = result.substring(0,result.length()-2);}//minus the last ", " while adding all numbers
     }
         return "[" + result + "]";
     } 
  // code for copyOf
      public static int[] copyOf(int[] a,int size) {
        int[] b = new int [size];
        for (int i = 0; i < size && i < a.length; i++){
          b[i]=a[i];
        }
        return b;
      }
  // code for sort
      public static void sort(int[] a){
        for (int i = 0; i < a.length; i++){
          for (int j = 0; j < a.length-1; j++){
            if (a[j] > a[j+1]){
              int temp = a[j];
              a[j] = a[j+1];
              a[j+1] = temp;}
          }}}
}