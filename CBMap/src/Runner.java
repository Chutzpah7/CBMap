import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Runner extends JFrame {
	
	public static String costFunction = "Step";
	public static String benefitFunction = "Linear";
	public static String comboMethod = "Addition";
	public static boolean paused = true;
	public static JPanel benefitMap;
	public static JPanel costMap;
	public static JPanel comboMap;
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Runner frame = new Runner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Runner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel configuration = new JPanel();
		configuration.setBorder(new EmptyBorder(10, 10, 10, 10));
		tabbedPane.addTab("Config", null, configuration, null);
		configuration.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel costPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) costPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		costPanel.setBorder(new TitledBorder(null, "Cost Function", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		configuration.add(costPanel);
		
		Box verticalBox = Box.createVerticalBox();
		costPanel.add(verticalBox);
		
		JRadioButton stepCost = new JRadioButton("Step");
		stepCost.setSelected(true);
		verticalBox.add(stepCost);
		stepCost.setActionCommand("Step");
		
		JRadioButton quadraticCost = new JRadioButton("Quadratic");
		verticalBox.add(quadraticCost);
		quadraticCost.setActionCommand("Quadratic");
		
		JRadioButton exponentialCost = new JRadioButton("Exponential");
		verticalBox.add(exponentialCost);
		exponentialCost.setActionCommand("Exponential");
		
		ButtonGroup costButtons = new ButtonGroup();
		costButtons.add(stepCost);
		costButtons.add(quadraticCost);
		costButtons.add(exponentialCost);
		
		// Create ActionListener and add it to buttons ---------------------------------------------------------
		ActionListener costListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				costFunction = e.getActionCommand();
			}
		};
		stepCost.addActionListener(costListener);
		quadraticCost.addActionListener(costListener);
		exponentialCost.addActionListener(costListener);
		//------------------------------------------------------------------------------------------------------

		JPanel benefitPanel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) benefitPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		benefitPanel.setBorder(new TitledBorder(null, "Benefit Function", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		configuration.add(benefitPanel);
		
		Box verticalBox_1 = Box.createVerticalBox();
		benefitPanel.add(verticalBox_1);
		
		JRadioButton linearBenefit = new JRadioButton("Linear");
		linearBenefit.setSelected(true);
		verticalBox_1.add(linearBenefit);
		linearBenefit.setActionCommand("Linear");
		
		JRadioButton quadraticBenefit = new JRadioButton("Quadratic");
		verticalBox_1.add(quadraticBenefit);
		quadraticBenefit.setActionCommand("Quadratic");
		
		JRadioButton exponentialBenefit = new JRadioButton("Exponential");
		verticalBox_1.add(exponentialBenefit);
		exponentialBenefit.setActionCommand("Exponential");
		
		ButtonGroup benefitButtons = new ButtonGroup();
		benefitButtons.add(linearBenefit);
		benefitButtons.add(quadraticBenefit);
		benefitButtons.add(exponentialBenefit);
		
		// Create ActionListener and add it to buttons ---------------------------------------------------------
		ActionListener benefitListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				benefitFunction = e.getActionCommand();
			}
		};
		linearBenefit.addActionListener(benefitListener);
		quadraticBenefit.addActionListener(benefitListener);
		exponentialBenefit.addActionListener(benefitListener);
		//------------------------------------------------------------------------------------------------------
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_2.setBorder(new TitledBorder(null, "Cost-Benefit Map", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		configuration.add(panel_2);
		
		Box verticalBox_2 = Box.createVerticalBox();
		panel_2.add(verticalBox_2);
		
		JRadioButton additionCombo = new JRadioButton("Addition");
		verticalBox_2.add(additionCombo);
		additionCombo.setSelected(true);
		additionCombo.setActionCommand("Addition");
		
		// Create ActionListener and add it to buttons ---------------------------------------------------------
		ActionListener comboListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboMethod = e.getActionCommand();
			}
		};
		additionCombo.addActionListener(comboListener);
		//------------------------------------------------------------------------------------------------------
		
		
		JPanel simTab = new JPanel();
		tabbedPane.addTab("Simulation", null, simTab, null);
		simTab.setLayout(new BorderLayout(0, 0));
		
		SimulationCanvas canvas = new SimulationCanvas();
		simTab.add(canvas, BorderLayout.CENTER);
		canvas.setBorder(new TitledBorder(null, "Simulation", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		
		JPanel mapContainer = new JPanel();
		simTab.add(mapContainer, BorderLayout.EAST);
		mapContainer.setLayout(new GridLayout(0, 1, 0, 0));
		mapContainer.setPreferredSize(new Dimension(250, 480));
		
		MapPanel benefitMap = new MapPanel("Benefit", SimulationCanvas.objectiveColor);
		benefitMap.setBorder(new TitledBorder(null, "Benefit Map", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mapContainer.add(benefitMap);
		
		MapPanel costMap = new MapPanel("Cost", SimulationCanvas.obstacleColor);
		mapContainer.add(costMap);
		costMap.setBorder(new TitledBorder(null, "Cost Map", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		MapPanel comboMap = new MapPanel("Combo", SimulationCanvas.vehicleColor);
		mapContainer.add(comboMap);
		comboMap.setBorder(new TitledBorder(null, "Combo Map", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		
		JPanel buttonContainer = new JPanel();
		simTab.add(buttonContainer, BorderLayout.SOUTH);
		
		Box horizontalBox = Box.createHorizontalBox();
		buttonContainer.add(horizontalBox);
		
		JButton forwardStep = new JButton("⏭");	
		JButton togglePause = new JButton("▶");
		
		horizontalBox.add(togglePause);
		horizontalBox.add(forwardStep);
		
		//Pause button action listener--------------------------------------------------------------------------
		ActionListener pauseListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(paused){
					paused = false;
					togglePause.setText("⏸");
					canvas.repaint();
				} else {
					paused = true;
					togglePause.setText("▶");
					System.out.println(canvas.getWidth());
				}
				forwardStep.setEnabled(paused);
			}
		};
		//------------------------------------------------------------------------------------------------------
		togglePause.addActionListener(pauseListener);
		
		ActionListener stepListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.repaint();
			}
		};
		
		
		
		
	}
}
