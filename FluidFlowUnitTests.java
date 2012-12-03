import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

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
		/////////////////////FFBatchReactor class unit tests////////////////////
		if(batch.getCurrentConcentration() == 1.0)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		if(batch.getPercentageOfUpperLimit() == 1.0)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		batch.setCurrentTime(batch.getCurrentTime() + 1);
		batch.doReactionStep(); //test doReactionStep() method
		
		if(batch.getCurrentConcentration() < 1 || (batch.getCurrentConcentration() == 1.0 && batch.getReactionConstant() == 0.0))
			System.out.println("Test Passed"); //see if concentration decreased from reaction
		else
			System.out.println("Test Failed");
		if(batch.getPercentageOfUpperLimit() < 1) //see if percentage decreased from reaction
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		batch.setInitialConcentration(2.0); //test for handling of concentrations over 1.0
		batch.setCurrentTime(batch.getCurrentTime() + 1);
		batch.doReactionStep(); 
		
		if(batch.getCurrentConcentration() > 1)
			System.out.println("Test Passed"); //check that concentration is greater than 1
		else
			System.out.println("Test Failed");
		if(batch.getPercentageOfUpperLimit() < 1) //check to see that percentage is still less than 100%
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		batch.setInitialConcentration(0.0); //test for divide by zero handling
		
		if(batch.getPercentageOfUpperLimit() == 0.0)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		batch.setReactionConstant(2.0); //test to see that values over 1.0 are not accepted
		
		if(batch.getReactionConstant() <= 1.0)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
			
		
		////////////////////////FFCSTReactor class unit tests////////////////////////
		if(cstr.getCurrentConcentration() == 0.0)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		if(cstr.getPercentageOfUpperLimit() == 0.0)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		cstr.setCurrentTime(cstr.getCurrentTime() + 1);
		cstr.doReactionStep(); //test doReactionStep() method
		
		if(cstr.getCurrentConcentration() > 0 || (cstr.getCurrentConcentration() == 0.0 && cstr.getReactionConstant() == 0.0))
			System.out.println("Test Passed"); //see if concentration decreased from reaction
		else
			System.out.println("Test Failed");
		if(cstr.getPercentageOfUpperLimit() > 0) //see if percentage decreased from reaction
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		cstr.setInflowConcentration(0.0); //test for divide by zero handling
		
		if(cstr.getPercentageOfUpperLimit() == 0.0)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		cstr.setReactionConstant(2.0); //test to see that values over 1.0 are not accepted
		
		if(cstr.getReactionConstant() <= 1.0)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		/////////////////////PFR class unit tests///////////////////////////
		if(pfr.getFlowing() == true)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		pfr.toggleFlowing(); 	//test that if/else statement toggles
								//value correctly
		if(pfr.getFlowing() == false)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");	
		
		if(pfr.getStarted() == false)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		pfr.toggleStarted();	//test that if/else statement toggles
								//value correctly
		if(pfr.getStarted() == true)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		///////////////////////FFDot class unit tests//////////////////////////
		Rectangle rect = new Rectangle(0, 0, 100, 100);
		FFDot dot = new FFDot(rect, 2);
		Ellipse2D ellipse = dot.getEllipse();
		
		if(ellipse.getX() - 2 <= 100 && ellipse.getY() <= 100)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");	
		
		if(ellipse.getX() - 2 >= 0 && ellipse.getY() >= 0)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		dot.setDiameter(-2); //check to see that negative diameters are not accepted
		
		if(ellipse.getHeight() == 2 && ellipse.getWidth() == 2)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		dot.setDiameter(1); //check to see that boundary condition of 
							//diameter of 1 is accepted
		ellipse = dot.getEllipse();
		
		if(ellipse.getHeight() == 1 && ellipse.getWidth() == 1)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		dot.setDiameter(1); //check to see that boundary condition of 
							//diameter of 0 is not accepted
		ellipse = dot.getEllipse();
		
		if(ellipse.getHeight() == 1 && ellipse.getWidth() == 1)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		//////////////////////ReactorPanel class unit tests////////////////////
		
		if(panel.getDots().size() == 0) //check that ArrayList starts out empty
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		panel.makeDots(); //test that method makes correct # of dots
		
		if(panel.getDots().size() == 2000)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
		
		panel.clearDots(); //test that method clears all dots
		
		if(panel.getDots().size() == 0)
			System.out.println("Test Passed");
		else
			System.out.println("Test Failed");
	}
}
