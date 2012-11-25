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

public class TabBatchReactor extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Preferences preferences;
	
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

	private JTextField txtInitialConcentration;
	private JTextField txtRateConstant;

	private JTextArea txtConcentrationLog;
	private FluidFlowReactorPanel panel;
	private JTextField txtParticleNumber;
	private JTextField txtTimeRate;
	private JTextField txtParticleMoveRate;

	private void initialize() {

		//setBounds(100, 100, 868, 813);
		setBounds(0, 0, 800, 600);
		setLayout(null);

		JLabel lblInitialConcentration = new JLabel("Initial Concentration");
		lblInitialConcentration.setBounds(12, 67, 192, 15);
		add(lblInitialConcentration);

		txtInitialConcentration = new JTextField();
		lblInitialConcentration.setLabelFor(txtInitialConcentration);
		txtInitialConcentration.setText(preferences.getBatchInitialC().toString() );
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
		txtRateConstant.setText(preferences.getBatchInitialK().toString() );
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
		txtConcentrationLog.setBounds(28, 273, 246, 266);
		add(txtConcentrationLog);



		txtParticleNumber = new JTextField();
		txtParticleNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				resetReactor();
			}
		});
		txtParticleNumber.setText(preferences.getBatchParticleNumber().toString());
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
		txtTimeRate.setText(preferences.getBatchTimeStep().toString());
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
		txtParticleMoveRate.setText(preferences.getBatchMotionRate().toString());
		txtParticleMoveRate.setBounds(239, 183, 114, 19);
		add(txtParticleMoveRate);
		txtParticleMoveRate.setColumns(10);

		JLabel lblRateOfRepaint = new JLabel("Rate of repaint of particles");
		lblRateOfRepaint.setBounds(12, 185, 192, 15);
		add(lblRateOfRepaint);

		JLabel lblNewLabel_1 = new JLabel("Batch Reactor Visualization");
		lblNewLabel_1.setBounds(608, 16, 135, 14);
		add(lblNewLabel_1);

		JLabel lblBatchReactorData = new JLabel("Batch Reactor Data");
		lblBatchReactorData.setBounds(69, 254, 135, 14);
		add(lblBatchReactorData);
		// pfrPanel.setReactor(panel.getReactor() );

		// JPanel panel = new JPanel();
		panel = new FluidFlowReactorPanel(2000, 3, 0, 50, 500);
		panel.setBorder(new LineBorder(preferences.getBatchBorderColor(), 4));
		panel.setBounds(598, 41, 192, 218);
		panel.setLogTextArea(txtConcentrationLog);
		panel.setDotSize(preferences.getBatchParticleSize());
		panel.setDotColor(preferences.getBatchParticleColor());
		panel.setBackground(preferences.getBatchBackgroundColor());
		
		

		add(panel);
		
		resetReactor();

	}

	private void resetReactor() {
		panel.setInitialConcentration(Double
				.parseDouble(txtInitialConcentration.getText()));
		panel.setReactionConstant(Double.parseDouble(txtRateConstant.getText()));
		panel.setCurrentTime(0);
		txtConcentrationLog.setText("");

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
			panel.setAnimationTimer(Integer.parseInt(txtParticleMoveRate
					.getText()));
			panel.startAnimation();
			panel.startReaction();

		}

	}

	class ButtonStopListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {

			panel.stopReaction();
			panel.stopAnimation();

		}

	}

	class ButtonResetListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			resetReactor();

		}

	}

}
