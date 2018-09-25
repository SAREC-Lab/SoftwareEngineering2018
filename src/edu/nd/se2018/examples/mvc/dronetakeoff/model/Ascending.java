package edu.nd.se2018.examples.mvc.dronetakeoff.model;

public class Ascending implements IFlyingState{
	
	DroneState droneState;
	
	public Ascending (DroneState droneState){
		this.droneState = droneState;
	}

	@Override
	public void takeoffPressed() {
		// Do nothing. Already ascending	
		droneState.setInfoMessage("No change in state.  Already taking off");
	}

	@Override
	public void landPressed() {
		droneState.setFlyingState(droneState.getLandingState());	
		droneState.setInfoMessage("Landing");
	}

	@Override
	public void reachedGround() {
		// Cannot reach ground from ascending mode.
	}

	@Override
	public void reachedMaxHeight() {
		droneState.setFlyingState(droneState.getHoveringState());		
		droneState.setInfoMessage("Reached Max height. Hovering.");
	}

	@Override
	public void hoverPressed() {
		droneState.setFlyingState(droneState.getHoveringState());
		droneState.setInfoMessage("Hovering in place");
		
	}

}
