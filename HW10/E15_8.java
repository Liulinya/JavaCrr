//reversing the order of a oldStr
import java.util.Scanner;
import java.util.Stack;

public class E15_8 {
   public static String reversedStr(String oldStr) {
      String reversed = "";
      Scanner scanner = new Scanner(oldStr);
      
      //create an empty Stack
      Stack<String> stack = new Stack<String>();
      
      while (scanner.hasNext()){
         String character = scanner.next();
         stack.push(character);//push/add method to add elements
         
         if (character.contains(".")) { //before "." is  a sentence
            boolean firstWord = true;
            while (stack.size() > 0) {
               String popChar = stack.pop();//pop/remove element from the top of the stack 
               
               if (firstWord) { //change 1st initial letter to upper case
                  String firstLetter = popChar.substring(0, 1);
                  popChar = firstLetter.toUpperCase() + popChar.substring(1);
                  firstWord = false;}
               else { popChar = popChar.toLowerCase();} // otherwise lower case
               
               popChar = popChar.replace(".", ""); // delete "." after last word in old sentence
               /*Given: Mary had a little lamb. Its fleece was white as snow. 
                Actual: Lamb. little a had mary. Snow. as white was fleece its.*/
               
               reversed = reversed + popChar;
               
               if (stack.size() <= 0) { 
                  reversed = reversed + "."; 
                  // no sentence chars left in stack, we can end the sentence with ". "
               }
               if (scanner.hasNext() || (stack.size() > 0)) {
                  reversed = reversed + " "; 
                 // sentence chars are continuing removing from the stack, we should continue to add " " in the reversed sentence
               }
            }
         }
      }
      return reversed;
   }
   
      public static void main(String[] args) {
      String old = "Mary had a little lamb. Its fleece was white as snow.";
      String reverse = reversedStr(old);
      
      System.out.println("Given: " + old);
      System.out.println("Actual: " + reverse);
      System.out.println("Expected: Lamb little a had mary. Snow as white was fleece its.");
   }
}
