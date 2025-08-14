import java.util.*;

public class DIYSorting{
   public static void main(String[] args){

      System.out.println("bubble sort:");
      int[] listArray = new int[10];
      for (int x = 0; x < 10; x++){
         listArray[x] = ((int)((Math.random()*20)+1));
      }
      System.out.println(Arrays.toString(listArray));
      bubbleSort(listArray, true);
      
      System.out.println("\nselection sort:");
      int[] listArray1 = new int[10];
      for (int x = 0; x < 10; x++){
         listArray1[x] = ((int)((Math.random()*20)+1));
      }
      System.out.println(Arrays.toString(listArray1));
      selectionSort(listArray1, true);
      
      System.out.println("\nbubble selection sort:");
      int[] listArray2 = new int[10];
      for (int x = 0; x < 10; x++){
         listArray2[x] = ((int)((Math.random()*20)+1));
      }
      System.out.println(Arrays.toString(listArray2));
      bubbleSelectionSort(listArray2, true);
      
      System.out.println("\nmr muellers example:");
      int[] listArray3 = {18, 8, 4, 5, 20, 17, 20, 9, 11, 7};
      System.out.println(Arrays.toString(listArray3));
      bubbleSort(listArray3, true);
      int[] listArray4 =  {18, 8, 4, 5, 20, 17, 20, 9, 11, 7};
      selectionSort(listArray4, true);
      int[] listArray5 =  {18, 8, 4, 5, 20, 17, 20, 9, 11, 7};
      bubbleSelectionSort(listArray5, true);

     
   }
   
   public static void bubbleSort(int[] array){
      int size = array.length;
      int bubbles = 0;
      for (int i = 0; i < size - 2; i++){
         boolean swap = false;
         for (int j = 0; j < size - 1 - i; j++){
            if (array[j] > array[j+1]){
               int temp = array[j+1];
               array[j+1] = array[j];
               array[j] = temp;
               swap = true;
               bubbles++;
            }
         }
         if (!swap){
            break;
         }
      }
      System.out.println(Arrays.toString(array) + " " + bubbles + " bubbles"); 
   }
   
   public static void selectionSort(ArrayList<Integer> list){
      int size = list.size();
      int moves = 0;
      for (int i = 0; i < size - 1; i++){
         int minIndex = i;
         for (int j = i+1; j < size; j++){
            if (list.get(j) < list.get(minIndex)){
               minIndex = j;
            }
         }
         if (minIndex != i){
            int temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
            moves++;
         }
      }
      System.out.println(list + " " + moves + " moves");
   }
   
   public static void bubbleSort(int[] array, boolean ascending){
      int size = array.length;
      int bubbles = 0;
      for (int i = 0; i < size - 2; i++){
         boolean swap = false;
         for (int j = 0; j < size - 1 - i; j++){
            if (ascending){
               if (array[j] > array[j+1]){
                  int temp = array[j+1];
                  array[j+1] = array[j];
                  array[j] = temp;
                  swap = true;
                  bubbles++;
               }
            } 
            if (!ascending){
               if (array[j] < array[j+1]){
                  int temp = array[j+1];
                  array[j+1] = array[j];
                  array[j] = temp;
                  swap = true;
                  bubbles++;
               }
            }  
         }
         if (!swap){
            break;
         }
      }
      System.out.println(Arrays.toString(array)  + " " + bubbles + " bubbles");
   }
   
   public static void bubbleSort(ArrayList<Integer> list, boolean ascending){
      int size = list.size();
      int bubbles = 0;
      for (int i = 0; i < size - 2; i++){
         boolean swap = false;
         for (int j = 0; j < size - 1 - i; j++){
            if (ascending){
               if (list.get(j) > list.get(j+1)){
                  int temp = list.get(j+1);
                  list.set(j+1, list.get(j));
                  list.set(j, temp);
                  swap = true;
                  bubbles++;
               }
            } 
            if (!ascending){
               if (list.get(j) < list.get(j+1)){
                  int temp = list.get(j+1);
                  list.set(j+1, list.get(j));
                  list.set(j, temp);
                  swap = true;
                  bubbles++;
               }
            }  
         }
         if (!swap){
            break;
         }
      }
      System.out.println(list + " " + bubbles + " bubbles");
   }
   
   public static void selectionSort(int[] array, boolean ascending){
      int size = array.length;
      int moves = 0;
      for (int i = 0; i < size - 1; i++){
         int minIndex = i;
         for (int j = i+1; j < size; j++){
            if (ascending){
               if (array[j] < array[minIndex]){
                  minIndex = j;
               }
            } 
            if (!ascending){
               if (array[j] > array[minIndex]){
                  minIndex = j;
               }
            }     
         }
         if (minIndex != i){
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            moves++;
         }
      }
      System.out.println(Arrays.toString(array) + " " + moves + " moves");
   }

   
   public static void selectionSort(ArrayList<Integer> list, boolean ascending){
      int size = list.size();
      int moves = 0;
      for (int i = 0; i < size - 1; i++){
         int minIndex = i;
         for (int j = i+1; j < size; j++){
            if (ascending){
               if (list.get(j) < list.get(minIndex)){
                  minIndex = j;
               }
            } 
            if (!ascending){
               if (list.get(j) > list.get(minIndex)){
                  minIndex = j;
               }
            }     
         }
         if (minIndex != i){
            int temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
            moves++;
         }
      }
      System.out.println(list + " " + moves + " moves");
   }
   
   public static void bubbleSelectionSort(int[] array, boolean ascending){ // MAKE IT PRINT MOVES
      int size = array.length;
      int bubbles = 0;
      int moves = 0;
      
      for (int i = 0; i < size - 2; i++){
        
         boolean swap = false;
         int minIndex = i; //min is starting number
         int originalMin = minIndex; //to see if min index changed later to decide if swap is necessary 
         for (int j = i; j < size - 1 - i; j++){    
            
            //bubble a value up
            if (ascending){
               if (array[j] > array[j+1]){
                  int temp = array[j+1];
                  array[j+1] = array[j];
                  array[j] = temp;
                  swap = true;
                  bubbles++;
                  //System.out.println(Arrays.toString(array)); for testing
               }
            } 
            if (!ascending){
               if (array[j] < array[j+1]){
                  int temp = array[j+1];
                  array[j+1] = array[j];
                  array[j] = temp;
                  swap = true;
                  bubbles++;
               }
            } 
            
            //selection sort keep track of smallest per traverse
            if (ascending){
               if (array[j] < array[minIndex]){
                  minIndex = j;
               }
            } 
            if (!ascending){
               if (array[j] > array[minIndex]){
                  minIndex = j;
               }
            }
         }
         
         //swapping smallest to the beggining or whatever
         if (minIndex != originalMin){ 
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            moves++;
            //System.out.println(Arrays.toString(array)); for testing
            
         }
         
         //stop loop once sorted
         if (!swap){
            break;
         }
         
      }
      System.out.println(Arrays.toString(array) + " " + bubbles + " bubbles & " + moves + " moves");
   }
}
