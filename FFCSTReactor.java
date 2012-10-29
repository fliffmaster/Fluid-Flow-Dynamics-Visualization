
public class FFCSTReactor {
	
	private double tFinal;
	private double cIn;
	private double kInit;
	private double tCurr;
	private double cCurr;
	private double flowRate;
	private double reactorVolume;
	private double defaultConcentration;
	
	public FFCSTReactor()
	{
		this(1000.0, 1.0, 0.01, 1.0, 10.0, 1.0);
	}
	
	public FFCSTReactor(double tFinal, double cIn, double kInit, double flowRate, double reactorVolume, double defaultConcentration)
	{
		this.settFinal(tFinal);
		this.setcIn(cIn);
		this.setkInit(kInit);
		this.settCurr(0.0);
		this.setCCurr(0.0);
		this.setFlowRate(flowRate);
		this.setReactorVolume(reactorVolume); 
		this.setDefaultConcentration(defaultConcentration);
	}
	
	public double getCurrentConcentration()
	{
		cCurr = cCurr * (1 - flowRate / reactorVolume) + cIn * (flowRate / reactorVolume);
		cCurr = cCurr - (kInit * cCurr);
		return cCurr;
	}
	
	public double getPercentageOfConcentrationLeft(){
		return getCCurr() / defaultConcentration;
	}

	public double getFlowRate() {
		return flowRate;
	}

	public void setFlowRate(double flowRate) {
		this.flowRate = flowRate;
	}

	public double gettFinal() {
		return tFinal;
	}

	public void settFinal(double tFinal) {
		this.tFinal = tFinal;
	}

	public double getcIn() {
		return cIn;
	}

	public void setcIn(double cIn) {
		this.cIn = cIn;
	}

	public double getkInit() {
		return kInit;
	}

	public void setkInit(double kInit) {
		this.kInit = kInit;
	}

	public double gettCurr() {
		return tCurr;
	}

	public void settCurr(double tCurr) {
		this.tCurr = tCurr;
	}

	public double getCCurr() {
		return cCurr;
	}

	public void setCCurr(double cCurr) {
		this.cCurr = cCurr;
	}

	public double getReactorVolume() {
		return reactorVolume;
	}

	public void setReactorVolume(double reactorVolume) {
		this.reactorVolume = reactorVolume;
	}

	public double getDefaultConcentration() {
		return defaultConcentration;
	}

	public void setDefaultConcentration(double defaultConcentration) {
		this.defaultConcentration = defaultConcentration;
	}
	
	
}
