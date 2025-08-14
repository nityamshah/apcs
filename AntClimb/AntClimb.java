import java.util.Scanner;

public class AntClimb {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      System.out.print("Upward progress: ");
      int upward = scan.nextInt(); 
      System.out.print("Downward slide: ");
      int downward = scan.nextInt(); 
      System.out.print("Depth of hole: ");
      int depthOfHole = scan.nextInt();  
      System.out.println("Distance: " + climb(upward,downward,depthOfHole));
   }
   
   public static int climb (int up, int down, int depth){
      depth -= up;
      if (depth <= 0){
         return depth + up;
      }
      depth += down;
      return climb(up, down, depth) + up + down;
   }
}
