import java.util.Scanner;

/*
* Michigan Technological University CS1121 Problem 8-10
* Quadratic equations
*/
public class Book1EightTen {
	/*
	* Main testing method
	*/
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		double a = 0.0;
		double b = 0.0;
		double c = 0.0;
		
		System.out.print("Enter values for a, b, and c: ");
		
		a = input.nextDouble();
		b = input.nextDouble();
		c = input.nextDouble();
		
		QuadraticEquation myEquation = new QuadraticEquation(a, b, c);
		
		if (myEquation.getDiscriminant() > 0.0) {
			System.out.println(myEquation.getRoot1() );
			System.out.println(myEquation.getRoot2() );
		}
		
		else if (myEquation.getDiscriminant() == 0.0) {
			System.out.println(myEquation.getRoot1() );
		}
		
		else
			System.out.println("The equation has no real roots");
			
	}
	
}

class QuadraticEquation {
	// The coefficients for the quadratic equation
	double a;
	double b;
	double c;
	
	/*
	* Constructor for a new QuadraticEquation object
	*/
	QuadraticEquation(double coefficientA, double coefficientB, double coefficientC) {
		a = coefficientA;
		b = coefficientB;
		c = coefficientC;
	}
	
	/*
	* Return the value of coefficient 'a'
	*/
	double getA() {
		return a;
	}
	
	/*
	* Return the value of coefficient 'b'
	*/
	double getB() {
		return b;
	}
	
	/*
	* Return the value of coefficient 'c'
	*/
	double getC() {
		return c;
	}
	
	/*
	* Find the discriminant of the quadratic equation
	*/
	double getDiscriminant() {
		return Math.pow(getB(), 2) - (4 * getA() * getC() );
	}
	
	/*
	* Find root 1 of the quadratic equation
	*/
	double getRoot1() {
		double discriminant = getDiscriminant();
		
		if (discriminant < 0.0)
			return 0;
		
		return (-getB() + Math.sqrt(discriminant) ) / (2 * getA() );
	}
	
	/*
	* Find root 2 of the quadratic equation
	*/
	double getRoot2() {
		double discriminant = getDiscriminant();
		
		if (discriminant < 0.0)
			return 0;
		
		return (-getB() - Math.sqrt(discriminant) ) / (2 * getA() );
	}
	
}