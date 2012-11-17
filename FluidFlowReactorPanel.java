import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class FluidFlowReactorPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FFDot> dots;
	private int totalNumberOfDots;
	private int currentNumberOfDots;
	private double initialConcentration;
	private Timer animationTimer = new Timer(500, new AnimationTimerListener());
	private Timer reactionTimer = new Timer(50, new ReactionTimerListener());
	private FFBatchReactor reactor = new FFBatchReactor();
	private JTextArea txtConcentrationLog;
	private int dotDiameter;
	private int upperCornerX;
	private int xPos;
	
	public FluidFlowReactorPanel(int numDots, int diameter, int upperCornerX)
	{
		xPos = -upperCornerX;
		this.setUpperCornerX(upperCornerX);
		dotDiameter = diameter;
		totalNumberOfDots = numDots;
		currentNumberOfDots = numDots;
		dots = new ArrayList<FFDot>();
		animationTimer.setRepeats(true);
		reactionTimer.setRepeats(true);
	}
	
	public void setLogTextArea(JTextArea log)
	{
		txtConcentrationLog = log;
	}
	
	public void setInitialConcentration(double concentration)
	{
		initialConcentration = concentration;
		getReactor().setInitialConcentration(concentration);
	}
	
	public void setRateConstant(double rate)
	{
		getReactor().setRateConstant(rate);
	}
	
	public void setCurrentTime(double time)
	{
		getReactor().setCurrentTime(time);
	}
	
	public int getXPos()
	{
		return xPos;
	}
	
	public void setXPos()
	{
		xPos++;
	}
	
	public void resetXPos()
	{
		
	}
	
	public void startReaction()
	{
		reactionTimer.start();
	}
	
	public void stopReaction()
	{
		reactionTimer.stop();
	}

	public void startAnimation()
	{
		animationTimer.start();
	}
	
	public void stopAnimation()
	{
		animationTimer.stop();
	}
	
	public void setAnimationTimer(int delay)
	{
		animationTimer.setDelay(delay);
	}

	public void setReactionTimer(int delay)
	{
		reactionTimer.setDelay(delay);
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
		currentNumberOfDots = index;
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
	
	public FFBatchReactor getReactor() 
	{
		return reactor;
	}

	public void setReactor(FFBatchReactor newReactor) 
	{
		reactor = null;
		reactor = newReactor;
	}
	
	public void setDotDiameter(int diameter)
	{
		
	}

	public int getUpperCornerX() 
	{
		return upperCornerX;
	}

	public void setUpperCornerX(int upperCornerX) 
	{
		this.upperCornerX = upperCornerX;
	}

	class AnimationTimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			clearDots();
			currentNumberOfDots = (int) (reactor.getPercentageOfConcentrationLeft() * totalNumberOfDots);
			makeDots();
			repaint();
		}
	}
	
	class ReactionTimerListener implements ActionListener 
	{
		DecimalFormat df =  new DecimalFormat("#.##");
		public void actionPerformed(ActionEvent evt) 
		{
			reactor.setCurrentTime(reactor.getCurrentTime() + 1);
			if (txtConcentrationLog != null)
			{
				txtConcentrationLog.setText ("Concentration at time "
				+ (int) reactor.getCurrentTime() + " is "
				+ df.format(reactor.getPercentageOfConcentrationLeft() * 100 ) + "%\n" +  txtConcentrationLog.getText() );
			}
			clearDots();
			currentNumberOfDots = (int) (reactor.getPercentageOfConcentrationLeft() * totalNumberOfDots);
			//setLastDot((int) (reactor.getCurrentConcentration() / Double.parseDouble(txtInitialConcentration.getText())* Integer.parseInt(txtParticleNumber.getText())));
			makeDots();
			repaint();
		}
	}
}

