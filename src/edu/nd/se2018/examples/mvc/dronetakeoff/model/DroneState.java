package edu.nd.se2018.examples.mvc.dronetakeoff.model;

import java.awt.Point;

import javafx.scene.text.Text;

/**
 * Manages the state of a single drone
 * @author Jane
 *
 */
public class DroneState {
	Point droneCoordinates;
	IFlyingState ascendingState;
	IFlyingState hoveringState;
	IFlyingState landingState;
	IFlyingState groundState;
	IFlyingState currentState;
	Text infoMessage;
	
	public void setCoordinates(Point point){
		droneCoordinates = point;
	}
	
	public DroneState(Text infoMessage){
		this.infoMessage = infoMessage;
	}
	
	public Point getCoordinates(){
		return droneCoordinates;
	}
	
	/**
	 * Sets information message
	 * @param text
	 */
	public void setInfoMessage(String text){
		infoMessage.setText(text);
	}
	
	public void initializeStates(){
		ascendingState = new Ascending(this);
		hoveringState = new Hovering(this);
		landingState = new Landing(this);
		groundState = new OnGround(this);
		currentState = groundState;
	}
	
	public void setFlyingState(IFlyingState flyingState){
		currentState = flyingState;		
	}
	public IFlyingState getFlyingState(){
		return currentState;
	}
	public IFlyingState getAscendingState(){
		return ascendingState;
	}
	public IFlyingState getHoveringState(){
		return hoveringState;
	}
	public IFlyingState getLandingState(){
		return landingState;
	}
	public IFlyingState getGroundState(){
		return groundState;
	}
	
}
