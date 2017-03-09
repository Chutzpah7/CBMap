import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class SimulationCanvas extends JPanel {
	
	public static Simulation simulationObject;
	
	private final Color vehicleColor = new Color(0x2f, 0x62, 0xbe);
	
	public SimulationCanvas(){
		super();
		simulationObject = new Simulation();
		
	}
	public void paintComponent(Graphics q){
		super.paintComponent(q);
		Graphics2D g = (Graphics2D)q;
		
		//Draw Vehicle--------------------------------------------------------
		g.setColor(vehicleColor);
		//--------------------------------------------------------------------
	}
}
