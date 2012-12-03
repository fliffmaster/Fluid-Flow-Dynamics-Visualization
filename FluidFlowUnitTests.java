
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
		
		if(cstr.getCurrentConcentration() == 0.0)
			System.out.println("Test 3 Passed");
		else
			System.out.println("Test 3 Failed");
		
		if(cstr.getPercentageOfUpperLimit() == 1.0)
			System.out.println("Test 4 Passed");
		else
			System.out.println("Test 4 Failed");
		
		if(pfr.getFlowing() == true)
			System.out.println("Test 5 Passed");
		else
			System.out.println("Test 5 Failed");
		
			
		batch.setCurrentTime(batch.getCurrentTime() + 1);
		cstr.setCurrentTime(batch.getCurrentTime() + 1);
		batch.doReactionStep();
		cstr.doReactionStep();
		pfr.toggleFlowing();
	
		if(batch.getCurrentConcentration() < 1)
			System.out.println("Test 6 Passed");
		else
			System.out.println("Test 6 Failed");
		if(batch.getPercentageOfUpperLimit() < 1)
			System.out.println("Test 7 Passed");
		else
			System.out.println("Test 7 Failed");
		if(pfr.getFlowing() == false)
			System.out.println("Test 8 Passed");
		else
			System.out.println("Test 8 Failed");
		
		
		batch.setInitialConcentration(0.0);
		if(batch.getPercentageOfUpperLimit() == 0.0)
			System.out.println("Test 9 Passed");
		else
			System.out.println("Test 9 Failed");
		
		
	}
}
