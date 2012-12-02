//////////////////////////////////////////////////////////////////////////////////
// Class: 	FluidFlowReactorPanel
//
// Purpose: This class visually displays the batch reactor.  It 
// 			also has a xPos variable for use in the PFR class since our plug flow
//			reactor is composed of moving batch reactors that are reacting as
//			they move. xPos keeps track of a reactors position in the PFR.
//
//////////////////////////////////////////////////////////////////////////////////

public class FluidFlowReactorPanel extends ReactorPanel
{
	private static final long serialVersionUID = 1L;
	private int xPos;
	
	//Constructor uses the 5 parameter constructor in ReactorPanel
	public FluidFlowReactorPanel(int numDots, int diameter, int upperCornerX, int rDelta, int aDelta)
	{
		super(numDots, diameter, upperCornerX, rDelta, aDelta);
		setReactor(new FFBatchReactor());
		xPos = -upperCornerX;
	}
	
	//Must type cast before trying to set initial concentration,
	//since all reactor types do not have this method
	public void setInitialConcentration(double concentration)
	{
		FFBatchReactor react = (FFBatchReactor) getReactor();
		react.setInitialConcentration(concentration);
	}
	
	//Getters and setters
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

