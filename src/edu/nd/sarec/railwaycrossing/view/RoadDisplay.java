package edu.nd.sarec.railwaycrossing.view;

import java.util.Collection;

import edu.nd.sarec.railwaycrossing.model.infrastructure.Direction;
import edu.nd.sarec.railwaycrossing.model.infrastructure.Road;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


/**
 * Draws a road
 * @author jane
 *
 */
public class RoadDisplay implements IDisplay {
	Pane root;
	Collection<Road> roads;
	int roadSize;

	
	public RoadDisplay(Collection<Road> roads, Pane root){
		this.root = root;
		this.roads = roads;

	}
	
	@Override
	public void draw() {
		for(Road road: roads){
			roadSize = road.getRoadWidth();
			if (road.getDirection() == Direction.NORTH || road.getDirection() == Direction.SOUTH) {
				root.getChildren().add(new Line(road.getStartX()-roadSize,road.getStartY(),road.getEndX()-roadSize,road.getEndY()));
				root.getChildren().add(new Line(road.getStartX()+roadSize,road.getStartY(),road.getEndX()+roadSize,road.getEndY()));
			} else {
				root.getChildren().add(new Line(road.getStartX(),road.getStartY()-roadSize,road.getEndX(),road.getEndY()-roadSize));
				root.getChildren().add(new Line(road.getStartX(),road.getStartY()+roadSize,road.getEndX(),road.getEndY()+roadSize));
				if (road.getClearEnds()){
					Line line = new Line(road.getStartX(),road.getStartY()-roadSize,road.getStartX(),road.getStartY()+roadSize);
					line.setStroke(Color.WHITE);
				    root.getChildren().add(line);
				    Line line2 = new Line(road.getEndX(),road.getEndY()-roadSize,road.getEndX(),road.getEndY()+roadSize);
					line2.setStroke(Color.WHITE);
				    root.getChildren().add(line2);
				}				
			}
		}
	}
}

