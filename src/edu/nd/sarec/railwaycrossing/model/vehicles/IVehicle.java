package edu.nd.sarec.railwaycrossing.model.vehicles;

import javafx.scene.Node;


public interface IVehicle {
	public Node getImageView();
	public double getVehicleX();
	public double getVehicleY();
	public void move();
	public boolean offScreen();
	public void reset();
}
