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
	private FluidFlowReactorPanel[] batchPanels;
	private int x = 0;
	private Timer timer = new Timer(209, new TimerListener());
	private int batchPanelWidth;
	
	public PFR()
	{
		batchPanelWidth = this.getWidth() / 20;
		//panel_1 = new FluidFlowReactorPanel(2090, 2);
		batchPanels = new FluidFlowReactorPanel[22];
		
		for(int i = 0; i < 22; i++)
		{
			int upperCornerX = i * batchPanelWidth * (-1);
			batchPanels[i] = new FluidFlowReactorPanel(1000, 2, upperCornerX);
			batchPanels[i].setBounds(upperCornerX, 0, batchPanelWidth, 209);
			add(batchPanels[i]);
			batchPanels[i].setLayout(null);
		}
		
		timer.setRepeats(true);
		//panel_1.setBounds(0, 0, 40, 209);
		//add(panel_1);
		//panel_1.setLayout(null);
		
	}
	
//	public void setReactorPanel(FluidFlowReactorPanel newPanel){
//		panel_1 = newPanel;
//		panel_1.setBounds(x, 0, 10, 209);
//		add(panel_1);
//		panel_1.setLayout(null);
//	}
	public void setAnimationTimers(int delay){
		for(int i = 0; i < 22; i++)
			batchPanels[i].setAnimationTimer(delay);	
	}
	
	public void setReactor(FFBatchReactor newReactor, int index) {
		batchPanels[index].setReactor(newReactor);
		
	}
	
	public void startReactor(){
		timer.start();
		for(int i = 0; i < 22; i++)
			batchPanels[i].startAnimation();
		
		//panel_1.startReaction();
	}
	
	public void stopReactor(){
		timer.stop();
		for(int i = 0; i < 22; i++)
			batchPanels[i].stopAnimation();
		//panel_1.stopReaction();
	}
	
	public void resetBatchReactorLocation()
	{
		for(int i = 0; i < 22; i++)
			batchPanels[i].setBounds(batchPanels[i].getUpperCornerX(), 0, batchPanelWidth, 209);
		//panel_1.setBounds(x, 0, 40, 209);
		repaint();
		
	}
	
	class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg) 
		{
			x++;
			for(int i = 0; i < 22; i++)
			{
				batchPanels[i].setBounds(batchPanels[i].getUpperCornerX() + x, 0, batchPanelWidth, 209);
				if(batchPanels[i].getUpperCornerX() + x == 0)
					batchPanels[i].startReaction();	
			}
			repaint();
		}
		
	}
}
