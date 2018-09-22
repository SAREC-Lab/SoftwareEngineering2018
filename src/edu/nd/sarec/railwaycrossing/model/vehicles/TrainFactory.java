package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Collection;
import java.util.Observable;
import java.util.Vector;

import javafx.scene.image.ImageView;


public class TrainFactory extends Observable {

	Collection<Train> trains;

	public TrainFactory() {
		this.trains = new Vector<Train>();
	}
	
	public void addTrain(Train train) {
		
		trains.add(train);
	}
	
	public void move() {
		for (Train train: trains) {

			train.move();
			ImageView view = (ImageView) train.getImageView();
			view.setX(train.getVehicleX());

		}
		
		setChanged();
		notifyObservers();
	}
	
	public Collection<Train> getTrainFactory() {
		return trains;
	}
	
}