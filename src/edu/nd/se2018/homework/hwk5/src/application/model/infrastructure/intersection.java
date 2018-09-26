package application.model.infrastructure;

import java.util.ArrayList;
import java.util.Collection;
import application.model.infrastructure.Road;
import application.model.vehicles.Car;
import application.model.infrastructure.MapBuilder;


public class intersection {
	private ArrayList<Car> cars = new ArrayList<Car>();
	private Collection<Road> roads;
	
	
	
	public intersection(Collection<Road> roads1) {
		roads = roads1;
	}




	public boolean intersectionCheck(Collection<Road> roads) {
		
		for(Road road:roads) {
			cars = road.getCarFactory().getCars();
			for(Car car:cars) {
				if(car.getVehicleX() < 500 && (car.getVehicleY() > 600 && car.getVehicleY() < 800)) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}

}
