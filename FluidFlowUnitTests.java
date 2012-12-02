
public class FluidFlowUnitTests 
{
	public static void main(String[] args)
	{
		FFBatchReactor batch = new FFBatchReactor();
		FFCSTReactor cstr = new FFCSTReactor();
		PFR pfr = new PFR();
		ReactorPanel panel = new FluidFlowReactorPanel(2000, 3, 0, 50, 500);
		runTests(batch, cstr, pfr, panel);
	}
	
	public static void runTests(FFBatchReactor batch, FFCSTReactor cstr, PFR pfr, ReactorPanel panel)
	{
		batch.doReactionStep();
		cstr.doReactionStep();
		pfr.toggleFlowing();
		assert(pfr.)
	}
}
