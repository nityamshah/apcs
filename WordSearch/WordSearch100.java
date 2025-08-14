import java.util.Arrays;
import java.util.Scanner;

public class WordSearch100
{
	/** one 2D array private instance variable named wordArray - You CANNOT add any additional instance variables */
   private char[][] wordArray; 
	
	/** constructor used to set the number of rows and columns in the 2D array
		* @param row
		* @param col*/
      
   public WordSearch100(int row, int col)
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
      
      //checking if word is going diagonal \ down
      if (success == false){
         int indexRows = wordArray.length - 1;
         int indexColumns = wordArray[0].length - 1;
         int rows = wordArray.length;
         int columns = wordArray[0].length;
         int numOfDiagonals = rows+columns-1;
         for (int d = 0; d < numOfDiagonals; d++){
            if (d < indexRows){
               int rowToStart = indexRows - d;
               int columnToStart = 0;
               String diagonal = "";
               for (int r = rowToStart, c = 0; r < rows; r++, c++){
                  diagonal += wordArray[r][c];
               }
               if (diagonal.indexOf(s) != -1){
                  success = true;
                  break;
               } 
            }
            if (d >= indexRows){
               int rowToStart = 0;
               int columnToStart = Math.abs(numOfDiagonals-d-columns);
               String diagonal = "";
               for (int r = 0, c = columnToStart; r < rows && c < columns; r++, c++){
                  diagonal += wordArray[r][c];
               }
               if (diagonal.indexOf(s) != -1){
                  success = true;
                  break;
               }
            }
         }
      }
      
      //checking if word is going diagonal \ up
      if (success == false){
         int indexRows = wordArray.length - 1;
         int indexColumns = wordArray[0].length - 1;
         int rows = wordArray.length;
         int columns = wordArray[0].length;
         int numOfDiagonals = rows+columns-1;
         for (int d = 0; d < numOfDiagonals; d++){
            if (d < indexRows){
               int rowToStart = indexRows - d;
               int columnToStart = 0;
               String diagonal = "";
               for (int r = rowToStart, c = 0; r < rows; r++, c++){
                  char letter = wordArray[r][c];
                  diagonal = letter + diagonal;
               }
               if (diagonal.indexOf(s) != -1){
                  success = true;
                  break;
               } 
            }
            if (d >= indexRows){
               int rowToStart = 0;
               int columnToStart = Math.abs(numOfDiagonals-d-columns);
               String diagonal = "";
               for (int r = 0, c = columnToStart; r < rows && c < columns; r++, c++){
                  char letter = wordArray[r][c];
                  diagonal = letter + diagonal;
               }
               if (diagonal.indexOf(s) != -1){
                  success = true;
                  break;
               }
            }
         }
      }
      
      //checking if word is going diagonal / up
      if (success == false){
         int indexRows = wordArray.length - 1;
         int indexColumns = wordArray[0].length - 1;
         int rows = wordArray.length;
         int columns = wordArray[0].length;
         int numOfDiagonals = rows+columns-1;
         for (int d = 0; d < numOfDiagonals; d++){
            if (d < indexRows){
               int rowToStart = d;
               int columnToStart = 0;
               String diagonal = "";
               for (int r = rowToStart, c = 0; r >= 0; r--, c++){
                  diagonal += wordArray[r][c];
               }
               if (diagonal.indexOf(s) != -1){
                  success = true;
                  break;
               } 
            }
            if (d >= indexRows){
               int rowToStart = indexRows;
               int columnToStart = Math.abs(numOfDiagonals-d-columns);
               String diagonal = "";
               for (int r = rowToStart, c = columnToStart; r >= 0 && c < columns; r--, c++){
                  diagonal += wordArray[r][c];
               }
               if (diagonal.indexOf(s) != -1){
                  success = true;
                  break;
               }
            }
         }
      }
      
      //checking if word is going diagonal / down
      if (success == false){
         int indexRows = wordArray.length - 1;
         int indexColumns = wordArray[0].length - 1;
         int rows = wordArray.length;
         int columns = wordArray[0].length;
         int numOfDiagonals = rows+columns-1;
         for (int d = 0; d < numOfDiagonals; d++){
            if (d < indexRows){
               int rowToStart = d;
               int columnToStart = 0;
               String diagonal = "";
               for (int r = rowToStart, c = 0; r >= 0; r--, c++){
                  char letter = wordArray[r][c];
                  diagonal = letter + diagonal;
               }
               if (diagonal.indexOf(s) != -1){
                  success = true;
                  break;
               } 
            }
            if (d >= indexRows){
               int rowToStart = indexRows;
               int columnToStart = Math.abs(numOfDiagonals-d-columns);
               String diagonal = "";
               for (int r = rowToStart, c = columnToStart; r >= 0 && c < columns; r--, c++){
                  char letter = wordArray[r][c];
                  diagonal = letter + diagonal;
               }
               if (diagonal.indexOf(s) != -1){
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
      
      for (int r = 0; r < wordArray.length; r++){
         if (r == 0)
            System.out.print("[[ ");
         else 
            System.out.print(" [ ");
         for (int c = 0; c < wordArray[r].length; c++){
            System.out.print(wordArray[r][c] + " ");
         }   
         if (r == wordArray.length - 1)
            System.out.println("]]");
         else 
            System.out.println("] ");
      }
      return "";
   }
}

   

