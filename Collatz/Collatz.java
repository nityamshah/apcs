public class Collatz{
   
   private int startNum;
   
   public Collatz(){
      startNum = 0;
   }
   public Collatz(int start){
      startNum = start;
   }
   public int[] sequence(){
      int numitems = 0;
      int start = startNum;
      while (start != 1){
         if (start % 2 == 0){
            start = start/2;
         } else {
            start = start*3 + 1;
         }
         numitems++;
       }

      int[] sequence = new int[numitems + 1];
      start = startNum;
      sequence[0] = startNum;
      for( int i = 1; i < sequence.length; i++ ){
         if (start != 1){
            if (start % 2 == 0){
               start = start/2;
               sequence[i] = start;
            } else {
               start = start*3 + 1;
               sequence[i] = start;
            }
          }
       }
      return sequence;
   }
   public void eachStep(){
      for (int x = 0; x < sequence().length; x++){
         System.out.println("step " + (x+1) + " " + sequence()[x]);
      }
   }
   public int steps(){
      return sequence().length;
   }
   public int maxValue(){
      int max = sequence()[0];
      for(int x = 0; x < sequence().length; x++){
         if(sequence()[x] > max ){
            max = sequence()[x];
         }
      }
      return max;
   }
   public int minOddValue(){
      int firstValThatIsOdd = 0;
      for (int x = 0; x < sequence().length; x++){
         if (sequence()[x] % 2 == 1){
            firstValThatIsOdd = sequence()[x];
            break;
         }   
      }
      int minOdd = firstValThatIsOdd;
      for (int x = 0; x < sequence().length; x++){
         if ((sequence()[x] % 2 == 1) && sequence()[x]!= 1){
            if (sequence()[x] <= minOdd){
               minOdd = sequence()[x];
            }
         } else if (firstValThatIsOdd == 1) {
            minOdd = 1;
         }
      }
      return minOdd;
   
   }
   public int[] oddValues(){
      int numberOfOdds = 0;
      for (int x = 0; x < sequence().length; x++){
         if (sequence()[x] % 2 == 1){
            numberOfOdds++;
         }   
      }

      int[] odds = new int[numberOfOdds];
      int oddIndex = 0;
      for (int i : sequence()){
         if (i%2==1){
            odds[oddIndex] = i;
            oddIndex++;
         }
      }
      return odds;
   }
   
   public int sumValues(){
   int sum = 0;
      for (int x = 0; x < sequence().length; x++){
         sum = sum + sequence()[x];  
      }
      return sum;
   }
   public String toString(){
   return "Starting number " + startNum + " takes " + steps() + " steps ";
   }
}