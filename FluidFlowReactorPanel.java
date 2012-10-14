import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FluidFlowReactorPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FFDot> dots;
	private int lastDot;
	private Timer timer = new Timer(500,new TimerListener());
	
	public FluidFlowReactorPanel(int numDots)
	{
		//System.out.println(this.getBounds().getHeight());
		lastDot = numDots;
		dots = new ArrayList<FFDot>();
		timer.setRepeats(true);
	}
	
	public void start(){
		timer.start();
	}
	
	public void stop(){
		timer.stop();
	}
	
	public void setTimer(int delay){
		timer.setDelay(delay);
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
	
	public int getLastDot(){
		return lastDot;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLUE);
		makeDots();
		for(int i = 0; i < lastDot; i++)
		{
			Ellipse2D.Double dot = dots.get(i).getEllipse();
			g2.fill(dot);
		}
	}
	
	class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			clearDots();
			makeDots();
			repaint();
	
		}
	}
	
}

class FFDot
{
	private int x;
	private int y;
	private int diameter;
	private Random rando = new Random();
	
	public FFDot(Rectangle boundary)
	{
		
		diameter = 4;
		int height = (int) boundary.getHeight();
		//System.out.println(height);
		int width = (int) boundary.getWidth();
		y = rando.nextInt((int)(height - diameter - 10)) + 5;
		x = rando.nextInt((int)(width - diameter - 10)) + 5 ;	
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

