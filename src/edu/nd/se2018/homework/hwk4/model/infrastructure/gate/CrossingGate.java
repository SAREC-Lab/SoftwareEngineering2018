package edu.nd.se2018.homework.hwk4.model.infrastructure.gate;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.hwk4.model.infrastructure.Direction;
import edu.nd.se2018.homework.hwk4.model.vehicles.Train;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Context class for Crossing Gate
 *
 */
public class CrossingGate extends Observable implements Observer{
	
	// Crossing Gate location and its trigger & exit points
	private int anchorX;
	private int anchorY;
	private int movingX;
	private int movingY;
	private int triggerPoint1;
	private int triggerPoint2;
	private int exitPoint1;
	private int exitPoint2;
	private Boolean train1, train2;

	private IGateState gateClosed;
	private IGateState gateOpen;
	private IGateState gateClosing;
	private IGateState gateOpening;
	private IGateState currentGateState;
	private Line line; 
	private Pane root;
	
	public String gateName;
	
	public CrossingGate(){}
	
	public CrossingGate(int xPosition, int yPosition, String crossingGate){		
		anchorX = xPosition;
		anchorY = yPosition;
		movingX = anchorX;
		movingY = anchorY-60;
		triggerPoint1 = anchorX+250;
		triggerPoint2 = anchorX-250;
		exitPoint1 = anchorX-250;
		exitPoint2 = anchorX+250;
		train1 = false;
		train2 = false;
		
		// Gate elements
		line = new Line(anchorX, anchorY,movingX,movingY);
		line.setStroke(Color.RED);
	    line.setStrokeWidth(10);
		
		// Gate States
		gateClosed = new GateClosed(this);
		gateOpen = new GateOpen(this);
		gateOpening = new GateOpening(this);
		gateClosing = new GateClosing(this);
		currentGateState = gateOpen;
		gateName = crossingGate;
	}
	
	public Line getGateLine(){
		return line;
	}
	
	public void operateGate(){
		currentGateState.operate();
	}
	
	public void close(){
		if (movingY<anchorY){		
		    movingX+=1;
		    movingY+=1;
			line.setStartX(anchorX);
			line.setStartY(anchorY);
			line.setEndX(movingX);
			line.setEndY(movingY);
		} else {
			currentGateState.gateFinishedOpening();
		}
	}
	
	public void open(){
		if (movingX>anchorX){
			movingX-=1;
			movingY-=1;		
			line.setStartX(anchorX);
			line.setStartY(anchorY);
			line.setEndX(movingX);
			line.setEndY(movingY);
		}  else {
			currentGateState.gateFinishedOpening();
		}
	}
	
	// State getters and setters
	public IGateState getGateClosedState(){
		return gateClosed;
	}
	public IGateState getGateOpenState(){
		return gateOpen;
	}
	public IGateState getGateClosingState(){
		return gateClosing;
	}
	public IGateState getGateOpeningState(){
		return gateOpening;
	}
	
	public void setGateState(IGateState newState){
		currentGateState = newState;
		setChanged();
		notifyObservers();
	}
	
	public String getTrafficCommand(){
		return currentGateState.getTrafficAction();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Train){
			Train train = (Train)o;
			if (train.getDirection() == Direction.WEST) {
				if (train.getVehicleX() < exitPoint1) {
					if (train2 == false) {
						currentGateState.leaveStation();
					}
					train1 = false;
				}
				else if(train.getVehicleX() < triggerPoint1) { //|| train.getVehicleX() < triggerPoint2) {
					currentGateState.approachStation();
					train1 = true;
				}
			}
			else if (train.getDirection() == Direction.EAST) {
				if (train.getVehicleX() > exitPoint2) {
					if (train1 == false) {
						currentGateState.leaveStation();
					}
					train2 = false;
				}
				else if (train.getVehicleX() > triggerPoint2) { //|| train.getVehicleX() < triggerPoint1) {
					currentGateState.approachStation();
					train2 = true;
				}
			}
		}	
	}
}
