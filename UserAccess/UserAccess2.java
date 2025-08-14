import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserAccess2 {

   // keyboard scanner shared by all methods
   public static final Scanner scanInput = new Scanner(System.in);

   public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
   
      File userFile = new File("users2.dat");
      while (true){
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
            break;
         }
         else if (loginOrRegister == 'r'){
            register(userFile);
            break;
         }
         else {
            System.out.println("Please enter either 'l' or 'r'");
         }
      }
      
   }
   
   
   public static boolean login(File userFile)  throws FileNotFoundException,NoSuchAlgorithmException {
      boolean success = false;
      System.out.print("Username? ");
      String userName = scanInput.nextLine();
      System.out.print("Password? ");
      String password = scanInput.nextLine();
      Scanner in = new Scanner(new File("users2.dat"));
      while (in.hasNext()){
         if (in.next().equals(userName)){
            String hashReal = in.next();
            String salt = in.next();
            String hashComputed = toHexString(getSHA(password + salt));
            if (hashReal.equals(hashComputed)){
               success = true;
            } else {
               success = false;
            }  
         } 
      }
      return success;
   }
   
   
   public static void register(File userFile) throws FileNotFoundException,IOException,NoSuchAlgorithmException {
            
      String userName = null;
      Scanner in = null;
      boolean found = false;
      
      while (true) {
         found = false;
         in = new Scanner(new File("users2.dat"));
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
            
            String salt =  makeSalt();
            String modifiedPass = password + salt;
            String hash = toHexString(getSHA(modifiedPass));
            
            FileWriter fw = new FileWriter(userFile, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(userName + " " + hash + " " + salt);
            pw.flush();
            fw.close();
            pw.close();
            break;
            
         } else {
            System.out.println("Passwords do not match. Try again.");
         }
      }
   }
   
   public static String makeSalt() {
      char[] ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
      String randomSalt = ""; 
      for (int x = 0; x < 25; x++){
         int randomIndex = (int)(Math.random()*62);
         randomSalt += ALPHANUMERIC[randomIndex];
      }
      return randomSalt;
   }

   // getSHA() and toHexString() from https://www.geeksforgeeks.org/sha-256-hash-in-java/
   public static byte[] getSHA(String input) throws NoSuchAlgorithmException
   {
        // Static getInstance method is called with hashing SHA
      MessageDigest md = MessageDigest.getInstance("SHA-256");
   
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
      return md.digest(input.getBytes(StandardCharsets.UTF_8));
   }
     
   public static String toHexString(byte[] hash)
   {
        // Convert byte array into signum representation
      BigInteger number = new BigInteger(1, hash);
   
        // Convert message digest into hex value
      StringBuilder hexString = new StringBuilder(number.toString(16));
   
        // Pad with leading zeros
      while (hexString.length() < 64)
      {
         hexString.insert(0, '0');
      }
   
      return hexString.toString();
   }
   

}
