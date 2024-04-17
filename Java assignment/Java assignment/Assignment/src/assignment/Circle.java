package assignment;

public class Circle 
{
	
	private double radius =1.0;
	private String color = "red";
	
	Circle(){}
	
	Circle(double radius)
	{
		this.radius = radius;
	}
	
	public double getRadius() 
	{
		return radius;
	}
	
	public double getArea()
	{
		double Area = 3.14*radius*radius;
		return Area;
	}
	public static void main(String[] args) 
	{
		Circle c1 = new Circle();
		Circle c2 = new Circle(10);
		System.out.println("Radius: "+c1.getRadius());
		System.out.println("Area: "+c1.getArea());
		System.out.println("Radius: "+c2.getRadius());
		System.out.println("Area: "+c2.getArea());
	}

}

