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
	private FluidFlowReactorPanel panel;
	private JTextField txtParticleNumber;
	private JTextField txtTimeRate;
	private JTextField txtParticleMoveRate;
	private PFR  pfrPanel = new PFR();

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
		
		
		MainFrame = new JFrame();
		MainFrame.setTitle("Fluid Flow Dynamics Visualization");
		MainFrame.setBounds(100, 100, 868, 813);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(null);

		JLabel lblInitialConcentration = new JLabel("Initial Concentration");
		lblInitialConcentration.setBounds(12, 67, 192, 15);
		MainFrame.getContentPane().add(lblInitialConcentration);

		txtInitialConcentration = new JTextField();
		lblInitialConcentration.setLabelFor(txtInitialConcentration);
		txtInitialConcentration.setText("1000");
		txtInitialConcentration.setBounds(239, 63, 114, 19);
		MainFrame.getContentPane().add(txtInitialConcentration);
		
		txtInitialConcentration.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
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
		btnGo.setBounds(127, 218, 117, 25);
		MainFrame.getContentPane().add(btnGo);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ButtonStopListener());
		btnStop.setBounds(254, 218, 117, 25);
		MainFrame.getContentPane().add(btnStop);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ButtonResetListener());
		btnReset.setBounds(383, 218, 117, 25);
		MainFrame.getContentPane().add(btnReset);

		txtConcentrationLog = new JTextArea();
		txtConcentrationLog.setLineWrap(true);
		txtConcentrationLog.setBounds(28, 255, 520, 266);
		MainFrame.getContentPane().add(txtConcentrationLog);
		
		//JPanel panel = new JPanel();
		panel = new FluidFlowReactorPanel(2000, 3, 0);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBounds(583, 78, 242, 338);
		panel.setLogTextArea(txtConcentrationLog);
		
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

		
		pfrPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		//Timer
		pfrPanel.setBounds(28, 550, 626, 209);
		MainFrame.getContentPane().add(pfrPanel);
		pfrPanel.setLayout(null);
		//pfrPanel.setReactor(panel.getReactor() );
		
		
		resetReactor();
		
		
	}

	private void resetReactor() {
		panel.setInitialConcentration(Double
				.parseDouble(txtInitialConcentration.getText()));
		panel.setRateConstant(Double.parseDouble(txtRateConstant.getText()));
		panel.setCurrentTime(0);
		txtConcentrationLog.setText("");
		pfrPanel.setAnimationTimers(Integer.parseInt(txtParticleMoveRate.getText()));
		
		panel.setReactionTimer(Integer.parseInt(txtTimeRate.getText()));
		panel.setAnimationTimer(Integer.parseInt(txtParticleMoveRate.getText()));
		panel.clearDots();
		panel.setTotalNumberOfDots(Integer.parseInt(txtParticleNumber.getText()));
		panel.makeDots();
		panel.repaint();
		
	}

	class ButtonGoListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			
			panel.setReactionTimer(Integer.parseInt(txtTimeRate.getText()));
			panel.setAnimationTimer(Integer.parseInt(txtParticleMoveRate.getText()));
			panel.startAnimation();
			panel.startReaction();
			pfrPanel.setAnimationTimers(Integer.parseInt(txtParticleMoveRate.getText()));
			pfrPanel.startReactor();
		}

	}

	class ButtonStopListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			
			panel.stopReaction();
			panel.stopAnimation();
			pfrPanel.stopReactor();
		}

	}

	class ButtonResetListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			resetReactor();
			pfrPanel.resetBatchReactorLocation();
		}

	}


}
