import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class ReactorPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private ArrayList<FFDot> dots;
	private int totalNumberOfDots;
	private int currentNumberOfDots;
	private JTextArea txtConcentrationLog;
	private int dotDiameter;
	private int upperCornerX;
	
	public ReactorPanel(int numDots, int diameter, int upperCornerX, int rDelta, int aDelta)
	{
		this.setUpperCornerX(upperCornerX);
		dotDiameter = diameter;
		totalNumberOfDots = numDots;
		currentNumberOfDots = 0;
		dots = new ArrayList<FFDot>();
	}
	
	public void setLogTextArea(JTextArea log)
	{
		txtConcentrationLog = log;
	}
	
	public JTextArea getTextLogArea()
	{
		return txtConcentrationLog;
	}
	
	public void makeDots()
	{
		for(int i = 0; i < currentNumberOfDots; i++)
			dots.add(new FFDot(this.getBounds(), dotDiameter));
	}
	
	public void clearDots()
	{
		dots = new ArrayList<FFDot>();
	}
	
	public void setTotalNumberOfDots(int index)
	{
		totalNumberOfDots = index;
	}
	
	public void setCurrentNumberOfDots(int index)
	{
		currentNumberOfDots = index;
	}
	
	public int getCurrentNumberOfDots()
	{
		return currentNumberOfDots;
	}
	
	public int getTotalNumberOfDots()
	{
		return totalNumberOfDots;
	}
	
	
	public int getLastDot()
	{
		return totalNumberOfDots;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		makeDots();
		for(int i = 0; i < currentNumberOfDots; i++)
		{
			Ellipse2D.Double dot = dots.get(i).getEllipse();
			g2.fill(dot);
		}
	}

	public int getUpperCornerX() 
	{
		return upperCornerX;
	}

	public void setUpperCornerX(int upperCornerX) 
	{
		this.upperCornerX = upperCornerX;
	}
}
