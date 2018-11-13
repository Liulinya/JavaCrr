public class P16_10 {
   public static void main(String[] args) {
      LispList a = new EmptyList();
      System.out.println(a.length());
      System.out.println("Expected: 0");

      LispList b = new NonEmptyList("A", new NonEmptyList("B", new NonEmptyList("C", new EmptyList())));
      System.out.println(b.length());
      System.out.println("Expected: 3");

      LispList c = LispList.NIL.cons("C").cons("B").cons("A");
      System.out.println(c.length());
      System.out.println("Expected: 3");
   }
}
