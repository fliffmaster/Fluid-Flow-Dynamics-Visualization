public class FluidFlowReactorPanel2 extends ReactorPanel
{
	private static final long serialVersionUID = 1L;
	
	public FluidFlowReactorPanel2(int numDots, int diameter, int upperCornerX, int rDelta, int aDelta)
	{
		super(numDots, diameter, upperCornerX, rDelta, aDelta);
		setReactor(new FFCSTReactor());
	}
	
	public void setInflowConcentration(double concentration)
	{
		FFCSTReactor react = (FFCSTReactor) getReactor();
		react.setInflowConcentration(concentration);
	}
}
