package edu.nd.se2018.examples.observer.catmouse;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Example of a class that implements the Observer
 * @author Jane
 *
 */
public class Cat implements Observer{
	Point mousePosition;
	Point catPosition;
	Random rand = new Random();
	ImageView catImageView;
	Image catImage;
	
	// Constructor
	public Cat(){
		catPosition = new Point(rand.nextInt(800), rand.nextInt(800));
		catImage = new Image("images\\Cat.png",50,50,true,true);	
		catImageView = new ImageView(catImage);		
	}
	
	public ImageView getImageView(){
		return catImageView;
	}
	
	// Moves the cat
	// Because the cat is an observer of the mouse -- it's "mousePosition" variable is kept updated.
	// So whenever we tell the cat to move we can assume that it knows the current position of the mouse.
	public void moveCat() {
		if (catPosition.x - mousePosition.x < 0)
			catPosition.x++;
		else
			catPosition.x--;
		
		if (catPosition.y - mousePosition.y < 0)
			catPosition.y++;
		else
			catPosition.y--;
		
		catImageView.setX(catPosition.x);
		catImageView.setY(catPosition.y);	
		
		// Retained for debugging.
		// System.out.println("Cat: " + catPosition.x + " " + catPosition.y);
	}

	// If the cat is registered as an observer of the mouse it will get the position.
	// Note the downcasting that occurs + the necessity of checking whether s is an instanceof Mouse!
	@Override
	public void update(Observable s, Object arg1) {
		if (s instanceof Mouse){
			mousePosition = ((Mouse)s).getPosition();
			moveCat();			
		}		
		
	}
}
