public class Alice{
   public static void main (String args[]){
      
      for (int x = 1; x <= 20; x++){
         System.out.print("            ");
         if (x <= 3){
            for (int i = 0; i < x; i++)
               System.out.print("&");
            System.out.println();
         }
         if (4 <= x && x <= 7){
            System.out.print("&&");
            for (int i = 0; i < x-3; i++)
               System.out.print("-");
            System.out.print("&");
            System.out.println();
         }
         if (x >7){
            System.out.print("&&--");
            for (int i = 0; i < x-7; i++)
               System.out.print(".");
            System.out.print("--&");
            System.out.println();
         } 
      }
      
      System.out.println("             ||                   \\o/");
      System.out.println("             ||                    | ");
      System.out.println(" ======================================");
      System.out.println("   ==================================");
      System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
   }
}