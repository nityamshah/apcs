import java.io.*;
import java.util.*;

public class MusicalDiceGameRunner{
 public static void main(String[] args){
   Scanner scanInput = new Scanner(System.in);
   System.out.println("1 clarinet");
   System.out.println("2 flute-harp");
   System.out.println("3 mbira");
   System.out.println("4 piano");
   String instrument = scanInput.nextLine();
   String directory = instrument;
   MusicalDiceGame music = new MusicalDiceGame(directory);
   music.playMinuets();
   music.playTrios();
   }
}
