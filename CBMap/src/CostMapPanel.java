import java.awt.Graphics;

import javax.swing.*;

public class CostMapPanel extends JPanel {
	public CostMapPanel(){
		super();
	}
	
	public void paintComponent(Graphics g){
		//Loop if unpaused----------------------------------------------------
				if(!Runner.paused){
					if(SimulationCanvas.simulationObject.isAlive()){
						repaint(); //This could be more efficient
					}
				}
		//--------------------------------------------------------------------
	}
}