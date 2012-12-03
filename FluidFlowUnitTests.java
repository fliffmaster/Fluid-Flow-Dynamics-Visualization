
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
		if(batch.getCurrentConcentration() == 1.0)
			System.out.println("Test 1 Passed");
		else
			System.out.println("Test 1 Failed");
		
		if(batch.getPercentageOfUpperLimit() == 1.0)
			System.out.println("Test 2 Passed");
		else
			System.out.println("Test 2 Failed");
		
		if(pfr.getFlowing() == true)
			
		
		batch.doReactionStep();
		cstr.doReactionStep();
		pfr.toggleFlowing();
	
		if(batch.getCurrentConcentration() == 0.9)
		{
			System.out.println(batch.getCurrentConcentration());
			System.out.println("Test 3 Passed");
		}
		else
			System.out.println("Test 3 Failed");
		System.out.println(batch.getCurrentConcentration());
		if(batch.getPercentageOfUpperLimit() == 0.9)
			System.out.println("Test 4 Passed");
		else
			System.out.println("Test 4 Failed");
		
		batch.setInitialConcentration(0.0);
		assert(batch.getPercentageOfUpperLimit() == (Double) null);
		
		
	}
}
