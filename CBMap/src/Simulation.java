import java.awt.Point;
import java.awt.geom.Point2D;
import java.math.*;
public class Simulation {
	private final int headingOptions = 20; //Number of headings to check when generating map
	
	private Point2D obstacle;
	private Point2D objectave;
	
	//Vehicle Information---------------------------------------------------
	private Point2D.Float position;
	private double heading; //θ
	private double headingChange; //dθ/dt
	private double maxHeadingChangeMagnitude = 5; //Degrees per second
	private final double speed = 1.5;
	//----------------------------------------------------------------------
	
	//Time related variables------------------------------------------------
	private final double timeStep = 0.05;
	private int stepsElapsed = 0;
	//----------------------------------------------------------------------

	
	//CB Maps---------------------------------------------------------------
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
	public void step(){
		//Generate maps
		updateBenefitMap();
		updateCostMap();
		updateComboMap();
		//Choose headingChange
		
		int maxCBIndex = 0;
		for(int i = 1; i<headingOptions; i++){
			if (comboMap[i] > comboMap[maxCBIndex]){
				
			}
		}
		headingChange = 2*maxHeadingChangeMagnitude/(headingOptions)*maxCBIndex-maxHeadingChangeMagnitude;
		//Increment heading
		heading = heading + timeStep*headingChange;
		//Increment position
		position.setLocation(position.getX()+getDX(),
				position.getY()+getDY());
		
	}
	public void updateBenefitMap(){
		switch (Runner.benefitFunction) {
		case "Linear":
			int optimalHeadingIndex = 0;
			for(int i = 1; i < headingOptions; i++){
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

