import java.util.*;
public class CardPlayerLevel2and3 extends CardPlayer{

   public CardPlayerLevel2and3(String n, int s, ArrayList<Card> h){
      super(n, s, h);
   }
   
   public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previous){
      Card toReturn = null;
      
      Card twoOfClubs = new Card("2", "clubs", 2); //if have 2 of clubs, play it
      if (super.getHand().contains(twoOfClubs)){
         toReturn = playCard(super.getHand().indexOf(twoOfClubs));
      }
      
      if (previous.size() != 0 && round.size() == 0){ //not first round, but first player //dont play ace //play low
         //make an if else with below being else, and if is play hearts, test what value
         ArrayList<Integer> notAce = new ArrayList<Integer>();
         for (Card x : super.getHand()){
            if (!(x.getName().equals("A"))){
               notAce.add(super.getHand().indexOf(x));
            }
         }
         if (notAce.size() == 0){
            toReturn = playCard((int)(Math.random()*super.getHand().size()));
         }
         else {
            Card lowestCard = super.getHand().get(notAce.get(0));
            for (int x : notAce){
               Card c = super.getHand().get(x);
               if (c.getRank() <= lowestCard.getRank()){ 
                  lowestCard = c;
               }
            }
            toReturn = playCard(super.getHand().indexOf(lowestCard));
         }
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
         if (hasSuit == true){ //if you have the same suit as the first card, and its the beginnning of the round, play a high one, else play the highest that is lower than the first, if u cant then play random
            if (previous.size() < 3){ 
               Card highestSame = super.getHand().get(suitIndexes.get(0));
               for (int x : suitIndexes){
                  Card c = super.getHand().get(x);
                  if (c.getRank() >= highestSame.getRank()){ 
                     highestSame = c;
                  }
               }
               toReturn = playCard(super.getHand().indexOf(highestSame));
               cardPlayed = true;
            } else { 
               Card highestButLower = super.getHand().get(suitIndexes.get(0));
               for (int x : suitIndexes){
                  Card c = super.getHand().get(x);
                  if (c.getRank() >= highestButLower.getRank() && c.getRank() < round.get(0).getRank()){ 
                     highestButLower = c;
                  }
               }
               if (highestButLower.equals(round.get(0))){
                  int randomSuit = (int)(Math.random()*suitIndexes.size());
                  toReturn = playCard(suitIndexes.get(randomSuit));
               } else {
                  toReturn = playCard(super.getHand().indexOf(highestButLower));
               }
               cardPlayed = true;
            }
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
         
         if (cardPlayed == false){ //if none of the above, play highest card
            Card highestCard = super.getHand().get(0);
            for (Card c : getHand()){
               if (c.getRank() >= highestCard.getRank()){ 
                  highestCard = c;
               }
            }
            toReturn = playCard(super.getHand().indexOf(highestCard));
            cardPlayed = true;
         }
         
      }
      return toReturn;
   }
}