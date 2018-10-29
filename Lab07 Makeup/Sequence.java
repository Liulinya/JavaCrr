
public class Sequence
{
   private int[] values;
   public Sequence(int size) {values = new int[size];}
   public void set(int i, int n) {values[i] = n;}
   public int get(int i) {return values[i];}
   public int size() {return values.length;}

   public boolean sameValues (Sequence other){
     //check if values of this seq equal values of other seq
     for (int i = 0; i < this.size(); i++){
       boolean result = false;
       for (int j = 0; j < other.size(); j++){
         if (this.get(i) == other.get(j)){
           result = true;
         }
       }
       if (!result){
         return false;
       }
     } 
     
     //check if values of other seq equal values of this seq
     for (int i = 0; i < other.size(); i++){
       boolean result = false;
      for (int j = 0; j < this.size(); j++){
       if (this.get(j) == other.get(i)){
        result = true;
        }
       }
        if (!result){
         return false;
       }
     }
     return true;
     }
   
      public static void main(String[] args)
   {
      Sequence first = new Sequence(4);
      Sequence second = new Sequence(1);
      Sequence third = new Sequence(6);

      first.set(0, 1);
      first.set(1, 3);
      first.set(2, 7);
      first.set(3, 5);

      second.set(0, 1);

      third.set(0, 1);
      third.set(1, 3);
      third.set(2, 3);
      third.set(3, 5);
      third.set(4, 7);
      third.set(5, 7);

      System.out.println(first.sameValues(second));
      System.out.println("Expected: false");
      System.out.println(first.sameValues(third));
      System.out.println("Expected: true");
   }
}