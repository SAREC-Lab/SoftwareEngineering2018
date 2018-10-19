package edu.nd.se2018.homework.chipsChallenge;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.ImageView;

public class BugFactory {
	
	ArrayList<Bug> bugs;
	
	public BugFactory(){
		bugs = new ArrayList<>();
	}
	
	public void addStraightLineBug(int x, int y, boolean horizontal, Level level){
		BugMovement movementStrategy = new StraightLineBugMovement(horizontal);
		Bug b = new Bug(x, y, movementStrategy, level);
		level.addObserver(b);
		bugs.add(b);
	}
	
	public void moveBugs(){
		for(Bug b : bugs)
			b.move();
	}
	
	public ImageView[] getBugImageViews(){
		ImageView[] views = new ImageView[bugs.size()];
		for(int i=0; i<bugs.size(); i++){
			views[i] = bugs.get(i).getImageView();
		}
		return views;
	}
	
	public void setBugsToObserve(Observable o){
		for(Bug b : bugs)
			o.addObserver(b);
	}
	
	public void observeBugs(Observer o){
		for(Bug b : bugs)
			b.addObserver(o);
	}
}
