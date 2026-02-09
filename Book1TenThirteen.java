import java.awt.geom.Line2D;

/*
* Michigan Technological University CS1121 Problem 10-13
* Geometry: The Triangle2D class
*/
public class Book1TenThirteen {
	/*
	* Main method
	*/
	public static void main(String[] args) {
		Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), 
			new MyPoint(4.2, 3), new MyPoint(5, 3.5) );
			
		System.out.println(t1.getArea() );
		System.out.println(t1.getPerimeter() );
		System.out.println(t1.contains(new MyPoint(3, 3) ) );
		System.out.println(t1.contains(new Triangle2D(new MyPoint(2.9, 2),
			new MyPoint(4, 1), new MyPoint(1, 3.4) ) ) );
		System.out.println(t1.overlaps(new Triangle2D(new MyPoint(2, 5.5),
			new MyPoint(4, -3), new MyPoint(2, 6.5) ) ) );
	}
	
}

/*
* The class for modeling a point
* in 2D space
*/
class MyPoint {
	// Data fields for the point
	double x;
	double y;
	
	/*
	* A no-arg default constructor
	*/
	public MyPoint() {
		x = 0.0;
		y = 0.0;
	}
	
	/*
	* A constructor for a point with the 
	* specified x- and y-coordinates
	*/
	public MyPoint(double xCoord, double yCoord) {
		x = xCoord;
		y = yCoord;
	}
	
	/*
	* Return the x-coordinate
	*/
	public double getX() {
		return x;
	}
	
	/*
	* Return the y-coordinate
	*/
	public double getY() {
		return y;
	}
	
	/*
	* Get the distance between
	* this point and another MyPoint
	*/
	public double distance(MyPoint p) {
		return Math.sqrt(Math.pow(p.getX() - getX(), 2) + 
			Math.pow(p.getY() - getY(), 2) );
	}
	
	/*
	* Get the distance between this
	* point and the specified x- and
	* y-coordinates
	*/
	public double distance(double x, double y) {
		return Math.sqrt(Math.pow(x - getX(), 2) + 
			Math.pow(y - getY(), 2) );
	}
	
}

/*
* The class that models a triangle
* in 2D space
*/
class Triangle2D {
	// Data fields for definining the triangle
	MyPoint p1;
	MyPoint p2;
	MyPoint p3;
	
	/*
	* A no-arg constructor for a default
	* triangle
	*/
	public Triangle2D() {
		p1 = new MyPoint(0, 0);
		p2 = new MyPoint(1, 1);
		p3 = new MyPoint(2, 5);
	}
	
	/*
	* A constructor for a triangle
	* with the specified points
	*/
	public Triangle2D(MyPoint point1, MyPoint point2, MyPoint point3) {
		p1 = point1;
		p2 = point2;
		p3 = point3;
	}
	
	/*
	* Return point 1
	*/
	public MyPoint getPoint1() {
		return p1;
	}
	
	/*
	* Set point 1's value
	*/
	public void setPoint1(MyPoint point1) {
		p1 = point1;
	}
	
	/*
	* Return point 2
	*/
	public MyPoint getPoint2() {
		return p2;
	}
	
	/*
	* Set point 2's value
	*/
	public void setPoint2(MyPoint point2) {
		p2 = point2;
	}
	
	/*
	* Return point 3
	*/
	public MyPoint getPoint3() {
		return p3;
	}
	
	/*
	* Set point 3's value
	*/
	public void setPoint3(MyPoint point3) {
		p3 = point3;
	}
	
