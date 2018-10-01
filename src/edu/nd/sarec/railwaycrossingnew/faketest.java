package edu.nd.sarec.railwaycrossingnew;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;

import edu.nd.sarec.railwaycrossingnew.model.infrastructure.Direction;
import edu.nd.sarec.railwaycrossingnew.model.infrastructure.Road;
import edu.nd.sarec.railwaycrossingnew.model.vehicles.Car;
import edu.nd.sarec.railwaycrossingnew.model.vehicles.CarFactory;

public class faketest {

	public static void main(String[] args) {
		Road road = new Road(new Point(800,0),new Point (800,1000),Direction.SOUTH,true,false);
		road.addCarFactory("TST",false);
		CarFactory carFactory = road.getCarFactory();

		for (int k = 0; k < 1000; k++) {
			//System.out.println("K = " + k);
			for(int j = 0; j < 10000; j++) {
				carFactory.buildCar(false);
				carFactory.driveCars();
			}
			ArrayList<Car> cars = carFactory.getCars();
			//System.out.println(k + ": Cars created: " + cars.size());
			int leadCarPosition = 5000; // set to high numbers
			for (Car car: cars) {
				assertTrue("Car overtook its leader",car.getCarPosition().getY() < (leadCarPosition));
				//if (car.getCarPosition().getY() > (y)) {
				//	fail("Car over took its leader");
				//	System.out.println("Checking car: " + car.getVehicleX());
				//}
				//System.out.println("Car: " + (int)car.getVehicleY() + " " + y);
				leadCarPosition = (int)car.getCarPosition().getY();
			}
		}
		assert(true);

	}

}
