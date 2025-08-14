import java.util.Arrays;
import java.util.Scanner;

public class WordSearch80
{
	/** one 2D array private instance variable named wordArray - You CANNOT add any additional instance variables */
   private char[][] wordArray; 
	
	/** constructor used to set the number of rows and columns in the 2D array
		* @param row
		* @param col*/
      
   public WordSearch80(int row, int col)
   {
      wordArray = new char[row][col];
   }
	
	/** method to set an element in the 2D array
		* @param s which is the value to store in the 2D array
		* @param row the row to use
		* @param col the column to use*/
   public void setSpot(char s, int row, int col)
   {
      wordArray [row][col] = s;
   }
	
	/** methods to check for the word in the 2D array
		* @param the word to search for
		* @return return true or false*/
   public boolean inGrid(String s)
   {
      boolean success = false;
            
      //checking if word is going right
      if (success == false){
         for (int r = 0; r < wordArray.length; r++){
            String row = "";
            for (int c = 0; c < wordArray[r].length; c++){
               row += wordArray[r][c];
               if (row.indexOf(s) != -1){
                  success = true;
                  break;
               }
            }
         }
      }
      
      //checking if word is going down
      if (success == false){
         for (int c = 0; c < wordArray[0].length; c++){
            String column = "";
            for (int r = 0; r < wordArray.length; r++){
               column += wordArray[r][c];
               if (column.indexOf(s) != -1){
                  success = true;
                  break;
               }
            }
         }
      }
      
      //checking if word is going left
      if (success == false){
         for (int r = wordArray.length - 1; r >= 0; r--){
            String row = "";
            for (int c = wordArray[r].length - 1; c >= 0; c--){
               row += wordArray[r][c];
               if (row.indexOf(s) != -1){
                  success = true;
                  break;
               }
            }
         }
      }
      
      //checking if word is going up
      if (success == false){
         for (int c = wordArray[0].length - 1; c >= 0; c--){
            String column = "";
            for (int r = wordArray.length - 1; r >= 0; r--){
               column += wordArray[r][c];
               if (column.indexOf(s) != -1){
                  success = true;
                  break;
               }
            }
         }
      }
      
      return success;
   }
	
	/** toString method
		* @return String containing all elements in the 2D array*/
   public String toString()
   {
      
      return "";
   }
}
