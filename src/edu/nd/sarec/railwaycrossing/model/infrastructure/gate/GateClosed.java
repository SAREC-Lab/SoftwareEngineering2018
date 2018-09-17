package edu.nd.sarec.railwaycrossing.model.infrastructure.gate;

/**
 * Gate in CLOSED state
 * @author jane
 *
 */
public class GateClosed implements IGateState {
	
	private CrossingGate gate;
	
	protected GateClosed(CrossingGate gate){
		this.gate = gate;
	}

	@Override
	public void approachStation() {
		// Do nothing.  Gate is already closed.
		// IF there were two tracks we would have to keep track of how many trains were in the station!	
	}

	@Override
	public void leaveStation() {
		gate.setGateState(gate.getGateOpeningState());		
	}

	@Override
	public void gateFinishedOpening() {
		// not applicable		
	}

	@Override
	public void gateFinishedClosing() {
		// not applicable.  Gate is already closed.	
	}

	@Override
	public void operate() {
		// Flash lights
		
	}

	@Override
	public String getTrafficAction() {
		return "STOP";
	}
	
	
}
