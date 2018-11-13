public class NonEmptyList implements LispList {
   Object listHead;
   LispList listTail;

   public NonEmptyList(Object obj, LispList lst) {
      listHead = obj;
      listTail = lst;
   }

   public LispList cons(Object obj) {
      return new NonEmptyList(obj, this);
   }

   public boolean empty() { return false; }

   public Object head() { return listHead; }

   public LispList tail() { return listTail; }

   public String toString() {
      return head() + " " + tail().toString();
   }
}
