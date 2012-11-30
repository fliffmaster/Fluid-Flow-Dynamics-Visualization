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
