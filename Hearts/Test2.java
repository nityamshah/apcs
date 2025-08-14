import java.util.*; 
public class Test2{
   public static void main(String args[]){
      Deck d = new Deck();
      System.out.println(d);
   
      ArrayList<Card> karasCards = new ArrayList<Card>();
      
      CardPlayerLevel1 cplay = new CardPlayerLevel1("Kara Jones", 0, karasCards);
      
      System.out.println("New CardPlayer -> " + cplay);
      
      for (int x = 0; x < 3; x++){
         cplay.addCard(d.dealTopCard()); //hand has clubs
      }       
      cplay.addCard(new Card ("5", "clubs", 5)); //hand has spades
      cplay.addCard(new Card ("6", "clubs", 6));
      cplay.addCard(new Card ("7", "clubs", 7));
   
     
      System.out.println("After adding 6 specific cards. Player -> " + cplay);
      System.out.println("Played " + cplay.playCard(5) + " at index 5."); 
      System.out.println("Player -> " + cplay);
      
      ArrayList<Card> playedInRound = new ArrayList<Card>();
      ArrayList<Card> playedInGame = new ArrayList<Card>();
      
      System.out.println("Cards played in round -> " + playedInRound);
      System.out.println("Cards played in game -> " + playedInGame);
   
      System.out.println("Chose as first player-> " + cplay.chooseCard(playedInRound, playedInGame));
      System.out.println("Player -> " + cplay);
      
      playedInRound.add(new Card("7", "diamonds", 7)); //diamonds first suit played in round
      playedInGame.add(new Card("6", "diamonds", 6));
      System.out.println("Cards played in round -> " + playedInRound);
      System.out.println("Cards played in game -> " + playedInGame);
      
      System.out.println("Chose as non first player under certain conditions-> " + cplay.chooseCard(playedInRound, playedInGame));
      System.out.println("Player -> " + cplay);
   }
}