import java.lang.Math;

public class FFBatchReactor //extends Thread
{
	private double tFinal;
	private double cInit;
	private double kInit;
	private double tCurr;
	private double cCurr;
	//private double kCurr;

	public double getInitialConcentration() {
		return cInit;
	}

	public void setInitialConcentration(double cInit) {
		this.cInit = cInit;
	}

	public double getRateConstant() {
		return kInit;
	}

	public void setRateConstant(double kInit) {
		this.kInit = kInit;
	}

	public double getCurrentTime() {
		return tCurr;
	}

	public void setCurrentTime(double tCurr) {
		this.tCurr = tCurr;
	}

	public double getcCurr() {
		return cCurr;
	}


	public double gettFinal() {
		return tFinal;
	}

	//can add another variable for timestep size

	public FFBatchReactor()
	{
		this.tCurr = 0;
		this.tFinal = 1000;
		this.cInit = this.cCurr = 1;
		this.kInit =  0.001;
	}

	public FFBatchReactor(double time, double cInit, double reactionK)
	{
		this.tCurr = 0;
		this.tFinal = time;
		this.cInit = this.cCurr = cInit;
		this.kInit =  reactionK;
	}

//	public void reactionStep() //permanently alters tCurr and cCurr
//	{
//		decrementCurrentConcentration();
//		tCurr = tCurr + 1;
//	}

	public double getCurrentConcentration()
	{
		return cCurr = cInit * Math.exp((-1) * kInit * tCurr);
	}

//	public void decrementCurrentConcentration()
//	{
//		cCurr = cCurr - (kInit * cCurr);
//	}
//
//	public void run()
//	{
//		while(tCurr < tFinal)
//		{
//			System.out.print("Conc: " + cCurr + " Time: " + tCurr);
//			System.out.println(" Conc: " + getCurrentConcentration() + " Time: " + tCurr);
//			reactionStep();
//
//			try
//			{
//				Thread.sleep(400);
//			}
//			catch(InterruptedException e)
//			{
//				System.out.println("Couldn't sleep thread");
//			}
//		}
//	}
//
//	public static void main(String[] args)
//	{
//		FFBatchReactor reactor = new FFBatchReactor();
//		reactor.start();
//	}
}