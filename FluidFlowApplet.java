//////////////////////////////////////////////////////////////////////////////////
// Class: 	FluidFlowApplet
//
// Purpose: This class is the top level application class for our project.  It
//			provides logic for running the application as an applet or as an
//			application.  It constructs a JTabbedPane in whatever frame it is
//			running in, and then adds each of the 3 "Tab" reactor JPanel type
//			classes to their own tab, along with adding a Preferences object to
//			the 4th tab.
//
//////////////////////////////////////////////////////////////////////////////////

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class FluidFlowApplet extends JApplet 
{
	private static final long serialVersionUID = 1L;
	private JFrame MainFrame;
	private Container appPane;
	private boolean isApplet; //based on val of this var, run as application or applet
	
	//Applet constructor
	public FluidFlowApplet() 
	{
		appPane = getContentPane();
		isApplet = true;
		initialize();

	}
	
	//Application constructor
	public FluidFlowApplet(boolean b) 
	{
		MainFrame = new JFrame();
		MainFrame.setTitle("Fluid Flow Dynamics Visualization");
		MainFrame.setBounds(100, 100, 820, 650);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appPane = MainFrame.getContentPane();
		isApplet = false;
		initialize();
	}
	
	//Main method for creating the applet/application
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					FluidFlowApplet window = new FluidFlowApplet(false);
					window.MainFrame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	//All objects required by our application other than a frame are
	//constructed within this initialize() method
	private void initialize() 
	{
		
		//Set the bounds/layout of the content pane
		appPane.setBounds(0, 0, 800, 600);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 800, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		appPane.setLayout(gridBagLayout);
		
		//Set the bounds/layout of the JTabbedPane
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		appPane.add(tabbedPane, gbc_tabbedPane);
		
		Preferences preferences = new Preferences();
		if (isApplet == false) //preferences option not available for applet
			preferences.loadPreferences();

		//Create the 3 "Tab" Reactor classes (1 for each reactor type)
		//and add them to the JTabbedPanel
		TabBatchReactor batchReactor = new TabBatchReactor(preferences);
		tabbedPane.addTab("Batch Reactor", null, batchReactor, null);

		TabConstantlyStirredReactor constantlyStirredReactor = new TabConstantlyStirredReactor(
				preferences);
		tabbedPane.addTab("Constantly Stirred Reactor", null,
				constantlyStirredReactor, null);

		TabPlugFlowReactor plugFlowReactor = new TabPlugFlowReactor(preferences);
		tabbedPane.addTab("Plug Flow Reactor", null, plugFlowReactor, null);
		
		//Set the Preferences object's reactor variables
		preferences.setBatch(batchReactor);
		preferences.setConstantlyStirred(constantlyStirredReactor);
		preferences.setPlugFlow(plugFlowReactor);

		//No preferences tab for an applet
		if (isApplet == false)
			tabbedPane.addTab("Preferences", null, preferences, null);
	}

}
