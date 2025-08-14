public class TwoWords  
{  
   private String word1;
   private String word2;

   /** Constructs a TwoWords object. */  
   public TwoWords(String first, String second)  
   { /* to be implemented in part (a) */ 
      word1 = first;
      word2 = second;
   }  
   
   /** Returns the first string of this WordPair object. */  
   public String getFirst()
   { /* to be implemented in part (a) */ 
      return word1;
   }  

   /** Returns the second string of this WordPair object. */  
   public String getSecond()
   { /* to be implemented in part (a) */ 
      return word2;
   }  

   /** return a string of the format 
    *  ("word1", "word2")
    * the only space is the single space after the ,
    */
   public String toString()
   { /* to be implemented in part (a) */ 
      return "(\"" + word1 + "\", \"" + word2 + "\")"; 
   }  
 
}  
