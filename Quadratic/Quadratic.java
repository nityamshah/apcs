public class Quadratic {
	private double a;
	private double b;
	private double c;
	private QuadraticResult result;
   
   public static int realRoots;
   public static int imaginaryRoots;

	public Quadratic(){
   	a = 0.0;
   	b = 0.0;
   	c = 0.0;
   	result = null;
   }

   public Quadratic(double inputA, double inputB, double inputC){
   	a = inputA;
   	b = inputB;
   	c = inputC;
   	result = null;
   }
      
   public void solve(){
   	double discriminant = ((b*b) - (4*a*c));
      
      if(result == null) {
         result = new QuadraticResult();
      }
      
   	if (discriminant > 0){
         result.setResult1((((-1*b) + Math.sqrt(discriminant))/(2*a)));
         result.setResult2((((-1*b) - Math.sqrt(discriminant))/(2*a)));
         result.setNumRoots(2);
         result.setIsReal(true);
         realRoots += 1;
      }
      else if (discriminant == 0){
         result.setResult1(((-1*b)/(2*a)));
         result.setNumRoots(1);
         result.setIsReal(true);
         realRoots += 1;
      }
      else if (discriminant < 0){
         result.setResult1((-1*b)/(2*a));//real part
         result.setResult2((Math.sqrt(-1*discriminant))/(2*a));//complex part
         result.setNumRoots(2);
         result.setIsReal(false);
         imaginaryRoots += 1;
      }
   }
   
   public String toString() {
   	String equation = a + "x^2 + " + b + "x + " + c;
      if (result == null){
         return equation + " has not been solved yet!!!";
      }
      return equation + result.toString();
   }
}
   