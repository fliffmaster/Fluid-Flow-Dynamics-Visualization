import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PFR extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FluidFlowReactorPanel> batchPanels;
	//private int x = 0;
	private Timer timer = new Timer(50, new TimerListener());
	private int batchPanelWidth;
	//private int upperCornerX;
	private boolean flowing = true;
	private boolean started = false;
	
	public PFR()
	{
		batchPanelWidth = /*this.getWidth()*/ 30;  //This is where we would put in a variable for user input on batch size
		batchPanels = new ArrayList<FluidFlowReactorPanel>();
		
		timer.setRepeats(true);		
	}
	
	public boolean isFlowing()
	{
		return flowing;
	}
	
	public void toggleFlowing()
	{
		if(flowing == true)
			flowing = false;
		else
			flowing = true;
	}
	
	public boolean isStarted()
	{
		return started;
	}
	
	public void toggleStarted()
	{
		if(started == false)
			started = true;
		else
			started = false;
	}

	public void setAnimationTimers(int delay)
	{
		for(FluidFlowReactorPanel f : batchPanels)
			f.setAnimationTimer(delay);
	}
	
	public void setReactor(FFBatchReactor newReactor, int index)
	{
		batchPanels.get(index).setReactor(newReactor);
	}
	
	public void startAnimation()
	{
		timer.start();
//		int size = batchPanels.size();
//		for(int i = 0; i < size; i++)
//			batchPanels.get(i).startAnimation();
		for(FluidFlowReactorPanel f : batchPanels)
			f.startAnimation();
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
		removeAll();
		batchPanels.clear();
		System.out.println(batchPanels.isEmpty());
		
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

			if(flowing == true)
			{
				if(batchPanels.get(size - 1).getXPos() >= 0)
				{
					batchPanels.add(new FluidFlowReactorPanel(1000, 2, batchPanelWidth));
					add(batchPanels.get(size));
					batchPanels.get(size).startAnimation();
				}
			}
			if(batchPanels.get(0).getXPos() == 600)
			{
				remove(0);
				batchPanels.remove(0);
			}

			repaint();
		}	
	}
}
