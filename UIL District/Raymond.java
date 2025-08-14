import java.io.*;
import java.util.*;

public class Raymond{

   public static void main (String args[]) throws FileNotFoundException{
   
      Scanner scanInput = new Scanner(new File("raymond.dat"));
      while (scanInput.hasNextInt()){
         int number = scanInput.nextInt();
         int compliment = (number*-1)-1;
         System.out.println(number + " " + compliment);
      }
   }
}