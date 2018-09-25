package edu.nd.sarec.railwaycrossing.model.infrastructure.gate;

/**
 * Gate in open state
 * @author jane
 *
 */
public class GateOpen implements IGateState {

	private CrossingGate gate;
	
	protected GateOpen(CrossingGate gate){
		this.gate = gate;
	}

	@Override
	public void approachStation() {
		gate.setGateState(gate.getGateClosingState());		
	}

	@Override
	public void leaveStation() {
		// n/a gate already open		
	}

	@Override
	public void gateFinishedOpening() {
		// n/a gate already open		
	}

	@Override
	public void gateFinishedClosing() {
		// n/a can't be closing and opened.		
	}

	@Override
	public void operate() {
		// Normal operation.  Do nothing.	
	}
	
	@Override
	public String getTrafficAction() {
		return "GO";
	}
	
}
