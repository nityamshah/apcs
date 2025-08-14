public class Vigenere0
{
   // declare instance variables for text and keyword
   private String plainText;
   private String key;

   // default constructor
   public Vigenere0 ()
   {
      plainText = "";
      key = "";
   }
    
   // initialization constructor
   public Vigenere0 (String theMsg, String theKey)
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
    
   // equals method
   //   return a boolean
   //   Vigenere reference parameter
    public boolean equals(Object obj)
    {
       Vigenere0 v = (Vigenere0) obj;
       return (plainText.equals(v.getPlainText()) && key.equals(v.getKey()));
    }    
   
   // toString() method
   public String toString()
   {
        return("plain Text     = " + plainText + "\nkey            = " + key + "\nencrypted Text = " + encrypt());    // Do NOT modify 
   }
    
}
