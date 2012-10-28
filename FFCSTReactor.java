
public class FFCSTReactor {
	
	public double tFinal;
	public double cIn;
	public double kInit;
	public double tCurr;
	public double cOut;
	public double flowRate;
	
	public FFCSTReactor()
	{
		this(1000.0, 1.0, 0.01, 1.0);
	}
	
	public FFCSTReactor(double tFinal, double cIn, double kInit, double flowRate)
	{
		this.tFinal = tFinal;
		this.cIn = cIn;
		this.kInit = kInit;
		this.tCurr = 0.0;
		this.cOut = 0.0;
		this.flowRate = flowRate;
	}
}
