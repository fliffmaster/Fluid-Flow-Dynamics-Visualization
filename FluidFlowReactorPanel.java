public class FluidFlowReactorPanel extends ReactorPanel
{
	private static final long serialVersionUID = 1L;
	private int xPos;
	
	
	public FluidFlowReactorPanel(int numDots, int diameter, int upperCornerX, int rDelta, int aDelta)
	{
		super(numDots, diameter, upperCornerX, rDelta, aDelta);
		setReactor(new FFBatchReactor());
		xPos = -upperCornerX;
	}
	
	public void setInitialConcentration(double concentration)
	{
		FFBatchReactor react = (FFBatchReactor) getReactor();
		react.setInitialConcentration(concentration);
	}
	
	public int getXPos()
	{
		return xPos;
	}
	
	//We need to make this a user variable so flow rate is a variable (also possible needs to be linked
	//with batch panel width somehow for less gaps between plugs in PFR).
	public void setXPos()
	{
		xPos += 1;
	}
}

