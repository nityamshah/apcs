import java.util.*;

public class PairsOfWords  
{  
   /** The list of word pairs, initialized by the constructor. */  
   private ArrayList<TwoWords> allPairs;  
   
  /** Constructs a WordPairList object as described in part (a).  
    * Precondition: words.length >= 2  
  */ 
   public PairsOfWords(String[] words)
   { /* to be implemented in part (b) */ 
      allPairs = new ArrayList<TwoWords>();
      for (int i = 0; i < words.length; i++){
         for (int j = i+1; j < words.length; j++){
            allPairs.add(new TwoWords(words[i], words[j]));
         }
      }
   }  

   
   /** returns the ArrayList containing all the word pairs */ 
   public ArrayList<TwoWords> getAllPairs()
   { /* to be implemented in part (c) */ 
      return allPairs;
   }  

   
   /** Returns the number of matches as described in part (c). 
   */  
   public int numMatches()
   { /* to be implemented in part (d) */
      int x = 0;
      for (int i = 0; i< allPairs.size(); i++)// go through
      {
         if (allPairs.get(i).getFirst().equals(allPairs.get(i).getSecond())){
            x++;
         }
      }
      return x;
    }  

} 
