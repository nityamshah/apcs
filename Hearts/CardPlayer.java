import java.util.*;
public class CardPlayer extends Player{
   
   private ArrayList<Card> hand;
   private ArrayList<Card> takenCards;
   
   public CardPlayer(String name, int score, ArrayList<Card> hand){
      super(name, score);
      this.hand = hand;
      takenCards = new ArrayList<Card>();
   }
   
   public ArrayList<Card> getHand(){
      return hand;
   } 
   
   public ArrayList<Card> getTakenCards(){
      return takenCards;
   }   
   
   public void setHand(ArrayList<Card> hand){
      this.hand = hand;
   }
   
   public void setTakenCards(ArrayList<Card> takenCards){
      this.takenCards = takenCards;
   }
   
   public void addCard(Card card){
      hand.add(card);
   }
   
   public Card playCard(int index){
      return hand.remove(index);
   }
   
   public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previous){ 
      Card toReturn = null;
      
      Card twoOfClubs = new Card("2", "clubs", 2); //if have 2 of clubs, play it
      if (hand.contains(twoOfClubs)){
         toReturn = playCard(hand.indexOf(twoOfClubs));
      }
      
      else if (previous.size() != 0 && round.size() == 0){ //not first round, but first player
         toReturn = playCard((int)(Math.random()*hand.size()));
      }
      
      else if (round.size() > 0){ //not the first player
         boolean cardPlayed = false;
         
         boolean hasSuit = false;
         ArrayList<Integer> suitIndexes = new ArrayList<Integer>();
         for (Card x : hand){
            if (x.getSuit().equals(round.get(0).getSuit())){
               hasSuit = true;
               suitIndexes.add(hand.indexOf(x));
            }
         }
         if (hasSuit == true){ //if you have the same suit as the first card, play it
            int randomSuit = (int)(Math.random()*suitIndexes.size());
            toReturn = playCard(suitIndexes.get(randomSuit));
            cardPlayed = true;
         }
            
         if (cardPlayed == false){//if you dont have the same suit, play a random heart
            boolean hasHearts = false;
            ArrayList<Integer> heartIndexes = new ArrayList<Integer>();
            for (Card x : hand){
               if (x.getSuit().equals("hearts")){
                  hasHearts = true;
                  heartIndexes.add(hand.indexOf(x));
               }
            }
            if (hasHearts == true){
               int randomHeart = (int)(Math.random()*heartIndexes.size());
               toReturn = playCard(heartIndexes.get(randomHeart));
               cardPlayed = true;
            } 
         }
         if (cardPlayed == false){ //if none of the above, play a random card
            toReturn = playCard((int)(Math.random()*hand.size()));
         }
      }
   
      return toReturn;
   }
   
   public String toString(){
      Collections.sort(hand);
      return getName() + " (" + getScore() + ") " + getHand();
   }
}