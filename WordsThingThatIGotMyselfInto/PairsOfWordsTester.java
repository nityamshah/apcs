import java.util.*;

public class PairsOfWordsTester {

  public static void main(String[] args) {
   
    //ArrayList<TwoWords> wordPairs;
    ArrayList<TwoWords> wordPairs = new ArrayList<TwoWords>();
   
    System.out.println("Example 1");
    String[] wordNums = {"one", "two", "three"};  
    PairsOfWords exampleOne = new PairsOfWords(wordNums);
    // assign all the wordPairs from exampleOne to wordPairs variable
    // and then use a for each loop to retrieve and print each twoWords object
    // in the wordPairs ArrayList.
    wordPairs.addAll(exampleOne.getAllPairs());
    for (TwoWords x : wordPairs){
      System.out.println(x);
    }
    
    System.out.println("Example 2");
    String[] phrase = {"the", "more", "the", "merrier"};    
    // finish the code for Example 2 (make it just like the code for Example 1)
    PairsOfWords exampleTwo = new PairsOfWords(phrase);
    wordPairs.clear();
    wordPairs.addAll(exampleTwo.getAllPairs());
    for (TwoWords x : wordPairs){
      System.out.println(x);
    }

    System.out.println("Example 3");    
    String[] moreWords = {"the", "red", "fox", "the", "red"};  
    // finish the code for Example 3 by 
    //   * instantiating a PairsOfWords object which contains all the word pairs for the moreWords array
    //   * prints the number of TwoWords objects for which the two strings match.
    PairsOfWords exampleThree = new PairsOfWords(moreWords);
    System.out.println("matches -> " + exampleThree.numMatches());
  }  
}