import java.io.*;
import java.util.*;

public class Max{ //check about the decimal and stop

   public static void main (String args[]) throws FileNotFoundException{      
   
      Scanner scanInput = new Scanner(new File("max.dat"));
      while (scanInput.hasNextLine()){
         String line = scanInput.nextLine();
         for (int x = 0; x < line.length(); x++){
            char character = line.charAt(x);
            switch (character){
               case 'A' : System.out.print("Alpha");
                  break;
               case 'B' : System.out.print("Bravo");
                  break;
               case 'C' : System.out.print("Charlie");
                  break;
               case 'D' : System.out.print("Delta");
                  break;
               case 'E' : System.out.print("Echo");
                  break;
               case 'F' : System.out.print("Foxtrot");
                  break;
               case 'G' : System.out.print("Golf");
                  break;
               case 'H' : System.out.print("Hotel");
                  break;
               case 'I' : System.out.print("India");
                  break;
               case 'J' : System.out.print("Juliet");
                  break;
               case 'K' : System.out.print("Kilo");
                  break;
               case 'L' : System.out.print("Lima");
                  break;
               case 'M' : System.out.print("Mike");
                  break;
               case 'N' : System.out.print("November");
                  break;
               case 'O' : System.out.print("Oscar");
                  break;
               case 'P' : System.out.print("Papa");
                  break;
               case 'Q' : System.out.print("Quebec");
                  break;
               case 'R' : System.out.print("Romeo");
                  break;
               case 'S' : System.out.print("Sierra");
                  break;
               case 'T' : System.out.print("Tango");
                  break;
               case 'U' : System.out.print("Uniform");
                  break;
               case 'V' : System.out.print("Victor");
                  break;
               case 'W' : System.out.print("Whiskey");
                  break;
               case 'X' : System.out.print("Xray");
                  break;
               case 'Y' : System.out.print("Yankee");
                  break;
               case 'Z' : System.out.print("Zulu");
                  break;
               case '0' : System.out.print("Zero");
                  break;
               case '1' : System.out.print("Wun");
                  break;
               case '2' : System.out.print("Too");
                  break;
               case '3' : System.out.print("Tree");
                  break;
               case '4' : System.out.print("Fower");
                  break;
               case '5' : System.out.print("Fife");
                  break;
               case '6' : System.out.print("Six");
                  break;
               case '7' : System.out.print("Seven");
                  break;
               case '8' : System.out.print("Ait");
                  break;
               case '9' : System.out.print("Niner");
                  break;
            }
            System.out.print(" ");
         }
         System.out.println();
      }
   }
}
