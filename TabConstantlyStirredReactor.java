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

public class TabConstantlyStirredReactor extends JPanel {

	private static final long serialVersionUID = 1L;
	private Preferences preferences;
	private JTextArea textLogArea;
	private JTextField txtInflowConcentration;
	private JTextField txtRateConstant;
	private FluidFlowReactorPanel2 panel2;
	private JTextField txtFlowRate;
	
	public TabConstantlyStirredReactor() {
		initialize();
	}
	
	public TabConstantlyStirredReactor(Preferences pref) {
		preferences = pref;
		initialize();
	}
	public TabConstantlyStirredReactor(LayoutManager layout) {
		super(layout);
		initialize();
	}

	public TabConstantlyStirredReactor(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initialize();
	}

	public TabConstantlyStirredReactor(LayoutManager layout,
			boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initialize();
	}

	private void initialize() 
	{
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		panel2 = new FluidFlowReactorPanel2(2000, 3, 0, 100, 500);
		panel2.setBorder(new LineBorder(preferences.getContinuouslyStirredBorderColor(), 4));
		panel2.setBounds(339, 138, 433, 358);
		panel2.setDotSize(preferences.getContinuouslyStirredParticleSize());
		panel2.setDotColor(preferences.getContinuouslyStirredParticleColor());
		panel2.setBackground(preferences.getBatchBackgroundColor());
		add(panel2);

		JLabel lblInitialConcentration = new JLabel("Inflow Concentration");
		lblInitialConcentration.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInitialConcentration.setBounds(30, 110, 192, 15);
		add(lblInitialConcentration);

		txtInflowConcentration = new JTextField();
		lblInitialConcentration.setLabelFor(txtInflowConcentration);
		txtInflowConcentration.setText(preferences.getContinuouslyStirredInitialC().toString());
		txtInflowConcentration.setBounds(181, 107, 114, 19);
		add(txtInflowConcentration);

		JLabel lblNewLabel = new JLabel("Rate Constant per Minute");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(30, 137, 192, 15);
		add(lblNewLabel);

		txtRateConstant = new JTextField();
		txtRateConstant.setText(preferences.getContinuouslyStirredInitialK().toString());
		txtRateConstant.setBounds(181, 134, 114, 19);
		add(txtRateConstant);
		txtRateConstant.setColumns(10);

		JButton btnGo = new JButton("Go");
		btnGo.setBackground(new Color(0, 128, 0));
		btnGo.setForeground(new Color(240, 255, 255));
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnGo.addActionListener(new ButtonGoListener());
		btnGo.setBounds(65, 11, 174, 71);
		add(btnGo);

		JButton btnStop = new JButton("Stop");
		btnStop.setBackground(new Color(255, 0, 0));
		btnStop.setForeground(new Color(240, 255, 255));
		btnStop.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnStop.addActionListener(new ButtonStopListener());
		btnStop.setBounds(309, 11, 174, 71);
		add(btnStop);

		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(240, 255, 255));
		btnReset.setBackground(new Color(184, 134, 11));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnReset.addActionListener(new ButtonResetListener());
		btnReset.setBounds(551, 11, 174, 71);
		add(btnReset);

		JLabel lblCstrVisualization = new JLabel("CSTR Visualization");
		lblCstrVisualization.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCstrVisualization.setBounds(452, 107, 192, 27);
		add(lblCstrVisualization);

		textLogArea = new JTextArea();
		JScrollPane logPane = new JScrollPane(textLogArea);
		textLogArea.setFocusable(false);
		logPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textLogArea.setBackground(new Color(245, 245, 220));
		logPane.setBounds(23, 265, 375, 264);
		panel2.setLogTextArea(textLogArea);
		JLabel lblCstrData = new JLabel("CSTR Data");
		lblCstrData.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCstrData.setBounds(113, 253, 107, 27);
		add(lblCstrData);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(30, 281, 265, 264);
		panel.add(logPane);
		add(panel);
		
		JLabel lblInflowRate = new JLabel("Inflow Rate");
		lblInflowRate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInflowRate.setBounds(30, 163, 114, 14);
		add(lblInflowRate);
		
		txtFlowRate = new JTextField();
		txtFlowRate.setText(preferences.getContinuouslyStirredFlowRate().toString());
		txtFlowRate.setBounds(181, 161, 114, 20);
		add(txtFlowRate);
		txtFlowRate.setColumns(10);
		
		JButton applyButton = new JButton("Apply");
		applyButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		applyButton.setToolTipText("Click here to apply parameter changes");
		applyButton.setBounds(206, 192, 89, 33);
		applyButton.addActionListener(new ApplyButtonListener());
		add(applyButton);
		
		JLabel lblNewLabel_1 = new JLabel("0.0");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(624, 507, 101, 14);
		panel2.setConcentrationLabel(lblNewLabel_1);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("0.00%");
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(624, 532, 101, 14);
		panel2.setPercentageLabel(lblNewLabel_2);
		add(lblNewLabel_2);
		
		JLabel lblCurrentConcentration = new JLabel("Current Concentration:");
		lblCurrentConcentration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCurrentConcentration.setBounds(339, 507, 183, 18);
		add(lblCurrentConcentration);
		
		JLabel lblPercentageOfInflow = new JLabel("Percentage of Inflow Concentation:");
		lblPercentageOfInflow.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPercentageOfInflow.setBounds(339, 536, 250, 14);
		add(lblPercentageOfInflow);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(176, 196, 222));
		panel_1.setBounds(0, 0, 800, 91);
		add(panel_1);

		resetReactor();

	}

	private void resetReactor() {

		panel2.setInflowConcentration(Double
				.parseDouble(txtInflowConcentration.getText()));
		panel2.getReactor().setCurrentConcentration(0.0);
		panel2.setReactionConstant(Double.parseDouble(txtRateConstant.getText()));
		panel2.setCurrentTime(0);
		textLogArea.setText("");
		panel2.getConcentrationLabel().setText("0.0");
		panel2.getPercentageLabel().setText("0.00%");
		panel2.clearDots();
		panel2.setCurrentNumberOfDots(0);
		panel2.repaint();
		
	}

	class ButtonGoListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
			panel2.startAnimation();
			panel2.startReaction();
		}
	}

	class ButtonStopListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
			panel2.stopReaction();
			panel2.stopAnimation();
		}
	}

	class ButtonResetListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
			resetReactor();
		}
	}
	
	class ApplyButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			panel2.setInflowConcentration(Double.parseDouble(txtInflowConcentration.getText()));
			panel2.getReactor().setReactionConstant(Double.parseDouble(txtRateConstant.getText()));
			panel2.setFlowRate(Double.parseDouble(txtFlowRate.getText()));
		}
	}
}
