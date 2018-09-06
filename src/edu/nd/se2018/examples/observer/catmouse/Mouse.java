package edu.nd.se2018.examples.observer.catmouse;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Example of a class that extends the Observable superclass
 * @author Jane
 *
 */
public class Mouse extends Observable {
	List<Observer> observers = new LinkedList<Observer>();
	Point mousePosition = new Point(400,500);  	// Actual position of the mouse
	Point targetPosition;  						// Coordinates that the mouse is currently heading towards
	Random rand;								// Introduces randomness into the "game"
	ImageView mouseImageView;					// In JavaFX a mouse image is managed by a mouseImageView
	Image mouseImage;
	
	// Constructor
	public Mouse(){
		targetPosition = new Point(0,0);
		rand = new Random();
		mouseImage = new Image("images\\Mouse.png",50,50,true,true);	
		mouseImageView = new ImageView(mouseImage);		
	}
	
	// Updates the position that the mouse is heading towards
	private void setTargetPosition(){
		targetPosition.x = rand.nextInt(800);
		targetPosition.y = rand.nextInt(800);
	}
	
	// Sets a new mouse position
	private void setMousePosition(){
		mousePosition.x = rand.nextInt(800);
		mousePosition.y = rand.nextInt(800);
		mouseImageView.setX(mousePosition.x);
		mouseImageView.setY(mousePosition.y);	
	}
	
	
	// Returns mouse position
	public Point getPosition(){
		return mousePosition;
	}
	
		
	// Returns image view (i.e., the wrapper for the image)
	public ImageView getImageView(){
		return mouseImageView;
	}
	
	// Move the mouse towards its target.
	public void mouseMove(){
		while (Math.abs(mousePosition.x-targetPosition.x) + 
				Math.abs(mousePosition.y-targetPosition.y) < 20){
			setTargetPosition();
			setMousePosition();
		}
		
		if (mousePosition.x - targetPosition.x < 0)
			mousePosition.x++;
		else
			mousePosition.x--;
		
		if (mousePosition.y - targetPosition.y < 0)
			mousePosition.y++;
		else
			mousePosition.y--;
		
		mouseImageView.setX(mousePosition.x);
		mouseImageView.setY(mousePosition.y);	
		
		// Used for debugging!
		// System.out.println("Mouse: " + mousePosition.x + " " + mousePosition.y);
		
		setChanged();		// The observable object has moved.  To include recent changes you *MUST* have this line
		notifyObservers();  // Now notify observers.
		
	}
}
