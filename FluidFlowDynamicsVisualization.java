import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class FluidFlowDynamicsVisualization {

	private JFrame MainFrame;
	private JTextField txtInitialConcentration;
	private JTextField txtRateConstant;
	private Timer timer = new Timer( 100, new TimerListener());
	private FFBatchReactor reactor = new FFBatchReactor();
	private JTextArea txtConcentrationLog;
	private FluidFlowReactorPanel panel;

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
		timer.setRepeats(true);
		
		MainFrame = new JFrame();
		MainFrame.setTitle("Fluid Flow Dynamics Visualization");
		MainFrame.setBounds(100, 100, 868, 560);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(null);

		JLabel lblInitialConcentration = new JLabel("Initial Concentration");
		lblInitialConcentration.setBounds(12, 67, 192, 15);
		MainFrame.getContentPane().add(lblInitialConcentration);

		txtInitialConcentration = new JTextField();
		lblInitialConcentration.setLabelFor(txtInitialConcentration);
		txtInitialConcentration.setText("1000");
		txtInitialConcentration.setBounds(183, 63, 114, 19);
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
		txtRateConstant.setBounds(183, 90, 114, 19);
		MainFrame.getContentPane().add(txtRateConstant);
		txtRateConstant.setColumns(10);

		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ButtonGoListener());
		btnGo.setBounds(183, 124, 117, 25);
		MainFrame.getContentPane().add(btnGo);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ButtonStopListener());
		btnStop.setBounds(183, 161, 117, 25);
		MainFrame.getContentPane().add(btnStop);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ButtonResetListener());
		btnReset.setBounds(183, 198, 117, 25);
		MainFrame.getContentPane().add(btnReset);

		txtConcentrationLog = new JTextArea();
		txtConcentrationLog.setLineWrap(true);
		txtConcentrationLog.setBounds(336, 39, 224, 432);
		MainFrame.getContentPane().add(txtConcentrationLog);
		
		//JPanel panel = new JPanel();
		panel = new FluidFlowReactorPanel(2000);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBounds(583, 78, 242, 338);
		panel.makeDots();
		MainFrame.getContentPane().add(panel);
		resetReactor();
		
	}

	private void resetReactor() {
		reactor.setInitialConcentration(Double
				.parseDouble(txtInitialConcentration.getText()));
		reactor.setRateConstant(Double.parseDouble(txtRateConstant.getText()));
		reactor.setCurrentTime(0);
		txtConcentrationLog.setText("");

	}

	class ButtonGoListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			// TODO Action Listener actions

			timer.start();
		}

	}

	class ButtonStopListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			// TODO Action Listener actions
			timer.stop();
		}

	}

	class ButtonResetListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
		}

	}

	class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			reactor.setCurrentTime(reactor.getCurrentTime() + 1);
			txtConcentrationLog.setText("Concentration at time "
					+ reactor.getCurrentTime() + " is "
					+ reactor.getCurrentConcentration() + "\n" + txtConcentrationLog.getText());
			panel.clearDots();
			panel.makeDots();
			panel.setLastDot((int) (reactor.getCurrentConcentration() / Double.parseDouble(txtInitialConcentration.getText())* 2000));
			panel.repaint();
	
		}
	}
}
