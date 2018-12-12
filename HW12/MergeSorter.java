//E18_7: generic merge sort
import java.util.*;

public class MergeSorter <X extends Comparable<? super X>>{
   private X[] a = null;
   private ArrayList<X> list;

  public static void main(String[] args){
      String[] letters ={"Happy", "end", "of","semester"};
      MergeSorter<String> sorter = new MergeSorter<String>(letters);
      sorter.sort();
      System.out.println(Arrays.toString(letters));
      System.out.println("Expected: [Happy, end, of, semester]");
   }

   public MergeSorter(X[] array){
      // copy array elements to a managed list to overcome the difficulty of instantiating a generic array
      a = array;
      list = new ArrayList<X>();
      for (X element : a)
         list.add(element);
   }
   
   public MergeSorter(ArrayList<X> aList){list = aList;}
   
   // sort arraylist by merge sorter
   public void sort(){  
      if (list.size() <= 1) return;
      ArrayList<X> firstList = new ArrayList<X>(list.size() / 2);
      ArrayList<X> secondList = new ArrayList<X>(list.size() - list.size() / 2);
      for (int i = 0; i < list.size() / 2; i++)
         firstList.add(list.get(i));
      for (int i = 0; i < list.size() - list.size() / 2; i++)
         secondList.add(list.get(list.size() / 2 + i));
      MergeSorter<X> firstSorter = new MergeSorter<X>(firstList);
      MergeSorter<X> secondSorter = new MergeSorter<X>(secondList);
      firstSorter.sort();
      secondSorter.sort();
      merge(firstList, secondList);
      
      // if originally input array instead of arraylist, copy the sorted elements back to the array
      if (a != null)
         for (int i = 0; i < list.size(); i++)
            a[i] = list.get(i);
   }

   // merge two sorted lists into the managed list
   private void merge(ArrayList<X> firstList, ArrayList<X> secondList){  
      // merge both halves into the temporary list
      int firstListNxt = 0; // next element in 1st list
      int secondListNxt = 0; // next element in 2nd list
      int j = 0; // next open position in l

      // as long as neither iFirst nor iSecond past the end, move the smaller element into l
      while (firstListNxt < firstList.size() && secondListNxt < secondList.size()){  
         if (firstList.get(firstListNxt).compareTo(secondList.get(secondListNxt)) < 0){  
            list.set(j, firstList.get(firstListNxt));
            firstListNxt++;
         }else{  
            list.set(j, secondList.get(secondListNxt));
            secondListNxt++;}
         j++;
      }

      // copy any remaining entries of 1st list
      for (int i = 0; i < firstList.size() - firstListNxt; i++)
         list.set(j + i, firstList.get(firstListNxt + i));
      
      // copy any remaining entries of 2nd list
      for (int i = 0; i < secondList.size() - secondListNxt; i++)
         list.set(j + i, secondList.get(secondListNxt + i));
   }
}
