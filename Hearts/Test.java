import java.util.*; 
public class Test{

   public static void main(String args[]){
      
      String[] names = {"Bob", "Bill", "Ivette", "SarahGarah"};
      
      CardGame playTime = new CardGame("playTime", 4, names, 0);
      
      double totalBadPoints = 0;
      
      for (int x = 0; x < 10000; x++){ //plays the game x number of times
         playTime.getDeckOfCards().initializeDeck();
         playTime.getDeckOfCards().shuffle();
         for (int y = 0; y < playTime.getPlayers().size(); y++){
            playTime.deal(13, y);
         }
         playTime.playGame();
      }
      
      //each players score and total bad points
      double bobTotal = playTime.getPlayers().get(0).getScore();;
      double billTotal = playTime.getPlayers().get(1).getScore();;
      double ivetteTotal = playTime.getPlayers().get(2).getScore();;
      double sarahgarahTotal = playTime.getPlayers().get(3).getScore();;
      totalBadPoints = bobTotal+billTotal+ivetteTotal+sarahgarahTotal;
   
      //each players score followed by percentage of bad points taken (less is winning)
      System.out.println ("Total Bad Points: " + totalBadPoints);
      System.out.println("Bob: " + bobTotal + " " + bobTotal/totalBadPoints*100);
      System.out.println("Bill: " + billTotal + " " + billTotal/totalBadPoints*100);
      System.out.println("Ivette: " + ivetteTotal + " " + ivetteTotal/totalBadPoints*100);
      System.out.println("SarahGarah: " + sarahgarahTotal + " " + sarahgarahTotal/totalBadPoints*100);
   
   
  
   }
}


