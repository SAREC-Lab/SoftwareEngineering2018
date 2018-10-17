package edu.nd.sarec.railwaycrossingnew.view;

import java.util.Observable;
import java.util.Observer;

import edu.nd.sarec.railwaycrossingnew.model.vehicles.Car;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CarView implements Observer{
	private ImageView ivCar;
	private TextField txtCar;
	
	public CarView(Car car) {
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(car.getVehicleX());
		ivCar.setY(car.getVehicleY());
		txtCar = new TextField();
		txtCar.setText(car.getLicense());
		txtCar.setLayoutX(car.getVehicleX()+25);
		txtCar.setLayoutY(car.getVehicleY());
		txtCar.prefWidth(25);
	}
	
	public Node getImageView() {
		return ivCar;
	}
	
	public Node getLicenseView() {
		return txtCar;
	}

	// The car view now starts to observe the car model!
	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car) {
			ivCar.setY(((Car)o).getVehicleY());
			txtCar.setLayoutY(((Car)o).getVehicleY());
		}		
	}
}
