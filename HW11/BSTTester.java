import java.util.*;

public class BSTTester{
  public static void main(String[] args){
    System.out.println("Your kth elemnt in BST is ");
    Scanner in = new Scanner(System.in);
    int num = in.nextInt();
    
    BST a = new BST (num, null, null);
    a.insert(8);
    a.insert(7);
    a.insert(12);
    a.insert(5);
    a.insert(6);
    a.insert(10);
    a.insert(11);
    bst2List(a);
    System.out.println("Your BST list is ["+a+" ]");
    System.out.println("So your " + Integer.toString(num) + "th element is " + list.get(num-1));
  }
  
    static ArrayList<Integer> list = new ArrayList<>();
    
    public static void bst2List(BST node){
      if (node == null) return;
      bst2List(node.left);
      list.add(node.value);
      bst2List(node.right);
  }
}