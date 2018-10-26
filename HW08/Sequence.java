import java.util.ArrayList; 

public class Sequence {
  private ArrayList<Integer> values; 
  public Sequence() {
    this.values = new ArrayList<Integer>();
  }
  public Sequence(int[] values){ 
    this(); // ha, ha!
    for (int v : values)
      this.values.add( v);
  } 
  public void add(int n) {
    this.values.add(n);
  }
  public String toString() {
    return this.values.toString();
  }
  public static void main(String[] args) {    
    Sequence w = new Sequence( new int[] { 4, 5, 2, 3, 1, 7, 6 } ); 
              // notice how easy it is to initialize a Sequence now
    System.out.println( w ); 
    System.out.println( "Expected [4, 5, 2, 3, 1, 7, 6]\n" ); 
    System.out.println( longest(w).toString() ); 
    System.out.println( "Expected [4, 5]\n"); 
    System.out.println( rest(w).toString() ); 
    System.out.println( "Expected [2, 3, 1, 7, 6]\n" ); 
    System.out.println( merge(longest(w), rest(w)).toString()); 
    System.out.println( "Expected [2, 3, 1, 4, 5, 7, 6]\n"  ); 
    System.out.println( sort(w).toString() ); 
    System.out.println( "Expected [1, 2, 3, 4, 5, 6, 7]" ); 
  }
  
  /*(sort seq) = (merge (longest seq)
                    (sort (rest seq)))*/
  public static Sequence sort(Sequence w){
    if (w.values.size()<=1) return w;
    else return merge(longest(w),sort(rest(w)));
    //only when sort array is 1, return the #; otherwise leave sorted longest and sort the rest
  }
  
/*(sort [4, 5, 2, 3, 1, 7, 6]) is...                    because (longest [4, 5, 2, 3, 1, 7, 6]) is [4, 5] 
                                                          and (rest    [4, 5, 2, 3, 1, 7, 6]) is [2, 3, 1, 7, 6]
(merge [4, 5] (sort [2, 3, 1, 7, 6])) which is...           because (longest [2, 3, 1, 7, 6]) is [2, 3] 
                                                                and (rest    [2, 3, 1, 7, 6]) is [1, 7, 6]
(merge [4, 5] (merge [2, 3] (sort [1, 7, 6])) which is...         because (longest [1, 7, 6]) is [1, 7] 
                                                                      and (rest    [1, 7, 6]) is [6] 
(merge [4, 5] (merge [2, 3] (merge [1, 7] (sort ([6]))))) which is...   because    (sort [6]) is [6] 
                                                                        
(merge [4, 5] (merge [2, 3] (merge [1, 7] [6]))) which is... 

(merge [4, 5] (merge [2, 3] [1, 6, 7])) which is...

(merge [4, 5] [1, 2, 3, 6, 7]) which is... 

[1, 2, 3, 4, 5, 6, 7]*/
  
  
  public static Sequence merge(Sequence a, Sequence b){
    Sequence seq = new Sequence();
    for (int i = 0, j = 0; i < a.values.size() || j < b.values.size();)
    {// within seq a and seq b
      if (i < a.values.size() && j < b.values.size())
        if (a.values.get(i) < b.values.get(j) ) 
        seq.add(a.values.get(i++));
        else seq.add(b.values.get(j++));
        // when i < a length and j < b length && a[i] < b[j], new seq add a[i], otherwise add b[j]
      else if (i < a.values.size()) 
        seq.add(a.values.get(i++));
      // when i < a length but j > b length, new seq add a[i]
      else seq.add(b.values.get(j++));
      // when j < b length but i > a length, new seq add b[j]
    }
    return seq;
  }
  
  // return the longest prefix already sorted
  public static Sequence longest(Sequence w){
    Sequence seq = new Sequence();
    for (int i = 0; seq.values.size() == 0 || i < w.values.size() && seq.values.get(seq.values.size()-1) < w.values.get(i); i++)
    {
    //when <empty seq or i<w[whole]> and seq[last#]<w[i], keep adding w[i] in new seq
      seq.add(w.values.get(i));
    }
    return seq;
  }
  
  // return the rest seq
  public static Sequence rest(Sequence w){
    Sequence seq = new Sequence();
    for (int i = longest(w).values.size(); i<w.values.size(); i++)
    {//since longest length # + 1 == size() - 1 + 1 == size(), if i<w[whole], seq add # 
      seq.add(w.values.get(i));
    }
    return seq;
  }
}
