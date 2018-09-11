import java.util.Scanner;

public class Grade {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in); 
    System.out.print("Grade: "); 
    getNumericGrade(in.nextDouble());//use NextLine inside Get method 
}
  public static void getNumericGrade(double grade){
    if (grade <= 4 && grade >= 0) {
      if (grade <= 4 && grade >= 3.85) { 
        System.out.println("A"); 
      } else {
        if (grade < 3.85 && grade >= 3.35) { 
        System.out.println("A-"); 
      } else {
          if (grade < 3.35 && grade >= 3.05) { 
          System.out.println("B+"); 
          } else {
            if (grade < 3.05 && grade >= 2.85) { 
          System.out.println("B"); 
          } else {
            if (grade < 2.85 && grade >= 2.35) { 
          System.out.println("B-"); 
          } else {
            if (grade < 2.35 && grade >= 2.05) { 
          System.out.println("C+"); 
          } else {
            if (grade < 2.05 && grade >= 1.85) { 
          System.out.println("C"); 
          } else {
            if (grade < 1.85 && grade >= 1.35) { 
          System.out.println("C-"); 
          } else {
            if (grade < 1.35 && grade >= 1.05) { 
          System.out.println("D+"); 
          } else {
            if (grade < 1.05 && grade >= 0.85) { 
          System.out.println("D"); 
          } else {
            if (grade < 0.85 && grade >= 0.05) { 
          System.out.println("D-"); 
          } else {
          System.out.println("F"); 
          }}}}}}}}}}}}
    else {System.out.println("Not correct grade.");}
  }
}