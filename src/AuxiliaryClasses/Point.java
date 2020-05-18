package AuxiliaryClasses;

public class Point
	{
	private final int x;
	private final int y;

	public boolean equals(int x, int y)
		{
		return (this.x == x && this.y == y);
		}
		
	public String toString()
		{
		return "Point: x = " + x + "     y = " + y;
		}
	
	public int getX()
		{
		return x;
		}
		
	public int getY()
		{
		return y;
		}
	
	public Point(int x, int y)
		{
		this.x = x;
		this.y = y;
		}
	}
