
public abstract class FFReactor {
	private double tFinal;
	private double kInit;
	private double cCurr;
	private double tCurr;
	
	public FFReactor()
	{
		this(1000.0, 0.1, 1.0);
	}
	
	public FFReactor(double tFinal, double kInit, double cCurr)
	{
		this.tFinal = tFinal;
		this.tCurr = 0;
		this.kInit = kInit;
		this.cCurr = cCurr;
	}

	public abstract double getPercentageOfConcentrationLeft();
	public abstract void doReactionStep();
	
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
