import java.awt.Color;
//import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.LineBorder;


public class Start {

	private JFrame frame;

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
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 802, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		PFR pfrPanel = new PFR();
		pfrPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		//Timer
		pfrPanel.setBounds(43, 26, 626, 209);
		frame.getContentPane().add(pfrPanel);
		pfrPanel.setLayout(null);
		
	}
}
