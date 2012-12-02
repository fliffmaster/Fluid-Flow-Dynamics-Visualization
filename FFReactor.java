//////////////////////////////////////////////////////////////////////////////////
// Class: 	FFReactor
//
// Purpose: This class encapsulates the functionality of a basic reactor. It 
//			contains all functionality the two low level reactor classes,
//			FFBatchReactor and FFCSTReactor, share in common, and is their
//			parent.  It contains 3 methods which must be implemented at the child
//			level, so they are declared abstract and FFReactor is abstract.
//
//////////////////////////////////////////////////////////////////////////////////

public abstract class FFReactor 
{
	private double tFinal;
	private double kInit;
	private double cCurr;
	private double tCurr;
	
	public FFReactor()
	{
		//default values are 1000 time steps, k=0.1, and initial
		//concentration = 1.0
		this(1000.0, 0.1, 1.0);
	}
	
	public FFReactor(double tFinal, double kInit, double cCurr)
	{
		this.tFinal = tFinal;
		this.tCurr = 0;
		this.kInit = kInit;
		this.cCurr = cCurr;
	}
	
	//3 abstract methods implemented at children level
	public abstract double getPercentageOfConcentrationLeft();
	public abstract double getPercentageOfUpperLimit();
	public abstract void doReactionStep();
	
	//accessor and mutator methods for instance variables
	public double getCurrentTime() {
		return tCurr;
	}

	public void setCurrentTime(double tCurr) {
		this.tCurr = tCurr;
	}

	public double getCurrentConcentration() {
		return cCurr;
	}

	public void setCurrentConcentration(double cCurr) {
		this.cCurr = cCurr;
	}

	public double getReactionConstant() {
		return kInit;
	}

	public void setReactionConstant(double kInit) {
		this.kInit = kInit;
	}

	public double getFinalTime() {
		return tFinal;
	}

	public void setFinalTime(double tFinal) {
		this.tFinal = tFinal;
	}
}
