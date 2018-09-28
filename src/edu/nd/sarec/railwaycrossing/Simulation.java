package edu.nd.sarec.railwaycrossing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Vector;

import edu.nd.sarec.railwaycrossing.model.infrastructure.MapBuilder;
import edu.nd.sarec.railwaycrossing.model.infrastructure.RailwayTracks;
import edu.nd.sarec.railwaycrossing.model.infrastructure.Road;
import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.model.vehicles.Car;
import edu.nd.sarec.railwaycrossing.model.vehicles.OppositeTrain;
import edu.nd.sarec.railwaycrossing.model.vehicles.Train;
import edu.nd.sarec.railwaycrossing.model.vehicles.TrainFactory;
import edu.nd.sarec.railwaycrossing.view.MapDisplay;
import edu.nd.sarec.railwaycrossing.model.infrastructure.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Simulation extends Application{
	
	private Pane root;
	private Scene scene;
	private MapBuilder mapBuilder;
	private MapDisplay mapDisplay;
	
	@Override  
	public void start(Stage stage) throws Exception {
		
		root = new Pane();
		
		// Build infrastructure
		mapBuilder = new MapBuilder();
		mapDisplay = new MapDisplay(root, mapBuilder.getRoads(), mapBuilder.getTracks(),mapBuilder.getAllGates());					
		mapDisplay.drawTracks();		
		mapDisplay.drawRoad();
		mapDisplay.drawGate();
		
		scene = new Scene(root,1200,1000);
		stage.setTitle("Railways");
		stage.setScene(scene);
		stage.show();
				
		// Train
		RailwayTracks track = mapBuilder.getTrack("Royal");
		RailwayTracks track1 = mapBuilder.getTrack("Layor");
		Train train = new Train(track.getEndX()+100,track.getEndY()-25, Direction.WEST);
		Train train1 = new Train(track1.getStartX()-100,track1.getStartY()-25, Direction.EAST);
		root.getChildren().add(train.getImageView());
		root.getChildren().add(train1.getImageView());
		
		// Train Factory
		TrainFactory trainFactory = new TrainFactory();
		trainFactory.addTrain(train);
		trainFactory.addTrain(train1);
		
		for(CrossingGate gate: mapBuilder.getAllGates()) {
			trainFactory.addObserver(gate);
		}
				
		// Sets up a repetitive loop i.e., in handle that runs the actual simulation
		new AnimationTimer(){

			@Override
			public void handle(long now) {
			
				createCar();
				trainFactory.move();
				
				for(CrossingGate gate: mapBuilder.getAllGates())
					gate.operateGate();
				
				Collection<Train> trains = trainFactory.getTrainFactory();
				for (Train train : trains) {
					if (train.offScreen()) {
						train.reset();
					}
				}
						
				clearCars();
				clearIntersections("tJunction");
			}
		}.start();
	}
	
	// Clears cars as they leave the simulation
	private void clearCars(){
		Collection<Road> roads = mapBuilder.getRoads();
		for(Road road: roads){			
			if (road.getCarFactory()!= null){
				ArrayList<Car> junkCars = road.getCarFactory().removeOffScreenCars();	
				mapDisplay.removeCarImages(junkCars);
			}
		}
	}
	
	private void createCar(){
		Collection<Road> roads = mapBuilder.getRoads();
		TJunction tJunction = mapBuilder.getTJunction("tJunction");
		for(Road road: roads){
			if (road.getCarFactory() != null){
				if ((int)(Math.random() * 250) == 15){
					Car car = road.getCarFactory().buildCar();
					if (car != null){
						// Add car to the correct TJunction list
						if (road.getName() == "Western Highway") {
							tJunction.getSubRoadList("NE").add(car);
						} else if (road.getName() == "Skyway") {
							tJunction.getSubRoadList("NW").add(car);
						}
						root.getChildren().add(car.getImageView());
					}
				}
			}
		}
	}
	
	private void clearIntersections(String name) {
		TJunction tJunction = mapBuilder.getTJunction(name);
		HashMap<String, Collection<Car>> roadDivides = tJunction.getSubRoadLists();
		Vector<Car> NE = (Vector<Car>)roadDivides.get("NE");
		Vector<Car> SE = (Vector<Car>)roadDivides.get("SE");
		Vector<Car> EW = (Vector<Car>)roadDivides.get("EW");
		Vector<Car> NW = (Vector<Car>)roadDivides.get("NW");
		Vector<Car> SW = (Vector<Car>)roadDivides.get("SW");
		
		Car car = null;
		Car car1 = null;
		Car car2 = null;
		Car car3 = null;
		Car car4 = null;
		Car car5 = null;
		
		// print to check if Junction itself was populating
//		if(ew.size() > 0) {
//			for (Car ewCar : ew) {
//				System.out.println(ewCar);
//			}
//			System.out.println(ew.size());
//		}
		
		// if NE road has cars, 
		if (NE.size() > 0) {
			car = NE.get(0);
			// turn left "right from car's persp." condition
			if (car.getVehicleY() > 632 && car.getVehicleY() < 668 && car.isWestBound()) {
				NE.remove(0);
				car.deleteObservers();

				if (EW.size() > 0) {
					car2 = EW.get(EW.size()-1);
					car2.addObserver(car);
				} else {
					car.removeLeadCarX();
				}
				
				EW.add(car);
				
				if (SE.size() > 0) {
					car1 = SE.get(SE.size()-1);
					car1.deleteObservers(); 
					if (NE.size() > 0) {
						Car newCar = NE.get(0);
						car1.addObserver(newCar);
					}
					else if(NE.size() == 0) {
						car1.removeLeadCarX();	
					}
				} else if (NE.size() > 0) {
					Car newCar = NE.get(0);
					newCar.removeLeadCarY();
				}
				
			} else if (car.getVehicleY() > 632 && !car.isWestBound()) {
				NE.remove(0);
				SE.add(car);
			}
		}
		
		// junction acting has connector from east to west road
		if (EW.size() > 0) { 
			car4 = EW.get(0);
			if (car4.getVehicleX() > 370 && car4.getVehicleX() < 390) {
				EW.remove(0);
				car4.deleteObservers();
				
				// remove car in junction with Y observer
				if (EW.size() > 0) { 
					Car newCar = EW.get(0);
					newCar.removeLeadCarY();
				}
				
				// if SW road has cars, delete it's NW cars' observers
				if (SW.size() > 0) {
					car3 = SW.get(SW.size()-1);
					car3.deleteObservers();
					car3.addObserver(car4);
				}
				SW.add(car4);
	
				// if NW road has cars, add observer to first car in SW road.
				if (NW.size() > 0) {
					car5 = NW.get(0);
					car4.addObserver(car5);
				}
							
			}
		}
		
		// transition from NW to SW subroads.
		if (NW.size() > 0) {
			car5 = NW.get(0);
			if (car5.getVehicleY() > 632 ) {
				NW.remove(0);
				SW.add(car5);
			}
		}
		
		// replace reset 
		ArrayList<Car> carsReset = new ArrayList<Car>();
		for(Car c: SE){					
			if (c.offScreen())
				carsReset.add(c);
		}   
		
		for (Car c: carsReset)
			SE.remove(c);
		
		carsReset.clear();
		
		for(Car c: SW){					
			if (c.offScreen())
				carsReset.add(c);
		}   
		
		for (Car c: carsReset)
			SW.remove(c);
		
		carsReset.clear();
	}
	
	public static void main(String[] args){
		launch(args);
	}
}

