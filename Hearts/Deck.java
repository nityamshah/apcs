import java.util.*;

public class Deck{

   private ArrayList<Card> deck = new ArrayList<Card>();
   
   public static final String[] NAMES = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
   public static final String[] SUITS = {"clubs", "spades", "hearts", "diamonds"};
   public static final int[] RANKS = {2,3,4,5,6,7,8,9,10,11,12,13,14};

   public Deck(){
      initializeDeck();
   }
   
   public ArrayList<Card> getDeck(){
      return deck;
   }
   
   public void setDeck(ArrayList<Card> d){
      deck = d;
   }
   
   public void initializeDeck(){
      deck.clear();
      for (String x : SUITS){
         String suit = x;
         for (int y = 0; y < NAMES.length; y++){
            String name = NAMES[y];
            int rank = RANKS[y];
            Card c = new Card(name, suit, rank);
            deck.add(c);
         }
      }
   }
   
   public Card getCard(int idx){
      return deck.get(idx);
   }
   
   public Card dealTopCard(){
      return deck.remove(0);
   }
   
   public void shuffle(){
       Collections.shuffle(deck);
   }
   
   public void shuffle2(){
      int numberToChange = (int)((Math.random()*9)+2); //random number 2-10
      ArrayList<Card> toChange = new ArrayList<Card>(deck.subList(0, numberToChange)); //list of top 2-10 cards
      deck.removeAll(toChange); //removes the top 2-10 cards
      int indexToMove = (int)((Math.random()*(deck.size()-1))+1); //random index 1-end
      if (indexToMove == deck.size()-1){ //if it is moving to the end
         deck.addAll(toChange);
      } else { 
         deck.addAll(indexToMove, toChange); //adds the top 2-10 cards to new location
      }
   }

   public String toString(){
      String toReturn = "";
      if (deck.size() == 0){
         toReturn = "No cards in the deck!";
      }else{
         for (Card x : deck){
            toReturn += x.toString();
         }
      }  
      return toReturn;
   }
}