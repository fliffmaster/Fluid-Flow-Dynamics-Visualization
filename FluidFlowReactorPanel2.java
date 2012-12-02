//////////////////////////////////////////////////////////////////////////////////
// Class: 	FluidFlowReactorPanel2
//
// Purpose: This class visually displays the CST reactor.  Unlike its sibling,
//			it has accessor and mutator methods for inflowConcentration and 
//			flowRate, instead of initialConcentration.
//
//////////////////////////////////////////////////////////////////////////////////

public class FluidFlowReactorPanel2 extends ReactorPanel
{
	private static final long serialVersionUID = 1L;
	
	//Constructor uses the 5 parameter constructor in ReactorPanel
	public FluidFlowReactorPanel2(int numDots, int diameter, int upperCornerX, int rDelta, int aDelta)
	{
		super(numDots, diameter, upperCornerX, rDelta, aDelta);
		setReactor(new FFCSTReactor());
	}
	
	//Must type cast in these accessor and mutator methods, since
	//all reactor types don't have the methods they use
	public void setInflowConcentration(double concentration)
	{
		FFCSTReactor react = (FFCSTReactor) getReactor();
		react.setInflowConcentration(concentration);
	}
	
	public double getInflowConcentration()
	{
		FFCSTReactor react = (FFCSTReactor) getReactor();
		return react.getInflowConcentration();
	}
	
	public void setFlowRate(double rate)
	{
		FFCSTReactor react = (FFCSTReactor) getReactor();
		react.setFlowRate(rate);
	}
	
	public double getFlowRate(double concentration)
	{
		FFCSTReactor react = (FFCSTReactor) getReactor();
		return react.getFlowRate();
	}
}
