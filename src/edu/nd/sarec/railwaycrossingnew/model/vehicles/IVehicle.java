package edu.nd.sarec.railwaycrossingnew.model.vehicles;

import javafx.scene.Node;


public interface IVehicle {
	public double getVehicleX();
	public double getVehicleY();
	public void move();
	public boolean offScreen();
	public void reset();
}
