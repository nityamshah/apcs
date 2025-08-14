import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class WordSearch80Runner
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// instantiate Scanner object to read in from file
		Scanner in = new Scanner(new File("grid.txt"));   // read in grid.txt
		
		// read in rows
		int rows = in.nextInt();
      
		// read in columns
      int columns = in.nextInt();
		
		// instantiate WordSearch object passing in number of rows & columns for 2D array
      WordSearch80 wordSearch = new WordSearch80(rows, columns);
		
		// loop through the rows in the file
      for (int r = 0; r < rows; r++){
		
			// loop through the columns in the file
         for (int c = 0; c < columns; c++){
			
				// read in value from file using local variable
            char letter = in.next().charAt(0);
				
				// pass row, column, and value into the 2D array
            wordSearch.setSpot(letter, r, c);
      
         }
      }      
				
		// read number of words to search for from file
      int wordsBeingSearched = in.nextInt();
		
		// loops through the words
		for (int x = 0; x < wordsBeingSearched; x++){

			// read in word from file
         String word = in.next();
			
			// method call to search for the word in the 2D array
         boolean inGrid = wordSearch.inGrid(word);
			
			// print out word to search for and true/false
         System.out.println(word + " -> " + inGrid);
      }
      System.out.println();
      wordSearch.toString();
	}
}