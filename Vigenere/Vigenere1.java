public class Vigenere1
{
   // declare instance variables for text and keyword
   private String plainText;
   private String key;

   // default constructor
   public Vigenere1 ()
   {
      plainText = "";
      key = "";
   }
    
   // initialization constructor
   public Vigenere1 (String theMsg, String theKey)
   {
      plainText = theMsg;
      key = theKey;
   }
    
   // modifier method for plainText
   public void setPlainText(String newMsg){
      plainText = newMsg;
   }

   // modifier method for key
   public void setKey(String newKey){
      key = newKey;
   }
    
   // accessor method for plainText
   public String getPlainText(){
      return plainText;
   }
    
   // accessor method for key
   public String getKey(){
      return key;
   }
    
   //   encrypt method
   //   return a String
   //   no parameters
   public String encrypt()
   {
      String encryptedMessage = "";
      int keyWordIndex = 0;
      char[] plainTextArray = plainText.toCharArray();
      char[] keyArray = key.toCharArray();
      for (int x = 0; x < plainTextArray.length; x++){
         if (keyWordIndex == key.length()){
            keyWordIndex = 0;
         }
         int msgCharPos = (int) plainTextArray[x] - 65;
         int keyCharPos = (int) keyArray[keyWordIndex] - 65;
         int newCharPos = (msgCharPos + keyCharPos)%26;
         
         char newChar = (char) (newCharPos + 65);
         
         encryptedMessage += newChar;
      
         keyWordIndex++;
      } 
      return encryptedMessage;
   }
   
    
   // decrypt method
   //   return a String
   //   String parameter 
   public String decrypt(String encryptedMessage){
      String decryptedMessage = "";
      int keyWordIndex = 0;
      char[] encryptedMsg = encryptedMessage.toCharArray();
      char[] keyArray = key.toCharArray();
      for (int x = 0; x < encryptedMsg.length; x++){
         if (keyWordIndex == key.length()){
            keyWordIndex = 0;
         }
         int msgCharPos = (int) encryptedMsg[x] - 65; //position in alphabet
         int keyCharPos = (int) keyArray[keyWordIndex] - 65; //position in alphabet
         int newCharPos = msgCharPos - keyCharPos; //if negative, you have to wrap around from end of alphabet
         if (newCharPos < 0)
            newCharPos += 26;
         else 
            newCharPos = newCharPos%26;    
                 
         char newChar = (char) (newCharPos + 65);
         
         decryptedMessage += newChar;
      
         keyWordIndex++;
      } 
      return decryptedMessage;
   
   }
    
   // equals method
   //   return a boolean
   //   Vigenere reference parameter
   public boolean equals(Object obj)
   {
      Vigenere1 v = (Vigenere1) obj;
      return (plainText.equals(v.getPlainText()) && key.equals(v.getKey()));
   }    
   
   // toString() method
   public String toString()
   {
      return("plain Text     = " + plainText + "\nkey            = " + key + "\nencrypted Text = " + encrypt() + "\ndecrypted Text = " + decrypt(encrypt()));    // Do NOT modify 
   }
    
}
