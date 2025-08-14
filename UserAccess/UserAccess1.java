import java.io.*;
import java.util.*;

public class UserAccess1 {
    
   // keyboard scanner shared by all methods
   public static final Scanner scanInput = new Scanner(System.in);    

   public static void main(String[] args) throws FileNotFoundException, IOException {
   
      File userFile = new File("users1.dat");
      System.out.print("(l)ogin or (r)egister? ");
      char loginOrRegister = scanInput.nextLine().charAt(0);
      if (loginOrRegister == 'l'){
         boolean loginResult = login(userFile);
         while (loginResult == false){
            System.out.println("Username and/or password do not match. Try again.");
            loginResult = login(userFile);
            if (loginResult){
               break;
            }
         }
         if (loginResult){
            System.out.println("Welcome!!!");
         }
      } 
      else if (loginOrRegister == 'r'){
         register(userFile);
      }
   }
   
   public static boolean login(File userFile) throws FileNotFoundException {
      boolean success = false;
      System.out.print("Username? ");
      String userName = scanInput.nextLine();
      System.out.print("Password? ");
      String password = scanInput.nextLine();
      Scanner in = new Scanner(new File("users1.dat"));
      while (in.hasNext()){
         if (in.next().equals(userName)){
            if (in.next().equals(password)){
               success = true;
            } else {
               success = false;
            }
         }
      }
      return success;
   }
   
   public static void register(File userFile) throws FileNotFoundException,IOException {
   
      String userName = null;
      Scanner in = null;
      boolean found = false;
      
      while (true) {
         found = false;
         in = new Scanner(new File("users1.dat"));
         System.out.print("Username? ");
         userName = scanInput.nextLine();
         
         while (in.hasNext()){
            if (userName.equals(in.next())){
               System.out.println("Username already taken. Please choose a different one.");
               in.close();
               in = null;
               found = true;
               break;
            }
         }
         if (found==false) {
            in.close();
            in = null;
            break;
         }
      }   
   
      boolean verifiedPassword = false;
      while(true) {
         System.out.print("Password? ");
         String password = scanInput.nextLine();
         System.out.print("Verify Password? ");
         String verify = scanInput.nextLine();
      
         if (password.equals(verify)){
            System.out.println("Welcome!!!");
            FileWriter fw = new FileWriter(userFile, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(userName + " " + password);
            pw.flush();
            fw.close();
            pw.close();
            break;
         } else {
            System.out.println("Passwords do not match. Try again.");
         }
      }   
   }
        
      // Use the below code to append to userFile
      // FileWriter fw = new FileWriter(userFile, true);   // open file in append mode by passing true
      // PrintWriter pw = new PrintWriter(fw);    // use PrintWriter to write a line using println
      // pw.println(userName + " " + password);
      // pw.flush();   // flush output to file
}
