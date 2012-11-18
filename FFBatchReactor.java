import java.lang.Math;

public class FFBatchReactor extends FFReactor //extends Thread
{
	private double cInit;

	public double getInitialConcentration() {
		return cInit;
	}
	
	public void setRateConstant(double rate)
	{
		setkInit(rate);
	}
	
	public void setCurrentTime(double time)
	{
		settCurr(time);
	}
	
	public double getCurrentTime()
	{
		return gettCurr();
	}

	public void setInitialConcentration(double cInit) {
		this.cInit = cInit;
	}

	public FFBatchReactor()
	{
		this(1,1000.0,0.01);
	}

	public FFBatchReactor(double time, double cInit, double reactionK)
	{
		super(time, reactionK, cInit);
		setInitialConcentration(cInit);
	}

	public void setCurrentConcentration()
	{
		setCCurr(cInit * Math.exp((-1) * getkInit() * gettCurr()));
	}
	
	public double getPercentageOfConcentrationLeft()
	{
		return getCCurr() / cInit;
	}
}