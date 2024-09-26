package edu.nd.sarec.railwaycrossing.model.vehicles;

import javafx.scene.Node;


public interface IVehicle {
	public Node getImageView();
	public double getVehicleX();
	public double getVehicleY();
	public void moveWest();
	public void moveEast();
	public void moveSouth();
	public boolean offScreen();
	public void reset();
}
