public class P16_9
{
   public static void main(String[] args)
   {
      LispList a = new EmptyList();
      System.out.println("[" + a + "]");
      System.out.println("Expected: []");

      LispList b = new NonEmptyList("A", new NonEmptyList("B", new NonEmptyList("C", new EmptyList())));
      System.out.println(b);
      System.out.println("Expected: A B C");

      LispList c = LispList.NIL.cons("C").cons("B").cons("A");
      System.out.println(c);
      System.out.println("Expected: A B C");
   }
}
