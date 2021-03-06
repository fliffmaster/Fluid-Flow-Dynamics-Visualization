import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class PFR extends JPanel {
	private static final long serialVersionUID = 1L;
	private ArrayList<FluidFlowReactorPanel> batchPanels;
	private Timer timer = new Timer(50, new TimerListener());
	private Timer plugMoveTimer = new Timer(50, new plugMoveTimerListener());
	private int batchPanelWidth;
	private boolean flowing = true;
	private boolean started = false;
	private Preferences preferences;
	private boolean colorToggle;
	private int borderWidth = 0;
	private int batchPanelHeight;
	private int reactionTimeRate = 500;
	private int particleMoveRate = 50;
	private int flowParticleSize = 2;
	private int initialConcentration = 1000;
	private double rateConstant;
	private JLabel concentrationLabel;
	public JLabel getConcentrationLabel() {
		return concentrationLabel;
	}

	public JLabel getPercentageLabel() {
		return percentageLabel;
	}

	public void setConcentrationLabel(JLabel concentrationLabel) {
		this.concentrationLabel = concentrationLabel;
	}

	public void setPercentageLabel(JLabel percentageLabel) {
		this.percentageLabel = percentageLabel;
	}

	private JLabel percentageLabel;
	
	public int getReactionTimeRate() {
		return reactionTimeRate;
	}

	public void setReactionTimeRate(int reactionTimeRate) {
		this.reactionTimeRate = reactionTimeRate;
	}

	public int getParticleMoveRate() {
		return particleMoveRate;
	}

	public void setParticleMoveRate(int particleMoveRate) {
		this.particleMoveRate = particleMoveRate;
	}

	public void setRateConstant(double constant) {
		rateConstant = constant;
	}

	public double getRateConstant() {
		return rateConstant;
	}
	
	public boolean getStarted()
	{
		return started;
	}

	private JPanel panel = new JPanel();

	public void setBorder(LineBorder lb) {
		super.setBorder(lb);
		borderWidth = lb.getThickness();
		panel.setBounds(borderWidth, borderWidth, getWidth()
				- (2 * borderWidth), getHeight() - (2 * borderWidth));

	}

	public PFR(Preferences pref) {
		setLayout(null);
		batchPanelWidth = 30; // This is where we would put in a variable for
								// user input on batch size
		batchPanelHeight = this.getHeight() - (2 * borderWidth);
		batchPanels = new ArrayList<FluidFlowReactorPanel>();
		preferences = pref;

		colorToggle = true;
		timer.setRepeats(true);
		panel.setBounds(1, 1, 100, 100);
		panel.setLayout(null);
		flowParticleSize = preferences.getPlugFlowParticleSize();
		add(panel);
	}

	public PFR() {
		setLayout(null);
		panel.setBounds(1, 1, 100, 100);
		panel.setLayout(null);
		add(panel);
		batchPanelWidth = 30; // This is where we would put in a variable for
								// user input on batch size
		batchPanels = new ArrayList<FluidFlowReactorPanel>();
		timer.setRepeats(true);
	}

	public boolean isFlowing() {
		return flowing;
	}

	public void toggleFlowing() {
		if (flowing == true)
			flowing = false;
		else
			flowing = true;
	}

	public boolean isStarted() {
		return started;
	}

	public void toggleStarted() {
		if (started == false)
			started = true;
		else
			started = false;
	}

	public void setAnimationTimers(int delay) {
		for (FluidFlowReactorPanel f : batchPanels)
			f.setAnimationTimer(delay);
	}

	public void setReactor(FFBatchReactor newReactor, int index) {
		batchPanels.get(index).setReactor(newReactor);
	}

	public void startAnimation() {
		timer.start();
		plugMoveTimer.start();
		for (FluidFlowReactorPanel f : batchPanels)
			f.startAnimation();
	}

	public void startReactor() {
		for (FluidFlowReactorPanel f : batchPanels)
			f.startReaction();
	}

	public void beginAnimation() {
		if (batchPanels.isEmpty()) {
			FluidFlowReactorPanel ffTemp = new FluidFlowReactorPanel(
					initialConcentration, flowParticleSize, batchPanelWidth,
					reactionTimeRate, particleMoveRate);

			ffTemp.getReactor().setReactionConstant(rateConstant);
			batchPanels.add(ffTemp);
		}

		for (FluidFlowReactorPanel f : batchPanels) {
			f.startAnimation();
			panel.add(f);
		}
	}

	public void stopReactor() {
		timer.stop();
		plugMoveTimer.stop();
		int size = batchPanels.size();
		for (int i = 0; i < size; i++)
			batchPanels.get(i).stopReaction();
	}

	public void stopAnimation() {
		for (FluidFlowReactorPanel f : batchPanels)
			f.stopAnimation();
	}

	public void resetBatchReactorLocation() {
		panel.removeAll();
		batchPanels.clear();
		flowing = true;
		started = false;
		colorToggle = true;
		repaint();
	}

	class TimerListener implements ActionListener {
		private DecimalFormat df1 =  new DecimalFormat("#.####");
		private DecimalFormat df2 =  new DecimalFormat("#.##");
		public void actionPerformed(ActionEvent arg) {
			int size = batchPanels.size();
			batchPanelHeight = panel.getHeight();

			if (flowing == true) {
				if (batchPanels.get(size - 1).getXPos() >= 0) {
					FluidFlowReactorPanel ffTemp = new FluidFlowReactorPanel(
							initialConcentration, flowParticleSize,
							batchPanelWidth, reactionTimeRate, particleMoveRate);
					ffTemp.getReactor().setReactionConstant(rateConstant);
					ffTemp.startAnimation();
					if (preferences != null) {
						ffTemp.setDotSize(preferences.getPlugFlowParticleSize());
						ffTemp.setDotColor(preferences
								.getPlugFlowParticleColor());
						if (!colorToggle) {
							ffTemp.setBackground(preferences
									.getPlugFlowPlug1Background());
						} else {
							ffTemp.setBackground(preferences
									.getPlugFlowPlug2Background());
						}
						colorToggle = !colorToggle;
					}
					batchPanels.add(ffTemp);
					panel.add(batchPanels.get(size));
					batchPanels.get(size).startAnimation();
				}
			}
			if (batchPanels.get(0).getXPos() > panel.getWidth()) {
				if (concentrationLabel != null) concentrationLabel.setText(df1.format(batchPanels.get(0).getReactor().getCurrentConcentration()));
				if (percentageLabel != null) percentageLabel.setText(df2.format(batchPanels.get(0).getReactor().getPercentageOfUpperLimit() * 100) + "%");
				panel.remove(0);
				batchPanels.remove(0);
			}

			repaint();

		}
	}

	class plugMoveTimerListener implements ActionListener {
		public void actionPerformed(ActionEvent arg) {

			for (FluidFlowReactorPanel f : batchPanels) {
				f.setXPos();
				f.setBounds(f.getXPos(), 0, batchPanelWidth, batchPanelHeight);
				if (f.getXPos() >= 0)
					f.startReaction();
			}

		}
	}

	public int getMoveTime() {
		return plugMoveTimer.getDelay();
	}

	public void setMoveTime(int rate) {
		plugMoveTimer.setDelay(rate);

	}

	public int getInitialConcentration() {
		return initialConcentration;
	}

	public void setInitialConcentration(int initialConcentration) {
		this.initialConcentration = initialConcentration;
	}

	public void setFlowing(boolean flowing) {
		this.flowing = flowing;
	}

	public boolean getFlowing() {
		return flowing;
	}
}
