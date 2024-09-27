package edu.nd.se2018.homework.hwk4.model.vehicles;

import javafx.scene.Node;


public interface IVehicle {
	public Node getImageView();
	public double getVehicleX();
	public double getVehicleY();
	public void move();
	public boolean offScreen();
	public void reset();
}
