package edu.nd.se2018.examples.mvc.dronetakeoff.model;

public class Hovering implements IFlyingState{
	
	DroneState droneState;
	
	public Hovering (DroneState droneState){
		this.droneState = droneState;
	}

	@Override
	public void takeoffPressed() {  
		droneState.setFlyingState(droneState.getAscendingState());
		droneState.setInfoMessage("Ascending again");
	}

	@Override
	public void landPressed() {
		droneState.setFlyingState(droneState.getLandingState());		
		droneState.setInfoMessage("Landing again");
	}

	@Override
	public void reachedGround() {
		// Impossible to reach ground from hovering state	
	}

	@Override
	public void reachedMaxHeight() {
		// Impossible to reach max height from hovering state	
	}

	@Override
	public void hoverPressed() {
		// Already hovering.
		
	}

}