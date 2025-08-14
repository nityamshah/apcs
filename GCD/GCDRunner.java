//import Scanner
import java.util.Scanner;


public class GCDRunner
{
	//main method
	public static void main(String[] args)
	{
		//instantiate Scanner object
		Scanner scan = new Scanner(System.in);
		
		//prompt user for numerator
		System.out.println("Enter the numerator:");
		
		//assign user input to variable
		int numerator = scan.nextInt();
		
		//prompt user for denominator
		System.out.println("Enter the denominator:");
		
		//assign user input to variable
		int denominator = scan.nextInt();
		
		//instantiate GCD object
      GCD gcd1 = new GCD(numerator, denominator);
		
		//call toString() method
      System.out.println("The GCD is: " + gcd1);
		
		//print fraction in lowest term
		System.out.println("The fraction in lowest terms is " + gcd1.numeratorSimplified() + "/" + gcd1.denominatorSimplified());
	}
}