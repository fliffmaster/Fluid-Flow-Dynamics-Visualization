import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TabPlugFlowReactor extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtInitialConcentration;
	private JTextField txtRateConstant;
	
	private JTextArea txtConcentrationLog;
	private JTextField txtParticleNumber;
	private JTextField txtTimeRate;
	private JTextField txtParticleMoveRate;
	private PFR  pfrPanel;
	private Preferences preferences;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public TabPlugFlowReactor() {
		initialize();
	}
	
	public TabPlugFlowReactor(Preferences pref) {
		preferences = pref;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//make the main frame for the application
		setBounds(0, 0, 800, 600);
		setLayout(null);
		
		//Initial Concentration Label
		JLabel lblInitialConcentration = new JLabel("Initial Concentration");
		lblInitialConcentration.setBounds(12, 67, 192, 15);
		add(lblInitialConcentration);
		
		//Make Initial Concentration text field
		txtInitialConcentration = new JTextField();
		lblInitialConcentration.setLabelFor(txtInitialConcentration);
		txtInitialConcentration.setText(preferences.getPlugFlowInitialC().toString());
		txtInitialConcentration.setBounds(239, 63, 114, 19);
		add(txtInitialConcentration);
		
		//NEED TO FIX THIS, SHOULD NOT DO THIS (when you click around fields w/o changing anything, the whole thing resets)
		txtInitialConcentration.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusLost(FocusEvent e) 
			{
				resetReactor();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Rate Constant per Minute");
		lblNewLabel.setBounds(12, 94, 192, 15);
		add(lblNewLabel);

		txtRateConstant = new JTextField();
		txtRateConstant.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				resetReactor();
			}
		});
		txtRateConstant.setText(preferences.getPlugFlowInitialK().toString());
		txtRateConstant.setBounds(239, 90, 114, 19);
		add(txtRateConstant);
		txtRateConstant.setColumns(10);

		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ButtonGoListener());
		btnGo.setBounds(247, 218, 81, 25);
		add(btnGo);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ButtonStopListener());
		btnStop.setBounds(338, 218, 71, 25);
		add(btnStop);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ButtonResetListener());
		btnReset.setBounds(419, 218, 81, 25);
		add(btnReset);

		txtConcentrationLog = new JTextArea();
		txtConcentrationLog.setBackground(new Color(127, 255, 212));
		txtConcentrationLog.setLineWrap(true);
		txtConcentrationLog.setBounds(569, 62, 246, 266);
		add(txtConcentrationLog);
		
		pfrPanel = new PFR(preferences);
		
		txtParticleNumber = new JTextField();
		txtParticleNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				resetReactor();
			}
		});
		txtParticleNumber.setText(preferences.getPlugFlowParticleNumber().toString());
		txtParticleNumber.setBounds(239, 121, 114, 19);
		add(txtParticleNumber);
		txtParticleNumber.setColumns(10);
		
		JLabel lblNumberOfParticles = new JLabel("Number of particles");
		lblNumberOfParticles.setBounds(12, 121, 192, 15);
		add(lblNumberOfParticles);
		
		txtTimeRate = new JTextField();
		txtTimeRate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				resetReactor();
			}
		});
		txtTimeRate.setText(preferences.getPlugFlowTimeStep().toString());
		txtTimeRate.setBounds(239, 152, 114, 19);
		add(txtTimeRate);
		txtTimeRate.setColumns(10);
		
		JLabel lblRateOfReaction = new JLabel("Rate of reaction steps");
		lblRateOfReaction.setBounds(12, 154, 220, 15);
		add(lblRateOfReaction);
		
		txtParticleMoveRate = new JTextField();
		txtParticleMoveRate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				resetReactor();
			}
		});
		txtParticleMoveRate.setText(preferences.getPlugFlowMotionRate().toString());
		txtParticleMoveRate.setBounds(239, 183, 114, 19);
		add(txtParticleMoveRate);
		txtParticleMoveRate.setColumns(10);
		
		JLabel lblRateOfRepaint = new JLabel("Rate of repaint of particles");
		lblRateOfRepaint.setBounds(12, 185, 192, 15);
		add(lblRateOfRepaint);

		
		pfrPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		//Timer
		pfrPanel.setBounds(71, 339, 626, 209);
		add(pfrPanel);
		pfrPanel.setLayout(null);
		
		
		JLabel lblBatchReactorData = new JLabel("Batch Reactor Data");
		lblBatchReactorData.setBounds(629, 37, 135, 14);
		add(lblBatchReactorData);
		
		JButton btnToggleFlow = new JButton("Toggle Flow");
		btnToggleFlow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				pfrPanel.toggleFlowing();
			}
		});
		btnToggleFlow.setBounds(148, 219, 89, 23);
		add(btnToggleFlow);
		//pfrPanel.setReactor(panel.getReactor() );		
		resetReactor();		
	}

	private void resetReactor() 
	{
		txtConcentrationLog.setText("");
		pfrPanel.setAnimationTimers(Integer.parseInt(txtParticleMoveRate.getText()));				
	}

	class ButtonGoListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent evt) 
		{
			if(pfrPanel.isFlowing() == true && pfrPanel.isStarted() == false)
			{
			pfrPanel.setAnimationTimers(Integer.parseInt(txtParticleMoveRate.getText()));
			pfrPanel.startAnimation();
			pfrPanel.beginAnimation();
			}
		}
	}

	class ButtonStopListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent evt)
		{
			pfrPanel.stopReactor();
			pfrPanel.stopAnimation();
		}

	}

	class ButtonResetListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent evt) 
		{
			resetReactor();
			pfrPanel.resetBatchReactorLocation();
		}

	}
}
