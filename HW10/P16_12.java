public class P16_12 {
   public static void main(String[] args) {
      LispList a = new EmptyList();
      System.out.println(a.contains("A"));
      System.out.println("Expected: false");

      LispList b = new NonEmptyList("A", new NonEmptyList("B", new NonEmptyList("C", new EmptyList())));
      System.out.println(b.contains("A"));
      System.out.println("Expected: true");

      LispList c = LispList.NIL.cons("C").cons("B").cons("A");
      System.out.println(c.contains("E"));
      System.out.println("Expected: false");
   }
}
