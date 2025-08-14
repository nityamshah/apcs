import java.util.Scanner;
import java.util.Arrays;

public class CollatzRunner{
   
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Starting number ");
      int start = scan.nextInt();
      Collatz obj = new Collatz(start);
      System.out.println(obj);
      System.out.println("Number of steps " + obj.steps());
      System.out.println("Maximum value " + obj.maxValue());
      System.out.println("Minimum odd value " + obj.minOddValue());///fix
      System.out.println("Odd values " + Arrays.toString(obj.oddValues())); ///fix
      System.out.println("Sum of all values " + obj.sumValues());
      obj.eachStep();
   }
}