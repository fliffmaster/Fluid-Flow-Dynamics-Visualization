//////////////////////////////////////////////////////////////////////////////////
// Class: 	TabBatchReactor
//
// Purpose: This class implements all the visual elements in the Batch Reactor
//			tab of the final application.  It is comprised of a 
//			FluidFlowReactorPanel, a JTextArea for data, text fields for entering
//			parameters, and buttons for controlling the reactor
//
//////////////////////////////////////////////////////////////////////////////////

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Panel;

public class TabBatchReactor extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Preferences preferences;
	private JTextField txtInitialConcentration;
	private JTextField txtRateConstant;
	private JTextArea textLogArea;
	private FluidFlowReactorPanel panel;
	private JTextField txtParticleNumber;
	private JTextField txtTimeRate;
	private JTextField txtParticleMoveRate;
	
	//Constructors all use the initialize() method
	public TabBatchReactor() {
		initialize();
	}
	
	public TabBatchReactor(Preferences pref) {
		preferences = pref;
		initialize();
	}
	public TabBatchReactor(LayoutManager layout) {
		super(layout);
		initialize();
	}

	public TabBatchReactor(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initialize();
	}

	public TabBatchReactor(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initialize();
	}

	//Constructs all objects in the Batch Reactor Tab of the application
	private void initialize() 
	{
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		//Create the reactor panel/set appearance based on preferences
		panel = new FluidFlowReactorPanel(2000, 3, 0, 50, 500);
		panel.setBorder(new LineBorder(preferences.getBatchBorderColor(), 4));
		panel.setBounds(339, 138, 433, 358);
		panel.setDotSize(preferences.getBatchParticleSize());
		panel.setDotColor(preferences.getBatchParticleColor());
		panel.setBackground(preferences.getBatchBackgroundColor());
		add(panel);

		//Create Labels for text fields
		JLabel lblInitialConcentration = new JLabel("Initial Concentration");
		lblInitialConcentration.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInitialConcentration.setBounds(30, 137, 192, 15);
		add(lblInitialConcentration);
		
		JLabel lblRateConstant = new JLabel("Rate Constant per Minute");
		lblRateConstant.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRateConstant.setBounds(30, 163, 114, 14);
		add(lblRateConstant);
		
		//Create text fields
		txtInitialConcentration = new JTextField();
		lblInitialConcentration.setLabelFor(txtInitialConcentration);
		txtInitialConcentration.setText(preferences.getBatchInitialC().toString() );
		txtInitialConcentration.setBounds(181, 134, 114, 19);
		add(txtInitialConcentration);

		txtRateConstant = new JTextField();
		txtRateConstant.setText(preferences.getBatchInitialK().toString() );
		txtRateConstant.setBounds(181, 161, 114, 20);
		add(txtRateConstant);
		txtRateConstant.setColumns(10);
		
		//Create reactor control buttons
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ButtonGoListener());
		btnGo.setBackground(new Color(0, 128, 0));
		btnGo.setForeground(new Color(240, 255, 255));
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnGo.setBounds(65, 11, 174, 71);
		add(btnGo);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ButtonStopListener());
		btnStop.setBackground(new Color(255, 0, 0));
		btnStop.setForeground(new Color(240, 255, 255));
		btnStop.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnStop.setBounds(309, 11, 174, 71);
		add(btnStop);

		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(240, 255, 255));
		btnReset.setBackground(new Color(184, 134, 11));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnReset.addActionListener(new ButtonResetListener());
		btnReset.setBounds(551, 11, 174, 71);
		add(btnReset);
		
		//Create label for reactor
		JLabel lblCstrVisualization = new JLabel("Batch Visualization");
		lblCstrVisualization.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCstrVisualization.setBounds(452, 107, 236, 27);
		add(lblCstrVisualization);
		
		//Create data log
		textLogArea = new JTextArea();
		JScrollPane logPane = new JScrollPane(textLogArea);
		textLogArea.setFocusable(false);
		logPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textLogArea.setBackground(new Color(245, 245, 220));
		logPane.setBounds(23, 265, 375, 264);
		panel.setLogTextArea(textLogArea);
		JLabel lblBatchData = new JLabel("Batch Data");
		lblBatchData.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBatchData.setBounds(113, 253, 107, 27);
		add(lblBatchData);
		
		//Create panel for data text area
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new BorderLayout());
		dataPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		dataPanel.setBounds(30, 281, 265, 264);
		dataPanel.add(logPane);
		add(dataPanel);
		
		//Create Apply button to apply new parameters entered by user in
		//text fields
		JButton applyButton = new JButton("Apply");
		applyButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		applyButton.setToolTipText("Click here to apply parameter changes");
		applyButton.setBounds(206, 192, 89, 33);
		applyButton.addActionListener(new ApplyButtonListener());
		add(applyButton);
		
		//Create dynamic concentration and percentage figures
		JLabel dynamicConcentrationLabel = new JLabel("0.0");
		dynamicConcentrationLabel.setForeground(new Color(0, 0, 255));
		dynamicConcentrationLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		dynamicConcentrationLabel.setBounds(624, 507, 101, 14);
		panel.setConcentrationLabel(dynamicConcentrationLabel);
		add(dynamicConcentrationLabel);
		
		JLabel dynamicPercentLabel = new JLabel("0.00%");
		dynamicPercentLabel.setForeground(new Color(0, 0, 255));
		dynamicPercentLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		dynamicPercentLabel.setBounds(624, 532, 101, 14);
		panel.setPercentageLabel(dynamicPercentLabel);
		add(dynamicPercentLabel);
		
		//Create labels for dynamic concentration and percentage figures
		JLabel lblCurrentConcentration = new JLabel("Current Concentration:");
		lblCurrentConcentration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentConcentration.setBounds(339, 507, 183, 18);
		add(lblCurrentConcentration);
		
		JLabel lblPercentageOfInflow = new JLabel("Percentage of Inflow Concentation:");
		lblPercentageOfInflow.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPercentageOfInflow.setBounds(339, 536, 250, 14);
		add(lblPercentageOfInflow);
		
		//Just a cosmetic panel
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(176, 196, 222));
		panel_1.setBounds(0, 0, 800, 91);
		add(panel_1);
		
		//Reset the reactor
		resetReactor();

	}
	
	public ReactorPanel getReactorPanel()
	{
		return panel;
	}
	
	//Resets the reactor by reseting the initial concentration
	//and reaction constant figures and dynamic label figures, 
	//then remaking the dots and repainting
	private void resetReactor() 
	{
		panel.setInitialConcentration(Double
				.parseDouble(txtInitialConcentration.getText()));
		panel.setReactionConstant(Double.parseDouble(txtRateConstant.getText()));
		panel.setCurrentTime(0);
		textLogArea.setText("");
		panel.getConcentrationLabel().setText(txtInitialConcentration.getText());
		panel.getPercentageLabel().setText("100.00%");
		panel.clearDots();
		panel.setCurrentNumberOfDots(panel.getTotalNumberOfDots());
		panel.makeDots();
		panel.repaint();
	}

	//Listener for the Go button
	class ButtonGoListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
			panel.startAnimation();
			panel.startReaction();

		}

	}

	//Listener for the Stop button
	class ButtonStopListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt)
		{
			panel.stopReaction();
			panel.stopAnimation();
		}
	}

	//Listener for the Reset button
	class ButtonResetListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
			resetReactor();
		}
	}
	
	//Listener for the apply changes button
	class ApplyButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			panel.setInitialConcentration(Double.parseDouble(txtInitialConcentration.getText()));
			panel.getReactor().setReactionConstant(Double.parseDouble(txtRateConstant.getText()));
		}
	}

}
