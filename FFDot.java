//////////////////////////////////////////////////////////////////////////////////
// Class: 	FFDot
//
// Purpose: This class encapsulates the functionality of the small particles used
//			in our simulations, based on drawing an ellipse at (x,y) coordinates
//			within a rectangular boundary.
//
//////////////////////////////////////////////////////////////////////////////////

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class FFDot
{
	private int x;
	private int y;
	private int diameter;
	private Random rando = new Random();
	
	//Constructs a new dot w/given diameter at random coordinates within a rectangle
	public FFDot(Rectangle boundary, int diameter)
	{	
		if(diameter >= 1)
			this.diameter = diameter;
		else
			this.diameter = 1;
		int height = (int) boundary.getHeight();
		int width = (int) boundary.getWidth();
		y =  rando.nextInt(Math.abs((int)(height - diameter + 1)));
		x = rando.nextInt(Math.abs((int)(width - diameter + 1)));	
	}
	
	//returns the ellipse for the dot with specified coordinates and diameter
	public Ellipse2D.Double getEllipse()
	{
		return new Ellipse2D.Double(x, y, diameter, diameter);
	}
	
	public void setDiameter(int diameter)
	{
		if(diameter >= 1)
			this.diameter = diameter;
		else
			this.diameter = 1;
	}	
	
	public int getDiameter()
	{
		return diameter;
	}
}
