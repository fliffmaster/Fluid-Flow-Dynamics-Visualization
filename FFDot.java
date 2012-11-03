import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class FFDot
{
	private int x;
	private int y;
	private int diameter;
	private Random rando = new Random();
	
	public FFDot(Rectangle boundary, int diameter)
	{
		
		this.diameter = diameter;
		int height = (int) boundary.getHeight();
		//System.out.println(height);
		int width = (int) boundary.getWidth();
		y = rando.nextInt((int)(height - diameter )) + 1;
		x = rando.nextInt((int)(width - diameter )) + 1;	
	}
	
	public FFDot(int x, int y, Rectangle boundary)
	{
		
	}
	
	public Ellipse2D.Double getEllipse()
	{
		return new Ellipse2D.Double(x, y, diameter, diameter);
	}
	
	public void setDiameter(int diameter)
	{
		this.diameter = diameter;
	}
	/*public void drawDot(Graphics2D g2)
	{
		Ellipse2D.Double dot = new Ellipse2D.Double(x, y, diameter, diameter);
		g2.setColor(Color.BLUE);
		g2.fill(dot);
		g2.setColor(Color.BLACK);
	}*/
	
}
