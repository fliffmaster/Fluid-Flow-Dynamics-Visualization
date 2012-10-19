import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.awt.Color;

public class Particle 
{
	Ellipse2D.Double seedEllipse;
	private Color particleColor;
	
	public Particle()
	{
		Random generator = new Random();
		
		int xBounds = generator.nextInt(10);
		int yBounds = generator.nextInt(210);
		seedEllipse = new Ellipse2D.Double(5, 5, xBounds, yBounds);
	
	}
	
	public Ellipse2D getEllipse()
	{
		return seedEllipse;
	}
	
	public void deleteParticle()
	{
		
	}
}
