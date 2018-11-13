public class P16_9
{
   public static void main(String[] args)
   {
      LispList a = new EmptyList();
      System.out.println("[" + a + "]");
      System.out.println("Expected: []");

      LispList c = new NonEmptyList("A", new NonEmptyList("B", new NonEmptyList("C", new EmptyList())));
      System.out.println(c);
      System.out.println("Expected: A B C");

      LispList d = LispList.NIL.cons("E").cons("D").cons("C");
      System.out.println(d);
      System.out.println("Expected: A B C");
   }
}
