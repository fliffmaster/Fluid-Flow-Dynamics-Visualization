//////////////////////////////////////////////////////////////////////////////////
// Class: 	FFBatchReactor
//
// Purpose: This class encapsulates encapsulates the functionality of a batch
//			reactor by implementing FFReactor and adding a variable for initial
//			reactor concentration.
//
//////////////////////////////////////////////////////////////////////////////////

import java.lang.Math;

public class FFBatchReactor extends FFReactor 
{
	private double cInit;

	//Default constructor w/initial concentration of 1.0
	public FFBatchReactor()
	{
		super(); //default FFReactor constructor
		this.setInitialConcentration(1.0);
	}
	
	//Constructor for setting all variables.  Initial concentration
	//and current concentration are set to the same value initially.
	public FFBatchReactor(double time, double cInit, double reactionK)
	{
		super(time, reactionK, cInit);
		this.setInitialConcentration(cInit);
	}
	
	//Uses the equation C(current) = C(initial) * e^(-kt)
	public void doReactionStep()
	{
		setCurrentConcentration(cInit * Math.exp((-1) * getReactionConstant() * getCurrentTime()));
	}
	
	//Returns the ratio of the current concentration to the initial
	//concentration as a percentage.  This method does calls doReactionStep()
	//to set the current concentration since current concentration is not set
	//incrementally adjusted in this type of reactor like it is in the CSTR
	public double getPercentageOfConcentrationLeft()
	{
		doReactionStep();
		return getCurrentConcentration() / cInit;
	}
	
	public double getPercentageOfUpperLimit()
	{
		return getCurrentConcentration() / cInit;
	}
	
	//Accessor and mutator methods for Batch Reactor specific vars
	public double getInitialConcentration() {
		return cInit;
	}
	
	public void setInitialConcentration(double cInit) {
		this.cInit = cInit;
	}
}