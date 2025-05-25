import java.util.Scanner;

/*
* Michigan Technological University CS1121 Problem 3-28
* Two rectangles
*/
public class Book1ThreeTwentyeight {
	public static void main(String[] args) {
		// Create a new Scanner object
		Scanner input = new Scanner(System.in);
		
		// Set up the input variables
		double rect1CenterX = 0.0;
		double rect1CenterY = 0.0;
		double rect1Width = 0.0;
		double rect1Height = 0.0;
		double rect2CenterX = 0.0;
		double rect2CenterY = 0.0;
		double rect2Width = 0.0;
		double rect2Height = 0.0;
		
		// Get the values for the input variables
		System.out.println("Enter r1's center x-, y-coordinates, width, and height: ");
		rect1CenterX = input.nextDouble();
		rect1CenterY = input.nextDouble();
		rect1Width = input.nextDouble();
		rect1Height = input.nextDouble();
		
		System.out.println("Enter r2's center x-, y-coordinates, width, and height: ");
		rect2CenterX = input.nextDouble();
		rect2CenterY = input.nextDouble();
		rect2Width = input.nextDouble();
		rect2Height = input.nextDouble();
		
		boolean point1Inside = false;
		boolean point2Inside = false;
		boolean point3Inside = false;
		boolean point4Inside = false;
		boolean inside = false;
		boolean overlap = false;
		
		// Minimum x-value of rectangle 1
		double rect1MinX = rect1CenterX - rect1Width / 2;
		
		// Maximum x-value of rectangle 1
		double rect1MaxX = rect1CenterX + rect1Width / 2;
		
		// Minimum y-value of rectangle 1
		double rect1MinY = rect1CenterY - rect1Height / 2;
		
		// Maximum y-value of rectangle 1
		double rect1MaxY = rect1CenterY + rect1Height / 2;
		
		// Rectangle 2 point 1 coordinates
		double rect2Point1X = rect2CenterX - rect2Width / 2;
		double rect2Point1Y = rect2CenterY + rect2Height / 2;
		
		// Rectangle 2 point 2 coordinates
		double rect2Point2X = rect2CenterX + rect2Width / 2;
		double rect2Point2Y = rect2CenterY + rect2Height / 2;
		
		// Rectangle 2 point 3 coordinates
		double rect2Point3X = rect2CenterX - rect2Width / 2;
		double rect2Point3Y = rect2CenterY - rect2Height / 2;
		
		// Rectangle 2 point 4 coordinates
		double rect2Point4X = rect2CenterX + rect2Width / 2;
		double rect2Point4Y = rect2CenterY - rect2Height / 2;
		
		// Testing if point 1 of rectangle 2 is inside rectangle 1
		if ( (rect2Point1X > rect1MinX && rect2Point1X < rect1MaxX) &&
				(rect2Point1Y > rect1MinY && rect2Point1Y < rect1MaxY) )
			point1Inside = true;
		
		// Testing if point 2 of rectangle 2 is inside rectangle 1
		if ( (rect2Point2X > rect1MinX && rect2Point2X < rect1MaxX) &&
				(rect2Point2Y > rect1MinY && rect2Point2Y < rect1MaxY) )
			point2Inside = true;
		
		// Testing if point 3 of rectangle 2 is inside rectangle 1
		if ( (rect2Point3X > rect1MinX && rect2Point3X < rect1MaxX) &&
				(rect2Point3Y > rect1MinY && rect2Point3Y < rect1MaxY) )
			point3Inside = true;
		
		// Testing if point 4 of rectangle 2 is inside rectangle 1
		if ( (rect2Point4X > rect1MinX && rect2Point4X < rect1MaxX) &&
				(rect2Point4Y > rect1MinY && rect2Point4Y < rect1MaxY) )
			point4Inside = true;
		
		// Testing if rectangle 2 is inside rectangle 1
		if (point1Inside && point2Inside && point3Inside && point4Inside)
			inside = true;
		
		// Testing if rectangle 2 overlaps rectangle 1
		else if (point1Inside || point2Inside || point3Inside || point4Inside)
			overlap = true;
		
		// Print the final result
		if (inside) 
			System.out.println("r2 is inside r1");
		else if (overlap)
			System.out.println("r2 overlaps r1");
		else
			System.out.println("r2 does not overlap r1");
		
	}
}