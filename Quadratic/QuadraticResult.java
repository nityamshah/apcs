public class QuadraticResult {
	private boolean isReal;
	private int numRoots;
	private double result1;
	private double result2;

   public QuadraticResult(){
      isReal = true;
      numRoots = 0;
      result1 = 0.0;
      result2 = 0.0;
   }

   public void setIsReal(boolean realornot){
   	isReal = realornot;
   }
   
   public void setNumRoots(int newNumRoots){
   	numRoots = newNumRoots;
   }
   
   public void setResult1(double newResult1){
   	result1 = newResult1;
   }
   
   public void setResult2(double newResult2){
   	result2 = newResult2;
   }
   
   public String toString(){
      String formattedAnswer = "";
      if (numRoots == 2 && isReal == true){
         formattedAnswer = " real root1 " + result1 + " real root2 " + result2;
      }
      else if (numRoots == 1 && isReal == true){
         formattedAnswer = " real root " + result1;
      }
      else if (numRoots == 2 && isReal == false){
         formattedAnswer = " imaginary root1 " + result1 + "+" + result2 + "i imaginary root2 " + result1 + "-" + result2 + "i";
      }
      
      return formattedAnswer;

   }
  

}
