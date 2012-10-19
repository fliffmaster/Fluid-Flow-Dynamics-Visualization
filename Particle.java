import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Particle 
{
	private Ellipse2D.Double seedEllipse;
	private static Random generator = new Random();
	//private Color particleColor;
	
	public Particle()
	{
		
		
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
