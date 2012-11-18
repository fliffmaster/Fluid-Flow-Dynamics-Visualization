import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;



public class Preferences extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBatchParticleSize;
	private JTextField txtBatchParticleNumber;
	private JTextField txtBatchMotionRate;
	private JTextField txtBatchInitialC;
	private JTextField txtBatchInitialK;
	private JTextField txtBatchTimeStep;
	private JTextField txtBatchParticleColor;
	private JTextField txtBatchBackgroundColor;
	private JTextField txtBatchBorderColor;

	private JTextField txtPlugFlowParticleSize;
	private JTextField txtPlugFlowParticleNumber;
	private JTextField txtPlugFlowMotionRate;
	private JTextField txtPlugFlowInitialC;
	private JTextField txtPlugFlowInitialK;
	private JTextField txtPlugFlowTimeStep;
	private JTextField txtPlugFlowParticleColor;
	private JTextField txtPlugFlowPlug1Background;
	private JTextField txtPlugFlowBorderColor;
	private JTextField txtPlugFlowPlug2Background;
	
	private JTextField txtContinuouslyStirredParticleSize;
	private JTextField txtContinuouslyStirredParticleNumber;
	private JTextField txtContinuouslyStirredMotionRate;
	private JTextField txtContinuouslyStirredInitialC;
	private JTextField txtContinuouslyStirredInitialK;
	private JTextField txtContinuouslyStirredTimeStep;
	private JTextField txtContinuouslyStirredParticleColor;
	private JTextField txtContinuouslyStirredBackgroundColor;
	private JTextField txtContinuouslyStirredBorderColor;

	private Double dblBatchParticleSize;
	private Double dblBatchParticleNumber;
	private Double dblBatchMotionRate;
	private Double dblBatchInitialC;
	private Double dblBatchInitialK;
	private Double dblBatchTimeStep;
	private Color clrBatchParticleColor;
	private Color clrBatchBackgroundColor;
	private Color clrBatchBorderColor;

	private Double dblPlugFlowParticleSize;
	private Double dblPlugFlowParticleNumber;
	private Double dblPlugFlowMotionRate;
	private Double dblPlugFlowInitialC;
	private Double dblPlugFlowInitialK;
	private Double dblPlugFlowTimeStep;
	private Color clrPlugFlowParticleColor;
	private Color clrPlugFlowPlug1Background;
	private Color clrPlugFlowBorderColor;
	private Color clrPlugFlowPlug2Background;
	
	private Double dblContinuouslyStirredParticleSize;
	private Double dblContinuouslyStirredParticleNumber;
	private Double dblContinuouslyStirredMotionRate;
	private Double dblContinuouslyStirredInitialC;
	private Double dblContinuouslyStirredInitialK;
	private Double dblContinuouslyStirredTimeStep;
	private Color clrContinuouslyStirredParticleColor;
	private Color clrContinuouslyStirredBackgroundColor;
	private Color clrContinuouslyStirredBorderColor;
	
		
	
	public Double getBatchParticleSize() {
		return dblBatchParticleSize;
	}

	public void setBatchParticleSize(Double dblBatchParticleSize) {
		this.dblBatchParticleSize = dblBatchParticleSize;
		txtBatchParticleSize.setText(Double.toString(dblBatchParticleSize));
	}

	public Double getBatchParticleNumber() {
		return dblBatchParticleNumber;
	}

	public void setBatchParticleNumber(Double dblBatchParticleNumber) {
		this.dblBatchParticleNumber = dblBatchParticleNumber;
		txtBatchParticleNumber.setText(Double.toString(dblBatchParticleNumber));
	}

	public Double getBatchMotionRate() {
		return dblBatchMotionRate;
	}

	public void setBatchMotionRate(Double dblBatchMotionRate) {
		this.dblBatchMotionRate = dblBatchMotionRate;
		txtBatchMotionRate.setText(Double.toString(dblBatchMotionRate));
	}

	public Double getBatchInitialC() {
		return dblBatchInitialC;
	}

	public void setBatchInitialC(Double dblBatchInitialC) {
		this.dblBatchInitialC = dblBatchInitialC;
		txtBatchInitialC.setText(Double.toString(dblBatchInitialC));
	}

	public Double getBatchInitialK() {
		return dblBatchInitialK;
	}

	public void setBatchInitialK(Double dblBatchInitialK) {
		this.dblBatchInitialK = dblBatchInitialK;
		txtBatchInitialK.setText(Double.toString(dblBatchInitialK));
	}

	public Double getBatchTimeStep() {
		return dblBatchTimeStep;
	}

	public void setBatchTimeStep(Double dblBatchTimeStep) {
		this.dblBatchTimeStep = dblBatchTimeStep;
		txtBatchTimeStep.setText(Double.toString(dblBatchTimeStep));
	}

	public Color getBatchParticleColor() {
		return clrBatchParticleColor;
	}

	public void setBatchParticleColor(Color clrBatchParticleColor) {
		this.clrBatchParticleColor = clrBatchParticleColor;
		txtBatchParticleColor.setText(clrBatchParticleColor.toString() );
	}

	public Color getBatchBackgroundColor() {
		return clrBatchBackgroundColor;
	}

	public void setBatchBackgroundColor(Color clrBatchBackgroundColor) {
		this.clrBatchBackgroundColor = clrBatchBackgroundColor;
		txtBatchBackgroundColor.setText(clrBatchBackgroundColor.toString());
	}

	public Color getBatchBorderColor() {
		return clrBatchBorderColor;
	}

	public void setBatchBorderColor(Color clrBatchBorderColor) {
		this.clrBatchBorderColor = clrBatchBorderColor;
		txtBatchBorderColor.setText(clrBatchBorderColor.toString());
	}

	public Double getPlugFlowParticleSize() {
		return dblPlugFlowParticleSize;
	}

	public void setPlugFlowParticleSize(Double dblPlugFlowParticleSize) {
		this.dblPlugFlowParticleSize = dblPlugFlowParticleSize;
		txtPlugFlowParticleSize.setText(Double.toString(dblPlugFlowParticleSize));
	}

	public Double getPlugFlowParticleNumber() {
		return dblPlugFlowParticleNumber;
	}

	public void setPlugFlowParticleNumber(Double dblPlugFlowParticleNumber) {
		this.dblPlugFlowParticleNumber = dblPlugFlowParticleNumber;
		txtPlugFlowParticleNumber.setText(Double.toString(dblPlugFlowParticleNumber));
	}

	public Double getPlugFlowMotionRate() {
		return dblPlugFlowMotionRate;
	}

	public void setPlugFlowMotionRate(Double dblPlugFlowMotionRate) {
		this.dblPlugFlowMotionRate = dblPlugFlowMotionRate;
		txtPlugFlowMotionRate.setText(Double.toString(dblPlugFlowMotionRate));
	}

	public Double getPlugFlowInitialC() {
		return dblPlugFlowInitialC;
	}

	public void setPlugFlowInitialC(Double dblPlugFlowInitialC) {
		this.dblPlugFlowInitialC = dblPlugFlowInitialC;
		txtPlugFlowInitialC.setText(Double.toString(dblPlugFlowInitialC));
	}

	public Double getPlugFlowInitialK() {
		return dblPlugFlowInitialK;
	}

	public void setPlugFlowInitialK(Double dblPlugFlowInitialK) {
		this.dblPlugFlowInitialK = dblPlugFlowInitialK;
		txtPlugFlowInitialK.setText(Double.toString(dblPlugFlowInitialK));
	}

	public Double getPlugFlowTimeStep() {
		return dblPlugFlowTimeStep;
	}

	public void setPlugFlowTimeStep(Double dblPlugFlowTimeStep) {
		this.dblPlugFlowTimeStep = dblPlugFlowTimeStep;
		txtPlugFlowTimeStep.setText(Double.toString(dblPlugFlowTimeStep));
	}

	public Color getPlugFlowParticleColor() {
		return clrPlugFlowParticleColor;
	}

	public void setPlugFlowParticleColor(Color clrPlugFlowParticleColor) {
		this.clrPlugFlowParticleColor = clrPlugFlowParticleColor;
		txtPlugFlowParticleColor.setText(clrPlugFlowParticleColor.toString());
	}

	public Color getPlugFlowPlug1Background() {
		return clrPlugFlowPlug1Background;
	}

	public void setPlugFlowPlug1Background(Color clrPlugFlowPlug1Background) {
		this.clrPlugFlowPlug1Background = clrPlugFlowPlug1Background;
		txtPlugFlowPlug1Background.setText(clrPlugFlowPlug1Background.toString());
	}

	public Color getPlugFlowBorderColor() {
		return clrPlugFlowBorderColor;
	}

	public void setPlugFlowBorderColor(Color clrPlugFlowBorderColor) {
		this.clrPlugFlowBorderColor = clrPlugFlowBorderColor;
		txtPlugFlowBorderColor.setText(clrPlugFlowBorderColor.toString());
	}

	public Color getPlugFlowPlug2Background() {
		return clrPlugFlowPlug2Background;
	}

	public void setPlugFlowPlug2Background(Color clrPlugFlowPlug2Background) {
		this.clrPlugFlowPlug2Background = clrPlugFlowPlug2Background;
		txtPlugFlowPlug2Background.setText(clrPlugFlowPlug2Background.toString());
	}

	public Double getContinuouslyStirredParticleSize() {
		return dblContinuouslyStirredParticleSize;
	}

	public void setContinuouslyStirredParticleSize(
			Double dblContinuouslyStirredParticleSize) {
		this.dblContinuouslyStirredParticleSize = dblContinuouslyStirredParticleSize;
		txtContinuouslyStirredParticleSize.setText(Double.toString(dblContinuouslyStirredParticleSize));
	}

	public Double getContinuouslyStirredParticleNumber() {
		return dblContinuouslyStirredParticleNumber;
	}

	public void setContinuouslyStirredParticleNumber(
			Double dblContinuouslyStirredParticleNumber) {
		this.dblContinuouslyStirredParticleNumber = dblContinuouslyStirredParticleNumber;
		txtContinuouslyStirredParticleNumber.setText(Double.toString(dblContinuouslyStirredParticleNumber));
	}

	public Double getContinuouslyStirredMotionRate() {
		return dblContinuouslyStirredMotionRate;
	}

	public void setContinuouslyStirredMotionRate(
			Double dblContinuouslyStirredMotionRate) {
		this.dblContinuouslyStirredMotionRate = dblContinuouslyStirredMotionRate;
		txtContinuouslyStirredMotionRate.setText(Double.toString(dblContinuouslyStirredMotionRate));
	}

	public Double getContinuouslyStirredInitialC() {
		return dblContinuouslyStirredInitialC;
	}

	public void setContinuouslyStirredInitialC(
			Double dblContinuouslyStirredInitialC) {
		this.dblContinuouslyStirredInitialC = dblContinuouslyStirredInitialC;
		txtContinuouslyStirredInitialC.setText(Double.toString(dblContinuouslyStirredInitialC));
	}

	public Double getContinuouslyStirredInitialK() {
		return dblContinuouslyStirredInitialK;
	}

	public void setContinuouslyStirredInitialK(
			Double dblContinuouslyStirredInitialK) {
		this.dblContinuouslyStirredInitialK = dblContinuouslyStirredInitialK;
		txtContinuouslyStirredInitialK.setText(Double.toString(dblContinuouslyStirredInitialK));
	}

	public Double getContinuouslyStirredTimeStep() {
		return dblContinuouslyStirredTimeStep;
	}

	public void setContinuouslyStirredTimeStep(
			Double dblContinuouslyStirredTimeStep) {
		this.dblContinuouslyStirredTimeStep = dblContinuouslyStirredTimeStep;
		txtContinuouslyStirredTimeStep.setText(Double.toString(dblContinuouslyStirredTimeStep));
	}

	public Color getContinuouslyStirredParticleColor() {
		return clrContinuouslyStirredParticleColor;
	}

	public void setContinuouslyStirredParticleColor(
			Color clrContinuouslyStirredParticleColor) {
		this.clrContinuouslyStirredParticleColor = clrContinuouslyStirredParticleColor;
		txtContinuouslyStirredParticleColor.setText(clrContinuouslyStirredParticleColor.toString());
	}

	public Color getContinuouslyStirredBackgroundColor() {
		return clrContinuouslyStirredBackgroundColor;
	}

	public void setContinuouslyStirredBackgroundColor(
			Color clrContinuouslyStirredBackgroundColor) {
		this.clrContinuouslyStirredBackgroundColor = clrContinuouslyStirredBackgroundColor;
		txtContinuouslyStirredBackgroundColor.setText(clrContinuouslyStirredBackgroundColor.toString());
	}

	public Color getContinuouslyStirredBorderColor() {
		return clrContinuouslyStirredBorderColor;
	}

	public void setContinuouslyStirredBorderColor(
			Color clrContinuouslyStirredBorderColor) {
		this.clrContinuouslyStirredBorderColor = clrContinuouslyStirredBorderColor;
		txtContinuouslyStirredBorderColor.setText(clrContinuouslyStirredBorderColor.toString());
	}


	
	/**
	 * Create the panel.
	 */
	public Preferences() {
				
		JPanel batchReactorPreferences = new JPanel();
		addTab("Batch Reactor", null, batchReactorPreferences, null);
		GridBagLayout gbl_batchReactorPreferences = new GridBagLayout();
		gbl_batchReactorPreferences.columnWidths = new int[]{137, 0, 0};
		gbl_batchReactorPreferences.rowHeights = new int[]{15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 0};
		gbl_batchReactorPreferences.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_batchReactorPreferences.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		batchReactorPreferences.setLayout(gbl_batchReactorPreferences);
		
		JLabel lblParticles = new JLabel("Particles");
		GridBagConstraints gbc_lblParticles = new GridBagConstraints();
		gbc_lblParticles.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblParticles.insets = new Insets(0, 0, 5, 5);
		gbc_lblParticles.gridx = 0;
		gbc_lblParticles.gridy = 0;
		batchReactorPreferences.add(lblParticles, gbc_lblParticles);
		
		JLabel lblColor = new JLabel("Color");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 1;
		batchReactorPreferences.add(lblColor, gbc_lblColor);
		
		txtBatchParticleColor = new JTextField();
		txtBatchParticleColor.setText("FF0000");
		
		GridBagConstraints gbc_txtBatchParticleColor = new GridBagConstraints();
		gbc_txtBatchParticleColor.anchor = GridBagConstraints.WEST;
		gbc_txtBatchParticleColor.insets = new Insets(0, 0, 5, 0);
		gbc_txtBatchParticleColor.gridx = 1;
		gbc_txtBatchParticleColor.gridy = 1;
		batchReactorPreferences.add(txtBatchParticleColor, gbc_txtBatchParticleColor);
		txtBatchParticleColor.setColumns(10);
		
		
		
		JLabel lblSize = new JLabel("Size");
		GridBagConstraints gbc_lblSize = new GridBagConstraints();
		gbc_lblSize.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblSize.gridx = 0;
		gbc_lblSize.gridy = 2;
		batchReactorPreferences.add(lblSize, gbc_lblSize);
		
		txtBatchParticleSize = new JTextField();
		txtBatchParticleSize.setText("2");
		GridBagConstraints gbc_txtBatchParticleSize = new GridBagConstraints();
		gbc_txtBatchParticleSize.anchor = GridBagConstraints.WEST;
		gbc_txtBatchParticleSize.insets = new Insets(0, 0, 5, 0);
		gbc_txtBatchParticleSize.gridx = 1;
		gbc_txtBatchParticleSize.gridy = 2;
		batchReactorPreferences.add(txtBatchParticleSize, gbc_txtBatchParticleSize);
		txtBatchParticleSize.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number");
		GridBagConstraints gbc_lblNumber = new GridBagConstraints();
		gbc_lblNumber.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumber.gridx = 0;
		gbc_lblNumber.gridy = 3;
		batchReactorPreferences.add(lblNumber, gbc_lblNumber);
		
		txtBatchParticleNumber = new JTextField();
		txtBatchParticleNumber.setText("5000");
		GridBagConstraints gbc_txtBatchParticleNumber = new GridBagConstraints();
		gbc_txtBatchParticleNumber.anchor = GridBagConstraints.WEST;
		gbc_txtBatchParticleNumber.insets = new Insets(0, 0, 5, 0);
		gbc_txtBatchParticleNumber.gridx = 1;
		gbc_txtBatchParticleNumber.gridy = 3;
		batchReactorPreferences.add(txtBatchParticleNumber, gbc_txtBatchParticleNumber);
		txtBatchParticleNumber.setColumns(10);
		
		JLabel lblMotionRate = new JLabel("Motion rate");
		GridBagConstraints gbc_lblMotionRate = new GridBagConstraints();
		gbc_lblMotionRate.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblMotionRate.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotionRate.gridx = 0;
		gbc_lblMotionRate.gridy = 4;
		batchReactorPreferences.add(lblMotionRate, gbc_lblMotionRate);
		
		txtBatchMotionRate = new JTextField();
		txtBatchMotionRate.setText("50");
		GridBagConstraints gbc_txtBatchMotionRate = new GridBagConstraints();
		gbc_txtBatchMotionRate.anchor = GridBagConstraints.WEST;
		gbc_txtBatchMotionRate.insets = new Insets(0, 0, 5, 0);
		gbc_txtBatchMotionRate.gridx = 1;
		gbc_txtBatchMotionRate.gridy = 4;
		batchReactorPreferences.add(txtBatchMotionRate, gbc_txtBatchMotionRate);
		txtBatchMotionRate.setColumns(10);
		
		JLabel lblBackgroundColor = new JLabel("Background Color");
		GridBagConstraints gbc_lblBackgroundColor = new GridBagConstraints();
		gbc_lblBackgroundColor.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblBackgroundColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblBackgroundColor.gridx = 0;
		gbc_lblBackgroundColor.gridy = 5;
		batchReactorPreferences.add(lblBackgroundColor, gbc_lblBackgroundColor);
		
		txtBatchBackgroundColor = new JTextField();
		txtBatchBackgroundColor.setText("FFFFFF");
		GridBagConstraints gbc_txtBatchBackgroundColor = new GridBagConstraints();
		gbc_txtBatchBackgroundColor.anchor = GridBagConstraints.WEST;
		gbc_txtBatchBackgroundColor.insets = new Insets(0, 0, 5, 0);
		gbc_txtBatchBackgroundColor.gridx = 1;
		gbc_txtBatchBackgroundColor.gridy = 5;
		batchReactorPreferences.add(txtBatchBackgroundColor, gbc_txtBatchBackgroundColor);
		txtBatchBackgroundColor.setColumns(10);
		
		JLabel lblBorderColor = new JLabel("Border Color");
		GridBagConstraints gbc_lblBorderColor = new GridBagConstraints();
		gbc_lblBorderColor.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblBorderColor.insets = new Insets(0, 0, 5, 5);
		gbc_lblBorderColor.gridx = 0;
		gbc_lblBorderColor.gridy = 6;
		batchReactorPreferences.add(lblBorderColor, gbc_lblBorderColor);
		
		txtBatchBorderColor = new JTextField();
		txtBatchBorderColor.setText("000000");
		GridBagConstraints gbc_txtBatchBorderColor = new GridBagConstraints();
		gbc_txtBatchBorderColor.anchor = GridBagConstraints.WEST;
		gbc_txtBatchBorderColor.insets = new Insets(0, 0, 5, 0);
		gbc_txtBatchBorderColor.gridx = 1;
		gbc_txtBatchBorderColor.gridy = 6;
		batchReactorPreferences.add(txtBatchBorderColor, gbc_txtBatchBorderColor);
		txtBatchBorderColor.setColumns(10);
		
		JLabel lblInitialC = new JLabel("Initial C");
		GridBagConstraints gbc_lblInitialC = new GridBagConstraints();
		gbc_lblInitialC.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblInitialC.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitialC.gridx = 0;
		gbc_lblInitialC.gridy = 7;
		batchReactorPreferences.add(lblInitialC, gbc_lblInitialC);
		
		txtBatchInitialC = new JTextField();
		txtBatchInitialC.setText("100");
		GridBagConstraints gbc_txtBatchInitialC = new GridBagConstraints();
		gbc_txtBatchInitialC.anchor = GridBagConstraints.WEST;
		gbc_txtBatchInitialC.insets = new Insets(0, 0, 5, 0);
		gbc_txtBatchInitialC.gridx = 1;
		gbc_txtBatchInitialC.gridy = 7;
		batchReactorPreferences.add(txtBatchInitialC, gbc_txtBatchInitialC);
		txtBatchInitialC.setColumns(10);
		
		JLabel lblInitialK = new JLabel("Initial K");
		GridBagConstraints gbc_lblInitialK = new GridBagConstraints();
		gbc_lblInitialK.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblInitialK.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitialK.gridx = 0;
		gbc_lblInitialK.gridy = 8;
		batchReactorPreferences.add(lblInitialK, gbc_lblInitialK);
		
		txtBatchInitialK = new JTextField();
		txtBatchInitialK.setText(".01");
		GridBagConstraints gbc_txtBatchInitialK = new GridBagConstraints();
		gbc_txtBatchInitialK.anchor = GridBagConstraints.WEST;
		gbc_txtBatchInitialK.insets = new Insets(0, 0, 5, 0);
		gbc_txtBatchInitialK.gridx = 1;
		gbc_txtBatchInitialK.gridy = 8;
		batchReactorPreferences.add(txtBatchInitialK, gbc_txtBatchInitialK);
		txtBatchInitialK.setColumns(10);
		
		JLabel lblTimeStep = new JLabel("Time Step");
		GridBagConstraints gbc_lblTimeStep = new GridBagConstraints();
		gbc_lblTimeStep.insets = new Insets(0, 0, 0, 5);
		gbc_lblTimeStep.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTimeStep.gridx = 0;
		gbc_lblTimeStep.gridy = 9;
		batchReactorPreferences.add(lblTimeStep, gbc_lblTimeStep);
		
		txtBatchTimeStep = new JTextField();
		txtBatchTimeStep.setText("100");
		GridBagConstraints gbc_txtBatchTimeStep = new GridBagConstraints();
		gbc_txtBatchTimeStep.anchor = GridBagConstraints.WEST;
		gbc_txtBatchTimeStep.gridx = 1;
		gbc_txtBatchTimeStep.gridy = 9;
		batchReactorPreferences.add(txtBatchTimeStep, gbc_txtBatchTimeStep);
		txtBatchTimeStep.setColumns(10);
		
		JPanel plugFlowReactorPreferences = new JPanel();
		addTab("Plug Flow Reactor", null, plugFlowReactorPreferences, null);
		GridBagLayout gbl_plugFlowReactorPreferences = new GridBagLayout();
		gbl_plugFlowReactorPreferences.columnWidths = new int[]{152, 0, 0};
		gbl_plugFlowReactorPreferences.rowHeights = new int[]{15, 15, 15, 15, 15, 15, 0, 15, 15, 15, 15, 0};
		gbl_plugFlowReactorPreferences.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_plugFlowReactorPreferences.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		plugFlowReactorPreferences.setLayout(gbl_plugFlowReactorPreferences);
		
		JLabel lblParticles2 = new JLabel("Particles");
		GridBagConstraints gbc_lblParticles2 = new GridBagConstraints();
		gbc_lblParticles2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblParticles2.insets = new Insets(0, 0, 5, 5);
		gbc_lblParticles2.gridx = 0;
		gbc_lblParticles2.gridy = 0;
		plugFlowReactorPreferences.add(lblParticles2, gbc_lblParticles2);
		
		JLabel lblColor2 = new JLabel("Color");
		GridBagConstraints gbc_lblColor2 = new GridBagConstraints();
		gbc_lblColor2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblColor2.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor2.gridx = 0;
		gbc_lblColor2.gridy = 1;
		plugFlowReactorPreferences.add(lblColor2, gbc_lblColor2);
		
		txtPlugFlowParticleColor = new JTextField();
		txtPlugFlowParticleColor.setText("FF0000");
		GridBagConstraints gbc_txtPlugFlowParticleColor = new GridBagConstraints();
		gbc_txtPlugFlowParticleColor.anchor = GridBagConstraints.WEST;
		gbc_txtPlugFlowParticleColor.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlugFlowParticleColor.gridx = 1;
		gbc_txtPlugFlowParticleColor.gridy = 1;
		plugFlowReactorPreferences.add(txtPlugFlowParticleColor, gbc_txtPlugFlowParticleColor);
		txtPlugFlowParticleColor.setColumns(10);
		
		JLabel lblSize2 = new JLabel("Size");
		GridBagConstraints gbc_lblSize2 = new GridBagConstraints();
		gbc_lblSize2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSize2.insets = new Insets(0, 0, 5, 5);
		gbc_lblSize2.gridx = 0;
		gbc_lblSize2.gridy = 2;
		plugFlowReactorPreferences.add(lblSize2, gbc_lblSize2);
		
		txtPlugFlowParticleSize = new JTextField();
		txtPlugFlowParticleSize.setText("2");
		GridBagConstraints gbc_txtPlugFlowParticleSize = new GridBagConstraints();
		gbc_txtPlugFlowParticleSize.anchor = GridBagConstraints.WEST;
		gbc_txtPlugFlowParticleSize.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlugFlowParticleSize.gridx = 1;
		gbc_txtPlugFlowParticleSize.gridy = 2;
		plugFlowReactorPreferences.add(txtPlugFlowParticleSize, gbc_txtPlugFlowParticleSize);
		txtPlugFlowParticleSize.setColumns(10);
		
		JLabel lblNumber2 = new JLabel("Number");
		GridBagConstraints gbc_lblNumber2 = new GridBagConstraints();
		gbc_lblNumber2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNumber2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumber2.gridx = 0;
		gbc_lblNumber2.gridy = 3;
		plugFlowReactorPreferences.add(lblNumber2, gbc_lblNumber2);
		
		txtPlugFlowParticleNumber = new JTextField();
		txtPlugFlowParticleNumber.setText("5000");
		GridBagConstraints gbc_txtPlugFlowParticleNumber = new GridBagConstraints();
		gbc_txtPlugFlowParticleNumber.anchor = GridBagConstraints.WEST;
		gbc_txtPlugFlowParticleNumber.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlugFlowParticleNumber.gridx = 1;
		gbc_txtPlugFlowParticleNumber.gridy = 3;
		plugFlowReactorPreferences.add(txtPlugFlowParticleNumber, gbc_txtPlugFlowParticleNumber);
		txtPlugFlowParticleNumber.setColumns(10);
		
		JLabel lblMotionRate2 = new JLabel("Motion rate");
		GridBagConstraints gbc_lblMotionRate2 = new GridBagConstraints();
		gbc_lblMotionRate2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblMotionRate2.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotionRate2.gridx = 0;
		gbc_lblMotionRate2.gridy = 4;
		plugFlowReactorPreferences.add(lblMotionRate2, gbc_lblMotionRate2);
		
		txtPlugFlowMotionRate = new JTextField();
		txtPlugFlowMotionRate.setText("50");
		GridBagConstraints gbc_txtPlugFlowMotionRate = new GridBagConstraints();
		gbc_txtPlugFlowMotionRate.anchor = GridBagConstraints.WEST;
		gbc_txtPlugFlowMotionRate.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlugFlowMotionRate.gridx = 1;
		gbc_txtPlugFlowMotionRate.gridy = 4;
		plugFlowReactorPreferences.add(txtPlugFlowMotionRate, gbc_txtPlugFlowMotionRate);
		txtPlugFlowMotionRate.setColumns(10);
		
		JLabel lblBackgroundColor2 = new JLabel("Plug 1 Background");
		GridBagConstraints gbc_lblBackgroundColor2 = new GridBagConstraints();
		gbc_lblBackgroundColor2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblBackgroundColor2.insets = new Insets(0, 0, 5, 5);
		gbc_lblBackgroundColor2.gridx = 0;
		gbc_lblBackgroundColor2.gridy = 5;
		plugFlowReactorPreferences.add(lblBackgroundColor2, gbc_lblBackgroundColor2);
		
		txtPlugFlowPlug1Background = new JTextField();
		txtPlugFlowPlug1Background.setText("FFFFFF");
		GridBagConstraints gbc_txtPlugFlowPlug1Background = new GridBagConstraints();
		gbc_txtPlugFlowPlug1Background.anchor = GridBagConstraints.WEST;
		gbc_txtPlugFlowPlug1Background.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlugFlowPlug1Background.gridx = 1;
		gbc_txtPlugFlowPlug1Background.gridy = 5;
		plugFlowReactorPreferences.add(txtPlugFlowPlug1Background, gbc_txtPlugFlowPlug1Background);
		txtPlugFlowPlug1Background.setColumns(10);
		
		JLabel lblPlugBackground = new JLabel("Plug 2 Background");
		GridBagConstraints gbc_lblPlugBackground = new GridBagConstraints();
		gbc_lblPlugBackground.anchor = GridBagConstraints.EAST;
		gbc_lblPlugBackground.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlugBackground.gridx = 0;
		gbc_lblPlugBackground.gridy = 6;
		plugFlowReactorPreferences.add(lblPlugBackground, gbc_lblPlugBackground);
		
		txtPlugFlowPlug2Background = new JTextField();
		txtPlugFlowPlug2Background.setText("BBBBBB");
		GridBagConstraints gbc_txtPlugFlowPlug2Background = new GridBagConstraints();
		gbc_txtPlugFlowPlug2Background.anchor = GridBagConstraints.WEST;
		gbc_txtPlugFlowPlug2Background.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlugFlowPlug2Background.gridx = 1;
		gbc_txtPlugFlowPlug2Background.gridy = 6;
		plugFlowReactorPreferences.add(txtPlugFlowPlug2Background, gbc_txtPlugFlowPlug2Background);
		txtPlugFlowPlug2Background.setColumns(10);
		
		JLabel lblBorderColor2 = new JLabel("Border Color");
		GridBagConstraints gbc_lblBorderColor2 = new GridBagConstraints();
		gbc_lblBorderColor2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblBorderColor2.insets = new Insets(0, 0, 5, 5);
		gbc_lblBorderColor2.gridx = 0;
		gbc_lblBorderColor2.gridy = 7;
		plugFlowReactorPreferences.add(lblBorderColor2, gbc_lblBorderColor2);
		
		txtPlugFlowBorderColor = new JTextField();
		txtPlugFlowBorderColor.setText("000000");
		GridBagConstraints gbc_txtPlugFlowBorderColor = new GridBagConstraints();
		gbc_txtPlugFlowBorderColor.anchor = GridBagConstraints.WEST;
		gbc_txtPlugFlowBorderColor.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlugFlowBorderColor.gridx = 1;
		gbc_txtPlugFlowBorderColor.gridy = 7;
		plugFlowReactorPreferences.add(txtPlugFlowBorderColor, gbc_txtPlugFlowBorderColor);
		txtPlugFlowBorderColor.setColumns(10);
		
		JLabel lblInitialC2 = new JLabel("Initial C");
		GridBagConstraints gbc_lblInitialC2 = new GridBagConstraints();
		gbc_lblInitialC2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblInitialC2.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitialC2.gridx = 0;
		gbc_lblInitialC2.gridy = 8;
		plugFlowReactorPreferences.add(lblInitialC2, gbc_lblInitialC2);
		
		txtPlugFlowInitialC = new JTextField();
		txtPlugFlowInitialC.setText("100");
		GridBagConstraints gbc_txtPlugFlowInitialC = new GridBagConstraints();
		gbc_txtPlugFlowInitialC.anchor = GridBagConstraints.WEST;
		gbc_txtPlugFlowInitialC.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlugFlowInitialC.gridx = 1;
		gbc_txtPlugFlowInitialC.gridy = 8;
		plugFlowReactorPreferences.add(txtPlugFlowInitialC, gbc_txtPlugFlowInitialC);
		txtPlugFlowInitialC.setColumns(10);
		
		JLabel lblInitialK2 = new JLabel("Initial K");
		GridBagConstraints gbc_lblInitialK2 = new GridBagConstraints();
		gbc_lblInitialK2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblInitialK2.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitialK2.gridx = 0;
		gbc_lblInitialK2.gridy = 9;
		plugFlowReactorPreferences.add(lblInitialK2, gbc_lblInitialK2);
		
		txtPlugFlowInitialK = new JTextField();
		txtPlugFlowInitialK.setText(".01");
		GridBagConstraints gbc_txtPlugFlowInitialK = new GridBagConstraints();
		gbc_txtPlugFlowInitialK.anchor = GridBagConstraints.WEST;
		gbc_txtPlugFlowInitialK.insets = new Insets(0, 0, 5, 0);
		gbc_txtPlugFlowInitialK.gridx = 1;
		gbc_txtPlugFlowInitialK.gridy = 9;
		plugFlowReactorPreferences.add(txtPlugFlowInitialK, gbc_txtPlugFlowInitialK);
		txtPlugFlowInitialK.setColumns(10);
		
		JLabel lblTimeStep2 = new JLabel("Time Step");
		GridBagConstraints gbc_lblTimeStep2 = new GridBagConstraints();
		gbc_lblTimeStep2.insets = new Insets(0, 0, 0, 5);
		gbc_lblTimeStep2.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTimeStep2.gridx = 0;
		gbc_lblTimeStep2.gridy = 10;
		plugFlowReactorPreferences.add(lblTimeStep2, gbc_lblTimeStep2);
		
		txtPlugFlowTimeStep = new JTextField();
		txtPlugFlowTimeStep.setText("100");
		GridBagConstraints gbc_txtPlugFlowTimeStep = new GridBagConstraints();
		gbc_txtPlugFlowTimeStep.anchor = GridBagConstraints.WEST;
		gbc_txtPlugFlowTimeStep.gridx = 1;
		gbc_txtPlugFlowTimeStep.gridy = 10;
		plugFlowReactorPreferences.add(txtPlugFlowTimeStep, gbc_txtPlugFlowTimeStep);
		txtPlugFlowTimeStep.setColumns(10);
		
		JPanel continuouslyStirredReactorPreferences = new JPanel();
		addTab("Continuously Stirred Reactor", null, continuouslyStirredReactorPreferences, null);

		GridBagLayout gbl_continuouslyStirredReactorPreferences = new GridBagLayout();
		gbl_continuouslyStirredReactorPreferences.columnWidths = new int[]{137, 0, 0};
		gbl_continuouslyStirredReactorPreferences.rowHeights = new int[]{15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 0};
		gbl_continuouslyStirredReactorPreferences.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_continuouslyStirredReactorPreferences.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		continuouslyStirredReactorPreferences.setLayout(gbl_continuouslyStirredReactorPreferences);
		
		JLabel lblParticles3 = new JLabel("Particles");
		GridBagConstraints gbc_lblParticles3 = new GridBagConstraints();
		gbc_lblParticles3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblParticles3.insets = new Insets(0, 0, 5, 5);
		gbc_lblParticles3.gridx = 0;
		gbc_lblParticles3.gridy = 0;
		continuouslyStirredReactorPreferences.add(lblParticles3, gbc_lblParticles3);
		
		JLabel lblColor3 = new JLabel("Color");
		GridBagConstraints gbc_lblColor3 = new GridBagConstraints();
		gbc_lblColor3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblColor3.insets = new Insets(0, 0, 5, 5);
		gbc_lblColor3.gridx = 0;
		gbc_lblColor3.gridy = 1;
		continuouslyStirredReactorPreferences.add(lblColor3, gbc_lblColor3);
		
		txtContinuouslyStirredParticleColor = new JTextField();
		txtContinuouslyStirredParticleColor.setText("FF0000");
		GridBagConstraints gbc_txtContinuouslyStirredParticleColor = new GridBagConstraints();
		gbc_txtContinuouslyStirredParticleColor.anchor = GridBagConstraints.WEST;
		gbc_txtContinuouslyStirredParticleColor.insets = new Insets(0, 0, 5, 0);
		gbc_txtContinuouslyStirredParticleColor.gridx = 1;
		gbc_txtContinuouslyStirredParticleColor.gridy = 1;
		continuouslyStirredReactorPreferences.add(txtContinuouslyStirredParticleColor, gbc_txtContinuouslyStirredParticleColor);
		txtContinuouslyStirredParticleColor.setColumns(10);
		
		JLabel lblSize3 = new JLabel("Size");
		GridBagConstraints gbc_lblSize3 = new GridBagConstraints();
		gbc_lblSize3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSize3.insets = new Insets(0, 0, 5, 5);
		gbc_lblSize3.gridx = 0;
		gbc_lblSize3.gridy = 2;
		continuouslyStirredReactorPreferences.add(lblSize3, gbc_lblSize3);
		
		txtContinuouslyStirredParticleSize = new JTextField();
		txtContinuouslyStirredParticleSize.setText("2");
		GridBagConstraints gbc_txtContinuouslyStirredParticleSize = new GridBagConstraints();
		gbc_txtContinuouslyStirredParticleSize.anchor = GridBagConstraints.WEST;
		gbc_txtContinuouslyStirredParticleSize.insets = new Insets(0, 0, 5, 0);
		gbc_txtContinuouslyStirredParticleSize.gridx = 1;
		gbc_txtContinuouslyStirredParticleSize.gridy = 2;
		continuouslyStirredReactorPreferences.add(txtContinuouslyStirredParticleSize, gbc_txtContinuouslyStirredParticleSize);
		txtContinuouslyStirredParticleSize.setColumns(10);
		
		JLabel lblNumber3 = new JLabel("Number");
		GridBagConstraints gbc_lblNumber3 = new GridBagConstraints();
		gbc_lblNumber3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNumber3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumber3.gridx = 0;
		gbc_lblNumber3.gridy = 3;
		continuouslyStirredReactorPreferences.add(lblNumber3, gbc_lblNumber3);
		
		txtContinuouslyStirredParticleNumber = new JTextField();
		txtContinuouslyStirredParticleNumber.setText("5000");
		GridBagConstraints gbc_txtContinuouslyStirredParticleNumber = new GridBagConstraints();
		gbc_txtContinuouslyStirredParticleNumber.anchor = GridBagConstraints.WEST;
		gbc_txtContinuouslyStirredParticleNumber.insets = new Insets(0, 0, 5, 0);
		gbc_txtContinuouslyStirredParticleNumber.gridx = 1;
		gbc_txtContinuouslyStirredParticleNumber.gridy = 3;
		continuouslyStirredReactorPreferences.add(txtContinuouslyStirredParticleNumber, gbc_txtContinuouslyStirredParticleNumber);
		txtContinuouslyStirredParticleNumber.setColumns(10);
		
		JLabel lblMotionRate3 = new JLabel("Motion rate");
		GridBagConstraints gbc_lblMotionRate3 = new GridBagConstraints();
		gbc_lblMotionRate3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblMotionRate3.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotionRate3.gridx = 0;
		gbc_lblMotionRate3.gridy = 4;
		continuouslyStirredReactorPreferences.add(lblMotionRate3, gbc_lblMotionRate3);
		
		txtContinuouslyStirredMotionRate = new JTextField();
		txtContinuouslyStirredMotionRate.setText("50");
		GridBagConstraints gbc_txtContinuouslyStirredMotionRate = new GridBagConstraints();
		gbc_txtContinuouslyStirredMotionRate.anchor = GridBagConstraints.WEST;
		gbc_txtContinuouslyStirredMotionRate.insets = new Insets(0, 0, 5, 0);
		gbc_txtContinuouslyStirredMotionRate.gridx = 1;
		gbc_txtContinuouslyStirredMotionRate.gridy = 4;
		continuouslyStirredReactorPreferences.add(txtContinuouslyStirredMotionRate, gbc_txtContinuouslyStirredMotionRate);
		txtContinuouslyStirredMotionRate.setColumns(10);
		
		JLabel lblBackgroundColor3 = new JLabel("Background Color");
		GridBagConstraints gbc_lblBackgroundColor3 = new GridBagConstraints();
		gbc_lblBackgroundColor3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblBackgroundColor3.insets = new Insets(0, 0, 5, 5);
		gbc_lblBackgroundColor3.gridx = 0;
		gbc_lblBackgroundColor3.gridy = 5;
		continuouslyStirredReactorPreferences.add(lblBackgroundColor3, gbc_lblBackgroundColor3);
		
		txtContinuouslyStirredBackgroundColor = new JTextField();
		txtContinuouslyStirredBackgroundColor.setText("FFFFFF");
		GridBagConstraints gbc_txtContinuouslyStirredBackgroundColor = new GridBagConstraints();
		gbc_txtContinuouslyStirredBackgroundColor.anchor = GridBagConstraints.WEST;
		gbc_txtContinuouslyStirredBackgroundColor.insets = new Insets(0, 0, 5, 0);
		gbc_txtContinuouslyStirredBackgroundColor.gridx = 1;
		gbc_txtContinuouslyStirredBackgroundColor.gridy = 5;
		continuouslyStirredReactorPreferences.add(txtContinuouslyStirredBackgroundColor, gbc_txtContinuouslyStirredBackgroundColor);
		txtContinuouslyStirredBackgroundColor.setColumns(10);
		
		JLabel lblBorderColor3 = new JLabel("Border Color");
		GridBagConstraints gbc_lblBorderColor3 = new GridBagConstraints();
		gbc_lblBorderColor3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblBorderColor3.insets = new Insets(0, 0, 5, 5);
		gbc_lblBorderColor3.gridx = 0;
		gbc_lblBorderColor3.gridy = 6;
		continuouslyStirredReactorPreferences.add(lblBorderColor3, gbc_lblBorderColor3);
		
		txtContinuouslyStirredBorderColor = new JTextField();
		txtContinuouslyStirredBorderColor.setText("000000");
		GridBagConstraints gbc_txtContinuouslyStirredBorderColor = new GridBagConstraints();
		gbc_txtContinuouslyStirredBorderColor.anchor = GridBagConstraints.WEST;
		gbc_txtContinuouslyStirredBorderColor.insets = new Insets(0, 0, 5, 0);
		gbc_txtContinuouslyStirredBorderColor.gridx = 1;
		gbc_txtContinuouslyStirredBorderColor.gridy = 6;
		continuouslyStirredReactorPreferences.add(txtContinuouslyStirredBorderColor, gbc_txtContinuouslyStirredBorderColor);
		txtContinuouslyStirredBorderColor.setColumns(10);
		
		JLabel lblInitialC3 = new JLabel("Initial C");
		GridBagConstraints gbc_lblInitialC3 = new GridBagConstraints();
		gbc_lblInitialC3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblInitialC3.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitialC3.gridx = 0;
		gbc_lblInitialC3.gridy = 7;
		continuouslyStirredReactorPreferences.add(lblInitialC3, gbc_lblInitialC3);
		
		txtContinuouslyStirredInitialC = new JTextField();
		txtContinuouslyStirredInitialC.setText("100");
		GridBagConstraints gbc_txtContinuouslyStirredInitialC = new GridBagConstraints();
		gbc_txtContinuouslyStirredInitialC.anchor = GridBagConstraints.WEST;
		gbc_txtContinuouslyStirredInitialC.insets = new Insets(0, 0, 5, 0);
		gbc_txtContinuouslyStirredInitialC.gridx = 1;
		gbc_txtContinuouslyStirredInitialC.gridy = 7;
		continuouslyStirredReactorPreferences.add(txtContinuouslyStirredInitialC, gbc_txtContinuouslyStirredInitialC);
		txtContinuouslyStirredInitialC.setColumns(10);
		
		JLabel lblInitialK3 = new JLabel("Initial K");
		GridBagConstraints gbc_lblInitialK3 = new GridBagConstraints();
		gbc_lblInitialK3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblInitialK3.insets = new Insets(0, 0, 5, 5);
		gbc_lblInitialK3.gridx = 0;
		gbc_lblInitialK3.gridy = 8;
		continuouslyStirredReactorPreferences.add(lblInitialK3, gbc_lblInitialK3);
		
		txtContinuouslyStirredInitialK = new JTextField();
		txtContinuouslyStirredInitialK.setText(".01");
		GridBagConstraints gbc_txtContinuouslyStirredInitialK = new GridBagConstraints();
		gbc_txtContinuouslyStirredInitialK.anchor = GridBagConstraints.WEST;
		gbc_txtContinuouslyStirredInitialK.insets = new Insets(0, 0, 5, 0);
		gbc_txtContinuouslyStirredInitialK.gridx = 1;
		gbc_txtContinuouslyStirredInitialK.gridy = 8;
		continuouslyStirredReactorPreferences.add(txtContinuouslyStirredInitialK, gbc_txtContinuouslyStirredInitialK);
		txtContinuouslyStirredInitialK.setColumns(10);
		
		JLabel lblTimeStep3 = new JLabel("Time Step");
		GridBagConstraints gbc_lblTimeStep3 = new GridBagConstraints();
		gbc_lblTimeStep3.insets = new Insets(0, 0, 0, 5);
		gbc_lblTimeStep3.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTimeStep3.gridx = 0;
		gbc_lblTimeStep3.gridy = 9;
		continuouslyStirredReactorPreferences.add(lblTimeStep3, gbc_lblTimeStep3);
		
		txtContinuouslyStirredTimeStep = new JTextField();
		txtContinuouslyStirredTimeStep.setText("100");
		GridBagConstraints gbc_txtContinuouslyStirredTimeStep = new GridBagConstraints();
		gbc_txtContinuouslyStirredTimeStep.anchor = GridBagConstraints.WEST;
		gbc_txtContinuouslyStirredTimeStep.gridx = 1;
		gbc_txtContinuouslyStirredTimeStep.gridy = 9;
		continuouslyStirredReactorPreferences.add(txtContinuouslyStirredTimeStep, gbc_txtContinuouslyStirredTimeStep);
		txtContinuouslyStirredTimeStep.setColumns(10);
	}
}
