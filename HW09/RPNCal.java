// read arithmetic expressions and convert to reverse polish notation
import java.util.Scanner;
import java.util.Stack;

public class RPNCal {
  
   public static void main(String[] args) {
      RPNCal.convertToRPN("3 + 4");
      System.out.println("\nExpected: 3 4 +");

      RPNCal.convertToRPN("3 + 4 * 5 ");
      System.out.println("\nExpected: 3 4 5 * + ");

      RPNCal.convertToRPN("3 * (4 + 5)");
      System.out.println("\nExpected: 3 4 5 + * ");

      RPNCal.convertToRPN("(3 + 4) * (5 + 6)");
      System.out.println("\nExpected: 3 4 + 5 6 + * ");

      RPNCal.convertToRPN("3 + 4 + 5");
      System.out.println("\nExpected: 3 4 + 5 +");
   }
     
   public static void convertToRPN(String sentence) {
      Stack<Character> opstack = new Stack<>();
      int pos = 0;
      
      while (pos < sentence.length()) {
         char ch = sentence.charAt(pos);
         pos++;
         
         if (Character.isDigit(ch)) {
            String str = sentence.substring(pos);
            sentence = grabNum(ch, str);
            pos = 0;// renew the position cursor to check nums once again
         }
         else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            grabOpr(ch, sentence, opstack);
         } else if (ch == '(') {
            // remove one pair of parentheses and recursively handle the sub-expression inside them
            int posOpen = pos - 1;
            int i = findParen(sentence.substring(pos-1));
            int posClose = pos + i - 1;
            
            // convert the (...) into RPN version
            convertToRPN(sentence.substring(pos, posClose));
            // process the remainder of the expression
            if (posClose < sentence.length()) {
               sentence = sentence.substring(posClose + 1);
            }
            pos = 0;// renew the position cursor to check () once again
         }
      }
      
      // print any operators remaining on the stack
      while (opstack.size() > 0) {
         char opr = opstack.pop();
         System.out.print(opr + " ");
      }
   }

   // concatenate a string of digits and print the number
   public static String grabNum(char ch, String str) {
      int pos = 0;
      while (pos < str.length() && Character.isDigit(str.charAt(pos))) {
         pos++;
      }
      String numStr = ch + str.substring(0, pos);
      System.out.print(numStr + " ");
      return str.substring(pos);
   }

   // grab operator precedence
   public static void grabOpr(char ch, String input, Stack<Character> opstack) {
      if ( opstack.size() == 0) {
         opstack.push(ch); } 
      else {
         char oldOp = opstack.pop();
         if ( precedence(ch) <= precedence(oldOp)) {
            System.out.print(oldOp + " "); } 
         else { opstack.push(oldOp); }
         opstack.push(ch);
      }
   }

   // compute the precedence level of an operator
   public static int precedence(char ch) {
     if (ch == '+' || ch == '-') { return 1;}
     else if (ch == '*' || ch == '/') { return 2;} 
     else { return 0;}
   }

   // find the closed parenthese ')' that matches the open parenthese '('
   public static int findParen(String in) {
      int openParen = 0;
      for (int i = 0; i < in.length() ; i++) {
         if (in.charAt(i) == '(') {
            openParen = openParen + 1;
         } else if (in.charAt(i) == ')') {
            openParen = openParen - 1;
            if (openParen == 0) {
               return i;
            }
         }
      }
      return 0; // when error, return nothing
   }
}

