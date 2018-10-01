package edu.nd.sarec.railwaycrossingnew.model.vehicles;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import edu.nd.sarec.railwaycrossingnew.model.infrastructure.Direction;
import edu.nd.sarec.railwaycrossingnew.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossingnew.view.CarView;


/**
 * Very basic car factory.  Creates the car and registers it with the crossing gate and the car infront of it.
 * @author jane
 *
 */
public class CarFactory {
	
	private Collection<CrossingGate> gates = null;
	private Car previousCar = null;
	private ArrayList<Car> cars = new ArrayList<Car>();
	private Direction direction;
	private Point location;
	private int carNumber;
	private String factoryName;
	
	public CarFactory(){}
	
	public CarFactory(Direction direction, Point location, Collection<CrossingGate> gates, String factoryName, boolean gui){
		this.direction = direction;
		this.location = location;
		this.gates = gates;
		carNumber = 1;
		this.factoryName = factoryName;
	}
	
	// Most code here is to create random speeds
	public Car buildCar(boolean gui){
		if (previousCar == null || location.y < previousCar.getVehicleY()-100){
			String newLicense = factoryName + ":" + Integer.toString(carNumber);
			Car car = new Car(location.x,location.y,newLicense);
			if (gui) {
				CarView carView = new CarView(car); 
				car.attachCarView(carView);
			}
			carNumber++;
			
			double speedVariable = (Math.random() * 10)/10;
			car.setSpeed((2-speedVariable)*2); 
			
			// All cars created by this factory must be aware of crossing gates in the road
			for(CrossingGate gate: gates){
				gate.addObserver(car);
				if(gate != null && gate.getTrafficCommand()=="STOP")
					car.setGateDownFlag(true);
			}
			
			// Each car must observe the car infront of it so it doesn't collide with it.
			if (previousCar != null)
				previousCar.addObserver(car);
			previousCar = car;
			
			cars.add(car);
			return car;
		} else 
			return null;
	}

	// We will get a concurrency error if we try to delete cars whilst iterating through the array list
	// so we perform this in two stages.
	// 1.  Loop through the list and identify which cars are off the screen.  Add them to 'toDelete' array.
	// 2.  Iterate through toDelete and remove the cars from the original arrayList.
	public ArrayList<Car> driveCars() {
		// Removing cars from the array list.
		ArrayList<Car> toDelete = new ArrayList<Car>();
		for(Car car: cars){
			car.move();					
			if (car.offScreen())
				toDelete.add(car);
			
		}   
		for (Car car: toDelete)
			cars.remove(car);
		return toDelete;
	}
	
	public ArrayList<Car> getCars(){
		return cars;
	}
}
