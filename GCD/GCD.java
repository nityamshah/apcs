public class GCD
{
	//instance variables - DO NOT ADD ANY MORE INSTANCE VARIABLES
	private int numerator;
	private int denominator;
	
	//default constructor
	public GCD(){
      numerator = 0;
      denominator = 0;
   }
	
	//initialization constructor
	public GCD(int top, int bottom){
      numerator = top;
      denominator = bottom;
   }
	
	//modifier method for numerator
	public void setNumerator(int newNumerator){
      numerator = newNumerator;
   }
	
	//modifier method for denominator
	public void setDenominator(int newDenominator){
      denominator = newDenominator;
   }
	
	//accessor method for numerator
	public int getNumerator(){
      return numerator;
   }
	
	//accessor method for denominator
	public int getDenominator(){
      return denominator;
   }
	
	//method to determine gcd called calcGCD
	public int calcGCD(){
      int lowestNumber;
      int i = 1;
      int currentGCD = 0;
      
      if (numerator>denominator){
         lowestNumber = denominator;
      } else {
         lowestNumber = numerator;
      }
      
      while (i <=lowestNumber){
         if (numerator % i == 0 && denominator % i == 0){
            currentGCD = i;
         } 
         i++;
      }
      
      return currentGCD;
   }
	
	//method to determine lowest term of numerator called numeratorSimplified
	public int numeratorSimplified(){
      return numerator/calcGCD();
   }
	
	//method to determine lowest term of denominator called denominatorSimplified
	public int denominatorSimplified(){
      return denominator/calcGCD();
   }
	
	// toString() method that only returns the GCD
	public String toString(){
      return "" + calcGCD();
   }
}