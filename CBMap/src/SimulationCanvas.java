import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class SimulationCanvas extends JPanel {
	
	
	public static Simulation simulationObject;
	
	private final int xViewRange = 150;
	public static final Color vehicleColor = new Color(0x2f, 0x62, 0xbe);
	public static final Color obstacleColor = new Color(0xc9, 0x13, 0x00);
	public static final Color objectiveColor = new Color(0x0f, 0xa4, 0x00);
	public SimulationCanvas(){
		super();
		simulationObject = new Simulation();
		
	}
	public void paintComponent(Graphics q){
		
		simulationObject.step();
		
		Runner.costMap.repaint();
		Runner.benefitMap.repaint();
		Runner.comboMap.repaint();
		
		super.paintComponent(q);
		Graphics2D g = (Graphics2D)q;
		//setBackground(Color.WHITE);setOpaque(true);// remove
		
		//Draw Vehicle--------------------------------------------------------
		g.setColor(vehicleColor);
		Point veh = pointToPixel(simulationObject.getPosition());
		g.fillOval((int)veh.getX()-5, (int)veh.getY()-5, 10, 10);//TODO make this into a nice arrow looking thing to be able to see heading. Means using rotation matrix :(
		
		//--------------------------------------------------------------------
		
		//Draw Obstacle-------------------------------------------------------
		g.setColor(obstacleColor);
		Point obs = pointToPixel(simulationObject.getObstacle());
		int radius = (int)(simulationObject.getObstacleRadius()*getWidth()/xViewRange);
		g.fillOval((int)obs.getX()-radius, (int)obs.getY()-radius, 2*radius, 2*radius);
		//--------------------------------------------------------------------
		
		//Draw Objective------------------------------------------------------
		g.setColor(objectiveColor);
		Point obj = pointToPixel(simulationObject.getObjective());
		g.fillOval((int)obj.getX()-5, (int)obj.getY()-5, 10, 10);
		//--------------------------------------------------------------------
		
		//Loop if unpaused----------------------------------------------------
		if(!Runner.paused){
			if(SimulationCanvas.simulationObject.isAlive()){
				repaint(); //This could be more efficient
			}
		}
		//--------------------------------------------------------------------
	}
	public Point pointToPixel(Point2D p) {
		//calculation to get square aspect ratio
		double n=(double)xViewRange*getHeight()/getWidth();
		
		Point ret = new Point((int)((p.getX()+(xViewRange - simulationObject.getObjective().getX())/2.0)*getWidth()/xViewRange), (int)((n/2-p.getY())*getHeight()/n));
		return ret;
	}
	public Simulation getSimulationObject(){
		return simulationObject;
	}
}
