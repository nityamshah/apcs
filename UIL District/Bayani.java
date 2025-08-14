import java.io.*;
import java.util.*;

public class Bayani{
   
   public static void main (String args[]) throws FileNotFoundException{
   
      Scanner scanInput = new Scanner(new File("bayani.dat"));
   
      double total = 0;
      while (scanInput.hasNextDouble()){
         double number = scanInput.nextDouble();
         total += number;
         int dollarValue = (int) number;
         int length = String.valueOf(dollarValue).length();
         System.out.print("        $");
         for (int x = 0; x < 4 - length; x++){
            System.out.print(" ");
         }
         System.out.println(number);
      }
      System.out.print("Total = $ " + total); 
   }
}