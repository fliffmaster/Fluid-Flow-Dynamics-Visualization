import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	private ArrayList<FluidFlowReactorPanel> batchPanels;
	//private FluidFlowReactorPanel[] batchPanels;
	private int x = 0;
	private Timer timer = new Timer(209, new TimerListener());
	private int batchPanelWidth;
	int upperCornerX;
	
	public PFR()
	{
		
		batchPanelWidth = /*this.getWidth()*/ 626 / 20;
		//panel_1 = new FluidFlowReactorPanel(2090, 2);
		batchPanels = new ArrayList<FluidFlowReactorPanel>();
		
		
		
//		batchPanels.add(new FluidFlowReactorPanel(1000, 2, batchPanelWidth));
//		for(FluidFlowReactorPanel f : batchPanels)
//			add(f);
		//add(batchPanels.get(0));
		
//		for(int i = 0; i < 22; i++)
//		{			
//			batchPanels[i] = new FluidFlowReactorPanel(1000, 2, upperCornerX);
//			batchPanels[i].setBounds(upperCornerX, 0, batchPanelWidth, 209);
//			add(batchPanels[i]);
//			batchPanels[i].setLayout(null);
//		}
		
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
		int size = batchPanels.size();
		
		for(int i = 0; i < size; i++)
			batchPanels.get(i).setAnimationTimer(delay);	
	}
	
	public void setReactor(FFBatchReactor newReactor, int index) {
		batchPanels.get(index).setReactor(newReactor);
		
	}
	
	public void startAnimation(){
		timer.start();
		int size = batchPanels.size();
		for(int i = 0; i < size; i++)
			batchPanels.get(i).startAnimation();
		
		//panel_1.startReaction();
	}
	
	public void startReactor()
	{
		for(FluidFlowReactorPanel f : batchPanels)
			f.startReaction();
	}
	
	public void beginAnimation()
	{
		batchPanels.add(new FluidFlowReactorPanel(1000, 2, batchPanelWidth));
		for(FluidFlowReactorPanel f : batchPanels)
			add(f);
	}
	
	public void stopReactor()
	{
		timer.stop();
		int size = batchPanels.size();
		for(int i = 0; i < size; i++)
			batchPanels.get(i).stopReaction();
		//panel_1.stopReaction();
	}
	
	public void stopAnimation()
	{
		for(FluidFlowReactorPanel f : batchPanels)
			f.stopAnimation();
	}
	
	public void resetBatchReactorLocation()
	{
//		int size = batchPanels.size();
		
//		for(FluidFlowReactorPanel f : batchPanels)
	//		f.setBounds(f.getUpperCornerX(), 0, batchPanelWidth, 209);
		//for(FluidFlowReactorPanel f: batchPanels)
		removeAll();
		batchPanels.clear();
		System.out.println(batchPanels.isEmpty());
		
		
		
//		for(int i = 0; i < size; i++)
//		{
//			batchPanels.get(i).setBounds(batchPanels.get(i).getUpperCornerX(), 0, batchPanelWidth, 209);
//		}
		//panel_1.setBounds(x, 0, 40, 209);
		repaint();
		
	}
	
	class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg) 
		{
			int size = batchPanels.size();
			for(FluidFlowReactorPanel f : batchPanels)
			{
				f.setXPos();
				f.setBounds(f.getXPos(), 0, batchPanelWidth, 209);
				if(f.getXPos() >= 0)
					f.startReaction();	
			}
			if(batchPanels.get(size - 1).getXPos() >= 0)
			{
				batchPanels.add(new FluidFlowReactorPanel(1000, 2, batchPanelWidth));
				add(batchPanels.get(size));
			}
			
			
			repaint();
		}	
	}
}
