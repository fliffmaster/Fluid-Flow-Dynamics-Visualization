import java.util.Random;
import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.Graphics;

public class FluidFlowReactorPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FFDot> dots;
	private int lastDot;
	
	public FluidFlowReactorPanel(int numDots)
	{
		System.out.println(this.getBounds().getHeight());
		lastDot = numDots;
		dots = new ArrayList<FFDot>();
	}
	
	public void makeDots()
	{
		for(int i = 0; i < lastDot; i++)
			dots.add(new FFDot(this.getBounds()));
	}
	
	public void clearDots()
	{
		dots = new ArrayList<FFDot>();
	}
	
	public void setLastDot(int index)
	{
		lastDot = index;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		
		for(int i = 0; i < lastDot; i++)
		{
			Ellipse2D.Double dot = dots.get(i).getEllipse();
			g2.fill(dot);
		}
	}
	
	
}

class FFDot
{
	private int x;
	private int y;
	private int diameter;
	private Random rando;
	
	public FFDot(Rectangle boundary)
	{
		rando = new Random();
		diameter = 4;
		int height = (int) boundary.getHeight();
		System.out.println(height);
		int width = (int) boundary.getWidth();
		y = rando.nextInt((int)(height - diameter + 1));
		x = rando.nextInt((int)(width - diameter + 1));	
	}
	
	public FFDot(int x, int y, Rectangle boundary)
	{
		
	}
	
	public Ellipse2D.Double getEllipse()
	{
		return new Ellipse2D.Double(x, y, diameter, diameter);
	}
	/*public void drawDot(Graphics2D g2)
	{
		Ellipse2D.Double dot = new Ellipse2D.Double(x, y, diameter, diameter);
		g2.setColor(Color.BLUE);
		g2.fill(dot);
		g2.setColor(Color.BLACK);
	}*/
}
