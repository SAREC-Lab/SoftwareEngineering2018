package edu.nd.sarec.railwaycrossing.view;

import java.util.Collection;

import edu.nd.sarec.railwaycrossing.model.infrastructure.RailwayTracks;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;


/** 
 * Draws a track
 * @author jane
 *
 */
public class TracksDisplay implements IDisplay {
	Pane root;
	Collection<RailwayTracks> tracks;
	int trackSize = 16;
	
	public TracksDisplay(Collection<RailwayTracks> tracks, Pane root){
		this.root = root;
		this.tracks = tracks;
	}
	
	@Override
	public void draw() {
		for(RailwayTracks track: tracks){
			root.getChildren().add(new Line(track.getStartX(),track.getStartY()-trackSize,track.getEndX(),track.getEndY()-trackSize));
			root.getChildren().add(new Line(track.getStartX(),track.getStartY()+trackSize,track.getEndX(),track.getEndY()+trackSize));
			for(int j = track.getStartX()+(trackSize/2); j < track.getEndX(); j+=trackSize){
				root.getChildren().add(new Line(j,track.getStartY()-trackSize - 2,j,track.getEndY()+trackSize+2));
			}
		}
	}
}
