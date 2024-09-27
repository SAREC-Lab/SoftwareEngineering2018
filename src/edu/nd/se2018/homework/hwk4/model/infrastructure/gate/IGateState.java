package edu.nd.se2018.homework.hwk4.model.infrastructure.gate;

/**
 * Declares all operations that GateState classes must implement
 *
 */
public interface IGateState {
	public void approachStation();
	public void leaveStation();
	public void gateFinishedOpening();
	public void gateFinishedClosing();
	public void operate();
	public String getTrafficAction();
}
