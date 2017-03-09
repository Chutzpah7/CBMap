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
		
		double[] mapPoints;
		
		switch (mapType) {
		case "Cost":
			mapPoints = SimulationCanvas.simulationObject.getCostMap();
			break;
		case "Benefit":
			mapPoints = SimulationCanvas.simulationObject.getBenefitMap();
			break;
		case "Combo":
			mapPoints = SimulationCanvas.simulationObject.getComboMap();
			break;
		default:
			break;
		}
	}
}
