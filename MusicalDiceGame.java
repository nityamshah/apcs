public class MusicalDiceGame{

   private String dir; 
   
   public MusicalDiceGame(String directory){
      dir = directory;
   }
   
   public void playMinuets(){
      //minuet
      for (int i = 0; i < 16; i++){
         int s = rollDice() + rollDice();
         // play minueti-s.wav //StdAudio.play("piano/minuet3-8.wav");
         System.out.println(dir + "/minuet" + i + "-" + s + ".wav");
         StdAudio.play("mozart/mozart/" + dir + "/minuet" + i + "-" + s + ".wav");
      }
   }
      
   public void playTrios(){
      //trio
      for (int i = 0; i < 16; i++){
         int s = rollDice();
         // play trioi-s.wav //StdAudio.play("piano/trio5-6.wav");
         System.out.println(dir + "/trio" + i + "-" + s + ".wav");
         StdAudio.play("mozart/mozart/" + dir + "/trio" + i + "-" + s + ".wav");
      }
   }
   
   //dice roll
   public static int rollDice(){
      return (int)(Math.random() * 6) + 1;
   }
}