public class Card implements Comparable<Object> {

   private String name;
   private String suit;
   private int rank;
   
   public Card(){
      name = "default";
      suit = "default";
      rank = 0;
   }
   
   public Card(String n, String s, int r){
      name = n;
      suit = s;
      rank = r;
   }
   
   public String getName(){
      return name;
   }
   
   public void setName(String n){
      name = n;
   }
   
   public String getSuit(){
      return suit;
   }
   
   public void setSuit(String s){
      suit = s;
   }
   
   public int getRank(){
      return rank;
   }
   
   public void setRank(int r){
      rank = r;
   }
   
   public boolean equals(Object obj){
      boolean toReturn = false;
      Card c = (Card) obj;
      if (c.getName().equals(name) && c.getSuit().equals(suit) && c.getRank() == rank){
         toReturn = true;
      }
      return toReturn;
   }
   
   public int compareTo(Object obj){
      int toReturn = 0;
      Card c = (Card) obj;
      String otherSuit = c.getSuit();
      int otherRank = c.getRank();
      
      if (suit.equals(otherSuit)){
         if (rank < otherRank){
            toReturn = -1;
         }
         if (rank == otherRank){
            toReturn = 0;
         }
         if (rank > otherRank){
            toReturn = 1;
         }
      }
       //suits are different, need way to compare them. any club > any spade > any heart > any diamond
      else if (suit.equals("clubs")){
         toReturn = 1;
      }
      else if (suit.equals("diamonds")){
         toReturn = -1;
      }
      else if (suit.equals("spades")){
         if (otherSuit.equals("clubs"))
            toReturn = -1;
         if (otherSuit.equals("hearts"))
            toReturn = 1;
         if (otherSuit.equals("diamonds"))
            toReturn = 1;
      }
      else if (suit.equals("hearts")){
         if (otherSuit.equals("clubs"))
            toReturn = -1;
         if (otherSuit.equals("spades"))
            toReturn = -1;
         if (otherSuit.equals("diamonds"))
            toReturn = 1;
      
      } 
      return toReturn;
   } 
   public String toString(){
      return suit.substring(0,1)+name+"("+rank+")";
   }
}

