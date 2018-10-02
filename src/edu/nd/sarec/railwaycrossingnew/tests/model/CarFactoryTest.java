package edu.nd.sarec.railwaycrossingnew.tests.model;

import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.nd.sarec.railwaycrossingnew.model.infrastructure.Direction;
import edu.nd.sarec.railwaycrossingnew.model.infrastructure.Road;
import edu.nd.sarec.railwaycrossingnew.model.vehicles.Car;
import edu.nd.sarec.railwaycrossingnew.model.vehicles.CarFactory;

class CarFactoryTest {
	
	CarFactory carFactory;
	Road road;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {	
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
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
			int leadCarPosition = 5000; // set to high numbers
			for (Car car: cars) {
				assertTrue("Car overtook its leader",car.getCarPosition().getY() < (leadCarPosition));
				leadCarPosition = (int)car.getCarPosition().getY();
			}
		}
		assert(true);
	}

}
