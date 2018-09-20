package edu.nd.se2018.examples.mvc.dronetakeoff.view;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.examples.mvc.dronetakeoff.controller.Drone;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DroneUI extends Application implements Observer{

	Stage mainStage;
	Scene mainScene;
	Drone xCopter;
	Text infoMessage;
	final int GROUNDLEVEL = 420;
	ImageView droneImageView;
	Image droneImage;
	
	private void setDroneImage(Drone drone){
		Image droneImage = new Image("images\\drone4.png",100,100,true,true);	
		droneImageView = new ImageView(droneImage);
		droneImageView.setX(drone.getCoordinates().x);
		droneImageView.setY(drone.getCoordinates().y);	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {				
		AnchorPane root = new AnchorPane();
		mainScene = new Scene(root,450,600);
		mainStage = new Stage();
		mainStage.setTitle("Take off demo");
		mainStage.setScene(mainScene);
		mainStage.show();	
		
		infoMessage = new Text();
		infoMessage.setX(25);
		infoMessage.setY(GROUNDLEVEL+140);
		infoMessage.setFont(new Font("Times New Roman", 20));
		root.getChildren().add(infoMessage);
		
		xCopter = new Drone(180,GROUNDLEVEL-50,50, infoMessage, GROUNDLEVEL);
		xCopter.addObserver(this);
		setDroneImage(xCopter);
		root.getChildren().add(droneImageView);
		
		Button takeoffButton = createButton(root,"Take off", 50, GROUNDLEVEL+50);
		takeoffButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				xCopter.takeOff();
		}});
		
		Button hoverButton = createButton(root,"Hover", 200, GROUNDLEVEL+50);
		hoverButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				xCopter.hover();
		}});
		
		Button landButton = createButton(root,"Land", 350, GROUNDLEVEL+50);
		landButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				xCopter.land();
		}});
		
		// Starts the animation
		new AnimationTimer(){
			@Override
			public void handle(long now) {
				runSimulation();
			}
		}.start();
	}
	
	public void setMessage(String msg){
		infoMessage.setText(msg);
	}
	
	private void runSimulation(){
		if (xCopter.isAscending()){//currentState instanceof Ascending){
			xCopter.ascend();
		}
		if (xCopter.isLanding()){
			xCopter.descend();
		}
		try {
			Thread.sleep(25);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Helper function for creating buttons
	 * @param pane Button gets added to the pane
	 * @param buttonName
	 * @param x
	 * @param y
	 * @return
	 */
	private Button createButton(AnchorPane pane, String buttonName,int x, int y){
		Button button = new Button();
		button.setLayoutX(x);
		button.setLayoutY(y);
		button.setText(buttonName);
		button.setFont(new Font("Times New Roman",20));
		pane.getChildren().add(button);		
		return button;		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Drone){
			Drone drone = (Drone)o;
			droneImageView.setY(drone.getCoordinates().y);
		}	
		
	}
}

