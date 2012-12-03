//////////////////////////////////////////////////////////////////////////////////
// Class: 	FluidFlowDynamicsVisualization
//
// Purpose: This class is our top level acceptance testing class for the lower
//			level reactor components (up to the FluidFlowReactorPanel classes).
//			It constructs 1 of each type of reactor, one of each type of text
//			field, and one of each type of button that will be in the final
//			product.  The user of this class can test the reactors by trying any
//			combination of the start/stop/reset buttons
//
//////////////////////////////////////////////////////////////////////////////////

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
	private Preferences preferences;
	private JTextField txtInflowConcentration;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
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

	public FluidFlowDynamicsVisualization() 
	{
		initialize();
	}

	private void initialize() 
	{
		//Construct the main application frame
		MainFrame = new JFrame();
		MainFrame.setTitle("Fluid Flow Dynamics Visualization");
		MainFrame.setBounds(100, 100, 868, 813);
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(null);
		
		//Create a sample preferences menu
		preferences = new Preferences();
		
		//Create labels for text fields and reactors
		JLabel lblInitialConcentration = new JLabel("Initial Concentration");
		lblInitialConcentration.setBounds(12, 34, 192, 15);
		MainFrame.getContentPane().add(lblInitialConcentration);
		
		JLabel lblRateConstant = new JLabel("Rate Constant per Minute");
		lblRateConstant.setBounds(12, 94, 192, 15);
		MainFrame.getContentPane().add(lblRateConstant);
		
		JLabel lblNumberOfParticles = new JLabel("Number of particles");
		lblNumberOfParticles.setBounds(12, 121, 192, 15);
		MainFrame.getContentPane().add(lblNumberOfParticles);
		
		JLabel lblRateOfReaction = new JLabel("Rate of reaction steps");
		lblRateOfReaction.setBounds(12, 154, 220, 15);
		MainFrame.getContentPane().add(lblRateOfReaction);
		
		JLabel lblRateOfRepaint = new JLabel("Rate of repaint of particles");
		lblRateOfRepaint.setBounds(12, 185, 192, 15);
		MainFrame.getContentPane().add(lblRateOfRepaint);
		
		JLabel lblInflowConcentration = new JLabel("Inflow Concentration");
		lblInflowConcentration.setBounds(12, 69, 121, 14);
		MainFrame.getContentPane().add(lblInflowConcentration);
		
		JLabel lblBatchVisualization = new JLabel("Batch Reactor Visualization");
		lblBatchVisualization.setBounds(608, 16, 135, 14);
		MainFrame.getContentPane().add(lblBatchVisualization);
		
		JLabel lblCstrVisualization = new JLabel("CSTR Visualization");
		lblCstrVisualization.setBounds(608, 270, 101, 14);
		MainFrame.getContentPane().add(lblCstrVisualization);
		
		JLabel lblPfrVisualization = new JLabel("PFR Visualization");
		lblPfrVisualization.setBounds(114, 542, 123, 14);
		MainFrame.getContentPane().add(lblPfrVisualization);
		
		JLabel lblBatchReactorData = new JLabel("Batch Reactor Data");
		lblBatchReactorData.setBounds(69, 245, 135, 14);
		MainFrame.getContentPane().add(lblBatchReactorData);
		
		JLabel lblCstrData = new JLabel("CSTR Data");
		lblCstrData.setBounds(338, 245, 71, 14);
		MainFrame.getContentPane().add(lblCstrData);
		
		//Create/add the text fields for entering parameters
		txtInitialConcentration = new JTextField();
		lblInitialConcentration.setLabelFor(txtInitialConcentration);
		txtInitialConcentration.setText(preferences.getContinuouslyStirredInitialK().toString());
		txtInitialConcentration.setBounds(239, 30, 114, 19);
		MainFrame.getContentPane().add(txtInitialConcentration);
		
		txtInflowConcentration = new JTextField();
		txtInflowConcentration.setBounds(239, 60, 114, 20);
		txtInflowConcentration.setText(preferences.getContinuouslyStirredInitialC().toString());
		MainFrame.getContentPane().add(txtInflowConcentration);
		txtInflowConcentration.setColumns(10);

		txtRateConstant = new JTextField();
		txtRateConstant.setText(preferences.getContinuouslyStirredInitialK().toString());
		txtRateConstant.setBounds(239, 90, 114, 19);
		MainFrame.getContentPane().add(txtRateConstant);
		txtRateConstant.setColumns(10);
		
		txtParticleNumber = new JTextField();
		txtParticleNumber.setText(preferences.getContinuouslyStirredParticleNumber().toString());
		txtParticleNumber.setBounds(239, 121, 114, 19);
		MainFrame.getContentPane().add(txtParticleNumber);
		txtParticleNumber.setColumns(10);
		
		txtTimeRate = new JTextField();
		txtTimeRate.setText(preferences.getContinuouslyStirredTimeStep().toString());
		txtTimeRate.setBounds(239, 152, 114, 19);
		MainFrame.getContentPane().add(txtTimeRate);
		txtTimeRate.setColumns(10);
		
		txtParticleMoveRate = new JTextField();
		txtParticleMoveRate.setText(preferences.getContinuouslyStirredMotionRate().toString());
		txtParticleMoveRate.setBounds(239, 183, 114, 19);
		MainFrame.getContentPane().add(txtParticleMoveRate);
		txtParticleMoveRate.setColumns(10);

		//Create the buttons for starting/stopping/resetting the reactors
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

		//Create the data log areas for the Batch reactor and CSTR
		txtConcentrationLog = new JTextArea();
		txtConcentrationLog.setBackground(new Color(127, 255, 212));
		txtConcentrationLog.setLineWrap(true);
		txtConcentrationLog.setBounds(24, 265, 246, 266);
		MainFrame.getContentPane().add(txtConcentrationLog);
		
		cstrConcentrationLog = new JTextArea();
		cstrConcentrationLog.setBackground(new Color(127, 255, 212));
		cstrConcentrationLog.setBounds(293, 265, 239, 266);
		MainFrame.getContentPane().add(cstrConcentrationLog);
		
		//Create the reactor panels
		panel = new FluidFlowReactorPanel(2000, 2, 0, 50, 500);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBounds(598, 41, 192, 218);
		panel.setLogTextArea(txtConcentrationLog);
		MainFrame.getContentPane().add(panel);
		
		panel2 = new FluidFlowReactorPanel2(2000, 3, 0, 100, 500);
		panel2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel2.setBounds(597, 290, 182, 218);
		panel2.setLogTextArea(cstrConcentrationLog);
		MainFrame.getContentPane().add(panel2);
		
		pfrPanel = new PFR();
		pfrPanel.setBounds(91, 555, 626, 209);
		pfrPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		MainFrame.getContentPane().add(pfrPanel);
		pfrPanel.setLayout(null);
		
		//Add the button for toggling flow for the PFR
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
	
		//Reset the reactor 
		resetReactor();	
	}

	//Resets the entire simulation, which shares reactor parameters
	private void resetReactor() 
	{
		//Reset the initial concentration, k, time, reaction time, and
		//animation timer for the batch reactor
		panel.setInitialConcentration(Double
				.parseDouble(txtInitialConcentration.getText()));
		panel.setReactionConstant(Double.parseDouble(txtRateConstant.getText()));
		panel.setCurrentTime(0);
		txtConcentrationLog.setText("");
		panel.setReactionTimer(Integer.parseInt(txtTimeRate.getText()));
		panel.setAnimationTimer(Integer.parseInt(txtParticleMoveRate.getText()));
		panel.clearDots();
		panel.setTotalNumberOfDots(Integer.parseInt(txtParticleNumber.getText()));
		panel.setCurrentNumberOfDots(Integer.parseInt(txtParticleNumber.getText()));
		panel.makeDots();
		panel.repaint();
		
		//Reset the initial concentration, k, time, reaction time, and
		//animation timer for the CSTR
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
		
		//reset the pfr
		pfrPanel.setAnimationTimers(Integer.parseInt(txtParticleMoveRate.getText()));	
		pfrPanel.setInitialConcentration(300);
		pfrPanel.setRateConstant(Double.parseDouble(txtRateConstant.getText()));
	}

	//sets each reactors reaction timer to the txtTimeRate fields value and
	//starts the animation and reaction for each reactor
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
			
			if(pfrPanel.isFlowing() == true && pfrPanel.isStarted() == false)
			{
				pfrPanel.setAnimationTimers(Integer.parseInt(txtParticleMoveRate.getText()));
				pfrPanel.startAnimation();
				pfrPanel.beginAnimation();
			}
		}
	}

	//stops reactions and animations for all reactors
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

	//Causes the Reset button to call the resetReactor() method
	class ButtonResetListener implements ActionListener {

		public void actionPerformed(ActionEvent evt) {
			resetReactor();
			pfrPanel.resetBatchReactorLocation();
		}

	}
}
