import java.awt.Color;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class PlugFlowReactorWindow {

	private JFrame frmPlugFlowRaactor;
	private JTextField txtInitialConcentration;
	private JTextField txtRateConstant;
	private JTextField txtInFlowRate;
	private JTextField txtReactorVolume;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Start window = new Start();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PlugFlowReactorWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlugFlowRaactor = new JFrame();
		frmPlugFlowRaactor.setTitle("Plug Flow Raactor");
		frmPlugFlowRaactor.setBounds(100, 100, 802, 456);
		frmPlugFlowRaactor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlugFlowRaactor.getContentPane().setLayout(null);
		
		PFR pfrPanel = new PFR();
		pfrPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		//Timer
		pfrPanel.setBounds(86, 191, 626, 209);
		frmPlugFlowRaactor.getContentPane().add(pfrPanel);
		pfrPanel.setLayout(null);
		
		JLabel label = new JLabel("Initial Concentration");
		label.setBounds(211, 14, 192, 15);
		frmPlugFlowRaactor.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Rate Constant per Minute");
		label_1.setBounds(211, 44, 192, 15);
		frmPlugFlowRaactor.getContentPane().add(label_1);
		
		txtInitialConcentration = new JTextField();
		txtInitialConcentration.setText("1000");
		txtInitialConcentration.setBounds(472, 12, 114, 19);
		frmPlugFlowRaactor.getContentPane().add(txtInitialConcentration);
		
		txtRateConstant = new JTextField();
		txtRateConstant.setText(".1");
		txtRateConstant.setColumns(10);
		txtRateConstant.setBounds(472, 42, 114, 19);
		frmPlugFlowRaactor.getContentPane().add(txtRateConstant);
		
		JLabel lblInFlowRate = new JLabel("In Flow Rate");
		lblInFlowRate.setBounds(211, 74, 192, 15);
		frmPlugFlowRaactor.getContentPane().add(lblInFlowRate);
		
		JLabel lblReactorVolume = new JLabel("Reactor Volume");
		lblReactorVolume.setBounds(211, 104, 192, 15);
		frmPlugFlowRaactor.getContentPane().add(lblReactorVolume);
		
		txtInFlowRate = new JTextField();
		txtInFlowRate.setText("10");
		txtInFlowRate.setColumns(10);
		txtInFlowRate.setBounds(472, 72, 114, 19);
		frmPlugFlowRaactor.getContentPane().add(txtInFlowRate);
		
		txtReactorVolume = new JTextField();
		txtReactorVolume.setText("200");
		txtReactorVolume.setColumns(10);
		txtReactorVolume.setBounds(472, 102, 114, 19);
		frmPlugFlowRaactor.getContentPane().add(txtReactorVolume);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBounds(211, 142, 117, 25);
		frmPlugFlowRaactor.getContentPane().add(btnGo);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(340, 142, 117, 25);
		frmPlugFlowRaactor.getContentPane().add(btnStop);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(469, 142, 117, 25);
		frmPlugFlowRaactor.getContentPane().add(btnReset);
		
	}
}
