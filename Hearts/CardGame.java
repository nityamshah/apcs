import java.util.*;

public class CardGame{
   
   private Deck deckOfCards;
   private String nameOfGame;
   private ArrayList<CardPlayer> players = new ArrayList<CardPlayer>();
   private int numberOfPlayers;
   private int currentPlayer;
   
   //ORIGINAL
   /*
   public CardGame(String n, int numPlayers, String[] names, int current){
      deckOfCards = new Deck();
      nameOfGame = n;
      for (int x = 0; x < 4; x++){
         String name = names[x];
         players.add(new CardPlayer(name, 0, new ArrayList<Card>()));
      }
      numberOfPlayers = numPlayers;
      currentPlayer = current;
   }
   */  
   
   //VERSION WITH 3 CPL1 and MY GOODER ONE
   public CardGame(String n, int numPlayers, String[] names, int current){
      deckOfCards = new Deck();
      nameOfGame = n;
      for (int x = 0; x < 3; x++){
         String name = names[x];
         players.add(new CardPlayerLevel1(name, 0, new ArrayList<Card>()));
      }
      players.add(new CardPlayerLevel2and3(names[3], 0, new ArrayList<Card>()));
      numberOfPlayers = numPlayers;
      currentPlayer = current;
   }
   
   public Deck getDeckOfCards(){
      return deckOfCards;
   }
   public void setDeckOfCards(Deck d){
      deckOfCards = d;
   }
   public String getNameOfGame(){
      return nameOfGame;
   }
   public void setNameOfGame(String s){
      nameOfGame = s;
   }
   public ArrayList<CardPlayer> getPlayers(){
      return players;
   }
   public void setPlayers(ArrayList<CardPlayer> p){
      players = p;
   }
   public int getNumberOfPlayers(){
      return numberOfPlayers;
   }
   public void setNumberOfPlayers(int n){
      numberOfPlayers = n;
   }
   public int getCurrentPlayer(){
      return currentPlayer;
   }
   public void setCurrentPlayer(int n){
      currentPlayer = n;
   }
   
   public void deal(int numToDeal, int playerIndex){
      ArrayList<Card> toDeal = new ArrayList<Card>(deckOfCards.getDeck().subList(0, numToDeal));
      deckOfCards.getDeck().removeAll(toDeal);
      players.get(playerIndex).getHand().addAll(toDeal);
   }  
   
   public void playGame(){
      for (CardPlayer x : players){
         x.getTakenCards().clear();
         //System.out.println(x.getHand());
      }
      for (int x = 0; x < players.size(); x++){ 
         for (int i = 0; i < players.get(x).getHand().size(); i++){
            if (players.get(x).getHand().get(i).equals(new Card("2", "clubs", 2))){
               currentPlayer = x;
               break;
            }
         }
      }
      
      ArrayList<Card> round = new ArrayList<Card>();
      ArrayList<Card> previous = new ArrayList<Card>();
      
      for (int r = 0; r < 13; r++){ 
         round.clear();
      
         int playerWhoLed = currentPlayer;
         //System.out.println(players.get(currentPlayer).getName() + " is the current player");
         
         //for (CardPlayer x : players){
            //System.out.println(x.getHand());      
         //}
         
         Card firstCard = players.get(currentPlayer).chooseCard(round, previous); 
         //System.out.println(players.get(currentPlayer).getName() + " played the first card ->" + firstCard);
         round.add(firstCard);
         setCurrentPlayerToNextPlayer();
               
         Card highestCard = firstCard;
         int highestPlayer = playerWhoLed;
         
         for (int p = 0; p < players.size()-1; p++){ 
            Card chosenCard = players.get(currentPlayer).chooseCard(round, previous);
            //System.out.println(players.get(currentPlayer).getName() + " played the card ->" + chosenCard);
            if (chooseHigherCard(firstCard, highestCard, chosenCard) == 1){ 
               highestPlayer = currentPlayer;
               highestCard = chosenCard;
            }
            //System.out.println(players.get(highestPlayer).getName() + " is currently highest with ->" + highestCard);
            setCurrentPlayerToNextPlayer();
            round.add(chosenCard);
         }
         
         currentPlayer = highestPlayer;
         //System.out.println(players.get(highestPlayer).getName() + " is winner of this round ->" + highestCard);
         players.get(highestPlayer).getTakenCards().addAll(round);
         previous.addAll(round);
         checkRound(round, playerWhoLed); 
         //System.out.println("Added " + round + " to previous and "+ players.get(highestPlayer).getName() + "'s taken cards");
         //System.out.println(players.get(highestPlayer).getName() + "'s taken cards:" + players.get(highestPlayer).getTakenCards());
      }
      
      for (int x = 0; x < players.size(); x++){ 
         int score = calcScore(players.get(x).getTakenCards());
         players.get(x).updateScore(score);
         //System.out.println(players.get(x) + " "+ players.get(x).getScore());
      }
   }
   
   public static int chooseHigherCard(Card first, Card highest, Card toCompare){
      int toReturn = 0;
      if (toCompare.getSuit().equals(first.getSuit())){
         if (toCompare.getRank() > highest.getRank()){
            toReturn = 1;
         }
         if (toCompare.getRank() < highest.getRank()){
            toReturn = -1;
         }
      } else {
         toReturn = -1;
      }
      return toReturn;
   }
   
   public static int calcScore(ArrayList<Card> cards){
      int score = 0;
      for (Card x : cards){
         if (x.getSuit().equals("hearts")){
            score += 1;
         }
         if (x.getSuit().equals("spades") && x.getRank() == 12){
            score += 13;
         }
      }
      return score;
   }
   
   public void setCurrentPlayerToNextPlayer(){
      if (currentPlayer == players.size()-1){ //current player becomes next player
         currentPlayer = 0;
      }
      else {
         currentPlayer++;
      }
   }
   
   public String toString(){
      String toReturn = " \n";
      for (CardPlayer x : players){
         toReturn += x + "\n";
      }
      toReturn += "deck -> ";
      return nameOfGame + toReturn + deckOfCards; 
   }
   
   static int errorsInCheckRound;
   public void checkRound(ArrayList<Card> round, int startingPlayer) {
      if (errorsInCheckRound < 5) {
         //System.out.print(startingPlayer + " ");
         String roundSuit = round.get(0).getSuit();  // Suit that was led
         for (int i = 1; i < round.size(); i++) {     // for all other cards played in the round
            if (!round.get(i).getSuit().equals(roundSuit)) {    
               CardPlayer player = players.get((i + startingPlayer) % round.size());
               for (Card c : player.getHand()) {   // check each card in that players hand
                  if (c.getSuit().equals(roundSuit)) { 
                     System.out.println("*** DID NOT FOLLOW SUIT ***\n  round=" + round + "\n  played=" + round.get(i) + "\n  hand=" + player.getHand());
                     errorsInCheckRound++;
                     break;
                  }
               }
            }
         }
      }
   }
}

