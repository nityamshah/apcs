import java.util.*;
public class CardPlayerLevel1 extends CardPlayer{

   public CardPlayerLevel1(String n, int s, ArrayList<Card> h){
      super(n, s, h);
   }
   
   public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previous){
      Card toReturn = null;
      
      Card twoOfClubs = new Card("2", "clubs", 2); //if have 2 of clubs, play it
      if (super.getHand().contains(twoOfClubs)){
         toReturn = playCard(super.getHand().indexOf(twoOfClubs));
      }
      
      if (previous.size() != 0 && round.size() == 0){ //not first round, but first player
         toReturn = playCard((int)(Math.random()*super.getHand().size()));
      }
      
      else if (round.size() > 0){ //not the first player
         boolean cardPlayed = false;
         
         boolean hasSuit = false;
         ArrayList<Integer> suitIndexes = new ArrayList<Integer>();
         for (Card x : super.getHand()){
            if (x.getSuit().equals(round.get(0).getSuit())){
               hasSuit = true;
               suitIndexes.add(super.getHand().indexOf(x));
            }
         }
         if (hasSuit == true){ //if you have the same suit as the first card, play it
            int randomSuit = (int)(Math.random()*suitIndexes.size());
            toReturn = playCard(suitIndexes.get(randomSuit));
            cardPlayed = true;
         }
            
         Card queenOfSpades = new Card("Q", "spades", 12); //if have queen of spades, play it
         if (cardPlayed == false){
            if (super.getHand().contains(queenOfSpades)){
               toReturn = playCard(super.getHand().indexOf(queenOfSpades));
               cardPlayed = true;
            }
         }
            
         if (cardPlayed == false){ //if you dont have the same suit, play highest heart
            boolean hasHearts = false;
            ArrayList<Integer> heartIndexes = new ArrayList<Integer>();
            for (Card x : super.getHand()){
               if (x.getSuit().equals("hearts")){
                  hasHearts = true;
                  heartIndexes.add(super.getHand().indexOf(x));
               }
            }
            if (hasHearts == true){
               Card highestHeart = super.getHand().get(heartIndexes.get(0));
               for (int x : heartIndexes){
                  Card c = super.getHand().get(x);
                  if (c.getRank() >= highestHeart.getRank()){ 
                     highestHeart = c;
                  }
               }
               toReturn = playCard(super.getHand().indexOf(highestHeart));
               cardPlayed = true;
            }
         }
         if (cardPlayed == false){ //if none of the above, play a random card
            toReturn = playCard((int)(Math.random()*super.getHand().size()));
         }
      }
      return toReturn;
   }
}