package edu.nd.sarec.railwaycrossing.view;

import java.util.ArrayList;
import java.util.Collection;

import edu.nd.sarec.railwaycrossing.model.infrastructure.RailwayTracks;
import edu.nd.sarec.railwaycrossing.model.infrastructure.Road;
import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.model.vehicles.Car;
import javafx.scene.layout.Pane;

/**
 * Called by JavaFX main UI thread to help display elements on the UI
 * @author jane
 *
 */
public class MapDisplay {
	Pane root;
	IDisplay roadDisplay, tracksDisplay;
	Collection<Road> roads;
	Collection<RailwayTracks> track;
	Collection<CrossingGate> gates;
	
	
	public MapDisplay(Pane root, Collection<Road> roads, Collection<RailwayTracks> tracks, Collection<CrossingGate> gates){
		this.root = root;
		this.roads= roads;
		this.track = tracks;
		this.gates = gates;
		roadDisplay = new RoadDisplay(roads,root);
		tracksDisplay = new TracksDisplay(tracks,root);
	}

	public void drawTracks(){
		tracksDisplay.draw();
	}
	
	public void drawRoad(){
		roadDisplay.draw();
	}
	
	public void drawGate(){
		for (CrossingGate gate: gates)
			root.getChildren().add(gate.getGateLine());  
	}
	

	public void removeCarImages(ArrayList<Car> junkCars) {
		for(Car car: junkCars)
			root.getChildren().remove(car.getImageView());
		
	}
}
