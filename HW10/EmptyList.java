public class EmptyList implements LispList{
  public boolean contains(Object obj) { return false; }
   public int length(){ return 0; }
     
   public LispList cons(Object obj){
      return new NonEmptyList(obj, this);
   }
     
   public EmptyList(){ }

   public Object head(){
      throw new UnsupportedOperationException();
   }

   public LispList tail(){
      throw new UnsupportedOperationException();
   }
   
   public boolean empty(){ return true; }

   public String toString() { return ""; }
}
