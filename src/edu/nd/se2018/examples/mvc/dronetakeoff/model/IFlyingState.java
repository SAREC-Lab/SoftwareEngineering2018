package edu.nd.se2018.examples.mvc.dronetakeoff.model;

public interface IFlyingState {
	public void takeoffPressed();
	public void landPressed();
	public void reachedGround();
	public void reachedMaxHeight();
	public void hoverPressed();
}
