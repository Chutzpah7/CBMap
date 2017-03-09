import java.awt.Graphics;

import javax.swing.*;

public class BenefitMapPanel extends JPanel {
	public BenefitMapPanel(){
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