	/*
	* Return the area of the triangle
	* by using Heron's Formula
	*/
	public double getArea() {
		double side1 = getPoint1().distance(getPoint2() );
		double side2 = getPoint2().distance(getPoint3() );
		double side3 = getPoint1().distance(getPoint3() );
		double s = (side1 + side2 + side3) / 2.0;
		
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3) );
	}
	
	/*
	* Get the perimeter of the
	* triangle
	*/
	public double getPerimeter() {
		double side1 = getPoint1().distance(getPoint2() );
		double side2 = getPoint2().distance(getPoint3() );
		double side3 = getPoint1().distance(getPoint3() );
		
		return side1 + side2 + side3;
	}
	
	/*
	* Determine if a point is contained
	* in the triangle
	*/
	public boolean contains(MyPoint p) {
		Line2D side1 = new Line2D.Double(getPoint1().getX(), getPoint1().getY(),
			getPoint2().getX(), getPoint2().getY() );
		Line2D side2 = new Line2D.Double(getPoint2().getX(), getPoint2().getY(),
			getPoint3().getX(), getPoint3().getY() );
		Line2D side3 = new Line2D.Double(getPoint1().getX(), getPoint1().getY(), 
			getPoint3().getX(), getPoint3().getY() );
		
		MyPoint side1Mid = new MyPoint((getPoint1().getX() + getPoint2().getX() ) / 2,
			(getPoint1().getY() + getPoint2().getY() ) / 2);
		MyPoint side2Mid = new MyPoint((getPoint2().getX() + getPoint3().getX() ) / 2,
			(getPoint2().getY() + getPoint3().getY() ) / 2);
		MyPoint side3Mid = new MyPoint((getPoint1().getX() + getPoint3().getX() ) / 2,
			(getPoint1().getY() + getPoint3().getY() ) / 2);
		
		Line2D s1 = new Line2D.Double(side1Mid.getX(), side1Mid.getY(),
			p.getX(), p.getY() );
		Line2D s2 = new Line2D.Double(side2Mid.getX(), side2Mid.getY(),
			p.getX(), p.getY() );
		Line2D s3 = new Line2D.Double(side3Mid.getX(), side3Mid.getY(),
			p.getX(), p.getY() );
	
		if (s1.intersectsLine(side2) || s1.intersectsLine(side3) )
			return false;
		else if (s2.intersectsLine(side1) || s2.intersectsLine(side3) )
			return false;
		else if (s3.intersectsLine(side1) || s3.intersectsLine(side2) )
			return false;

		return true;
	}
	
	/*
	* Determine if a triangle is contained
	* in this triangle
	*/
	public boolean contains(Triangle2D t) {
		if (contains(t.getPoint1() ) && contains(t.getPoint2() ) && contains(t.getPoint3() ) )
			return true;
		
		return false;
	}
	
	/*
	* Determine if a triangle overlaps
	* this triangle
	*/
	public boolean overlaps(Triangle2D t) {
		// The sides for this triangle
		Line2D side1 = new Line2D.Double(getPoint1().getX(), getPoint1().getY(),
			getPoint2().getX(), getPoint2().getY() );
		Line2D side2 = new Line2D.Double(getPoint2().getX(), getPoint2().getY(),
			getPoint3().getX(), getPoint3().getY() );
		Line2D side3 = new Line2D.Double(getPoint1().getX(), getPoint1().getY(),
			getPoint3().getX(), getPoint3().getY() );
			
		// The sides for triangle 2
		Line2D s1 = new Line2D.Double(t.getPoint1().getX(), t.getPoint1().getY(),
			t.getPoint2().getX(), t.getPoint2().getY() );
		Line2D s2 = new Line2D.Double(t.getPoint2().getX(), t.getPoint2().getY(),
			t.getPoint3().getX(), t.getPoint3().getY() );
		Line2D s3 = new Line2D.Double(t.getPoint1().getX(), t.getPoint1().getY(),
			t.getPoint3().getX(), t.getPoint3().getY() );
			
		if (s1.intersectsLine(side1) || s1.intersectsLine(side2) || s1.intersectsLine(side3) )
			return true;
		else if (s2.intersectsLine(side1) || s2.intersectsLine(side2) || s2.intersectsLine(side3) )
			return true;
		else if (s3.intersectsLine(side1) || s3.intersectsLine(side2) || s3.intersectsLine(side3) )
			return true;
		
		return false;
	}
	
}