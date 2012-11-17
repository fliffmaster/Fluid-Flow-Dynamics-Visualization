import java.awt.Color;
import java.awt.LayoutManager;
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

public class TabPlugFlowReactor extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TabPlugFlowReactor() {
		initialize();
	}

	public TabPlugFlowReactor(LayoutManager layout) {
		super(layout);
		initialize();
	}

	public TabPlugFlowReactor(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		initialize();
	}

	public TabPlugFlowReactor(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		initialize();
	}
	
	private JTextField txtInitialConcentration;
	private JTextField txtRateConstant;

	private JTextArea txtConcentrationLog;
	private JTextField txtParticleNumber;
	private JTextField txtTimeRate;
	private JTextField txtParticleMoveRate;
	private PFR pfrPanel;

	private void initialize() {

		//setBounds(100, 100, 868, 813);
		setBounds(0, 0, 800, 600);
		setLayout(null);

		JLabel lblInitialConcentration = new JLabel("Initial Concentration");
		lblInitialConcentration.setBounds(12, 67, 192, 15);
		add(lblInitialConcentration);

		txtInitialConcentration = new JTextField();
		lblInitialConcentration.setLabelFor(txtInitialConcentration);
		txtInitialConcentration.setText("1000");
		txtInitialConcentration.setBounds(239, 63, 114, 19);
		add(txtInitialConcentration);

		txtInitialConcentration.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
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
		txtRateConstant.setText(".01");
		txtRateConstant.setBounds(239, 90, 114, 19);
		add(txtRateConstant);
		txtRateConstant.setColumns(10);

		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ButtonGoListener());
		btnGo.setBounds(127, 218, 117, 25);
		add(btnGo);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ButtonStopListener());
		btnStop.setBounds(254, 218, 117, 25);
		add(btnStop);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ButtonResetListener());
		btnReset.setBounds(383, 218, 117, 25);
		add(btnReset);

		txtConcentrationLog = new JTextArea();
		txtConcentrationLog.setBackground(new Color(127, 255, 212));
		txtConcentrationLog.setLineWrap(true);
		txtConcentrationLog.setBounds(522, 30, 246, 231);
		add(txtConcentrationLog);
		pfrPanel = new PFR();

		txtParticleNumber = new JTextField();
		txtParticleNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				resetReactor();
			}
		});
		txtParticleNumber.setText("5000");
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
		txtTimeRate.setText("1000");
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
		txtParticleMoveRate.setText("50");
		txtParticleMoveRate.setBounds(239, 183, 114, 19);
		add(txtParticleMoveRate);
		txtParticleMoveRate.setColumns(10);

		JLabel lblRateOfRepaint = new JLabel("Rate of repaint of particles");
		lblRateOfRepaint.setBounds(12, 185, 192, 15);
		add(lblRateOfRepaint);

		pfrPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		// Timer
		pfrPanel.setBounds(31, 274, 626, 209);
		add(pfrPanel);
		pfrPanel.setLayout(null);

		JLabel lblBatchReactorData = new JLabel("Batch Reactor Data");
		lblBatchReactorData.setBounds(546, 12, 135, 14);
		add(lblBatchReactorData);
		// pfrPanel.setReactor(panel.getReactor() );

		resetReactor();

	}

	private void resetReactor() {
		txtConcentrationLog.setText("");
		pfrPanel.setAnimationTimers(Integer.parseInt(txtParticleMoveRate
				.getText()));

	}

	class ButtonGoListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {

			pfrPanel.setAnimationTimers(Integer.parseInt(txtParticleMoveRate
					.getText()));
			pfrPanel.startReactor();
		}

	}

	class ButtonStopListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {


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
