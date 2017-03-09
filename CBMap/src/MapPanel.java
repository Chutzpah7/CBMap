import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MapPanel extends JPanel{
	
	private String mapType;
	private Color mapColor;
	
	public MapPanel(String mapType, Color color){
		super();
		this.mapType = mapType;
		this.mapColor = color;
	}
	public void paintComponent(Graphics q){
		Graphics2D g = (Graphics2D)q;
		
		super.paintComponent(q);
				
		double[] mapPoints;
		
		switch (mapType) {
		case "Cost":
			mapPoints = SimulationCanvas.simulationObject.getCostMap();
			setBackground(Color.WHITE);setOpaque(true);
			break;
		case "Benefit":
			mapPoints = SimulationCanvas.simulationObject.getBenefitMap();
			break;
		case "Combo":
			mapPoints = SimulationCanvas.simulationObject.getComboMap();
			break;
		default:
			mapPoints = null;
			break;
		}
		g.setColor(mapColor);
		
		//Find minimum---------------------------------------------------------
		double min = mapPoints[0];
		double max = mapPoints[0];
		for(double d : mapPoints){
			if(d<min){
				min=d;
			}
			if(d>max){
				max=d;
			}
		}
		//---------------------------------------------------------------------
		
		for(int i = 0; i < mapPoints.length-1; i++){
			
		}
	}
}
