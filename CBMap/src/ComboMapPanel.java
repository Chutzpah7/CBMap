import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class ComboMapPanel extends JPanel{
	public ComboMapPanel(){
		super();
	}
	
	public void paintComponent(Graphics q){
		
		Graphics2D g = (Graphics2D)q;
		
		
		//Loop if unpaused----------------------------------------------------
				if(!Runner.paused){
					if(SimulationCanvas.simulationObject.isAlive()){
						repaint(); //This could be more efficient
					}
				}
		//--------------------------------------------------------------------
	}
}
