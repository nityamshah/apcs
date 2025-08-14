import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserEnglish{
   public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
      File wordFile = new File("words.dat");
      Scanner in = new Scanner(wordFile);
      File hackFile = new File("usersToHack.dat");
      //Scanner in2 = new Scanner(hackFile);
      while (in.hasNext()){
         String word = in.next();
         while (true){
            Scanner in2 = new Scanner(hackFile);
            while (in2.hasNext()){ 
               String userName = in2.next();
               String hash = in2.next();
               String salt = in2.next();
               String hashed = toHexString(getSHA(word + salt));
               if (hash.equals(hashed)){
                  System.out.println("user = " + userName + " password = " + word);
               }
            } 
            in2.close();     
            break;     
         }
      }
      in.close();   
   }   
      
   // getSHA() and toHexString() from https://www.geeksforgeeks.org/sha-256-hash-in-java/
   public static byte[] getSHA (String input) throws NoSuchAlgorithmException
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