package edu.nd.se2018.examples.observer.catmouse;

import java.util.LinkedList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * JavaFX application.
 * Note that you will only be able to run this if you've installed JavaFX!!
 * @author Jane
 *
 */
public class CatAndMouseGameFX extends Application{
	
	List<Cat> cats;
	Mouse mouse;
	
	public CatAndMouseGameFX(){
		
		cats = new LinkedList<Cat>();
	
		mouse = new Mouse();
		
		int catCount = 3;
		
		// Create cats
		for(int j = 0; j < catCount; j++)
			cats.add(new Cat());
		
		// Register cats as observers of the mouse.
		// You won't find the addObserver in the mouse class if you look for it, BECAUSE it is in the 
		// superclass OBSERVABLE.
		for(Cat cat: cats)
			mouse.addObserver(cat);
		
	}
	
	public static void main(String[] args) {
		new CatAndMouseGameFX();
		launch(args);  // This is how we startup JavaFX applications!  It calls the "start" method.
	}

	@Override
	public void start(Stage stage) throws Exception {
		final Pane root = new AnchorPane();
		Scene scene = new Scene(root,800,800); 
		
		stage.setScene(scene);
		stage.show();
		
		root.getChildren().add(mouse.getImageView());
		for(Cat cat: cats)
			root.getChildren().add(cat.getImageView());
		
		new AnimationTimer() { 
            @Override
            public void handle(long now) {
            	try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}           	
            	mouse.mouseMove();            
            }
        }.start();
   	}

}
