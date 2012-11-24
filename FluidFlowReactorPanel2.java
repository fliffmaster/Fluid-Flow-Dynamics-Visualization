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

public class FluidFlowReactorPanel2 extends ReactorPanel
{
	private Timer animationTimer;
	private Timer reactionTimer;
	private FFCSTReactor reactor;
	
	public FluidFlowReactorPanel2(int numDots, int diameter, int upperCornerX, int rDelta, int aDelta)
	{
		super(numDots, diameter, upperCornerX, rDelta, aDelta);
		reactor = new FFCSTReactor();
		animationTimer = new Timer(aDelta,new AnimationTimerListener());
		reactionTimer = new Timer(rDelta, new ReactionTimerListener());
		animationTimer.setRepeats(true);
		reactionTimer.setRepeats(true);
	}
	
	public void setInflowConcentration(double concentration)
	{
		reactor.setInflowConcentration(concentration);
	}
	
	public void setReactionConstant(double rate)
	{
		reactor.setReactionConstant(rate);
	}
	
	public void setCurrentTime(double time)
	{
		reactor.setCurrentTime(time);
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
	
	public FFCSTReactor getReactor() 
	{
		return reactor;
	}

	public void setReactor(FFCSTReactor newReactor) 
	{
		reactor = null;
		reactor = newReactor;
	}

	class AnimationTimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			clearDots();
			setCurrentNumberOfDots((int) (reactor.getPercentageOfConcentrationLeft() * getTotalNumberOfDots()));
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
			if (getTextLogArea() != null)
			{
				getTextLogArea().setText ("Concentration at time "
				+ (int) reactor.getCurrentTime() + " is "
				+ df.format(reactor.getPercentageOfConcentrationLeft() * 100 ) + "%\n" +  getTextLogArea().getText() );
			}
			clearDots();
			setCurrentNumberOfDots((int) (reactor.getPercentageOfConcentrationLeft() * getTotalNumberOfDots()));
			makeDots();
			repaint();
		}
	}
	
}
