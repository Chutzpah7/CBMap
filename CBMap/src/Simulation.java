import java.awt.Point;
import java.awt.geom.Point2D;
import java.math.*;
public class Simulation {
	private final int headingOptions = 20; //Number of headings to check when generating map
	
	private Point2D obstacle;
	private Point2D objectave;
	private double obstacleRadius = 5;	
	//Vehicle Information---------------------------------------------------
	private Point2D.Float position;
	private double heading; //θ
	private double headingChange; //dθ/dt
	private double maxHeadingChangeMagnitude = 5; //Degrees per second
	private final double speed = 1.5;
	//----------------------------------------------------------------------
	
	//Time related variables------------------------------------------------
	public static final double timeStep = 0.005;
	private int stepsElapsed = 0;
	private boolean dead = false;
	//----------------------------------------------------------------------

	
	//CB Maps---------------------------------------------------------------
	/*
	 * These have a known number of heading options, and based on the maximum heading change and
	 * the number of heading options, each index can be mapped to a specific heading. Arrays are
	 * efficient for holding these fixed double values for each heading.
	*/
	private double[] costMap = new double[headingOptions];
	private double[] benefitMap = new double[headingOptions];
	private double[] comboMap = new double[headingOptions];
	//----------------------------------------------------------------------

	public Simulation() {
		this.position = new Point2D.Float(0, 0);
		this.obstacle = new Point2D.Float(50, 0);
		this.objectave = new Point(100, 0);
		this.heading = 0;
	}
	public Point2D getPosition(){
		return position;
	}
	public Point2D getObstacle(){
		return obstacle;
	}
	public Point2D getObjective(){
		return objectave;
	} 
	public double getDX(){
		return speed*Math.cos(Math.toRadians(heading));
	}
	public double getDY(){
		return speed*Math.sin(Math.toRadians(heading));
	}
	public double getHeading(){
		return heading;
	}
	public double getObstacleRadius(){
		return obstacleRadius;
	}
	public double[] getCostMap(){
		return costMap;
	}
	public double[] getBenefitMap(){
		return benefitMap;
	}
	public double[] getComboMap(){
		return comboMap;
	}
	
	// This step method represents a very small amount of time passing.
	public void step(){
		//Generate maps
		updateBenefitMap();
		updateCostMap();
		updateComboMap();
		
		//Choose headingChange
		
		int maxCBIndex = 0;
		for(int i = 1; i<headingOptions; i++){
			if (comboMap[i] > comboMap[maxCBIndex]){
				maxCBIndex = i;
			}
		}
		
		//This calculation calculates the corresponding heading change of an index in a map array
		headingChange = 2.0*maxHeadingChangeMagnitude/(headingOptions)*maxCBIndex-maxHeadingChangeMagnitude;
		
		//Increment heading
		heading = heading + timeStep*headingChange;
		
		//Increment position
		position.setLocation(position.getX()+getDX()*timeStep,
				position.getY()+getDY()*timeStep);
		
		//TODO: Check if alive
		
		//TODO: Check if at objective
		
	}
	public void updateBenefitMap(){
		switch (Runner.benefitFunction) {
		case "Linear":
			int optimalHeadingIndex = 0;
			for(int i = 0; i < headingOptions; i++){
				//TODO 
			}
			break;

		default:
			break;
		}
	}
	public void updateCostMap(){
		switch (Runner.costFunction) {
		case "Step":
			for(int i = 0; i < headingOptions; i++){
				//TODO
			}
			break;

		default:
			break;
		}
	}
	public boolean isAlive(){
		return !dead;
	}
	public void updateComboMap(){
		switch (Runner.comboMethod) {
		case "Addition":
			//TODO
			break;

		default:
			break;
		}
	}
}

