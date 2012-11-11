import javax.swing.JApplet;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;


public class FluidFlowApplet extends JApplet {

	/**
	 * Create the applet.
	 */
	public FluidFlowApplet() {
		setBounds(0, 0, 800, 600);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {800, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		TabBatchReactor batchReactor = new TabBatchReactor();
		tabbedPane.addTab("Batch Reactor", null, batchReactor, null);
		
		TabConstantlyStirredReactor constantlyStirredReactor = new TabConstantlyStirredReactor();
		tabbedPane.addTab("Constantly Stirred Reactor", null, constantlyStirredReactor, null);
		
		TabPlugFlowReactor plugFlowReactor = new TabPlugFlowReactor();
		tabbedPane.addTab("Plug Flow Reactor", null, plugFlowReactor, null);
		
		Preferences preferences = new Preferences();
		tabbedPane.addTab("Preferences", null, preferences, null);

	}
}
