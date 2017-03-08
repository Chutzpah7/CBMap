import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SimulationCanvas extends JPanel {
	
	public static Simulation simulationObject;
	
	public SimulationCanvas(){
		super();
		simulationObject = new Simulation();
		setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g){
		
	}
}
