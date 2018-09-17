package edu.nd.sarec.railwaycrossing.model.infrastructure.gate;

/**
 * Gate in closing state
 * @author jane
 *
 */
public class GateClosing implements IGateState{

	private CrossingGate gate;
	
	protected GateClosing(CrossingGate gate){
		this.gate = gate;
	}

	@Override
	public void approachStation() {
		// Gate is already closing	
	}

	@Override
	public void leaveStation() {
		// This was an unwanted event.  The gate wasn't fully closed when the train was in the station.
		// Nevertheless we will open the gate.
		gate.setGateState(gate.getGateOpeningState());	
	}

	@Override
	public void gateFinishedOpening() {
		// n/a	
	}

	@Override
	public void gateFinishedClosing() {
		gate.setGateState(gate.getGateClosedState());		
	}

	@Override
	public void operate() {
		gate.close();
		// flash lights
	}
	
	@Override
	public String getTrafficAction() {
		return "STOP";
	}
	

}
