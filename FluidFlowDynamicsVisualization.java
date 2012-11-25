import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FluidFlowDynamicsVisualization {

	private JFrame MainFrame;
	private JTextField txtInitialConcentration;
	private JTextField txtRateConstant;
	
	private JTextArea txtConcentrationLog;
	private JTextArea cstrConcentrationLog;
	private FluidFlowReactorPanel panel;
	private JTextField txtParticleNumber;
	private JTextField txtTimeRate;
	private JTextField txtParticleMoveRate;
	private PFR  pfrPanel;
	private FluidFlowReactorPanel2 panel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FluidFlowDynamicsVisualization window = new FluidFlowDynamicsVisualization();
					window.MainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FluidFlowDynamicsVisualization() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//make the main frame for the application
		MainFrame = new JFrame();
		MainFrame.setTitle("Fluid Flow Dynamics Visualization");
		MainFrame.setBounds(100, 100, 868, 813);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(null);
		
		//Initial Concentration Label
		JLabel lblInitialConcentration = new JLabel("Initial Concentration");
		lblInitialConcentration.setBounds(12, 67, 192, 15);
		MainFrame.getContentPane().add(lblInitialConcentration);
		
		//Make Initial Concentration text field
		txtInitialConcentration = new JTextField();
		lblInitialConcentration.setLabelFor(txtInitialConcentration);
		txtInitialConcentration.setText("1.0");
		txtInitialConcentration.setBounds(239, 63, 114, 19);
		MainFrame.getContentPane().add(txtInitialConcentration);
		
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
		MainFrame.getContentPane().add(lblNewLabel);

		txtRateConstant = new JTextField();
		txtRateConstant.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				resetReactor();
			}
		});
		txtRateConstant.setText(".1");
		txtRateConstant.setBounds(239, 90, 114, 19);
		MainFrame.getContentPane().add(txtRateConstant);
		txtRateConstant.setColumns(10);

		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ButtonGoListener());
		btnGo.setBounds(247, 218, 81, 25);
		MainFrame.getContentPane().add(btnGo);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ButtonStopListener());
		btnStop.setBounds(338, 218, 71, 25);
		MainFrame.getContentPane().add(btnStop);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ButtonResetListener());
		btnReset.setBounds(419, 218, 81, 25);
		MainFrame.getContentPane().add(btnReset);

		txtConcentrationLog = new JTextArea();
		txtConcentrationLog.setBackground(new Color(127, 255, 212));
		txtConcentrationLog.setLineWrap(true);
		txtConcentrationLog.setBounds(28, 273, 246, 266);
		MainFrame.getContentPane().add(txtConcentrationLog);
		
		cstrConcentrationLog = new JTextArea();
		cstrConcentrationLog.setBackground(new Color(127, 255, 212));
		cstrConcentrationLog.setBounds(294, 273, 239, 266);
		MainFrame.getContentPane().add(cstrConcentrationLog);
		
		//JPanel panel = new JPanel();
		panel = new FluidFlowReactorPanel(2000, 2, 0, 50, 500);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBounds(598, 41, 192, 218);
		panel.setLogTextArea(txtConcentrationLog);
		
		panel2 = new FluidFlowReactorPanel2(2000, 3, 0, 100, 500);
		panel2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel2.setBounds(597, 290, 182, 218);
		panel2.setLogTextArea(cstrConcentrationLog);
		MainFrame.getContentPane().add(panel2);
		
		pfrPanel = new PFR();
		
		MainFrame.getContentPane().add(panel);
		
		txtParticleNumber = new JTextField();
		txtParticleNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				resetReactor();
			}
		});
		txtParticleNumber.setText("5000");
		txtParticleNumber.setBounds(239, 121, 114, 19);
		MainFrame.getContentPane().add(txtParticleNumber);
		txtParticleNumber.setColumns(10);
		
		JLabel lblNumberOfParticles = new JLabel("Number of particles");
		lblNumberOfParticles.setBounds(12, 121, 192, 15);
		MainFrame.getContentPane().add(lblNumberOfParticles);
		
		txtTimeRate = new JTextField();
		txtTimeRate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				resetReactor();
			}
		});
		txtTimeRate.setText("1000");
		txtTimeRate.setBounds(239, 152, 114, 19);
		MainFrame.getContentPane().add(txtTimeRate);
		txtTimeRate.setColumns(10);
		
		JLabel lblRateOfReaction = new JLabel("Rate of reaction steps");
		lblRateOfReaction.setBounds(12, 154, 220, 15);
		MainFrame.getContentPane().add(lblRateOfReaction);
		
		txtParticleMoveRate = new JTextField();
		txtParticleMoveRate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				resetReactor();
			}
		});
		txtParticleMoveRate.setText("50");
		txtParticleMoveRate.setBounds(239, 183, 114, 19);
		MainFrame.getContentPane().add(txtParticleMoveRate);
		txtParticleMoveRate.setColumns(10);
		
		JLabel lblRateOfRepaint = new JLabel("Rate of repaint of particles");
		lblRateOfRepaint.setBounds(12, 185, 192, 15);
		MainFrame.getContentPane().add(lblRateOfRepaint);

		
		

		//Timer
		pfrPanel.setBounds(132, 551, 626, 209);
		pfrPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		MainFrame.getContentPane().add(pfrPanel);
		pfrPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Batch Reactor Visualization");
		lblNewLabel_1.setBounds(608, 16, 135, 14);
		MainFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCstrVisualization = new JLabel("CSTR Visualization");
		lblCstrVisualization.setBounds(608, 270, 101, 14);
		MainFrame.getContentPane().add(lblCstrVisualization);
		
		JLabel lblBatchReactorData = new JLabel("Batch Reactor Data");
		lblBatchReactorData.setBounds(69, 254, 135, 14);
		MainFrame.getContentPane().add(lblBatchReactorData);
		
		JLabel lblCstrData = new JLabel("CSTR Data");
		lblCstrData.setBounds(338, 254, 71, 14);
		MainFrame.getContentPane().add(lblCstrData);
		
		JButton btnToggleFlow = new JButton("Toggle Flow");
		btnToggleFlow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				pfrPanel.toggleFlowing();
			}
		});
		btnToggleFlow.setBounds(148, 219, 89, 23);
		MainFrame.getContentPane().add(btnToggleFlow);
		//pfrPanel.setReactor(panel.getReactor() );
		
		resetReactor();	
	}

	private void resetReactor() {
		panel.setInitialConcentration(Double
				.parseDouble(txtInitialConcentration.getText()));
		panel.setReactionConstant(Double.parseDouble(txtRateConstant.getText()));
		panel.setCurrentTime(0);
		txtConcentrationLog.setText("");
		pfrPanel.setAnimationTimers(Integer.parseInt(txtParticleMoveRate.getText()));
		
		panel.setReactionTimer(Integer.parseInt(txtTimeRate.getText()));
		panel.setAnimationTimer(Integer.parseInt(txtParticleMoveRate.getText()));
		panel.clearDots();
		panel.setTotalNumberOfDots(Integer.parseInt(txtParticleNumber.getText()));
		panel.setCurrentNumberOfDots(Integer.parseInt(txtParticleNumber.getText()));
		panel.makeDots();
		panel.repaint();
		
		panel2.setInflowConcentration(1.0);
		panel2.getReactor().setCurrentConcentration(0.0);
		panel2.setReactionConstant(Double.parseDouble(txtRateConstant.getText()));
		panel2.setCurrentTime(0);
		cstrConcentrationLog.setText("");
		panel2.setReactionTimer(Integer.parseInt(txtTimeRate.getText()));
		panel2.setAnimationTimer(Integer.parseInt(txtParticleMoveRate.getText()));
		panel2.clearDots();
		panel2.setTotalNumberOfDots(Integer.parseInt(txtParticleNumber.getText()));
		panel2.setCurrentNumberOfDots(0);
		panel2.repaint();
		
	}

	class ButtonGoListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			
			panel.setReactionTimer(Integer.parseInt(txtTimeRate.getText()));
			panel.setAnimationTimer(Integer.parseInt(txtParticleMoveRate.getText()));
			panel.startAnimation();
			panel.startReaction();
			panel2.setReactionTimer(Integer.parseInt(txtTimeRate.getText()));
			panel2.setAnimationTimer(Integer.parseInt(txtParticleMoveRate.getText()));
			panel2.startAnimation();
			panel2.startReaction();
			pfrPanel.setAnimationTimers(Integer.parseInt(txtParticleMoveRate.getText()));
			pfrPanel.startAnimation();
			pfrPanel.beginAnimation();
			//pfrPanel.startReactor();
		}

	}

	class ButtonStopListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			
			panel.stopReaction();
			panel.stopAnimation();
			panel2.stopReaction();
			panel2.stopAnimation();
			pfrPanel.stopReactor();
			pfrPanel.stopAnimation();
		}

	}

	class ButtonResetListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			resetReactor();
			pfrPanel.resetBatchReactorLocation();
		}

	}
}
