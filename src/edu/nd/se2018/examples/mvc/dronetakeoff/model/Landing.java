package edu.nd.se2018.examples.mvc.dronetakeoff.model;

public class Landing implements IFlyingState{
	DroneState droneState;
	
	public Landing (DroneState droneState){
		this.droneState = droneState;
	}

	@Override
	public void takeoffPressed() {  
		droneState.setInfoMessage("Cannot abort landing");
	}

	@Override
	public void landPressed() {
		droneState.setInfoMessage("Already landing");
	}

	@Override
	public void reachedGround() {
		droneState.setFlyingState(droneState.getGroundState());
		droneState.setInfoMessage("Landed on ground");		
	}

	@Override
	public void reachedMaxHeight() {
		// Impossible to reach max height from landing state	
	}
	
	@Override
	public void hoverPressed() {
		droneState.setFlyingState(droneState.getHoveringState());
		droneState.setInfoMessage("Hovering in place");		
	}
}
