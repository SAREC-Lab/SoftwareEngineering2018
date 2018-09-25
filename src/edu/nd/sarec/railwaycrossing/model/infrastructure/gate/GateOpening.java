package edu.nd.sarec.railwaycrossing.model.infrastructure.gate;

/**
 * Gate in opening state
 * @author jane
 *
 */
public class GateOpening implements IGateState{
	
	CrossingGate gate;
	
	protected GateOpening(CrossingGate gate){
		this.gate = gate;
	}

	@Override
	public void approachStation() {
		gate.setGateState(gate.getGateClosingState());		
	}

	@Override
	public void leaveStation() {
		// Already opening.		
	}

	@Override
	public void gateFinishedOpening() {
		gate.setGateState(gate.getGateOpenState());
	}

	@Override
	public void gateFinishedClosing() {
	    // not reachable except through error.
		// Raise an alarm!!
	}

	@Override
	public void operate() {
		gate.open();
		// Flash lights..	
	}
	
	@Override
	public String getTrafficAction() {
		return "STOP";
	}
	
}
