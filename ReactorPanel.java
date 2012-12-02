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
import javax.swing.JLabel;

public class ReactorPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private ArrayList<FFDot> dots;
	private int totalNumberOfDots;
	private int currentNumberOfDots;
	private JTextArea txtConcentrationLog;
	private int dotDiameter;
	private int upperCornerX;
	private Color dotColor;
	private Color backgroundColor;
	private Timer animationTimer;
	private Timer reactionTimer;
	private FFReactor reactor;
	private JLabel concentrationLabel;
	private JLabel percentageLabel;
	
	public ReactorPanel(int numDots, int diameter, int upperCornerX, int rDelta, int aDelta)
	{
		this.setUpperCornerX(upperCornerX);
		dotDiameter = diameter;
		totalNumberOfDots = numDots;
		currentNumberOfDots = numDots;
		dots = new ArrayList<FFDot>();
		dotColor = Color.RED;
		backgroundColor = Color.WHITE;
		setBackground(backgroundColor);
		setAnimationTimer(new Timer(aDelta, new AnimationTimerListener()));
		setReactionTimer(new Timer(rDelta, new ReactionTimerListener()));
		getAnimationTimer().setRepeats(true);
		getReactionTimer().setRepeats(true);
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
	
	public void setDotColor(Color RGB){
		dotColor = RGB;
	}
	
	public void setBgColor(Color RGB){
		backgroundColor = RGB;
		setBackground(backgroundColor);
	}
	
	public void setDotSize(int sz){
		dotDiameter = sz;
	}
	
	public void setAnimationTimer(Timer t)
	{
		animationTimer = t;
	}
	
	public Timer getAnimationTimer()
	{
		return animationTimer;
	}
	
	public void setReactionTimer(Timer t)
	{
		reactionTimer = t;
	}
	
	public Timer getReactionTimer()
	{
		return reactionTimer;
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
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(dotColor);
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
	
	public void setReactionConstant(double rate)
	{
		reactor.setReactionConstant(rate);
	}
	
	public void setCurrentTime(double time)
	{
		reactor.setCurrentTime(time);
	}
	
	public FFReactor getReactor() 
	{
		return reactor;
	}

	public void setReactor(FFReactor newReactor) 
	{
		reactor = null;
		reactor = newReactor;
	}
	
	public JLabel getConcentrationLabel() {
		return concentrationLabel;
	}

	public void setConcentrationLabel(JLabel concentrationLabel) {
		this.concentrationLabel = concentrationLabel;
	}

	public JLabel getPercentageLabel() {
		return percentageLabel;
	}

	public void setPercentageLabel(JLabel percentageLabel) {
		this.percentageLabel = percentageLabel;
	}

	class AnimationTimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			clearDots();
			makeDots();
			repaint();
		}
	}
	
	class ReactionTimerListener implements ActionListener 
	{
		DecimalFormat df1 =  new DecimalFormat("#.####");
		DecimalFormat df2 =  new DecimalFormat("#.##");
		public void actionPerformed(ActionEvent evt) 
		{
			concentrationLabel.setText(df1.format(reactor.getCurrentConcentration()));
			percentageLabel.setText(df2.format(reactor.getPercentageOfUpperLimit() * 100) + "%");
			reactor.setCurrentTime(reactor.getCurrentTime() + 1);
			if (getTextLogArea() != null)
			{
				getTextLogArea().append("Concentration at time "
				+ (int) reactor.getCurrentTime() + " is "
				+ df1.format(reactor.getCurrentConcentration()) + "\n");
			}
			clearDots();
			setCurrentNumberOfDots((int) (reactor.getPercentageOfConcentrationLeft() * getTotalNumberOfDots()));
			makeDots();
			repaint();
		}
	}
}
