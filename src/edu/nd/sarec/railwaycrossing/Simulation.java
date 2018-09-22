package edu.nd.sarec.railwaycrossing;

import java.util.ArrayList;
import java.util.Collection;

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
		//int test = track1.getStartX();
		//String str = Integer.toString(test)test;
		//System.out.print(str);
//		OppositeTrain train1 = new OppositeTrain(track1.getStartX()-100,track1.getStartY()-25);
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
		for(Road road: roads){
			if (road.getCarFactory() != null){
				if ((int)(Math.random() * 150) == 15){
					Car car = road.getCarFactory().buildCar();
					if (car != null){
						root.getChildren().add(car.getImageView());
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		launch(args);
	}
}

