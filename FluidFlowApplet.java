import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class FluidFlowApplet extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame MainFrame;
	private Container appPane;
	private boolean isApplet;

	/**
	 * Create the applet.
	 */
	public FluidFlowApplet() {
		appPane = getContentPane();
		isApplet = true;
		initialize();

	}

	public FluidFlowApplet(boolean b) {
		MainFrame = new JFrame();
		MainFrame.setTitle("Fluid Flow Dynamics Visualization");
		MainFrame.setBounds(100, 100, 850, 650);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appPane = MainFrame.getContentPane();
		isApplet = false;
		initialize();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FluidFlowApplet window = new FluidFlowApplet(false);
					window.MainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void initialize() {
		appPane.setBounds(0, 0, 800, 600);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 800, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		appPane.setLayout(gridBagLayout);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		appPane.add(tabbedPane, gbc_tabbedPane);
		Preferences preferences = new Preferences();

		if (isApplet == false)
			preferences.loadPreferences();

		TabBatchReactor batchReactor = new TabBatchReactor(preferences);
		tabbedPane.addTab("Batch Reactor", null, batchReactor, null);

		TabConstantlyStirredReactor constantlyStirredReactor = new TabConstantlyStirredReactor(
				preferences);
		tabbedPane.addTab("Constantly Stirred Reactor", null,
				constantlyStirredReactor, null);

		TabPlugFlowReactor plugFlowReactor = new TabPlugFlowReactor(preferences);
		tabbedPane.addTab("Plug Flow Reactor", null, plugFlowReactor, null);

		// TabBatchReactor batchReactor = new TabBatchReactor();
		// tabbedPane.addTab("Batch Reactor", null, batchReactor, null);
		//
		// TabConstantlyStirredReactor constantlyStirredReactor = new
		// TabConstantlyStirredReactor();
		// tabbedPane.addTab("Constantly Stirred Reactor", null,
		// constantlyStirredReactor, null);
		//
		// TabPlugFlowReactor plugFlowReactor = new TabPlugFlowReactor();
		// tabbedPane.addTab("Plug Flow Reactor", null, plugFlowReactor, null);

		if (isApplet == false)
			tabbedPane.addTab("Preferences", null, preferences, null);
	}

}
