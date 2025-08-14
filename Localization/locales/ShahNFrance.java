public class ShahNFrance extends AbstractLocale{

   public ShahNFrance(){
      super("France", "French");
   }
   public ShahNFrance(String loc, String lang){
      super(loc, lang);
   }
   public String getLocalTime(int hour, int min){ 
      int frenchHour = (hour + 7)%12;
      return String.format("%d:%02d", frenchHour, min);
   }
   public String getGreeting(){
      return "Bonjour";
   } 
   public String getCurrencySymbol(){
      return "€";
   }
   public double getCurrencyValue(double dollarAmount){ //round
      return dollarAmount*.94;
   }
}