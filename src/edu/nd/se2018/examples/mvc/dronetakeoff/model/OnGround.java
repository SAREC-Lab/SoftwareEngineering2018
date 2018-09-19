package edu.nd.se2018.examples.mvc.dronetakeoff.model;


public class OnGround implements IFlyingState{
	
	DroneState droneState;
	
	public OnGround (DroneState droneState){
		this.droneState = droneState;
	}

	@Override
	public void takeoffPressed() {  
		droneState.setInfoMessage("Taking off");
		droneState.setFlyingState(droneState.getAscendingState());
	}

	@Override
	public void landPressed() {
		// already on ground
	}

	@Override
	public void reachedGround() {
		// already on ground
	}

	@Override
	public void reachedMaxHeight() {
		// not moving yet	
	}

	@Override
	public void hoverPressed() {
		droneState.setInfoMessage("On ground.  Cannot hover!!");	
	}

}

