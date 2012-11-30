public class FFCSTReactor extends FFReactor 
{	
	private double cIn;
	private double flowRate;
	private double reactorVolume;
	private double defaultConcentration;
	
	public FFCSTReactor()
	{	//Default values: Inflow concentration = 1.0, reaction constant = 0.001,
		//Reactor Volume = 100, Flow Rate = 1.0, Default Concentration = 1.0
		this(1000.0, 1.0, 0.001, 1.0, 100.0, 1.0);
	}
	
	public FFCSTReactor(double tFinal, double cIn, double kInit, double flowRate, double reactorVolume, double defaultConcentration)
	{
		super(tFinal, kInit, 0);
		this.cIn = cIn;
		this.flowRate = flowRate;
		this.reactorVolume = reactorVolume;
		this.defaultConcentration = defaultConcentration;
	}
	
	//Finds current concentration as weighted average of previous reactor concentration
	//and inflow concentration in proper proportions.  Then decrements the concentration
	//according to the first order diffEq C = C - kC
	public void doReactionStep()
	{
		setCurrentConcentration(getCurrentConcentration() * (1 - flowRate / reactorVolume) + cIn * (flowRate / reactorVolume));
		setCurrentConcentration(getCurrentConcentration() - (getReactionConstant() * getCurrentConcentration()));
	}
	
	//Proceeds 1 reaction step and returns ratio or current concentration
	//to default concentration as a percentage
	public double getPercentageOfConcentrationLeft()
	{
		doReactionStep();
		return getCurrentConcentration() / defaultConcentration;
	}
	
	//This version only returns percentage w/o executing a reaction step.
	//Not yet used
	public double getPercentageOfUpperLimit()
	{
		return getCurrentConcentration() / cIn;
	}

	// Accessor and mutator methods for CSTR specific variables
	public double getFlowRate() 
	{
		return flowRate;
	}

	public void setFlowRate(double flowRate) 
	{
		this.flowRate = flowRate;
	}

	public double getInflowConcentration() 
	{
		return cIn;
	}

	public void setInflowConcentration(double cIn) 
	{
		this.cIn = cIn;
	}

	public double getReactorVolume() 
	{
		return reactorVolume;
	}

	public void setReactorVolume(double reactorVolume) 
	{
		this.reactorVolume = reactorVolume;
	}

	public double getDefaultConcentration() 
	{
		return defaultConcentration;
	}

	public void setDefaultConcentration(double defaultConcentration) 
	{
		this.defaultConcentration = defaultConcentration;
	}
}
