import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class PFR extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private WaterSlice panel_1 = new WaterSlice();
	private FluidFlowReactorPanel panel_1;
	private int x = 0;
	private Timer timer = new Timer(200, new TimerListener());
	
	public PFR()
	{
		
		panel_1 = new FluidFlowReactorPanel(2000, 2);
		
		timer.setRepeats(true);
		panel_1.setBounds(0, 0, 40, 209);
		add(panel_1);
		panel_1.setLayout(null);
		
	}
	
//	public void setReactorPanel(FluidFlowReactorPanel newPanel){
//		panel_1 = newPanel;
//		panel_1.setBounds(x, 0, 10, 209);
//		add(panel_1);
//		panel_1.setLayout(null);
//	}
	public void setAnimationTimer(int delay){
		panel_1.setAnimationTimer(delay);
		
	}
	public void setReactor(FFBatchReactor newReactor) {
		panel_1.setReactor(newReactor);
		
	}
	
	public void startReactor(){
		timer.start();
		panel_1.startAnimation();
		//panel_1.startReaction();
	}
	
	public void stopReactor(){
		timer.stop();
		panel_1.stopAnimation();
		//panel_1.stopReaction();
	}
	
	
	
	class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg) 
		{
			x++;
			panel_1.setBounds(x, 0, 40, 209);
			repaint();
		}
		
	}
}
